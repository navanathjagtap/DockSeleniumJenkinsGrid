package webDriverManager; 

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleSearchUsingWebDriverManager {

	public static void main(String[] args) {
		System.out.println("-----for firefox change the org.seleniumhq.selenium to 4.15.0 for chrome-------");
		testGoogleSearch("chrome");
//		System.out.println("-----for firefox change the org.seleniumhq.selenium to 4.1.0 for firefox-------");
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
			WebDriverManager.firefoxdriver().setup();	
			driver = new FirefoxDriver();
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