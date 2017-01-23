package ro.accenture.selenium.II.utils;

import org.apache.commons.io.FileUtils;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by andreicontan on 19/01/2017.
 */
public class ScreenshotRule implements MethodRule {

    public WebDriver driver;

    public ScreenshotRule(WebDriver driver){
        this.driver = driver;
    }

    public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod,
                           final Object o){
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    statement.evaluate();
                }
                catch (Throwable t){
                    captureScreenshot(frameworkMethod.getName());
                    throw t;
                }
            }
            public void captureScreenshot(String fileName) throws IOException {
                File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                fileName += UUID.randomUUID().toString();
                String path = "/Users/andreicontan/Documents/Work/Trainings/Accenture/Training - Selenium3Days/worksets/UnitTestsWarZone/src/test/screenshots";

                File targetFile = new File(path + fileName + ".png");
                FileUtils.copyFile(screenshot, targetFile);

            }
        };
    }
}
