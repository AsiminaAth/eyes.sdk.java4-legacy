package com.applitools.eyes.selenium;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestFluentApi_Chrome.class,
        TestFluentApi_Chrome_ForceFullPageScreenShot.class,
        TestFluentApi_Firefox.class,
        TestFluentApi_Firefox_ForceFullPageScreenshot.class
})

public class SeleniumFluentAPITestsSuite {
}
