package lta.stepdefinitions;

import com.google.common.base.Splitter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lta.actions.navigation.Navigate;
import lta.actions.navigation.TitleBanner;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

public class NavigationStepDefinitions {

    @Steps
    Navigate navigate;

    TitleBanner titleBanner;
    @When("Vicky is on LTA home page")
    public void vickyIsOnLTAHomePage() {
        navigate.toTheLTAHomePage();
    }

    @Then("he/she should be able to navigate to the following sections through the tp level menu")
    public void sheShouldBeAbleToNavigateToTheFollowingSectionsThroughTheTpLevelMenu(List<String> sections) {
        SoftAssertions softly = new SoftAssertions();
        sections.forEach(
                section ->{
                    navigate.toTheSection(section);
                    softly.assertThat(titleBanner.title()).isEqualTo(section);
                }

        );
        softly.assertAll();
    }

    @When("he/she opens the {} menu")
    public void sheOpensTheTopLevelMenuMenu(String sectionMenu) {
        navigate.openTheSection(sectionMenu);
        
    }

    @And("he/she should be able to navigate to each of the sections in {}")
    public void sheShouldBeAbleToNavigateToEachOfTheSectionsInSubMenus(String subMenus) {
        List<String> subMenuEntries = Splitter.on(",").trimResults().splitToList(subMenus);
        SoftAssertions softly = new SoftAssertions();
        subMenuEntries.forEach(
                subMenu->{
                    navigate.toTheSubMenuSection(subMenu);
                   softly.assertThat(titleBanner.dropDownList()).isEqualTo(subMenu);
                }
        );
    }
}
