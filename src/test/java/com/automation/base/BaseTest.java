package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.utils.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
public class BaseTest {
    protected WebDriver driver;
    protected ExtentReports extent;
    
    @BeforeSuite
    public void setupreport()
	{
		extent=ExtentManager.getinstance();
		
	}
	
	@AfterSuite
	public void flushreport()
		
	{
		System.out.println(">>> Flushing Extent Report <<<");
		extent.flush();
		
	}

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tatacliq.com/");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
