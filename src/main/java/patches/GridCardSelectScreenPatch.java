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
        paramtypes={        }
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
            CardGroup group = (CardGroup)f2.get(screen);
            for (int i = 0; i < numCards; i++) {
                    Field f = c.getDeclaredField("hoveredCard");
                    f.setAccessible(true);
                    AbstractCard card = (AbstractCard)f.get(screen);
                    card = group.group.get(0);
                    card.hb.hovered = true;
                    card.hb.clicked = true;
                    f.set(screen, group.group.get(0));
                    System.out.println("card name to remove: " + card.name);
                }
            }
        catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
