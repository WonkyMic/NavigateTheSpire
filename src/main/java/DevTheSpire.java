import basemod.BaseMod;
import basemod.helpers.RelicType;
import basemod.interfaces.*;
import botActions.CardActions;
import cards.AutoPlayForm;
import com.badlogic.gdx.Gdx;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
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
		if ( AbstractDungeon.player.currentHealth < AbstractDungeon.player.maxHealth )
		{
			AbstractDungeon.player.currentHealth = AbstractDungeon.player.maxHealth;
		}
		changeRandomThings();
	}

	public void changeRandomThings(){
		int rand = generator.nextInt(99);
		if (rand <= 0){ //1% chance to remove a relic
			removeRandomRelic();
		}
		else if (rand <= 5){ //5% chance to add a relic
			addRandomRelic();
		}
		else if (rand <= 6){ //1% chance to remove a card
			removeRandomCard();
		}
		else if (rand <= 26){ //20% chance to add a card
			addRandomCard();
		}
		else if (rand <= 27){ //1% chance to add a curse
			addRandomCurse();
		}
		else if (rand <= 28){ //1% chance to remove a potion
			removeRandomPotion();
		}
		else if (rand <= 38){ //10% chance to add a potion
			addRandomPotion();
		}
		else { //61% chance that nothing changes
			System.out.println("Changing nothing.");
		}
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
				AbstractDungeon.player.relics.remove(relicToRemove);
			}
		}
	}

	public void addRandomPotion(){
    	int slotToAdd = 0;
			while (!"Potion Slot".equalsIgnoreCase(AbstractDungeon.player.potions.get(slotToAdd).name)) {
				slotToAdd++;
			}
			if(slotToAdd < AbstractDungeon.player.potionSlots) {
				AbstractPotion potion = PotionHelper.getRandomPotion();
				AbstractDungeon.player.obtainPotion(slotToAdd, potion);
			}
			else {
				System.out.println("Not adding potion.");
			}
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
