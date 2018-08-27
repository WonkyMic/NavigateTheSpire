package patches;

import com.badlogic.gdx.Gdx;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.shrines.GremlinMatchGame;

import java.lang.reflect.Field;


@SpirePatch(
        clz= GremlinMatchGame.class,
        method="updateMatchGameLogic",
        paramtypes = {}
)
public class GremlinMatchGamePatch2 {


    public static void Replace (GremlinMatchGame game) {
        try {
            //reflection garbage start
            Class<?> cls = game.getClass();
            Field[] fields = cls.getDeclaredFields();

            Class<?> cls1 = Class.forName("com.megacrit.cardcrawl.events.shrines.GremlinMatchGame$CUR_SCREEN");
            Object[] enumElements = cls1.getEnumConstants();


            for (Field f : fields) {
                f.setAccessible(true);
            }

            Field f = cls.getDeclaredField("waitTimer");
            Field f1 = cls.getDeclaredField("hoveredCard");
            Field f2 = cls.getDeclaredField("cards");
            Field f3 = cls.getDeclaredField("cardFlipped");
            Field f4 = cls.getDeclaredField("chosenCard");
            Field f5 = cls.getDeclaredField("gameDone");
            Field f6 = cls.getDeclaredField("attemptCount");
            Field f7 = cls.getDeclaredField("cardsMatched");
            Field f8 = cls.getDeclaredField("screen");

            float waitTimer = (float)f.get(game);
            AbstractCard hoveredCard = (AbstractCard)f1.get(game);
            CardGroup cards = (CardGroup)f2.get(game);
            boolean cardFlipped = (boolean)f3.get(game);
            AbstractCard chosenCard = (AbstractCard)f4.get(game);
            boolean gameDone = (boolean)f5.get(game);
            int attemptCount = (int)f6.get(game);
            int cardsMatched = (int)f7.get(game);
            Object screen = (Object)f8.get(game);
            //reflection garbage end

            if (waitTimer == 0.0F) {
                //get first card index to check here
                hoveredCard = cards.group.get(0);
                if(!hoveredCard.isFlipped){
                    //get second card index to check here
                    hoveredCard = cards.group.get(1);
                }
                        hoveredCard.drawScale = 0.7F;
                        hoveredCard.targetDrawScale = 0.7F;
                        if ( (hoveredCard.isFlipped)) {
                            hoveredCard.isFlipped = false;
                            if (!cardFlipped) {
                                cardFlipped = true;
                                chosenCard = hoveredCard;
                            } else {
                                cardFlipped = false;
                                if (chosenCard.cardID.equals(hoveredCard.cardID)) {
                                    waitTimer = 1.0F;
                                    chosenCard.targetDrawScale = 0.7F;
                                    chosenCard.target_x = (Settings.WIDTH / 2.0F);
                                    chosenCard.target_y = (Settings.HEIGHT / 2.0F);
                                    hoveredCard.targetDrawScale = 0.7F;
                                    hoveredCard.target_x = (Settings.WIDTH / 2.0F);
                                    hoveredCard.target_y = (Settings.HEIGHT / 2.0F);
                                } else {
                                    waitTimer = 1.25F;
                                    chosenCard.targetDrawScale = 1.0F;
                                    hoveredCard.targetDrawScale = 1.0F;
                                }
                    }
                    for (AbstractCard c : cards.group)
                    {
                        if (c != chosenCard) {
                            c.targetDrawScale = 0.5F;
                        }
                    }
                }
            } else {
                waitTimer -= Gdx.graphics.getDeltaTime();
                if ((waitTimer < 0.0F) && (!gameDone)) {
                    waitTimer = 0.0F;
                    if (chosenCard.cardID.equals(hoveredCard.cardID)) {
                        cardsMatched += 1;
                        cards.group.remove(chosenCard);
                        cards.group.remove(hoveredCard);
                        AbstractDungeon.effectList.add(new com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndObtainEffect(chosenCard
                                .makeCopy(), Settings.WIDTH / 2.0F, Settings.HEIGHT / 2.0F));
                        chosenCard = null;
                        hoveredCard = null;
                    } else {
                        chosenCard.isFlipped = true;
                        hoveredCard.isFlipped = true;
                        chosenCard.targetDrawScale = 0.5F;
                        hoveredCard.targetDrawScale = 0.5F;
                        chosenCard = null;
                        hoveredCard = null;
                    }
                    attemptCount -= 1;
                    if (attemptCount == 0) {
                        gameDone = true;
                        waitTimer = 1.0F;
                    }
                } else if (gameDone) {
                    screen = enumElements[4];
                }
            }
            f.set(game, waitTimer);
            f1.set(game, hoveredCard);
            f2.set(game, cards);
            f3.set(game, cardFlipped);
            f4.set(game, chosenCard);
            f5.set(game, gameDone);
            f6.set(game, attemptCount);
            f7.set(game, cardsMatched);
            f8.set(game, screen);
        }
        catch (NoSuchFieldException | IllegalAccessException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

}
