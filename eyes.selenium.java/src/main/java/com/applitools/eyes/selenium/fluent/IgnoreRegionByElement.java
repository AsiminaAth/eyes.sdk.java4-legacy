package com.applitools.eyes.selenium.fluent;

import com.applitools.eyes.*;
import com.applitools.eyes.fluent.GetRegion;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class IgnoreRegionByElement implements GetRegion {
    private WebElement element;

    public IgnoreRegionByElement(WebElement element){
        this.element = element;
    }

    @Override
    public List<Region> getRegions(EyesBase eyesBase, EyesScreenshot screenshot) {
        Point p = element.getLocation();
        Location l = new Location(p.getX(), p.getY());
        Location lTag = screenshot.convertLocation(l, CoordinatesType.CONTEXT_RELATIVE, CoordinatesType.SCREENSHOT_AS_IS);
        List<Region> value = new ArrayList<>();
        value.add(new Region(
                lTag.getX(),
                lTag.getY(),
                element.getSize().getWidth(),
                element.getSize().getHeight()));
        return value;
    }
}
