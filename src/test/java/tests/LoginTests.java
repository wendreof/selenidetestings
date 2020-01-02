package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.components.SideBar;

import static com.codeborne.selenide.Condition.text;

public class LoginTests {

    protected static LoginPage login;
    protected static SideBar side;

    @DataProvider(name = "login-alerts")
    public Object[][] loginProvider() {
        return new Object[][]{
                {"wendreo@dev.com.br", "bc`123", "Usuário e/ou senha inválidos"},
                {"123@kkkkk.org", "bbc`123", "Usuário e/ou senha inválidos"},
                {"", "bbc`123", "Opps. Cadê o email?"},
                {"wendreo@dev.com.br", "", "Opps. Cadê a senha?"}
        };
    }

    @BeforeMethod
    public void start() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://ninjaplus-web:5000";

        login = new LoginPage();
        side = new SideBar();
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
