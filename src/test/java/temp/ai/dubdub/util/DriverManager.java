package temp.ai.dubdub.util;
import java.time.Duration; 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	 
	public static  WebDriver getDriver(String drivertype, String url) {
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		
		if(drivertype.equalsIgnoreCase("chrome") || drivertype=="") {
			driver  = new ChromeDriver();
		}
		else if(drivertype.equalsIgnoreCase("firefox")) {
			driver  = new FirefoxDriver();
		}else {
			driver  = new ChromeDriver();
		}
		Reporter.log("Driver setup : "+ drivertype );
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		driver.get(url);
		Reporter.log("The browser is opened with URL : "+ url +" |");
		return driver;
	}
	
}
