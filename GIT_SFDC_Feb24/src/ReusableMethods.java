import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableMethods {
	
	public static WebDriver driver;
	static ExtentTest logger;
	static ExtentReports report;
	
	
	public static void InitializeDriver()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void EnterText(WebElement element, String text, String ObjName)
	{
		if(element == null || !element.isDisplayed())
			logger.log(LogStatus.FAIL, ObjName + "Textbox is not found");	
		else
			logger.log(LogStatus.PASS, ObjName + "Textbox is found");
			element.sendKeys(text);
	}
	
	public static void Clickbutton(WebElement element, String ObjName)
	{
		if(element==null || !element.isDisplayed())
			logger.log(LogStatus.FAIL, ObjName + "Button is not found");
		else
			logger.log(LogStatus.PASS, ObjName + "Button is found");
			element.click();			
	}
	
//	public static void Click(WebElement element,String ObjName)
//	{
//		if(element==null || !element.isDisplayed())
//			logger.log(LogStatus.FAIL, ObjName+ " is not found");
//		else
//			logger.log(LogStatus.PASS, ObjName + " is found");
//			element.click();			
//	}
	
	public static void CreateReport()
	{
		String fileName = new SimpleDateFormat("'SFDCReport_'YYYYMMddHHmm'.html'").format(new Date());
		String path = "C:\\Users\\jyoth\\OneDrive\\Documents\\Jyothi_Tekarch_Training\\TestResult\\" + fileName;
		report = new ExtentReports(path);
	}
		
	public static void CloseReport() {
		report.flush();
	}
	
	public static void logintoSFDC() throws InterruptedException
	{
		logger = report.startTest("logintoSFDC");
		driver.get("https://login.salesforce.com/");
		Thread.sleep(1000);
		WebElement un = driver.findElement(By.id("username"));
		EnterText(un, "jyothi@abc.com", "username");
		Thread.sleep(2000);
		WebElement Pswd = driver.findElement(By.id("password"));
		EnterText(Pswd, "Samiksha14$", "password");
		WebElement LoginBtn = driver.findElement(By.id("Login"));
		Clickbutton(LoginBtn, "Login"); 
		logger.log(LogStatus.PASS, "Logged in successfully");
	}
	
}
