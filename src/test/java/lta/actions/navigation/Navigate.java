package lta.actions.navigation;

import net.serenitybdd.core.steps.UIInteractionSteps;

import static lta.actions.navigation.TopLevelMenuBar.NAVBAR_TOGGLE;

public class Navigate extends UIInteractionSteps {

    TopLevelMenuBar topLevelMenuBar;

    public void toTheLTAHomePage() {
        getDriver().get("https://www.lta.gov.sg/");
    }

    public void toTheSection(String section) {
        if (topLevelMenuBar.isSquashed()){
            topLevelMenuBar.expandSection();
        }
        $(TopLevelMenuBar.topLevelMenuItemCalled(section)).click();

    }

    public void openTheSection(String sectionMenu) {
        if (topLevelMenuBar.isSquashed()){
            topLevelMenuBar.expandSection();
            $(TopLevelMenuBar.topLevelMenuToggleFor(sectionMenu)).click();
        }else {
            moveTo(TopLevelMenuBar.topLevelMenuItemCalled(sectionMenu));
        }
    }

    public void toTheSubMenuSection(String subMenu) {
        moveTo(TopLevelMenuBar.subMenuItemCalled(subMenu));
    }
}
