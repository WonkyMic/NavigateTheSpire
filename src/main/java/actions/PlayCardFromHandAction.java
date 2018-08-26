package actions;


import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import jsonUtil.JsonDump;


public class PlayCardFromHandAction extends com.megacrit.cardcrawl.actions.AbstractGameAction {


    public PlayCardFromHandAction() {
        this.duration = Settings.ACTION_DUR_FAST;
        this.actionType = com.megacrit.cardcrawl.actions.AbstractGameAction.ActionType.WAIT;
        this.source = AbstractDungeon.player;
    }

    public void update() {

    	AbstractPlayer p = AbstractDungeon.player;
    	JsonDump jsonDump = new JsonDump();
    	jsonDump.createJson();


		if (AbstractDungeon.player.hand.group.size() > 0) { //something to do with hand being empty after the last card is played????
			int n = 0;
			while (n<AbstractDungeon.getCurrRoom().monsters.monsters.size()-1 && (AbstractDungeon.getCurrRoom().monsters.monsters.get(n).isDead || AbstractDungeon.getCurrRoom().monsters.monsters.get(n).isDying)) {
				n = n + 1;
			}
			AbstractMonster m = AbstractDungeon.getCurrRoom().monsters.monsters.get(n);
			if (!p.potions.isEmpty())
			{
				for (AbstractPotion potion : p.potions)
				{
					potion.use(m);
					for (final AbstractRelic r : AbstractDungeon.player.relics) {
						r.onUsePotion();
					}
					System.out.println("potion in slot: " + potion.slot);
					if (!"Potion Slot".equalsIgnoreCase(potion.name) ) {
						AbstractDungeon.topPanel.destroyPotion(potion.slot);
					}
				}
			}
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
				AbstractDungeon.player.limbo.group.add(cardToPlay);
				AbstractDungeon.player.hand.group.remove(cardToPlay);
				cardToPlay.applyPowers();
				AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.utility.QueueCardAction(cardToPlay, m));
				AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.utility.WaitAction(3f));
			}
		}
		else
        {
            AbstractDungeon.actionManager.cardQueue.clear();
            AbstractDungeon.player.limbo.group.clear();
            AbstractDungeon.player.releaseCard();
            AbstractDungeon.overlayMenu.endTurnButton.disable(true);
        }
        this.isDone = true;
	}
}
