package com.applitools.eyes.selenium;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.fluent.Target;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.model.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

@RunWith(JUnit4.class)
public class AdidasTest_ForceFPS extends TestSetup {

    @ClassRule
    public static final TestRule setTestSuitName = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            testSuitName = "Adidas Region";
            testedPageUrl = "http://www.adidas.com/us/soccer-shoes";
            testedPageSize = new RectangleSize(1380, 680);
            hideScrollbars = false;
            forceFullPageScreenshot = true;
        }
    };

    @Rule
    public final TestRule beforeTest = new TestWatcher() {
        @Override
        public Statement apply(Statement statement, Description description) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            options.setHeadless(true);
            caps = options;

            return statement;
        }
    };

    @Test
    public void TestAdidas_Fluent_ForceFPS() {
        eyes.check("Work As expected", Target.region(By.cssSelector("#product-grid")));
    }

    @Test
    public void TestAdidas_Classic_ForceFPS(){
        eyes.checkRegion(By.cssSelector("#product-grid"),"Not working as expected");
    }
}