package UI.MailRu.PageObjects;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.*;
public class HiTech {
// Ready HiTech
    @Getter
    private final SelenideElement hiTechLogo = $(".pm-logo__link__pic[src*=\"hi-tech_name_web_vk.svg\"]");
}
