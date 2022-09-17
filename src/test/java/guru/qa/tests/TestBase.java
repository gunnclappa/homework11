package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

    private final static String REMOTE = System.getProperty("remote"),
            LOGIN_REMOTE = "user1",
            PASSWORD_REMOTE = "1234";

    @BeforeAll
    static void configure() {


        SelenideLogger.addListener("allure", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = System.getProperty("browser_name", "chrome");
        Configuration.browserVersion = System.getProperty("browser_version", "100");
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");

        if (REMOTE == null || REMOTE.equals("")) {
        } else {
            Configuration.remote = "https://"
                    + LOGIN_REMOTE + ":"
                    + PASSWORD_REMOTE + "@"
                    + REMOTE;

            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        }
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        if (REMOTE == null || REMOTE.equals("")) {
        } else {
            Attach.addVideo();
        }
    }
}