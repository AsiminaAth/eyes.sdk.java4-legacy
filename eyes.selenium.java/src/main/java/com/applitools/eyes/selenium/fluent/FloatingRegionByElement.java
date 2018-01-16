package com.applitools.eyes.selenium.fluent;

import com.applitools.eyes.*;
import com.applitools.eyes.fluent.GetFloatingRegion;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FloatingRegionByElement implements GetFloatingRegion {

    private WebElement element;
    private int maxUpOffset;
    private int maxDownOffset;
    private int maxLeftOffset;
    private int maxRightOffset;

    public FloatingRegionByElement(WebElement element, int maxUpOffset, int maxDownOffset, int maxLeftOffset, int maxRightOffset) {
        this.element = element;
        this.maxUpOffset = maxUpOffset;
        this.maxDownOffset = maxDownOffset;
        this.maxLeftOffset = maxLeftOffset;
        this.maxRightOffset = maxRightOffset;
    }

    @Override
    public List<FloatingMatchSettings> getRegions(EyesBase eyesBase, EyesScreenshot screenshot) {
        Point p = element.getLocation();
        Location l = new Location(p.getX(), p.getY());
        Location lTag = screenshot.convertLocation(l, CoordinatesType.CONTEXT_RELATIVE, CoordinatesType.SCREENSHOT_AS_IS);

        List<FloatingMatchSettings> value = new ArrayList<>();
        value.add(new FloatingMatchSettings(
                lTag.getX(),
                lTag.getY(),
                element.getSize().getWidth(),
                element.getSize().getHeight(),
                maxUpOffset, maxDownOffset, maxLeftOffset, maxRightOffset));

        return value;
    }
}
