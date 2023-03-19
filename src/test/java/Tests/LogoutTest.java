package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.OrangeHRMBase;
import Pages.LoginAdminPage;
import Pages.LogoutPage;

public class LogoutTest extends OrangeHRMBase{
	
	LogoutPage lout;
	LoginAdminPage la;
	String usernameAdmin,passwordAdmin,usernameESS,passwordESS;
	
	@BeforeMethod
	public void browserConfig() {
		initialization();
		la = new LoginAdminPage(driver);
		lout = new LogoutPage(driver,util);
		usernameAdmin = prop.getProperty("UsernameAdmin");
		passwordAdmin = prop.getProperty("PasswordAdmin");
		usernameESS = prop.getProperty("UsernameESS");
		passwordESS = prop.getProperty("PasswordESS");
	}

	@Test
	public void logoutAdminUserTest() {
		la.login(usernameAdmin, passwordAdmin);
		lout.logout();
		Assert.assertTrue(lout.verifyLogout());
	}
	
	@Test
	public void logoutESSUserTest() {
		la.login(usernameESS, passwordESS);
		lout.logout();
		Assert.assertTrue(lout.verifyLogout());
	}

	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}

}
