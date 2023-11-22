package UBB.VVTA.dcci0321.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends PageObject {

    private By searchInput = By.cssSelector("input[class='searchBox__input searchBox__input--navbar'][name='q']");
    private By searchResultsContainer = By.cssSelector(".gr-bookSearchResults--navbar");
    private By firstResultLink = By.cssSelector(".gr-bookSearchResults__item a.gr-mediaFlexbox");
    private By bookTitle = By.cssSelector("h1.Text.Text__title1");

    public void searchFor(String query) {
        $(searchInput).type(query);
        waitFor(ExpectedConditions.visibilityOfElementLocated(searchResultsContainer));
    }

    public void selectFirstResult() {
        WebElement firstResult = $(firstResultLink).waitUntilVisible();
        firstResult.click();
    }

    public String getBookTitle() {
        return $(bookTitle).waitUntilVisible().getText();
    }
}
