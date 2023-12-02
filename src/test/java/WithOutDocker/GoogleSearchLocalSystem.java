package WithOutDocker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleSearchLocalSystem {

	public static void main(String[] args) {
		testGoogleSearch("chrome");
		System.out.println("-----for firefox change the org.seleniumhq.selenium to 4.1.0-------");
//        testGoogleSearch("firefox");
	}

	public static void testGoogleSearch(String browser) {
		WebDriver driver;
		if ("chrome".equalsIgnoreCase(browser)) {
			System.out.println("----chrome---");
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			driver = new ChromeDriver(chromeOptions);
		} else if ("firefox".equalsIgnoreCase(browser)) {
			System.out.println("----firefox---");
			System.setProperty("webdriver.gecko.driver", "C:/Users/navnath/Desktop/drivers/geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			driver = new FirefoxDriver(firefoxOptions);
		} else {
			throw new IllegalArgumentException("Invalid browser name: " + browser);
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
