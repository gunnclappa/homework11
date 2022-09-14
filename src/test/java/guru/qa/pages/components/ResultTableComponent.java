package guru.qa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

    private static final String TITLE_TEXT = "Thanks for submitting the form";

    private SelenideElement
            modalDialog = $(".modal-dialog"),
            modalHeader = $(".modal-header"),
            table = $(".table-responsive table");

    public ResultTableComponent checkVisible() {
        modalDialog.should(appear);
        modalHeader.shouldHave(text(TITLE_TEXT));

        return this;
    }

    public ResultTableComponent checkResult(final String key, final String value) {
        table.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }
}