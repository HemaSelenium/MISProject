package common;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumHelper {
	public static WebDriver driver;
@Parameters({"Browser"})
	@Test
 public void Init(String Browser)  throws InterruptedException {
		String path = System.getProperty("user.dir");
		System.out.println(path);
		if(Browser.equalsIgnoreCase("chrome")) {
		System.out.println(1);
		System.setProperty("webdriver.chrome.driver", path+"/files/chromedriver.exe");
		driver=new ChromeDriver();
		Thread.sleep(4000);
			}
	else if(Browser.equalsIgnoreCase("firefox")) {
		System.out.println("firefox");
		System.setProperty("webdriver.gecko.driver", path+"/files/geckodriver.exe");
		System.out.println("firefox");
		driver=new FirefoxDriver();
		System.out.println("firefox");
		DesiredCapabilities capa = DesiredCapabilities.firefox();
		System.out.println("firefox");
		capa.setCapability("marionette", true);
				
		System.out.println("firefox");
		Thread.sleep(4000);
	}
			}

public void login(String Username,String Password) {
	
	driver.get("http://cpt.stageibb.com/cpt_stage/cpt_mis/Login");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.findElement(By.xpath("*//input[@name='username']")).click();
	driver.findElement(By.xpath("*//input[@name='username']")).sendKeys("admin");
	driver.findElement(By.xpath("*//input[@name='password']")).sendKeys("admin");
	
}




}
