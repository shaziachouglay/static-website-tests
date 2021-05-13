package lta.actions.navigation;

import net.serenitybdd.core.pages.PageObject;

public class TitleBanner extends PageObject {

    public String title() {
        return $(".title-banner h3").getText();
    }


    public String dropDownList() {
        return $("//li[@class='dropdown-item']/a").getText();
    }
}
