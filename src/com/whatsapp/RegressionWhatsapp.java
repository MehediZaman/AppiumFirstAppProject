package com.whatsapp;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class RegressionWhatsapp {
	
	 WebDriver driver;
	
	 	@Test
		public void testApp()  throws IOException, MalformedURLException{		

		File app = new File("E:\\Dropbox\\Downloads\\WhatsApp.apk");
		System.out.println("Launching App");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4.2");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy_S5_Sample");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.whatsapp");
		capabilities.setCapability("appActivity", "com.whatsapp.Main");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	 	
		 @AfterTest
		  public void teardown() {
			  driver.quit();
		      //driver.close();
			  System.out.println("Finished the tests successfully");
		  }
}


