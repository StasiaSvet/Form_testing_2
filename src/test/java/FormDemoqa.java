import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class FormDemoqa {

    @BeforeAll
    static void setup() {

        Configuration.startMaximized = true;
    }

    @Test
    void successfulFillTestWithNotBestLocators() {
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
        $(byText("Sports")).click();
        $(byText("Reading")).click();
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

                text(firstName + lastName),
                text(email),
                text("Male"),
                text(userNumber),
                text("02 April,1986"),
                text(subjectInput1 + ", " + subjectInput2),
                text("Sports, Reading"),
                text("111.jpg"),
                text(cAddress),
                text(state + " " + city));
        $("#closeLargeModal").click();
        $(".modal-content").shouldNotBe(visible);

        //Sleep(5000);

    }
}
