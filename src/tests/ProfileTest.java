package tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import mapping.Client;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pages.feedback.FeedbackPage;
import pages.home.HomePage;
import pages.login.LoginPage;
import pages.overview.OverviewPage;
import pages.profile.ProfilePage;
import utils.AppUrls;
import utils.Constants;
import utils.ExcelReader;
import utils.Log;

public class ProfileTest extends GeneralTest {
	
	private List<Client> listClients;
	private ExcelReader reader = new ExcelReader();
	private LoginPage loginPage;
	private HomePage homePage;
	private OverviewPage overviewPage;
	private FeedbackPage feedbackPage;
	private ProfilePage profilePage;
	
	
	@Before
	public void setData() {
		
		
		Log.startTestCase(LoginTest.class.getSimpleName()+"started");
		loginInToTheApp();		
		
	}

	@Test
	public void editDisplayName() {
		Log.startTestCase("EditDisplayName");
		
		profilePage= new ProfilePage();
		profilePage.validateNavigation();
		//Assert.assertTrue(profilePage.validateNavigation());
		
		profilePage.enableEditLink();
		profilePage.EditDisplayName();
		
		//System.out.println("funciona!!");
		profilePage.verifyAttribute();
		
		//System.out.println("funciona2!!");
		
		/*profilePage.refresh();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		profilePage.enableEditLink();
		profilePage.SetInitalDisplayName();
		
		
	
	}
	
	@After
	public void after() {
		
		quitDriver();
	}
	/*@AfterClass
	public static void afterClass(){
		
		Log.endTestCase(FeedbackTest.class.getSimpleName()+"finished");
		//reader..closeExcelFile();
	
	}*/
}
