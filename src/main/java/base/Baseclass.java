package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

public class Baseclass 
{
	protected WebDriver driver;
	
	public void launchingbrowser()
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

	public void closingbrowser()
	{
		driver.quit();
		Reporter.log("browser closed",true);
	}
}
