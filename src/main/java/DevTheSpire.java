import basemod.helpers.RelicType;
import basemod.interfaces.*;
import com.badlogic.gdx.Gdx;
import com.megacrit.cardcrawl.cards.AbstractCard;

import cards.AutoPlayForm;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.RelicStrings;
import relics.AutoPlayRelic;

//When all External Libraries are added from the pom.xml using maven the code can be uncommented.

import basemod.BaseMod;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@SpireInitializer
public class DevTheSpire implements  EditCardsSubscriber, OnCardUseSubscriber, EditRelicsSubscriber, PostCreateIroncladStartingRelicsSubscriber, PostCreateSilentStartingRelicsSubscriber, EditStringsSubscriber {


	public boolean inCombat = false;


    public DevTheSpire(){
        //Use this for when you subscribe to any hooks offered by BaseMod.
        BaseMod.subscribe(this);
		//BaseMod.subscribeToPostCreateStartingRelics(this);
    }

    //Used by @SpireInitializer
    public static void initialize(){

        //This creates an instance of our classes and gets our code going after BaseMod and ModTheSpire initialize.
        new DevTheSpire();

        //Look at the BaseMod wiki for getting started. (Skip the decompiling part. It's not needed right now)

    }

	@Override
	public void receiveEditCards() {
		BaseMod.addCard(new AutoPlayForm());
		
	}

	@Override
	public void receiveCardUsed(AbstractCard arg0) {
		System.out.println("receiveCardUsed listener new");
		while (!AbstractDungeon.actionManager.isEmpty() && !AbstractDungeon.player.limbo.group.isEmpty() && AbstractDungeon.actionManager.cardQueue.isEmpty())
		{
			System.out.println("waiting");
		}
		AbstractDungeon.actionManager.addToBottom(new actions.PlayCardFromHandAction());
	}


	@Override
	public void receiveEditRelics() {
    	BaseMod.addRelic(new AutoPlayRelic(), RelicType.SHARED);
	}

	@Override
	public boolean receivePostCreateStartingRelics(ArrayList<String> relics) {
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
		return false; //return false to retain normal starting relic, true will replace.
	}

	@Override
	public void receiveEditStrings() {
		String relicStrings = Gdx.files.internal("localization/relicstrings.json").readString(
				String.valueOf(StandardCharsets.UTF_8));
		BaseMod.loadCustomStrings(RelicStrings.class, relicStrings);
	}

}
