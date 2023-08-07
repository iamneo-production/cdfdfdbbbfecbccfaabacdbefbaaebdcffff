package ai.iamneo.testing.Testing_Selenium_TestNg;

import org.testng.annotations.Test;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AppTest {

	ChromeOptions chromeOptions = new ChromeOptions();
	WebDriver driver = null;

	@BeforeTest
	public void beforeTest() throws Exception {
	//	System.setProperty("webdriver.chrome.driver", "/home/coder/project/workspace/Testing-with-Selenium-TestNg/chromedriver");
		driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
	}

	@Test
	public void testCase_1() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("https://amazon.com");
		List<WebElement> allLink = driver.findElements(By.tagName("a"));
		System.out.println("Number of links on a page : "+allLink.size());
		Thread.sleep(3000);
			
	}
	@Test
	public void testCase_2() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> allLink = driver.findElements(By.tagName("a"));
		for(WebElement link:allLink){
			System.out.println("Link Text :"+link.getText());
			System.out.println("Link Url :"+link.getAttribute("href"));
		}
		Thread.sleep(3000);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
