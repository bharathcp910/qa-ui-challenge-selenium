package main.java.pageEvents;

import main.java.pageObjects.ResultPageElements;
import main.java.utils.CommonFunctions;
import org.testng.Assert;

public class ResultPageEvents {

    public void validateReadPatientWithoutId() {
        CommonFunctions commonFunctions = new CommonFunctions();
        Assert.assertTrue(commonFunctions.getElement("css", ResultPageElements.alertHeading).getText()
                .equals("Warning!"));
        Assert.assertTrue(commonFunctions.getElement("css", ResultPageElements.alertMessage).getText()
                .equals("No ID specified"));
    }
}
