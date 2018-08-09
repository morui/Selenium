package com.selenium.assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

	protected WebDriver driver;

	public Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isAtCorrectPage(String title) {
        boolean isMatch= false;
        if (driver.getTitle().equalsIgnoreCase(title)){
        	isMatch=true;
        	System.out.print("Title : "+title+" Matches with the page");
        }else{
        	System.out.print("Title : "+title+" does not Matches with the page");
        }
		return isMatch ;
	}

	public void scrollPage() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,150)", "");
	}

	public void highlightElement(WebElement element) {
		for (int i = 0; i < 10; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "color: blue; border: 6px solid blue;");
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "");
		}
	}

	public void waitForElement(WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	public boolean verifyErrorMessage(WebElement elmnt, String expValue) {
		boolean isMatch = false;
		try {
			String mesg = elmnt.getText().trim();
			System.out.print("The label text: " + mesg);

			if (mesg.equalsIgnoreCase(expValue)) {
				isMatch = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isMatch;
	}
}
