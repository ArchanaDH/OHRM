package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.OrangeHRMBase;
import Pages.CreateESSUserPage;
import Pages.LoginAdminPage;

public class CreateESSUserTest extends OrangeHRMBase {

	LoginAdminPage la;
	CreateESSUserPage cp;
	String usernameAdmin,passwordAdmin,firstnameESS,lastnameESS,usernameESS,passwordESS;

	@BeforeMethod
	public void browserConfiguration() {
		initialization();
		la = new LoginAdminPage(driver);
		cp = new CreateESSUserPage(driver,util);
		usernameAdmin = prop.getProperty("UsernameAdmin");
		passwordAdmin = prop.getProperty("PasswordAdmin");
		firstnameESS = prop.getProperty("ESSUserFirstName");
		lastnameESS = prop.getProperty("ESSUserLastName");
		usernameESS = prop.getProperty("UsernameESS");
		passwordESS = prop.getProperty("PasswordESS");
	}

	@Test
	public void createESSUserTest() {
		la.login(usernameAdmin, passwordAdmin);
		String empID = cp.fillFormCreateESSUser(firstnameESS,lastnameESS,usernameESS,passwordESS);
		Assert.assertTrue(cp.searchEmployeeRecord(empID, "createESSUserTest"));
	}

	@Test
	public void createESSUserWithExistingUsernameTest()
	{
		la.login(usernameAdmin, passwordAdmin);
		boolean val = cp.createESSUserWithExistingUsername(firstnameESS,lastnameESS,usernameESS);
		Assert.assertTrue(val);
	}
	
	@AfterMethod
	public void TearDown() {
		 closeBrowser();
	}
}
