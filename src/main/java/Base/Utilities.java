package Base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities extends OrangeHRMBase{

	public void screenshot(String TestCaseName)
	{
		String destFileName = "./Screenshots/"+TestCaseName+".png";
		try {
			File destFile = new File(destFileName);
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File srcFile =screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void jscriptExecuter(String key, Object args)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(key, args);	
	}
	public String  getDataJSExecuter(Object args)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String data =(String) jsExecutor.executeScript("return arguments[0].value", args);
		return data;
	}
	
	public void applyWait(Duration duration, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
