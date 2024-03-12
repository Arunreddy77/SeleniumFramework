package Selenium.Framework;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Locators.Adminlogin;
import Locators.faq;
import Locators.faqCreate;

public class MainClass extends Baseclass {

	
	
	@Test(groups = {"monkey"}, retryAnalyzer = Retry.class)
	public void faq() throws Exception {
	Adminlogin al =	url("http://13.233.29.114/meityadmin/auth");
	faq fq = al.Alogin("superadmin@msh.gov.in", "Super2024@msh");
	faqCreate fqs = fq.faqclick();
	fqs.faqcreation();
	}
}
