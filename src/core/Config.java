package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import utils.Constants;
import utils.Enums.Browsers;

public class Config {

	private WebDriver driver = null;
	private static Config instance;

	public static Config getInstance() {
		if (instance == null) {
			instance = new Config();
		}
		return instance;
	}

	/**
	 * This method is used to initialize the driver depending on the type of browser
	 * @param browserType
	 */
	public void initializeDriver(Browsers browserType) {
		switch (browserType) {
		case FIREFOX:
			System.setProperty("webdriver.firefox.driver","C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
			driver = new FirefoxDriver();
			break;
		case IE:
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "/seleniumdrivers/IEDriver.msu");
			driver = new InternetExplorerDriver();
			break;
		case CHROME:
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ "/seleniumdrivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case SAFARI:
			driver = new SafariDriver();
			break;
		default:
			new Exception("Browser not supported");
		}
		Constants.Browser=browserType.toString();
		// Implicit method to maximize browser
		driver.manage().window().maximize();
		// Implicit method to wait until document is ready
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	}
	
	/**
	 * This method is used to close the driver instantiated
	 */
	public void quitDriver() {
		driver.quit();
	}
	
	/**
	 * This method is used to get the driver instantiated
	 */
	public WebDriver getDriver() {
		return driver;
	}
	
	//TODO
	public void setProfile(){
		
	}
}
