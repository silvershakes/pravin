package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

public class Baseclassfor_listnerscreenshot 
{
	
	 protected static WebDriver driver;
     public void launchingbrow()
     {
    	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\pravi\\Desktop\\silenium all\\crome driver\\chromedriver.exe");
 		
 		ChromeOptions opt = new ChromeOptions();
 		
 		opt.addArguments("--disable-notifications");
 		
 		driver = new ChromeDriver(opt);
 		
 		driver.get("https://kite.zerodha.com/?next=%2Fdashboard#loggedout");
 		
 		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
 		
 		driver.manage().window().maximize();
 		
 		Reporter.log("browser opened sucessfully",true);
 		
 	}
     
     public void Takesscreenshot(String TCname) throws IOException
     {
    	 File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	    
    	    System.out.println("screenshot taken");
    	    
    	    File d =new File("C:\\Users\\pravi\\Desktop\\velocity\\Practise screenshot\\TC"+TCname+"screenshot.png");
    	 
    	    org.openqa.selenium.io.FileHandler.copy(screen, d);
     }
     
     public void closingbrowser()
     {
    	 driver.quit();
     }
}
