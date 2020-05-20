package e2eframework.scratch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseTwo {
	public static AppiumDriverLocalService service;

	public AppiumDriverLocalService startAppiumServer() throws InterruptedException {

		// Check if Appium Server is already running
		boolean flag = checkIfAppiumServerIsRunning(4723);

		if (!flag) { // true: start the server else not

			// Provided by Appium guys(help us to start server)
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
			Thread.sleep(20000);
		}

		return service;
	}

	public static boolean checkIfAppiumServerIsRunning(int port) {

		boolean isAppiumServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {

			// If control comes over here, then it means that the port is in use
			isAppiumServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isAppiumServerRunning;

	}

	public static void startEmulator() throws IOException, InterruptedException {

		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\startEmulator.bat");
		Thread.sleep(10000);
	}

	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\e2eframework\\scratch\\global.properties");

		Properties prop = new Properties();
		prop.load(fis);

		AndroidDriver<AndroidElement> driver;

		File appDir = new File("src");
		// Should not be hard-coded
		File app = new File(appDir, (String) prop.get(appName));

		DesiredCapabilities capabilities = new DesiredCapabilities();

		String device = (String) prop.get("device");

		if (device.contains("HEMUA_1")) {
			startEmulator();
		}
		Thread.sleep(20000);

		// Start Emulator
		/*
		 * "XXX.bat" file is used to execute commands
		 */

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		// Standard for Android (So no Hard-Coded)
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);

		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

}
