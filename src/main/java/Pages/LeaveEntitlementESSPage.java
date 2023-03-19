package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Utilities;

public class LeaveEntitlementESSPage {

	WebDriver driver;
	Utilities util;
	@FindBy(xpath = "//span[text()='Leave']")WebElement LeaveLink;
	@FindBy(xpath = "//span[text() = 'Entitlements ']")WebElement EntitlementsLink;
	@FindBy(xpath = "//a[text() = 'My Entitlements']")WebElement MyEntitlements;
	@FindBy(xpath = "//div[text()= '10']")WebElement Days;
	@FindBy(xpath = "//span[text() = 'Reports ']")WebElement ReportsLink;
	@FindBy(xpath = "//a[text()='My Leave Entitlements and Usage Report']")WebElement UsageReportLink;
	@FindBy(xpath = "//div[@data-rgcol = '4' and @data-rgrow = '3']")WebElement PersonalLeaveBalance;
	@FindBy(xpath = "//a[text()='Apply']")WebElement ApplyLink;
	@FindBy(xpath = "//div[@class='oxd-select-wrapper']/div/div[@role='option']/span[text()='CAN - Personal']")
	WebElement LeaveType;
	@FindBy(xpath = "//div[@class = 'oxd-select-wrapper']/div/div")WebElement LeaveTypeSelect;
	@FindBy(xpath = "//input[@class = 'oxd-input oxd-input--active' and @placeholder = 'yyyy-mm-dd' ]")
	WebElement FromDate;
	@FindBy(xpath = "(//div[@class= 'oxd-calendar-date-wrapper'])[13]/div")WebElement InputDate;
	@FindBy(xpath = "//textarea[@class = 'oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")WebElement Comment;
	@FindBy(xpath = "//button[@type='submit']")WebElement Submit;
	@FindBy(xpath = "//a[text()='My Leave']")WebElement MyLeaveLink;
	@FindBy(xpath = "//div[text()='Personal Leave']")WebElement comment;
	@FindBy(xpath = "//button[@type='button' and text()=' Cancel ']")WebElement CancelLeave;
	@FindBy(xpath = "//div[text()='Cancelled (1.00)']")WebElement verifyLeaveCancelled;
	@FindBy(xpath = "//h5[text()='My Leave List']")WebElement MyLeaveList;
	
	public LeaveEntitlementESSPage(WebDriver driver, Utilities util) {
		this.driver = driver;
		this.util = util;
		PageFactory.initElements(driver, this);
	}
	
	public String verifyESSUserEntitlements()
	{
		LeaveLink.click();
		EntitlementsLink.click();
		MyEntitlements.click();
		return Days.getText();	
	}
	
	public String verifyESSUserLeaveUsageReport()
	{
		LeaveLink.click();
		ReportsLink.click();
		UsageReportLink.click();
		return PersonalLeaveBalance.getText();
	}
	
	public void applyLeave()
	{
		LeaveLink.click();
		ApplyLink.click();
		LeaveTypeSelect.click();
		LeaveType.click();
		FromDate.click();
		InputDate.click();
		Comment.sendKeys("Personal Leave");
		Submit.click();
	}
	
	public boolean verifyAppliedLeave()
	{
		LeaveLink.click();
		MyLeaveLink.click();
		return comment.isDisplayed();
	}
	public boolean cancleLeave()
	{
		LeaveLink.click();
		MyLeaveLink.click();
		CancelLeave.click();
		util.applyWait(Duration.ofSeconds(3), MyLeaveLink);
		return verifyLeaveCancelled.isDisplayed();
	}
}
