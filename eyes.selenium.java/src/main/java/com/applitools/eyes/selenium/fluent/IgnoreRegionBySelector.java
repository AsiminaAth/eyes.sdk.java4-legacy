package com.applitools.eyes.selenium.fluent;

import com.applitools.eyes.*;
import com.applitools.eyes.fluent.GetRegion;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class IgnoreRegionBySelector implements GetRegion {
    private By selector;

    public IgnoreRegionBySelector(By selector) {
        this.selector = selector;
    }

    @Override
    public List<Region> getRegions(EyesBase eyesBase, EyesScreenshot screenshot) {
        List<WebElement> elements = ((Eyes) eyesBase).getDriver().findElements(this.selector);
        List<Region> regions = new ArrayList<>(elements.size());
        for (WebElement element : elements) {

            Point p = element.getLocation();
            Location l = new Location(p.getX(), p.getY());
            Location lTag = screenshot.convertLocation(l, CoordinatesType.CONTEXT_RELATIVE, CoordinatesType.SCREENSHOT_AS_IS);

            regions.add(new Region(
                    lTag.getX(),
                    lTag.getY(),
                    element.getSize().getWidth(),
                    element.getSize().getHeight()));
        }

        return regions;
    }
}
