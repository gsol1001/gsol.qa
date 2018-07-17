/**
 * This Class contains methods that represent the locators available on Top Nav Menu Bar
 * Created: Tue 11 Aug 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/08/11
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on Top Nav Menu Bar.
 * @author Teng Shyh Wei
 *
 */
public class TopNav_MenuBar extends BaseClass{
	
    private static WebElement element = null;
    
    public TopNav_MenuBar(WebDriver driver){
        	super(driver);
    }
    
    // Go back to GSOL homepage
    public static WebElement lnk_backToGSOLHomePage() throws Exception{
    	try{
    		// Wait for element to be clickable
    	//	WebDriverWait wait = new WebDriverWait(driver, 15);
    	//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'GS_logo')]")));
    		
    		//img[@alt='Manufacturers & Suppliers']
    	//	element = driver.findElement(By.xpath("//div[contains(@class, 'GS_logo')]"));
    		element = driver.findElement(By.xpath("//img[@alt='Manufacturers & Suppliers']"));
    		element.click();
    		Add_Log.info("Go back to GSOL home page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Global Sources Logo is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    public static WebElement check_topMenuBarIsVisible() throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		@SuppressWarnings("unused")
    		List<WebElement> topNavList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[contains(@class, 'GS_nav_list')]")));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // ================================================ Start of Online Marketplaces at Top Navigator ===============================================
    
    /**
     * Mouse hover on menu bar Online Marketplace at Top Navigator.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement menuBar_mousehoverOnlineMarketplace() throws Exception{
    	try{
    		// Locate menu bar Online Marketplace
    		WebElement mousehoverMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Online Marketplace']"));
			
    		// Hover mouse above the menu but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(mousehoverMenu).build().perform();
    		Add_Log.info("User is mouse hover on menu bar Online Marketplace at Top Navigator.");
    	}catch(Exception e){
    		Add_Log.error("Top Navigator Online Marketplace is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on menu bar Online Marketplace to click on sub menu Auto Parts & Accessories.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement subMenu_selectAutoPartAndAccessories() throws Exception{
    	try{
    		// Wait until Top Nav menu bar is visible
    		TopNav_MenuBar.check_topMenuBarIsVisible();
    		
    		WebElement element = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Auto Parts & Accessories']"));
    		
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		Add_Log.info("Sub menu Auto Parts & Accessories is click on the page.");
    		
    	/*	Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Online Marketplace']"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Auto Parts & Accessories']"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();*/
    	}catch(Exception e){
    		Add_Log.error("Sub menu Auto Parts & Accessories is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on menu bar Online Marketplace to click on sub menu Consumer Electronics.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement subMenu_selectConsumerElectronics() throws Exception{
    	try{
    		TopNav_MenuBar.check_topMenuBarIsVisible();
    		
    		WebElement element = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Consumer Electronics']"));
    		
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		Add_Log.info("Sub menu Consumer Electronics is click on the page.");
    		
    		/*Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Online Marketplace']"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Consumer Electronics']"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();*/
    	}catch(Exception e){
    		Add_Log.error("Sub menu Consumer Electronics is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on menu bar Online Marketplace to click on sub menu Drones & Robotics.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement subMenu_selectDronesRobotics() throws Exception{
    	try{
    		TopNav_MenuBar.check_topMenuBarIsVisible();
    		
    		WebElement element = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Drones & Robotics']"));
    		
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		Add_Log.info("Sub menu Drones & Robotics is click on the page.");
    		
    		/*Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Online Marketplace']"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Drones & Robotics']"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();*/
    	}catch(Exception e){
    		Add_Log.error("Sub menu Drones & Robotics is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on menu bar Online Marketplace to click on sub menu Electronic Components.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement subMenu_selectElectronicComponents() throws Exception{
    	try{
    		TopNav_MenuBar.check_topMenuBarIsVisible();
    		
    		WebElement element = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Electronic Components']"));
    		
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		Add_Log.info("Sub menu Electronic Components is click on the page.");
    		
    		/*Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Online Marketplace']"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Electronic Components']"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();*/
    	}catch(Exception e){
    		Add_Log.error("Sub menu Electronic Components is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on menu bar Online Marketplace to click on sub menu Fashion Accessories & Footwear.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement subMenu_selectFashionAccessoriesAndFootwear() throws Exception{
    	try{
    		TopNav_MenuBar.check_topMenuBarIsVisible();
    		
    		WebElement element = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Fashion Accessories & Footwear']"));
    		
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		Add_Log.info("Sub menu Fashion Accessories & Footwear is click on the page.");
    		
    		/*Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Online Marketplace']"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Fashion Accessories & Footwear']"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();*/
    	}catch(Exception e){
    		Add_Log.error("Sub menu Fashion Accessories & Footwear is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on menu bar Online Marketplace to click on sub menu Fashion Apparel & Fabrics.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement subMenu_selectFashionApparelAndFabrics() throws Exception{
    	try{
    		TopNav_MenuBar.check_topMenuBarIsVisible();
    		
    		WebElement element = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Fashion Apparel & Fabrics']"));
    		
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		Add_Log.info("Sub menu Fashion Apparel & Fabrics is click on the page.");
    		
    		/*Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Online Marketplace']"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Fashion Apparel & Fabrics']"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();*/
    	}catch(Exception e){
    		Add_Log.error("Sub menu Fashion Apparel & Fabrics is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on menu bar Online Marketplace to click on sub menu Gifts & Premiums.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement subMenu_selectGiftsAndPremiums() throws Exception{
    	try{
    		TopNav_MenuBar.check_topMenuBarIsVisible();
    		
    		WebElement element = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Gifts & Premiums']"));
    		
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		Add_Log.info("Sub menu Gifts & Premiums is click on the page.");
    		
    		/*Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Online Marketplace']"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Gifts & Premiums']"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();*/
    	}catch(Exception e){
    		Add_Log.error("Sub menu Gifts & Premiums is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on menu bar Online Marketplace to click on sub menu Hardware.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement subMenu_selectHardware() throws Exception{
    	try{
    		TopNav_MenuBar.check_topMenuBarIsVisible();
    		
    		WebElement element = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Hardware']"));
    		
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		Add_Log.info("Sub menu Hardware is click on the page.");
    		
    		/*Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Online Marketplace']"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Hardware']"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();*/
    	}catch(Exception e){
    		Add_Log.error("Sub menu Hardware is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on menu bar Online Marketplace to click on Home Products.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement subMenu_selectHomeProducts() throws Exception{
    	try{
    		TopNav_MenuBar.check_topMenuBarIsVisible();
    		
    		WebElement element = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Home Products']"));
    		
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		Add_Log.info("Sub menu Home Products is click on the page.");
    		
    		/*Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Online Marketplace']"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Home Products']"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();   */     		
    	}catch(Exception e){
    		Add_Log.error("Sub menu Home Products is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on menu bar Online Marketplace to click on LED & Solar Products.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement subMenu_selectLEDAndSolarProducts() throws Exception{
    	try{
    		TopNav_MenuBar.check_topMenuBarIsVisible();
    		
    		WebElement element = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='LED & Solar Products']"));
    		
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		Add_Log.info("Sub menu LED & Solar Products is click on the page.");
    		
    		/*Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Online Marketplace']"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='LED & Solar Products']"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();*/
    	}catch(Exception e){
    		Add_Log.error("Sub menu LED & Solar Products is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on menu bar Online Marketplace to click on LEDs & Optoelectronics.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement subMenu_selectLEDsAndOptoelectronics() throws Exception{
    	try{
    		TopNav_MenuBar.check_topMenuBarIsVisible();
    		
    		WebElement element = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='LEDs & Optoelectronics']"));
    		
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		Add_Log.info("Sub menu LEDs & Optoelectronics is click on the page.");
    		
    		/*Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Online Marketplace']"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='LEDs & Optoelectronics']"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();*/
    	}catch(Exception e){
    		Add_Log.error("Sub menu LEDs & Optoelectronics is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on menu bar Online Marketplace to click on Machinery & Parts.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement subMenu_selectMachineryAndParts() throws Exception{
    	try{
    		TopNav_MenuBar.check_topMenuBarIsVisible();
    		
    		WebElement element = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Machinery & Parts']"));
    		
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		Add_Log.info("Sub menu Machinery & Parts is click on the page.");
    		
    		/*Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Online Marketplace']"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Machinery & Parts']"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();*/
    	}catch(Exception e){
    		Add_Log.error("Sub menu Machinery & Parts is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on menu bar Online Marketplace to click on Mobile Electronics.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement subMenu_selectMobileElectronics() throws Exception{
    	try{
    		TopNav_MenuBar.check_topMenuBarIsVisible();
    		
    		WebElement element = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Mobile Electronics']"));
    		
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		Add_Log.info("Sub menu Mobile Electronics is click on the page.");
    		
    		/*Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Online Marketplace']"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Mobile Electronics']"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();*/
    	}catch(Exception e){
    		Add_Log.error("Sub menu Mobile Electronics is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on menu bar Online Marketplace to click on Security Products.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement subMenu_selectSecurityProducts() throws Exception{
    	try{
    		TopNav_MenuBar.check_topMenuBarIsVisible();
    		
    		WebElement element = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Security Products']"));
    		
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		Add_Log.info("Sub menu Security Products is click on the page.");
    		
    		/*Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Online Marketplace']"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Security Products']"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();*/
    	}catch(Exception e){
    		Add_Log.error("Sub menu Security Products is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on menu bar Online Marketplace to click on Smart Living.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement subMenu_selectSmartLiving() throws Exception{
    	try{
    		TopNav_MenuBar.check_topMenuBarIsVisible();
    		
    		WebElement element = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Smart Living']"));
    		
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		Add_Log.info("Sub menu Smart Living is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Sub menu Smart Living is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on menu bar Online Marketplace to click on Underwear & Swimwear.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement subMenu_selectUnderwearAndSwimwear() throws Exception{
    	try{
    		TopNav_MenuBar.check_topMenuBarIsVisible();
    		
    		WebElement element = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Underwear & Swimwear']"));
    		
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		Add_Log.info("Sub menu Underwear & Swimwear is click on the page.");
    		
    		/*Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Online Marketplace']"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Underwear & Swimwear']"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();*/
    	}catch(Exception e){
    		Add_Log.error("Sub menu Underwear & Swimwear is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on menu bar Trade Shows at Top Navigator.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement menuBar_mousehoverOnTradeShows() throws Exception{
    	try{
    		// Locate menu bar Trade Shows
    		WebElement mousehoverMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_item')][contains(text(),'Trade Shows')]"));
			
    		// Hover mouse above the menu but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(mousehoverMenu).build().perform();
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // ==================================================== Start of Magazines at Top Navigator =====================================================
    
    /**
     * Mouse hover on menu bar Smart Sourcing at Top Navigator.
     * 16-Aug-2017 MR#47265 Change from "Magazines" to "Smart Sourcing"
     * 
     * @return
     * @throws Exception
     */
    public static WebElement menuBar_mousehoverOnSmartSourcing() throws Exception{
    	try{
    		// Locate menu bar Magazines
    		WebElement mousehoverMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_item')][contains(text(),'Smart Sourcing')]"));
    	//			By.xpath("//*[contains(@class, 'GS_nav_item')][contains(text(),'Magazines')]"));
			
    		// Hover mouse above the menu but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(mousehoverMenu).build().perform();
    		Add_Log.info("User is mouse hover on menu bar Smart Sourcing at Top Navigator.");
    	}catch(Exception e){
    		Add_Log.error("Top Navigator Smart Sourcing is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Mouse hover on menu bar 'Smart Sourcing' to click on sub menu Analyst's Choice.
    public static WebElement subMenu_selectAnalystsChoice() throws Exception{
    	try{
    		Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("(//*[contains(@class, 'GS_nav_list')]//a[contains(text(),'Smart Sourcing')])"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("(//*[contains(@class, 'GS_globalNav_pop GS_nav_pop')]//a[contains(text(),\"Analyst's Choice\")])"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
    		Add_Log.info("Sub menu Analyst's Choice is click on the page.");
    	}catch(Exception e){
    		Add_Log.error("Sub menu Analyst's Choice is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on menu bar 'Smart Sourcing' to click on sub menu 'Sourcing News & Advice'.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement subMenu_selectSourcingNewsAndAdvice() throws Exception{
    	try{
    		Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("(//*[contains(@class, 'GS_nav_list')]//a[contains(text(),'Smart Sourcing')])"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("(//*[contains(@class, 'GS_globalNav_pop GS_nav_pop')]//a[contains(text(),'Sourcing News & Advice')])"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
    		Add_Log.info("Sub menu Sourcing News & Advice is click on the page.");
    	}catch(Exception e){
    		Add_Log.error("Sub menu Sourcing News & Advice is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Mouse hover on menu bar 'Smart Sourcing' to click on sub menu 'New Sourcing Markets'
    public static WebElement subMenu_selectNewSourcingMarkets() throws Exception{
    	try{
    		Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_item')][contains(text(),'Smart Sourcing')]"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_globalNav_pop GS_nav_pop')]//a[text()='New Sourcing Markets']"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
    		Add_Log.info("Sub menu New Sourcing Markets is click on the page.");
    	}catch(Exception e){
    		Add_Log.error("Sub menu New Sourcing Markets is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on menu bar 'Smart Sourcing' to click on sub menu Sourcing Reports.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement subMenu_selectSourcingReports() throws Exception{
    	try{
    		Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_item')][contains(text(),'Smart Sourcing')]"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_globalNav_pop GS_nav_pop')]//a[text()='Sourcing Reports']"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
    		Add_Log.info("Sub menu Sourcing Reports is click on the page.");
    	}catch(Exception e){
    		Add_Log.error("Sub menu Sourcing Reports is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Mouse hover on menu bar 'Smart Sourcing' to click on sub menu 'Global Sources Summit'.
    public static WebElement subMenu_selectGlobalSourcesSummit() throws Exception{
    	try{
    		Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("(//*[contains(@class, 'GS_nav_list')]//a[contains(text(),'Smart Sourcing')])"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("(//*[contains(@class, 'GS_globalNav_pop GS_nav_pop')]//a[contains(text(),'Global Sources Summit')])"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
    		Add_Log.info("Sub menu Global Sources Summit is click on the page.");
    	}catch(Exception e){
    		Add_Log.error("Sub menu Global Sources Summit is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on menu bar 'Smart Sourcing' to click on sub menu 'Buyer Support'.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement subMenu_selectBuyerSupport() throws Exception{
    	try{
    		Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("(//*[contains(@class, 'GS_nav_list')]//a[contains(text(),'Smart Sourcing')])"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("(//*[contains(@class, 'GS_globalNav_pop GS_nav_pop')]//a[contains(text(),'Buyer Support')])"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
    		Add_Log.info("Sub menu Buyer Support is click on the page.");
    	}catch(Exception e){
    		Add_Log.error("Sub menu Buyer Support is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // ================================================== Start of Other Services at Top Navigator ==================================================
    
    /**
     * Mouseover on menu bar Other Services at Top Navigator.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement menuBar_mousehoverOnOtherServices() throws Exception{
    	try{
    		// Locate menu bar Other Services
    		WebElement mousehoverMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Other Services']"));
			
    		// Hover mouse above the menu but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(mousehoverMenu).build().perform();
    		Add_Log.info("User is mouse hover on menu bar Other Services at Top Navigator.");
    	}catch(Exception e){
    		Add_Log.error("Top Navigator Other Services is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on menu bar 'Other Service' to click on sub menu 'RFQ'.
     * MR#46624 21-Jun-2017 Copy "Get Quotations" changed to "RFQ" 
     *    
     * @return
     * @throws Exception
     */
    public static WebElement subMenu_selectRFQ() throws Exception{
    	try{
    		Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("(//*[contains(@class, 'GS_nav_list')]//a[contains(text(),'Other Services')])"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("(//*[contains(@class, 'GS_globalNav_pop GS_nav_pop')]//a[contains(text(),'RFQ')])"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
    		Add_Log.info("Sub menu RFQ is click on the page.");
    	}catch(Exception e){
    		Add_Log.error("Sub menu RFQ is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on menu bar 'Other Service' to click on sub menu 'Product Alerts'.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement subMenu_selectProductAlerts() throws Exception{
    	try{
    		Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("(//*[contains(@class, 'GS_nav_list')]//a[contains(text(),'Other Services')])"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("(//*[contains(@class, 'GS_globalNav_pop GS_nav_pop')]//a[contains(text(),'Product Alerts')])"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
    		Add_Log.info("Sub menu Product Alerts is click on the page.");
    	}catch(Exception e){
    		Add_Log.error("Sub menu Product Alerts is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on menu bar 'Other Service' to click on sub menu Magazines.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement subMenu_selectMagazines() throws Exception{
    	try{
    		// 15-Aug-2017 MR#47265
    	/*	WebDriverWait waits = new WebDriverWait(driver, 20);
    		waits.until(ExpectedConditions.visibilityOfElementLocated(
    				By.xpath("//*[contains(@class, 'GS_nav_item')][text()='Magazines']")));
    		
    		Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_item')][text()='Magazines']"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_globalNav_pop GS_nav_pop')]//a[text()='Magazines']"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
    	*/	
    		WebDriverWait waits = new WebDriverWait(driver, 20);
    		waits.until(ExpectedConditions.visibilityOfElementLocated(
    				By.xpath("//*[contains(@class, 'GS_nav_item')][text()='Other Services']")));
    		
    		Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_nav_item')][text()='Other Services']"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_globalNav_pop GS_nav_pop')]//a[text()='Magazines']"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
    		Add_Log.info("Sub menu Magazines is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Sub menu Magazines is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on menu bar 'Other Service' to click on sub menu 'Private Sourcing Events'.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement subMenu_selectPrivateSourcingEvents() throws Exception{
    	try{
    		Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("(//*[contains(@class, 'GS_nav_list')]//a[contains(text(),'Other Services')])"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("(//*[contains(@class, 'GS_globalNav_pop GS_nav_pop')]//a[contains(text(),'Private Sourcing Events')])"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
    		Add_Log.info("Sub menu Private Sourcing Events is click on the page.");
    	}catch(Exception e){
    		Add_Log.error("Sub menu Private Sourcing Events is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on menu bar 'Other Service' to click on sub menu 'About Us'.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement subMenu_selectAboutUs() throws Exception{
    	try{
    		Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("(//*[contains(@class, 'GS_nav_list')]//a[contains(text(),'Other Services')])"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("(//*[contains(@class, 'GS_globalNav_pop GS_nav_pop')]//a[contains(text(),'About Us')])"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
    		Add_Log.info("Sub menu About Us is click on the page.");
    	}catch(Exception e){
    		Add_Log.error("Sub menu About Us is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    

    // ==================================================== Start of Online Marketplace Top Nav =======================================================
    
    /**
     * To verify Auto Parts & Accessories page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_autoPartsAndAccessoriesPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Auto Parts & Accessories Manufacturers & Suppliers | Global Sources"));
    		
    		if(driver.getTitle().equals("Auto Parts & Accessories Manufacturers & Suppliers | Global Sources")){
    			Add_Log.info("Auto Parts & Accessories page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_AUTO_PARTS_ACCESSORIES_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Auto Parts & Accessories page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_AUTO_PARTS_ACCESSORIES_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Auto Parts & Accessories page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify Consumer Electronics page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_consumerElectronicsPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Consumer Electronics Manufacturers & Suppliers | Global Sources"));
    		    	
    		if(driver.getTitle().equals("Consumer Electronics Manufacturers & Suppliers | Global Sources")){
    			Add_Log.info("Consumer Electronics page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_CONSUMER_ELECTRONICS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Consumer Electronics page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_CONSUMER_ELECTRONICS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Consumer Electronic page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify Drones & Robotics page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_dronesRoboticsPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Drones & Robotics Manufacturers & Suppliers | Global Sources"));
    		
    		if(driver.getTitle().equals("Drones & Robotics Manufacturers & Suppliers | Global Sources")){
    			Add_Log.info("Drones & Robotics page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_DRONES_ROBOTICS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Drones & Robotics page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_DRONES_ROBOTICS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Drones & Robotics page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify Electronic Components page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_electronicComponentsPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Electronic Components Manufacturers & Suppliers | Global Sources"));
    		
    		if(driver.getTitle().equals("Electronic Components Manufacturers & Suppliers | Global Sources")){
    			Add_Log.info("Electronic Components page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ELECTRONIC_COMPONENTS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Electronic Components page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ELECTRONIC_COMPONENTS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Electronic Components page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify Fashion Accessories & Footwear page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_fashionAccessoriesAndFootwearPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Fashion Accessories & Footwear Manufacturers & Suppliers | Global Sources"));
    		
    		if(driver.getTitle().equals("Fashion Accessories & Footwear Manufacturers & Suppliers | Global Sources")){
    			Add_Log.info("Fashion Accessories & Footwear page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_FASHION_ACCESSORIES_FOOTWEAR_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Fashion Accessories & Footwear page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_FASHION_ACCESSORIES_FOOTWEAR_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Fashion & Footwear page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify Fashion Apparel & Fabrics page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_fashionApparelAndFabricsPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Fashion Apparel & Fabrics Manufacturers & Suppliers | Global Sources"));
    		
    		if(driver.getTitle().equals("Fashion Apparel & Fabrics Manufacturers & Suppliers | Global Sources")){
    			Add_Log.info("Fashion Apparel & Fabrics page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_FASHION_APPAREL_FABRICS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Fashion Apparel & Fabrics page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_FASHION_APPAREL_FABRICS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Fashion Apparel & Fabrics page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify Gifts & Premiums page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_giftsAndPremiumsPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Gifts & Premiums Manufacturers & Suppliers | Global Sources"));
    		    	
    		if(driver.getTitle().equals("Gifts & Premiums Manufacturers & Suppliers | Global Sources")){
    			Add_Log.info("Gifts & Premiums page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_GIFTS_PREMIUMS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Gifts & Premiums page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_GIFTS_PREMIUMS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Gifts & Premiums page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify Hardware page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_hardwarePageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Hardware Manufacturers & Suppliers | Global Sources"));
    		    	
    		if(driver.getTitle().equals("Hardware Manufacturers & Suppliers | Global Sources")){
    			Add_Log.info("Hardware page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_HARDWARE_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Hardware page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_HARDWARE_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.info("Hardware page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify Home Products page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_homeProductsPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Home Products Manufacturers & Suppliers | Global Sources"));
    		    	
    		if(driver.getTitle().equals("Home Products Manufacturers & Suppliers | Global Sources")){
    			Add_Log.info("Home Products page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_HOME_PRODUCTS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Home Products page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_HOME_PRODUCTS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Home Products page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify LED & Solar Products page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_LEDAndSolarProductsPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("LED & Solar Product suppliers & exporters from mainland China, Hong Kong, Taiwan & the world"));
    		    	
    		if(driver.getTitle().equals("LED & Solar Product suppliers & exporters from mainland China, Hong Kong, Taiwan & the world")){
    			Add_Log.info("LED & Solar Products page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_LED_SOLAR_PRODUCTS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("LED & Solar Products page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_LED_SOLAR_PRODUCTS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("LED & Solar Products page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify LEDs & Optoelectronics page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_LEDsAndOptoelectronicsPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("LED & Optoelectronic suppliers & exporters from mainland China, Hong Kong, Taiwan & the world"));
    		    	
    		if(driver.getTitle().equals("LED & Optoelectronic suppliers & exporters from mainland China, Hong Kong, Taiwan & the world")){
    			Add_Log.info("LEDs & Optoelectronics page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_LED_OPTOELECTRONICS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("LEDs & Optoelectronics page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_LED_OPTOELECTRONICS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("LEDs & Optoelectronics page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify Machinery & Parts page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_machineryAndPartsPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Machinery & Parts Manufacturers & Suppliers | Global Sources"));
    		    	
    		if(driver.getTitle().equals("Machinery & Parts Manufacturers & Suppliers | Global Sources")){
    			Add_Log.info("Machinery & Parts page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MACHINERY_PARTS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Machinery & Parts page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MACHINERY_PARTS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Machinery & Parts page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify Mobile Electronics page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_mobileElectronicsPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Mobile Electronics Manufacturers & Suppliers | Global Sources"));
    		    	
    		if(driver.getTitle().equals("Mobile Electronics Manufacturers & Suppliers | Global Sources")){
    			Add_Log.info("Mobile Electronics page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MOBILE_ELECTRONICS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Mobile Electronics page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MOBILE_ELECTRONICS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Mobile Electronics page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify Security Products page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_securityProductsPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Security Products Manufacturers & Suppliers | Global Sources"));
    		    	
    		if(driver.getTitle().equals("Security Products Manufacturers & Suppliers | Global Sources")){
    			Add_Log.info("Security Products page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SECURITY_PRODUCTS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Security Products page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SECURITY_PRODUCTS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Security Products page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify Smart Living page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_smartLivingPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Smart Living Manufacturers & Suppliers | Global Sources"));
    		    	
    		if(driver.getTitle().equals("Smart Living Manufacturers & Suppliers | Global Sources")){
    			Add_Log.info("Smart Living page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SMART_LIVING_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Smart Living page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SMART_LIVING_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Smart Living page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify Underwear & Swimwear page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_underwearAndSwimwearPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Underwear & Swimwear suppliers & exporters from mainland China, Hong Kong, Taiwan & the world"));
    		    	
    		if(driver.getTitle().equals("Underwear & Swimwear suppliers & exporters from mainland China, Hong Kong, Taiwan & the world")){
    			Add_Log.info("Underwear & Swimwear page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_UNDERWEAR_SWIMWEAR_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Underwear & Swimwear page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_UNDERWEAR_SWIMWEAR_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Underwear & Swimwear page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    // ==================================================== End of Online Marketplace Top Nav =======================================================
    
    // ==================================================== Start of Smart Sourcing Top Nav =========================================================
    
    // To verify Analyst's Choice page is displayed.
    public static WebElement check_analystsChoicePageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Analyst's Choice for new, cool & innovative products from China and Asia | Global Sources"));
    		    	
    		if(driver.getTitle().equals("Analyst's Choice for new, cool & innovative products from China and Asia | Global Sources")){
    			Add_Log.info("Analyst's Choice page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ANALYSTS_CHOICE_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Analyst's Choice page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ANALYSTS_CHOICE_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Analyst's Choice page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify Sourcing News & Advice page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_sourcingNewsAndAdvicePageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("China Sourcing News, Import Advice & New Products | Global Sources"));
    		    	
    		if(driver.getTitle().equals("China Sourcing News, Import Advice & New Products | Global Sources")){
    			Add_Log.info("Sourcing News & Advice page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SOURCING_NEWS_ADVICE_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Sourcing News & Advice page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SOURCING_NEWS_ADVICE_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Sourcing News & Advice page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    // To verify New Sourcing Markets page is displayed.
    public static WebElement check_newSourcingMarketsPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("New Sourcing Markets"));
    		    	
    		if(driver.getTitle().equals("New Sourcing Markets")){
    			Add_Log.info("New Sourcing Markets page is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_NEW_SOURCING_MARKETS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("New Sourcing Markets page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_NEW_SOURCING_MARKETS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("New Sourcing Markets page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify Sourcing Report page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_sourcingReportsPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// title before: Research on Market Trends | China Sourcing Reports
    		// Date 29-Dec-15: Developing Country Sourcing Developing Country Sourcing - Essential Sourcing Intelligence
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Research on Market Trends | China Sourcing Reports"));
    		    	
    		if(driver.getTitle().equals("Research on Market Trends | China Sourcing Reports")){
    			Add_Log.info("Sourcing Reports page is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SOURCING_REPORTS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Sourcing Reports page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SOURCING_REPORTS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Sourcing Report page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    // To verify Global Sources Summit page is displayed.
    public static WebElement check_GlobalSourcesSummitPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleContains("Global Sources Summit"));
    		
    		if(driver.getTitle().contains("Global Sources Summit")){
    			Add_Log.info("Global Sources Summit page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_GS_SUMMIT_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Global Sources Summit page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_GS_SUMMIT_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Global Sources Summit page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify Buyer Support page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_buyerSupportPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Top China sourcing advice for buyers"));
    		    	
    		if(driver.getTitle().equals("Top China sourcing advice for buyers")){
    			Add_Log.info("Buyer Support page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BUYER_SUPPORT_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Buyer Support page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BUYER_SUPPORT_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Buyer Support page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    // ===================================================== End of Smart Sourcing Top Nav ==========================================================
    
    // ===================================================== Start of Other Services Top Nav ========================================================
    
    /**
     * To verify Request For Quotations (RFQ) page displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_getRequestForQuotationsPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{    		
    	//	String pageTitle = "MessageCenter - Global Sources";
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("MessageCenter - Global Sources"));
    		
    		if(driver.getTitle().equals("MessageCenter - Global Sources")){
    			Add_Log.info("Request For Quotations (RFQ) page is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_GET_QUOTATIONS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Request For Quotations (RFQ) page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_GET_QUOTATIONS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Request For Quotations (RFQ) page is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Product Alerts page is displayed. (Non-login user)
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_productAlertsPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		String productAlertTitle = driver.findElement(By.xpath("//*[contains(@class, 'PA_MT_tit')]")).getText();
    		// 12-Jul-2017 MR#47152 Updating the PA marketing page
    	//	String expectedTitle = "Get notified of new products with Product Alert";
    		String expectedTitle = "Receive new product updates with Product Alert";
    		Add_Log.info("Page title ::" + productAlertTitle);
    		
    		if(productAlertTitle.equals(expectedTitle)){
    			Add_Log.info("Product Alerts page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PRODUCT_ALERTS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Product Alerts page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PRODUCT_ALERTS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Product Alert page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify Product Alerts page is displayed. (Logged-in user)
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_productAlertsPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
       		WebDriverWait wait = new WebDriverWait(driver, 25);
       		wait.until(ExpectedConditions.titleIs("Global Sources - Product Alert"));
       		    	
       		if(driver.getTitle().equals("Global Sources - Product Alert")){
    			Add_Log.info("Product Alerts page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PRODUCT_ALERTS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
       		}else{
    			Add_Log.info("Product Alerts page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PRODUCT_ALERTS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
       		}

    	}catch(Exception e){
    		Add_Log.error("Product Alert page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify Magazines page is displayed. (non-logged in user)
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_magazinesPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Sourcing Magazines"));
    		    	
    		if(driver.getTitle().equals("Sourcing Magazines")){
    			Add_Log.info("Magazines page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MAGAZINES_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Magazines page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MAGAZINES_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Magazines page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    // To verify Magazines page is displayed. (Logged-in user)
    public static WebElement check_magazinesPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail)throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Global Sources - Sourcing Magazines"));
    		
    		if(driver.getTitle().equals("Global Sources - Sourcing Magazines")){
    			Add_Log.info("Magazines page is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MAGAZINES_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Magazines page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MAGAZINES_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    		
    	}catch(Exception e){
    		Add_Log.error("Magazines page is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Private Sourcing Events page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_privateSourcingEventsPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Private Sourcing Events | Global Sourcing for big volume buyers"));
    		    	
    		if(driver.getTitle().equals("Private Sourcing Events | Global Sourcing for big volume buyers")){
    			Add_Log.info("Private Sourcing Events page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PRIVATE_SOURCING_EVENT_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Private Sourcing Events page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PRIVATE_SOURCING_EVENT_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Private Sourcing Event page is NOT found on the page.");
    		throw(e);
    	}
       	return element;
    }
    
    /**
     * To verify GS About Us page is displayed.
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_aboutUsPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Global Sources - Corporate Information"));
    		    	
    		if(driver.getTitle().equals("Global Sources - Corporate Information")){
    			Add_Log.info("About Us page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ABOUT_US_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("About Us page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ABOUT_US_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("About Us page is not found on the page");    		
    		throw(e);
       	}
       	return element;
    } 
    
    // ====================================================== End of Other Services Top Nav =========================================================
    
    // ===================================================== Start of Top Nav Verification ==========================================================
    
    /**
     * In Top Navigator, verify that the following links are available in sequence:
     * <p><ul>
     * <li>Online Marketplace
     * <li>Trade Shows
     * <li>Smart Sourcing
     * <li>Other Services
     * </ul></p>
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */ 
    public static WebElement check_sequenceTopNavAreCorrect(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> topNavList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[contains(@class, 'GS_nav_list')]")));
    		
    		List<String> topNavNameList = new ArrayList<String>();
			for (WebElement element : topNavList){
				Add_Log.info("topNavNameList ::" + element.getText());
				topNavNameList.add(element.getText());
			}	
			
			String[] expectedTopNavList = {"Online Marketplace", "Trade Shows", "Smart Sourcing", "Other Services"};
    		
    		List<String> expMenuTopNav = Arrays.asList(expectedTopNavList);
    		if(expMenuTopNav.equals(topNavNameList)){
    			Add_Log.info("In top navigator, menu Online Marketplace, Trade Shows, Smart Sourcing and Other Service are available in sequence");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_TOP_NAV_ARE_IN_SEQUENCE_, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("In top navigator, menu Online Marketplace, Trade Shows, Smart Sourcing and Other Service are NOT available in sequence");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_TOP_NAV_ARE_IN_SEQUENCE_, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
	/**
	 * To verify all the product verticals listing is displayed under the Online Marketplace link.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @return
	 * @throws Exception
	 */
	public static WebElement check_subMenuOnlineMarketplaceAvailable(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 15);
			List<WebElement> onlineMarketplaceList = wait.
					until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
							By.xpath("//*[contains(@class, 'GS_globalNav_pop GS_nav_pop GS_nav_omPop')]//li")));
			
			List<String> onlineMarketplaceNameList = new ArrayList<String>();
			for (WebElement element : onlineMarketplaceList){
				Add_Log.info("Online Marketplace List ::" + element.getText());
				onlineMarketplaceNameList.add(element.getText());
			}	
			
			// To verify all the product verticals listing is displayed under the Online Marketplace link.
			String[] expectedOnlineMarketplace = {"Auto Parts & Accessories", "Consumer Electronics", "Drones & Robotics",
					"Electronic Components", "Fashion Accessories & Footwear", "Fashion Apparel & Fabrics", "Gifts & Premiums", 
					"Hardware", "Home Products", "LED & Solar Products", "LEDs & Optoelectronics", "Machinery & Parts", 
					"Mobile Electronics", "Security Products", "Smart Living", "Underwear & Swimwear"};
			
    		List<String> expSubMenuOnlineMarketplace = Arrays.asList(expectedOnlineMarketplace);
    		if(expSubMenuOnlineMarketplace.containsAll(onlineMarketplaceNameList)){
    			Add_Log.info("All the product verticals listing is displayed under the Online Marketplace link.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUB_MENU_ONLINE_MARKETPLACE_AVAILABLE, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("All the product verticals listing is NOT displayed under the Online Marketplace link.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUB_MENU_ONLINE_MARKETPLACE_AVAILABLE, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
		}catch(Exception e){
			Add_Log.error("Sub menu Online Marketplace are NOT found on the page");
    		throw(e);
    	}
    	return element;
	}

	/**
	 * To verify Global Sources Exhibitions, Electronics, Mobile Electronics, Gifts & Home, Fashion, Hardware & Machinery and 
	 * Other Trade Shows are displayed under the Trade Shows link.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @return
	 * @throws Exception
	 */
    public static WebElement check_subMenuTradeShowsAvailable(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> tradeShowsList = wait.
    				until(ExpectedConditions.presenceOfAllElementsLocatedBy(
    						By.xpath("//*[contains(@class, 'GS_globalNav_pop GS_nav_pop')]/ul/li[2]/ul/li/a")));
    		
    		List<String> tradeShowNameList = new ArrayList<String>();
			for (WebElement element : tradeShowsList){
				Add_Log.info("Trade Show List ::" + element.getText());
				tradeShowNameList.add(element.getText());
			}	
				
    		String[] expTradeShowsList = {"Global Sources Exhibitions", "Electronics", "Mobile Electronics", "Gifts & Home", 
    				"Fashion", "Hardware & Machinery", "Other Trade Shows"};
    		
    		List<String> expSubMenuTradeShows = Arrays.asList(expTradeShowsList);
    		if(expSubMenuTradeShows.equals(tradeShowNameList)){
    			Add_Log.info("Global Sources Exhibitions, Electronics, Mobile Electronics, Gifts & Home, Fashion, Hardware & Machinery and "
    					+ "Other Trade Shows are displayed under the Trade Shows link.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUB_MENU_TRADE_SHOWS_AVAILABLE, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Global Sources Exhibitions, Electronics, Mobile Electronics, Gifts & Home, Fashion, Hardware & Machinery and "
    					+ "Other Trade Shows are NOT displayed under the Trade Shows link.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUB_MENU_TRADE_SHOWS_AVAILABLE, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Sub menu Trade Shows are NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Magazines and Sourcing Reports are displayed under the Magazines Link.
     * 16-Aug-2017 MR#47265 Change from "Magazines" to "Smart Sourcing"
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_subMenuSmartSourcingAvailable(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		// 09-Mar-2017 //*[contains(@class, 'GS_globalNav clearfix')]/ul/li[3]/ul/li
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> smartSourcingList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[@id='mobile_GS_nav']/li[3]/ul/li")));
    		
    		List<String> smartSourcingNameList = new ArrayList<String>();
			for (WebElement element : smartSourcingList){
				Add_Log.info("Smart Sourcing List ::" + element.getText());
				smartSourcingNameList.add(element.getText());
			}	
			
			String[] expSmartSourcingList = {"Analyst's Choice", "Sourcing News & Advice", "New Sourcing Markets", 
					"Sourcing Reports", "Global Sources Summit", "Buyer Support"};
			
    		List<String> expSubMenuSmartSourcing = Arrays.asList(expSmartSourcingList);
    		if(expSubMenuSmartSourcing.containsAll(smartSourcingNameList)){
    			Add_Log.info("Analyst's Choice, Sourcing News & Advice, New Sourcing Markets, Sourcing Reports, "
    					+ "Global Sources Summit and Buyer Support are displayed under the Smart Sourcing Link.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUB_MENU_SMART_SOURCING_AVAILABLE, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Analyst's Choice, Sourcing News & Advice, New Sourcing Markets, Sourcing Reports, "
    					+ "Global Sources Summit and Buyer Support are NOT displayed under the Smart Sourcing Link.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUB_MENU_SMART_SOURCING_AVAILABLE, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Sub menu Smart Sourcing are NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
	/**
	 * To verify Get Quotations, Product Alerts, Analyst's Choice, Private Sourcing Events, Sourcing News & Advice, Buyer Support and About Us
	 * are displayed under the Other Service link. 
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @return
	 * @throws Exception
	 */
    public static WebElement check_subMenuOtherServiceAvailable(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// 09-Mar-2017 //*[contains(@class, 'GS_globalNav clearfix')]/ul/li[4]/ul/li
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> otherServicesList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[@id='mobile_GS_nav']/li[4]/ul/li")));
    		
    		List<String> otherServicesNameList = new ArrayList<String>();
			for (WebElement element : otherServicesList){
				Add_Log.info("Other Service List ::" + element.getText());
				otherServicesNameList.add(element.getText());
			}	
			
    	//	String[] expOtherServiceList = {"Product Alerts", "Sourcing News & Advice", "Private Sourcing Events", "Buyer Support", "About Us"};	
    	//	String[] expOtherServiceList = {"Get Quotations", "Product Alerts", "Analyst's Choice", "Private Sourcing Events", "Sourcing News & Advice", "Buyer Support", "About Us"};
    	//	String[] expOtherServiceList = {"Get Quotations", "Product Alerts", "Analyst's Choice", "Sourcing News & Advice", "New Sourcing Markets", "Private Sourcing Events", "Buyer Support", "About Us"};
			// 16-Aug-2017 MR#47265
    	//	String[] expOtherServiceList = {"RFQ", "Product Alerts", "Analyst's Choice", "Sourcing News & Advice", "New Sourcing Markets", "Private Sourcing Events", "Buyer Support", "About Us"};
    		String[] expOtherServiceList = {"RFQ", "Product Alerts", "Magazines", "Private Sourcing Events", "About Us"};
    		
    		List<String> expSubMenuOtherService = Arrays.asList(expOtherServiceList);
    		if(expSubMenuOtherService.containsAll(otherServicesNameList)){
    			Add_Log.info("RFQ, Product Alerts, Magazines, Private Sourcing Events and About Us are displayed under the Other Service menu.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUB_MENU_OTHER_SERVICE_AVAILABLE, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("RFQ, Product Alerts, Magazines, Private Sourcing Events and About Us are NOT displayed under the Other Service menu.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUB_MENU_OTHER_SERVICE_AVAILABLE, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Sub menu Other Services are NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Temp to test GSOL Refactor.
    public static WebElement check_subMenuOtherServiceAvailable1(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> otherServicesList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[contains(@class, 'GS_globalNav clearfix')]/ul/li[4]/ul/li")));
    		
    		List<String> otherServicesNameList = new ArrayList<String>();
			for (WebElement element : otherServicesList){
				Add_Log.info("Other Service List ::" + element.getText());
				otherServicesNameList.add(element.getText());
			}	
			
    		String[] expOtherServiceList = {"Get Quotations", "Product Alerts", "Private Sourcing Events", "Sourcing News & Advice", 
    				"Buyer Support", "About Us"};
    		
    		List<String> expSubMenuOtherService = Arrays.asList(expOtherServiceList);
    		if(expSubMenuOtherService.containsAll(otherServicesNameList)){
    			Add_Log.info("Get Quotations, Product Alerts, Private Sourcing Events, Sourcing News & Advice, Buyer Support and About Us "
    					+ "are displayed under the Other Service link.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUB_MENU_OTHER_SERVICE_AVAILABLE, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Get Quotations, Product Alerts, Private Sourcing Events, Sourcing News & Advice, Buyer Support and About Us "
    					+ "are NOT displayed under the Other Service link.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUB_MENU_OTHER_SERVICE_AVAILABLE, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }     

}
