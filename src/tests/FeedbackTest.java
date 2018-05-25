package tests;

import java.io.IOException;
import java.util.List;

import mapping.Client;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

import core.Config;
import pages.feedback.FeedbackPage;
import pages.home.HomePage;
import pages.login.LoginPage;
import pages.overview.OverviewPage;
import utils.Constants;
import utils.ExcelReader;
import utils.Log;
import utils.ScreenshotTestRule;


public class FeedbackTest extends GeneralTest{
	
	private ExcelReader reader = new ExcelReader();
	private LoginPage loginPage;
	private HomePage homePage;
	private WebDriverWait wait;
	
	/**
	 * This Rule enable the automated screenshoot every time a Test fail
	 */
	@Rule
	public ScreenshotTestRule screenshotTestRule = new ScreenshotTestRule();	
	
	@Before
	public void setData() {
		
		Log.startTestCase(FeedbackPage.class.getSimpleName()+"started");

		loginInToTheApp();
	}
	
	
	@Test
	public void feedbacktest() {
		try {
			Log.startTestCase("feedbacktest");
			Thread.sleep(1000);
			navigateToFeedback();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void fieldRequired(){
		try {
			for (int i = 1; i < 8; i++) {
				/*
				FeedbackPage.fillFeedbackWithout(i);
				FeedbackPage.clickOnbtnPost();
				Thread.sleep(1000);
				FeedbackPage.refresh();*/
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
	@After
	public void after()
	{
		quitDriver();
	}
	
	@AfterClass
	public static void afterClass(){
		Log.endTestCase(FeedbackTest.class.getSimpleName()+"finished");	
	}

}
