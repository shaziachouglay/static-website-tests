package lta.actions.navigation;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class TopLevelMenuBar extends PageObject {
    private static String TOP_LEVEL_MENU_ENTRY = "//a[normalize-space()='%s']";
    public static By NAVBAR_TOGGLE = By.cssSelector(".navbar-toggler-icon");
    private static String TOP_LEVEL_MENU_TOGGLE = "//div[contains(.,'%s')][contains(@class,'nav-link')]";
    private static String SUB_LEVEL_MENU = "//li[@class='dropdown-item']/a[contains(.,'%s')]";

    public static By topLevelMenuToggleFor(String menuItem) {
        return By.xpath(String.format(TOP_LEVEL_MENU_TOGGLE,menuItem));
    }

    public static By subMenuItemCalled(String subMenu) {
        return By.xpath(String.format(SUB_LEVEL_MENU,subMenu));
    }

    public boolean isSquashed() {
       return $(NAVBAR_TOGGLE).isCurrentlyVisible();
    }

    public void expandSection() {
        $(NAVBAR_TOGGLE).click();
    }
    public static By topLevelMenuItemCalled(String menuItemName){
      return By.xpath(String.format(TOP_LEVEL_MENU_ENTRY,menuItemName));
    }
}
