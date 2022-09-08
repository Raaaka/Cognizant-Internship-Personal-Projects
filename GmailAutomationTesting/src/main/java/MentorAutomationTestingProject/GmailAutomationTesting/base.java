package MentorAutomationTestingProject.GmailAutomationTesting;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class base {
	public WebDriver driver;
	public Properties prop;

	// this function is used to create the driver.//
	public void invokeBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\driver\\chromedriver.exe");
			driver = new ChromeDriver();

			driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);

			if (prop == null) {
				prop = new Properties();
				try {
					FileInputStream file = new FileInputStream(System.getProperty("user.dir")
							+ "\\src\\test\\resources\\ObjectProperties\\configure.properties");
					prop.load(file);
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		}
	}

	// function to accept the websiteUrl then call "get" function and then call the
	// driver object.
	public void openWebsite(String websiteUrl) {
		driver.get(prop.getProperty(websiteUrl));
	}

	// to close the browser
	public void tearDown() {
		driver.close();
	}

	// to quit the driver
	public void quitBrowser() {
		driver.quit();
	}

	// to enter any text into the website, it accepts both locator and url, it calls
	// getEelement fucntion created below.
	public void enterText(String locator, String value) {
		getElement(locator).sendKeys(prop.getProperty(value));

	}

	// to click on radion button or to click on webElement
	public void clickElement(String locator) {
		getElement(locator).click();

	}

	// to perform assert function
	public void assertFunction(String expectedTitle) {
		String actual = driver.getTitle();
		Assert.assertEquals(actual, prop.getProperty(expectedTitle));
		System.out.println(actual);
	}

	// to compare any text on website with a harcode value.
	public void textCompare(String locator, String value) {
		String actual = getElement(locator).getText();
		Assert.assertEquals(actual, prop.getProperty(value));
		System.out.println(actual);

	}

	// to print value to console extracted from the website.
	public void printText(String locator) {
		String text = getElement(locator).getText();
		System.out.println(text);
	}

	// to get an element from website, its return type is webElement.
	public WebElement getElement(String locator) {
		WebElement element = null;

		if (locator.endsWith("xpath")) {
			element = driver.findElement(By.xpath(prop.getProperty(locator)));
		} else if (locator.endsWith("id")) {
			element = driver.findElement(By.id(prop.getProperty(locator)));
		}
		return element;

	}
}
