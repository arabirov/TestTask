package qa.selenide.zoom;

import qa.selenide.zoom.common.GoogleDocsForm;

public abstract class AbstractNavigationTest {

    void doActions(GoogleDocsForm form) {
        form.doFirstAction();
        form.doSecondAction();
        form.doThirdAction();
        form.doFourthAction();
        form.doFifthAction();
        form.doSixthAction();
        form.doSeventhAction();
        form.doEighthAction();
        form.doNinthAction();
        form.doTenthAction();
    }
}
