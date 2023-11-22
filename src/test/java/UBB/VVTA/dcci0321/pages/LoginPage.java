package UBB.VVTA.dcci0321.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://www.goodreads.com/user/sign_in")
public class LoginPage extends PageObject {

    private By emailInput = By.id("ap_email");
    private By passwordInput = By.id("ap_password");
    private By signInButton = By.id("a-autoid-0");

    private By profileIcon = By.cssSelector("a[href*='/user/show'] img.circularIcon");

    private By signInWithEmailButton = By.xpath("//button[contains(text(), 'Sign in with email')]");

    private By errorMessage = By.id("auth-error-message-box");

    public void clickSignInWithEmail() {
        $(signInWithEmailButton).click();
    }

    public void enterEmail(String email) {
        $(emailInput).type(email);
    }

    public void enterPassword(String password) {
        $(passwordInput).type(password);
    }

    public void clickSignIn() {
        $(signInButton).click();
    }

    public boolean isUserLoggedIn() {
        return $(profileIcon).isPresent();
    }

    public boolean isUserSeeingErrorMessage() {
        return $(errorMessage).isPresent();
    }
}
