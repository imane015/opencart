package pageObjects1;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {
	WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement Password;
	
	
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement PrivacyPolicy;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement ContinueBtn;
	
	@FindBy(xpath= "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement ConfirmationMsg;
	
	
	public void setFirstname(String fname) {
		FirstName.sendKeys(fname);
	}
	public void setLastname(String lname) {
		LastName.sendKeys(lname);
	}
	public void setEmail(String email) {
		Email.clear();
		Email.sendKeys(email);
	}
	public void setPassword(String password) {
		Password.sendKeys(password);
	}
	
	
	public void setPrivacyPolicy() {
		new Actions(super.driver)
        .moveToElement(PrivacyPolicy, 1, 1) 
        .click()
        .perform();
//		PrivacyPolicy.click();

	}
	
	public void setRegisterBtn() {
		//sol1
		//ContinueBtn.click();
		//sol2 
//		ContinueBtn.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(RegisterBtn).click().perform();
					
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", ContinueBtn);
		
		//Sol 5
		//RegisterBtn.sendKeys(Keys.RETURN);
		
		//Sol6  
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(ContinueBtn)).click();
	}
	
	public String getConfirmationMsg() {
		try {
		return(ConfirmationMsg.getText());
		} catch (Exception e){
			return (e.getMessage());
		}
		
		
	}
	
		
	
	
	

}
