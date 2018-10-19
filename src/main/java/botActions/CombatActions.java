package botActions;

import basemod.BaseMod;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.characters.Defect;
import com.megacrit.cardcrawl.characters.Ironclad;
import com.megacrit.cardcrawl.characters.TheSilent;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.helpers.PotionHelper;
import com.megacrit.cardcrawl.helpers.RelicLibrary;
import com.megacrit.cardcrawl.map.MapEdge;
import com.megacrit.cardcrawl.map.MapRoomNode;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.rooms.MonsterRoom;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class CombatActions {
    static Random generator = new Random();
    public static boolean changeThings = true;
    public static void StartFight(String encounterName) {
            AbstractDungeon.monsterList.add(0, encounterName);
            MapRoomNode cur = AbstractDungeon.currMapNode;
            MapRoomNode node = new MapRoomNode(cur.x, cur.y);
            node.room = new MonsterRoom();
            ArrayList<MapEdge> curEdges = cur.getEdges();
            Iterator var6 = curEdges.iterator();

            while(var6.hasNext()) {
                MapEdge edge = (MapEdge)var6.next();
                node.addEdge(edge);
            }

            AbstractDungeon.nextRoom = node;
            AbstractDungeon.nextRoomTransitionStart();
    }

    public static void StartRandomFight() {

        String encounterName = BaseMod.encounterList.get(generator.nextInt(BaseMod.encounterList.size()-1));
        AbstractDungeon.monsterList.add(0, encounterName);
        MapRoomNode cur = AbstractDungeon.currMapNode;
        MapRoomNode node = new MapRoomNode(cur.x, cur.y);
        node.room = new MonsterRoom();
        ArrayList<MapEdge> curEdges = cur.getEdges();
        Iterator var6 = curEdges.iterator();

        while(var6.hasNext()) {
            MapEdge edge = (MapEdge)var6.next();
            node.addEdge(edge);
        }

        AbstractDungeon.nextRoom = node;
        AbstractDungeon.nextRoomTransitionStart();
    }


    public static void initializePlayerState(){
        ArrayList<String> relics = null;
        AbstractDungeon.player.loseRandomRelics(AbstractDungeon.player.relics.size());
        if (AbstractDungeon.player.chosenClass == AbstractPlayer.PlayerClass.IRONCLAD) {
            relics = Ironclad.getStartingRelics();
            relics.add("Navi");
        }
        else if (AbstractDungeon.player.chosenClass == AbstractPlayer.PlayerClass.THE_SILENT) {
            relics = TheSilent.getStartingRelics();
            relics.add("Navi");
        }
        else if (AbstractDungeon.player.chosenClass == AbstractPlayer.PlayerClass.DEFECT) {
            relics = Defect.getStartingRelics();
            relics.add("Navi");
        }
        int index = 0;
        for (final String relic : relics){
            RelicLibrary.getRelic(relic).makeCopy().instantObtain(AbstractDungeon.player, index, false);
            index++;
        }

        try{
            Method m = AbstractDungeon.class.getDeclaredMethod("initializeRelicList");
            m.setAccessible(true);
            m.invoke(CardCrawlGame.dungeon);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void changeRandomThings(){
        initializePlayerState();
        AbstractDungeon.player.currentHealth = generator.nextInt(AbstractDungeon.player.maxHealth - 1) + 1;
        int numCardsToRemove = generator.nextInt(5);
        for(int i=0; i < numCardsToRemove; i++)
        {
            removeRandomCard();
        }
        int numCardsToAdd = generator.nextInt(30);
        for(int i=0; i < numCardsToAdd; i++)
        {
            addRandomCard();
        }
        int numRelicsToAdd = generator.nextInt(20);
        for(int i=0; i < numRelicsToAdd; i++)
        {
            addRandomRelic();
        }
        int numPotionsToAdd = generator.nextInt( 4);
        for(int i=0; i < numPotionsToAdd; i++)
        {
            addRandomPotion();
        }
        int numCursesToAdd = generator.nextInt( 3);
        for(int i=0; i < numCursesToAdd; i++)
        {
            addRandomCurse();
        }
    }

    public static void addRandomCard(){
        boolean hasPrismaticShard = false;
        AbstractCard card;
        AbstractCard.CardRarity[] cardRarities = AbstractCard.CardRarity.values();
        if (AbstractDungeon.player.hasRelic("PrismaticShard")){
            hasPrismaticShard = true;
        }
        com.megacrit.cardcrawl.random.Random gen = new com.megacrit.cardcrawl.random.Random();
        if (!hasPrismaticShard){
            card = CardLibrary.getColorSpecificCard(AbstractDungeon.player.chosenClass, gen);
        }
        else {
            AbstractCard.CardRarity randomRarity = cardRarities[generator.nextInt(cardRarities.length-1)];
            card = CardLibrary.getAnyColorCard(randomRarity);
        }
        System.out.println("Adding card " + card.cardID);
        boolean toUpgrade = generator.nextInt(100) <= 9; //generator.nextBoolean();
        System.out.println("Is it gonna be upgraded? " + toUpgrade);
        CardActions.AddCard2(card.cardID, toUpgrade);
    }

    public static void removeRandomCard(){
        if (AbstractDungeon.player.masterDeck.getPurgeableCards().group.size() > 1) {
            AbstractCard cardToRemove = AbstractDungeon.player.masterDeck.getPurgeableCards().group.get(generator.nextInt(AbstractDungeon.player.masterDeck.getPurgeableCards().group.size() - 1));
            AbstractDungeon.player.masterDeck.removeCard(cardToRemove);
        }
    }

    public static void addRandomRelic(){
        AbstractRelic.RelicTier[] relicTiers = AbstractRelic.RelicTier.values();
        AbstractRelic.RelicTier randomTier = relicTiers[generator.nextInt(relicTiers.length-1)];
        String relicToAdd = "None";
        int relicIndexToGet = 0;
        switch (randomTier){
            case BOSS:
                relicToAdd = AbstractDungeon.bossRelicPool.get(relicIndexToGet);
                AbstractDungeon.bossRelicPool.remove(relicIndexToGet);
                break;
            case RARE:
                relicToAdd = AbstractDungeon.rareRelicPool.get(relicIndexToGet);
                AbstractDungeon.rareRelicPool.remove(relicIndexToGet);
                break;
            case UNCOMMON:
                relicToAdd = AbstractDungeon.uncommonRelicPool.get(relicIndexToGet);
                AbstractDungeon.uncommonRelicPool.remove(relicIndexToGet);
                break;
            case COMMON:
                relicToAdd = AbstractDungeon.commonRelicPool.get(relicIndexToGet);
                AbstractDungeon.commonRelicPool.remove(relicIndexToGet);
                break;
            case SHOP:
                relicToAdd = AbstractDungeon.shopRelicPool.get(relicIndexToGet);
                AbstractDungeon.shopRelicPool.remove(relicIndexToGet);
                break;
            case SPECIAL:
                break;
            default:
                break;
        }
        if(!"None".equals(relicToAdd) && !relicToAdd.contains("Bottled") && !relicToAdd.contains("Empty Cage") && !relicToAdd.contains("Calling Bell") && !relicToAdd.contains("Astrolabe")) {
            System.out.println("Adding relic: " + relicToAdd);
            AbstractDungeon.getCurrRoom().spawnRelicAndObtain((float)(Settings.WIDTH / 2), (float)(Settings.HEIGHT / 2), RelicLibrary.getRelic(relicToAdd).makeCopy());
        }
        else{
            System.out.println("Not adding relic.");
        }
    }

    public void removeRandomRelic(){
        if (AbstractDungeon.player.relics.size() > 2) {
            int relicToRemoveIndex = generator.nextInt(AbstractDungeon.player.relics.size());
            if (relicToRemoveIndex <= 1)
            {
                System.out.println("Not removing a relic.");
            }
            else
            {
                AbstractRelic relicToRemove = AbstractDungeon.player.relics.get(relicToRemoveIndex); //don't remove first two relics??
                AbstractDungeon.player.loseRelic(relicToRemove.relicId);
            }
        }
    }

    public static void addRandomPotion(){
        boolean isPotionSlotAvailable = false;
        for ( AbstractPotion potion : AbstractDungeon.player.potions)
        {
            System.out.println("Player potion.name :: " + potion.name);
            if ( "Potion Slot".equalsIgnoreCase(potion.name) )
            {
                isPotionSlotAvailable = true;
            }
        }
        if ( isPotionSlotAvailable )
        {
            AbstractPotion potion = PotionHelper.getRandomPotion();
            AbstractDungeon.player.obtainPotion(potion);
        }
        else {
            System.out.println("Not adding potion.");
        }
    }

    public void removeRandomPotion(){
        AbstractPotion potionToRemove = AbstractDungeon.player.potions.get(generator.nextInt(AbstractDungeon.player.potions.size()-1));
        AbstractDungeon.player.potions.remove(potionToRemove);
    }

    public static void addRandomCurse(){
        AbstractCard card = CardLibrary.getCurse();
        CardActions.AddCard(card.cardID, false);
    }
}
