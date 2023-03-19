package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.ExcelReader;
import Base.OrangeHRMBase;
import Pages.LoginAdminPage;

public class LoginAdminTest extends OrangeHRMBase {

	LoginAdminPage lp;

	@BeforeMethod
	public void browserConfig() {
		initialization();
		lp = new LoginAdminPage(driver);
	}

	@Test(priority = 0)
	public void verifyTitleTest() {
		String expectedTitle = "OrangeHRM";
		String actualTitle = lp.getOHRMTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(dataProvider = "getExcelData", priority = 1)
	public void adminLoginTest(String username, String password, String Type) 
	{
		if(username != null)
		{
			System.out.println("username : "+ username);
			lp.login(username, password);

			if (Type.equalsIgnoreCase("Valid")) {
				// for valid credentials- check successfull login
				Assert.assertTrue(lp.validateLogin());
			} else {
				// for invalid credentials - check message Invalid credentials
				Assert.assertTrue(lp.checkInvalidCredentials());
			}
		}
		
	}

	@DataProvider
	public Object[][] getExcelData() {

		String filePath = "E:\\EclipseWorkspace1\\Exclr_Project_OHRM\\src\\main\\java\\config\\data.xlsx";
		String sheetName = "LoginDataAdmin";
		try {
			ExcelReader reader = new ExcelReader();
			return reader.getData(filePath, sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}

}
