package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import mapping.Client;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.Config;
import pages.home.HomePage;
import pages.login.LoginPage;
import utils.Constants;
import utils.ExcelReader;
import utils.Log;
import utils.ScreenshotTestRule;

public class NavigationTest extends GeneralTest{
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
		
		Log.startTestCase(NavigationTest.class.getSimpleName());
		loginInToTheApp();
		
	}
	/**
	 * Navigationtest : This TEST navigate for each page randomly in Kernel
	 * expecting in some cases The NavBar or in other cases the "X" Button
	 */
	@Test
	public void Navigationtest() {
		Random r = new Random();
		int min = 0;
		int max = 6;
		int rvalue = r.nextInt(max-min) + min;
		ArrayList<String> url = new ArrayList<String>();
		url.add(0, Constants.GlobalUrl+Constants.Env);
		url.add(1, Constants.GlobalUrl+Constants.Env + Constants.CreateSurvey);
		url.add(2, Constants.GlobalUrl+Constants.Env + Constants.CreateTopic);
		url.add(3, Constants.GlobalUrl+Constants.Env + Constants.FeedbackPage);
		url.add(4, Constants.GlobalUrl+Constants.Env + Constants.TeamActivity);
		url.add(5, Constants.GlobalUrl+Constants.Env + Constants.UserActivity);
		url.add(6, Constants.GlobalUrl+Constants.Env + Constants.TeamInsightActivity);
		url.add(7, Constants.GlobalUrl+Constants.Env + Constants.Profile);
		url.add(8, Constants.GlobalUrl+Constants.Env+ Constants.LearnMore);
		for (int i = 0; i < 20; i++) {
			try { 
					rvalue = r.nextInt(max-min) + min;
					configuration.getDriver().get(url.get(rvalue));
					Thread.sleep(5000);
					if (rvalue==0 || rvalue==4 || rvalue==5 || rvalue==6 || rvalue==7 ) {
						 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("kernelnavbar")));
						Assert.assertTrue(Config.getInstance().getDriver().findElement(By.id("kernelnavbar")).isDisplayed());
					}else
					{
						wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='k-button cancelEdit']")));
						Assert.assertTrue(Config.getInstance().getDriver().findElement(By.xpath("//*[@class='k-button cancelEdit']")).isDisplayed());
					}
			}catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						continue;
			}catch (NoSuchElementException e) {
				e.printStackTrace();
				System.out.println(rvalue);
				continue;
			}
		}
	}
	/**
	 * FailTest : This TEST always will fail, only for test the screenshot rule
	 */
	@Test
	public void FailTest()
	{
		navigateToProfile();
		Assert.assertTrue(Config.getInstance().getDriver().findElement(By.xpath("//*[@class='k-button cancelEdit']")).isDisplayed());
	}
	
	@After
	public void after()
	{
		quitDriver();
	}
	@AfterClass
	public static void afterClass(){
		Log.endTestCase(NavigationTest.class.getSimpleName()+"finished");
	}

	
		

}
