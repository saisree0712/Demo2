package packone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OneTest {
	
	WebDriver driver;
	
	@Test
	public void testoneA() {
		
		//ChromeOptions options = new ChromeOptions();
		// options.addArguments("headless");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.get("http://tutorialsninja.com/demo/"); 
		
		driver.findElement(By.name("search")).sendKeys("HP");
		driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']")).click();
		
		
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("alert('saisree');");
		
	}
	
	@AfterMethod
	public void teardown(){
		
		driver.quit();
		
	}
	
   @Test
	public void testoneB() {
		
	}
}
