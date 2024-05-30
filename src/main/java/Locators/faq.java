package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class faq extends CodeReuseability {

	WebDriver driver;
	public faq(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy
	(xpath = "//span[.='FAQs']")
	WebElement faqs;
	
	
	public faqCreate faqclick() {
		visibilityofelem(faqs);
		//presenceofelem(By.xpath("//span[.='FAQs']"));
		faqs.click();
		
		faqCreate fqs = new faqCreate(driver);
		return fqs;
	}
	
}
