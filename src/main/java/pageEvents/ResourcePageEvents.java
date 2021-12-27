package main.java.pageEvents;

import main.java.pageObjects.ResourcePageElements;
import main.java.utils.CommonFunctions;

public class ResourcePageEvents {

    public void selectCrudOperations() {
        CommonFunctions commonFunctions = new CommonFunctions();
        commonFunctions.getElement("id", ResourcePageElements.tabCrudOperations).click();
    }

    public void clickOnRead() {
        CommonFunctions commonFunctions = new CommonFunctions();
        commonFunctions.getElement("id", ResourcePageElements.btnReadPatient).click();
    }
}
