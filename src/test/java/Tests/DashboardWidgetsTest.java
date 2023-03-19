package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.OrangeHRMBase;
import Pages.DashboardWidgetsPage;
import Pages.LoginAdminPage;

public class DashboardWidgetsTest extends OrangeHRMBase{

	LoginAdminPage la;
	DashboardWidgetsPage dp;
	
	@BeforeMethod
	public void browserConfiguration()
	{
		initialization();
		la = new LoginAdminPage(driver);
		dp = new DashboardWidgetsPage(driver);
	}
	
	@Test
	public void checkWidgetsAdminTest()
	{
		la.login(prop.getProperty("UsernameAdmin"), prop.getProperty("PasswordAdmin"));
		
		Assert.assertTrue(dp.checkTimeAtWorkWidget());
		Assert.assertTrue(dp.checkMyActionsWidget());
		Assert.assertTrue(dp.checkQuickLaunchWidget());
		Assert.assertTrue(dp.checkBuzzPostWidget());
		Assert.assertTrue(dp.checkEmployeeOnLeaveTodayWidget());
		Assert.assertTrue(dp.checkEmployeeDistributionBySubUnitWidget());
		Assert.assertTrue(dp.checkEmployeeDistributionByLocationWidget());
	}
	
	@Test
	public void checkWidgetsESSTest()
	{
		la.login(prop.getProperty("UsernameESS"), prop.getProperty("PasswordESS"));
		Assert.assertTrue(dp.checkTimeAtWorkWidget());
		Assert.assertTrue(dp.checkMyActionsWidget());
		Assert.assertTrue(dp.checkQuickLaunchWidget());
		Assert.assertTrue(dp.checkBuzzPostWidget());
		Assert.assertTrue(dp.checkEmployeeOnLeaveTodayWidget());
	}
	
	@AfterMethod
	public void TearDown()
	{
		closeBrowser();
	}
}
