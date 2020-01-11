package tests;

import commom.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;

public class LoginTests extends BaseTest {

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
        login
                .open()
                .with("wendreo@dev.com.br", "pwd123");

        side.loggedUser().shouldHave(text("Wendreo"));
    }

    //DDT  (Data Driven Testing)
    @Test(dataProvider = "login-alerts")
    public void ShouldSeeLoginAlerts(String email, String pwd, String expectedAlert) {
        login
                .open()
                .with(email, pwd)
                .alert().shouldHave(text(expectedAlert));
    }

    @AfterMethod
    public void cleanup() {
        login.clearSession();
    }
}
