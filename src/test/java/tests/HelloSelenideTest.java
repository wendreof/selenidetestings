package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.isChrome;
import static com.codeborne.selenide.Selenide.open;

public class HelloSelenideTest {

    @Test
    public void onAir() {
        isChrome();
        open("http://ninjaplus-web:5000/login");
        assertEquals(title(), "Ninja+");
    }
}
