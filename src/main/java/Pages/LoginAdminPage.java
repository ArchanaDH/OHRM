package Pages;

import org.openqa.selenium.By;

import Base.OrangeHRMBase;

public class LoginAdminPage extends OrangeHRMBase {

	public void login(String usernameAdmin, String passwordAdmin) {

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(usernameAdmin);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passwordAdmin);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	public boolean validateLogin()
	{
		return driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();
	}
	
	public String getOHRMTitle()
	{
		return driver.getTitle();
	}

	public boolean checkInvalidCredentials()
	{
		return driver.findElement(By.xpath("//p[text()='Invalid credentials']")).isDisplayed();
	}
}
