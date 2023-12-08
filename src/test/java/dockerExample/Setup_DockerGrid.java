package dockerExample;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
//#Move this to docker selenium folder
public class Setup_DockerGrid {

	@BeforeTest
	void startDockerGrid() throws Exception {
		Runtime.getRuntime().exec("cmd /c start start_dockerGrid.bat");
		Thread.sleep(50000);
	}

	@AfterTest
	void stopDockerGrid() throws Exception {
		Runtime.getRuntime().exec("cmd /c start stop_dockerGrid.bat");
		Thread.sleep(5000);
		Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
	}
}
