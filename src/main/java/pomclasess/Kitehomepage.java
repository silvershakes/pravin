package pomclasess;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Kitehomepage
{//1.locate elements
	
	@FindBy(xpath = "//span[@class='user-id']") private WebElement userid;
	@FindBy(xpath = "//a[@target='_self']") private WebElement logoutbutton;
	
//2. use constructor
	
	public Kitehomepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

//3. methods
	public String Actualuserid()
	{
		String Actualresult = userid.getText();
		return Actualresult;
	}
	
	public void gettinglogout() throws InterruptedException 
	{
		userid.click();
		Thread.sleep(3000);
		
		logoutbutton.click();
		
	}
}
