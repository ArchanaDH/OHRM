package Base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMBase {

	public static WebDriver driver;
	public static Properties prop;

	public void initialization() {
		try {

			WebDriverManager.chromedriver().setup();

			loadProperties();
			String browser = prop.getProperty("browser");
			String url = prop.getProperty("URL");

			if (browser.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			} else {
				throw new Exception("Enter Correct Browser Name");
			}
			
			driver.get(url);	
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadProperties()
	{
		String configFile = "..\\Exclr_Project_OHRM\\src\\main\\java\\config\\config.properties";
		try {
			FileInputStream file = new FileInputStream(configFile);
			prop = new Properties();
			prop.load(file);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
}
