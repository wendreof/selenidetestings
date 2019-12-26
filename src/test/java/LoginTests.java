import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.isChrome;

public class LoginTests {

    @DataProvider(name = "login-alerts")
    public Object[][] loginProvider() {
        return new Object[][]{
                {"wendreo@dev.com.br", "bc`123", "Usuário e/ou senha inválidos"},
                {"123@kkkkk.org", "bbc`123", "Usuário e/ou senha inválidos"},
                {"", "bbc`123", "Opps. Cadê o email?"},
                {"wendreo@dev.com.br", "", "Opps. Cadê a senha?"}
        };
    }

    @Test
    public void shouldSeeLoggedUser() {
        isChrome();
        executeJavaScript("localStorage.clear();");
        open("http://ninjaplus-web:5000/login");

        $("#emailId").setValue("wendreo@dev.com.br");
        $("#passId").setValue("pwd123");
        //$("#login").click();
        $(byText("Entrar")).click();
        $(".user .info span").shouldHave(text("Wendreo"));
    }

    @Test(dataProvider = "login-alerts")
    public void ShouldSeeLoginAlerts(String email, String pwd, String expectedAlert) {
        isChrome();
        open("http://ninjaplus-web:5000/login");

        $("#emailId").setValue(email);
        $("#passId").setValue(pwd);
        $(byText("Entrar")).click();

        $(".alert span").shouldHave(text(expectedAlert));
    }
}
