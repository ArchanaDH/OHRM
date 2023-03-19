package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Utilities;

public class CreateESSUserPage {

	WebDriver driver;
	Utilities util;
	@FindBy(xpath = "//a/span[text()='PIM']")WebElement PIM;
	@FindBy(xpath = "//a[text()= 'Add Employee']")WebElement AddEmployee;
	@FindBy(name = "firstName")WebElement firstName;
	@FindBy(name = "lastName")WebElement lastName;
	@FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")WebElement ToggleCreateLogin;
	@FindBy(xpath = "(//input[@class = 'oxd-input oxd-input--active'])[2]")WebElement employeeID;
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")WebElement username;
	@FindBy(xpath = "((//div[@class = 'oxd-grid-2 orangehrm-full-width-grid'])[3]/div/div/div/input)[1]")WebElement password;
	@FindBy(xpath = "((//div[@class = 'oxd-grid-2 orangehrm-full-width-grid'])[3]/div/div/div/input)[2]")WebElement confirmPassword;
	@FindBy(xpath = "//button[@type='submit']")WebElement submit;
	@FindBy(xpath = "//a[text()= 'Employee List']")WebElement EmployeeList;
	@FindBy(xpath = "//span[text()='(1) Record Found']")WebElement empRecord;
	@FindBy(xpath = "//span[text() = 'Username already exists']")WebElement DuplicateUser;

	
	public CreateESSUserPage(WebDriver driver, Utilities util) {
		this.driver = driver;
		this.util = util;
		PageFactory.initElements(driver, this);
	}
	public String fillFormCreateESSUser(String firstnameESS, String lastnameESS, String usernameESS, String passwordESS) {

		PIM.click();
		AddEmployee.click();
		firstName.sendKeys(firstnameESS);
		lastName.sendKeys(lastnameESS);
		ToggleCreateLogin.click();

		String empID = util.getDataJSExecuter(employeeID);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));

		username.sendKeys(usernameESS);
		password.sendKeys(passwordESS);
		confirmPassword.sendKeys(passwordESS);
		submit.click();
		
		return empID;
	}

	public boolean searchEmployeeRecord(String empID, String testCaseName) {
		PIM.click();
		EmployeeList.click();
		employeeID.sendKeys(empID);
		submit.click();
		util.screenshot(testCaseName);

		if (empRecord.isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public boolean createESSUserWithExistingUsername(String firstnameESS, String lastnameESS, String usernameESS)
	{
		PIM.click();
		AddEmployee.click();
		firstName.sendKeys(firstnameESS);
		lastName.sendKeys(lastnameESS);
		ToggleCreateLogin.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));

		username.sendKeys(usernameESS);
				
		if (DuplicateUser.isDisplayed()) {
			return true;
		}
		return false;
	}
}
