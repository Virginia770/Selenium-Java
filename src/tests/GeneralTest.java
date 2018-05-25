package tests;

import java.util.Iterator;
import java.util.List;

import mapping.Client;
import utils.Constants;
import utils.Enums.Browsers;
import core.Config;

public class GeneralTest {
	public Config configuration = Config.getInstance();
	public List<Client> listClients;
	public CommonClass commonClass= new CommonClass();
	private void initializeDriver(){
		configuration.initializeDriver(Browsers.CHROME);
	}
	                 
	public void navigateToLoginPage() {
		initializeDriver();
		commonClass.navigateToLoginPage();
	}
	
	public void loginInToTheApp(){
		initializeDriver();
		commonClass.logInSuccesfull();
	}
	public void navigateToFeedback() {
		configuration.getDriver().get(Constants.GlobalUrl+Constants.Env +Constants.FeedbackPage );
	}
	
	public void navigateToTopicPage() {
		configuration.getDriver().get(Constants.GlobalUrl+Constants.Env +Constants.TopicPage + "/10A67BD52A5911E59CF3843A4B55DE24/navbar" );
	}
	
	public void navigateToTeamActivity() {
		configuration.getDriver().get(Constants.GlobalUrl+Constants.Env +Constants.TeamActivity );
	}
	
	public void navigateToUserActivity() {
		configuration.getDriver().get(Constants.GlobalUrl+Constants.Env +Constants.UserActivity );
	}
	
	public void navigateToTeamInsightSummary() {
		configuration.getDriver().get(Constants.GlobalUrl+Constants.Env +Constants.TeamInsightActivity );
	}
	
	public void navigateToProfile() {
		configuration.getDriver().get(Constants.GlobalUrl+Constants.Env +Constants.Profile );
	}
	
	
	
	public void quitDriver(){
		configuration.quitDriver();
	}
	
	
	public Client clientNeeded(String attrib) {
		Iterator<Client> itr = listClients.iterator();
		Client returnValue = null;
		while (itr.hasNext()) {
			Client clients = itr.next();
			if (clients.getStatus().equalsIgnoreCase(attrib)) {
				returnValue = clients;
				break;
			}
		}
		return returnValue;
	}
	
}
