package Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cross_Browser

{
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
		@Parameters ("browserName")
	 
		@BeforeTest
		
		public void setup(String browserName) 
		{
					
		if (browserName.equalsIgnoreCase("chrome")) 
			{
			System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			} 
		else if (browserName.equalsIgnoreCase("edge")) 
			{
			System.setProperty("webdriver.edge.driver", projectPath+"/Drivers/msedgedriver.exe");
			driver = new EdgeDriver();
			}
	
		}
 
		@Test
		public void testYahoo() throws Exception
		{
			driver.get("https://yahoo.com");
			Thread.sleep(5000);
		}
		
		@Test
		public void testGoogle() throws Exception
		{
			driver.get("https://google.com");
			Thread.sleep(5000);
		}
		
		@AfterTest
		public void finish() {
		driver.quit();
		System.out.println("Test is successful");
		}
}


