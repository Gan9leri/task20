package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@DisplayName("Тесты для Google Pixel 6")
@Tag("mob")
public class SearchTest extends TestBase{
    @DisplayName("Тест строки поиска")
    @Tag("successfulSearchTest")
    @Test
    void successfulSearchTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @DisplayName("Тест открытия статьи")
    @Tag("openItemTest")
    @Test
    void openItemTest(){
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Google");
        });
        step("Verify content found", () ->
                $(id("org.wikipedia.alpha:id/page_list_item_title")).click());
                $(id("org.wikipedia.alpha:id/view_wiki_error_text")).shouldHave(text("Error"));
    }
}