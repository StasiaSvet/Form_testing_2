import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class FormDemoqa {

    @BeforeAll
    static void setup() {

        Configuration.startMaximized = true;
    }

    @Test
    void successfulFillTestWithNotBestLocators() throws InterruptedException {
        String firstName = "Ivan";
        String lastName = "Ivanov";
        String email = "ivanivanov@vvv.com";
        String userNumber = "3334445556";
        String subjectInput1 = "English";
        String subjectInput2 = "Biology";
        String cAddress = "ABC 123 KKK";
        String state = "Rajasthan";
        String city = "Jaiselmer";



        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText("Male")).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();

        $(".react-datepicker__month-select").selectOptionByValue("3");
        $(".react-datepicker__year-select").selectOptionByValue("1986");
        $(".react-datepicker__day.react-datepicker__day--002").click();

        $("#subjectsInput").setValue(subjectInput1).pressEnter();
        $("#subjectsInput").setValue(subjectInput2).pressEnter();
        $("#hobbies-checkbox-1+label").click();
        $("#hobbies-checkbox-2+label").click();
        $("#uploadPicture").uploadFromClasspath("111.jpg");
        $("#currentAddress").setValue(cAddress);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();

        //Select by input
        //$("#react-select-3-input").setValue("Haryana").pressEnter();
        //$("#react-select-4-input").setValue("Panipat").pressEnter();

        $("#submit").click();

        $(".modal-content").shouldHave(
                Condition.text(firstName + lastName),
                Condition.text(email),
                Condition.text("Male"),
                Condition.text(userNumber),
                Condition.text("02 April,1986"),
                Condition.text(subjectInput1 + ", " + subjectInput2),
                Condition.text("Sports, Reading"),
                Condition.text("111.jpg"),
                Condition.text(cAddress),
                Condition.text(state + " " + city));
        $("#closeLargeModal").click();
    }
}
