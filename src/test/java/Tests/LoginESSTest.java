package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import Base.ExcelReader;
import Base.OrangeHRMBase;
import Pages.LoginESSPage;

public class LoginESSTest extends OrangeHRMBase{

	LoginESSPage ls;
	
	@BeforeMethod
	public void browserConfig()
	{
		initialization();
		ls = new LoginESSPage();
	}
	
	@Test(priority = 0)
	public void verifyTitleTest()
	{
		String expectedTitle = "OrangeHRM";
		String actualTitle = ls.getOHRMTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(dataProvider = "getExcelData", priority = 1)
	public void loginTest(String username, String password, String Type)
	{
		if(username != null)
		{
			ls.login(username, password);
			if(Type.equalsIgnoreCase("Valid"))
			{
				Assert.assertTrue(ls.validateLogin());
			}
			else
			{
				Assert.assertTrue(ls.checkInvalidCredentials());
			}
		}
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException
	{
		ExcelReader reader = new ExcelReader();
		String filePath = "..\\Exclr_Project_OHRM\\src\\main\\java\\config\\data.xlsx";
		String sheetName = "LoginDataESS";
		return reader.getData(filePath, sheetName);
	}
	
	@AfterMethod
	public void tearDown()
	{
		closeBrowser();
	}
}
