package com.applitools.eyes.selenium;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SeleniumClassicAPITestsSuite.class,
        SeleniumFluentAPITestsSuite.class,
        TestSpecialCases_Chrome.class,
        TestSpecialCases_Chrome_ForceFullPageScreenshot.class,
        //TestCustomerWebsites.class
})

public class SeleniumTestsSuite {
}
