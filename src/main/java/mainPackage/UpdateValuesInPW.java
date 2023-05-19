package mainPackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateValuesInPW 
{
	public static boolean updateFieldsInLeasePage() throws Exception
	{
		try
		{
		RunnerClass.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(5));
        RunnerClass.driver.findElement(Locators.summaryEditButton).click();
        
        //Utility Connection Request
        if(RunnerClass.Utility_ConnectionRequest!=null)
        {
        try
        {
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.utilityConnectionRequest)).build().perform();
        	Select utilityConnectionRequest = new Select(RunnerClass.driver.findElement(Locators.utilityConnectionRequest));
        	utilityConnectionRequest.selectByVisibleText(RunnerClass.Utility_ConnectionRequest);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Utility Connection Request";
        }
        }
        //Save Lease
        if(AppConfig.saveButtonOnAndOff==false)
		{
			 RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.cancelLease)).build().perform();
			 RunnerClass.driver.findElement(Locators.cancelLease).click();
		}
		else 
		{
			RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.saveLease)).build().perform();
			 RunnerClass.driver.findElement(Locators.saveLease).click();
			 Thread.sleep(2000);
			 if(RunnerClass.driver.findElement(Locators.saveLease).isDisplayed())
			 {
				 RunnerClass.failedReason = RunnerClass.failedReason + ", Lease Fields Could not get updated";
				 return false;
			 }
		}
        return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}
	
	public static boolean updateFieldsInBuildingPagePage() throws Exception
	{
		RunnerClass.driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(3));
        RunnerClass.driver.findElement(Locators.summaryEditButton).click();
        
        //Lock Box Code
        if(RunnerClass.lockBoxCode!=null) //||!RunnerClass.lockBoxCode.equals("")
        {
        try
        {
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.lockBoxCode)).build().perform();
        	RunnerClass.driver.findElement(Locators.utilityConnectionRequest).click();
        	RunnerClass.driver.findElement(Locators.utilityConnectionRequest).clear();
        	RunnerClass.driver.findElement(Locators.utilityConnectionRequest).sendKeys(RunnerClass.lockBoxCode);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Lock Box Code";
        }
        }
       //Filter - Other
        if(RunnerClass.filter_Other!=null)//||!RunnerClass.filter_Other.equals(""))
        {
        try
        {
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.filter_Other)).build().perform();
        	RunnerClass.driver.findElement(Locators.filter_Other).click();
        	RunnerClass.driver.findElement(Locators.filter_Other).clear();
        	RunnerClass.driver.findElement(Locators.filter_Other).sendKeys(RunnerClass.filter_Other);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Filter - Other";
        }
        }
      //MOI Inspection Date
        if(RunnerClass.MOIInspectionDate!=null)//||!RunnerClass.MOIInspectionDate.equals(""))
        {
        try
        {
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.MOIInspectionDate)).build().perform();
        	RunnerClass.driver.findElement(Locators.MOIInspectionDate).click();
        	RunnerClass.driver.findElement(Locators.MOIInspectionDate).clear();
        	RunnerClass.driver.findElement(Locators.MOIInspectionDate).sendKeys(RunnerClass.MOIInspectionDate);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", MOI Inspection Date";
        }
        }
      //Turnover Handled by
        if(RunnerClass.turnOverHandledBy!=null)//!RunnerClass.turnOverHandledBy.equals(""))
        {
        try
        {
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.turnOverHandledBy)).build().perform();
        	Select utilityConnectionRequest = new Select(RunnerClass.driver.findElement(Locators.turnOverHandledBy));
        	utilityConnectionRequest.selectByVisibleText(RunnerClass.turnOverHandledBy);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Turnover Handled by";
        }
        }
      //Turn Estimate Submission Date
        if(RunnerClass.turnEstimateSubmissionDate!=null)//!RunnerClass.turnEstimateSubmissionDate.equals(""))
        {
        try
        {
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.turnEstimateSubmissionDate)).build().perform();
        	Select utilityConnectionRequest = new Select(RunnerClass.driver.findElement(Locators.turnEstimateSubmissionDate));
        	utilityConnectionRequest.selectByVisibleText(RunnerClass.turnEstimateSubmissionDate);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Turn Estimate Submission Date";
        }
        }
      //Turn Estimate Cost
        if(RunnerClass.turnEstimateCost!=null)//!RunnerClass.turnEstimateCost.equals(""))
        {
        try
        {
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.turnEstimateCost)).build().perform();
        	RunnerClass.driver.findElement(Locators.turnEstimateCost).click();
        	RunnerClass.driver.findElement(Locators.turnEstimateCost).clear();
        	RunnerClass.driver.findElement(Locators.turnEstimateCost).sendKeys(RunnerClass.turnEstimateCost);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Turn Estimate Cost";
        }
        }
      //Turn Approval Date
        if(RunnerClass.turnApprovalDate!=null)//!RunnerClass.turnApprovalDate.equals(""))
        {
        try
        {
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.turnApprovalDate)).build().perform();
        	RunnerClass.driver.findElement(Locators.turnApprovalDate).click();
        	RunnerClass.driver.findElement(Locators.turnApprovalDate).clear();
        	RunnerClass.driver.findElement(Locators.turnApprovalDate).sendKeys(RunnerClass.turnApprovalDate);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Turn Approval Date";
        }
        }
      //Turn Start Date
        if(RunnerClass.turnStartDate!=null)//!RunnerClass.turnStartDate.equals(""))
        {
        try
        {
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.turnStartDate)).build().perform();
        	RunnerClass.driver.findElement(Locators.turnStartDate).click();
        	RunnerClass.driver.findElement(Locators.turnStartDate).clear();
        	RunnerClass.driver.findElement(Locators.turnStartDate).sendKeys(RunnerClass.turnStartDate);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Turn Start Date";
        }
        }
      //Turn Target Completion Date
        if(RunnerClass.turnTargetCompletionDate!=null)//!RunnerClass.turnTargetCompletionDate.equals(""))
        {
        try
        {
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.turnTargetCompletionDate)).build().perform();
        	RunnerClass.driver.findElement(Locators.turnTargetCompletionDate).click();
        	RunnerClass.driver.findElement(Locators.turnTargetCompletionDate).clear();
        	RunnerClass.driver.findElement(Locators.turnTargetCompletionDate).sendKeys(RunnerClass.turnTargetCompletionDate);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Turn Target Completion Date";
        }
        }
      //Turn Actual Completion Date
        if(RunnerClass.turnActualCompletionDate!=null)//!RunnerClass.turnActualCompletionDate.equals(""))
        {
        try
        {
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.turnActualCompletionDate)).build().perform();
        	RunnerClass.driver.findElement(Locators.turnActualCompletionDate).click();
        	RunnerClass.driver.findElement(Locators.turnActualCompletionDate).clear();
        	RunnerClass.driver.findElement(Locators.turnActualCompletionDate).sendKeys(RunnerClass.turnActualCompletionDate);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Turn Actual Completion Date";
        }
        }
      //Turn Actual Cost
        if(RunnerClass.turnActualCost!=null)//!RunnerClass.turnActualCost.equals(""))
        {
        try
        {
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.turnActualCost)).build().perform();
        	RunnerClass.driver.findElement(Locators.turnActualCost).click();
        	RunnerClass.driver.findElement(Locators.turnActualCost).clear();
        	RunnerClass.driver.findElement(Locators.turnActualCost).sendKeys(RunnerClass.turnActualCost);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Turn Actual Cost";
        }
        }
      //Turn QC Completed Date
        if(RunnerClass.turnQCCompletedDate!=null)//!RunnerClass.turnQCCompletedDate.equals(""))
        {
        try
        {
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.turnQCCompletedDate)).build().perform();
        	RunnerClass.driver.findElement(Locators.turnQCCompletedDate).click();
        	RunnerClass.driver.findElement(Locators.turnQCCompletedDate).clear();
        	RunnerClass.driver.findElement(Locators.turnQCCompletedDate).sendKeys(RunnerClass.turnQCCompletedDate);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Turn QC Completed Date";
        }
        }
      //Code box Active
        if(RunnerClass.codeBoxActive!=null)//!RunnerClass.codeBoxActive.equals(""))
        {
        try
        {
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.codeBoxActive)).build().perform();
        	RunnerClass.driver.findElement(Locators.codeBoxActive).click();
        	RunnerClass.driver.findElement(Locators.codeBoxActive).clear();
        	RunnerClass.driver.findElement(Locators.codeBoxActive).sendKeys(RunnerClass.codeBoxActive);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Code box Active";
        }
        }
      //Last Vacant Visit
        if(RunnerClass.lastVacantVisit!=null)//!RunnerClass.lastVacantVisit.equals(""))
        {
        try
        {
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.lastVacantVisit)).build().perform();
        	RunnerClass.driver.findElement(Locators.lastVacantVisit).click();
        	RunnerClass.driver.findElement(Locators.lastVacantVisit).clear();
        	RunnerClass.driver.findElement(Locators.lastVacantVisit).sendKeys(RunnerClass.lastVacantVisit);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Last Vacant Visit";
        }
        }
        try
        {
        //Save Building
        if(AppConfig.saveButtonOnAndOff==false)
		{
			 RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.cancelBuilding)).build().perform();
			 RunnerClass.driver.findElement(Locators.cancelBuilding).click();
		}
		else 
		{
			RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.saveBuilding)).build().perform();
			 RunnerClass.driver.findElement(Locators.saveBuilding).click();
			 Thread.sleep(2000);
			 if(RunnerClass.driver.findElement(Locators.cancelBuilding).isDisplayed())
			 {
				 RunnerClass.failedReason = RunnerClass.failedReason + ", Building Fields Could not get updated";
				 return false;
			 }
		}
        return true;
        }
        catch(Exception e)
        {
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Building Fields Could not get updated";
        	return false;
        }
        
	}
	
	

}
