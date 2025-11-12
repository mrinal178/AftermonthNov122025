package Jenkinsgit;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jengitTest {

	public WebDriver driver;
	
	@BeforeClass
	public void openbrowser() {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	
	@Test
	public void Verifytitle() {
	String title=	driver.getTitle();
	if(title.equals("Google")) {
		System.out.println("Test Passed");
	}
	}
}
