package pomclasess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Kiteloginpage 
{//1.locate variables
	
	@FindBy(id = "userid") private WebElement userid;
	@FindBy(id = "password") private WebElement pass;
	@FindBy(xpath = "//span[contains(text(),'User ID should be minimum ')]") private WebElement errorforuserid;
    @FindBy(xpath = "//span[contains(text(),'Password should be minimum ')]") private WebElement errorforpass;
    @FindBy(xpath = "//button[@type='submit']") private WebElement continuebutton;


//2.use constructor
    
    public Kiteloginpage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }

//3.methods
    
    public void enterusername(String UN)
    {
    	userid.sendKeys(UN);
    }

    public void enterpassword(String PASS)
    {
    	pass.sendKeys(PASS);
    }

    public void clickoncontinuebutton()
    {
    	continuebutton.click();
    }

     public String Erroeforuserid()
     {
    	 String Actualresult = errorforuserid.getText();
    	 
    	 return Actualresult;
     }

     public String Errorforpass()
     {
    	 String Actualresult = errorforpass.getText();
    	 
    	 return Actualresult;
     }



}
