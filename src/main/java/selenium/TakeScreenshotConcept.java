package selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import com.crm.qa.util.TestUtil;

public class TakeScreenshotConcept {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\prath\\workspace\\FreeCRMTest\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
		driver.get("http://www.google.com");
		
		//take screenshot and store as a file format
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// now copy the screenshot to desired location using copyfile method
		FileHandler.copy(src, new File("\\Users\\prath\\workspace\\FreeCRMTest\\src\\main\\java\\selenium\\google.png"));

	}

}
