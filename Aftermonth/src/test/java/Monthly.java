import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
//import ru.yandex.qatools.ashot.AShot;
//import ru.yandex.qatools.ashot.Screenshot;
//import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Monthly {

	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		FileInputStream fis = new FileInputStream("C:\\Users\\hp\\Desktop\\Book1.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fis);
		Sheet sheet = book.getSheetAt(0);
		//string data = new string[][];
		int rows = sheet.getPhysicalNumberOfRows();
		for(int i=0;i<rows;i++) {
		Row row=sheet.getRow(i);
	int cells=row.getPhysicalNumberOfCells();
	String[][] data = new String[rows][cells];
		for(int j=0;j<cells;j++) {
		Cell cell=	row.getCell(j);
	String val=	cell.getStringCellValue();
	System.out.println("Data"+" "+data[i][j]+" = "+ " "+cell.getStringCellValue());
	((TakesScreenshot)(driver)).getScreenshotAs(OutputType.FILE);
		}
		}
	}
}
