import basemod.BaseMod;
import basemod.helpers.RelicType;
import basemod.interfaces.*;
import botActions.CardActions;
import cards.AutoPlayForm;
import com.badlogic.gdx.Gdx;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.localization.RelicStrings;
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
    	//Randomly add a card to the deck at the start of combat. This will allow us to emulate new combats and let the AI learn multiple combinations of things.
		//TODO: Force card to be from same class, UNLESS player has the prismatic relic.
		//TODO: Randomly add potions
		//TODO: Randomly add relics
		Random generator = new Random();
		Object[] values = BaseMod.underScoreCardIDs.values().toArray();
		Object randomValue = values[generator.nextInt(values.length)];
		System.out.println("Adding card " + (String)randomValue);
		boolean toUpgrade = generator.nextBoolean();
		System.out.println("Is it gonna be upgraded? " + toUpgrade);
		CardActions.AddCard((String)randomValue, toUpgrade);
	}
}
