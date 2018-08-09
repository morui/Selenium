package com.selenium.assessment;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium.assessment.ApplicationPage;
import com.selenium.assessment.CareerPage;
import com.selenium.assessment.HomePage;
import com.selenium.assessment.PostPage;

public class JobApplication extends BaseTest {
	
 
  @Test
  @Parameters({"homeTitle","careerTitle","base-url"})
  public void gotoHomePage(String title1, String title2,String url) {
	  
	  driver.get(url);
	  HomePage  homePage = new HomePage(driver);
	  assertTrue(homePage.isAtCorrectPage(title1));
	  homePage.clickCareerLink();
	  assertTrue(homePage.isAtCorrectPage(title2));
  }
  
  
  @Test
  public void selectJob() throws Exception {
	  
	  CareerPage careerPage = new CareerPage(driver);
	  careerPage.clickCountryLink();
	  assertTrue(careerPage.isAtCorrectPage("SOUTH AFRICA - iLAB"));
	  PostPage postPage = new PostPage(driver);
	  postPage.clickPostLink();
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  assertTrue(postPage.isAtCorrectPage("Senior Test Automation Specialist – Johannesburg - iLAB"));
  }
  
  @Test
  @Parameters({"name","email"})
  public void applyJob(String name,String email) throws InterruptedException{
	  
	  ApplicationPage appPage = new ApplicationPage(driver);
	  appPage.scrollPage();
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  appPage.clickApplyButton();
	 
	  appPage.populateForm(name,email);
	  appPage.clickSendButton();
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  assertTrue(appPage.verifySubmitMesssage("You need to upload at least one file."));
  }
  
}
