package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        // Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        if (System.getProperty("remote") != null) {
            Configuration.remote = System.getProperty("remote");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = System.getProperty("browser_name", "chrome");
        Configuration.browserVersion = System.getProperty("browser_version", "100");
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        if (System.getProperty("remote") != null) {
            Attach.addVideo();
        }
    }
}