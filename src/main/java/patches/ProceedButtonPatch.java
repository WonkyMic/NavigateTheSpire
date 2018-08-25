package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.Hitbox;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.screens.select.BossRelicSelectScreen;
import com.megacrit.cardcrawl.ui.buttons.ProceedButton;

import java.lang.reflect.Field;
import java.util.ArrayList;


@SpirePatch(
        clz= ProceedButton.class,
        method="show"
)
public class ProceedButtonPatch {
    public static void Postfix (ProceedButton button) {
        //TODO: check for room complete?
        /*
        if(AbstractDungeon.getCurrRoom().phase == com.megacrit.cardcrawl.rooms.AbstractRoom.RoomPhase.COMPLETE) {
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
        */
    }
}
