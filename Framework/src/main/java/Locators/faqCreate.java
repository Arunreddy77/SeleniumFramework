package Locators;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class faqCreate extends CodeReuseability{

	WebDriver driver;
	public String text1;
	public faqCreate(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@formcontrolname='question']")
	WebElement faqqn;
	
	@FindBy(xpath = "//div[@role='textbox']")
	WebElement answer;
	
	@FindBy(xpath = "//button[.='Create']")
	WebElement create;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[2]")
	List<WebElement> faqt;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[5]/div/div/a")
	List<WebElement> approve;
	
	@FindBy(xpath = "//button[.='YES']")
	WebElement yes;
	
	@FindBy(xpath = "//a[@aria-label='Next page']")
	WebElement next;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[4]")
	List<WebElement>  status;
	
	public void faqcreation() throws Exception {
		visibilityofelem(faqqn);
		String text = randomstring();
		 text1 = "FAQ created by Automated Script " + text ;
		System.out.println(text1);
		faqqn.sendKeys(text1);
		answer.sendKeys("Answer given by Automated Script " + text);
		create.click();
		int r =0;
		for(int i=0; i<3; i++) {
			for(int j=0; j<faqt.size(); j++) {
				WebElement aa = faqt.get(i);
				visibilityofelem(aa);
				scrollTo(aa);
				String faqtext = faqt.get(j).getText();
				if(faqtext.equalsIgnoreCase(text1)) {
					Thread.sleep(1000);
					approve.get(j).click();
					visibilityofelem(yes);
					Thread.sleep(1000);
					yes.click();
					Thread.sleep(3000);
					r=1;
					break;
					
				}
				
			}
			if(r==1) {
				break;
			}
			next.click();
		}
		
		
	}
}





















