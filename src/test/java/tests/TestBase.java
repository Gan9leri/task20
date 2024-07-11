package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.BrowserstackConfig;
import config.ConfigReader;
import drivers.BrowserstackDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {

    private static final BrowserstackConfig config = ConfigReader.Instance.read();

    @BeforeAll
    static void beforeAll() {

        BrowserstackDriver driver = new BrowserstackDriver(config);
        driver.getDriver();

        Configuration.browser = BrowserstackDriver.class.getName();
        Configuration.browserSize = null;
    }

    @BeforeEach
    void beforeEach() {
        open();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttacments(){
        String sessionId = Selenide.sessionId().toString();
        System.out.println(sessionId);

//        Attach.screenshotAs("Last screenshot"); // todo fix
        Attach.pageSource();
        closeWebDriver();
        Attach.addVideo(sessionId);
    }
}
