import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAppium {
	private WebDriver driver = null;

	@BeforeTest
	public void setup() throws MalformedURLException {

		File appDir = new File(
				"./src/");
		File app = new File(appDir, "MainActivity.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("device", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability(CapabilityType.BROWSER_NAME, ""); // Name of
																		// mobile
																		// web
																		// browser
																		// to
																		// automate.
																		// Should
																		// be an
																		// empty
																		// string
																		// if
																		// automating
																		// an
																		// app
																		// instead.
		capabilities.setCapability("platformVersion", "5.0.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "vivo Y51L");
		capabilities.setCapability("app-package", "com.matesnetwork.cogdemo"); // Replace
																				// with
																				// your
																				// app's
																				// package
		capabilities.setCapability("app-activity",
				"com.matesnetwork.cogdemo.MainActivity"); // Replace with app's
															// Activity

		

		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);

	}

	@Test
	public void appiumExampleTest() throws Exception {
		driver.findElement(By.name("Login")).click();
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
