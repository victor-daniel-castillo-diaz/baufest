package com.baufest.po;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class BasePage {
	private static AppiumDriverLocalService localAppiumServer;
	public static AppiumDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
    private By loginButton = By.xpath("//android.widget.Button[@content-desc='Login']");
    private By formButton = By.xpath("//android.widget.Button[@content-desc='Forms']");
    private By webViewButton = By.xpath("//android.widget.Button[@content-desc='Webview']");

	public BasePage() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\com\\baufest\\config.properties");
		prop.load(fis);
	}
	
    public static URL getAppiumServerUrl() {
        return localAppiumServer.getUrl();
    }

    public static AppiumDriver createAppiumDriver(URL appiumServerUrl, String udid) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.wdiodemoapp");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.wdiodemoapp.MainActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability("appium:chromedriverExecutable", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
        AppiumDriver<AndroidElement> appiumDriver = new AppiumDriver<>(appiumServerUrl, capabilities);
		System.out.println(String.format("Created AppiumDriver for device %s on %s", udid, appiumServerUrl));
		return appiumDriver;
    }

	public static void setUp() {
	    AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.usingAnyFreePort();
        localAppiumServer = AppiumDriverLocalService.buildService(serviceBuilder);
        localAppiumServer.start();
        System.out.println(String.format("Appium server started on url: '%s'", localAppiumServer.getUrl().toString()));
        String udid = prop.getProperty("udid");
        driver = createAppiumDriver(getAppiumServerUrl(), udid);
        wait = new WebDriverWait(driver, 30);
	}

	public static void quit() {
		if (null != driver) {
            driver.quit();
        }
	}

    public LogInPage clickLoginButton() throws Exception {
        driver.findElement(loginButton).click();
		return new LogInPage();
	}

    public FormPage clickFormButton() throws Exception {
        driver.findElement(formButton).click();
		return new FormPage();
	}

    public WebviewPage clickWebviewButton() throws Exception {
        driver.findElement(webViewButton).click();
		return new WebviewPage();
	}

}