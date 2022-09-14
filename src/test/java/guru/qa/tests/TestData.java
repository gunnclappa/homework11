package guru.qa.tests;

import com.github.javafaker.Faker;
import guru.qa.utils.RandomValues;

public class TestData {
    static Faker faker = new Faker();
    static RandomValues randomValues = new RandomValues();
    static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = randomValues.gender(),
            number = faker.phoneNumber().subscriberNumber(10),
            day = String.valueOf(faker.number().numberBetween(10, 28)),
            month = randomValues.month(),
            year = String.valueOf(faker.number().numberBetween(1970, 2022)),
            subject = "Maths",
            hobby = randomValues.hobby(),
            picturePath = "src/test/resources/cat.jpg",
            pictureName = "cat.jpg",
            address = faker.address().fullAddress(),
            state = "Haryana",
            city = "Karnal";
}