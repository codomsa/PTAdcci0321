package UBB.VVTA.dcci0321.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import UBB.VVTA.dcci0321.steps.serenity.EndUserLoginSteps;
import UBB.VVTA.dcci0321.steps.serenity.EndUserSearchBookSteps;
import UBB.VVTA.dcci0321.steps.serenity.EndUserAddBookSteps;
import UBB.VVTA.dcci0321.steps.serenity.EndUserNavToProfSteps;


@RunWith(SerenityRunner.class)
public class Story {

    @Managed(uniqueSession = true, driver = "firefox")
    public WebDriver webdriver;

    @Steps
    public EndUserLoginSteps user;

    @Steps
    public EndUserSearchBookSteps searcher;

    @Steps
    public EndUserAddBookSteps adder;

    @Steps
    public EndUserNavToProfSteps profileNavigator;

    public void waitForCaptchaSolving() {
        try {

            Thread.sleep(10000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
    @BeforeEach
    public void initialization(){
        user.is_on_the_login_page();
        user.selects_sign_in_with_email();
        user.enters_email("domsacosmin@gmail.com");
        user.enters_password("1337haxFTW");
        user.initiates_sign_in();
        waitForCaptchaSolving();
    }
    @Test
    public void should_be_able_to_login() {
        initialization();
        user.should_be_logged_in();
    }
    @Test
    public void should_not_be_able_to_login(){
        user.is_on_the_login_page();
        user.selects_sign_in_with_email();
        user.enters_email("aaaaa");
        user.enters_password("aaa123");
        user.initiates_sign_in();
        waitForCaptchaSolving();
        user.should_not_be_logged_in();
    }

    @Test
    public void should_navigate_to_profile() {
        initialization();
        profileNavigator.opens_profile_dropdown();
        profileNavigator.goes_to_profile();
        profileNavigator.should_be_on_profile_page("https://www.goodreads.com/user/show/124986219-cosmin-domsa");
        profileNavigator.should_see_profile_name("Cosmin Domsa (edit profile)");
    }

    @Test
    public void should_be_able_to_search_for_book() {
        initialization();
        searcher.search_for_book("Understanding Power");
        searcher.select_first_result();
        searcher.should_see_correct_book_title("Understanding Power: The Indispensable Chomsky");
    }

    @Test
    public void should_be_able_to_add_book_to_want_to_read_and_verify() {
        initialization();
        adder.search_for_book_title("Understanding Power");
        adder.select_first_result();
        adder.add_to_want_to_read();
        adder.should_see_want_to_read_selected();
    }

}

