package tests;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ser.std.NumberSerializer;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

@Listeners(listeners.Practicelistener.class)
public class PracticeNovSeven {

	public WebDriver driver;
	
//	@BeforeClass()
//public void openbrowser() throws IOException {
//		String Browser="chrome";
//		FileInputStream fis = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Aftermonth\\src\\test\\resources\\config.properties");
//		Properties config = new Properties();
//		config.load(fis);
//		if(Browser.equals(config.getProperty("browser"))) {			
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}else if (Browser.equals(config.getProperty("browser"))) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		}
//		driver.get("https://www.wikipedia.org/");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//		driver.manage().window().maximize();
//	}	
//	
//	@Test()
//	public void elementselection() {
//	List<WebElement> dropdown=	driver.findElements(By.xpath("//select[@id=\"searchLanguage\"]//option"));
//	for (WebElement e : dropdown) {
//		System.out.println(e.getText());
//	}

//	}
//@Parameters("browser")
@BeforeClass()
public void openBrowser() {
//	if (browser.equalsIgnoreCase("chrome")) {
//		
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.get("https://www.w3schools.com/Jsref/met_win_alert.asp");
//	}else if (browser.equalsIgnoreCase("edge")) {
//		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();
//		driver.get("https://www.w3schools.com/Jsref/met_win_alert.asp");
//	} 	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://www.w3schools.com/Jsref/met_win_alert.asp");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
}

@Test()
public void elementscreenshot() {
WebElement TryitYourSelf= driver.findElement(By.xpath("//a[text() = \"Try it Yourself »\"]"));
String Originalwindow = driver.getWindowHandle();
TryitYourSelf.click();
Set<String> windows = driver.getWindowHandles();
for (String i : windows) {
	if(!i.equals(Originalwindow)) {
		driver.switchTo().window(i);
	}
}
driver.findElement(By.xpath("//a[text() = \"Get your\"]")).click();
System.out.println("After");
}

@BeforeMethod()
public void zz() {
	System.out.println("Before");
}

}// class closing
