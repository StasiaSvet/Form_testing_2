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
        String name = "Ivan";
        String lastName = "Ivanov";
        String email = "ivanivanov@vvv.com";
        String userNumber = "3334445";
        String subjectInput1 = "Eng";
        String subjectInput2 = "Bio";



        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(name);
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


        sleep(10000);






    }








}
