package test.java;

import main.java.pageEvents.LeftNavigationPaneEvents;
import main.java.pageEvents.ResourcePageEvents;
import main.java.pageEvents.ResultPageEvents;
import org.testng.annotations.Test;

public class ReadPatientTest extends BaseTest{

    @Test(priority = 1)
    public void readPatientWithoutId() {
        LeftNavigationPaneEvents leftNavigationPaneEvents = new LeftNavigationPaneEvents();
        ResourcePageEvents resourcePageEvents = new ResourcePageEvents();
        ResultPageEvents resultPageEvents = new ResultPageEvents();

        leftNavigationPaneEvents.clickOnPatientResource();
        resourcePageEvents.selectCrudOperations();
        resourcePageEvents.clickOnRead();
        resultPageEvents.validateReadPatientWithoutId();
    }
}
