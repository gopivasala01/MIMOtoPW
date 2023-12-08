package mainPackage;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertyWare 
{
	

	public static boolean signIn() {
		try
		{
		RunnerClass.downloadFilePath = AppConfig.downloadFilePath;
		Map<String, Object> prefs = new HashMap<String, Object>();
	    // Use File.separator as it will work on any OS
	    prefs.put("download.default_directory",
	    		RunnerClass.downloadFilePath);
        // Adding cpabilities to ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().clearDriverCache().setup();
        RunnerClass.driver= new ChromeDriver(options);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL); // Or PageLoadStrategy.EAGER if needed
        options.setPageLoadTimeout(Duration.ofSeconds(500));
        RunnerClass.driver.manage().window().maximize();
        RunnerClass.driver.get(AppConfig.URL);
        RunnerClass.driver.findElement(Locators.userName).sendKeys(AppConfig.username); 
        RunnerClass.driver.findElement(Locators.password).sendKeys(AppConfig.password);
        RunnerClass.driver.findElement(Locators.signMeIn).click();
        RunnerClass.actions = new Actions(RunnerClass.driver);
        RunnerClass.js = (JavascriptExecutor)RunnerClass.driver;
        RunnerClass.driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(2));
        try {
            if (RunnerClass.driver.findElement(Locators.loginError).isDisplayed()) 
            {
                System.out.println("Login failed");
                String failedReason = ", Login failed";
                
                return false;
            }
        }
        catch(Exception e) {}
        RunnerClass.driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(100));
        return true;
		}
		catch(Exception e)
		{
			System.out.println("Login failed");
		    RunnerClass.failedReason = RunnerClass.failedReason+","+ "Login failed";
			return false;
		}
	}
	
	public static boolean selectBuilding() {
	    try {
	        // Check company name contains HomeRiver Group Prefix
	        if (RunnerClass.company.toLowerCase().contains("home")) {
	            for (String companyName : AppConfig.companyNames) {
	                if (RunnerClass.company.contains(companyName)) {
	                    RunnerClass.company = companyName.trim();
	                    break;
	                }
	            }
	        }

	        // Set up implicit wait and WebDriverWait
	        RunnerClass.driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(100));

	        // Refresh the page and handle intermittent pop-ups
	       // RunnerClass.driver.navigate().refresh();
	        Thread.sleep(2000);
	        PropertyWare.intermittentPopUp();

	        // Click on the market dropdown and select market
	        RunnerClass.driver.findElement(Locators.marketDropdown).click();
	        String marketName = "HomeRiver Group - " + RunnerClass.company;
	        new Select(RunnerClass.driver.findElement(Locators.marketDropdown)).selectByVisibleText(marketName);
	        Thread.sleep(3000);

	        // Navigate to the building page URL
	        String buildingPageURL = AppConfig.buildingPageURL + RunnerClass.unitEntityID;
	        RunnerClass.driver.navigate().to(buildingPageURL);

	        // Check for permission denied page
	        if (PropertyWare.permissionDeniedPage()) {
	            System.out.println("Wrong Unit Entity ID");
	            RunnerClass.failedReason = "Wrong Unit Entity ID";
	            return false;
	        }

	        // Handle intermittent pop-ups and check if building is deactivated
	        PropertyWare.intermittentPopUp();
	        if (PropertyWare.checkIfBuildingIsDeactivated()) {
	            return false;
	        }

	        return true;
	    } catch (Exception e) {
	        RunnerClass.failedReason = "Building not found";
	        e.printStackTrace();
	        return false;
	    }
	}

	
	/*public static boolean selectLease()
	{
		try
		{
			RunnerClass.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(5));
	        RunnerClass.js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	        if(RunnerClass.driver.findElement(Locators.leasesTab).getText().equals("Leases"))
	    		RunnerClass.driver.findElement(Locators.leasesTab).click();
	    		else 
	    			RunnerClass.driver.findElement(Locators.leasesTab2).click();
	        boolean leaseAvailibilityCheck = false;
	        List<WebElement> tenantContactList = RunnerClass.driver.findElements(Locators.tenantContact);
	        List<WebElement> leaseList = RunnerClass.driver.findElements(Locators.leaseList);
	        for(int i=0;i<tenantContactList.size();i++)
	        {
	        	String tenantContact = tenantContactList.get(i).getText();
	        	if(tenantContact.trim().contains(RunnerClass.current_Resident_FirstName)&&tenantContact.trim().contains(RunnerClass.Current_Resident_LastName))
	        	{
	        		leaseList.get(i).click();
	        		PropertyWare.intermittentPopUp();
	        		leaseAvailibilityCheck = true;
	        		break;
	        	}
	        		
	        }
	        if(leaseAvailibilityCheck == false)
	        {
	        	RunnerClass.failedReason = "Lease not Available";
	        	
	        	return false;
	        }
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}*/
	
	public static void intermittentPopUp()
	{
		//Pop up after clicking lease name
				try
				{
					RunnerClass.driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
			        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(1));
			        try
			        {
					if(RunnerClass.driver.findElement(Locators.popUpAfterClickingLeaseName).isDisplayed())
					{
						RunnerClass.driver.findElement(Locators.popupClose).click();
					}
			        }
			        catch(Exception e) {}
			        try
			        {
					if(RunnerClass.driver.findElement(Locators.scheduledMaintanancePopUp).isDisplayed())
					{
						RunnerClass.driver.findElement(Locators.scheduledMaintanancePopUpOkButton).click();
					}
			        }
			        catch(Exception e) {}
			        try
			        {
			        if(RunnerClass.driver.findElement(Locators.scheduledMaintanancePopUpOkButton).isDisplayed())
			        	RunnerClass.driver.findElement(Locators.scheduledMaintanancePopUpOkButton).click();
			        }
			        catch(Exception e) {}
					RunnerClass.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(5));
				}
				catch(Exception e) {
					e.printStackTrace();}
			
	}
	
	public static boolean checkIfBuildingIsDeactivated()
	{
		//Pop up after clicking lease name
				try
				{
					RunnerClass.driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
			        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(1));
			        try
			        {
					if(RunnerClass.driver.findElement(Locators.buildingDeactivatedMessage).isDisplayed())
					{
						System.out.println("Building is Deactivated");
						RunnerClass.failedReason = "Building is Deactivated";
						RunnerClass.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(5));
			        	return true;
					}
			        }
			        catch(Exception e) {}
			        
					RunnerClass.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(5));
			        return false;
				}
				catch(Exception e) {}
				return false;
				
	}
	public static boolean permissionDeniedPage()
	{
		try
		{
		RunnerClass.driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(1));
        if(RunnerClass.driver.findElement(Locators.permissionDenied).isDisplayed())
        {
        	RunnerClass.driver.navigate().back();
        	return true;
        }
        RunnerClass.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(5));
		}
		catch(Exception e)
		{
			return false;
		}
		return false;
	}

}
