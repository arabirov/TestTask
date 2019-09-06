package qa.selenide.zoom;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import qa.selenide.zoom.common.Browser;
import qa.selenide.zoom.description.Constants;
import qa.selenide.zoom.common.GoogleDocsForm;

import java.util.logging.Logger;

public class FirefoxNavigationTest extends AbstractNavigationTest {

    private static final Logger LOGGER = Logger.getLogger(FirefoxNavigationTest.class.getName());

    @BeforeClass
    public static void driverFirefox() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
        WebDriver driver = new FirefoxDriver();
        WebDriverRunner.setWebDriver(driver);
        WebDriverRunner.clearBrowserCache();
        Selenide.open(Constants.Env.URL);
    }

    @AfterClass
    public static void closeFirefox() {
        WebDriverRunner.driver().getWebDriver().quit();
        LOGGER.info("Firefox tests ended.");
    }

    @Test
    public void runTest() {
        GoogleDocsForm googleDocsForm = new GoogleDocsForm(Browser.FIREFOX);
        doActions(googleDocsForm);
    }
}