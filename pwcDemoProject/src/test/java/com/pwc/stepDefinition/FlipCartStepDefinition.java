package com.pwc.stepDefinition;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pwc.pageFiles.FlipCartPageFile;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlipCartStepDefinition extends Basic{
	
	FlipCartPageFile flipCartPageFile = null;
	WebDriver driver =null;
	int counter = 0;
	
	public Map<String,Object> returnMap = new HashMap<String,Object>();
	
	public FlipCartStepDefinition() {
		dataReadFromConfigFile();
	}
	
	
	@After
	public void afterMethod() {
		closeBrowser(this.driver);
	}
	

	@Given("User is able to launch the Flipcart site using {string}")
	public void user_is_able_to_launch_the_flipcart_site_using(String keyword) throws Throwable{
		System.out.println(keyword);
		System.setProperty("webdriver.chrome.driver","chromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		this.driver = driver;
		flipCartPageFile = new FlipCartPageFile(driver);
		returnMap = readDataFromExcel(keyword,testDataPath,testSheet);
		boolean result = flipCartPageFile.validatePopUp(returnMap);
		
		counter++;
		takeScreenshoot(counter, this.driver);
		assertTrue(result);	
	    
	}
	

	@When("User cancel the popup")
	public void user_cancel_the_popup() throws Throwable{
		
		boolean result = flipCartPageFile.clickCrossButton(returnMap);
		
		counter++;
		takeScreenshoot(counter, this.driver);
		assertTrue(result);	
	   
	}
	@When("Search {string} in searchbox")
	public void search_in_searchbox(String productName) throws Throwable{
		boolean result = flipCartPageFile.enterProductName(returnMap.get(productName).toString());
		
		counter++;
		takeScreenshoot(counter, this.driver);
		assertTrue(result);	
	}
	@Then("User is able to see List of Mobiles")
	public void user_is_able_to_see_list_of_mobiles() throws Throwable{
		boolean result = flipCartPageFile.userSeeListOfMobile(returnMap);
		
		counter++;
		takeScreenshoot(counter, this.driver);
		assertTrue(result);	
		
	}
	@When("User navigate to sixth mobile to store the price of mobile")
	public void user_navigate_to_sixth_mobile_to_store_the_price_of_mobile() throws Throwable{
		
		boolean result = flipCartPageFile.savePriceDetails();
		
		counter++;
		
		assertTrue(result);	
	}
	@When("User clicks on the mobile descriptions")
	public void user_clicks_on_the_mobile_descriptions() throws Throwable{
		boolean result = flipCartPageFile.userClickProductDescription();
		
		counter++;
		takeScreenshoot(counter, this.driver);
		assertTrue(result);	
		
	  
	}
	@Then("User navigate to Product defination page")
	public void user_navigate_to_product_defination_page() throws Throwable{
		
		boolean result = flipCartPageFile.usernavigateProductDescription(returnMap);
		
		counter++;
		
		assertTrue(result);	
	    
	}
	@When("User clicks on Add to cart button")
	public void user_clicks_on_add_to_cart_button() throws Throwable{
		boolean result = flipCartPageFile.userClicksAddButton(returnMap);
		
		counter++;
		takeScreenshoot(counter, this.driver);
		assertTrue(result);
	}
	@Then("User is able to validate the price")
	public void user_is_able_to_validate_the_price() throws Throwable{
	   
		boolean result = flipCartPageFile.validatePrice(returnMap);
		
		counter++;
		takeScreenshoot(counter, this.driver);
		assertTrue(result);	
	}


}
