package UI.MailRu.PageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
// Ready Main
    private final SelenideElement dollar = $x("//a[contains(@href,\"USD\")]//div[contains(@class,\"rate__currency\")]");
    private final SelenideElement hiTechTab = $("[data-testid=\"news-tabs-tab-item-hitech\"]");

    private final ElementsCollection newsHeadlines = $$("[data-testid=\"general-news-item-rb\"], [data-testid=\"extra-news-item-rb\"]");

    public void getDollarRate(){
        System.out.println("Курс доллара: " + dollar.getText() + " рублей \n\n");
    }

    public void clickHiTechTab(){
        hiTechTab.click();
    }

    public void getHiTechNewsHeadLines(){
        String oldFirstHeadLine = newsHeadlines.first().getText();
        clickHiTechTab();
        newsHeadlines.get(0).shouldNotHave(text(oldFirstHeadLine), Duration.ofSeconds(10));
        System.out.println("Заголовки новостей по Hi-Tech:");
        for(SelenideElement el : newsHeadlines)
            System.out.println("   - " + el.getText());
    }
}
