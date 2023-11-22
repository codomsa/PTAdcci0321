package UBB.VVTA.dcci0321.steps.serenity;

import UBB.VVTA.dcci0321.pages.*;
import net.thucydides.core.annotations.Step;
import static org.junit.Assert.assertTrue;


public class EndUserLoginSteps {

    LoginPage loginPage;

    @Step
    public void is_on_the_login_page() {

        loginPage.open();
    }
    @Step
    public void selects_sign_in_with_email() {

        loginPage.clickSignInWithEmail();
    }


    @Step
    public void enters_email(String email) {

        loginPage.enterEmail(email);
    }

    @Step
    public void enters_password(String password) {

        loginPage.enterPassword(password);
    }

    @Step
    public void initiates_sign_in() {

        loginPage.clickSignIn();
    }
    @Step
    public void should_be_logged_in() {
        assertTrue("User is not logged in as the profile icon is not displayed.", loginPage.isUserLoggedIn());
    }

    @Step
    public void should_not_be_logged_in() {
        assertTrue("User is logged in as the error message is not displayed.", loginPage.isUserSeeingErrorMessage());
    }
}

