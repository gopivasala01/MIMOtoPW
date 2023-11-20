package mainPackage;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
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

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MailActivities 
{
	//Create Excel File with processed data
	public static void createExcelFileWithProcessedData() {
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String date = dateObj.format(formatter);
        System.out.println(date);
        String filename;
        try {
            filename = AppConfig.excelFileLocation + "\\MIMOtoPW_" + date + ".xlsx";
            File file = new File(filename);
            if (!file.exists())
                file.mkdirs();

            // If the file exists, delete and recreate it
            if (file.exists()) {
                file.delete();
            }

            Workbook wb = new XSSFWorkbook();
            Sheet sheet1 = wb.createSheet("Sheet 1");
            Row header = sheet1.createRow(0);

            String[] headers = { "ID", "Company", "Unit Entity ID", "Lease Entity ID", "Address",
                    "Current Resident First Name", "Current Resident Last Name", "Utility Connection Request",
                    "Lock Box Code", "Filter Other", "MOI Inspection Date", "Turn Over Handled By",
                    "Turn Estimate Submission Date", "Turn Estimate Cost", "Turn Approval Date", "Turn Start Date",
                    "Turn Target Completion Date", "Turn Actual Completion Date", "Turn Actual Cost",
                    "Turn QC Completed Date", "Code Box Active", "Last Vacant Visit" };

            for (int i = 0; i < headers.length; i++) {
                header.createCell(i).setCellValue(headers[i]);
            }

            boolean getBuildings = DataBase.getCompletedBuildingsList();

            if (getBuildings && RunnerClass.pendingLeases != null) {
                for (int i = 0; i < RunnerClass.pendingLeases.length; i++) {
                    String ID = RunnerClass.pendingLeases[i][0];
                    String company = RunnerClass.pendingLeases[i][2];
                    String unitEntityID = RunnerClass.pendingLeases[i][1];
                    String leaseEntityID = RunnerClass.pendingLeases[i][3];
                    String address = RunnerClass.pendingLeases[i][4];
                    String currentResidentFirstName = RunnerClass.pendingLeases[i][5];
                    String currentResidentLastName = RunnerClass.pendingLeases[i][6];
                    String utilityConnectionRequest = RunnerClass.pendingLeases[i][7];
                    String lockBoxCode = RunnerClass.pendingLeases[i][20];
                    String filterOther = RunnerClass.pendingLeases[i][9];
                    String MOIInspectionDate = RunnerClass.pendingLeases[i][10].trim();
                    String turnOverHandledBy = RunnerClass.pendingLeases[i][11];
                    String turnEstimateSubmissionDate = RunnerClass.pendingLeases[i][12].trim();
                    String turnEstimateCost = RunnerClass.pendingLeases[i][13];
                    String turnApprovalDate = RunnerClass.pendingLeases[i][14].trim();
                    String turnStartDate = RunnerClass.pendingLeases[i][15].trim();
                    String turnTargetCompletionDate = RunnerClass.pendingLeases[i][16].trim();
                    String turnActualCompletionDate = RunnerClass.pendingLeases[i][17].trim();
                    String turnActualCost = RunnerClass.pendingLeases[i][18];
                    String turnQCCompletedDate = RunnerClass.pendingLeases[i][19].trim();
                    String codeBoxActive = RunnerClass.pendingLeases[i][8];
                    String lastVacantVisit = RunnerClass.pendingLeases[i][21].trim();

                 // Inside the loop where rows are created
                    
                        // Previous code for extracting data from the array

                 // Inside the loop where rows are created
                    
                        // Previous code for extracting data from the array

                        Row row = sheet1.createRow(1 + i);

                        try {
                            row.createCell(0).setCellValue(ID);
                        } catch (Exception e) {
                            ID = "";
                            row.createCell(0).setCellValue(ID);
                        }

                        try {
                            row.createCell(1).setCellValue(company);
                        } catch (Exception e) {
                            company = "";
                            row.createCell(1).setCellValue(company);
                        }

                        try {
                            row.createCell(2).setCellValue(unitEntityID);
                        } catch (Exception e) {
                            unitEntityID = "";
                            row.createCell(2).setCellValue(unitEntityID);
                        }

                        try {
                            row.createCell(3).setCellValue(leaseEntityID);
                        } catch (Exception e) {
                            leaseEntityID = "";
                            row.createCell(3).setCellValue(leaseEntityID);
                        }

                        try {
                            row.createCell(4).setCellValue(address);
                        } catch (Exception e) {
                            address = "";
                            row.createCell(4).setCellValue(address);
                        }

                        try {
                            row.createCell(5).setCellValue(currentResidentFirstName);
                        } catch (Exception e) {
                            currentResidentFirstName = "";
                            row.createCell(5).setCellValue(currentResidentFirstName);
                        }

                        try {
                            row.createCell(6).setCellValue(currentResidentLastName);
                        } catch (Exception e) {
                            currentResidentLastName = "";
                            row.createCell(6).setCellValue(currentResidentLastName);
                        }

                        try {
                            row.createCell(7).setCellValue(utilityConnectionRequest);
                        } catch (Exception e) {
                            utilityConnectionRequest = "";
                            row.createCell(7).setCellValue(utilityConnectionRequest);
                        }

                        try {
                            row.createCell(8).setCellValue(lockBoxCode);
                        } catch (Exception e) {
                            lockBoxCode = "";
                            row.createCell(8).setCellValue(lockBoxCode);
                        }

                        try {
                            row.createCell(9).setCellValue(filterOther);
                        } catch (Exception e) {
                            filterOther = "";
                            row.createCell(9).setCellValue(filterOther);
                        }

                        try {
                            row.createCell(10).setCellValue(MOIInspectionDate);
                        } catch (Exception e) {
                            MOIInspectionDate = "";
                            row.createCell(10).setCellValue(MOIInspectionDate);
                        }

                        try {
                            row.createCell(11).setCellValue(turnOverHandledBy);
                        } catch (Exception e) {
                            turnOverHandledBy = "";
                            row.createCell(11).setCellValue(turnOverHandledBy);
                        }

                        try {
                            row.createCell(12).setCellValue(turnEstimateSubmissionDate);
                        } catch (Exception e) {
                            turnEstimateSubmissionDate = "";
                            row.createCell(12).setCellValue(turnEstimateSubmissionDate);
                        }

                        try {
                            row.createCell(13).setCellValue(turnEstimateCost);
                        } catch (Exception e) {
                            turnEstimateCost = "";
                            row.createCell(13).setCellValue(turnEstimateCost);
                        }

                        try {
                            row.createCell(14).setCellValue(turnApprovalDate);
                        } catch (Exception e) {
                            turnApprovalDate = "";
                            row.createCell(14).setCellValue(turnApprovalDate);
                        }

                        try {
                            row.createCell(15).setCellValue(turnStartDate);
                        } catch (Exception e) {
                            turnStartDate = "";
                            row.createCell(15).setCellValue(turnStartDate);
                        }

                        try {
                            row.createCell(16).setCellValue(turnTargetCompletionDate);
                        } catch (Exception e) {
                            turnTargetCompletionDate = "";
                            row.createCell(16).setCellValue(turnTargetCompletionDate);
                        }

                        try {
                            row.createCell(17).setCellValue(turnActualCompletionDate);
                        } catch (Exception e) {
                            turnActualCompletionDate = "";
                            row.createCell(17).setCellValue(turnActualCompletionDate);
                        }

                        try {
                            row.createCell(18).setCellValue(turnActualCost);
                        } catch (Exception e) {
                            turnActualCost = "";
                            row.createCell(18).setCellValue(turnActualCost);
                        }

                        try {
                            row.createCell(19).setCellValue(turnQCCompletedDate);
                        } catch (Exception e) {
                            turnQCCompletedDate = "";
                            row.createCell(19).setCellValue(turnQCCompletedDate);
                        }

                        try {
                            row.createCell(20).setCellValue(codeBoxActive);
                        } catch (Exception e) {
                            codeBoxActive = "";
                            row.createCell(20).setCellValue(codeBoxActive);
                        }

                        try {
                            row.createCell(21).setCellValue(lastVacantVisit);
                        } catch (Exception e) {
                            lastVacantVisit = "";
                            row.createCell(21).setCellValue(lastVacantVisit);
                        }
                    }
            }



            System.out.println("Last row in the sheet = " + sheet1.getLastRowNum());
            FileOutputStream fileOut = new FileOutputStream(filename);
            wb.write(fileOut);
            wb.close();
            fileOut.close();
            System.out.println("Excel file has been generated successfully.");
            MailActivities.sendFileToMail(filename);
         
            }catch (Exception e) {
            e.printStackTrace();
        }
    }
			
			public static void sendFileToMail(String fileName) 
			   {
			     
			      // Assuming you are sending email through relay.jangosmtp.net
			      String host = "smtpout.asia.secureserver.net";

			      Properties props = new Properties();
			      props.put("mail.smtp.auth", "true");
			      //props.put("mail.smtp.starttls.enable", "true");
			     props.put("mail.smtp.host", host);
			      props.put("mail.smtp.port", "80");

			      // Get the Session object.
			      Session session = Session.getInstance(props,
			         new javax.mail.Authenticator() {
			            protected PasswordAuthentication getPasswordAuthentication() {
			               return new PasswordAuthentication(AppConfig.fromEmail, AppConfig.fromEmailPassword);
			            }
			         });

			      try {
			         // Create a default MimeMessage object.
			         Message message = new MimeMessage(session);

			         // Set From: header field of the header.
			         message.setFrom(new InternetAddress(AppConfig.fromEmail));

			         InternetAddress[] toAddresses = InternetAddress.parse(AppConfig.toEmail);
			         // Set To: header field of the header.
			        message.setRecipients(Message.RecipientType.TO,
			        		toAddresses);

			        
			        InternetAddress[] CCAddresses = InternetAddress.parse(AppConfig.CCEmail);
			         // Set CC: header field of the header.
			         message.setRecipients(Message.RecipientType.CC,
			        		 CCAddresses);
			         
			         /*
			         // Set CC: header field of the header.
			         message.setRecipients(Message.RecipientType.BCC,
			            InternetAddress.parse("sujana.t@beetlerim.com"));
			         */
			         // Set Subject: header field
			        String subject = AppConfig.mailSubject+CommonMethods.getCurrentDate();
			        message.setSubject(subject);

			         // Create the message part
			         BodyPart messageBodyPart = new MimeBodyPart();

			         // Now set the actual message
			         String messageInBody = "Hi All,\n Please find the attachment.\n\n Regards,\n HomeRiver Group.";
			         messageBodyPart.setText(messageInBody);

			         // Create a multipar message
			         Multipart multipart = new MimeMultipart();

			         // Set text message part
			         multipart.addBodyPart(messageBodyPart);

			         // Part two is attachment
			         messageBodyPart = new MimeBodyPart();
			        // String filename = "C:\\PropertyWare\\externalFiles\\downloadFiles\\"+"Operations-Marketing.xlsx";
			         System.out.println("FileName sending in mail"+fileName);
			         messageBodyPart.setFileName(new File(fileName).getName());
			         DataSource source = new FileDataSource(fileName);
			         messageBodyPart.setDataHandler(new DataHandler(source));
			        // messageBodyPart.setFileName(filename);
			         messageBodyPart.setFileName(new File(fileName).getName());
			         multipart.addBodyPart(messageBodyPart);

			         // Send the complete message parts
			         message.setContent(multipart);

			         // Send message
			         Transport.send(message);

			         System.out.println("Sent message successfully....");
			  
			         //wait until file is downloaded
			         /*
			         File dir = new File("DownloadPath");
			         //String partialName = downloaded_report.split("_")[0].concat("_"); //get cancelled and add underscore
			        // FluentWait<WebDriver> wait = new FluentWait<WebDriver>(RunnerClass.driver);
			                 //wait.pollingEvery(1, TimeUnit.SECONDS);
			                 //wait.withTimeout(15, TimeUnit.SECONDS);
			                 RunnerClass.wait.until(x -> {
			                     File[] filesInDir = dir.listFiles();
			                     for (File fileInDir : filesInDir) {
			                         if (fileInDir.getName().startsWith("Marketing")) {
			                             return true;
			                         }
			                     }
			                     return false;
			                 });
			         */
			         //delete the current file
			         File file = new File(fileName);
			         file.delete();
			      } catch (MessagingException e) 
			      {
			    	  e.printStackTrace();
			         throw new RuntimeException(e);
			      }
			   }
		


}
