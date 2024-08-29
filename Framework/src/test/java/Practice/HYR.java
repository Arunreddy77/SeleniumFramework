package Practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Locators.Adminlogin;
import Selenium.Framework.Baseclass;

public class HYR extends Baseclass{
	
	@Test
	public void windowhandles() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.hyrtutorials.com/");
		WebElement elem = driver.findElement(By.xpath("//a[.='Selenium Practice']"));
		Actions action = new Actions(driver);
		action.moveToElement(elem).build().perform();
		driver.findElement(By.xpath("//a[.='Window Handles']")).click();
//		driver.findElement(By.id("newTabBtn")).click();
		driver.findElement(By.id("newWindowBtn")).click();
		Set<String> handle = driver.getWindowHandles();
		List<String> handleList = new ArrayList<>(handle);
		driver.switchTo().window(handleList.get(1));
		Thread.sleep(3000);
//		driver.findElement(By.id("alertBox")).click();
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
	}
	
	
	@Test
	public void ddown() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		WebElement elem = driver.findElement(By.tagName("select"));
		Select sc = new Select(elem);
		sc.selectByIndex(2);
		List<WebElement> options = sc.getOptions();
		for(WebElement name : options) {
			System.out.println(name.getText());
		}
		
		
	}
	
	@Test
	public void name() {
		String name = "Arun";
		String s2="";
		for(int i=0; i<name.length(); i++) {
			for(int j=0; j<=i; j++) {
				System.out.print(name.charAt(i));
			}
		}
		
		for(int i=name.length()-1; i>=0; i--) {
			s2+= name.charAt(i);			
		}
		System.out.print(s2);
	}
	
	@Test
	public void rsa() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//label[@for='bmw']/input")).click();
		String name = driver.findElement(By.xpath("//label[@for='bmw']")).getText();
		System.out.println(name + "-text");
	}
	
}
