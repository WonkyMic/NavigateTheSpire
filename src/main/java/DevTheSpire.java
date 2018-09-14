import basemod.BaseMod;
import basemod.helpers.RelicType;
import basemod.interfaces.*;
import botActions.CardActions;
import cards.AutoPlayForm;
import com.badlogic.gdx.Gdx;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.helpers.PotionHelper;
import com.megacrit.cardcrawl.helpers.RelicLibrary;
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import jsonUtil.JsonDump;
import relics.AutoPlayRelic;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

//When all External Libraries are added from the pom.xml using maven the code can be uncommented.

@SpireInitializer
public class DevTheSpire implements  EditCardsSubscriber, OnCardUseSubscriber, EditRelicsSubscriber, PostCreateStartingRelicsSubscriber, EditStringsSubscriber, PostDungeonInitializeSubscriber, PostDeathSubscriber, PostBattleSubscriber, OnStartBattleSubscriber {
	Random generator = new Random();

    public DevTheSpire(){
        //Use this for when you subscribe to any hooks offered by BaseMod.
        BaseMod.subscribe(this);
    }

    //Used by @SpireInitializer
    public static void initialize(){

        //This creates an instance of our classes and gets our code going after BaseMod and ModTheSpire initialize.
        new DevTheSpire();


    }

	@Override
	public void receiveEditCards() {
		BaseMod.addCard(new AutoPlayForm());
		
	}

	@Override
	public void receiveCardUsed(AbstractCard arg0) {
		/*
		//TODO :: remove health logic
		if ( AbstractDungeon.player.currentHealth < AbstractDungeon.player.maxHealth )
		{
			AbstractDungeon.player.currentHealth = AbstractDungeon.player.maxHealth;
		}
		*/
	}


	@Override
	public void receiveEditRelics() {
    	BaseMod.addRelic(new AutoPlayRelic(), RelicType.SHARED);
	}

	@Override
	public void receivePostCreateStartingRelics(AbstractPlayer.PlayerClass chosenClass, ArrayList<String> relics) {
		// here we simply give the player na'vi in addition to their other starting relics
		boolean hasNavi = false;
		for (int i = 0; i < relics.size(); i++)
		{
			if(relics.get(i) == "Navi")
			{
				hasNavi = true;
			}
		}
		if(!hasNavi) {
			relics.add("Navi");
		}
	}

	@Override
	public void receiveEditStrings() {
		String relicStrings = Gdx.files.internal("localization/relicstrings.json").readString(
				String.valueOf(StandardCharsets.UTF_8));
		BaseMod.loadCustomStrings(RelicStrings.class, relicStrings);
	}

	@Override
	public void receivePostDungeonInitialize() {
		JsonDump.gameID = UUID.randomUUID();
		JsonDump.currentStateID = 0;
	}

	@Override
	public void receivePostDeath() {
		//TODO: player has died, reset RL environment
	}

	@Override
	public void receivePostBattle(AbstractRoom r){

	}

	@Override
	public void receiveOnBattleStart(AbstractRoom abstractRoom) {
    	//Randomly add and remove random cards/potions/relics/curses at the start of combat. This will allow us to emulate new combats and let the AI learn multiple combinations of things.
		//Need to randomize if each of these is called and how many times.
		addRandomCard();
		addRandomRelic();
		addRandomPotion();
		addRandomCurse();
		removeRandomRelic();
		removeRandomCard();
		removeRandomPotion();
	}

	public void addRandomCard(){
		boolean hasPrismaticShard = false;
		AbstractCard card;
		AbstractCard.CardRarity[] cardRarities = AbstractCard.CardRarity.values();
		AbstractCard.CardColor[] cardColors = AbstractCard.CardColor.values();
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
		boolean toUpgrade = generator.nextBoolean();
		System.out.println("Is it gonna be upgraded? " + toUpgrade);
		CardActions.AddCard(card.cardID, toUpgrade);
	}

	public void removeRandomCard(){
		AbstractCard cardToRemove = AbstractDungeon.player.masterDeck.group.get(generator.nextInt(AbstractDungeon.player.masterDeck.group.size()-1));
		while (cardToRemove.cardID == "AscendersBane" || cardToRemove.cardID == "Necronomicurse"){
			cardToRemove = AbstractDungeon.player.masterDeck.group.get(generator.nextInt(AbstractDungeon.player.masterDeck.group.size()-1));
		}
		AbstractDungeon.player.masterDeck.group.remove(cardToRemove);
	}

	public void addRandomRelic(){
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
		if(!"None".equals(relicToAdd)) {
			AbstractDungeon.player.getRelic(relicToAdd);
		}
		else{
			System.out.println("Not adding relic.");
		}
	}

	public void removeRandomRelic(){
    	AbstractRelic relicToRemove = AbstractDungeon.player.relics.get(generator.nextInt(AbstractDungeon.player.relics.size()-3)+2); //don't remove first two relics??
		AbstractDungeon.player.relics.remove(relicToRemove);
	}

	public void addRandomPotion(){
    	int slotToAdd = 0;
		for ( AbstractPotion potion : AbstractDungeon.player.potions) {
			if ("Potion Slot".equalsIgnoreCase(potion.name)) {
				slotToAdd = potion.slot;
			}
		}
		AbstractPotion potion = PotionHelper.getRandomPotion();
		AbstractDungeon.player.obtainPotion(slotToAdd, potion);
	}

	public void removeRandomPotion(){
		AbstractPotion potionToRemove = AbstractDungeon.player.potions.get(generator.nextInt(AbstractDungeon.player.potions.size()-1)); //don't remove first two relics??
		AbstractDungeon.player.potions.remove(potionToRemove);
	}

	public void addRandomCurse(){
		AbstractCard card = CardLibrary.getCurse();
		CardActions.AddCard(card.cardID, false);
	}

}
