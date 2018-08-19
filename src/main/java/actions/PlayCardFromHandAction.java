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
				System.out.println("q iterator = " + q);
				System.out.println("p.hand.group.size() = " + p.hand.group.size());
				q = q + 1;
			}
			AbstractCard cardToPlay = AbstractDungeon.player.hand.group.get(q);
			if (q == p.hand.group.size()-1 && !cardToPlay.canUse(p, m)) { //if player can't play any cards, end the turn.
				System.out.println("ending turn");
				AbstractDungeon.actionManager.cardQueue.clear();
				AbstractDungeon.player.limbo.group.clear();
				AbstractDungeon.player.releaseCard();
				AbstractDungeon.overlayMenu.endTurnButton.disable(true);
				//AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.common.EndTurnAction());
			}

			System.out.println("**FEZ PlayCardFromHandAction - Can Use Card:" + cardToPlay.canUse(p, m));
			System.out.println("**FEZ PlayCardFromHandAction - Can Use Card with this name:" + cardToPlay.name);
			if (cardToPlay.canUse(p, m)) {
				cardToPlay.freeToPlayOnce = false;
				cardToPlay.exhaustOnUseOnce = false;
				/*
				cardToPlay.current_y = (-200.0F * Settings.scale);
				cardToPlay.target_x = (Settings.WIDTH / 2.0F + 200.0F);
				cardToPlay.target_y = (Settings.HEIGHT / 2.0F);
				cardToPlay.targetAngle = 0.0F;
				cardToPlay.lighten(false);
				cardToPlay.drawScale = 0.12F;
				cardToPlay.targetDrawScale = 0.75F;
				*/
				AbstractDungeon.player.limbo.group.add(cardToPlay);
				AbstractDungeon.player.hand.group.remove(cardToPlay);
				cardToPlay.applyPowers();
				//cardToPlay.use(p,monsterToHit);
				AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.utility.QueueCardAction(cardToPlay, m));
				//AbstractDungeon.actionManager.addToBottom(new PlayCardFromHandAction());
				System.out.println("**FEZ PlayCardFromHandAction - past the line" + cardToPlay.canUse(p, m));
			}
			this.isDone = true;
		}
	}
}
