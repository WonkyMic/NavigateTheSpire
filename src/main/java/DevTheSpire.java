package devthespire;


import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

import basemod.interfaces.PostBattleSubscriber;
import basemod.interfaces.PostDrawSubscriber;
import basemod.interfaces.PostDungeonInitializeSubscriber;
import basemod.interfaces.PostExhaustSubscriber;
import devthespire.actions.PlayLeftCardFromHandAction;
import devthespire.cards.AutoPlayForm;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.OnCardUseSubscriber;

//When all External Libraries are added from the pom.xml using maven the code can be uncommented.

import basemod.BaseMod;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

@SpireInitializer
public class DevTheSpire implements PostDrawSubscriber, PostExhaustSubscriber,
PostBattleSubscriber, PostDungeonInitializeSubscriber, EditCardsSubscriber, OnCardUseSubscriber {
	
	private int count, totalCount;
	
	private void resetCounts() {
		totalCount = count = 0;
	}
	
	@Override
	public void receivePostDraw(AbstractCard card) {
	    System.out.println(card.name + " was drawn!");
	}
	
	@Override
	public void receivePostExhaust(AbstractCard c) {
		count++;
		totalCount++;
	}
	
	@Override
	public void receivePostBattle(AbstractRoom r) {
		System.out.println(count + " cards were exhausted this battle, " +
			totalCount + " cards have been exhausted so far this act.");
		count = 0;
	}
	
	@Override
	public void receivePostDungeonInitialize() {
		resetCounts();
	}


    public DevTheSpire(){
        //Use this for when you subscribe to any hooks offered by BaseMod.
        BaseMod.subscribe(this);
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
	
	public static final String makePath(String resource) {
		String result = "img/" + resource;

		return result;
	}

	@Override
	public void receiveCardUsed(AbstractCard arg0) {
		AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.utility.WaitAction(30));
    	AbstractPlayer p = AbstractDungeon.player;
    	System.out.println("receiveCardUsed listener");
		if (AbstractDungeon.player.hand.group.size() > 0)
		{
			AbstractCard cardToPlay = AbstractDungeon.player.hand.group.get(0);
			System.out.println("Seeing if I can play any cards.");
			System.out.println("Card costs: " + cardToPlay.cost);
			System.out.println("Energy Available: " + EnergyPanel.getCurrentEnergy());
			if (cardToPlay.cost <= EnergyPanel.getCurrentEnergy())
			{
		        AbstractDungeon.actionManager.addToBottom(new PlayLeftCardFromHandAction());
			}
			
		}
		
	}

}
