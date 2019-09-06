package qa.selenide.zoom;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import qa.selenide.zoom.common.Browser;
import qa.selenide.zoom.description.Constants;
import qa.selenide.zoom.common.GoogleDocsForm;

import java.util.logging.Logger;

public class ChromeNavigationTest extends AbstractNavigationTest {

    private static final Logger LOGGER = Logger.getLogger(ChromeNavigationTest.class.getName());

    @BeforeClass
    public static void driverChrome() {
        WebDriverRunner.clearBrowserCache();
        Selenide.open(Constants.Env.URL);
    }

    @AfterClass
    public static void closeChrome() {
        WebDriverRunner.driver().getWebDriver().quit();
        LOGGER.info("Chrome tests ended.");
    }

    @Test
    public void runTest() {
        GoogleDocsForm googleDocsForm = new GoogleDocsForm(Browser.CHROME);
        doActions(googleDocsForm);
    }
}