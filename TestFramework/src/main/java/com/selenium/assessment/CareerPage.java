package com.selenium.assessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareerPage extends Page{
	

	@FindBy(linkText="South Africa")
	public WebElement countryLink;
	

	public CareerPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickCountryLink(){	
		this.countryLink.click();
	}
	
	
	
	
}
