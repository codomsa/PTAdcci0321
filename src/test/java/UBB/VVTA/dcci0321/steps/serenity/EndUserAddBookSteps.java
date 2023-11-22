package UBB.VVTA.dcci0321.steps.serenity;

import UBB.VVTA.dcci0321.pages.AddPage;
import net.thucydides.core.annotations.Step;
import static org.junit.Assert.assertTrue;

public class EndUserAddBookSteps {

    AddPage addPage;

    @Step
    public void search_for_book_title(String bookTitle) {

        addPage.searchFor(bookTitle);
    }

    @Step
    public void select_first_result() {

        addPage.selectFirstResult();
    }

    @Step
    public void add_to_want_to_read() {

        addPage.clickWantToReadAndWait();
    }
    @Step
    public void should_see_want_to_read_selected() {
        String buttonClasses = addPage.getWantToReadButtonSelectedClasses();
        assertTrue("The book is not shelved as 'Want to Read'", buttonClasses.contains("Button--secondary"));
    }
}


