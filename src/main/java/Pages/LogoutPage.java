package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Utilities;

public class LogoutPage {

	WebDriver driver;
	Utilities util;
	@FindBy(xpath = "//i[@class = 'oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")WebElement logoutSelect;
	@FindBy(xpath = "//a[text() = 'Logout']")WebElement Logout;
	@FindBy(xpath = "//h5[text() = 'Login']")WebElement Login;
	
	
	public LogoutPage(WebDriver driver, Utilities util) {
		this.driver = driver;
		this.util = util;
		PageFactory.initElements(driver, this);
	}
	
	public void logout()
	{
		logoutSelect.click();
		util.applyWait(Duration.ofSeconds(3),Logout);
		Logout.click();
		util.applyWait(Duration.ofSeconds(5), Login);
	}
	
	public boolean verifyLogout()
	{
		return Login.isDisplayed();
	}
}
