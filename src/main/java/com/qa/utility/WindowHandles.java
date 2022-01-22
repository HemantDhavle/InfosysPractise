package com.qa.utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandles 
{
	public WebDriver driver;
	public void handlewindow()
	{
		Set<String> handles = driver.getWindowHandles();
		Iterator<String>  it = handles.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(parent);
						
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		Actions act = new Actions(driver);
act.doubleClick(target);
act.contextClick(target);
act.moveToElement(target)
act.dragAndDrop(source, target)
	}

}
