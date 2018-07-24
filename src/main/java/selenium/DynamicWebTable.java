package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class DynamicWebTable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\prath\\workspace\\FreeCRMTest\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
		driver.get("https://www.freecrm.com");
		
		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.switchTo().frame("mainpanel");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		//*[@id="vContactsForm"]/table/tbody/tr[4]/td[2]/a
		//*[@id="vContactsForm"]/table/tbody/tr[5]/td[2]/a
		//*[@id="vContactsForm"]/table/tbody/tr[6]/td[2]/a
		//*[@id="vContactsForm"]/table/tbody/tr[7]/td[2]/a
		
		//method 1
		
//		String before_xpath="//*[@id='vContactsForm']/table/tbody/tr[";
//		String after_xpath="]/td[2]/a";
//		
//		for(int i=4; i<=17;i++){
//			String name = driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
//			System.out.println(name);
//			if(name.contains("sonali sarolkar")){
//				driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr["+i+"]/td[1]/input")).click();
//			}
//		}
		
		//Method 2
		
		driver.findElement(By.xpath("//a[contains(text(),'sonali sarolkar')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
		
		
		
		

	}

}
