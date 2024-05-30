package Selenium.Framework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test extends Baseclass{
	
	WebDriverWait wait;
	@Test
	public void test() {
		driver.get("https://test2-web.parkoursc.com/#/login");
		wait = new WebDriverWait(driver, Duration.ofSeconds(15, 5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='username']")));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("hcjhdeedfsbj");
		driver.findElement(By.id("1-password")).sendKeys("djefdehe");
		driver.findElement(By.id("1-submit")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='animated fadeInUp']/span")));
		String Actual = driver.findElement(By.xpath("//span[@class='animated fadeInUp']/span")).getText();
		String Expected = "WRONG USERNAME OR PASSWORD.";
		
		Assert.assertEquals(Actual, Expected);
		
		
		
	}
	

}
