package pomclasess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Kitepinpage 
{
//1.locate variable
	@FindBy(id = "pin") private WebElement pin;
	@FindBy(xpath = "//span[contains(text(),'This field is ')]") private WebElement errorforpin;
	@FindBy(xpath = "//button[@type='submit']") private WebElement continuebutton;

	//2.use construtor
	
	public Kitepinpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//3.methods
	
	public void enterpin(String PIN)
	{
		pin.sendKeys(PIN);
	}
	
	public void Clickoncontinuebutton()
	{
		continuebutton.click();
	}
	
	public String Errorforpin()
	{
		String Actualerror = errorforpin.getText();
		return Actualerror;
	}
	
	
	
	
	
	
}
