package botActions;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.status.Wound;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndObtainEffect;

//Use BaseMod.underScoreCardIDs for all cardNames here
public class CardActions {
    public static void AddCard(String cardName, boolean upgrade){


            AbstractCard c = CardLibrary.getCard(cardName);
            if (c != null) {
                AbstractCard copy = c.makeCopy();
                if(upgrade) {
                    copy.upgrade();
                }
                UnlockTracker.markCardAsSeen(copy.cardID);
                AbstractDungeon.effectList.add(new ShowCardAndObtainEffect(copy, (float) Settings.WIDTH / 2.0F, (float)Settings.HEIGHT / 2.0F));
                AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(copy, 1, true, false));
            }
    }
    public static void RemoveCard(String cardName) {
        AbstractDungeon.player.masterDeck.removeCard(cardName);
    }

}
