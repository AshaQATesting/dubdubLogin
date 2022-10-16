package temp.ai.dubdub.po; 

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class PO_Login {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@type='text']")
	WebElement eleEmail;
	
	
	@FindBy(css="input[type='password']")
	WebElement elePass;
	
	@FindBy(tagName="button")
	WebElement eleButton;
	
	public PO_Login(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	private void setEmail(String emailVal) {
		eleEmail.sendKeys(emailVal);
		Reporter.log(" EmailId set : "+ emailVal +" | " );
	}
	
	
	private void setPassword(String passVal) {
		elePass.sendKeys(passVal);
		Reporter.log("  Password set : "+ passVal +" | " );
	}
	private void clickButton() {
		eleButton.click();
		Reporter.log(" Submit utton clicked | " );
	}
	
	public void loginPerform(String emailVal, String passVal) {
		this.resetForm();
		this.setEmail(emailVal);
		this.setPassword(passVal);
		this.clickButton();
		Reporter.log(" Login Perform Done | ");
	}
	
	 
	private void resetForm() { 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) { 
			e.printStackTrace();
		}
		eleEmail.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE)); 
		eleEmail.clear();  
		elePass.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE)); 
		elePass.clear();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) { 
			e.printStackTrace();
		}
	}


}
