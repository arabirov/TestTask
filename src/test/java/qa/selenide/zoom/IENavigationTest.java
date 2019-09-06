package qa.selenide.zoom;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import qa.selenide.zoom.common.Browser;
import qa.selenide.zoom.description.Constants;
import qa.selenide.zoom.common.GoogleDocsForm;

import java.util.logging.Logger;

public class IENavigationTest extends AbstractNavigationTest {

    private static final Logger LOGGER = Logger.getLogger(IENavigationTest.class.getName());

    @BeforeClass
    public static void driverIE() {
        System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
        WebDriver driver = new InternetExplorerDriver();
        WebDriverRunner.setWebDriver(driver);
        WebDriverRunner.clearBrowserCache();
        Selenide.open(Constants.Env.URL);
    }

    @AfterClass
    public static void closeIE() {
        WebDriverRunner.driver().getWebDriver().close();
        WebDriverRunner.driver().getWebDriver().quit();
        LOGGER.info("IE tests ended.");
    }

    @Test
    public void runTest() {
        GoogleDocsForm googleDocsForm = new GoogleDocsForm(Browser.IE);
        doActions(googleDocsForm);
    }
}