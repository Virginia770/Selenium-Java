/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.login;

import java.util.ArrayList;
import java.util.List;

import pages.TestPage;
import utils.Enums.LocatorType;
import core.TestElement;

public class LoginPage extends TestPage {

	TestElement txtUser = new TestElement();
	TestElement txtPass = new TestElement();
	TestElement btnLogin = new TestElement();
	TestElement errorMessage= new TestElement();

	public LoginPage() {
		txtUser.findMe(LocatorType.ID, "username");
		txtPass.findMe(LocatorType.ID, "password");
		btnLogin.findMe(LocatorType.ID, "kc-login");
		
		List <TestElement> list= new ArrayList<TestElement>();
		list.add(txtUser);
		list.add(txtPass);
		list.add(btnLogin);
		super.setElementsToConfirm(list);
	}
	
	public void applicationLogin(String username, String passwd) {
		txtUser.write(username);
		txtPass.write(passwd);		
		btnLogin.click();
	}
	
	public void verifyExistErrorMessage(){
		
		try {
			errorMessage.findMe(LocatorType.XPATH,"//*[text()='Invalid username or password.']");
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			errorMessage.findMe(LocatorType.XPATH,"//*[text()='Invalid username or password.']");
		}
		//errorMessage.findMe(LocatorType.XPATH,"//*[text()='Invalid username or password.']");
		//errorMessage.findMe(LocatorType.XPATH, "//*[@class='error-text']");
	}
	
	public boolean  verifyCorrectTextErrorMessage(String text){
		try {
			return errorMessage.validateText(text);
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			return errorMessage.validateText(text);
		}
		//return errorMessage.validateText(text);
	}
    
	public void clearFields(){
//		txtUser.clearField();
	//	txtPass.clearField();
	}
	
	
}