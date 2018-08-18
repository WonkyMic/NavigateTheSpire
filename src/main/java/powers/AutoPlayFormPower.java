package devthespire.powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import devthespire.actions.PlayLeftCardFromHandAction;

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
	
	@Override
	public void atStartOfTurnPostDraw() {
		System.out.println("StartOfTurnPostDraw");
		AbstractDungeon.actionManager.addToBottom(new PlayLeftCardFromHandAction());
	}
}
