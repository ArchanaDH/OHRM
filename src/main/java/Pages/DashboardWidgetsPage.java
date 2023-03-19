package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardWidgetsPage {

	WebDriver driver;
	public DashboardWidgetsPage(WebDriver driver) {
		this.driver = driver;
	}
	public boolean checkTimeAtWorkWidget()
	{
		return driver.findElement(By.xpath("//p[text()='Time at Work']")).isDisplayed();
	}
	
	public boolean checkMyActionsWidget()
	{
		return driver.findElement(By.xpath("//p[text()='My Actions']")).isDisplayed();
	}
	
	public boolean checkQuickLaunchWidget()
	{
		return driver.findElement(By.xpath("//p[text()='Quick Launch']")).isDisplayed();
	}
	
	public boolean checkBuzzPostWidget()
	{
		return driver.findElement(By.xpath("//p[text()='Buzz Latest Posts']")).isDisplayed();
	}
	
	public boolean checkEmployeeOnLeaveTodayWidget()
	{
		return driver.findElement(By.xpath("//p[text()='Employees on Leave Today']")).isDisplayed();
	}
	
	public boolean checkEmployeeDistributionBySubUnitWidget()
	{
		return driver.findElement(By.xpath("//p[text()='Employee Distribution by Sub Unit']")).isDisplayed();
	}
	
	public boolean checkEmployeeDistributionByLocationWidget()
	{
		return driver.findElement(By.xpath("//p[text()='Employee Distribution by Location']")).isDisplayed();
	}
}
