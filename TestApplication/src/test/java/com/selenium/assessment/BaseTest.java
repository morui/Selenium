package com.selenium.assessment;

import java.io.IOException;
import java.util.concurrent.TimeUnit;







import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.selenium.assessment.BrowserType;

public class BaseTest {

	protected static WebDriver driver;

	@BeforeClass
	public static void setUp(ITestContext context) throws IOException {
		
		String browserType = context.getCurrentXmlTest().getParameter("browserType");
		
		if (browserType.equalsIgnoreCase("firefox")) {

			driver = getWebDriver(BrowserType.FIREFOX);
		}

		if (browserType.equalsIgnoreCase("ie")) {

			driver = getWebDriver(BrowserType.IE);

		}

		if (browserType.equalsIgnoreCase("chrome")) {

			driver = getWebDriver(BrowserType.CHROME);
}
	}
	
	
	
	public static WebDriver getWebDriver(BrowserType browserType) throws IOException {

		switch (browserType) {
		case FIREFOX:
			// Need to implement firefox Driver stuff
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			return driver;
		case IE:
			// Need to implement IE Driver stuff
			 System.setProperty("webdriver.ie.driver", "C:\\iLab_Assessment_Selenium\\Workspace\\TestFramework\\lib\\IEDriverServer.exe");
			  driver =new InternetExplorerDriver();
			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			  driver.manage().window().maximize();
			  return driver;
		case CHROME:
			// Need to implement Chrome Driver stuff
			  System.setProperty("webdriver.chrome.driver", "C:\\iLab_Assessment_Selenium\\Workspace\\TestFramework\\lib\\chromedriver.exe");
			   driver =  new ChromeDriver();
			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			  driver.manage().window().maximize();
			  return driver;
			
		case HTMLUNIT:
			// Need to implement
			return null;
		default:
			throw new RuntimeException("Browser type unsupported");
		}

	}


	@AfterClass
	public static void tearDown() {
		driver.manage().deleteAllCookies();
		driver.close();
	}

}
