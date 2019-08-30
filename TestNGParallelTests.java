package testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGParallelTests {
	
	@BeforeClass
	void setUpClass() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/patri/Downloads/chromedriver.exe");
	}
	
	@Test
	void calcTest() {			
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");	
		
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("2 + 3");
		element.submit();
			
		WebElement result = driver.findElement(By.id("cwos"));
		AssertJUnit.assertEquals(result.getText(), "5");
	}
	
	@Test
	void searchTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Selenium WebDriver");
		element.submit();
		
		AssertJUnit.assertTrue(driver.getTitle().startsWith("Selenium WebDriver"));
	}

	
}
