package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.screens.mainMenu.EarlyAccessPopup;
import com.megacrit.cardcrawl.screens.mainMenu.MainMenuScreen;


@SpirePatch(
        clz= EarlyAccessPopup.class,
        method="update",
        paramtypez = {}
)
public class EarlyAccessPopupPatch {
    public static void Postfix (EarlyAccessPopup screen) {
        CardCrawlGame.mainMenuScreen.bg.activated = true;
        screen.isUp = false;
        CardCrawlGame.mainMenuScreen.lighten();
    }
}
