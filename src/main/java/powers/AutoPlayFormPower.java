package powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;


public class AutoPlayFormPower extends AbstractPower {
	public static final String POWER_ID = "AutoPlayFormPower";
	public static final String NAME = "Auto Play Form";
	public static final String[] DESCRIPTIONS = new String[] {
			"Auto play the cards in your hand."
	};
	
	public AutoPlayFormPower(AbstractCreature owner, int amount) {
		this.name = NAME;
		this.ID = POWER_ID;
		this.owner = owner;
		this.amount = amount;
		updateDescription();
		this.type = AbstractPower.PowerType.BUFF;
		this.isTurnBased = false;
		this.priority = 90;
		this.img = new Texture("img/powers/AutoPlayPower.png");
		
	}

	//TODO: Figure out where this gets called and patch so that power is unnecessary?
	@Override
	public void onAfterUseCard (AbstractCard card, UseCardAction action) {
		AbstractDungeon.actionManager.addToBottom(new actions.PlayCardFromHandAction());
	}


	/*
	@Override
	public void atStartOfTurn () {
		System.out.println("atStartOfTurn");
		AbstractDungeon.actionManager.addToBottom(new actions.PlayCardFromHandAction());
	}
	*/
}
