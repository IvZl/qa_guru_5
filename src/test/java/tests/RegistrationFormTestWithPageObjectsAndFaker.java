package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.TestData.*;

public class RegistrationFormTestWithPageObjectsAndFaker {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll () {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .setFirstName(testFirstName)
                .setLastName(testLastName)
                .setEmail(testEmail)
                .selectGender(testGender)
                .setPhone(testPhoneNumber)
                .setSubject(testSubject)
                .selectHobbies(testHobbyName)
                .setAddress(testAddress)
                .uploadFile(testFilePath)
                .selectState(testStateName)
                .selectCity(testCityName)
                .calendarComponent.setDate("30","November", "1998");

        registrationPage.clickSubmit();

        registrationPage
                .checkResultValues("Student Name", testFirstName + " " + testLastName)
                .checkResultValues("Student Email", testEmail)
                .checkResultValues("Gender", testGender)
                .checkResultValues("Mobile", testPhoneNumber)
                .checkResultValues("Date of Birth", "30 November,1998")
                .checkResultValues("Subjects", testSubject)
                .checkResultValues("Hobbies", testHobbyName)
                .checkResultValues("Picture", "test.png")
                .checkResultValues("Address", testAddress)
                .checkResultValues("State and City",testStateName + " " + testCityName);
    }
}