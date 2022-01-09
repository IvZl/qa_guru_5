package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;
import static tests.TestData.*;

public class RegistrationFormTestWithPageObjects {

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
                .selectGender("Male")
                .setPhone(testPhoneNumber)
                .setSubject("Economics")
                .selectHobbies("Music")
                .calendarComponent.setDate("30","November", "1998");

        $("#currentAddress").setValue("TestAddress");
        $("#uploadPicture").uploadFromClasspath("images/test.png");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#react-select-4-input").setValue("Karnal").pressEnter();

        $("[id=submit]").click();

        registrationPage
                .checkResultValues("Student Name", testFirstName + " " + testLastName)
                .checkResultValues("Student Email", testEmail)
                .checkResultValues("Gender", "Male")
                .checkResultValues("Mobile", testPhoneNumber)
                .checkResultValues("Date of Birth", "30 November,1998")
                .checkResultValues("Subjects", "Economics")
                .checkResultValues("Hobbies", "Music");
          //      .checkResultValues("Picture",)
            //    .checkResultValues("Address",)
              //  .checkResultValues("State and City",);

        $(".table-responsive").shouldHave(
                text("test.png"),
                text("TestAddress"),
                text("Haryana"),
                text("Karnal"));
    }
}