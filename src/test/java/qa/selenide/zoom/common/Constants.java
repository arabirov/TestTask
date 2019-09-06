package qa.selenide.zoom.description;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Constants {
    public static class Env {
        public static final String URL = "https://docs.google.com/forms/d/e/1FAIpQLScNx9xK2LM-G3Z3fJXOQapiSK1IAoNXc_67MyS-soTfhDXotA/viewform";
    }

    public static class Elements {

        public static final SelenideElement FIRST_STEP_CHECK_NECESSITY_FIELD = $("#i\\.err\\.1806505028");
        public static final SelenideElement FIRST_STEP_CURRENT_MONTH = $("div.quantumWizTextinputPaperinputEl:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)");
        public static final SelenideElement FIRST_STEP_FIREFOX_SET_DAY = $("div.freebirdFormviewerViewItemsDateDateSelectionInput:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)");
        public static final SelenideElement FIRST_STEP_FIREFOX_SET_MONTH = $("div.freebirdFormviewerViewItemsDateDateSelectionInput:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)");
        public static final SelenideElement FIRST_STEP_FIREFOX_SET_YEAR = $("div.freebirdFormviewerViewItemsDateDateSelectionInput:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)");
        public static final SelenideElement FIRST_STEP_SET_DATE = $("div.quantumWizTextinputPaperinputInputArea > input");
        public static final ElementsCollection FIRST_STEP_CHECKBOX = $$("div.freebirdFormviewerViewNumberedItemContainer:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div");

        public static final SelenideElement SECOND_STEP_MOVIES = $("textarea.quantumWizTextinputPapertextareaInput");
        public static final SelenideElement SECOND_STEP_RADIO_CHECK = $("div.freebirdFormviewerViewNumberedItemContainer:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)");

        public static final SelenideElement BACK_BUTTON = $("div.quantumWizButtonPaperbuttonEl:nth-child(1) > span:nth-child(3) > span"); //BACK_BUTTON is also works as NEXT_BUTTON on first step
        public static final SelenideElement NEXT_BUTTON = $("div.quantumWizButtonPaperbuttonEl:nth-child(2) > span:nth-child(3) > span");
        public static final SelenideElement STEP_BANNER = $("div.freebirdFormviewerViewItemsPagebreakBanner");
        public static final ElementsCollection RADIO_ARRAY = $$("span.exportContent > div:nth-child(1) > div");
    }
}