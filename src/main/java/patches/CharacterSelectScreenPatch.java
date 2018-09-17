package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.screens.charSelect.CharacterSelectScreen;
import com.megacrit.cardcrawl.screens.mainMenu.MainMenuScreen;


@SpirePatch(
        clz= CharacterSelectScreen.class,
        method="open",
        paramtypez = {boolean.class}
)
public class CharacterSelectScreenPatch {
    public static void Postfix (CharacterSelectScreen screen, boolean isEndless) {
        int characterToSelect = 0; //0 for Ironclad, 1 for Silent, 2 for Defect
        screen.options.get(characterToSelect).hb.hovered = true;
        screen.options.get(characterToSelect).hb.clicked = true;

        screen.confirmButton.hb.hovered = true;
        screen.confirmButton.hb.clicked = true;
    }
}
