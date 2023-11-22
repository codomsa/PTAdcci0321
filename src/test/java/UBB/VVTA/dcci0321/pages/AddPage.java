package UBB.VVTA.dcci0321.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddPage extends PageObject{
    private By searchInput = By.cssSelector("input[class='searchBox__input searchBox__input--navbar'][name='q']");
    private By searchResultsContainer = By.cssSelector(".gr-bookSearchResults--navbar");
    private By firstResultLink = By.cssSelector(".gr-bookSearchResults__item a.gr-mediaFlexbox");
    private By wantToReadButton = By.cssSelector("button.Button--wtr");
    private By wantToReadButtonSelected = By.cssSelector("button.Button--secondary");


    public void searchFor(String query) {
        $(searchInput).type(query);
        waitFor(ExpectedConditions.visibilityOfElementLocated(searchResultsContainer));
    }

    public void selectFirstResult() {
        WebElement firstResult = $(firstResultLink).waitUntilVisible();
        firstResult.click();
    }
    public void clickWantToReadAndWait() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement wantToReadBtn = wait.until(ExpectedConditions.elementToBeClickable(wantToReadButton));
        wantToReadBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(wantToReadButtonSelected));
    }

    public String getWantToReadButtonSelectedClasses() {
        return $(wantToReadButtonSelected).getAttribute("class");
    }
}
