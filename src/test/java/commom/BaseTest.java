package commom;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.MoviePage;
import pages.components.SideBar;

public class BaseTest {
    protected static MoviePage movie;
    protected static SideBar side;
    protected static LoginPage login;

    @BeforeMethod
    public void start() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://ninjaplus-web:5000";

        login = new LoginPage();
        side = new SideBar();
        movie = new MoviePage();
    }
}
