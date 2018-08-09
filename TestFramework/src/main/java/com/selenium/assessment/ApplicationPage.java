package com.selenium.assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ApplicationPage extends Page {

	
	@FindBy(xpath="//*[@id='wpjb-scroll']/div[1]/a")
	public WebElement applyLink;
	
	@FindBy(id="applicant_name")
	public WebElement yourName;
	
	
	@FindBy(id="email")
	public WebElement email;
	
	
	@FindBy(id="phone")
	public WebElement phone;
	
	@FindBy(linkText="Johannesburg, South Africa")
	public WebElement location;
	
	@FindBy(id="wpjb_submit")
	public WebElement sendButton;
	
	@FindBy(xpath="//*[@id='wpjb-apply-form']/fieldset[1]/div[5]/div/ul")
	public WebElement errorMessage;
	
	
	public ApplicationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
		
	public void clickApplyLink(){	
		
		driver.findElement(By.xpath("//*[contains(@class,'wpjb-form-job-apply')]")).click();;
	}
	
	public void clickApplyButton(){
		try{
		this.highlightElement(applyLink);
		this.applyLink.click();
		}catch(Exception e ){
			System.out.print(e.getMessage());
		}
	}
	public void expandLocation(){
		this.location.click();
	}
	
	public void clickSendButton(){	
		this.sendButton.click();
	}
  
	public void populateForm(String name, String email){
		
		DataManager dm = new DataManager();
		
		String phone = dm.generatePhoneNubmer();
		
		this.yourName.clear();
		this.yourName.sendKeys("Mamphofore");
		
		this.email.clear();
		this.email.sendKeys("automationAssessment@iLABQuality.com");
		
		this.phone.clear();
		this.phone.sendKeys(phone);
			
	}
	
	public void waitForApplyButton(){
		this.waitForElement(applyLink);
	}
	
	public boolean verifySubmitMesssage(String msg){
		
		boolean outcome = verifyErrorMessage(errorMessage, msg);
		System.out.print("the outcome value: " + outcome);
		return outcome;
	}
}
