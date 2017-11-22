package com.tests;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;

public class TestSampleAndriodTests {

	private WebDriver driver = null;

	@Before
	public void setup() throws MalformedURLException {

		// File appDir = new File("C");
		// File app = new File(appDir, "TestedAndroidApp.apk");

		File app = new File("./Application/app-debug.apk");
		File file = app.getAbsoluteFile();

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("device", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformVersion", "5.0.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "vivo Y51L");
		capabilities.setCapability("app-package", "dimysik.new_norm.dnepr.ukuarin.goodx-1");
		capabilities.setCapability("app-activity", "dimysik.new_norm.dnepr.ukuarin.goodx.activity.SplashActivity");

		// driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),
		// capabilities);
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}

	@Test
	public void TestappiumExampleTest() throws Exception {

		Thread.sleep(1000);
		driver.findElement(By.id("dimysik.new_norm.dnepr.ukraine.goodx:id/tv_start")).click();
		screenshot("Target/");
		driver.findElement(By.id("dimysik.new_norm.dnepr.ukraine.goodx:id/et_login")).sendKeys("alex");
		screenshot("Target/");
		driver.findElement(By.id("dimysik.new_norm.dnepr.ukraine.goodx:id/et_password")).sendKeys("asdf123$567GHJK");
		screenshot("Target/");
		driver.findElement(By.id("dimysik.new_norm.dnepr.ukraine.goodx:id/bt_login")).click();
		Thread.sleep(5000);
		screenshot("Target/");
		driver.findElement(By.id("dimysik.new_norm.dnepr.ukraine.goodx:id/iv_toolbar_hamburger")).click();
		;
		screenshot("Target/");
	}

	
	public void screenshot(String path_screenshot) throws IOException {
		File srcFile = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
		String filename = UUID.randomUUID().toString();
		File targetFile = new File(path_screenshot + filename + ".jpg");
		FileUtils.copyFile(srcFile, targetFile);
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
