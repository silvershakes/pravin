package error;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Baseclass;
import pomclasess.Kitehomepage;
import pomclasess.Kiteloginpage;
import pomclasess.Kitepinpage;

public class usererror extends Baseclass {
    int TCID=12345;
	Kitehomepage home;
	Kiteloginpage login;
	Kitepinpage pin;
	
	@BeforeClass
	public void launchitem()
	{
		launchingbrowser();
		
		home= new Kitehomepage(driver);
		pin=new  Kitepinpage(driver);
		login=new Kiteloginpage(driver);
	}
	
	@BeforeMethod
	public void loginitem() throws EncryptedDocumentException, IOException
	{
	    login.enterpassword(utility.Utilityclass.getdatafromexcelsheet(0, 1));
	    login.clickoncontinuebutton();
	}
	

	@Test
  public void uesererr() throws EncryptedDocumentException, IOException 
	{
		String Act = login.Erroeforuserid();
		String ex = utility.Utilityclass.getdatafromexcelsheet(0, 3);
		
		Assert.assertEquals(Act, ex,"not matching");
		utility.Utilityclass.takesscreenshot(driver, TCID);
  }
	
	@AfterClass
	public void close()
	{
		closingbrowser();
	}
	
}
