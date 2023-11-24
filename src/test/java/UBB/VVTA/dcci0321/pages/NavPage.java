package UBB.VVTA.dcci0321.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavPage extends PageObject {

    private By profileDropdown = By.cssSelector(".dropdown__trigger--profileMenu");
    private By profileLink = By.cssSelector("li[role='menuitem Profile'] a[href*='/user/show/124986219-cosmin-domsa']");
    private By profileName = By.cssSelector("#profileNameTopHeading");

    public void openProfileDropdown() {
        WebElementFacade settingsButton = $(profileDropdown).waitUntilClickable();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", settingsButton);
    }


    public void selectProfile() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement profileLinkElement = wait.until(ExpectedConditions.visibilityOfElementLocated(profileLink));
        wait.until(ExpectedConditions.elementToBeClickable(profileLinkElement)).click();
    }



    public String getProfileName() {
        waitFor(ExpectedConditions.visibilityOfElementLocated(profileName));
        return $(profileName).waitUntilVisible().getText().split("\n")[0]; // Splits the text and takes the first part to exclude the "(edit profile)" text
    }


    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }
}
