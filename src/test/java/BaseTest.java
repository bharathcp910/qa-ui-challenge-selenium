package test.java;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import main.java.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public ExtentHtmlReporter htmlReporter;
    public static ExtentReports extentReports;
    public static ExtentTest logger;

    @BeforeTest
    public void beforeTestMethod() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator
                + "AutomationReport.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Automation report");
        htmlReporter.config().setReportName("Automation Test Results");
        htmlReporter.config().setTheme(Theme.DARK);
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("Author", "Bharath");
    }

    @BeforeMethod
    public void beforeMethodMethod(Method testMethod) {
        logger = extentReports.createTest(testMethod.getName());
        setUp(Constants.browser);
        driver.manage().window().maximize();
        driver.get(Constants.URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void afterMethodMethod(ITestResult result) {
        if (result.isSuccess()) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test case: " + methodName + "passed";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS, markup);
        } else {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test case: " + methodName + "failed";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL, markup);
        }
        driver.quit();
    }

    @AfterTest
    public void afterTestMethod() {
        extentReports.flush();
    }

    public void setUp(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers"
                    + File.separator + "chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "drivers"
                    + File.separator + "geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers"
                    + File.separator + "chromedriver.exe");
            driver = new ChromeDriver();
        }
    }
}
