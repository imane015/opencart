package testCases;

import org.testng.annotations.Test;

import org.testng.Assert;

import pageObjects1.AccountRegistrationPage;
import pageObjects1.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"regression", "master"})
	public void verify_account_registration() {
		logger.info("***starting TC_001_AccountRegistrationTest***");
		logger.debug("application logs....");
		
		try {
			
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("clicked on MyAccount");
			hp.clickRegister();
			logger.info("clicked on Register");
			logger.info("Entering costumer details");
			
			
			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			regpage.setFirstname(randomeString().toUpperCase());
            regpage.setLastname(randomeString().toUpperCase());
            regpage.setEmail(randomeString() + "@gmail.com");
			regpage.setPassword(randomeAlphaNumeric());
			regpage.setPrivacyPolicy();
			regpage.setRegisterBtn();
			logger.info("clicked on continue...");
			

			String confmsg = regpage.getConfirmationMsg();
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		} catch (AssertionError|Exception e) {
			logger.error("test failed...", e);
			Assert.fail();
		}

		logger.info("***finished TC_001_AccountRegistrationTest***");

	}

}
