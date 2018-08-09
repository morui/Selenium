package com.selenium.assessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page{
	
	
	
	@FindBy(linkText="CAREERS")
	public WebElement careerLink;
	
	
	
	
	public HomePage(WebDriver driver){
		
		super(driver);
	}
	
	public void clickCareerLink(){	
		this.careerLink.click();
	}
		

}
