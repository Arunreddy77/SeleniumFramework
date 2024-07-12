package DataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Excel2 {

	public WebDriver driver;
	@Test
	public void Excel() throws IOException, InterruptedException {

		FileInputStream fis = new FileInputStream("/home/arunkumar/Documents/Login.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		//String[] username = null;

		// Assuming there is only one sheet, you can adjust this if there are multiple sheets
		XSSFSheet sheet = workbook.getSheetAt(0); 

		// Count rows and columns with data
		int numRows = sheet.getLastRowNum(); // Total number of rows with data
		int numCols = 2; // Assuming we are interested in columns 1 (A) and 2 (B)

		// 2D array to store cell values
		String[][] data = new String[numRows][numCols];

		// Iterate over rows starting from index 1 (assuming index 0 is header)
		for (int rowNum = 1; rowNum <= numRows; rowNum++) {
			Row row = sheet.getRow(rowNum);
			if (row != null) {
				// Iterate over columns 1 (index 0) and 2 (index 1)
				for (int colNum = 0; colNum < numCols; colNum++) {
					Cell cell = row.getCell(colNum);
					if (cell != null) {
						data[rowNum - 1][colNum] = cell.getStringCellValue(); // Store cell value in array
					} else {
						data[rowNum - 1][colNum] = ""; // If cell is null, store an empty string
					}
				}
			}
		}

		System.out.println("Value at [0][0]: " + data[0][0]);
		System.out.println("Value at [0][0]: " + data[0][1]);

		// Print the 2D array (optional, for verification)
		//        for (String[] row : data) {
		//            for (String cell : row) {
		//                System.out.print(cell + "\t");
		//            }
		//            System.out.println();
		//        }
		for(int i=0; i<3; i++) {
			for(int j=0; j<2; j++) {
				System.out.println(data[i][j]);
			}
		}

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://13.233.29.114/login");


		for (String[] credential : data) {
			String username = credential[0];
			String password = credential[1];

			try {
			driver.findElement(By.xpath("//input[@formcontrolname='emailOrMobile']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
			WebElement iframe =  driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
			driver.switchTo().frame(iframe);
			driver.findElement(By.xpath("//span[@id='recaptcha-anchor']")).click();
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//button[.=' Login '])[3]")).click();
			String text = driver.findElement(By.xpath("//button[@class='btn button-pad shadow me-3 btn-selected']")).getText();
			
			Assert.assertEquals(text, "Profile");
			driver.findElement(By.xpath("//a[@class='nav-link user-profile-loggedin']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[.=' Logout ']")).click();
			System.out.println(username+ " "+ password+ "    Pass");
		}
			catch (Exception e) {
				System.out.println(username+ " "+ password+ "    Fail");
               
			}
			
			finally {
                // Clear fields for next iteration
                WebElement usernameField = driver.findElement(By.xpath("//input[@formcontrolname='emailOrMobile']"));
                WebElement passwordField = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
                usernameField.clear();
                passwordField.clear();
            }
			
		}
	}
}








