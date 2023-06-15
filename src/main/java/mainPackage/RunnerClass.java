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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
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
	
	public static String[][] completedLeasesList;
	public static void main(String args[]) throws Exception
	{
		
		//Get all Pending Leases
		DataBase.getBuildingsList(AppConfig.pendingLeasesQuery);
		
		//Initial Browser
		PropertyWare.initiateBrowser();
		
		//Login to PW
		PropertyWare.signIn();
		int j=0;
		while(j<5)
		{
		//Loop over leases
		for(int i=0;i<pendingLeases.length;i++)
		{
			System.out.println("Lease ---- "+(i+1));
			try
			{
			ID = pendingLeases[i][0];
			company = pendingLeases[i][1];
			unitEntityID = pendingLeases[i][2];
			address = pendingLeases[i][3];
			current_Resident_FirstName = pendingLeases[i][4];
			Current_Resident_LastName = pendingLeases[i][5];
			Utility_ConnectionRequest = pendingLeases[i][6];
			lockBoxCode = pendingLeases[i][7];
			filter_Other = pendingLeases[i][8];
			MOIInspectionDate = pendingLeases[i][9].trim();//.split(" ")[0].replace("-", "/");
			turnOverHandledBy = pendingLeases[i][10];
			turnEstimateSubmissionDate = pendingLeases[i][11].trim();//.split(" ")[0].replace("-", "/");
			turnEstimateCost = pendingLeases[i][12];
			turnApprovalDate = pendingLeases[i][13].trim();//.split(" ")[0].replace("-", "/");
			turnStartDate = pendingLeases[i][14].trim();//.split("")[0].replace("-", "/");
			turnTargetCompletionDate = pendingLeases[i][15].trim();//.split(" ")[0].replace("-", "/");
			turnActualCompletionDate = pendingLeases[i][16].trim();//.split(" ")[0].replace("-", "/");
			turnActualCost = pendingLeases[i][17];
			turnQCCompletedDate = pendingLeases[i][18].trim();//.split(" ")[0].replace("-", "/");
			codeBoxActive = pendingLeases[i][19];
			lastVacantVisit = pendingLeases[i][20].trim();//.split(" ")[0].replace("-", "/");
			
			//Convert Dates
			MOIInspectionDate = CommonMethods.convertDate(MOIInspectionDate);
			turnEstimateSubmissionDate = CommonMethods.convertDate(turnEstimateSubmissionDate);
			turnApprovalDate = CommonMethods.convertDate(turnApprovalDate);
			turnStartDate = CommonMethods.convertDate(turnStartDate);
			turnTargetCompletionDate = CommonMethods.convertDate(turnTargetCompletionDate);
			turnActualCompletionDate = CommonMethods.convertDate(turnActualCompletionDate);
			turnQCCompletedDate = CommonMethods.convertDate(turnQCCompletedDate);
			lastVacantVisit = CommonMethods.convertDate(lastVacantVisit);
			
			//System.out.println(ID+" | "+company+" | "+unitEntityID+" | "+address+" | "+current_Resident_FirstName+" | "+Current_Resident_LastName+" | "+Utility_ConnectionRequest+" | "+lockBoxCode+" | "+filter_Other+" | "+MOIInspectionDate+" | "+turnOverHandledBy+" | "+turnEstimateSubmissionDate+" | "+turnEstimateCost+" | "+turnApprovalDate+" | "+turnStartDate+" | "+turnTargetCompletionDate+" | "+turnActualCompletionDate+" | "+turnActualCost+" | "+turnQCCompletedDate+" | "+codeBoxActive+" | "+lastVacantVisit);
			System.out.println(ID+" | "+company+" | "+unitEntityID+" | "+address);
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
			
			if(PropertyWare.selectBuilding()==false)
			{
				String query = "Update Automation.MIMOtoPW set Automation_Status='Failed',Automation_Notes='"+failedReason+"',Automation_CompletionDate =getdate() where ID = '"+ID+"'";
				DataBase.updateTable(query);
				continue;
			}
			
			if(UpdateValuesInPW.updateFieldsInBuildingPagePage()==false)
			{
				String query = "Update Automation.MIMOtoPW set Automation_Status='Failed',Automation_Notes='"+failedReason+"',Automation_CompletionDate =getdate() where ID = '"+ID+"'";
				DataBase.updateTable(query);
				continue;
			}
			
			if(PropertyWare.selectLease()==false)
			{
				String query = "Update Automation.MIMOtoPW set Automation_Status='Failed',Automation_Notes='"+failedReason+"',Automation_CompletionDate =getdate() where ID = '"+ID+"'";
				DataBase.updateTable(query);
				continue;
			}
			
			if(UpdateValuesInPW.updateFieldsInLeasePage()==false)
			{
				String query = "Update Automation.MIMOtoPW set Automation_Status='Failed',Automation_Notes='"+failedReason+"',Automation_CompletionDate =getdate() where ID = '"+ID+"'";
				DataBase.updateTable(query);
				continue;
			}
			String query = "";
			//Update record as Completed
			if(failedReason.equals(""))
			query = "Update Automation.MIMOtoPW set Automation_Status='Completed',Automation_CompletionDate =getdate() where ID = '"+ID+"'";
			else
			{
				if(failedReason.charAt(0)==',')
					failedReason = failedReason.substring(1, failedReason.length());
				query = "Update Automation.MIMOtoPW set Automation_Status='Review',Automation_Notes='"+failedReason+"',Automation_CompletionDate =getdate() where ID = '"+ID+"'";
			}
			DataBase.updateTable(query);
			
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
		//MailActivities.createExcelFileWithProcessedData();
		
	}
}
