package lta.actions.navigation;

import net.serenitybdd.core.pages.PageObject;

public class TitleBanner extends PageObject {

    public static final String TITLE_HEADER = ".title-banner h3";

    public String title() {
        return $(TITLE_HEADER).getText();
    }
}
