package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.shop.ShopScreen;
import com.megacrit.cardcrawl.shop.StorePotion;
import com.megacrit.cardcrawl.shop.StoreRelic;
import jsonUtil.StateDataDump;

import java.lang.reflect.Field;
import java.util.ArrayList;


@SpirePatch(
        clz= ShopScreen.class,
        method="open",
        paramtypes = {}
)
public class ShopScreenPatch {
    static boolean openPurge = true;
    public static void Postfix (ShopScreen screen) {

        //TODO: learn how to handle courier relic. updateRelics() patch????
        Class<?> c = screen.getClass();

        ArrayList<StoreRelic> relics = new ArrayList<StoreRelic>();
        ArrayList<StorePotion> potions = new ArrayList<StorePotion>();
        ArrayList<AbstractCard> coloredCards = new ArrayList<AbstractCard>();
        ArrayList<AbstractCard> colorlessCards = new ArrayList<AbstractCard>();
        boolean purgeHovered;
        try {
            Field f = c.getDeclaredField("relics");
            Field f1 = c.getDeclaredField("potions");
            Field f2 = c.getDeclaredField("coloredCards");
            Field f3 = c.getDeclaredField("colorlessCards");
            f.setAccessible(true);
            f1.setAccessible(true);
            f2.setAccessible(true);
            f3.setAccessible(true);
            relics = (ArrayList<StoreRelic>) f.get(screen);
            potions = (ArrayList<StorePotion>) f1.get(screen);
            coloredCards = (ArrayList<AbstractCard>) f2.get(screen);
            colorlessCards = (ArrayList<AbstractCard>) f3.get(screen);
        }
        catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        for(StoreRelic relic : relics) {
            System.out.println("Store relic: " + relic.relic.name + " costs " + relic.price);
            //add to list of relics seen.
            StateDataDump.relicsSeen.add(relic.relic.name);
        }
        for(StorePotion potion : potions) {
            System.out.println("Store potion: " + potion.potion.name + " costs " + potion.price);
        }
        for(AbstractCard coloredCard : coloredCards) {
            System.out.println("Store coloredCard: " + coloredCard.name + " costs " + coloredCard.price);
        }
        for(AbstractCard colorlessCard : colorlessCards) {
            System.out.println("Store colorlessCard: " + colorlessCard.name + " costs " + colorlessCard.price);
        }

        System.out.println("purge available: " + screen.purgeAvailable + " costs " + screen.actualPurgeCost);

        /* this is how we purchase things
        relics.get(0).relic.hb.hovered = true;
        relics.get(0).relic.hb.clicked = true;
        System.out.println("attempted to purchase relic: " + relics.get(0).relic.name);

        potions.get(0).potion.hb.hovered = true;
        potions.get(0).potion.hb.clicked = true;
        System.out.println("attempted to purchase relic: " + potions.get(0).potion.name);

        coloredCards.get(0).hb.hovered = true;
        coloredCards.get(0).hb.clicked = true;
        System.out.println("attempted to purchase relic: " + coloredCards.get(0).name);

        colorlessCards.get(0).hb.hovered = true;
        colorlessCards.get(0).hb.clicked = true;
        System.out.println("attempted to purchase relic: " + colorlessCards.get(0).name);
        */


        //handle opening card removal
        if (screen.purgeAvailable && AbstractDungeon.screen == AbstractDungeon.CurrentScreen.SHOP && openPurge)
        {
            if (AbstractDungeon.player.gold >= screen.actualPurgeCost) {
                openPurge = false;
                AbstractDungeon.previousScreen = AbstractDungeon.CurrentScreen.SHOP;
                AbstractDungeon.gridSelectScreen.open(CardGroup.getGroupWithoutBottledCards(AbstractDungeon.player.masterDeck.getPurgeableCards()), 1, ShopScreen.NAMES[13], false, false, true, true);
            }
        }
    }
}
