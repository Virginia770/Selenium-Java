/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;


public class Enums {
    // element types

    public enum ElementType {

        ARTICLE, BUTTON, INPUT, CHECKBOX, DIV, H1, H2, H3, LABEL, TABLE, TH, TR, TD, LI, OL, UL,       
        LINK, PARA, RADIO, SECTION, SELECT, SPAN, TEXTAREA, TEXTFIELD, FORM, H6, FILEINPUT, IMAGE;
    }
    // locator types

    public static enum LocatorType {

        CLASS, HREF, ID, NAME, INNERTEXT, TITLE, VALUE, STYLE, ALT, XPATH, CSSPATH, NA;
    }
    
    public static enum Browsers{
        FIREFOX, CHROME, IE, SAFARI;
    }
   }
