package DataDriven;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CSV {

	public WebDriver driver;
	
	@Test
	public void CSV() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		// Read the CSV file
       try {
		CSVReader reader = new CSVReader(new FileReader("/home/arunkumar/Documents/LoginMeity.csv"));
		String[]	lines = null;
		System.out.println(lines.length);
//		for(int i=0; i<lines.length; i++)	{
//			System.out.println(lines[1]);
//		}
		
		
	}
       catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	
	
	
	
	
	
	
	
}
