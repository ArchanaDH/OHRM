package Base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMBase {

	public static WebDriver driver;
	public Properties prop;
	public static Utilities util;

	public void initialization() {
		try {

			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");

			FirefoxOptions optionsFirefox = new FirefoxOptions();
			optionsFirefox.addArguments("--remote-allow-origins=*");

			loadProperties();
			String browser = prop.getProperty("browser");
			String url = prop.getProperty("URL");

			if (browser.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver(options);
			} else if (browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver(optionsFirefox);
			} else {
				throw new Exception("Enter Correct Browser Name");
			}
			util = new Utilities();
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadProperties() {
		String configFile = "..\\Exclr_proj_OHRM\\src\\main\\java\\config\\config.properties";
		try {
			FileInputStream file = new FileInputStream(configFile);
			prop = new Properties();
			prop.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void closeBrowser() {
		driver.quit();
	}
}
