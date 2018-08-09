package com.selenium.assessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends Page {
	
	@FindBy(xpath="/html/body/section/div[2]/div/div/div/div[3]/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/span[1]/a")
	public WebElement PostLink;

	public PostPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public void clickPostLink(){	
		try{
		this.highlightElement(PostLink);
		this.PostLink.click();
		}catch(Exception e ){
			
			System.out.print(e.getMessage());
		}
	}
}
