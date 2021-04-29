package lta.actions.navigation;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class Navigate extends UIInteractionSteps {

    TopLevelMenuBar topLevelMenuBar;

    @Step("Vicky opens the LTA home page")
    public void toTheLTAHomePage() {
        getDriver().get("https://www.lta.gov.sg/");
    }

    @Step("Vicky navigates the section {0}")
    public void toTheSection(String section) {
        if (topLevelMenuBar.isSquashed()) {
            topLevelMenuBar.expandMenu();
        }
        $(TopLevelMenuBar.topLevelMenuItemCalled(section)).click();
    }

    @Step("Vicky opening the section {0}")
    public void openSection(String section) {
        if (topLevelMenuBar.isSquashed()) {
            topLevelMenuBar.expandMenu();
            $(TopLevelMenuBar.topLevelMenuToggleFor(section)).click();
        } else {
            moveTo(TopLevelMenuBar.topLevelMenuItemCalled(section));
        }
    }
}
