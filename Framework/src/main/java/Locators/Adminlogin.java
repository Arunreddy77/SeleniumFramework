package Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adminlogin {

	
	WebDriver driver;
	public Adminlogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "input-email")
	WebElement username;
	
	@FindBy(id ="input-password")
	WebElement pswd;
	
	@FindBy(xpath = "//button[.=' Log In ']")
	WebElement login;
	
	
	
	public faq Alogin(String email, String password) {
		
		username.sendKeys(email);
		pswd.sendKeys(password);
		login.click();
		faq fq = new faq(driver);
		return fq;
	}
}
