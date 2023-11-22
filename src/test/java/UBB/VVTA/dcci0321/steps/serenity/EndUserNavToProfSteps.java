package UBB.VVTA.dcci0321.steps.serenity;

import net.thucydides.core.annotations.Step;
import UBB.VVTA.dcci0321.pages.NavPage;
import static org.junit.Assert.assertEquals;

public class EndUserNavToProfSteps {

    NavPage navPage;

    @Step
    public void opens_profile_dropdown() {
        navPage.openProfileDropdown();
    }
    @Step
    public void goes_to_profile() {
        navPage.selectProfile();
    }

    @Step
    public void should_be_on_profile_page(String expectedUrl) {
        String currentUrl = navPage.getCurrentUrl();
        assertEquals("The current URL is not as expected", expectedUrl, currentUrl);
    }

    @Step
    public void should_see_profile_name(String expectedName) {
        String actualName = navPage.getProfileName();
        assertEquals("The profile name does not match the expected name.", expectedName, actualName);
    }
}
