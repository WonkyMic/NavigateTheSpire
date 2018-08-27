package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.ui.buttons.ProceedButton;

import java.lang.reflect.Field;


@SpirePatch(
        clz= ProceedButton.class,
        method="show"
)
public class ProceedButtonPatch {
    public static void Postfix (ProceedButton button) {
        //TODO: check for room complete?
        Class<?> c = button.getClass();
        try {
            Field f = c.getDeclaredField("label");
            f.setAccessible(true);
            String s = (String) f.get(button);
            System.out.println("label on proceed button: " + s);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
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
