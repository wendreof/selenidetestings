package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MoviePage {

    public MoviePage add(){
        $(".movie-add").click();
        return this;
    }

    public MoviePage create(String title, String status, String year, String realeaseDate, List<String> cast, String plot){
        $("input[name=title]").setValue(title);
        this.selectStatus(status);
        $("input[name=year]").setValue(year);
        $("input[name=release_date]").setValue(realeaseDate);
        this.inputCast(cast);
        $("textarea[name=overview]").setValue(plot);

        return this;
    }

    private void inputCast(List<String> cast){

        SelenideElement element = $(".cast");

        for(String actor : cast){
            element.setValue(actor);
            element.sendKeys(Keys.TAB);
        }
    }

    private void selectStatus(String status){
        $("input[placeholder=Status]").click();
        $$("ul li span").findBy(text(status)).click();
    }
}