package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	
	public WebDriver driver;
	
	public WebDriver webDriverManager() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String browser = System.getenv("browser") != null ? System.getenv("browser") : prop.getProperty("browser");
		String url = prop.getProperty("url");
		
		if(browser.equalsIgnoreCase("chrome")) {
			if(driver == null) {
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(url);
			}
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			if(driver == null) {
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.get(url);
			}
		}
		
		return driver;
	}
}
