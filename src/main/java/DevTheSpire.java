import basemod.BaseMod;
import basemod.helpers.RelicType;
import basemod.interfaces.*;
import botActions.CardActions;
import botActions.CombatActions;
import cards.AutoPlayForm;
import com.badlogic.gdx.Gdx;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
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
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import jsonUtil.JsonDump;
import relics.AutoPlayRelic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

//When all External Libraries are added from the pom.xml using maven the code can be uncommented.

@SpireInitializer
public class DevTheSpire implements  EditCardsSubscriber, EditRelicsSubscriber, PostCreateStartingRelicsSubscriber, EditStringsSubscriber, PostDungeonInitializeSubscriber, OnStartBattleSubscriber {
	static Random generator = new Random();

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
	public void receiveEditRelics() {
    	BaseMod.addRelic(new AutoPlayRelic(), RelicType.SHARED);
	}

	@Override
	public void receivePostCreateStartingRelics(AbstractPlayer.PlayerClass chosenClass, ArrayList<String> relics) {
		// here we simply give the player na'vi in addition to their other starting relics
		boolean hasNavi = false;
		for (final String relic : relics)
		{
			if(relic.equals("Navi"))
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
		CombatActions.changeThings = true;
	}

	@Override
	public void receiveOnBattleStart(AbstractRoom abstractRoom) {
    	//Randomly add and remove random cards/potions/relics/curses at the start of combat. This will allow us to emulate new combats and let the AI learn multiple combinations of things.
		//Need to randomize if each of these is called and how many times.
		CombatActions.changeThings = false;

		if ( AbstractDungeon.player.currentHealth < AbstractDungeon.player.maxHealth )
		{
			//AbstractDungeon.player.currentHealth = AbstractDungeon.player.maxHealth;
		}
		//changeRandomThings();
		if (JsonDump.changeThings) {
			JsonDump.changeThings = false;
		}
	}
}
