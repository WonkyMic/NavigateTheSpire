package actions;


import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class PlayCardFromHandAction extends com.megacrit.cardcrawl.actions.AbstractGameAction {


    public PlayCardFromHandAction() {
        this.duration = Settings.ACTION_DUR_FAST;
        this.actionType = com.megacrit.cardcrawl.actions.AbstractGameAction.ActionType.WAIT;
        this.source = AbstractDungeon.player;
    }

    public void update() {
		AbstractPlayer p = AbstractDungeon.player;
		if (AbstractDungeon.player.hand.group.size() > 0) {
			int n = 0;
			while (AbstractDungeon.getCurrRoom().monsters.monsters.get(n).isDead) {
				n = n + 1;
			}
			AbstractMonster m = AbstractDungeon.getCurrRoom().monsters.monsters.get(n);
			int q = 0;
			while (q < p.hand.group.size()-1 && !AbstractDungeon.player.hand.group.get(q).canUse(p, m)) {
				q = q + 1;
			}
			AbstractCard cardToPlay = AbstractDungeon.player.hand.group.get(q);
			if (q == p.hand.group.size()-1 && !cardToPlay.canUse(p, m)) { //if player can't play any cards, end the turn.
				AbstractDungeon.actionManager.cardQueue.clear();
				AbstractDungeon.player.limbo.group.clear();
				AbstractDungeon.player.releaseCard();
				AbstractDungeon.overlayMenu.endTurnButton.disable(true);
			}
			if (cardToPlay.canUse(p, m)) {
				cardToPlay.freeToPlayOnce = false;
				cardToPlay.exhaustOnUseOnce = false;
				AbstractDungeon.player.limbo.group.add(cardToPlay);
				AbstractDungeon.player.hand.group.remove(cardToPlay);
				cardToPlay.applyPowers();
				AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.utility.QueueCardAction(cardToPlay, m));

			}
			this.isDone = true;
		}
	}
}
