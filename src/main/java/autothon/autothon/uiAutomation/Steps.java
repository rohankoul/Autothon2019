package autothon.autothon.uiAutomation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Steps extends Thread{

	
	
	String browser;
	String device;
	String status;
	WebDriver driver;
	
	
	public Steps(String browser, String device, String status) {
		super();
		this.browser = browser;
		this.device = device;
		this.status = status;
		if(this.device.toLowerCase().equals("android") && this.device.toLowerCase().equals("chrome") ) {
			try {
				this.driver = androidChromeFactory();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(this.device.toLowerCase().equals("windows") && this.device.toLowerCase().equals("chrome") ) {
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
		
		 
		//1  open the url
		
		//
		
		
		
		
		
		
	}
	
	public void run() {
		startExecution();
	}
	
}
