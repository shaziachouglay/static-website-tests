package lta.stepdefinitions;

import com.google.common.base.Splitter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lta.actions.navigation.TitleBanner;
import net.thucydides.core.annotations.Steps;
import lta.actions.navigation.Navigate;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NavigationStepDefinitions {

    @Steps
    Navigate navigate;

    TitleBanner titleBanner;

    @When("Vicky is on the LTA home page")
    public void onTheHomePage() {
        navigate.toTheLTAHomePage();
    }

    @Then("he/she should be able to navigate to the following sections though the top level menu")
    public void navigateToTopLevelMenuSections(List<String> sections) {
        SoftAssertions softly = new SoftAssertions();
        sections.forEach(
                section -> {
                    navigate.toTheSection(section);
                    softly.assertThat(titleBanner.title()).isEqualTo(section);
                }
        );
        softly.assertAll();
    }

    @When("he/she opens the {} menu")
    public void sheOpensTheMenu(String sectionMenu) {
        navigate.openSection(sectionMenu);
    }

    @And("he/she should be able to navigate to each of the sections in {}")
    public void sheShouldBeAbleToNavigateToEachOfTheSectionsIn(String submenus) {
        List<String> subMenuEntries = Splitter.on(",").trimResults().splitToList(submenus);
        SoftAssertions softly = new SoftAssertions();
        subMenuEntries.forEach(
                subMenu -> {
                    // TODO: Check that the submenu is visible
                }
        );
        softly.assertAll();

    }
}
