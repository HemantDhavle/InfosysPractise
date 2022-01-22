package com.qa.utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class elementUtils 
{
	public WebDriver driver;
	public WebDriverWait wait;
	
	public elementUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public By getBy(String locatorType, String locatorValue)
	{
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
		locator = By.id(locatorValue);	
			break;
		case "name":
			locator = By.name(locatorValue);	
				break;
		case "className":
			locator = By.className(locatorValue);	
				break;
		case "xpath":
			locator = By.xpath(locatorValue);	
				break;
		case "cssSelector":
			locator = By.cssSelector(locatorValue);	
				break;
		case "linktext":
			locator = By.linkText(locatorValue);	
				break;
		case "partiallinktext":
			locator = By.partialLinkText(locatorValue);	
				break;
		case "tagName":
			locator = By.tagName(locatorValue);	
				break;
		default:
			System.out.println("Please pass the correct locator");
			break;
		}
		return locator;
	}
	
	public WebElement getElement(String locatorType, String locatorValue)
	{
		return driver.findElement(getBy(locatorValue, locatorValue));
	}
	
	public WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	public List<WebElement> getElements(String locatorType, String locatorValue)
	{
		return driver.findElements(getBy(locatorValue, locatorValue));
	}
	
	public List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	
	//Select drop down handeling//
	public void selectDropDownValueByIndex(By locator, int index)
	{
		Select option = new Select(getElement(locator));
		option.selectByIndex(index);
	}
	public void selectDropDownValueByValue(By locator, String value)
	{
		Select option = new Select(getElement(locator));
		option.selectByValue(value);
	}
	public void selectDropDownValueByVisibleText(By locator, String text)
	{
		Select option = new Select(getElement(locator));
		option.selectByVisibleText(text);
	}
	
	public void selectDropDownsAndClick(By locator, String value)
	{
		Select option = new Select(getElement(locator));
		List<WebElement> options = option.getOptions();
		for(WebElement e : options)
		{
			if(e.getText().contains(value))
			{
				getElement(locator).click();
			}
		}
		
	}
	
	public void doWaitSendKey(By locator, String value, int duration)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOf(getElement(locator))).sendKeys(value);
	}
	
	public void doWaitSendKey(By locator, String value, int duration, int interval)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(duration, interval));
		wait.until(ExpectedConditions.visibilityOf(getElement(locator))).sendKeys(value);
	}
	
	
	
	public void doWaitClick(By locator, int duration)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOf(getElement(locator))).click();
	}
	
	
	public void doWaitClick(By locator, int duration, int interval)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(duration, interval));
		wait.until(ExpectedConditions.visibilityOf(getElement(locator))).click();
	}
	

}
