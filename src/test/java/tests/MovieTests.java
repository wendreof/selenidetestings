package tests;

import commom.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

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
        String year = "2020";
        String releaseDate = "16/01/2020";
        List<String> cast = Arrays.asList("The Rock", "Jack Black", "Kevin Hart", "Karen Gillan", "Danny DeVito");
        String plot = "Tentatado a revisitar o mundo de Jumanji, Spencer decide consertar " +
                " o bug no jogo do game que permite que sejam transportados ao local";

        movie.add().create(title, status, year, releaseDate, cast, plot);
    }
}