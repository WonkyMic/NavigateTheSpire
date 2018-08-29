package botActions;

import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.Hitbox;

import java.lang.reflect.Field;

public class ProceedButtonActions {

    public static void clickProceedButton()
    {
        com.megacrit.cardcrawl.ui.buttons.ProceedButton button = AbstractDungeon.overlayMenu.proceedButton;
        Class<?> c = button.getClass();
        try {
            Field f = c.getDeclaredField("hb");
            f.setAccessible(true);
            Hitbox h = (Hitbox) f.get(button);
            h.hovered = true;
            h.clicked = true;
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
