package Selenium.Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import Locators.Adminlogin;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	public WebDriver driver;


	@BeforeTest
	public WebDriver driverinitialization() throws IOException {
		// properties class
				Properties prop = new Properties();
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
						+ "/src/main/java/Resources/GlobalData.properties");
				prop.load(fis);
				String browserName = System.getProperty("browser")!=null ? System.getProperty("browser"): prop.getProperty("browser");
				//prop.getProperty("browser");
				
				if (browserName.contains("chrome")) {
					ChromeOptions options = new ChromeOptions();
					WebDriverManager.chromedriver().setup();
					if(browserName.contains("headless")) {
						options.addArguments("--headless=new");
					}
					driver = new ChromeDriver(options);
		 
				}
				else if (browserName.equalsIgnoreCase("firefox")) {
					// Firefox
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				}
				else if (browserName.equalsIgnoreCase("edge")) {
					// Edge
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
				}
		driver.manage().window().maximize();
		return driver;
	}

	public Adminlogin url(String URL) {
		driver.get(URL);
		Adminlogin al = new Adminlogin(driver);
		return al;
	}




	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs (OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "/reports/" + testCaseName + ".png"); 
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
