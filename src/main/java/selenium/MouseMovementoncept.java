package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.qa.util.TestUtil;

public class MouseMovementoncept {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\prath\\workspace\\FreeCRMTest\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
		driver.get("https://giftshop.eventcinemas.com.au/Category/MovieGiftVouchers");
		
		Actions action =new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("By Type"))).build().perform();
		driver.findElement(By.linkText("eGift Cards")).click();

	}

}
