package com.applitools.eyes.selenium.fluent;

import com.applitools.eyes.*;
import com.applitools.eyes.fluent.GetFloatingRegion;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FloatingRegionBySelector implements GetFloatingRegion {

    private By selector;
    private int maxUpOffset;
    private int maxDownOffset;
    private int maxLeftOffset;
    private int maxRightOffset;

    public FloatingRegionBySelector(By regionSelector, int maxUpOffset, int maxDownOffset, int maxLeftOffset, int maxRightOffset) {

        this.selector = regionSelector;
        this.maxUpOffset = maxUpOffset;
        this.maxDownOffset = maxDownOffset;
        this.maxLeftOffset = maxLeftOffset;
        this.maxRightOffset = maxRightOffset;
    }

    @Override
    public List<FloatingMatchSettings> getRegions(EyesBase eyesBase, EyesScreenshot screenshot) {
        List<WebElement> elements = ((Eyes) eyesBase).getDriver().findElements(this.selector);
        List<FloatingMatchSettings> value = new ArrayList<>();
        for (WebElement element : elements) {
            Point p = element.getLocation();
            Location l = new Location(p.getX(), p.getY());
            Location lTag = screenshot.convertLocation(l, CoordinatesType.CONTEXT_RELATIVE, CoordinatesType.SCREENSHOT_AS_IS);
            value.add(new FloatingMatchSettings(
                    lTag.getX(),
                    lTag.getY(),
                    element.getSize().getWidth(),
                    element.getSize().getHeight(),
                    maxUpOffset, maxDownOffset, maxLeftOffset, maxRightOffset));
        }
        return value;
    }
}
