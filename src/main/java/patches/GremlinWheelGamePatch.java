package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.events.shrines.GremlinWheelGame;
import com.megacrit.cardcrawl.helpers.Hitbox;
import com.megacrit.cardcrawl.helpers.input.InputHelper;

import java.lang.reflect.Field;


@SpirePatch(
        clz= GremlinWheelGame.class,
        method="update",
        paramtypes = {}
)
public class GremlinWheelGamePatch {
    public static void Postfix (GremlinWheelGame game) {

        System.out.println("GremlinWheelGame update ");

        Class<?> c = game.getClass();

        Hitbox button = new Hitbox(450.0F * Settings.scale, 300.0F * Settings.scale);
        boolean pressed = true;

        try {
            Field f = c.getDeclaredField("buttonHb");
            f.setAccessible(true);
            Field f1 = c.getDeclaredField("buttonPressed");
            f1.setAccessible(true);
            button = (Hitbox) f.get(game);
            pressed = (boolean) f1.get(game);
            f1.set(game, true);
        }
        catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        button.clickStarted = true;
        InputHelper.justReleasedClickLeft = true;
        button.hovered = true;
        button.clicked = true;

        pressed = true;
    }
}
