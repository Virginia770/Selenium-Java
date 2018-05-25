package pages.home;

import java.util.ArrayList;
import java.util.List;

import core.TestElement;
import pages.TestPage;
import utils.Enums.LocatorType;

public class HomePage extends TestPage  {

	
	TestElement signInLink = new TestElement();
	
	public HomePage(){
		
		//signInLink.findMe(LocatorType.CLASS, "ui-button-text");		
		signInLink.findMe(LocatorType.XPATH,"//*[text()='Iniciar Sesión']");
		
		List <TestElement> list= new ArrayList<TestElement>();
		list.add(signInLink);
	    super.setElementsToConfirm(list);
	    System.out.println("Home Page OK");
	}
	
	public void goToLoginPage() {
		 signInLink.click();
	}
	
	
}
