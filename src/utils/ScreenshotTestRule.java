package utils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

//import tests.GeneralTest;
import core.Config;
 
public class ScreenshotTestRule implements MethodRule { 
    @Override
    public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, final Object o) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    statement.evaluate();
                } catch (Throwable t) {
                    captureScreenshot(frameworkMethod.getName());
                    throw t;
                }
            }
 
         /*   public void captureScreenshot(String methodName) {
                try {
                	Date date = new Date();
                	SimpleDateFormat dformat=new SimpleDateFormat("yyyy.MM.dd HH.mm.ss zzzz");
                	System.out.println(dformat.format(date));
                    String filename =  Constants.Browser +"_"+ methodName + "_"+ dformat.format(date) + ".png";
                    File screenshot = ((TakesScreenshot) Config.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
                    FileUtils.copyFile(screenshot, new File("target" + File.separator + "result" + File.separator + filename));
                    Log.error("\t\tTaking screenshot: " + filename);
                	System.err.println("Llego al screenshot method");
                //	GeneralTest.quitDriver();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
           */
        };
    }

	   public void captureScreenshot(String methodName) {
                try {
                	Date date = new Date();
                	SimpleDateFormat dformat=new SimpleDateFormat("yyyy.MM.dd HH.mm.ss zzzz");
                	System.out.println(dformat.format(date));
                    String filename =  Constants.Browser +"_"+ methodName + "_"+ dformat.format(date) + ".png";
                    File screenshot = ((TakesScreenshot) Config.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
                    FileUtils.copyFile(screenshot, new File("target" + File.separator + "result" + File.separator + filename));
                    Log.error("\t\tTaking screenshot: " + filename);
                	System.err.println("Llego al screenshot method");
                //	GeneralTest.quitDriver();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
}