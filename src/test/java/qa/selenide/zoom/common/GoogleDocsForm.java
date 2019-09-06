package qa.selenide.zoom.common;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;

import javax.annotation.Nonnull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.codeborne.selenide.conditions.Visible.*;
import static qa.selenide.zoom.description.Constants.Elements.*;

public class GoogleDocsForm {

    private Browser browser;

    private List<String> movies = new ArrayList<>(8);

    {
        movies.add("High Rollers");
        movies.add("Apocalypse Now");
        movies.add("Fullmetal Alchemist: Brotherhood");
        movies.add("The Grand Budapest Hotel");
        movies.add("Pulp Fiction");
        movies.add("Trigun");
        movies.add("Snatch");
        movies.add("Knockin' on Heaven's Door");
    }

    public GoogleDocsForm(@Nonnull Browser browser) {
        this.browser = browser;
    }

    private Set<String> getRandomMovies() {
        Random random = new Random();
        Set<String> result = new HashSet<>();
        while (result.size() < 3) {
            result.add(movies.get(random.nextInt(movies.size())));
        }
        return result;
    }

    private static int getCurrentStep() {
        return STEP_BANNER.is(not(exist))
                ? 1 : STEP_BANNER.lastChild().has(text("More awesome questions"))
                ? 2 : STEP_BANNER.lastChild().has(text("This is the end"))
                ? 3 : 1;
    }

    private void checkStep(int step, int action) {
        if (getCurrentStep() != step) {
            Assert.fail("Test failed on action " + action + "!");
        }
    }

    public void doFirstAction() {
        checkStep(1, 1);

        for (SelenideElement checkboxItem : FIRST_STEP_CHECKBOX) {
            if (checkboxItem.has(exactText("Check this"))) {
                checkboxItem.shouldHave(exactText("Check this")).click();
            }
        }

        LocalDate plus5Days = LocalDate.now().plusDays(5);
        String formattedDate = plus5Days.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if (browser == Browser.CHROME) {
            FIRST_STEP_SET_DATE.setValue(formattedDate);
        } else {
            FIRST_STEP_FIREFOX_SET_DAY.setValue(Integer.toString(plus5Days.getDayOfMonth()));
            FIRST_STEP_FIREFOX_SET_MONTH.setValue(Integer.toString(plus5Days.getMonthValue()));
            FIRST_STEP_FIREFOX_SET_YEAR.setValue(Integer.toString(plus5Days.getYear()));
        }
    }

    public void doSecondAction() {
        checkStep(1, 2);

        BACK_BUTTON.click();
        FIRST_STEP_CHECK_NECESSITY_FIELD.shouldNotBe(hidden);
    }

    public void doThirdAction() {
        checkStep(1, 3);

        String formattedDate = LocalDate.now().getMonth().name();
        FIRST_STEP_CURRENT_MONTH.setValue(formattedDate);
    }

    public void doFourthAction() {
        checkStep(1, 4);

        BACK_BUTTON.click();

        checkStep(2, 4);
        SECOND_STEP_MOVIES.setValue(String.join("\n", getRandomMovies()));
        RADIO_ARRAY.findBy(text("Yellow")).click();
    }

    public void doFifthAction() {
        checkStep(2, 5);

        BACK_BUTTON.click();
    }

    public void doSixthAction() {
        checkStep(1, 6);

        String reversed = new StringBuilder(FIRST_STEP_CURRENT_MONTH.getValue()).reverse().toString();
        FIRST_STEP_CURRENT_MONTH.setValue(reversed);
    }

    public void doSeventhAction() {
        checkStep(1, 7);

        BACK_BUTTON.click();
    }

    public void doEighthAction() {
        checkStep(2, 8);

        SECOND_STEP_MOVIES.shouldBe(not(empty));
        SECOND_STEP_RADIO_CHECK.shouldHave(value("Yellow"));
    }

    public void doNinthAction() {
        checkStep(2, 9);

        NEXT_BUTTON.click();
    }

    public void doTenthAction() {
        checkStep(3, 10);

        RADIO_ARRAY.findBy(text("Yes")).click();
        NEXT_BUTTON.click();
    }
}