package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.shrines.GremlinWheelGame;
import com.megacrit.cardcrawl.helpers.Hitbox;
import com.megacrit.cardcrawl.helpers.input.InputHelper;
import com.megacrit.cardcrawl.shop.ShopScreen;
import com.megacrit.cardcrawl.shop.StorePotion;
import com.megacrit.cardcrawl.shop.StoreRelic;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


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
