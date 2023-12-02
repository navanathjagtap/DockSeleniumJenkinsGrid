package WithOutDocker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class GoogleSearchLocalSystem {

	public static void main(String[] args) {
		System.out.println("-----for chrome change the org.seleniumhq.selenium to 4.15.0-------");
		testGoogleSearch("chrome");
//		System.out.println("-----for firefox change the org.seleniumhq.selenium to 4.1.0-------");
//        testGoogleSearch("firefox");
//		System.out.println("-----for edge change the org.seleniumhq.selenium to 4.15.0-------");
//		testGoogleSearch("edgeBrowser");
	}

	public static void testGoogleSearch(String browser) {
		WebDriver driver;
		if ("chrome".equalsIgnoreCase(browser)) {
			System.out.println("----chrome---");
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if ("firefox".equalsIgnoreCase(browser)) {
			System.out.println("----firefox---");
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			driver = new FirefoxDriver(firefoxOptions);
		} else {
			try {
				System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
				driver = new EdgeDriver();
			} catch (Exception e) {
				throw new IllegalArgumentException("Invalid browser name: " + browser);
			}

		}
		try {
			System.out.println("------stared test case---------");
			driver.get("https://www.google.com");
			String title = driver.getTitle();
			System.out.println("Browser: " + browser + " - Title: " + title);
		} finally {
			driver.quit();
		}
	}
}
