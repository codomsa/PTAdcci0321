package UBB.VVTA.dcci0321.steps.serenity;

import UBB.VVTA.dcci0321.pages.SearchPage;
import net.thucydides.core.annotations.Step;
import static org.junit.Assert.assertEquals;

public class EndUserSearchBookSteps {

    SearchPage searchPage;

    @Step
    public void search_for_book(String bookTitle) {
        searchPage.searchFor(bookTitle);
    }

    @Step
    public void select_first_result() {
        searchPage.selectFirstResult();
    }
    @Step
    public void should_see_correct_book_title(String expectedTitle) {
        String actualTitle = searchPage.getBookTitle();
        assertEquals("The book title does not match the expected title.", expectedTitle, actualTitle);
    }
}

