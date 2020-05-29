package mainScripts;


/*import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;*/
import java.util.concurrent.TimeUnit;

/*import org.openqa.selenium.By;*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;*/
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import commonMethods.GenericMethod;
import pageObjects.mylearning;
import driver.EnvironmentVariable;
import commonMethods.login;

public class MainScript_mylearning {
	
	static WebDriver driver;
	
	static GenericMethod gm = new GenericMethod();
	static ExtentReports reports ;
	static ExtentTest logger;
	static login ln= new login();

	@BeforeClass()
	public void Open() throws InterruptedException 
	{
		try
		{
			

			System.setProperty(EnvironmentVariable.driverType, EnvironmentVariable.driverPath);
			driver = new ChromeDriver();

			driver.get(EnvironmentVariable.URL);
			
			gm.captureScreenshot(driver);
			
			
			ln.logins(driver);
			gm.captureScreenshot(driver);
			
			driver.manage().window().maximize();
			/*driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().wait(30000);*/
			// Extend Reports 
			reports = new ExtentReports(EnvironmentVariable.reportPath);
			logger = reports.startTest("Loggin to my portal");
			
			
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority = 1, dataProvider="Datasheet")
	public void mylearning(String passengers ,String departingfrom, String onmonth, String onday, String arrivingin,
			String returnmingmonth, String returningday, String serviceclass, String preference) throws Exception 
	{
		try
		{	
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			gm.selectValueFromList(driver, mylearning.passenger, passengers, passengers, logger);
			gm.selectValueFromList(driver, mylearning.departingfrom, departingfrom, departingfrom, logger);
			gm.selectValueFromList(driver, mylearning.onmonth, onmonth, onmonth, logger);
			gm.selectValueFromList(driver, mylearning.onday, onday, onday, logger);
			gm.selectValueFromList(driver, mylearning.arrivingin, arrivingin, arrivingin, logger);
			gm.selectValueFromList(driver, mylearning.returningmonth, returnmingmonth, returnmingmonth, logger);
			gm.selectValueFromList(driver, mylearning.returningday, returningday, returningday, logger);
			gm.selectRadioButton(driver, mylearning.serviceclass, serviceclass, logger);
			gm.selectValueFromList(driver, mylearning.airlines, preference, preference, logger);
			WebElement continueclick=driver.findElement(mylearning.continue1);
			continueclick.click();
		
		}
		catch(Exception e)
		{
			gm.logfail(logger, "Exception occured:"+e.getMessage());
		}
	}

	@DataProvider(name="Datasheet")
	public Object[][] getData()
	{
		Object[][] c1 = gm.getExcelData(EnvironmentVariable.dataPoolPath, "Automate");
		return c1;		
	}

	@AfterClass
	public void tearDown()
	{
		reports.endTest(logger);
		reports.flush();
		driver.close();
	}

	
}
