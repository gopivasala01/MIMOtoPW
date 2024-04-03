package mainPackage;


import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SampleText {
    // Connection URL for SQL Server
    private static final String CONNECTION_URL = "jdbc:sqlserver://azrsrv001.database.windows.net;databaseName=HomeRiverDB;user=service_sql02;password=xzqcoK7T;encrypt=true;trustServerCertificate=true;";

   

    public static void main(String[] args) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;

        try {
            // Establish connection to the database
            connection = DriverManager.getConnection(CONNECTION_URL);

            // Call the stored procedure
            callableStatement = connection.prepareCall("{call Automation.DifferenceInFilterValueInPW}");

            // Execute the stored procedure
            resultSet = callableStatement.executeQuery();
            String difference = null;
            // Process the result set
            while (resultSet.next()) {
                String reportID = resultSet.getString("ReportID");
                String reportAliasName = resultSet.getString("ReportAliasName");
                String companyName = resultSet.getString("CompanyName");
                String variable1Where = resultSet.getString("FilterValueInPW")
                        .replaceAll(System.lineSeparator(), " ")
                        .replaceAll("\\s+", " "); // Replace consecutive spaces with a single space

                String variable2Where = resultSet.getString("PreviousFilterValueInPW")
                        .replaceAll(System.lineSeparator(), " ")
                        .replaceAll("\\s+", " "); // Replace consecutive spaces with a single space

                // Find the differences between the two filter values
                difference = findDifference(variable1Where, variable2Where);

                // Output differences to console
                if (!difference.isEmpty()) {
                    System.out.println("ReportID: " + reportID);
                    System.out.println("ReportAliasName: " + reportAliasName);
                    System.out.println("CompanyName: " + companyName);
                    System.out.println("Difference in the Filter: ");
                    System.out.println(difference);
                    System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"); // Empty line between records
                }
               
            }
        	sendEmail(difference);
           
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close connections and resources
            try {
            
                if (resultSet != null) resultSet.close();
                if (callableStatement != null) callableStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static String findDifference(String variable1Where, String variable2Where) {
        // Split the filter values into individual filters
        String[] filters1 = variable1Where.split(",");
        String[] filters2 = variable2Where.split(",");

        // Convert array to list for easier manipulation
        List<String> list1 = Arrays.asList(filters1);

        // Find differences using Java 8 Streams
        List<String> differences = list1.stream()
                .filter(filter -> !Arrays.asList(filters2).contains(filter))
                .toList();

        // Construct a string containing the differing filters
        return String.join(", ", differences);
    }

    public static void sendEmail(String emailContent) {
        // Email configuration
        String smtpHost = "smtp.office365.com";
        String smtpPort = "587";
        String emailFrom = "santosh.p@beetlerim.com";
        String emailTo = "santosh.p@beetlerim.com,gopi.v@beetlerim.com";
        //String emailTo = "santosh.p@beetlerim.com , gopi.v@beetlerim.com , ratna@beetlerim.com , dahoffman@homeriver.com ";
        String emailSubject = "Different Value Detected";
        String emailBody = emailContent;

        // SMTP authentication information
        final String username = "santosh.p@beetlerim.com";
        final String password = "Welcome@123";

        // Set properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Create session
        Session session = null;
        try {
            session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            // Create message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailFrom));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
            message.setSubject(emailSubject);
            message.setText(emailBody);

            // Send message
            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (AuthenticationFailedException e) {
            System.out.println("Authentication failed. Please check your username and password.");
            e.printStackTrace();
        } catch (MessagingException e) {
            System.out.println("Failed to send email: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the session
            if (session != null) {
                try {
                    session.getTransport().close();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
