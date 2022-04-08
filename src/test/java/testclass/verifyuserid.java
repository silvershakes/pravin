package testclass;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Baseclass;
import pomclasess.Kitehomepage;
import pomclasess.Kiteloginpage;
import pomclasess.Kitepinpage;
import utility.Utilityclass;
@Listeners(listener.Listener.class)
public class verifyuserid extends Baseclass{
   int TCID=101;
	Kitehomepage home;
	Kiteloginpage login;
	Kitepinpage pin;
	
	@BeforeClass
	public void launchbrowser()
	{
		launchingbrowser();
		
		home = new Kitehomepage(driver);
		login = new Kiteloginpage(driver);
		pin = new Kitepinpage(driver);
		
	}
	
	@BeforeMethod
	public void log_in() throws EncryptedDocumentException, IOException
	{
		login.enterusername(Utilityclass.getdatafromexcelsheet(0, 0));
		login.enterpassword(Utilityclass.getdatafromexcelsheet(0, 1));
		login.clickoncontinuebutton();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		
		pin.enterpin(Utilityclass.getdatafromexcelsheet(0, 2));
		pin.Clickoncontinuebutton();
	}

	@Test
  public void validateuserid() throws EncryptedDocumentException, IOException 
	{ 
		String Actualr = home.Actualuserid();
		String expectedr = Utilityclass.getdatafromexcelsheet(0, 0);
		
		Assert.assertEquals(Actualr, expectedr,"not matching");
		
		Utilityclass.takesscreenshot(driver, TCID);
  
	}
	
	@AfterMethod
	public void gettinglogout() throws InterruptedException
	{
		home.gettinglogout();
	}
	
	@AfterClass
	public void closingbrow()
	{
		closingbrowser();
	}
}
