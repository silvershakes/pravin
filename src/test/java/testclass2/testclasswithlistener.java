package testclass2;

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

import base.Baseclassfor_listnerscreenshot;
import pomclasess.Kitehomepage;
import pomclasess.Kiteloginpage;
import pomclasess.Kitepinpage;
@Listeners(listener.Listener.class)
public class testclasswithlistener extends Baseclassfor_listnerscreenshot {
  
	Kitehomepage home;
	Kiteloginpage login;
	Kitepinpage pin;
	
	@BeforeClass
	
	public void launchbrowser()
	{
		launchingbrow();
		
		home= new Kitehomepage(driver);
		login= new Kiteloginpage(driver);
		pin=new Kitepinpage(driver);
		
	}
	
	
	@BeforeMethod
	public void login() throws EncryptedDocumentException, IOException
	{
		login.enterusername(utility.Utilityclass.getdatafromexcelsheet(0, 0));
		login.enterpassword(utility.Utilityclass.getdatafromexcelsheet(0, 1));
		login.clickoncontinuebutton();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		
		pin.enterpin(utility.Utilityclass.getdatafromexcelsheet(0, 2));
		pin.Clickoncontinuebutton();
	}

	@Test
  public void Validateuser() throws EncryptedDocumentException, IOException 
	{
		String Actual1 = home.Actualuserid();
		String Expected1 = utility.Utilityclass.getdatafromexcelsheet(0, 6);
		
		Assert.assertEquals(Actual1, Expected1,"not matching");
  }
	
	@AfterMethod
	public void logout() throws InterruptedException
	{
		home.gettinglogout();
	}
	
	@AfterClass
	public void closing()
	{
		closingbrowser();
	}
}
