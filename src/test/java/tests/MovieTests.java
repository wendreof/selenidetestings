package tests;

import commom.BaseTest;
import libs.Database;
import models.MovieModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.Arrays;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static models.MovieModelKt.coverPath;

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

        MovieModel movieData = new MovieModel(
                "Jumanji - Next Leve",
                "Pré-Venda",
                "2020",
                "16/01/2020",
                Arrays.asList("The Rock", "Jack Black", "Kevin Hart", "Karen Gillan", "Danny DeVito"),
                "Tentatado a revisitar o mundo de Jumanji, Spencer decide consertar o bug no jogo " +
                        "do game que permite que sejam transportados ao local",
                coverPath() + "jumanji2.jpg"

        );

        Database db = new Database();
        try {
            db.deleteMovie(movieData.getTitle());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        movie
                .add()
                .create(movieData)
                .items().findBy(text(movieData.getTitle())).shouldBe(visible);
    }
}
