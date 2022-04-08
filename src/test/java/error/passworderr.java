package error;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Baseclassfor_listnerscreenshot;
import pomclasess.Kitehomepage;
import pomclasess.Kiteloginpage;
import pomclasess.Kitepinpage;

public class passworderr extends Baseclassfor_listnerscreenshot {
    int TCID=1236;
	Kiteloginpage login;
    Kitehomepage home;
    Kitepinpage pin;
    
	@BeforeClass
	public void launchbjh()
	{
		launchingbrow();
		
		home= new Kitehomepage(driver);
		pin=new Kitepinpage(driver);
		login=new Kiteloginpage(driver);
	}
	
	@BeforeMethod
	public void passerroi() throws EncryptedDocumentException, IOException, InterruptedException
	{
		login.enterpassword(utility.Utilityclass.getdatafromexcelsheet(0, 0));
		Thread.sleep(1000);
		login.clickoncontinuebutton();
	}
	
	
	@Test
  public void f() throws EncryptedDocumentException, IOException 
	{
		String Ac = login.Errorforpass();
		String ex = utility.Utilityclass.getdatafromexcelsheet(0, 4);
		
		Assert.assertEquals(Ac, ex,"not matching");
		
		utility.Utilityclass.takesscreenshot(driver, TCID);
  }
	
	@AfterClass
	public void clo()
	{
		closingbrowser();
	}
}
