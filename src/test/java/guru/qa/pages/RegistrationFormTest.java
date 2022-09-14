package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.*;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest {

    private static final String URL = "/automation-practice-form";

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultTableComponent resultTableComponent = new ResultTableComponent();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            stateCityWrapper = $("#stateCity-wrapper"),
            submit = $("#submit");


    @Step("Открываем страницу")
    public RegistrationFormTest openPage() {
        open(URL);
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    @Step("Подставляем имя {value}")
    public RegistrationFormTest setFirstName(final String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Подставляем фамилию {value}")
    public RegistrationFormTest setLastName(final String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Подставляем email {value}")
    public RegistrationFormTest setEmail(final String value) {
        emailInput.setValue(value);

        return this;
    }

    @Step("Подставляем пол {value}")
    public RegistrationFormTest setGender(final String value) {
        $(byText(value)).click();

        return this;
    }

    @Step("Подставляем номер телефона {value}")
    public RegistrationFormTest setNumber(final String value) {
        userNumberInput.setValue(value);

        return this;
    }

    @Step("Подставляем дату рождения {day}-{month}-{year}")
    public RegistrationFormTest setBirthDate(final String day, final String month, final String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Подставляем предмет {value}")
    public RegistrationFormTest setSubjects(final String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Подставляем хобби {value}")
    public RegistrationFormTest setHobbies(final String value) {
        $(byText(value)).click();

        return this;
    }

    @Step("Подставляем картинку {value}")
    public RegistrationFormTest setPicture(final String value) {
        uploadPicture.uploadFile(new File(value));

        return this;
    }

    @Step("Подставляем адрес {value}")
    public RegistrationFormTest setAddress(final String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    @Step("Подставляем штат {value}")
    public RegistrationFormTest setState(final String value) {
        stateInput.scrollTo().click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Подставляем город {value}")
    public RegistrationFormTest setCity(final String value) {
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Жмём отправить")
    public RegistrationFormTest clickSubmit() {
        submit.pressEnter();

        return this;
    }

    @Step("Проверка отображения формы")
    public RegistrationFormTest checkResultTableVisible() {
        resultTableComponent.checkVisible();

        return this;
    }

    @Step("Проверка подстановки {key} = {value}")
    public RegistrationFormTest checkResult(final String key, final String value) {
        resultTableComponent.checkResult(key, value);

        return this;
    }
}