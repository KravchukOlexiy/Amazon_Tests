package autotests.tests;

import autotests.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPageTests extends BaseTest {

    @Test
    @Description("regression")
    @Disabled("Example test code for further test development")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://www.amazon.com/'", () ->
                open("https://www.amazon.com/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @Test
    @Tag("smoke")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://www.amazon.com/'", () ->
                open("https://www.amazon.com/"));

        step("Page title should have text 'Amazon.com. Spend less. Smile more.'", () -> {
            String expectedTitle = "Amazon.com. Spend less. Smile more.";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Tag("smoke")
    @DisplayName("Successful authorization to some demowebshop (UI)")
    void mainPageHasMainMenuTest() {
        step("Open url 'https://www.amazon.com/'", () ->
                open("https://www.amazon.com/"));

        step("Page should have items in main menu", () ->
                $$("#nav-main").shouldHave(sizeGreaterThan(0)));
    }

}
