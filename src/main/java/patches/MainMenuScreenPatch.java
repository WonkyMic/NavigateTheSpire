package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.screens.mainMenu.MainMenuScreen;


@SpirePatch(
        clz= MainMenuScreen.class,
        method="setMainMenuButtons",
        paramtypez = {}
)
public class MainMenuScreenPatch {
    public static void Postfix (MainMenuScreen screen) {
        screen.buttons.get(screen.buttons.size()-1).hb.hovered = true; //click the top button (continue game or new game)
        screen.buttons.get(screen.buttons.size()-1).hb.clicked = true;
    }
}
