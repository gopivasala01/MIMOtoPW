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
			public static void createExcelFileWithProcessedData()
			{
				//Get Today's date in MMddyyyy format
				LocalDate dateObj = LocalDate.now();
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
		        String date = dateObj.format(formatter);
		        System.out.println(date);
		        String filename ;
				try   
				{  
				filename = AppConfig.excelFileLocation+"\\MIMOtoPW_"+date+".xlsx";  
				File file = new File(filename);
				if(!file.exists())
					file.mkdirs();
				//if file exists, delete and re create it
				if(file.exists())
				{
					file.delete();
				}
				Workbook wb = new XSSFWorkbook();
				Sheet sheet1 = wb.createSheet("Sheet 1");
				Row header = sheet1.createRow(0);
				header.createCell(0).setCellValue("Company");
				header.createCell(1).setCellValue("Unit Entity ID");
				header.createCell(2).setCellValue("Address");
				header.createCell(3).setCellValue("Current Resident FirstName");
				header.createCell(4).setCellValue("Current Resident LastName");
				header.createCell(5).setCellValue("Utility ConnectionRequest");
				header.createCell(6).setCellValue("Set Construction Code to");
				header.createCell(7).setCellValue("Filter Size");
				header.createCell(8).setCellValue("Possesion Confirmed Date");
				header.createCell(9).setCellValue("Turn Over Handled By");
				header.createCell(10).setCellValue("Turn Estimate Submission Date");
				header.createCell(11).setCellValue("Turn Estimated Cost");
				header.createCell(12).setCellValue("Turn Approval Date");
				header.createCell(13).setCellValue("Turn State Date");
				header.createCell(14).setCellValue("Turn Estimated Completion Date");
				header.createCell(15).setCellValue("Turn Actual Completion Date");
				header.createCell(16).setCellValue("Turn Actual Cost");
				header.createCell(17).setCellValue("Turn QC Completed Date");
				header.createCell(18).setCellValue("Leasing Lockbox Serial Number");
				header.createCell(19).setCellValue("Last_vacantVisit");
				header.createCell(20).setCellValue("Automation Status");
				header.createCell(21).setCellValue("Automation Notes");
				//int totalCurrentDayBuildings = RunnerClass.successBuildings.size()+RunnerClass.failedBuildings.size();
				//sheet1.createRow(sheet1.getLastRowNum()+totalCurrentDayBuildings);
				boolean getBuildings =  DataBase.getCompletedBuildingsList();
				if(getBuildings==true&&RunnerClass.completedLeasesList!=null)
				{
					for(int i=0;i<RunnerClass.completedLeasesList.length;i++)
					{
						String company = RunnerClass.completedLeasesList[i][0];
						String Unit_Entity_ID = RunnerClass.completedLeasesList[i][1];
						String Address = RunnerClass.completedLeasesList[i][2];
						String Current_Resident_FirstName = RunnerClass.completedLeasesList[i][3];
						String Current_Resident_LastName = RunnerClass.completedLeasesList[i][4];
						String Utility_ConnectionRequest = RunnerClass.completedLeasesList[i][5];
						String SetConstruction_Codeto = RunnerClass.completedLeasesList[i][6];
						String FilterSize = RunnerClass.completedLeasesList[i][7];
						String PossesionConfirmedDate = RunnerClass.completedLeasesList[i][8];
						String TurnOver_HandledBy = RunnerClass.completedLeasesList[i][9];
						String TurnEstimate_SubmissionDate = RunnerClass.completedLeasesList[i][10];
						String TurnEstimatedCost = RunnerClass.completedLeasesList[i][11];
						String TurnApprovalDate = RunnerClass.completedLeasesList[i][12];
						String TurnStateDate = RunnerClass.completedLeasesList[i][13];
						String TurnEstimated_CompletionDate = RunnerClass.completedLeasesList[i][14];
						String TurnActual_CompletionDate = RunnerClass.completedLeasesList[i][15];
						String TurnActualCost = RunnerClass.completedLeasesList[i][16];
						String Turn_QCCompletedDate = RunnerClass.completedLeasesList[i][17];
						String LeasingLockbox_SerialNumber = RunnerClass.completedLeasesList[i][18];
						String Last_vacantVisit = RunnerClass.completedLeasesList[i][19];
						String Automation_Status = RunnerClass.completedLeasesList[i][20];
						String Automation_Notes = RunnerClass.completedLeasesList[i][21];
						Row row = sheet1.createRow(1+i);
						try
						{
						row.createCell(0).setCellValue(company);
						}
						catch(Exception e) 
						{company ="";}
						try
						{
						row.createCell(1).setCellValue(Unit_Entity_ID);
						}
						catch(Exception e) 
						{Unit_Entity_ID ="";};
						try
						{
							row.createCell(2).setCellValue(Address);
						}
						catch(Exception e)
						{
							Address = "";
						}
						
						try
						{
						row.createCell(3).setCellValue(Current_Resident_FirstName);
						}catch(Exception e) 
						{Current_Resident_FirstName = "";}
						try
						{
							row.createCell(4).setCellValue(Current_Resident_LastName);
						}
						catch(Exception e)
						{
							Current_Resident_LastName = "";
						}
						try
						{
						row.createCell(5).setCellValue(Utility_ConnectionRequest);
						}
						catch(Exception e)
						{
							Utility_ConnectionRequest = "";
						}
						try
						{
						row.createCell(6).setCellValue(SetConstruction_Codeto);
						}
						catch(Exception e)
						{
							SetConstruction_Codeto = "";
						}
						try
						{
						row.createCell(7).setCellValue(FilterSize);
						}
						catch(Exception e)
						{
							FilterSize = "";
						}
						try
						{
						row.createCell(8).setCellValue(PossesionConfirmedDate);
						}
						catch(Exception e)
						{
							PossesionConfirmedDate = "";
						}
						try
						{
						row.createCell(9).setCellValue(TurnOver_HandledBy);
						}
						catch(Exception e)
						{
							TurnOver_HandledBy = "";
						}
						try
						{
						row.createCell(10).setCellValue(TurnEstimate_SubmissionDate);
						}
						catch(Exception e)
						{
							TurnEstimate_SubmissionDate = "";
						}
						try
						{
						row.createCell(11).setCellValue(TurnEstimatedCost);
						}
						catch(Exception e)
						{
							TurnEstimatedCost = "";
						}
						try
						{
						row.createCell(12).setCellValue(TurnApprovalDate);
						}
						catch(Exception e)
						{
							TurnApprovalDate = "";
						}
						try
						{
						row.createCell(13).setCellValue(TurnStateDate);
						}
						catch(Exception e)
						{
							TurnStateDate = "";
						}
						try
						{
						row.createCell(14).setCellValue(TurnEstimated_CompletionDate);
						}
						catch(Exception e)
						{
							TurnEstimated_CompletionDate = "";
						}
						try
						{
						row.createCell(15).setCellValue(TurnActual_CompletionDate);
						}
						catch(Exception e)
						{
							TurnActual_CompletionDate = "";
						}
						try
						{
						row.createCell(16).setCellValue(TurnActualCost);
						}
						catch(Exception e)
						{
							TurnActualCost = "";
						}
						try
						{
						row.createCell(17).setCellValue(Turn_QCCompletedDate);
						}
						catch(Exception e)
						{
							Turn_QCCompletedDate = "";
						}
						try
						{
						row.createCell(18).setCellValue(LeasingLockbox_SerialNumber);
						}
						catch(Exception e)
						{
							LeasingLockbox_SerialNumber = "";
						}
						try
						{
						row.createCell(19).setCellValue(Last_vacantVisit);
						}
						catch(Exception e)
						{
							Last_vacantVisit = "";
						}
						try
						{
						row.createCell(20).setCellValue(Automation_Status);
						}
						catch(Exception e)
						{
							Automation_Status = "";
						}
						try
						{
						row.createCell(21).setCellValue(Automation_Notes);
						}
						catch(Exception e)
						{
							Automation_Notes = "";
						}
					}
				
				}
				
				System.out.println("Last row in the sheet = "+sheet1.getLastRowNum());
				FileOutputStream fileOut = new FileOutputStream(filename);  
				wb.write(fileOut);
				wb.close();
				fileOut.close();  
				System.out.println("Excel file has been generated successfully.");  
				MailActivities.sendFileToMail(filename);
				}   
				catch (Exception e)   
				{  
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
