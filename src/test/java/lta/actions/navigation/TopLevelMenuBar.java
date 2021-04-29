package lta.actions.navigation;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class TopLevelMenuBar extends PageObject {
    private static String TOP_LEVEL_MENU_ENTRY = "//a[normalize-space()='%s']";
    private static String TOP_LEVEL_MENU_TOGGLE = "//div[contains(.,'%s')][contains(@class,'nav-link')]";
    public static By NAVBAR_TOGGLE = By.cssSelector(".navbar-toggler-icon");

    public static By topLevelMenuItemCalled(String menuItemName) {
        return By.xpath(String.format(TOP_LEVEL_MENU_ENTRY, menuItemName));
    }

    public static By topLevelMenuToggleFor(String menuItemName) {
        return By.xpath(String.format(TOP_LEVEL_MENU_TOGGLE, menuItemName));
    }

    public boolean isSquashed() {
        return $(NAVBAR_TOGGLE).isCurrentlyVisible();
    }

    public void expandMenu() {
        $(NAVBAR_TOGGLE).click();
    }
}
