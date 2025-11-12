package listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import tests.PracticeNovSeven;


public class Testlistener implements ITestListener {

	WebDriver driver;
	
	 public void onTestStart(ITestResult result)
{
		System.out.println("Test Started: " + result.getName());
	    Object testClass = result.getInstance();
        WebDriver driver = ((PracticeNovSeven) testClass).driver;

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("E:\\eclipse photos\\" + result.getName() + ".png");
        try {
            FileUtils.copyFile(src, dest);
            System.out.println("📸 Screenshot saved: " + dest.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	 
	    public void onTestSuccess(ITestResult result) {
	        System.out.println("Test passed: " + result.getName());
	    }

	   
	    public void onTestFailure(ITestResult result) {
	        System.out.println("Test failed: " + result.getName());
	        
//	        Date D = new Date();
//	String format=  D.toString().replace(" ", "_").replace(":", "_");
//	        
//	 File Temp=  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	     File dest = new File("E:\\eclipse photos" + format + "\\image.jpg");
//	     try {
//			FileUtils.copyFile(Temp, dest);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	        System.out.println("🔴 Test Failed: " + result.getName());

	        // take screenshot
	        Object testClass = result.getInstance();
	        WebDriver driver = ((PracticeNovSeven) testClass).driver;

	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        File dest = new File("E:\\eclipse photos" + result.getName() + ".png");
	        try {
	            FileUtils.copyFile(src, dest);
	            System.out.println("📸 Screenshot saved: " + dest.getAbsolutePath());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	    }

	   
	    public void onTestSkipped(ITestResult result) {
	        System.out.println("Test skipped: " + result.getName());
	    }
}
