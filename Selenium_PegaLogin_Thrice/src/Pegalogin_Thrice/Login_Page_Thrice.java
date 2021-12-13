
package Pegalogin_Thrice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login_Page_Thrice {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	@Parameters("LoginCount")
	@BeforeTest
		public void setup(String LoginCount) {
		
			if (LoginCount.equalsIgnoreCase("one")) {
				System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver.exe");
				driver = new ChromeDriver();
				} 
			
			else if (LoginCount.equalsIgnoreCase("two")) {
					System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver.exe");
					driver = new ChromeDriver();
				}
			
			else if (LoginCount.equalsIgnoreCase("thrice")) {
				System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
				
	}
	
	@Test
	public void launch_app() throws Exception {
	driver.get("https://pega-86-demo.iqzsystems.io/prweb/app/default/b0aUC_g2NnC90uEC3dhEbKXJdQTMkXeP*/!STANDARD");
	Thread.sleep(1000);
	}
	
	@Test (dependsOnMethods = "launch_app")
	public void enter_username() throws Exception {
	WebElement username = driver.findElement(By.xpath("//input[@id='txtUserID']"));
	username.sendKeys("tcapron");
	Thread.sleep(1000);
	}
	
	@Test (dependsOnMethods = "enter_username")
	public void enter_password() throws Exception {
	WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
	password.sendKeys("Password@123");
	Thread.sleep(1000);
	}
	
	@Test (dependsOnMethods = "enter_password")
	public void click_login() throws Exception {
	WebElement loginbutton = driver.findElement(By.xpath("//button[@id='sub']"));
	loginbutton.click();
	Thread.sleep(1000);
	}
	
	@Test (dependsOnMethods = "enter_password")
	public void get_title() throws Exception {
	System.out.println("Page title is : " + driver.getTitle());
	}
	
	@AfterTest
	public void finish() {
	driver.close();
	System.out.println("Test Run successful");
	}

}



