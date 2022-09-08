package MentorAutomationTestingProject.GmailAutomationTesting;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class loginTest extends base {
	@AfterSuite
	public void close() {
		quitBrowser();
	}

	@Test(priority = 0)
	public void homePage() {
		invokeBrowser("chrome");
		openWebsite("websiteUrl");
		assertFunction("homePageTitle");
		clickElement("singinbtn_xpath");

	}

	@Test(priority = 1)
	public void accountPage() {
		assertFunction("accountPageTitle");
		enterText("username_xpath", "username");
		clickElement("userNextBtn_xpath");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		enterText("password_xpath", "wrongPassword");
		clickElement("passNextBtn_xpath");
		printText("wrongPass_xpath");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		enterText("password_xpath", "password");
		clickElement("passNextBtn_xpath");
	}

	@Test(priority = 2)
	public void inboxPage() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickElement("inbox_xpath");
		textCompare("inbox_xpath", "inboxText");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickElement("primary_xpath");
		textCompare("primary_xpath", "primaryText");
	}

	@Test(priority = 3)
	public void readEmail() {

		clickElement("Remail_xpath");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printText("Rusername_xpath");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printText("RemailID_xpath");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printText("Rsubject_xpath");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printText("Rmessage_xpath");

	}

	@Test(priority = 4)
	public void composeEmail() {
		clickElement("cumposeBtn_xpath");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickElement("emailIdTab_xpath");
		enterText("emailIdTab_xpath", "emailIdText");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickElement("subjectTab_xpath");
		enterText("subjectTab_xpath", "subjectText");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		clickElement("NmessageTab_xpath");
		enterText("NmessageTab_xpath", "messageText");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickElement("sendBtn_xpath");
	}
}
