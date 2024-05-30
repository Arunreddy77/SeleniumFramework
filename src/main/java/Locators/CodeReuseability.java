package Locators;

import java.time.Duration;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CodeReuseability {
	public WebDriver driver;
	public WebDriverWait wait;
	Actions actions;
	
	public CodeReuseability(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void visibilityofelem(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15, 5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void presenceofelem(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void tabswitch(Integer index) {
		Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the second tab (index 1 in the set)
        String secondTabHandle = windowHandles.toArray()[index].toString();
        driver.switchTo().window(secondTabHandle);
	}
	
	public void sendAlertpop() {
		 String script = "alert('Enter OTP manually');";
	        ((JavascriptExecutor) driver).executeScript(script);

	        // Switch to the alert
	        driver.switchTo().alert().accept();
	}
	
	public void opentab() {
		  ((ChromeDriver) driver).executeScript("window.open('', '_blank');");
	}
	
	public String randomstring() {
		String s = RandomStringUtils.randomNumeric(4);
		return s;
		
	}
	
	public void doubleclick(WebElement element) {
		  actions = new Actions(driver);
	        actions.doubleClick(element).build().perform();
	}
	
	public void rightclick(WebElement element) {
		 actions.contextClick(element).build().perform();
	}
	
	public void scrollTo(WebElement element) {
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
}












