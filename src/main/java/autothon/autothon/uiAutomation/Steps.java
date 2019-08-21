package autothon.autothon.uiAutomation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import autothon.autothon.helper.*;

public class Steps extends Thread{

	
	
	String browser;
	String device;
	String status;
	WebDriver driver;
	
	
	public Steps(String browser, String device) {
		super();
		this.browser = browser;
		this.device = device;
		this.status = status;
		if(this.device.toLowerCase().equals("android") && this.browser.toLowerCase().equals("chrome") ) {
			try {
				this.driver = androidChromeFactory();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(this.device.toLowerCase().equals("windows") && this.browser.toLowerCase().equals("chrome") ) {
			try {
				this.driver = winChromeFactory();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(this.device.toLowerCase().equals("windows") && this.device.toLowerCase().equals("firefox") ) {
			try {
				this.driver = firefoxFactory();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private WebDriver androidChromeFactory() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();// DesiredCapabilities.android();
		cap.setCapability("deviceName", "Moto G (5S) Plus");
		cap.setCapability("udid", "ZY32285CLZ");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "8.1.0");
		cap.setCapability("browserName", "Chrome");
		//cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		WebDriver d = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), cap);
		
		return d;
	}

	private WebDriver firefoxFactory() throws MalformedURLException {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--start-maximized");
		//options.addArguments("--headless");
		//WebDriver d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		WebDriver d = new FirefoxDriver(options);
		return d;
	}

	private WebDriver winChromeFactory() throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		//options.addArguments("--headless");
		//WebDriver d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		WebDriver d = new ChromeDriver(options);
		return d;
	}

	public void startExecution() {
		
		SeleniumUtilities utl = new autothon.autothon.helper.SeleniumUtilities();
		 
		HTMLOutputWriter html = new HTMLOutputWriter(
				"C:\\Users\\i340909\\OneDrive - SAP SE\\Autothon\\Execution_Output\\" +device, "Logs");
		//1  open the url
		//
		try{
			
			html.createTable("Main");
			utl.goToPage(driver, "https://youtube.com", this.device+"_1.png", html); // go to you tube 1
			
			utl.enterInput(driver, "//form/div/div/input", "step-inforum", this.device+"2.png", html); // input in search bar 2
			utl.findAndClickElement(driver, "//form/button", "dummy", html); // click on search button 
			
			WebElement e = utl.findElement(driver, "//a[@href='/user/stepinforum' and @class='yt-simple-endpoint style-scope ytd-channel-renderer']"); //find the searched channel name;
			
			if(!e.isDisplayed()) {
				Thread.sleep(4000);
			}
			
			utl.clickElement(driver, e, this.device+"_3.png");  // click on the channel name 3 
			
			e = utl.findElement(driver, "//paper-tab/div[contains(text(),'Videos')]");
			if(!e.isDisplayed()) {
				Thread.sleep(4000);
			}
			
			utl.clickElement(driver, e, this.device+"_4.png");
			
			//utl.findAndClickElement(driver, "//*[@id=\"tabsContent\"]/paper-tab[2]/div",  this.device+"_4.png", html); // click on videos tab; 4
			
			// API call   String  5
			
//			WebElement element = utl.findElement(driver, "");  // find the video link from the entire list
//			utl.scrollDown(driver, element );  // scroll up tp the element 5
//			 
//			Screenshot.takeScreenshot(driver, device+"_6.png");
//			
//			utl.clickElement(driver, element, device+"_8.png");
			
			
			
					
		}
		catch (Exception e) {
			System.out.println("Exception E " + e.getMessage());
			html.closeTable(0);
			
		} finally {
			// html.closeHTML();
			html.closeHTML();
			html.cleanup();
			driver.quit();
		}
	
		
		
		
		
		
	}
	
	public void run() {
		startExecution();
	}
	
}
