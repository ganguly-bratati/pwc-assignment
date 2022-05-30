package com.pwc.pageFiles;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipCartPageFile {
	WebDriver driver;
	
	@FindBy(xpath = "//span[@class='_36KMOx']/span")
	WebElement loginButton;
	
	
	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	WebElement crossButton;
	
	@FindBy(xpath = "//input[@class='_3704LK']")
	WebElement searchBox;
	
	@FindBy(xpath = "//button[@class='L0Z3Pu']/*[local-name()='svg']")
	WebElement searchButton;
	
	@FindBy(xpath = "(//div[@class='_4rR01T'])[6]")
	WebElement productDescription;
	
	@FindBy(xpath = "(//div[@class='_30jeq3 _1_WHN1'])[6]")
	WebElement productPrice;
	
	@FindBy(xpath = "(//span[@class='B_NuCI']")
	WebElement productDescriptionInPdpPage;
	
	@FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	WebElement addToCartButton;
	
	
	@FindBy(xpath = "//span[@class='_2-ut7f _1WpvJ7']")
	WebElement priceAtCartPage;
	
	
	
	
	

	public FlipCartPageFile(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean validatePopUp(Map<String, Object> returnMap) {
		String loginPopUp = loginButton.getText();
		System.out.println(loginPopUp);
		
		System.out.println(returnMap.get("LoginPopUp").toString());
		
		if (loginPopUp.equalsIgnoreCase(returnMap.get("LoginPopUp").toString())) {
		return true;
		}else {
			return false;
		}
	}

	public boolean clickCrossButton(Map<String, Object> returnMap) {
		crossButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String homePageTitle = driver.getTitle();
		System.out.println(homePageTitle);
		
		System.out.println(returnMap.get("Title").toString());
		
		if (homePageTitle.equalsIgnoreCase(returnMap.get("Title").toString())) {
		return true;
		}else {
			return false;
		}
	}

	public boolean enterProductName(String string) throws InterruptedException {
		searchBox.sendKeys(string);
		searchButton.click();
		driver.navigate().refresh();
		
		return true;
		
	}
	
	public boolean userSeeListOfMobile(Map<String, Object> returnMap) {
		String currentUrl = driver.getCurrentUrl();
		
		if (currentUrl.contains(returnMap.get("Products").toString()))
		return true;
		else
			return false;
	}

	public boolean savePriceDetails() {
		
		String price = productPrice.getText().toString();
		
		System.out.println(price);
		System.setProperty("priceDetails", price);
		
		return true;
	}

	public boolean userClickProductDescription() {
		if (productDescription.isDisplayed()){
			productDescription.click();	
			return true;
		}else
		{
			return false;
		}
		
	}

	public boolean usernavigateProductDescription(Map<String, Object> returnMap) throws InterruptedException {
		
		String parent = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		
		Iterator<String> iterator = allWindow.iterator();
		while(iterator.hasNext()) {
			String child = iterator.next();
			if(parent != child) {}
			driver.switchTo().window(child);
		}
		
		
		if (addToCartButton.isDisplayed()) {
			return true;
		}
		
		return false;
	}

	public boolean userClicksAddButton(Map<String, Object> returnMap) {
		addToCartButton.click();
		return true;
	}

	public boolean validatePrice(Map<String, Object> returnMap) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String priceDetails = priceAtCartPage.getText().toString();
		System.out.println(priceDetails);
		
		String priceAtPDP = System.getProperty("priceDetails");
		
		System.out.println(priceAtPDP);
		
		if (priceDetails.equals(priceAtPDP)) {
			return true;
		}
		
		return false;
	}

	

}
