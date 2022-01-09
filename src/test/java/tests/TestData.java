package tests;

import com.github.javafaker.Faker;
import com.github.javafaker.File;

public class TestData {
    static Faker faker = new Faker();
    static String testFirstName = faker.name().firstName();
    static String testLastName = faker.name().lastName();
    static String testEmail = faker.internet().emailAddress();
    static String testPhoneNumber = faker.number().digits(10);
    public static String testAddress = faker.address().streetAddress();
    static String testGender = "Male";
    static String testSubject = "Economics";
    static String testHobbyName = "Music";
    static String testFilePath = "images/test.png";
    static String testStateName = "Haryana";
    static String testCityName = "Panipat";
}
