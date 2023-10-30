package UI.MailRu;

import UI.MailRu.PageObjects.HiTech;
import UI.MailRu.PageObjects.MainPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.Assertions.assertThat;

public class TestMailRu {

    @BeforeAll
    public static void setUp(){
        String actualChromeDriver = "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", actualChromeDriver);
        Configuration.baseUrl = "http://mail.ru";
    }

    @Test
    void testMailRu(){
        open(Configuration.baseUrl);
        MainPage mainp = new MainPage();
        mainp.getDollarRate();
        mainp.getHiTechNewsHeadLines();
        mainp.clickHiTechTab();
        switchTo().window(1);
        assertThat(url()).isEqualTo("https://hi-tech.mail.ru/");
        HiTech ht = new HiTech();
        System.out.println("\nЗначение атрибута alt: " + ht.getHiTechLogo().getAttribute("alt"));
    }
}
