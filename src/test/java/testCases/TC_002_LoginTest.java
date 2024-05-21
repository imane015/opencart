package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects1.HomePage;
import pageObjects1.LoginPage;
import pageObjects1.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	
	@Test(groups= {"sanity", "master"})
	public void verify_login() {
		logger.info("*** Starting TC_002_LoginTest *** ");
		logger.debug("capturing application debug logs...");
		
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on my account link");
		hp.clickLogin();
		logger.info("clicked on login lnk under my account");
		
		LoginPage lp= new LoginPage(driver);
		logger.info("entering valid login credentials");
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage map= new MyAccountPage(driver);
		boolean targetPage = map.isMyAccountPageExists();
		if(targetPage==true) {
			logger.info("Login test passed.....");
			Assert.assertTrue(true);
		}
		else {
			logger.error("Login Test failed.....");
			Assert.fail();
		}
		
	}

}
