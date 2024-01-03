package mainPackage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class MailActivities {

    // Constants
	private static final String SHEET_NAME = "Sheet 1";
    private static final String[] HEADERS = {"ID", "Unit_Entity_ID", "Vacating_Resident_Lease_Entity_ID", "Status", "Address",
            "Current_Resident_First_Name", "Current_Resident_Last_Name", "Company_Name",
            "Last_Chance_Save_Renewal_Call_RC", "Utility_Connection_Request_RC", "Set_Construction_Lockbox_Code_To_TC",
            "Filter_Size_FI", "Possession_Confirmed_Date", "Turn_Over_Handled_By_TC",
            "Turn_Estimate_Submission_Date", "Turn_Estimated_Cost_TC", "Turn_Approval_Date_TC",
            "Turn_Start_Date_TC", "Turn_Estimated_Completion_Date_TC", "Turn_Actual_Completion_Date_TC",
            "Turn_Actual_Cost_TC", "Turn_QC_Scheduled_Date_TC", "Turn_QC_Completed_Date_FI",
            "Leasing_Lockbox_Serial_Number_FI", "Last_vacant_visit", "AutomationStatus",
            "AsOfDate", "Note"};



    public static void processAndSendEmail() {
        // Get current date for file naming
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String date = dateObj.format(formatter);

        // Create Excel workbook and sheet
        try (Workbook wb = new XSSFWorkbook()) {
            Sheet sheet1 = wb.createSheet(SHEET_NAME);

            // Create header row
            createHeaderRow(sheet1);

            // Retrieve data and populate rows
            boolean getBuildings = DataBase.getCompletedBuildingsList();
            if (getBuildings && RunnerClass.completedLeasesList != null) {
                populateDataRows(sheet1, RunnerClass.completedLeasesList);
            }

            // Write the workbook content to a file
            String filename = AppConfig.excelFileLocation + "\\MIMOtoPW_" + date + ".xlsx";
            try (FileOutputStream fileOut = new FileOutputStream(filename)) {
                wb.write(fileOut);
                System.out.println("Excel file created successfully at: " + filename);

                // Send email with attachment
                sendFileToMail(filename);

                // Delete the current file after sending the email
                File file = new File(filename);
                if (file.delete()) {
                    System.out.println("File deleted successfully.");
                } else {
                    System.out.println("Failed to delete the file.");
                }

            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception appropriately
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    private static void createHeaderRow(Sheet sheet) {
        Row header = sheet.createRow(0);
        for (int i = 0; i < HEADERS.length; i++) {
            header.createCell(i).setCellValue(HEADERS[i]);
        }
    }

    private static void populateDataRows(Sheet sheet, String[][] data) {
        for (int i = 0; i < data.length; i++) {
            Row row = sheet.createRow(1 + i);
            populateRowWithData(row, data[i]);
        }
    }

    private static void populateRowWithData(Row row, String[] rowData) {
        for (int i = 0; i < rowData.length; i++) {
            try {
                row.createCell(i).setCellValue(rowData[i]);
            } catch (Exception e) {
                rowData[i] = "";
                row.createCell(i).setCellValue(rowData[i]);
            }
        }
    }

    private static void sendFileToMail(String fileName) {
        String host = "smtpout.asia.secureserver.net";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "80");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(AppConfig.fromEmail, AppConfig.fromEmailPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(AppConfig.fromEmail));

            InternetAddress[] toAddresses = InternetAddress.parse(AppConfig.toEmail);
            message.setRecipients(Message.RecipientType.TO, toAddresses);

            InternetAddress[] ccAddresses = InternetAddress.parse(AppConfig.CCEmail);
            message.setRecipients(Message.RecipientType.CC, ccAddresses);

            String subject = AppConfig.mailSubject + CommonMethods.getCurrentDate();
            message.setSubject(subject);

            BodyPart messageBodyPart = new MimeBodyPart();
            String messageInBody = "Hi All,\n Please find the attachment.\n\n Regards,\n HomeRiver Group.";
            messageBodyPart.setText(messageInBody);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            messageBodyPart = new MimeBodyPart();
            messageBodyPart.setFileName(new File(fileName).getName());

            DataSource source = new FileDataSource(fileName);
            messageBodyPart.setDataHandler(new DataHandler(source));

            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            // Log the exception details
            e.printStackTrace();
            throw new RuntimeException("Error sending email", e);
        }
    }

    public static void sendEmptyEmail() {
       
                String subject = "No Data Available";
                String body = "Dear user,\nThe query returned no data. No buildings are available for pending leases.";

                sendEmail(subject, body);
            
        }

        

    private static void sendEmail(String subject, String body) {
        String host = "smtpout.asia.secureserver.net";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587"); // or "25" or "465"

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(AppConfig.fromEmail, AppConfig.fromEmailPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(AppConfig.fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(AppConfig.CCEmail));
            message.setSubject(subject);

            // Create the message body
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);

            // Create the multipart message
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // Attachments can be added here if needed
            // MimeBodyPart attachmentPart = new MimeBodyPart();
            // attachmentPart.attachFile((File) attachment);
            // multipart.addBodyPart(attachmentPart);

            // Set the message content
            message.setContent(multipart);

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    // Rest of your classes and methods
}

   
    	

 

