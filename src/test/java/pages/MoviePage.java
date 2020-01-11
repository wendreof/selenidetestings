package pages;

import static com.codeborne.selenide.Selenide.$;

public class MoviePage {

    public MoviePage add(){
        $(".movie-add").click();
        return this;
    }

    public MoviePage create(String title){
        $("input[name=title]").setValue(title);
        return this;
    }
}
