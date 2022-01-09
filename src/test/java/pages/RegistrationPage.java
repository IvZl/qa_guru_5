package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    SelenideElement
            enterFirstName = $("#firstName"),
            enterLastName = $("#lastName"),
            enterEmail = $("#userEmail"),
            selectGender = $("#genterWrapper"),
            enterPhone = $("#userNumber"),
            resultTable = $(".table-responsive"),
            enterSubject = $("#subjectsInput"),
            selectHobbies = $("#hobbiesWrapper"),
            enterAddress = $("#currentAddress"),
            selectFile = $("#uploadPicture"),
            selectState = $("#state #react-select-3-input"),
            selectCity =  $("#city #react-select-4-input");



    public CalendarComponent calendarComponent = new CalendarComponent();


    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        enterFirstName.setValue(firstName);

        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        enterLastName.setValue(lastName);

        return this;
    }

    public RegistrationPage setEmail(String email) {
        enterEmail.setValue(email);

        return this;
    }

    public RegistrationPage selectGender(String gender) {
        selectGender.$(byText(gender)).click();

        return this;
    }

    public RegistrationPage setPhone(String phone) {
        enterPhone.setValue(phone);

        return this;
    }

    public RegistrationPage setSubject(String nameOfSubject) {
        enterSubject.setValue(nameOfSubject).pressEnter();

        return this;
    }

    public RegistrationPage selectHobbies(String nameOfHobbies) {
        selectHobbies.$(byText(nameOfHobbies)).click();

        return this;
    }

    public RegistrationPage checkResultValues(String key, String value) {
        resultTable.$(byText(key)).parent().shouldHave(text(value));

        return this;
    }

    public RegistrationPage setAddress(String address) {
        enterAddress.setValue(address);

        return this;
    }

    public RegistrationPage uploadFile(String path) {
        selectFile.uploadFromClasspath(path);

        return this;
    }

    public RegistrationPage selectState(String state) {
        selectState.setValue(state).pressEnter();

        return this;
    }

    public RegistrationPage selectCity(String city) {
        selectCity.setValue(city).pressEnter();

        return this;
    }

    public void clickSubmit() {
        $("[id=submit]").click();
    }
}