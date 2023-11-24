package UBB.VVTA.dcci0321.features.search;

import UBB.VVTA.dcci0321.steps.serenity.EndUserLoginSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.annotations.Qualifier;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SerenityParameterizedRunner.class)
public class ParameterizedStory {

    private String email;
    private String password;

    @Steps
    public EndUserLoginSteps user;

    public ParameterizedStory(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @TestData
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"aaaaa", "aaa123"},
                {"invalid@example.com", "wrongpassword"}
        });
    }

    @Qualifier
    public String qualifier() {
        return email;
    }


    public void waitForCaptchaSolving() {
        try {
            Thread.sleep(10000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void should_not_be_able_to_login() {
        user.is_on_the_login_page();
        user.selects_sign_in_with_email();
        user.enters_email(email);
        user.enters_password(password);
        user.initiates_sign_in();
        waitForCaptchaSolving();
        user.should_not_be_logged_in();
    }
}
