package facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Selenium.Framework.Baseclass;

public class facebook extends Baseclass{

	
	@Test
	public void fb() throws InterruptedException {
		driver.get("https://msh.meity.gov.in/");
		Thread.sleep(3000);
		String elem =	driver.findElement(By.xpath("(//span[@class='nav-itmes-list'])[9]")).getText();
		System.out.println(elem);
		Assert.assertEquals(elem, "FORM");
	}
}
