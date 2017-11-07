package com.amazon;

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

import io.appium.java_client.android.AndroidDriver;

public class TestAppium_Backup {
	private WebDriver driver = null;

	@BeforeTest
	public void setup() throws MalformedURLException {

		File appDir = new File("C");
		// File app = new File(appDir, "TestedAndroidApp.apk");

		File app = new File(appDir, "KAYAK_5.5.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("device", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformVersion", "5.0.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "vivo Y51L");
		capabilities.setCapability("app-package", "com.kayak.android"); 
		capabilities.setCapability("app-activity", "com.kayak.android.Splash"); 

		// driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),
		// capabilities);
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}

	@Test
	public void appiumExampleTest() throws Exception {

		Thread.sleep(15000);
		driver.findElement(By.name("KAYAK")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("Sign up")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("Home Airport")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("from airport")).sendKeys("DEL");
		Thread.sleep(3000);
		driver.findElement(By.name("DEL: Delhi, India - Indira Gandhi Intl")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("Password")).click();
		driver.findElement(By
				.xpath("//android.widget.FrameLayout[0]/android.widget.LinearLayout[0]/android.widget.LinearLayout[1]/android.widget.LinearLayout[0]/android.widget.ScrollView[0]/android.widget.LinearLayout[0]/android.widget.LinearLayout[2]/android.widget.EditText"))
				.sendKeys("user123");

		Thread.sleep(5000);

	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
