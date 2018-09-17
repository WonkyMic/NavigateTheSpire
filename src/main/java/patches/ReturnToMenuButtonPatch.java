package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.screens.mainMenu.EarlyAccessPopup;
import com.megacrit.cardcrawl.ui.buttons.ReturnToMenuButton;

//After death will automatically return to menu and then other patches will start new run.
@SpirePatch(
        clz= ReturnToMenuButton.class,
        method="appear",
        paramtypez = {float.class, float.class, String.class}
)
public class ReturnToMenuButtonPatch {
    public static void Postfix (ReturnToMenuButton button, float x, float y, String label) {
        button.hb.hovered = true;
        button.hb.clicked = true;
        //POST death message to ML
    }
}
