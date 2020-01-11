package pages;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.components.SideBar;

import static com.codeborne.selenide.Condition.text;

public class MovieTests {

    private static MoviePage movie;
    private static SideBar side;
    private static LoginPage login;

    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://ninjaplus-web:5000";

        login = new LoginPage();
        side = new SideBar();
        movie = new MoviePage();

        login
                .open()
                .with("wendreo@dev.com.br", "pwd123");

        side.loggedUser().shouldHave(text("Wendreo"));
    }

    @Test
    public void shouldRegisterANewMovie() {
        String title = "Jumanji - Next Leve";

        movie.add().create(title);
    }
}
