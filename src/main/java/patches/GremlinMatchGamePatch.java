package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.events.shrines.GremlinMatchGame;
import com.megacrit.cardcrawl.events.shrines.GremlinWheelGame;
import com.megacrit.cardcrawl.helpers.Hitbox;
import com.megacrit.cardcrawl.helpers.input.InputHelper;

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
                System.out.println("gremlin match cards: " + (AbstractCard) cards.group.get(i));
            }
            //this doesn't quite work yet. I think I need another match game patch in updateMatchGameLogic()
            cards.group.get(0).hb.hovered = true;
            cards.group.get(1).hb.hovered = true;
            cards.group.get(0).hb.clicked = true;
            cards.group.get(1).hb.clicked = true;
        }
        catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }


    }
}
