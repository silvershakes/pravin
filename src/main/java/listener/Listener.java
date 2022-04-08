package listener;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.Baseclassfor_listnerscreenshot;

public class Listener extends Baseclassfor_listnerscreenshot implements ITestListener
{
	
	public void onTestFailure(ITestResult result)
	{   String value1 = result.getName();
	
		System.out.println("failed tc "+result.getName());
		
		try {
			Takesscreenshot(value1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("passed tc "+result.getName());
//		String value2 = result.getName();
//		try {
//			Takesscreenshot(value2);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
