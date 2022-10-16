package temp.ai.dubdub.tc;
  

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import temp.ai.dubdub.util.DriverManager;
import temp.ai.dubdub.po.PO_Login;

public class TC_Login {
	
	WebDriver driver;
	
	@BeforeTest
	public void setDriver() { 
		driver = DriverManager.getDriver("", "https://z3t0c9.csb.app/"); 
		// getDriver is static function so we can access by class name		
	}
	
	
	@Test(dataProvider="loginCredential")
	public void tc_01_login(String scenario, String email, String password) {
		
		Reporter.log(" tc_"+scenario+"_login Start | ");
		PO_Login po_loginObj = new PO_Login(driver);
		po_loginObj.loginPerform(email, password);
		Reporter.log(" tc_"+scenario+"_login End | "); 
		
	}
	
	
	@DataProvider(name="loginCredential")
	public Object[][] getData(){
		
		String[][] testLoginData = { 
									{"both_empty", "", ""}, 
									{"pass_empty", "test@gmail.com", ""}, 
									{"email_empty", "", "123456"}, 
									{"both_wrong", "wrong@gmail.com", "xyz123"}, 
									{"both_correct", "test@gmail.com", "123456"} 
								};
		return testLoginData;
	}
	
	
}
