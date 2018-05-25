package pages.profile;

import java.util.ArrayList;
import java.util.List;

import core.TestElement;
import pages.TestPage;
import utils.Enums.LocatorType;

public class ProfilePage extends TestPage{

	TestElement editLink = new TestElement();
	TestElement txtDisplayName = new TestElement();
	TestElement txtDisplayNameInput = new TestElement();
	TestElement btnSave = new TestElement();
	String attribute;
	String attributeEdited;
	
	
	
	public ProfilePage(){
		
		// findElement(xpath,Edit)
		editLink.findMe(LocatorType.XPATH,"//*[text()='Edit']");
		txtDisplayName.findMe(LocatorType.ID, "display_name");
		txtDisplayNameInput.findMe(LocatorType.ID, "display_name_input");
		btnSave.findMe(LocatorType.ID, "submit_changes");
		
		List <TestElement> list= new ArrayList<TestElement>();
		list.add(editLink);
		list.add(txtDisplayName);
		//list.add(txtDisplayNameInput);
		list.add(btnSave);
		super.setElementsToConfirm(list);
		System.out.println("Profile Page OK");
		
		
	}
	

	public boolean validateNavigation(){
		return confirmPage();
	}
	
	
	
	public void enableEditLink() {
		 editLink.click();
		// EditDisplayName();
		}
	
	public void EditDisplayName() {
		
		
		attributeEdited = "NewTest DisplayName";
		//attribute = txtDisplayName.getAttribute("value");				//get the current display name
		System.out.println("DisplayName es " +attribute);
		txtDisplayNameInput.clearField();
		txtDisplayNameInput.write(attributeEdited);
		System.out.println(attribute);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnSave.click();
		
		}
	
	public boolean verifyAttribute(){
		
		//System.out.println("old:"+attribute);
		//System.out.println("new"+attributeEdited);
		
		
	if(attributeEdited!=attribute)
		return true;
	else
		return false;
	}
	
	public void SetInitalDisplayName(){
		

		txtDisplayNameInput.clearField();
		txtDisplayNameInput.write(attribute);
		System.out.println(attribute);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnSave.click();
		//System.out.println("DisplayName es "+attribute);
	}
	
}
