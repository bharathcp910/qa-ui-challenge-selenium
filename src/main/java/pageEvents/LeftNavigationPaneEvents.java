package main.java.pageEvents;

import main.java.pageObjects.LeftNavigationPaneElements;
import main.java.utils.CommonFunctions;

public class LeftNavigationPaneEvents {

    public void clickOnPatientResource() {
        CommonFunctions commonFunctions = new CommonFunctions();
        commonFunctions.getElement("id", LeftNavigationPaneElements.lnkPatientResource).click();
    }
}
