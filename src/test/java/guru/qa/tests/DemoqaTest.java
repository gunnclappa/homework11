package guru.qa.tests;

import guru.qa.pages.RegistrationFormTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static guru.qa.tests.TestData.*;

public class DemoqaTest extends TestBase {

    @Test
    @DisplayName("Проверка заполнения формы Student Registration Form")
    @Feature("Student Registration Form")
    @Story("Заполнение Student Registration Form")
    @Owner("Kayrat")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Student Registration Form", url = "https://demoqa.com/automation-practice-form")
    void fillFormTest() {

        RegistrationFormTest registrationFormTest = new RegistrationFormTest();

        // Set Values
        registrationFormTest.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(number)
                .setBirthDate(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobby)
                .setPicture(picturePath)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        // Assertions
        registrationFormTest.checkResultTableVisible()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", number)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", pictureName)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }
}