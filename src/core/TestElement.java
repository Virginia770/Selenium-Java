/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.Enums.LocatorType;

//This class contains all methods that work with WebDriver
public class TestElement {

	WebElement elementoWeb = null;
	Select select = null;

	public TestElement() {
	}

	public void findMe(LocatorType locatorType, String elementName) {
	    elementoWeb = Config.getInstance().getDriver().findElement(getFindingMethod(locatorType,elementName));
	}

	public void write(String keysToSend) {
		elementoWeb.sendKeys(keysToSend);
	}

	public void click() {
		elementoWeb.click();
	}

	public boolean isPresent() {
		return elementoWeb.isDisplayed() && elementoWeb.isEnabled();
	}

	public boolean validateText(String text) {
		return elementoWeb.getText().contains(text);
	}

	public void clearField() {
		elementoWeb.clear();
	}

	public void searchSelectItems(LocatorType locatorType, String elementName,
			String value) {
		By by = null;

		switch (locatorType) {
		case ID:
			by = By.id(value);
			select = new Select(Config.getInstance().getDriver()
					.findElement(by));
			break;

		case XPATH:

			by = By.xpath(value);
			select = new Select(Config.getInstance().getDriver()
					.findElement(by));
			break;
		default:
			break;
		}

		select.selectByValue(value);

	}

	public void selectFromCombo(String xpath, LocatorType locator) {
		this.findMe(locator, xpath);

	}
	
	private By getFindingMethod(LocatorType locatorType, String elementName) {
		By by = null;

		switch (locatorType) {
		case ID:
			by = By.id(elementName);
			break;
		case CLASS:
			by = By.className(elementName);
			break;
		case NAME:
			by = By.name(elementName);
			break;
		case INNERTEXT:
			by = By.linkText(elementName);
			break;
		case TITLE:
			by = null;
			break;
		case VALUE:
			by = null;
			break;
		case STYLE:
			by = null;
			break;
		case ALT:
			by = null;
			break;
		case XPATH:
			by = By.xpath(elementName);
			break;
		case CSSPATH:
			by = By.cssSelector(elementName);
			break;
		case NA:
			by = null;
			break;
		default:
			break;
		}
		return by;
	}

}
