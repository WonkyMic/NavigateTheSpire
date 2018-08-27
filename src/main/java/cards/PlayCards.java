package cards;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class PlayCards {

    public void playLeftCardFromHand(AbstractCard currentCard)
    {
        playLeftCardFromHand();
    }

    public void playLeftCardFromHand()
    {
        System.out.println("playLeftCardFromHand called");
        AbstractPlayer p = AbstractDungeon.player;
        if (AbstractDungeon.player.hand.group.size() > 0) {
            int n = 0;
            while (AbstractDungeon.getCurrRoom().monsters.monsters.get(n).currentHealth == 0) {
                n = n + 1;
            }
            AbstractMonster m = AbstractDungeon.getCurrRoom().monsters.monsters.get(n);
            int q = 0;
            while (!AbstractDungeon.player.hand.group.get(q).canUse(p, m) && q < p.hand.group.size()) {
                q = q + 1;
            }
            AbstractCard cardToPlay = AbstractDungeon.player.hand.group.get(q);

            System.out.println("q iterator = " + q);
            System.out.println("p.hand.group.size() = " + p.hand.group.size());
            if (q == p.hand.group.size() && !cardToPlay.canUse(p, m)) {
                System.out.println("ending turn");
                AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.common.EndTurnAction());
            }
            System.out.println("**FEZ receiveCardUsed - Can Use Card:" + cardToPlay.canUse(p, m));
            if (cardToPlay.canUse(p, m)) {
                AbstractDungeon.actionManager.addToBottom(new actions.PlayCardFromHandAction());
                //AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.utility.UnlimboAction(cardToPlay));
            }
        }
    }


    /*
    An idea: Postfix patch HandCardSelectScreen.open() (both versions). Instantly select the amount of cards by setting hoveredCard and calling selectHoveredCard() for each
    */

}
