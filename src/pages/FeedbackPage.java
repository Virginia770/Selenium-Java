package pages;

import java.util.ArrayList;
import java.util.List;

import core.TestElement;
import pages.TestPage;
import utils.Enums.LocatorType;

public class FeedbackPage extends TestPage {

		TestElement inputContactName = new TestElement();
		TestElement comboPrimaryRole = new TestElement();
		TestElement comboRecognitionLevel = new TestElement();
		TestElement taContactAttr = new TestElement();
		TestElement inputInstitution = new TestElement();
		TestElement comboInstitutionType = new TestElement();
		TestElement checkPayer = new TestElement();
		TestElement checkIDS = new TestElement();
		TestElement inputIDS = new TestElement();
		TestElement dueDate = new TestElement();
		TestElement comboTimeSpent = new TestElement();
		TestElement taTopics = new TestElement();
		TestElement inputTopInsight = new TestElement();
		TestElement taInsight = new TestElement();
		TestElement linkCancel = new TestElement();
		TestElement btnPost = new TestElement();
		TestElement primaryRoleButton = new TestElement();
	
		
		public FeedbackPage() {
			
			inputContactName.findMe(LocatorType.XPATH, "//*[contains(@class,'dropdown')][@id='createLink']");
			//inputContactName.findMe(LocatorType.ID, "contacts");
		/*	comboPrimaryRole.findMe(LocatorType.ID, "primaryRoleMenu");
			//comboRecognitionLevel.findMe(LocatorType.ID, "recognitionLevelButton");
			comboRecognitionLevel.findMe(LocatorType.ID, "recognitionLevelMenu");
			taContactAttr.findMe(LocatorType.ID, "s2id_attributes");
			inputInstitution.findMe(LocatorType.ID, "institutions");
			comboInstitutionType.findMe(LocatorType.ID, "institutionTypeMenu");
			checkPayer.findMe(LocatorType.ID, "payer");
			checkIDS.findMe(LocatorType.ID, "ids");
			inputIDS.findMe(LocatorType.ID, "idsInput");
			dueDate.findMe(LocatorType.ID, "dueDate");
			comboTimeSpent.findMe(LocatorType.ID, "timeSpentMenu");
			taTopics.findMe(LocatorType.ID, "s2id_topics");
			inputTopInsight.findMe(LocatorType.ID, "insightTxtArea");
			taInsight.findMe(LocatorType.ID, "s2id_insight");
			linkCancel.findMe(LocatorType.XPATH, "//a[contains(@class,'cancel')]");
			btnPost.findMe(LocatorType.CSSPATH, "#kernelfooterdiv #postFeedback");
		*/	
			List <TestElement> list= new ArrayList<TestElement>();
			list.add(inputContactName);
		/*	list.add(comboPrimaryRole);
			list.add(comboRecognitionLevel);
			list.add(taContactAttr);
			list.add(inputInstitution);
			list.add(comboInstitutionType);
			list.add(checkPayer);
			list.add(checkIDS);
		//	list.add(inputIDS);
			list.add(comboTimeSpent);
			list.add(taTopics);
		//	list.add(inputTopInsight);
			list.add(taInsight);
			list.add(linkCancel);
			list.add(btnPost);*/
			super.setElementsToConfirm(list);
			System.out.println("Feedback Page OK");
			
		}
  
		public boolean validateNavigation(){
			return confirmPage();
		}
		public void clickOnbtnPost(){
			btnPost.click();
		}
		
		public void sendKeysInputContactName(String message) {
			inputContactName.write(message);
		}
		
		public void searchSelectItems(LocatorType locatorType, String elementName) {
		
			comboPrimaryRole.searchSelectItems(locatorType, elementName, "Care Coordinator");
		}
		
		public void addFeedback(){
			/**
			 * comboMas.selectFromCombo()
			 */
		}
		
		
		
}
