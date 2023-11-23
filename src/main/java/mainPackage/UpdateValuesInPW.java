package mainPackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        if(RunnerClass.Utility_ConnectionRequest.trim().equals("")||RunnerClass.Utility_ConnectionRequest==null)
        	RunnerClass.Utility_ConnectionRequest= "Please+Choose";
        //if(RunnerClass.Utility_ConnectionRequest!=null)
        //{
        try
        {
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.utilityConnectionRequest)).build().perform();
        	Select utilityConnectionRequest = new Select(RunnerClass.driver.findElement(Locators.utilityConnectionRequest));
        	if(RunnerClass.Utility_ConnectionRequest.contains("Please+Choose"))
        	utilityConnectionRequest.selectByValue(RunnerClass.Utility_ConnectionRequest);
        	else
        		utilityConnectionRequest.selectByVisibleText(RunnerClass.Utility_ConnectionRequest);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Utility Connection Request";
        }
        //}
        //Save Lease
        if(AppConfig.saveButtonOnAndOff==false)
		{
			 RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.cancelLease)).build().perform();
			 RunnerClass.driver.findElement(Locators.cancelLease).click();
			 Thread.sleep(2000);
		}
		else 
		{
			RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.saveLease)).build().perform();
			 RunnerClass.driver.findElement(Locators.saveLease).click();
			 Thread.sleep(2000);
			 try
			 {
				 
				 handleAlerts();
				 RunnerClass.driver.navigate().refresh();
			        Thread.sleep(2000);
			 }
			 
			 catch(Exception e)
			{e.printStackTrace();}
			 try
			 {
			 if(RunnerClass.driver.findElement(Locators.saveLease).isDisplayed())
			 {
				 RunnerClass.failedReason = RunnerClass.failedReason + ", Lease Fields Could not get updated";
				 return false;
			 }
			 }
			 catch(Exception e) {
				 e.printStackTrace();
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
        if(RunnerClass.lockBoxCode==null)
        	RunnerClass.lockBoxCode="";
        try
        {
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.lockBoxCode)).build().perform();
        	RunnerClass.js.executeScript("window.scrollBy(0,100)");
        	RunnerClass.driver.findElement(Locators.lockBoxCode).click();
        	RunnerClass.driver.findElement(Locators.lockBoxCode).clear();
        	RunnerClass.driver.findElement(Locators.lockBoxCode).sendKeys(RunnerClass.codeBoxActive);
        	Thread.sleep(500);

        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Lock Box Code";
        }
       //Filter - Other
        try
        {
        	if(RunnerClass.filter_Other==null)//||!RunnerClass.filter_Other.equals(""))
        		RunnerClass.filter_Other="";
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.filter_Other)).build().perform();
        	RunnerClass.js.executeScript("window.scrollBy(0,100)");
        	RunnerClass.driver.findElement(Locators.filter_Other).click();
        	RunnerClass.driver.findElement(Locators.filter_Other).clear();
        	RunnerClass.driver.findElement(Locators.filter_Other).sendKeys(RunnerClass.filter_Other);
        	Thread.sleep(500);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Filter - Other";
        }
      //MOI Inspection Date
        try
        {
        	if(RunnerClass.MOIInspectionDate==null)//||!RunnerClass.MOIInspectionDate.equals(""))
        		RunnerClass.MOIInspectionDate="";
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.MOIInspectionDate)).build().perform();
        	RunnerClass.js.executeScript("window.scrollBy(0,100)");
        	RunnerClass.driver.findElement(Locators.MOIInspectionDate).click();
        	RunnerClass.driver.findElement(Locators.MOIInspectionDate).clear();
        	RunnerClass.driver.findElement(Locators.MOIInspectionDate).sendKeys(RunnerClass.MOIInspectionDate);
        	RunnerClass.actions.sendKeys(Keys.ESCAPE).build().perform();
        	Thread.sleep(500);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", MOI Inspection Date";
        }
      //Turnover Handled by
        if(RunnerClass.turnOverHandledBy.trim().equals("")||RunnerClass.turnOverHandledBy==null)
        	RunnerClass.turnOverHandledBy = "Please+Choose";
        try
        {
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.turnOverHandledBy)).build().perform();
        	RunnerClass.js.executeScript("window.scrollBy(0,100)");
        	Select utilityConnectionRequest = new Select(RunnerClass.driver.findElement(Locators.turnOverHandledBy));
        	if(RunnerClass.turnOverHandledBy.contains("Please+"))
        		utilityConnectionRequest.selectByValue(RunnerClass.turnOverHandledBy);
        	else
        	utilityConnectionRequest.selectByVisibleText(RunnerClass.turnOverHandledBy);
        	Thread.sleep(500);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Turnover Handled by";
        }
      //Turn Estimate Submission Date
        try
        {
        	if(RunnerClass.turnEstimateSubmissionDate==null)//!RunnerClass.turnEstimateSubmissionDate.equals(""))
        		RunnerClass.turnEstimateSubmissionDate= "";
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.turnEstimateSubmissionDate)).build().perform();
        	RunnerClass.js.executeScript("window.scrollBy(0,50)");
        	//RunnerClass.driver.findElement(By.xpath("//*[text()='Turn Estimate Submission Date']")).click();
        	RunnerClass.driver.findElement(Locators.turnEstimateSubmissionDate).click();
        	//RunnerClass.actions.click(RunnerClass.driver.findElement(Locators.turnEstimateSubmissionDate)).sendKeys(Keys.CLEAR).build().perform();
        	//RunnerClass.js.executeScript("document.getElementById('pass').value = 'mukeshotwani';");
        	RunnerClass.driver.findElement(Locators.turnEstimateSubmissionDate).clear();
        	RunnerClass.driver.findElement(Locators.turnEstimateSubmissionDate).sendKeys(RunnerClass.turnEstimateSubmissionDate);
        	RunnerClass.actions.sendKeys(Keys.TAB).build().perform();
        	Thread.sleep(500);
        }
        catch(Exception e)
        {
        	
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Turn Estimate Submission Date";
        }
      //Turn Estimate Cost
        try
        {
        	if(RunnerClass.turnEstimateCost==null)//!RunnerClass.turnEstimateCost.equals(""))
        		RunnerClass.turnEstimateCost="";
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.turnEstimateCost)).build().perform();
        	RunnerClass.js.executeScript("window.scrollBy(0,100)");
        	RunnerClass.driver.findElement(Locators.turnEstimateCost).click();
        	RunnerClass.driver.findElement(Locators.turnEstimateCost).clear();
        	RunnerClass.driver.findElement(Locators.turnEstimateCost).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        	RunnerClass.driver.findElement(Locators.turnEstimateCost).sendKeys(RunnerClass.turnEstimateCost);
        	Thread.sleep(500);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Turn Estimate Cost";
        }
      //Turn Approval Date
        try
        {
        	if(RunnerClass.turnApprovalDate==null)//!RunnerClass.turnApprovalDate.equals(""))
        		RunnerClass.turnApprovalDate="";
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.turnApprovalDate)).build().perform();
        	RunnerClass.js.executeScript("window.scrollBy(0,100)");
        	RunnerClass.driver.findElement(Locators.turnApprovalDate).click();
        	RunnerClass.driver.findElement(Locators.turnApprovalDate).clear();
        	RunnerClass.driver.findElement(Locators.turnApprovalDate).sendKeys(RunnerClass.turnApprovalDate);
        	RunnerClass.actions.sendKeys(Keys.ESCAPE).build().perform();
        	Thread.sleep(500);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Turn Approval Date";
        }
      //Turn Start Date
        try
        {
        	if(RunnerClass.turnStartDate==null)//!RunnerClass.turnStartDate.equals(""))
        		RunnerClass.turnStartDate="";
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.turnStartDate)).build().perform();
        	RunnerClass.js.executeScript("window.scrollBy(0,100)");
        	RunnerClass.driver.findElement(Locators.turnStartDate).click();
        	RunnerClass.driver.findElement(Locators.turnStartDate).clear();
        	RunnerClass.driver.findElement(Locators.turnStartDate).sendKeys(RunnerClass.turnStartDate);
        	RunnerClass.actions.sendKeys(Keys.ESCAPE).build().perform();
        	Thread.sleep(500);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Turn Start Date";
        }
      //Turn Target Completion Date
        try
        {
        	if(RunnerClass.turnTargetCompletionDate==null)//!RunnerClass.turnTargetCompletionDate.equals(""))
        		RunnerClass.turnTargetCompletionDate="";
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.turnTargetCompletionDate)).build().perform();
        	RunnerClass.js.executeScript("window.scrollBy(0,100)");
        	RunnerClass.driver.findElement(Locators.turnTargetCompletionDate).click();
        	RunnerClass.driver.findElement(Locators.turnTargetCompletionDate).clear();
        	RunnerClass.driver.findElement(Locators.turnTargetCompletionDate).sendKeys(RunnerClass.turnTargetCompletionDate);
        	RunnerClass.actions.sendKeys(Keys.ESCAPE).build().perform();
        	Thread.sleep(500);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Turn Target Completion Date";
        }
      //Turn Actual Completion Date
        try
        {
        	if(RunnerClass.turnActualCompletionDate==null)//!RunnerClass.turnActualCompletionDate.equals(""))
        		RunnerClass.turnActualCompletionDate="";
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.turnActualCompletionDate)).build().perform();
        	RunnerClass.js.executeScript("window.scrollBy(0,100)");
        	RunnerClass.driver.findElement(Locators.turnActualCompletionDate).click();
        	RunnerClass.driver.findElement(Locators.turnActualCompletionDate).clear();
        	RunnerClass.driver.findElement(Locators.turnActualCompletionDate).sendKeys(RunnerClass.turnActualCompletionDate);
        	RunnerClass.actions.sendKeys(Keys.ESCAPE).build().perform();
        	Thread.sleep(500);
        	RunnerClass.driver.findElement(By.xpath("//*[text()=\"Turn Actual Completion Date\"]")).click();
        	Thread.sleep(500);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Turn Actual Completion Date";
        }
      //Turn Actual Cost
        try {
            if (RunnerClass.turnActualCost == null) {
                RunnerClass.turnActualCost = "";
            }

            WebDriverWait wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(10)); // Use Duration instead of int
            WebElement turnActualCostElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.turnActualCost));

            RunnerClass.actions.moveToElement(turnActualCostElement).build().perform();
            RunnerClass.js.executeScript("window.scrollBy(0,100)");

            turnActualCostElement.click();
            turnActualCostElement.clear();
            turnActualCostElement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            turnActualCostElement.sendKeys(RunnerClass.turnActualCost);

            Thread.sleep(500);
           

        } catch (Exception e) {
            e.printStackTrace();
            RunnerClass.failedReason = RunnerClass.failedReason + ", Turn Actual Cost";
        }



      //Turn QC Completed Date
        try
        {
        	if(RunnerClass.turnQCCompletedDate==null)//!RunnerClass.turnQCCompletedDate.equals(""))
        		RunnerClass.turnQCCompletedDate="";
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.turnQCCompletedDate)).build().perform();
        	RunnerClass.js.executeScript("window.scrollBy(0,100)");
        	RunnerClass.driver.findElement(Locators.turnQCCompletedDate).click();
        	RunnerClass.driver.findElement(Locators.turnQCCompletedDate).clear();
        	RunnerClass.driver.findElement(Locators.turnQCCompletedDate).sendKeys(RunnerClass.turnQCCompletedDate);
        	RunnerClass.actions.sendKeys(Keys.ESCAPE).build().perform();
        	Thread.sleep(500);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Turn QC Completed Date";
        }
      //Code box Active
        try
        {
        	if(RunnerClass.codeBoxActive==null)//!RunnerClass.codeBoxActive.equals(""))
        		RunnerClass.codeBoxActive="";
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.codeBoxActive)).build().perform();
        	RunnerClass.js.executeScript("window.scrollBy(0,100)");
        	RunnerClass.driver.findElement(Locators.codeBoxActive).click();
        	RunnerClass.driver.findElement(Locators.codeBoxActive).clear();
        	RunnerClass.driver.findElement(Locators.codeBoxActive).sendKeys(RunnerClass.lockBoxCode);
        	Thread.sleep(500);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Code box Active";
        }
     //Last Vacant Visit
        try
        {
        	if(RunnerClass.lastVacantVisit==null)//!RunnerClass.lastVacantVisit.equals(""))
        		RunnerClass.lastVacantVisit="";
        	RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.lastVacantVisit)).build().perform();
        	RunnerClass.js.executeScript("window.scrollBy(0,100)");
        	RunnerClass.driver.findElement(Locators.lastVacantVisit).click();
        	RunnerClass.driver.findElement(Locators.lastVacantVisit).clear();
        	RunnerClass.driver.findElement(Locators.lastVacantVisit).sendKeys(RunnerClass.lastVacantVisit);
        	Thread.sleep(500);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Last Vacant Visit";
        }
        try
        {
        //Save Building
        if(AppConfig.saveButtonOnAndOff==false)
		{
			 RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.cancelBuilding)).build().perform();
			 RunnerClass.driver.findElement(Locators.cancelBuilding).click();
			 Thread.sleep(500);
		}
		else 
		{
			RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.saveBuilding)).build().perform();
			 RunnerClass.driver.findElement(Locators.saveBuilding).click();
			 Thread.sleep(500);
			 try
			 {
			 if(RunnerClass.driver.findElement(Locators.cancelBuilding).isDisplayed())
			 {
				 RunnerClass.failedReason = RunnerClass.failedReason + ", Building Fields Could not get updated";
				 return false;
			 }
			 }
			 catch(Exception e) {}
		}
        return true;
        }
        catch(Exception e)
        {
        	RunnerClass.failedReason = RunnerClass.failedReason + ", Building Fields Could not get updated";
        	return false;
        }
        
        
	}
	
	private static void handleAlerts() {
        try {
            Alert alert = RunnerClass.driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException ignored) {
            // Alert not present, continue with the rest of the code
        }
	}
}
