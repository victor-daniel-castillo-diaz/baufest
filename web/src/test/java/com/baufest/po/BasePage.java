package com.baufest.po;

import com.baufest.util.Constant;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	private By signUpLink = By.id("signin2");
	private By logInLink = By.id("login2");
	private By logOutLink = By.id("logout2");
	private By cartLink = By.id("cartur");

	public BasePage() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\com\\baufest\\config.properties");
		prop.load(fis);
	}

	public static void setUp() {
		String browser = prop.getProperty("browser");
		try {
			if (browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", chromePrefs);
				driver = new ChromeDriver(options);
			}
			if (browser.equalsIgnoreCase("Opera")) {
				System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "\\resources\\operadriver.exe");
				driver = new OperaDriver();
			}
			if (browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\resources\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			if (browser.equalsIgnoreCase("Edge")) {
				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\resources\\msedgedriver.exe");
				driver = new EdgeDriver();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constant.IMPLICITY_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Constant.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		wait = new WebDriverWait(driver, 30);
	}
	
	public String getAlertMessage() throws Exception
    {   String message = null;
    	int i = 0;
        try
        {   while (i++ < 3)
            {   try
                {	wait.until(ExpectedConditions.alertIsPresent());
                    Alert alert = driver.switchTo().alert();
                    message = alert.getText();    
                    }catch (NoAlertPresentException nape)
                    {   continue;
                    }catch (UnhandledAlertException uae)
                    {   continue;
                }
            }
        }catch (Exception e)
        {   throw new Exception("no fue posible obtener el mensaje ", e);
		}
        return message;
    }

	public String acceptAlert(String expectedMessage) throws Exception
    {   String message = null;
    	int i = 0;
        try
        {   while (i++ < 3)
            {   try
                {	wait.until(ExpectedConditions.alertIsPresent());
                    Alert alert = driver.switchTo().alert();
                    message = alert.getText();
                    if (message != null)
                    {   if (!message.contains(expectedMessage))
                        {   throw new Exception("se esperaba mensaje  " + expectedMessage + "pero se encontro " + message);
                            }
                            alert.accept();
                            break;
                        }
                    }catch (NoAlertPresentException nape)
                    {   continue;
                    }catch (UnhandledAlertException uae)
                    {   continue;
                    }
                }
            }catch (Exception e)
            {   throw new Exception("no fue posible aceptar el mensaje " + message, e);
			}
            return message;
    }

	public static void quit() {
		driver.quit();
	}

	public SignUpPage clickSigUpLink() throws Exception {
		driver.findElement(signUpLink).click();
		return new SignUpPage();
	}

	public SignUpPage clickLogInLink() throws Exception {
		driver.findElement(logInLink).click();
		return new SignUpPage();
	}

	public SignUpPage clickLogOutLink() throws Exception {
		driver.findElement(logOutLink).click();
		return new SignUpPage();
	}

	public CartPage clickCartLink() throws Exception {
		driver.findElement(cartLink).click();
		return new CartPage();
	}
}