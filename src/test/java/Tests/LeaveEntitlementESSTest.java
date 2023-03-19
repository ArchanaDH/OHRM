package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.OrangeHRMBase;
import Pages.LeaveEntitlementESSPage;
import Pages.LoginESSPage;

public class LeaveEntitlementESSTest extends OrangeHRMBase{
	
	LoginESSPage la;
	LeaveEntitlementESSPage lp;
	String usernameESS,passwordESS;

	@BeforeMethod
	public void browserConfiguration() {
		initialization();
		la = new LoginESSPage(driver);
		lp = new LeaveEntitlementESSPage(driver,util);
		usernameESS = prop.getProperty("UsernameESS");
		passwordESS = prop.getProperty("PasswordESS");
	}

	@Test
	public void verifyESSUserEntitlementsTest() {
		la.login(usernameESS, passwordESS);
		Assert.assertEquals(lp.verifyESSUserEntitlements(), "10");
	}

	@Test
	public void verifyESSUserLeaveUsageReportTest()
	{
		la.login(usernameESS, passwordESS);
		Assert.assertEquals(lp.verifyESSUserLeaveUsageReport(), "10.00");
	}

	@Test
	public void applyLeaveTest()
	{
		la.login(usernameESS, passwordESS);
		lp.applyLeave();
	}
	
	@Test
	public void verifyAppliedLeaveTest()
	{
		la.login(usernameESS, passwordESS);
		Assert.assertTrue(lp.verifyAppliedLeave());	
	}
	
	 @Test public void cancleLeaveTest() {
	 
		 la.login(usernameESS, passwordESS);
		 Assert.assertTrue(lp.cancleLeave());
	 }
	
	@AfterMethod
	public void TearDown() {
		closeBrowser();
	}
}
