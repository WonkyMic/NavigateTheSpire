package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.screens.select.GridCardSelectScreen;
import com.megacrit.cardcrawl.screens.select.HandCardSelectScreen;
import com.megacrit.cardcrawl.ui.buttons.GridSelectConfirmButton;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SpirePatch(
        cls="com.megacrit.cardcrawl.screens.select.GridCardSelectScreen",
        method="open",
        paramtypes={
                "com.megacrit.cardcrawl.cards.CardGroup",
                "int",
                "java.lang.String",
                "boolean",
                "boolean",
                "boolean",
                "boolean"
        }
)
public class GridCardSelectScreenPatch {
    public static void Postfix (GridCardSelectScreen screen, CardGroup group, int numCards, String tipMsg, boolean forUpgrade, boolean forTransform, boolean canCancel, boolean forPurge)
    {
        if (canCancel)
        {
            AbstractDungeon.overlayMenu.cancelButton.hb.clicked = true;
        }
        else {
            Class<?> c = screen.getClass();
            for (int i = 0; i < numCards; i++) {

                try {
                    Field f = c.getDeclaredField("hoveredCard");
                    f.setAccessible(true);
                    f.set(screen, group.group.get(0));
                    //screen.update();
                    AbstractCard card = (AbstractCard)f.get(screen);
                    //card = group.group.get(0);
                    //group.group.get(0).hover();
                    System.out.println("card name to remove: " + card.name);
                    card.hb.clicked = true;
                    screen.update();
                    //Field f2 = c.getDeclaredField("hoveredCard.hb.clicked");
                    //f2.setAccessible(true);
                    //f2.set(screen, true);
                } catch (IllegalAccessException | NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
            try {
                Field f2 = c.getDeclaredField("confirmScreenUp");
                f2.setAccessible(true);
                boolean confirmScreenUp = (boolean) f2.get(screen);
                System.out.println("confirmScreenUp = " + confirmScreenUp);
                if(confirmScreenUp) {
                    System.out.println("ready to confirm");
                    Field f3 = c.getDeclaredField("confirmButton");
                    f3.setAccessible(true);
                    GridSelectConfirmButton button = (GridSelectConfirmButton) f3.get(screen);
                    button.hb.clicked = true;
                }
            //f3.set(screen, true);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }
}
