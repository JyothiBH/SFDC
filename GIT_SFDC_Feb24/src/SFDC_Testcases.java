
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class SFDC_Testcases extends ReusableMethods{

		public static void main(String[] args) throws InterruptedException, AWTException
		{
			
		InitializeDriver();
		CreateReport();
		
		//LoginErrorMessage1();
		//LoginToSalesForce2();
		//CheckRemeberMe3();
		//ForgotPassword4A();
		//TC05();
		//TC06();
		 //TC07();
		//TC08();
		//TC09();
		//TC10CreateAccount();
		//TC11Createnewview();
		//TC13MergeAccounts();
		//TC14();
		//TC15();
		//TC16();
		//TC17();
		//TC20leadsTab();
		//TC21leadsSelectView();
		//TC22defaultView();
		//TC23();
		//TC24();
		//TC25();
		//TC26();
		//TC27();
		//TC28();
		//TC29();
		//TC30();
		//TC31();
		TC34();
		
		CloseReport();
		}
		
		
		public static void LoginErrorMessage1() throws InterruptedException
		{
		logger = report.startTest("LoginErrorMessage1");
		driver.get("https://login.salesforce.com/");
		Thread.sleep(1000);
		WebElement uname = driver.findElement(By.id("username"));
		EnterText(uname, "jyothi@abc.com", "username");
		WebElement Pswd = driver.findElement(By.id("password"));
		Pswd.clear();
		WebElement LoginBtn = driver.findElement(By.id("Login"));
		Clickbutton(LoginBtn, "Login");
		Thread.sleep(2000);
		String ExpectedText = "Please enter your password.";
		String ActualText   = driver.findElement(By.xpath("//*[@id=\"error\"]")).getText();
		if(ActualText.contentEquals(ExpectedText))	
			logger.log(LogStatus.PASS, "The Error Message is displayed as expected");
		else
			logger.log(LogStatus.FAIL, "The Error message is NOT displayed as expected");
		Thread.sleep(2000);
		driver.quit();
		}   
	
	public static void LoginToSalesForce2() throws InterruptedException
	{
		logger = report.startTest("LoginToSalesForce2");
		driver.get("https://login.salesforce.com/");
		Thread.sleep(2000);
		WebElement un = driver.findElement(By.id("username"));
		EnterText(un, "jyothi@abc.com", "username");
		Thread.sleep(2000);
		WebElement Pswd = driver.findElement(By.id("password"));
		EnterText(Pswd, "Samiksha14$", "password");
		WebElement LoginBtn = driver.findElement(By.id("Login"));
		Clickbutton(LoginBtn, "Login");
		WebElement Hometab = driver.findElement(By.id("home_Tab"));
		if (Hometab.isDisplayed() == true)
			logger.log(LogStatus.PASS, "Login to SalesForce application is Successful");
		else
			logger.log(LogStatus.FAIL, "Login to SalesForce application is UnSuccessful");
			
		Thread.sleep(5000);
		driver.quit();
	}
	 
	public static void CheckRemeberMe3() throws InterruptedException 
	{
		logger = report.startTest("CheckRemeberMe3");
		InitializeDriver();
		driver.get("https://login.salesforce.com/");
		Thread.sleep(2000);
		WebElement un = driver.findElement(By.id("username"));
		EnterText(un, "jyothi@abc.com", "username");
		Thread.sleep(2000);
		WebElement Pswd = driver.findElement(By.id("password"));
		EnterText(Pswd, "Samiksha14$", "password");
		WebElement remembr = driver.findElement(By.id("rememberUn"));
		remembr.click();;
		WebElement LoginBtn = driver.findElement(By.id("Login"));
		Clickbutton(LoginBtn, "Login");
		Thread.sleep(1000);
		WebElement UserMenuDropdwn = driver.findElement(By.id("userNavLabel"));
		UserMenuDropdwn.click();
		WebElement Logout = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
		Logout.click();
		Thread.sleep(2000);
		WebElement savedUsernme = driver.findElement(By.id("idcard-identity"));
		String email = "jyothi@abc.com";
		if (savedUsernme.getText().contentEquals(email))
			logger.log(LogStatus.PASS, "The entered username is displayed in Username field");
		else
			logger.log(LogStatus.FAIL, "The entered username is NOT displayed in Username field");
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	public static void ForgotPassword4A() throws InterruptedException 
	{
		logger = report.startTest("ForgotPassword4A");
		driver.get("https://login.salesforce.com/");
		Thread.sleep(2000);
		WebElement ForgtPasswd = driver.findElement(By.id("forgot_password_link"));
		ForgtPasswd.click();
		String ForgotPswdPage = driver.findElement(By.xpath("//*[@id=\"header\"]")).getText();
		if (ForgotPswdPage.contentEquals("Forgot Your Password"))
			logger.log(LogStatus.PASS, "Salesforce forgot password page is displayed");
		else
			logger.log(LogStatus.FAIL, "Salesforce forgot password page is NOT displayed");
		Thread.sleep(2000);
		WebElement uName = driver.findElement(By.id("un"));
		uName.sendKeys("jyothi@abc.com");
		Thread.sleep(2000);
		WebElement continueBtn = driver.findElement(By.id("continue"));
		Clickbutton(continueBtn, "continue");
		Thread.sleep(2000);
		String EmailCheckMsg = driver.findElement(By.xpath("//*[@id=\"header\"]")).getText();
		if(EmailCheckMsg.contentEquals("Check Your Email"))
			logger.log(LogStatus.PASS, "Password reset message to Check Your Email is displayed");
		else
			logger.log(LogStatus.FAIL, "Password reset message to Check Your Email is NOT displayed");
		
		WebElement PswdResetMessage = driver.findElement(By.xpath("//*[@id=\"forgotPassForm\"]/div/p[1]"));
		if (PswdResetMessage.isDisplayed())
			logger.log(LogStatus.PASS, "Password reset message");
		else
			logger.log(LogStatus.PASS, "Password reset message is Not displayed");
		
		WebElement ReturnToLoginbutton = driver.findElement(By.xpath("//*[@id=\"forgotPassForm\"]/a"));
			
		if (ReturnToLoginbutton.isDisplayed() == true )
			logger.log(LogStatus.PASS, "Return to Login Button is Displayed");
		else
			logger.log(LogStatus.FAIL, "Return to Login Button is Not Displayed");
		driver.quit();
		}
	
	
	
		public static void TC05() throws InterruptedException  
		{
		logger = report.startTest("TC05");
		driver.get("https://login.salesforce.com/");
		Thread.sleep(1000);
		WebElement un = driver.findElement(By.id("username"));
		EnterText(un, "jyothi@abc.com", "username");
		Thread.sleep(2000);
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Pswd = driver.findElement(By.id("password"));
		EnterText(Pswd, "Samiksha14$", "password");
		WebElement LoginBtn = driver.findElement(By.id("Login"));
		Clickbutton(LoginBtn, "Login"); 
		logger.log(LogStatus.PASS, "User is Logged in successfully");
		WebElement Menudropdown = driver.findElement(By.id("userNav-arrow"));
		Menudropdown.click();
		
		String MyProfile = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[1]")).getText();
		if(MyProfile.equals("My Profile"))
			logger.log(LogStatus.PASS, "My Profile is present in user menu dropdown");
		else
			logger.log(LogStatus.FAIL, "My Profile is NOT present in user menu dropdown");
		
		String DeveloperConsole = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[3]")).getText();
		if(DeveloperConsole.equals("Developer Console"))
			logger.log(LogStatus.PASS, "Developer Console is present in user menu dropdown");
		else
			logger.log(LogStatus.FAIL, "Developer Console is NOT present in user menu dropdown");
		
		Thread.sleep(2000);
		String SwitchtoLightngExp = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[4]")).getText();
		if(SwitchtoLightngExp.equals("Switch to Lightning Experience"))
			logger.log(LogStatus.PASS, "Switch to Lightning Experience is present in user menu dropdown");
		else
			logger.log(LogStatus.FAIL, "Switch to Lightning Experience is NOT present in user menu dropdown");
		
		Thread.sleep(2000);
		String Logout = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]")).getText();
		if(Logout.equals("Logout"))
			logger.log(LogStatus.PASS, "Logout is present in user menu dropdown");
		else
			logger.log(LogStatus.FAIL, "Logout is NOT present in user menu dropdown");
		
		Thread.sleep(2000);
			
		}
		
		
		public static void TC06() throws InterruptedException  
		{
		logger = report.startTest("TC06");
		WebElement MyProfile = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[1]"));
		MyProfile.click();
		Thread.sleep(2000);
		WebElement Edit = driver.findElement(By.xpath("//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img"));
		Edit.click();
		logger.log(LogStatus.PASS, "success");
		/*  IMP -- switching to Pop up window */
		String myWindowHandle = driver.getWindowHandle();
		//System.out.println(myWindowHandle);
		driver.switchTo().window(myWindowHandle);
		/*//*[@id=\"contactInfoTitle\*/
		WebElement EditProfilePopup = driver.findElement(By.id("contactInfoX"));
		if (EditProfilePopup.isDisplayed())
			logger.log(LogStatus.PASS, "Edit profile pop up window is displayed");
		else
			logger.log(LogStatus.FAIL, "Edit profile pop up window is NOT displayed");
		Thread.sleep(2000);
			
		
//		Alert alert = driver.switchTo().alert();
//		alert.sendKeys(myWindowHandle); 
		
//should i consider this as an Alert or new window 
		
		String oldWindow = driver.getWindowHandle();
		Set<String> getAllWindows = driver.getWindowHandles();
		String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(getWindow[1]);
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(1000);	
		
		
		WebElement AboutTab = driver.findElement(By.xpath("//*[@id=\"aboutTab\"]/a"));
		System.out.println(AboutTab.getText());
		AboutTab.click();
		Thread.sleep(2000);
		
		driver.quit();
		
		}
		
		public static void TC07() throws InterruptedException  
		{
		logger = report.startTest("TC07");
		
		WebElement MySettings = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]"));
		MySettings.click();
		
			WebElement MySettingsHeading = driver.findElement(By.xpath("//*[@id=\"PersonalSetup_font\"]/span[2]"));
		if (MySettingsHeading.isDisplayed())
			logger.log(LogStatus.PASS,"My Setting Page is displayed");
		else
			logger.log(LogStatus.FAIL, "My Setting Page is NOT displayed");
		WebElement PersonalLink = driver.findElement(By.id("PersonalInfo_font"));
		PersonalLink.click();
		
		WebElement LoginHistoryLink = driver.findElement(By.id("LoginHistory_font"));
		LoginHistoryLink.click();
		
		WebElement LoginHistorypage = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[1]/div[1]/div[1]/h1"));
		if (LoginHistorypage.isDisplayed())
			logger.log(LogStatus.PASS,"Login History Page is displayed");
		else
			logger.log(LogStatus.FAIL, "Login History Page is NOT displayed");
		
		WebElement Display_LayoutLink = driver.findElement(By.id("DisplayAndLayout_font"));
		Display_LayoutLink.click();
		WebElement CustomizeMyTabs = driver.findElement(By.id("CustomizeTabs_font"));
		CustomizeMyTabs.click();
		
		
		WebElement CustomAppDropDown = driver.findElement(By.xpath("//*[@id=\"p4\"]"));
		
		Select select = new Select(CustomAppDropDown);
		select.selectByVisibleText("Salesforce Chatter");
		
		Thread.sleep(2000);
		WebElement AvailableTabs = driver.findElement(By.id("duel_select_0"));
		
		Select select1 = new Select (AvailableTabs);
		select1.selectByVisibleText("Reports");
		Thread.sleep(3000);
		//*[@id="duel_select_0_right"]/img
		WebElement Add = driver.findElement(By.xpath("//*[@id=\"duel_select_0_right\"]/img"));
		Clickbutton(Add, "Add");
		

		//List<WebElement> SelectedTabs = driver.findElements(By.id("duel_select_1"));
		int count=0;
		Select Tabs = new Select(driver.findElement(By.id("duel_select_1")));
		List<WebElement> SelectedTabs = Tabs.getOptions();
		for(WebElement c: SelectedTabs)
		{
			Tabs.selectByVisibleText(c.getText());
			System.out.println(c.getText());
			if(! c.getText().contentEquals("Reports"))
			{
				continue;
			}				
			else
			{
				logger.log(LogStatus.PASS, "Reports field is added to Selected Tabs list successfully");
				count =1;
			}
		}
		if (count == 0) 
			logger.log(LogStatus.FAIL, "Fail");
	
		WebElement EmailLink = driver.findElement(By.id("EmailSetup_font"));
		EmailLink.click();
		WebElement MyEmailSettingsLink = driver.findElement(By.id("EmailSettings_font"));
		MyEmailSettingsLink.click();
		
		WebElement MyEmailSettingsPage = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div/div[1]/div[1]/h1"));
		if(MyEmailSettingsPage.getText().contentEquals("My Email Settings"))
			logger.log(LogStatus.PASS, "My Email Settings page is displayed");
		else
			logger.log(LogStatus.FAIL, "My Email Settings page is NOT displayed");
		
		WebElement EmailName = driver.findElement(By.id("sender_name"));
		EmailName.clear();
		EnterText(EmailName, "Jyothi G", "sender_name");
		WebElement EmailAddress = driver.findElement(By.id("sender_email"));
		EmailAddress.clear();
		EnterText(EmailAddress, "Jyothi.Girishs@gmail.com", "sender_email");   
		
		//Thread.sleep(2000);
		
		/*Doubt to be asked regarding Save button*/
		
	//	WebElement Save = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
		//System.out.println(Save.isDisplayed());
	//	Save.submit();
		
		Thread.sleep(3000);
		String SavedSuccessMsg = driver.findElement(By.xpath("//*[@id=\"meSaveCompleteMessage\"]/table/tbody/tr/td[2]/div")).getText();
		if(SavedSuccessMsg.contentEquals("Your settings have been successfully saved"))
			logger.log(LogStatus.PASS, "Email settings have been successfully saved");
		else
			logger.log(LogStatus.FAIL, "Email settings have been successfully saved");
		Thread.sleep(2000);
	
		/*Calendar & Remainders*/
		
		WebElement CalendersRemindertLink = driver.findElement(By.id("CalendarAndReminders_font"));
		CalendersRemindertLink.click();
		
		WebElement ActivityReminders = driver.findElement(By.id("Reminders_font"));
		ActivityReminders.click(); 
		
		WebElement OpentestReminder = driver.findElement(By.id("testbtn"));
		OpentestReminder.click(); 
		
		Thread.sleep(4000);
		
		String oldWindow = driver.getWindowHandle();
		Set<String> getAllWindows = driver.getWindowHandles();
		String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(getWindow[1]);
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(1000);		
		WebElement SampleEvent = driver.findElement(By.xpath("//*[@id=\"summary0\"]/div"));
		Thread.sleep(2000);
		System.out.println(SampleEvent.getText());
		if (SampleEvent.getText().contentEquals("  Sample Event."))
			logger.log(LogStatus.PASS, "Sample event pop window is dispayed.");
		else
			logger.log(LogStatus.FAIL, "Sample event pop window is not dispayed.");
		
		driver.switchTo().window(oldWindow);
		driver.quit();
		}
		
		public static void TC08() throws InterruptedException
		{
			logger = report.startTest("TC08");
			WebElement DeveloperConsole = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[3]"));
			DeveloperConsole.click();
			
			String oldWindow = driver.getWindowHandle();
			Set<String> getAllWindows = driver.getWindowHandles();
			String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
			driver.switchTo().window(getWindow[1]);
			System.out.println(driver.getCurrentUrl());
			Thread.sleep(6000);	
			if(driver.getCurrentUrl().contentEquals("https://ap16.salesforce.com/_ui/common/apex/debug/ApexCSIPage"))
					
				logger.log(LogStatus.PASS, "Force.com Developer Console window is displayed");
			else
				logger.log(LogStatus.FAIL, "Force.com Developer Console window is NOT displayed");
			
			driver.close();

			Thread.sleep(2000);
			
			
			driver.quit();
		}
		
		public static void TC09() throws InterruptedException
		{
			logger = report.startTest("TC09");
			WebElement Logout = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
			Logout.click();
			Thread.sleep(4000);
			WebElement Username = driver.findElement(By.xpath("//*[@id=\"usernamegroup\"]/label"));
			if (driver.getCurrentUrl().contentEquals("https://login.salesforce.com/"))
				logger.log(LogStatus.PASS, "User is successfully logged out of sales force application");
			else
				logger.log(LogStatus.FAIL, "User is NOT logged out of sales force application");
		}
		
		public static void TC10CreateAccount() throws InterruptedException, AWTException
		{ 
			logger = report.startTest("TC10 CreateAccount");
			WebElement AccountLink = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
			AccountLink.click();
			
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);
			
			WebElement UserName = driver.findElement(By.xpath("//*[@id=\"mru0052w000001E32l\"]/a/span"));
						
			if (UserName.getText().contentEquals("Jyothi Halimani"))
				logger.log(LogStatus.PASS, "Accounts page is displayed with correct Username");
			else
				logger.log(LogStatus.FAIL, "Accounts page is Not displayed with correct Username");
			
			
			WebElement NewButton = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
			Clickbutton(NewButton, "New");
		
			WebElement AccountName = driver.findElement(By.id("acc2"));
			EnterText(AccountName, "PranavG", "AccountName"); 
			
			
			
			WebElement Type = driver.findElement(By.id("acc6"));
						
			Select select = new Select(Type);
			select.selectByVisibleText("Technology Partner");
			
			
			WebElement CustomerPriority = driver.findElement(By.id("00N2w000005FiTr"));
			
			Select select1 = new Select(CustomerPriority);
			select1.selectByIndex(1);
			
			Thread.sleep(2000);
			
			WebElement SaveButton = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
			Clickbutton(SaveButton, "Save");
			
			
			WebElement NewAccountName = driver.findElement(By.xpath("//*[@id=\"contactHeaderRow\"]/div[2]/h2"));
			if (NewAccountName.getText().contentEquals("PranavG")) 
				logger.log(LogStatus.PASS, "New account page is displayed with updated UserName");
			else
				logger.log(LogStatus.FAIL, "New account page is NOT displayed with updated UserName");
			
			
			WebElement AccountDetail_Type = driver.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[2]/table/tbody/tr[6]/td[1]"));
			if(AccountDetail_Type.getText().contentEquals("Technology Partner"))
				logger.log(LogStatus.PASS, "The New account details page is updated with Type Technology Partner");
			else
				logger.log(LogStatus.PASS, "The New account details page is Not updated");
		
			WebElement AccountDetail_Priority = driver.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[2]/table/tbody/tr[10]/td[1]"));
			if(AccountDetail_Priority.getText().contentEquals("High"))
				logger.log(LogStatus.PASS, "The New account details page is updated with High Priority");
			else
				logger.log(LogStatus.PASS, "The New account details page is Not updated");
			
		}
		
		public static void TC11Createnewview() throws InterruptedException, AWTException
		{ 
			logger = report.startTest("TC11 CreateAccount");
			WebElement AccountLink = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
			AccountLink.click();
			
			Thread.sleep(3000);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);
			
			WebElement CreateNewViewlink = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
			CreateNewViewlink.click();
			
			WebElement ViewNameTextbox = driver.findElement(By.id("fname"));
			EnterText(ViewNameTextbox, "Java234","View Name");
			
			WebElement ViewUniqueNameTextbox = driver.findElement(By.id("devname"));
			ViewUniqueNameTextbox.clear();
			Thread.sleep(4000);
			EnterText(ViewUniqueNameTextbox, "JavaSelenium234","View Unique Name");
			
			WebElement SaveButton = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]"));
			Clickbutton(SaveButton, "Save");
			
			logger.log(LogStatus.PASS, "details are added");   
			Thread.sleep(3000);
			
//     		WebElement newName = driver.findElement(By.id("00B2w000003cnI2_listSelect"));
//			System.out.println(newName.getText());
			
			
			
		}
		
		public static void TC13MergeAccounts() throws InterruptedException, AWTException
		{ 
			logger = report.startTest("TC13MergeAccounts");
			WebElement AccountLink = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
			AccountLink.click();
			
			Thread.sleep(2000);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);
			
			WebElement MergeAccountsLink = driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a"));
			MergeAccountsLink.click();
			
			Thread.sleep(1000);
			WebElement AccountTextbox = driver.findElement(By.id("srch"));
			EnterText(AccountTextbox, "sami", "Find Accounts");
			
			WebElement FindAccountsBtn = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[4]/input[2]"));
			Clickbutton(FindAccountsBtn, "Find Accounts");
			
			WebElement CheckboxSelection1 = driver.findElement(By.id("cid0"));
			CheckboxSelection1.click();
			WebElement CheckboxSelection2 = driver.findElement(By.id("cid1"));
			CheckboxSelection1.click();
			
			WebElement NextBtn = driver.findElement(By.className("btn"));
			Clickbutton(NextBtn, "Next");
			
			WebElement MergeMyAccounts = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div/div[1]/div[1]/h1"));
			if (MergeMyAccounts.getText().contentEquals("Merge My Accounts"))
					logger.log(LogStatus.PASS, "Merge My Accounts page is displayed");
			else
					logger.log(LogStatus.FAIL, "Merge My Accounts page is Not displayed");
				
			WebElement Acc1Details = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[4]/table/tbody/tr[1]/th[1]"));
			System.out.println(Acc1Details.getText());
						
			WebElement Acc2Details = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[4]/table/tbody/tr[1]/th[2]"));
			System.out.println(Acc2Details.getText());	
			Thread.sleep(2000);
			WebElement MergeBtn = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[5]/div/input[2]"));
			Clickbutton(MergeBtn, "Merge");    //   MergeBtn.click(); 
			
			Alert alert = driver.switchTo().alert();
			String alertMsg = driver.switchTo().alert().getText();
			System.out.println(alertMsg);
			alert.accept();
			
			WebElement AccountHomePage = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[1]/div[1]/div[1]/h2"));
			if (AccountHomePage.getText().contentEquals("Home"))
				logger.log(LogStatus.PASS, "Accounts Home page is displayed");
		else
				logger.log(LogStatus.FAIL, "Accounts Home page is Not displayed");
			
		}
		
		public static void TC14() throws InterruptedException, AWTException
		{
			logintoSFDC();
			logger = report.startTest("TC14");
			WebElement AccountLink = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
			AccountLink.click();
			Thread.sleep(2000); 
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(1000);
			
			WebElement AccountLstActivityLink = driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div/div[1]/ul/li[2]/a"));
			AccountLstActivityLink.click();
			
			String UnSavedReportPage = driver.findElement(By.xpath("//*[@id=\"thePage:sectionHeader\"]/div/div/div[1]/h2")).getText();
			if (UnSavedReportPage.contentEquals("Unsaved Report"))
				logger.log(LogStatus.PASS, "Unsaved Report page is displayed");
			else
				logger.log(LogStatus.FAIL, "Unsaved Report page is Not displayed");
			
			WebElement DateField = driver.findElement(By.xpath("//*[@id=\"ext-gen20\"]"));
			DateField.click();
			
			WebElement CreateDate = driver.findElement(By.xpath("//*[@id=\"ext-gen264\"]/div[3]"));
			CreateDate.click();
			Thread.sleep(3000);
			
			WebElement Calender1 = driver.findElement(By.id("ext-comp-1042"));
			Calender1.clear();
			Calender1.sendKeys("2/18/2020");
			
			Thread.sleep(5000);
						
			WebElement Calender2 = driver.findElement(By.id("ext-comp-1045"));
			Calender2.clear();
			Calender2.sendKeys("2/18/2020");
			Thread.sleep(8000);
			
			
			WebElement SaveBtnReport = driver.findElement(By.id("saveReportBtn"));
			SaveBtnReport.click();
			Thread.sleep(5000);
			
			String oldWindow = driver.getWindowHandle();
			String getsecondWindows = driver.getWindowHandle();
			
			//Set<String> getAllWindows = driver.getWindowHandles();
			//String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
			driver.switchTo().window(getsecondWindows);
			
			
			WebElement ReportName = driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']"));
			EnterText(ReportName, "2TestingJava", "Report Name");
								
			WebElement ReportUniqueName = driver.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']"));
			ReportUniqueName.clear();
			EnterText(ReportUniqueName, "2TestingJava", "Report Name");
			Thread.sleep(2000);
			
			WebElement ReportSaveBtn = driver.findElement(By.id("dlgSaveReport"));
			ReportSaveBtn.click();
			Thread.sleep(8000);	
			WebElement ReportPage = driver.findElement(By.xpath("//h2[@class='pageDescription']"));
			System.out.println(ReportPage.getText());
			if (ReportPage.getText().contains("2TestingJava"))
				logger.log(LogStatus.PASS, "Report page with details and report name is displayed");
			else
				logger.log(LogStatus.FAIL, "Report page is not updated");
			
		}
		
		public static void TC15() throws InterruptedException, AWTException
		{
			logintoSFDC();
			logger = report.startTest("TC15");
			
			WebElement OpportunitiesLink = driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]"));
			OpportunitiesLink.click();
			Thread.sleep(2000); 
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(1000);
			
			String ListOfDropdownItems = "All Opportunities,Closing Next Month,Closing This Month,My Opportunities,New Last Week,New This Week,Opportunity Pipeline,Private,Recently Viewed Opportunities,Won";
			String List[] =  ListOfDropdownItems.split(",");
			
			WebElement x = driver.findElement(By.name("fcf"));
			Select DropdownOpp = new Select(x);
			List<WebElement> Options = DropdownOpp.getOptions();
			for(WebElement c: Options)
			{
				System.out.println(c.getText());
				
			}
			for (int i=0;i<Options.size();i++)
			{
				if(List[i].contains(Options.get(i).getText()))
						logger.log(LogStatus.PASS, Options.get(i).getText() + " option is Present");
				else
					logger.log(LogStatus.FAIL, "fail");
			}
			
		}
		
		public static void TC16() throws InterruptedException, AWTException
		{
			logintoSFDC();
			logger = report.startTest("TC16");
			
			WebElement OpportunitiesLink = driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]"));
			OpportunitiesLink.click();
			Thread.sleep(2000); 
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);

			WebElement NewButton = driver.findElement(By.xpath("//input[@name='new']"));
			NewButton.click();
			
			WebElement OpportunityName = driver.findElement(By.id("opp3"));
			EnterText(OpportunityName, "Sami1", "Opportunity Name");
			
			WebElement AccountName = driver.findElement(By.id("opp4"));
			EnterText(AccountName, "Sami1", "Account Name");
			
			WebElement CloseDate = driver.findElement(By.id("opp9"));
			CloseDate.sendKeys("2/18/2020");
			
			WebElement Stage = driver.findElement(By.xpath("//select[@id='opp11']"));
			Select select = new Select(Stage);
			select.selectByVisibleText("Needs Analysis");
			
			WebElement SaveBtn = driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]"));
			Clickbutton(SaveBtn, "Save");
			
			WebElement NewOppHeading = driver.findElement(By.xpath("//h2[@class='pageDescription']"));
			
			System.out.println(NewOppHeading.getText());
			if(NewOppHeading.getText().contentEquals("Sami1"))
				logger.log(LogStatus.PASS, "New Opportunity page is displayed with Opportunity details.");
			else
				logger.log(LogStatus.FAIL, "New Opportunity page is NOT updated.");
		}
		
		public static void TC17() throws InterruptedException, AWTException
		{
			logintoSFDC();
			logger = report.startTest("TC16");
			
			WebElement OpportunitiesLink = driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]"));
			OpportunitiesLink.click();
			Thread.sleep(2000); 
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);

			WebElement OppPipline = driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));
			OppPipline.click();
			
			WebElement OppPiplineReportPage = driver.findElement(By.xpath("//*[@id=\"report\"]/div[1]/a"));
			System.out.println(OppPiplineReportPage.getText());
			if(OppPiplineReportPage.getText().contentEquals("Jyothi Halimani"))
				logger.log(LogStatus.PASS, "Report Opportunity page is displayed.");
			else
				logger.log(LogStatus.FAIL, "Report Opportunity page is NOT updated.");
		  }
		
		
		public static void TC20leadsTab() throws InterruptedException, AWTException
		{
			logintoSFDC();
			logger = report.startTest("TC20leadsTab");
			
			WebElement LeadsTab = driver.findElement(By.id("Lead_Tab"));
			LeadsTab.click();
			Thread.sleep(2000); 
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);
		}
		
		
		public static void TC21leadsSelectView() throws InterruptedException, AWTException
		{
			logintoSFDC();
			logger = report.startTest("TC21leadsSelectView");
			WebElement LeadsTab = driver.findElement(By.id("Lead_Tab"));
			LeadsTab.click();
			Thread.sleep(2000); 
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);
			
			WebElement ViewDroDown = driver.findElement(By.id("fcf"));
			Select select = new Select(ViewDroDown);
			List<WebElement> DropDownViewList = select.getOptions();
						
			String ExpetcedView = "All Open Leads,My Unread Leads,Recently Viewed Leads,Today's Leads,View - Custom 1,View - Custom 2";
			String ArrStrView[] = ExpetcedView.split(",");
			
			for (WebElement c: DropDownViewList)
			{
				System.out.println(c.getText());
			}
		
			for(int i=0;i<DropDownViewList.size();i++)
			{
				if(ArrStrView[i].contentEquals(DropDownViewList.get(i).getText()))
					logger.log(LogStatus.PASS, ArrStrView[i] + " option is present in dropdown list");
				else
					logger.log(LogStatus.FAIL, "View dropdown doesnt have listed dropdown items");
			}
		}
		
		public static void TC22defaultView() throws InterruptedException, AWTException
		{
			logintoSFDC();
			logger = report.startTest("TC22defaultView");
			WebElement LeadsTab = driver.findElement(By.id("Lead_Tab"));
			LeadsTab.click();
			Thread.sleep(2000); 
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);
			
			WebElement LeadsView = driver.findElement(By.xpath("//*[@id=\"fcf\"]"));
			Select select = new Select(LeadsView);
			select.selectByIndex(1);
						
			WebElement SelectedLeads =   driver.findElement(By.id("00B2w000004eRQ8_listSelect"));
			Select select1 = new Select(SelectedLeads);
			if ((select1.getFirstSelectedOption().getText()).contains("My Unread Leads"))
					logger.log(LogStatus.PASS, "Lead page is updated successfully");
			else
				logger.log(LogStatus.FAIL, "Lead page is NOT updated");
			Thread.sleep(3000);
			WebElement Menudropdown = driver.findElement(By.id("userNav-arrow"));
			Menudropdown.click();
			Thread.sleep(3000);
			String Logout = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]")).getText();
			if(Logout.equals("Logout"))
				logger.log(LogStatus.PASS, "Logout is present in user menu dropdown");
			else
				logger.log(LogStatus.FAIL, "Logout is NOT present in user menu dropdown");
			
			Thread.sleep(2000);		
			logintoSFDC();
			WebElement LeadsTab1 = driver.findElement(By.id("Lead_Tab"));
			LeadsTab1.click();
			
			WebElement GoBtn = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input"));
			GoBtn.click();
						
			Thread.sleep(4000);
						
		}	
			
		public static void TC23() throws InterruptedException, AWTException
		{
			logintoSFDC();
			logger = report.startTest("TC23");
			WebElement LeadsTab = driver.findElement(By.id("Lead_Tab"));
			LeadsTab.click();
			Thread.sleep(2000); 		
			
			WebElement LeadsView = driver.findElement(By.xpath("//*[@id=\"fcf\"]"));
			Select select = new Select(LeadsView);
			select.selectByIndex(3);
			Thread.sleep(2000); 
			
			WebElement TodaysLeadsPage = driver.findElement(By.id("00B2w000004eRQM_listSelect"));
			Select select1 = new Select(TodaysLeadsPage);
			if ((select1.getFirstSelectedOption().getText()).contains("Today's Leads"))
					logger.log(LogStatus.PASS, "Todays's Lead page is displayed.");
			else
				logger.log(LogStatus.FAIL, "Todays's Lead page is NOT updated");
		}	
		
		public static void TC24() throws InterruptedException, AWTException
		{
			logintoSFDC();
			logger = report.startTest("TC24");
			WebElement LeadsTab = driver.findElement(By.id("Lead_Tab"));
			LeadsTab.click();
			Thread.sleep(2000); 
			
			WebElement NewBtn = driver.findElement(By.xpath("//input[@name='new']"));
			NewBtn.click();
			
			WebElement NewLeadsPg = driver.findElement(By.xpath("//h2[@class='pageDescription']"));
			NewLeadsPg.click();
			
			
			WebElement LastName = driver.findElement(By.id("name_lastlea2"));
			EnterText(LastName, "ABCD2", "Last NAme");
			
			WebElement Company = driver.findElement(By.id("lea3"));
			EnterText(Company, "ABCD2", "Company");
			
			
			WebElement SaveBtn = driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@name='save']"));
			Clickbutton(SaveBtn,"Save");
			
			
			WebElement TopNameLeadViewPg = driver.findElement(By.xpath("//h2[@class='topName']"));
			if(TopNameLeadViewPg.getText().contentEquals("ABCD2"))
				logger.log(LogStatus.PASS, "Newly created Lead page is updated successfully");
			else
				logger.log(LogStatus.FAIL, "Lead page is Not updated successfully");
					
		}
		
		
		public static void TC25() throws InterruptedException, AWTException
		{
			logintoSFDC();
			logger = report.startTest("TC25");
			WebElement ContactTab = driver.findElement(By.id("Contact_Tab"));
			ContactTab.click();
			Thread.sleep(2000); 
			WebElement NewBtn = driver.findElement(By.xpath("//input[@name='new']"));
			Clickbutton(NewBtn,"New");
			Thread.sleep(2000);
			WebElement LastName = driver.findElement(By.id("name_lastcon2"));
			EnterText(LastName, "ABCD3", "LastName");
			WebElement AccountName = driver.findElement(By.id("con4"));
			EnterText(AccountName, "JBH", "AccountName");
			
			WebElement SaveBtn = driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@name='save']"));
			Clickbutton(SaveBtn,"Save");
			
			
			WebElement TopNameContactPg = driver.findElement(By.xpath("//h2[@class='topName']"));
			if(TopNameContactPg.getText().contentEquals("ABCD3"))
				logger.log(LogStatus.PASS, "New contact is created successfully");
			else
				logger.log(LogStatus.FAIL, "New contact is not created");
		}
		
		public static void TC26() throws InterruptedException, AWTException
		{
			logintoSFDC();
			logger = report.startTest("TC26");
			WebElement ContactTab = driver.findElement(By.id("Contact_Tab"));
			ContactTab.click();
			Thread.sleep(2000); 
			
			WebElement CreateNewView = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
			CreateNewView.click();
						
			WebElement ViewNameTextbox = driver.findElement(By.id("fname"));
			EnterText(ViewNameTextbox, "abc9","View Name");
			
			WebElement ViewUniqueNameTextbox = driver.findElement(By.id("devname"));
			ViewUniqueNameTextbox.clear();
			Thread.sleep(4000);
			EnterText(ViewUniqueNameTextbox, "abc9","View Unique Name");
			
			WebElement SaveButton = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]"));
			Clickbutton(SaveButton, "Save");
			Thread.sleep(4000);
			WebElement ContactPageViewName = driver.findElement(By.xpath("//select[@id='00B2w000003d1Rw_listSelect']"));
				//WebElement ContactPageViewName = driver.findElement(By.id("00B2w000003d1Rw_listSelect"));
			Select select1 = new Select(ContactPageViewName);
			System.out.println(select1.getFirstSelectedOption().getText());
//			
//			if ((select1.getFirstSelectedOption().getText()).contains("abc8"))
//					logger.log(LogStatus.PASS, "Created View name is displayed in drop down in that page by defalut");
//			else
//				logger.log(LogStatus.FAIL, "Created View name is NOT updated");
			
			Thread.sleep(3000);
			
		} 
			
		public static void TC27() throws InterruptedException, AWTException
		{
			logintoSFDC();
			logger = report.startTest("TC27");
			WebElement ContactTab = driver.findElement(By.id("Contact_Tab"));
			ContactTab.click();
			Thread.sleep(2000);	
						
			WebElement RecentlyCreatedDropdown = driver.findElement(By.xpath("//option[contains(text(),'Recently Created')]"));
			RecentlyCreatedDropdown.click();
						
			WebElement RecentContact1 = driver.findElement(By.xpath("//a[contains(text(),'G, Pranav')]"));
			
			System.out.println(RecentContact1.getText());
			
			if ((RecentContact1.getText()).contains("G, Pranav"))
				logger.log(LogStatus.PASS, "Recent created contact is displayed");
			else
				logger.log(LogStatus.FAIL, "Recent created contact is not displayedd");
		}
		
		public static void TC28() throws InterruptedException, AWTException
		{
			logintoSFDC();
			logger = report.startTest("TC28");
			WebElement ContactTab = driver.findElement(By.id("Contact_Tab"));
			ContactTab.click();
			Thread.sleep(2000);	
			
			WebElement RecentlyCreatedDropdown = driver.findElement(By.xpath("//option[contains(text(),'Recently Created')]"));
			RecentlyCreatedDropdown.click();
			
			
			WebElement ContactViewDropdown = driver.findElement(By.id("fcf"));
			Select select = new Select(ContactViewDropdown);
			select.selectByVisibleText("My Contacts");
			
			WebElement MyContactsPage = driver.findElement(By.id("00B2w000004eRR3_listSelect"));
			Select select1 = new Select(MyContactsPage);
			if ((select1.getFirstSelectedOption().getText()).contains("My Contacts"))
					logger.log(LogStatus.PASS, "Contacts page is displayed.");
			else
				logger.log(LogStatus.FAIL, "Contacts page is NOT updated");
			
			
		}	
		public static void TC29() throws InterruptedException, AWTException
		{
			logintoSFDC();
			logger = report.startTest("TC29");
			WebElement ContactTab = driver.findElement(By.id("Contact_Tab"));
			ContactTab.click();
			Thread.sleep(2000);	
			
			WebElement RecentlyCreatedDropdown = driver.findElement(By.xpath("//option[contains(text(),'Recently Created')]"));
			RecentlyCreatedDropdown.click();
			Thread.sleep(3000);	
			//tr[contains(@class,'dataRow even first')]//th[contains(@class,'')]
			WebElement ContactName = driver.findElement(By.xpath("//a[contains(text(),'G, Pranav')]"));
			ContactName.click();
		}
		
		public static void TC30() throws InterruptedException, AWTException
		{
			logintoSFDC();
			logger = report.startTest("TC30");
			WebElement ContactTab = driver.findElement(By.id("Contact_Tab"));
			ContactTab.click();
			Thread.sleep(2000);
			
			WebElement CreateNewViewLink = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
			CreateNewViewLink.click();
			
			WebElement ViewUniqueName = driver.findElement(By.id("devname"));
			EnterText(ViewUniqueName, "abc9","View Unique Name");
			
			WebElement SaveBtn = driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']"));
			SaveBtn.click();
			
			WebElement ErrorMsg = driver.findElement(By.xpath("//div[contains(text(),'You must enter a value')]"));
			
			System.out.println(ErrorMsg.getText());
			if(ErrorMsg.getText().contentEquals("Error: You must enter a value"))
				logger.log(LogStatus.PASS, "Error message to enter a value is displayed");
			else
				logger.log(LogStatus.FAIL, "Error msg is not displayed");
		}
		
		
		public static void TC31() throws InterruptedException, AWTException
		{
			logintoSFDC();
			logger = report.startTest("TC31");
			WebElement ContactTab = driver.findElement(By.id("Contact_Tab"));
			ContactTab.click();
			Thread.sleep(2000);
			
			WebElement CreateNewViewLink = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
			CreateNewViewLink.click();
			
			WebElement ViewName = driver.findElement(By.id("fname"));
			EnterText(ViewName, "abc9","View Name");
			
			WebElement ViewUniqueName = driver.findElement(By.id("devname"));
			EnterText(ViewUniqueName, "abc19","View Unique Name");
			
			WebElement CancelBtn = driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='cancel']"));
			CancelBtn.click();
			
			WebElement ContactsHome = driver.findElement(By.xpath("//h2[@class='pageDescription']"));
			
			System.out.println(ContactsHome.getText());
			if(ContactsHome.getText().contentEquals("Home"))
				logger.log(LogStatus.PASS, "Contacts Home page is displayed and the new View is not created.");
			else
				logger.log(LogStatus.FAIL, "Error in Cancel Button functionality");
			
		}
		
		public static void TC34() throws InterruptedException, AWTException
		{
			logintoSFDC();
			logger = report.startTest("TC34");
			WebElement ContactTab = driver.findElement(By.id("Contact_Tab"));
			ContactTab.click();
			Thread.sleep(2000);
			
			WebElement HomePage = driver.findElement(By.xpath("//*[@id=\"home_Tab\"]/a"));
			HomePage.click();
			
			
			WebElement FirstNameLastNameLink = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[1]/h1/a"));
			FirstNameLastNameLink.click();
			
			WebElement EditProfile = driver.findElement(By.xpath("//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img"));
			EditProfile.click();
			
			driver.switchTo().frame("contactInfoContentId");
			WebElement AboutTab = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
			AboutTab.click();
			
			
			
			
			
		}	
		
		
}