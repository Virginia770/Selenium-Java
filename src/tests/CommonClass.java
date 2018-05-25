package tests;

import mapping.Client;
import pages.home.HomePage;
import pages.login.LoginPage;
import utils.Constants;
import utils.ExcelReader;
import core.Config;

public class CommonClass {
	private LoginPage loginPage;
	private HomePage homePage;
	private ExcelReader reader = new ExcelReader();

	public void logInSuccesfull() {
		navigateToLoginPage();
		Client client = reader.getSpecificClient("succesfull");
		//Assert.assertNotNull(client);
		LoginPage loginPage = new LoginPage();// / QUIZAS COMO PARAMETRO????	
		loginPage.applicationLogin(client.getEmail(), client.getPassword());
	}

	public void navigateToLoginPage() {
		Config.getInstance().getDriver().get(Constants.GlobalUrl + Constants.Env);
		homePage = new HomePage();
		homePage.validateNavigation();
		homePage.goToLoginPage();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/*public void navigateToLoginPage(){
		Config.getInstance().getDriver().get(Constants.GlobalUrl + "#login");
		homePage = new HomePage();
		homePage.validateNavigation();
		homePage.goToLoginPage();

		loginPage = new LoginPage();
		Assert.assertTrue(loginPage.validateNavigation());
	}*/
}
