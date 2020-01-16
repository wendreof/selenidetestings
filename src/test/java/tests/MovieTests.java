package tests;

import commom.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;

public class MovieTests extends BaseTest {

    @BeforeMethod
    public void setup() {
        login
                .open()
                .with("wendreo@dev.com.br", "pwd123");

        side.loggedUser().shouldHave(text("Wendreo"));
    }

    @Test
    public void shouldRegisterANewMovie() {
        String title = "Jumanji - Next Leve";
        String status = "Pré-Venda";

        movie.add().create(title, status);
    }
}
