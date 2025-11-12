package listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import tests.PracticeNovSeven;

public class Practicelistener implements ITestListener {

	
public void onTestStart(ITestResult result) {
	System.out.println("Test Start:" + result.getName());
	// TODO Auto-generated method stub
}

public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	System.out.println("Test success:" + result.getName());
	
	//Screenshot on Test Fail:
Object obj=	 result.getInstance();
  WebDriver driver=((PracticeNovSeven)obj).driver;
  Date d = new Date();
 String format= d.toString().replace(" ", "_").replace(":", "_");
File src=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest = new File("E:\\eclipse photos\\"+result.getName()+ " "+ format+ ".png");
	try {
		FileUtils.copyFile(src, dest);
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
	}

public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	System.out.println("Test Fail:" + result.getName());
	
	//Screenshot on Test Fail:
Object obj=	 result.getInstance();
  WebDriver driver=((PracticeNovSeven)obj).driver;
  Date d = new Date();
 String format= d.toString().replace(" ", "_").replace(":", "_");
File src=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest = new File("E:\\eclipse photos\\"+result.getName()+ " "+ format + ".png");
	try {
		FileUtils.copyFile(src, dest);
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
	}

public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	System.out.println("Test Skip:" + result.getName());
	}
	
}
