package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.screens.CardRewardScreen;
import com.megacrit.cardcrawl.ui.buttons.SingingBowlButton;
import com.megacrit.cardcrawl.ui.buttons.SkipCardButton;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

@SpirePatch(
        cls="com.megacrit.cardcrawl.screens.CardRewardScreen",
        method="cardSelectUpdate"
)
public class CardRewardScreenPatch {
    @SpireInsertPatch(
            rloc=26,
            localvars={"rewardGroup", "hoveredCard", "skipButton", "bowlButton", "codex", "codexCard", "discovery", "discoveryCard", "draft", "draftCount"}
    )
    public static void Insert (CardRewardScreen screen, ArrayList<AbstractCard>rewardGroup, AbstractCard hoveredCard, SkipCardButton skipButton, SingingBowlButton bowlButton, boolean codex, AbstractCard codexCard, boolean discovery, AbstractCard discoveryCard, boolean draft, int draftCount) {
        hoveredCard = rewardGroup.get(0);
        hoveredCard.hb.clicked = true;
        //hoveredCard.hb.hovered = true;

        if (hoveredCard != null && hoveredCard.hb.clicked) {
            hoveredCard.hb.clicked = false;
            skipButton.hide();
            bowlButton.hide();
            if (codex) {
                screen.codexCard = hoveredCard;
            } else if (discovery) {
                screen.discoveryCard = hoveredCard;
            } else {
                try {
                    Method m = CardRewardScreen.class.getDeclaredMethod("acquireCard", AbstractCard.class);
                    m.setAccessible(true);
                    m.invoke(screen, hoveredCard);
                }
                catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e)
                {
                    e.printStackTrace();
                }
            }
            try {
                Method m = CardRewardScreen.class.getDeclaredMethod("takeReward");
                m.setAccessible(true);
                m.invoke(screen);
            }
            catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e)
            {
                e.printStackTrace();
            }
            if (draft && draftCount < 15) {
                screen.draftOpen();
            } else {
                AbstractDungeon.closeCurrentScreen();
                draftCount = 0;
            }
            //trying to switch screen to map to force next room after we're done picking rewards.
            AbstractDungeon.screen = AbstractDungeon.CurrentScreen.MAP;
        }
    }
}
