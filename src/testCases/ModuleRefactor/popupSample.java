package testCases.ModuleRefactor;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class popupSample {
	
	public static void main(String[] args){
		
		// For Selenium 3.0.0 onward, Firefox driver is required
		System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+"//BrowserDrivers//geckodriver.exe");
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		
		StopWatch pageLoad = new StopWatch();
		pageLoad.start();
		
		// Go to test URL
		driver.get("http://www.qa.globalsources.com");
		// Maximize the window 
		driver.manage().window().maximize();
		
		// Wait for the required element
		WebDriverWait wait = new WebDriverWait(driver, 15);
	//	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("keywordBtnSearch")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("keywordBtnSearch")));
		
		pageLoad.stop();
		// Get the time
		long pageLoadTime_ms = pageLoad.getTime();
		long pageLoadTime_Seconds = pageLoadTime_ms/1000;
		System.out.println("Total Page Load Time ::" + pageLoadTime_ms + "miliseconds");
		System.out.println("Total Page Load Time ::" + pageLoadTime_Seconds + "seconds");
		
		driver.close();
		
	/*	// Click on the button to trigger the popup alert
		WebElement element = driver.findElement(By.xpath("//*[@id='content']/p[8]/button"));
		element.click();
		
		// Switch to alert
		Alert alertBtn = driver.switchTo().alert();
		
		// Get popup alert message
		String alertText = alertBtn.getText();
		
		// Print alert message
		System.out.println("Print popup alert message ::" + alertText);
		
		// Accept the alert, equivalent of pressing OK
		alertBtn.accept();
		System.out.println("User is click on OK button.");
		
		
		// Click on the button again to trigger the popup alert
		element.click();
		
		// Switch to alert
		driver.switchTo().alert();
		
		// Reject the alert, equivalent of pressing Cancel
		alertBtn.dismiss();
		System.out.println("User is click on Cancel button.");
		
		// Close the driver
		driver.quit();
	*/	
	}

}
