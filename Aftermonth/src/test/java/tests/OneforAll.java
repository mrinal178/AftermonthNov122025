package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OneforAll {
	static WebDriver driver;

	@BeforeClass()
	public static void openbrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
	}

	@DataProvider(name = "dp")
	public static Object[][] data() throws IOException {

		FileInputStream Fis = new FileInputStream("C:\\Users\\hp\\Desktop\\Book1.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(Fis);
		Sheet sheet = book.getSheetAt(0);
		int Rows = sheet.getPhysicalNumberOfRows();
		int cells = sheet.getRow(0).getPhysicalNumberOfCells();
		List<Object[]> rawdata = new ArrayList<Object[]>();

		for (int i = 0; i < Rows; i++) {
			Row row = sheet.getRow(i);
			if (row == null)
				continue;

			Object[] singleRowData = new Object[cells];

			for (int j = 0; j < cells; j++) {
				Cell cell = row.getCell(j);
				if (cell == null || cell.getCellType() == CellType.BLANK)
					continue;

				singleRowData[j] = cell.getStringCellValue();
			}
			rawdata.add(singleRowData);
		} // for main loop

		// convert list to array

		Object[][] ExceldataArray = new Object[rawdata.size()][];
		for(int i =0;i<rawdata.size(); i++) {
			ExceldataArray[i] = rawdata.get(i);
		}
		return ExceldataArray;
	}// dataprovider method

	@Test(dataProvider = "dp")
	public void datafetcher(String username, String Password) {
	WebElement RedifId=	driver.findElement(By.xpath("//input[@type=\"text\"]"));
	RedifId.sendKeys(username);
	driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(Password);
	System.out.println(username);
	System.out.println(Password);
	}
	
	
}// class
