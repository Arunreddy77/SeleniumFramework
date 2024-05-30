package postman;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Selenium.Framework.Baseclass;

public class postman extends Baseclass{
WebDriverWait wait;
	@Test
	public void pman() {
		driver.get("https://www.postman.com/");
		driver.findElement(By.xpath("(//span[.='Sign In'])[1]")).click();
		driver.findElement(By.id("username")).sendKeys("arun.kumar@cognitivzen.com");
		driver.findElement(By.id("password")).sendKeys("ach#-4422");
		driver.findElement(By.id("sign-in-btn")).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15, 5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[.='Workspaces']")));
		driver.findElement(By.xpath("//span[.='Workspaces']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[.='My Workspace'])[1]")));
		driver.findElement(By.xpath("(//span[.='My Workspace'])[1]")).click();
		WebElement el = driver.findElement(By.xpath("//div[@class='collection-sidebar-list__list']/div/div[5]"));
		wait.until(ExpectedConditions.visibilityOf(el));
		el.click();
		driver.findElement(By.xpath("//div[.='o Auth Token'])[2]")).click();
		driver.findElement(By.xpath("//span[.='Send']")).click();
		String data[];
		
	}
}
