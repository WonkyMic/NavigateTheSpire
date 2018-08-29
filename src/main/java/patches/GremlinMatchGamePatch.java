package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.events.shrines.GremlinMatchGame;

import java.lang.reflect.Field;


@SpirePatch(
        clz= GremlinMatchGame.class,
        method="placeCards",
        paramtypes = {}
)
public class GremlinMatchGamePatch {
    public static void Postfix (GremlinMatchGame game) {

        System.out.println("GremlinMatchGame placeCards");
        Class<?> c = game.getClass();

        try {
            CardGroup cards;
            Field f = c.getDeclaredField("cards");
            f.setAccessible(true);
            cards = (CardGroup)f.get(game);
            for(int i = 0; i < cards.size(); ++i) {
                System.out.println("gremlin match cards: " + cards.group.get(i).name);
            }
        }
        catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }


    }
}
