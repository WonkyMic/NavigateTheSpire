package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.screens.select.GridCardSelectScreen;

import java.lang.reflect.Field;

@SpirePatch(
        clz=GridCardSelectScreen.class,
        method="update",
        paramtypez={        }
)
public class GridCardSelectScreenPatch {
    @SpireInsertPatch(
            rloc=45
    )
    public static void Insert (GridCardSelectScreen screen)
    {
        //send canCancel to Python instance?
            Class<?> c = screen.getClass();
        try {
            Field f1 = c.getDeclaredField("numCards");
            f1.setAccessible(true);
            int numCards = (int)f1.get(screen);
            Field f2 = c.getDeclaredField("targetGroup");
            f2.setAccessible(true);
            Field f3 = c.getDeclaredField("cardSelectAmount");
            f3.setAccessible(true);
            CardGroup group = (CardGroup)f2.get(screen);
            if ((int)f3.get(screen) < numCards) {
                    Field f = c.getDeclaredField("hoveredCard");
                    f.setAccessible(true);
                    group.group.get((int)f3.get(screen)).hb.hovered = true;
                    group.group.get((int)f3.get(screen)).hb.clicked = true;
                    f.set(screen, group.group.get((int)f3.get(screen)));
                    System.out.println("card name to remove: " + group.group.get((int)f3.get(screen)).name);
                }
            }
        catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        /* TODO: pass these to RL
        screen.forPurge;
        screen.forUpgrade;
        screen.forTransform;
        */
    }
}
