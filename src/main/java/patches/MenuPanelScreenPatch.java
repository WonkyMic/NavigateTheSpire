package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.screens.mainMenu.MainMenuScreen;
import com.megacrit.cardcrawl.screens.mainMenu.MenuPanelScreen;


@SpirePatch(
        clz= MenuPanelScreen.class,
        method="initializePanels",
        paramtypez = {}
)
public class MenuPanelScreenPatch {
    public static void Postfix (MenuPanelScreen screen) {
        screen.panels.get(0).hb.hovered = true; //0 for standard
        screen.panels.get(0).hb.clicked = true;

    }
}
