package dockerSelenium;

import org.testng.annotations.Test;

//jenkins run:  java -jar jenkins.war

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

	@Test(priority = 1)
	public void runnerDockerGrid() throws Exception {
		Runtime.getRuntime().exec("cmd /c start start_dockerGrid.bat");
		Thread.sleep(50000);
	}

	@Test(priority = 2)
	public void testGoogleSearch() throws Exception {
//		String browser = System.getProperty("browser", "chrome");
//		DesiredCapabilities cap = new DesiredCapabilities();
		chromeBrowser();
		Thread.sleep(10000);
		fireFoxBrowser();
		Thread.sleep(10000);
		edgeBrowser();
		Thread.sleep(10000);
	}

	private void edgeBrowser() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("MicrosoftEdge");
		cap.setPlatform(Platform.LINUX);
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);

		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println("docker Browser: edgeBrowser  Title: " + title);
		driver.quit();
	}

	private void fireFoxBrowser() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.LINUX);
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);

		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println("docker Browser: fireFoxBrowser  Title: " + title);
		driver.quit();

	}

	private void chromeBrowser() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.LINUX);
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);

		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println("docker Browser: chromeBrowser  Title: " + title);
		driver.quit();

	}

	@Test(priority = 3)
	public void stopDockerGrid() throws Exception {
		Runtime.getRuntime().exec("cmd /c start stop_dockerGrid.bat");
		Thread.sleep(10000);
		Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
	}
}
