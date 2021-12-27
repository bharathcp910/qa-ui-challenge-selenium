package main.java.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.java.BaseTest;

public class CommonFunctions {

    public WebElement getElement(String identifier, String identifierValue) {
        switch (identifier.toLowerCase()) {
            case "id":
                return BaseTest.driver.findElement(By.id(identifierValue));
            case "css":
                return BaseTest.driver.findElement(By.cssSelector(identifierValue));
            case "xpath":
                return BaseTest.driver.findElement(By.xpath(identifierValue));
            default:
                return null;
        }
    }
}
