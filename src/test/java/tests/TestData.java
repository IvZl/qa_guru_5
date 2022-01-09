package tests;

import com.github.javafaker.Faker;

public class TestData {
    static Faker faker = new Faker();
    static String testFirstName = faker.name().firstName();
    static String testLastName = faker.name().lastName();
    static String testEmail = faker.internet().emailAddress();
    static String testPhoneNumber = faker.number().digits(10);
}
