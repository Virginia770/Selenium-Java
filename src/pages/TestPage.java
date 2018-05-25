/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import core.TestElement;

public class TestPage {
	protected String url = "";
	protected String title = "";
	protected Stack<TestElement> confirmElements = null;
	private List<TestElement> elementToConfirm;


	public void setElementsToConfirm(List<TestElement> lista) {
		this.elementToConfirm = lista;
	}

	public boolean validateNavigation(){
		return confirmPage();
	}
	
	protected boolean confirmPage() {
		Iterator<TestElement> it = elementToConfirm.iterator();
		while (it.hasNext()) {
			TestElement element = it.next();
			if (!element.isPresent()) {
				return false;
			}
		}
		return true;

	}


}
