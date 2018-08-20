package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.screens.select.HandCardSelectScreen;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SpirePatch(
        cls="com.megacrit.cardcrawl.screens.select.HandCardSelectScreen",
        method="open",
        paramtypes={
                "java.lang.String",
                "int",
                "boolean",
                "boolean",
                "boolean",
                "boolean",
                "boolean"
        }
)
public class HandCardSelectScreenPatch {
    public static void Postfix (HandCardSelectScreen screen, String msg, int amount, boolean anyNumber, boolean canPickZero, boolean forTransform, boolean forUpgrade, boolean upTo)
    {
        for (int i = 0; i < screen.numCardsToSelect ; i++) {
            screen.hoveredCard = AbstractDungeon.player.hand.group.get(0);

            try {
                Method m = HandCardSelectScreen.class.getDeclaredMethod("selectHoveredCard");
                m.setAccessible(true);
                m.invoke(screen);
            }
            catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e)
            {
                e.printStackTrace();
            }
        }
        screen.button.hb.clicked = true;
    }
}
