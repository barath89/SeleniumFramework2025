package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LogInTest extends BaseClass{
	
	@Test(groups= {"Regression","Master"})
	public void verify_LogIn() {
		try {
		logger.info("***Starting TC_002_LogInTes****");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLoginBtn();
		
		MyAccountPage ap = new MyAccountPage(driver);
		Boolean targetPage = ap.isMyAccountExist();
		Assert.assertTrue(targetPage);
		
		ap.clickLogout();
		
		}
		catch (Exception e) {
			Assert.fail();
		}
		finally {
			logger.info("***Finished TC_002_LogInTes****");
		}
	}

}
