package dockerSelenium;

import org.testng.annotations.Test;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {
	WebDriver driver = null;
	WebDriverWait wait;

	@Test
	public void testGoogleSearch() throws Exception {
		String browser = System.getProperty("browser", "chrome");
		DesiredCapabilities cap = new DesiredCapabilities();

		if (browser.contains("chrome")) {

			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.LINUX);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);

		} else if (browser.contains("firefox")) {
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.LINUX);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		} else {
			throw new IllegalArgumentException("Invalid browser name: " + browser);
		}
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);

		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println("docker Browser: " + browser + " - Title: " + title);
		driver.quit();
	}
}
