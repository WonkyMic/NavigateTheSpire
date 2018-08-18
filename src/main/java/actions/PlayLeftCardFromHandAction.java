package devthespire.actions;


import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

public class PlayLeftCardFromHandAction extends com.megacrit.cardcrawl.actions.AbstractGameAction {
    AbstractCard cardToPlay;

    public PlayLeftCardFromHandAction () {
        this.duration = Settings.ACTION_DUR_FAST;
        this.actionType = com.megacrit.cardcrawl.actions.AbstractGameAction.ActionType.WAIT;
        this.source = AbstractDungeon.player;
    }

    public void update() {
    	System.out.println("PlayLeftCardFromHandAction");
    	AbstractPlayer p = AbstractDungeon.player;
		AbstractCard cardToPlay = AbstractDungeon.player.hand.group.get(0);
		System.out.println("Card costs: " + cardToPlay.cost);
		System.out.println("Energy Available: " + EnergyPanel.getCurrentEnergy());
		if (cardToPlay.cost <= EnergyPanel.getCurrentEnergy())
		{
				int n = 0;
				while (AbstractDungeon.getCurrRoom().monsters.monsters.get(n).currentHealth == 0)
				{
					n = n+1;
				}
				AbstractMonster m = AbstractDungeon.getCurrRoom().monsters.monsters.get(n);
		        AbstractDungeon.player.hand.group.remove(cardToPlay);
		        cardToPlay.freeToPlayOnce = false;
		        cardToPlay.exhaustOnUseOnce = false;
		        cardToPlay.current_y = (-200.0F * Settings.scale);
		        cardToPlay.target_x = (Settings.WIDTH / 2.0F + 200.0F);
		        cardToPlay.target_y = (Settings.HEIGHT / 2.0F);
		        cardToPlay.targetAngle = 0.0F;
		        cardToPlay.lighten(false);
		        cardToPlay.drawScale = 0.12F;
		        cardToPlay.targetDrawScale = 0.75F;
		        AbstractDungeon.player.limbo.group.add(cardToPlay);
		        cardToPlay.applyPowers();
		        AbstractDungeon.actionManager.addToTop(new com.megacrit.cardcrawl.actions.utility.QueueCardAction(cardToPlay, m));
		}
		        this.isDone = true;
    }

}
