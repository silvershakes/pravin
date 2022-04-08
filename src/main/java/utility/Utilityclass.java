package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.FileHandler;

import javax.print.attribute.standard.Destination;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Utilityclass 

{
	
public static String getdatafromexcelsheet(int rowcount,int cellcount) throws EncryptedDocumentException, IOException
{
	FileInputStream myfile =new FileInputStream("C:\\Users\\pravi\\Desktop\\silenium all\\1excel.xlsx");
	
	Sheet main = WorkbookFactory.create(myfile).getSheet("sheet3");
	
	String value = main.getRow(rowcount).getCell(cellcount).getStringCellValue();
	
	return value;
}

public static void takesscreenshot(WebDriver driver,int TCID) throws IOException 
{
    File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    
    System.out.println("taken");
    
    File d =new File("C:\\Users\\pravi\\Desktop\\velocity\\Practise screenshot\\TC"+TCID+"screenshot.png");
 
    org.openqa.selenium.io.FileHandler.copy(screen, d);
}
}
