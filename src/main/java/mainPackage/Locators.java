package mainPackage;

import org.openqa.selenium.By;

public class Locators 
{
	public static By userName = By.id("loginEmail");
	public static By password = By.name("password");
	public static By signMeIn = By.xpath("//*[@value='Sign Me In']");
	public static By loginError = By.xpath("//*[@class='toast toast-error']");
	
	public static By marketDropdown = By.id("switchAccountSelect");
	public static By buildingTitle = By.id("summaryTitleBuilding");
	public static By leasesTab = By.xpath("//*[@class='tabbedSection']/a[4]");	
    public static By leasesTab2 = By.xpath("(//a[text()='Leases'])[2]");
    public static By tenantContact = By.xpath("//*[@id='buildingLeaseList']/tbody/tr/td[2]/a");
    public static By leaseList = By.xpath("//*[@id='buildingLeaseList']/tbody/tr/td[1]/a");
    public static By popUpAfterClickingLeaseName = By.xpath("//*[@id='viewStickyNoteForm']");
    public static By scheduledMaintanancePopUp = By.xpath("//*[text()='Scheduled Maintenance Notification']");
    public static By scheduledMaintanancePopUpOkButton = By.id("alertDoNotShow");
    public static By popupClose = By.xpath("//*[@id='editStickyBtnDiv']/input[2]");
    
    public static By summaryEditButton = By.xpath("//*[@value='Edit']");
    public static By utilityConnectionRequest = By.xpath("//*[text()='Utility Connection Request']/following::Select[1]");
    public static By lockBoxCode = By.xpath("//*[text()='Lockbox Code']/following::input[1]");
    public static By filter_Other = By.xpath("//*[text()='Filter - Other']/following::input[1]");
    public static By MOIInspectionDate = By.xpath("//*[text()='MOI Inspection Date']/following::input[1]");
    public static By turnOverHandledBy = By.xpath("//*[text()='Turnover Handled By']/following::Select[1]");
    public static By turnEstimateSubmissionDate = By.xpath("//*[text()='Turn Estimate Submission Date']/following::Select[1]");
    public static By turnEstimateCost = By.xpath("//*[text()='Turn Estimate Cost']/following::input[1]");
    public static By turnApprovalDate = By.xpath("//*[text()='Turn Approval Date']/following::input[1]");
    public static By turnStartDate = By.xpath("//*[text()='Turn Start Date']/following::input[1]");
    public static By turnTargetCompletionDate = By.xpath("//*[text()='Turn Target Completion Date']/following::input[1]");
    public static By turnActualCompletionDate = By.xpath("//*[text()='Turn Actual Completion Date']/following::input[1]");
    public static By turnActualCost = By.xpath("//*[text()='Turn Actual Cost']/following::input[1]");
    public static By turnQCCompletedDate = By.xpath("//*[text()='Turn QC Completed Date']/following::input[1]");
    public static By codeBoxActive = By.xpath("//*[text()='Codebox Active']/following::input[1]");
    public static By lastVacantVisit = By.xpath("//*[text()='Last Vacant Visit']/following::input[1]");
    
    public static By saveLease = By.xpath("(//*[@class='primaryButtons'])[2]/input[1]");
    public static By cancelLease = By.xpath("(//*[@class='primaryButtons'])[2]/input[2]");
    
    public static By saveBuilding = By.xpath("(//*[@class='primaryButtons'])[2]/input[1]");
    public static By cancelBuilding = By.xpath("(//*[@class='primaryButtons'])[2]/input[4]");
    		
}
