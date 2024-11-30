package com.gbadegesin.socialappautomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;

@Component
public class ProfilePage extends BasePage {

	By txtHeadline = By.id("headline");
	By txtBio = By.id("bio");
	By txtCity = By.id("city");
	By txtCountry = By.id("country");
	By txtFirstName = By.id("firstName");
	By txtLastName = By.id("lastName");
	By txtPhone = By.id("phone");
	By txtEmailId = By.id("emailId");
	By txtPassword = By.id("password");

	By xPathSaveBtn = By.xpath("//input[@type='submit' and @value='Save']");
	By updateBasicProfileSaveBtn = By.xpath("(//input[@value='Save'])[1]");

	By xPathMessageBadge = By.id("messageBadge");
	
	public void setHeadline(String headline) {
		this.driverManager.getDriver().findElement(this.txtHeadline).sendKeys(headline);
	}

	public void setBio(String bio) {
		this.driverManager.getDriver().findElement(this.txtBio).sendKeys(bio);
	}

	public void setCity(String city) {
		this.driverManager.getDriver().findElement(this.txtCity).sendKeys(city);
	}

	public void setCountry(String country) {
		this.driverManager.getDriver().findElement(this.txtCountry).sendKeys(country);
	}

	public void clickSave() {
		this.driverManager.getDriver().findElement(this.xPathSaveBtn).click();
	}
	
	public void openProfilePage(String profilePageLink) {
		this.driverManager.getDriver().findElement(By.linkText(profilePageLink))
        .click();
	}
	
	public String getFirstName() {
		return this.driverManager.getDriver().findElement(this.txtFirstName).getAttribute("value");
	}
	
	public String getLastName() {
		return this.driverManager.getDriver().findElement(this.txtLastName).getAttribute("value");
	}
	
	public String getPhone() {
		return this.driverManager.getDriver().findElement(this.txtPhone).getAttribute("value");
	}
	
	public String getEmail() {
		return this.driverManager.getDriver().findElement(this.txtEmailId).getAttribute("value");
	}
	
	public void setFirstName(String firstName) {
		
		WebDriver driver = this.driverManager.getDriver();
		WebElement webElement = driver.findElement(this.txtFirstName);
		Actions actions = new Actions(driver);
        actions.keyDown(webElement, getOsKey()).sendKeys("a").keyUp(getOsKey()).sendKeys(Keys.BACK_SPACE).perform();
		webElement.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		
		WebDriver driver = this.driverManager.getDriver();
		WebElement webElement = driver.findElement(this.txtLastName);
		Actions actions = new Actions(driver);
        actions.keyDown(webElement, getOsKey()).sendKeys("a").keyUp(getOsKey()).sendKeys(Keys.BACK_SPACE).perform();
		webElement.sendKeys(lastName);
	}
	
	public void setPhone(String phone) {
		WebDriver driver = this.driverManager.getDriver();
		WebElement webElement = driver.findElement(this.txtPhone);
		Actions actions = new Actions(driver);
        actions.keyDown(webElement, getOsKey()).sendKeys("a").keyUp(getOsKey()).sendKeys(Keys.BACK_SPACE).perform();
		webElement.sendKeys(phone);
	}
	
	public void setEmail(String email) {
		
		WebDriver driver = this.driverManager.getDriver();
		WebElement webElement = driver.findElement(this.txtEmailId);
		Actions actions = new Actions(driver);
        actions.keyDown(webElement, getOsKey()).sendKeys("a").keyUp(getOsKey()).sendKeys(Keys.BACK_SPACE).perform();
		webElement.sendKeys(email);
	}
	
	public void setPassword(String password) {
		
		this.driverManager.getDriver().findElement(this.txtPassword).sendKeys(password);
	}
	
	public void clickSaveToUpdateProfile() {
		this.driverManager.getDriver().findElement(this.updateBasicProfileSaveBtn).click();
	}
	
	public String getMessage() {
		return this.getMessage(this.xPathMessageBadge);
	}
	
	private CharSequence getOsKey() {
		String os = System.getProperty("os.name").split(" ")[0];
		if (os.equals("Windows")) {
			return Keys.CONTROL;
		} else if (os.equals("Mac")) {
			return Keys.COMMAND;
		} else {
			return null;
		}
	}

}
