package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects1.HomePage;
import pageObjects1.LoginPage;
import pageObjects1.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String password, String exp_rst) {
		
		//homePage
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on my account link");
		hp.clickLogin();
		logger.info("clicked on login lnk under my account");
		
		
		//LoginPage
		LoginPage lp= new LoginPage(driver);
		logger.info("entering valid login credentials");
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
		
		//MyAccountPage
		MyAccountPage map= new MyAccountPage(driver);
		boolean targetPage = map.isMyAccountPageExists();
		
		if(exp_rst.equalsIgnoreCase("valid")) {
			if(targetPage==true) {
				map.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(exp_rst.equalsIgnoreCase("invalid")) {
			if(targetPage==true) {
				map.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
			

		}
		
		
		
	}
	

}
