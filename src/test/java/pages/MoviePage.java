package pages;

import com.codeborne.selenide.SelenideElement;
import models.MovieModel;
import org.openqa.selenium.Keys;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MoviePage {

    public MoviePage add(){
        $(".movie-add").click();
        return this;
    }

    public MoviePage create(MovieModel movieData ){
        $("input[name=title]").setValue(movieData.getTitle());
        this.selectStatus(movieData.getStatus());
        $("input[name=year]").setValue(movieData.getYear());
        $("input[name=release_date]").setValue(movieData.getReleaseDate());
        this.inputCast(movieData.getCast());
        $("textarea[name=overview]").setValue(movieData.getPlot());
        this.upload(movieData.getCover());

        return this;
    }

    private void upload(String stringCover){
        //String jsScript = "document.getElementById('upcover').classList.remove('el-upload__input);";
        //executeJavaScript(jsScript);

        $("#upcover").uploadFile(new File(stringCover));
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