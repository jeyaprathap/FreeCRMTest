package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class AlertPopUpHandle {

	public static void main(String[] args) {


		
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\prath\\workspace\\FreeCRMTest\\chromedriver");
	//WebDriver driver = new ChromeDriver();
		
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\prath\\workspace\\FreeCRMTest\\geckodriver\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
	driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	
	driver.findElement(By.name("proceed")).click();
	Alert alert=driver.switchTo().alert();
	System.out.println(alert.getText());
	alert.accept();
		
		
		
	}

}
