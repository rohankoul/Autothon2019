package autothon.autothon.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtilities {
	
	static int TIMEOUT_WAIT_UNTIL = 20;
	public void enterInput(WebDriver driver,String xpath, String value,String screenshot_name, HTMLOutputWriter html) throws SeleniumScriptFailedException
	{
		try {
			//WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_WAIT_UNTIL);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			WebElement e = driver.findElement(By.xpath(xpath));
			e.clear();
			e.sendKeys(value);
			html.insertRow("Input", value, "", 1);
			System.out.println("Entered"+value);
		}catch(Exception e) {
			
			String loc = "C:\\\\Users\\\\i340909\\\\OneDrive - SAP SE\\\\Autothon\\\\screenshots\\\\error_"+screenshot_name;
			Screenshot.takeScreenshot(driver, "C:\\\\Users\\\\i340909\\\\OneDrive - SAP SE\\\\Autothon\\\\screenshots\\\\error_"+screenshot_name);
			System.out.println("Exception in enter input method -> xpath = "+xpath);
			html.insertRow("Input",e.getMessage(),loc, 0);
			throw new SeleniumScriptFailedException (e);
		}finally {
			
		}
		
	}
	
	public void enterInputAndSubmit(WebDriver driver,String xpath, String value,String screenshot_name, HTMLOutputWriter html) throws SeleniumScriptFailedException
	{
		
		try {
			//WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_WAIT_UNTIL);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			WebElement e = driver.findElement(By.xpath(xpath));
			e.clear();
			e.sendKeys(value);
			e.submit();
			html.insertRow("Input & Submit",value, "", 1);
			System.out.println("Entered & submitted"+value);
		}
		catch(Exception e) {
			String loc = "C:\\\\Users\\\\i340909\\\\OneDrive - SAP SE\\\\Autothon\\\\screenshots\\\\error_"+screenshot_name;
			Screenshot.takeScreenshot(driver, "C:\\\\Users\\\\i340909\\\\OneDrive - SAP SE\\\\Autothon\\\\screenshots\\\\error_"+screenshot_name);
			html.insertRow("Input & Submit",e.getMessage(), loc, 0);
			System.out.println("Exception in enter input and submit method -> xpath = "+xpath);
			throw new SeleniumScriptFailedException (e);
		}finally {
			
		}
		
		
	}
	
	
	public void findAndClickElement(WebDriver driver,String xpath,String screenshot_name, HTMLOutputWriter html) throws SeleniumScriptFailedException {
		
		
		try {
			//WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_WAIT_UNTIL);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			WebElement e = driver.findElement(By.xpath(xpath));
			e.click();
			html.insertRow("Click", xpath, "", 1);
			System.out.println("Clicked "+xpath+" Sucessfully");
			
			
			
			
		}
		catch(Exception ex)
		{
			String loc = "C:\\\\Users\\\\i340909\\\\OneDrive - SAP SE\\\\Autothon\\\\screenshots\\\\error_"+screenshot_name;
			System.out.println("Exception in enter find and click element method -> xpath = "+xpath);
			Screenshot.takeScreenshot(driver, "C:\\\\Users\\\\i340909\\\\OneDrive - SAP SE\\\\Autothon\\\\screenshots\\\\error_"+screenshot_name);
			html.insertRow("Click", ex.getMessage(),loc, 0);
			
			
			
			throw new SeleniumScriptFailedException (ex);
		}finally {
			
		}
		
	}
	
	public void goToPage(WebDriver driver,String url,String screenshot_name, HTMLOutputWriter html) throws SeleniumScriptFailedException {
		try{
			
			driver.get(url);
			html.insertRow("Navigate to", url , "", 1);
			
		}
		catch(Exception e) {
			String loc = "C:\\\\Users\\\\i340909\\\\OneDrive - SAP SE\\\\Autothon\\\\screenshots\\\\error_"+screenshot_name;
			Screenshot.takeScreenshot(driver, "C:\\\\Users\\\\i340909\\\\OneDrive - SAP SE\\\\Autothon\\\\screenshots\\\\error_"+screenshot_name);
			html.insertRow("Navigate to", e.getMessage(), loc , 0);
			System.out.println("Exception in Go to Page method");
			
			throw new SeleniumScriptFailedException (e);
		}finally {
			
		}
	}
	
	public String getDataFromElement(WebDriver driver,String xpath, String screenshot_name, HTMLOutputWriter html)
	{
		try {
			//WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_WAIT_UNTIL);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			WebElement e = driver.findElement(By.xpath(xpath));
			String text = e.getText();
			html.insertRow("Read", "" , text, 1);
			return text;
		}
		catch(Exception ex) {
			String loc = "C:\\\\Users\\\\i340909\\\\OneDrive - SAP SE\\\\Autothon\\\\screenshots\\\\error_"+screenshot_name;
			Screenshot.takeScreenshot(driver, loc);
			html.insertRow("Read", ex.getMessage() , loc, 0);
			System.out.println("Exception in get data from element method xpath ->"+xpath);
			return "";
			
		}finally {
			
		}
		
	}
	
	public void enterInputWithCssSelector(WebDriver driver,String cssSelector, String value,String screenshot_name, HTMLOutputWriter html) throws SeleniumScriptFailedException {
	try {
		WebElement e = driver.findElement(By.cssSelector(cssSelector));
		e.sendKeys(value);
		e.clear();
		e.sendKeys(value);
		html.insertRow("Input", value, "", 1);
		System.out.println("Entered"+value);
	}catch(Exception e) {
		
		String loc = "C:\\\\Users\\\\i340909\\\\OneDrive - SAP SE\\\\Autothon\\\\screenshots\\\\error_"+screenshot_name;
		Screenshot.takeScreenshot(driver, "C:\\\\Users\\\\i340909\\\\OneDrive - SAP SE\\\\Autothon\\\\screenshots\\\\error_"+screenshot_name);
		
		html.insertRow("Input",e.getMessage(),loc, 0);
		throw new SeleniumScriptFailedException (e);
	}finally {
		
	}
	
}

public void findAndClickElementWithCssSelector(WebDriver driver,String cssSelector,String screenshot_name, HTMLOutputWriter html) throws SeleniumScriptFailedException {
		
		
		try {
			//WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_WAIT_UNTIL);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			WebElement e = driver.findElement(By.cssSelector(cssSelector));
			e.click();
			html.insertRow("Click", "", "", 1);
			System.out.println("Clicked");
			
			
			driver.findElement(By.cssSelector(""));
			
		}
		catch(Exception ex)
		{
			String loc = "C:\\\\Users\\\\i340909\\\\OneDrive - SAP SE\\\\Autothon\\\\screenshots\\\\error_"+screenshot_name;
			Screenshot.takeScreenshot(driver, "C:\\\\Users\\\\i340909\\\\OneDrive - SAP SE\\\\Autothon\\\\screenshots\\\\error_"+screenshot_name);
			html.insertRow("Click", ex.getMessage(),loc, 0);
			System.out.println("Clicked");
			throw new SeleniumScriptFailedException (ex);
		}finally {
			
		}
		
	}	
	
public String getDataFromElementUsingCssSelector(WebDriver driver,String cssSelector, String screenshot_name, HTMLOutputWriter html)
{
	try {
		//WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_WAIT_UNTIL);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		WebElement e = driver.findElement(By.xpath(cssSelector));
		String text = e.getText();
		html.insertRow("Read", "" , text, 1);
		return text;
	}
	catch(Exception ex) {
		String loc = "C:\\\\Users\\\\i340909\\\\OneDrive - SAP SE\\\\Autothon\\\\screenshots\\\\error_"+screenshot_name;
		Screenshot.takeScreenshot(driver, loc);
		html.insertRow("Read", ex.getMessage() , loc, 0);
		return "";
		
	}finally {
		
	}
	
}
}
		
	
	

