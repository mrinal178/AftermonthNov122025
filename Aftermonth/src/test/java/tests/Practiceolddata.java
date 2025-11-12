package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practiceolddata {

	public WebDriver driver;
	@BeforeClass
	public void Testopenbrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.rediff.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	@DataProvider(name = "dp")
	public Object[][] data() throws IOException{
		
		FileInputStream fis = new FileInputStream("C:\\Users\\hp\\Desktop\\Book1.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fis);
	Sheet sheet=	book.getSheetAt(0);
	int rows =	sheet.getPhysicalNumberOfRows();
	int cells =	sheet.getRow(0).getPhysicalNumberOfCells();
	ArrayList<Object[]> list = new ArrayList<Object[]>();
Row initialrow= sheet.getRow(0);


	
	for(int i=0;i<rows;i++) {
Row row= sheet.getRow(i);

Object[] singleRowData = new Object[cells];
for(int j=0;j<cells;j++) {
Cell cell=	row.getCell(j);
singleRowData[j] = cell.getStringCellValue();
}
list.add(singleRowData);

	}
	
	Object[][] dataarray = new Object[list.size()][];
	for(int i=0;i<list.size();i++) {
		dataarray[i] = list.get(i);
	}
	return  dataarray;
	}
	
}
