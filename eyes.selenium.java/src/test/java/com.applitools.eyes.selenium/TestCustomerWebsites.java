package com.applitools.eyes.selenium;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AdidasTest.class,
        AdidasTest_ForceFPS.class,
        DellTest.class,
        WizzAirTest.class
})
public class TestCustomerWebsites {
}
