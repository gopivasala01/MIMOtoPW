package mainPackage;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDButton;
import org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox;
import org.apache.pdfbox.pdmodel.interactive.form.PDComboBox;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDPushButton;
import org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunnerClass 
{
	public static String[][] pendingLeases; 
    public static ChromeDriver driver;
    public static String downloadFilePath;
	public static Actions actions;
	public static JavascriptExecutor js;
	public static WebDriverWait wait;
	public static Alert alert;
	
	public static String failedReason;
	
    public static String ID;
	public static String company;
	public static String unitEntityID;
	public static String leaseEntityID;
	public static String address;
	public static String current_Resident_FirstName;
	public static String Current_Resident_LastName;
	public static String Utility_ConnectionRequest;
	public static String lockBoxCode;
	public static String filter_Other;
	public static String MOIInspectionDate;
	public static String turnOverHandledBy;
	public static String turnEstimateSubmissionDate;
	public static String turnEstimateCost;
	public static String turnApprovalDate;
	public static String turnStartDate;
	public static String turnTargetCompletionDate;
	public static String turnActualCompletionDate;
	public static String turnActualCost;
	public static String turnQCCompletedDate;
	public static String codeBoxActive;
	public static String lastVacantVisit;
	public static String automationStatus;
	public static String buildingAddress;
	public static String buildingAbbreavation;
	
	public static String[][] completedLeasesList;
	public static void main(String args[]) throws Exception
	{
		
		//Get all Pending Leases
		DataBase.getBuildingsList(AppConfig.pendingLeasesQuery);
		
		PropertyWare.signIn();
		
		
		int j=0;
		while(j<5)
		{
		//Loop over leases
		for(int i=0;i<pendingLeases.length;i++) //pendingLeases.length
		{
			try {
				String expiredURL = RunnerClass.driver.getCurrentUrl();
				if(expiredURL.contains("https://app.propertyware.com/pw/expired.jsp") || expiredURL.equalsIgnoreCase("https://app.propertyware.com/pw/expired.jsp?cookie") || expiredURL.contains(AppConfig.URL)) {
					RunnerClass.driver.navigate().to(AppConfig.URL);
					RunnerClass.driver.findElement(Locators.userName).sendKeys(AppConfig.username); 
				    RunnerClass.driver.findElement(Locators.password).sendKeys(AppConfig.password);
				    Thread.sleep(2000);
				    RunnerClass.driver.findElement(Locators.signMeIn).click();
				    Thread.sleep(3000);
				}
			}
			catch(Exception e) {}
			System.out.println("Lease ---- "+(i+1));
			try
			{
				ID = RunnerClass.pendingLeases[i][0];
				company = RunnerClass.pendingLeases[i][2];
				unitEntityID = RunnerClass.pendingLeases[i][1];
				leaseEntityID = RunnerClass.pendingLeases[i][3];
				address = RunnerClass.pendingLeases[i][4];
				current_Resident_FirstName = RunnerClass.pendingLeases[i][5];
				Current_Resident_LastName = RunnerClass.pendingLeases[i][6];
				Utility_ConnectionRequest = RunnerClass.pendingLeases[i][7];
				codeBoxActive = RunnerClass.pendingLeases[i][8];
				filter_Other = RunnerClass.pendingLeases[i][9];
				MOIInspectionDate = RunnerClass.pendingLeases[i][10].trim().split(" ")[0].replaceAll("[a-zA-Z]", "");
				turnOverHandledBy = RunnerClass.pendingLeases[i][11];
				turnEstimateSubmissionDate = RunnerClass.pendingLeases[i][12].trim().split(" ")[0].replaceAll("[a-zA-Z]", "");
				turnEstimateCost = RunnerClass.pendingLeases[i][13];
				turnApprovalDate = RunnerClass.pendingLeases[i][14].trim().split(" ")[0].replaceAll("[a-zA-Z]", "");
				turnStartDate = RunnerClass.pendingLeases[i][15].trim().split(" ")[0].replaceAll("[a-zA-Z]", "");
				turnTargetCompletionDate = RunnerClass.pendingLeases[i][16].trim().split(" ")[0].replaceAll("[a-zA-Z]", "");
				turnActualCompletionDate = RunnerClass.pendingLeases[i][17].trim().split(" ")[0].replaceAll("[a-zA-Z]", "");
				turnActualCost = RunnerClass.pendingLeases[i][18];
				turnQCCompletedDate = RunnerClass.pendingLeases[i][19].trim().split(" ")[0].replaceAll("[a-zA-Z]", "");
				lockBoxCode = RunnerClass.pendingLeases[i][20];
				lastVacantVisit = RunnerClass.pendingLeases[i][21].trim().split(" ")[0].replaceAll("[a-zA-Z]", "");
				automationStatus = RunnerClass.pendingLeases[i][22];
				buildingAbbreavation = RunnerClass.pendingLeases[i][23];
				
				switch(company) 
				{
				case "OH":
				   company= "Ohio";
				    break;
				case "Columbus":
					company= "Ohio";
					break;
				case "Colombus":
					company= "Ohio";
					break;
				case "Missouri":
				    company = "Columbia - St Louis";
				    break;
				case "Indy/IN":
					company = "Indiana";
					break;
				case "Cincinnati":
					company = "Ohio";
					break;
				case "Saint Louis":
					company = "Columbia - St Louis";
					break;
				case "California PFW":
					company = "California pfw";
					break;
				case "Chicago PFW":
					company = "Chicago pfw";
					break;

				case "Kansas CIty":
					company = "Kansas City";
					break;

				case "Dallas/Ft Worth":
					company= "Dallas/Fort Worth";
					break;
				case "DFW":
					company= "Dallas/Fort Worth";
					break;
				case "Mississppi":
					company= "Tennessee";
					break;
				case "Dallas / Fort Worth":
					company= "Dallas/Fort Worth";
					break;
				case "Oklahoma":
					company= "OKC";
					break;
				case "Kentucky":
					company= "Ohio";
					break;
				case "Texas":
					company= "San Antonio";
					break;
				case "ALVAR X1 LLC":
					company= "Georgia";
					break;
				case "OHIO":
					   company= "Ohio";
					    break;
				case "Hero Homes JV 2 LLC":
					   company= "Ohio";
					    break;
					    
				case "Dallas/Forth Worth":
					   company= "Dallas/Fort Worth";
					    break;
				case "Hero Homes JV 1 Arbor LLC":
					   company= "Ohio";
					    break;
				case "TCA13 Homes LLC":
					   company= "Ohio";
					    break;
				case "RS Rental III-A LLC":
					   company= "Tennessee";
					    break;
				case "HOH.Hero Homes JV 2 LLC":
					   company= "Ohio";
					    break;
				case "AINO NC LLC":
					   company= "North Carolina";
					    break;
				case "Kansas":
					company = "Kansas City";
					break;
				case "RCGA LLC":
					   company= "Dallas/Fort Worth";
					    break;
				case "TH Properties CL LLC":
					   company= "Ohio";
					    break; 
				case "Hero Homes Solutions LLC":
					   company= "Ohio";
					    break;
					    
					   
				}
			
			//Convert Dates
			MOIInspectionDate = CommonMethods.convertDate(MOIInspectionDate);
			turnEstimateSubmissionDate = CommonMethods.convertDate(turnEstimateSubmissionDate);
			turnApprovalDate = CommonMethods.convertDate(turnApprovalDate);
			turnStartDate = CommonMethods.convertDate(turnStartDate);
			turnTargetCompletionDate = CommonMethods.convertDate(turnTargetCompletionDate);
			turnActualCompletionDate = CommonMethods.convertDate(turnActualCompletionDate);
			turnQCCompletedDate = CommonMethods.convertDate(turnQCCompletedDate);
			lastVacantVisit = CommonMethods.convertDate(lastVacantVisit);
			
			System.out.println(ID+" | "+company+" | "+unitEntityID+" | "+address+" | "+current_Resident_FirstName+" | "+Current_Resident_LastName+" | "+Utility_ConnectionRequest+" | "+lockBoxCode+" | "+filter_Other+" | "+MOIInspectionDate+" | "+turnOverHandledBy+" | "+turnEstimateSubmissionDate+" | "+turnEstimateCost+" | "+turnApprovalDate+" | "+turnStartDate+" | "+turnTargetCompletionDate+" | "+turnActualCompletionDate+" | "+turnActualCost+" | "+turnQCCompletedDate+" | "+codeBoxActive+" | "+lastVacantVisit+" |"+buildingAbbreavation);
			System.out.println(ID+" | "+company+" | "+unitEntityID+" | "+address+" |"+buildingAbbreavation);
			 /*uncomment this for production run
			if(Utility_ConnectionRequest==null&&lockBoxCode==null&&filter_Other==null&&MOIInspectionDate==null&&turnOverHandledBy==null&&turnEstimateSubmissionDate==null&&turnEstimateCost==null&&turnApprovalDate==null&&turnStartDate==null&&turnTargetCompletionDate==null&&turnActualCompletionDate==null&&turnActualCost==null&&turnQCCompletedDate==null&&codeBoxActive==null&&lastVacantVisit==null)
			{
				System.out.println("All values are null");
				continue;
			}
			*/
			failedReason = "";
			
			//Check if Permission Denied page appears
			//PropertyWare.permissionDeniedPage();
		
		     Thread.sleep(2000);
		     
			if (PropertyWare.selectBuilding() == false) 
			{
			    String query = "UPDATE Automation.MIMOToPw_Prod SET AutomationStatus='Failed', Note='" + failedReason + "' WHERE ID = '" + ID + "'";
			    DataBase.updateTable(query);
			    continue;
			}

			if (UpdateValuesInPW.updateFieldsInBuildingPagePage() == false) 
			{
			    String query = "UPDATE Automation.MIMOToPw_Prod SET AutomationStatus='Failed', Note='" + failedReason + "' WHERE ID = '" + ID + "'";
			    DataBase.updateTable(query);
			    continue;
			}

			/*if (PropertyWare.selectLease() == false) 
			{
			    String query = "UPDATE Automation.MIMOToPw_Prod SET AutomationStatus='Completed', Note='" + failedReason + "' WHERE ID = '" + ID + "'";
			    DataBase.updateTable(query);
			    continue;
			}

			if (UpdateValuesInPW.updateFieldsInLeasePage() == false) {
			    String query = "UPDATE Automation.MIMOToPw_Prod SET AutomationStatus='Completed', Note='" + failedReason + "' WHERE ID = '" + ID + "'";
			    DataBase.updateTable(query);
			    continue;
			}*/

			String query = "";
			// Update record as Completed
			if (failedReason.equals(""))
			    query = "UPDATE Automation.MIMOToPw_Prod SET AutomationStatus='Completed', Note= Null  WHERE ID = '" + ID + "'";
			else {
			    if (failedReason.charAt(0) == ',')
			        failedReason = failedReason.substring(1, failedReason.length());
			    query = "UPDATE Automation.MIMOToPw_Prod SET AutomationStatus='Review', Note='" + failedReason + "' WHERE ID = '" + ID + "'";
			}
			DataBase.updateTable(query);

			 RunnerClass.driver.get(AppConfig.homeURL);
			 WebDriverManager.chromedriver().clearDriverCache().setup();
			 Thread.sleep(2000);
		        PropertyWare.intermittentPopUp();
		     
		        RunnerClass.driver.findElement(Locators.marketDropdown).click();
		        String marketName = "HomeRiver Group Holdings, LLC (Master)";
		        Select marketDropdownList = new Select(RunnerClass.driver.findElement(Locators.marketDropdown));
		        marketDropdownList.selectByVisibleText(marketName);
		        RunnerClass.driver.navigate().refresh();
		        Thread.sleep(3000);
		        
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
				continue;
			} 
			
			
		}
		//Loop for Failed Leases
		DataBase.getBuildingsList(AppConfig.failedLeasesQuery);
		
		System.out.println((j+1)+ " Time");
		if(pendingLeases.length>0)
		j++;
		else break;
		
		}
		//Create Excel File 
		
		
		if(DataBase.getPendingLeases()==true) {
			MailActivities.processAndSendEmail();
		}
		

		
	}
}