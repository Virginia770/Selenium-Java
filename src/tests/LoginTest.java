package tests;

import mapping.Client;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import pages.home.HomePage;
import pages.login.LoginPage;
import pages.overview.OverviewPage;
import utils.ExcelReader;
import utils.Log;
import utils.ScreenshotTestRule;

public class LoginTest extends GeneralTest {
	private LoginPage loginPage;
	private HomePage homePage;
	private OverviewPage overviewPage;
	private ExcelReader excelData = new ExcelReader();
	/**
	 * This Rule enable the automated screenshoot every time a Test fail
	 */
	@Rule
	public ScreenshotTestRule screenshotTestRule = new ScreenshotTestRule();

	@Before
	public void setData() {
		Log.startTestCase(LoginTest.class.getSimpleName());
		

		navigateToLoginPage();
	
		loginPage = new LoginPage();
		Assert.assertTrue(loginPage.validateNavigation());
	}

	@Test
	public void badEmailTest() {

		Client client1 = excelData.getSpecificClient("badEmail");
		Log.startTestCase(client1.getStatus());
		loginPage.applicationLogin(client1.getEmail(), client1.getPassword());
		loginPage.verifyExistErrorMessage();
		Assert.assertTrue(loginPage.verifyCorrectTextErrorMessage(client1
				.getExpectedResult()));
		loginPage.clearFields();
		

	}

	@Test
	public void rightEmailAndBadPassword() {

		Client client = excelData.getSpecificClient("rightEmailAndBadPassword");
		Log.startTestCase(client.getStatus());
		loginPage.applicationLogin(client.getEmail(), client.getPassword());
		loginPage.verifyExistErrorMessage();
		Assert.assertTrue(loginPage.verifyCorrectTextErrorMessage(client
				.getExpectedResult()));
		loginPage.clearFields();

	}

	@Test
	public void emptyEmail() {

		Client client = excelData.getSpecificClient("emptyEmail");
		Log.startTestCase(client.getStatus());
		loginPage.applicationLogin(client.getEmail(), client.getPassword());

		loginPage.verifyExistErrorMessage();
		Assert.assertTrue(loginPage.verifyCorrectTextErrorMessage(client
				.getExpectedResult()));
		loginPage.clearFields();

	}

	@Test
	public void emptyFields() {

		Client client = excelData.getSpecificClient("emptyFields");
		Log.startTestCase(client.getStatus());
		loginPage.applicationLogin(client.getEmail(), client.getPassword());
		loginPage.verifyExistErrorMessage();
		Assert.assertTrue(loginPage.verifyCorrectTextErrorMessage(client
				.getExpectedResult()));
		loginPage.clearFields();

	}

	@Test
	public void rightEmailEmptyPassword() {

		Client client = excelData.getSpecificClient("rightEmailEmptyPassword");
		Log.startTestCase(client.getStatus());
		loginPage.applicationLogin(client.getEmail(), client.getPassword());
		loginPage.verifyExistErrorMessage();
		Assert.assertTrue(loginPage.validateNavigation());
		loginPage.clearFields();
		
		

	}

	@Test
	public void successfull() {
		Client client = excelData.getSpecificClient("successfull");
		Log.startTestCase(client.getStatus());
		loginPage.applicationLogin(client.getEmail(), client.getPassword());
	    overviewPage= new OverviewPage();
		Assert.assertTrue(overviewPage.validateNavigation());
		screenshotTestRule.captureScreenshot("successfull");
		
	}

	@After
	public void after() {
		quitDriver();
	}

	@AfterClass
	public static void afterClass() {
		Log.endTestCase(LoginTest.class.getSimpleName());
	}

}
