package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.screens.CardRewardScreen;
import com.megacrit.cardcrawl.screens.select.HandCardSelectScreen;
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
        System.out.println("cardSelectUpdate patch2 hit");
        //System.out.println("rewardGroup 0 = " + rewardGroup.get(0).name);
        //System.out.println("rewardGroup 1 = " + rewardGroup.get(1).name);
        //System.out.println("rewardGroup 2 = " + rewardGroup.get(2).name);
        hoveredCard = rewardGroup.get(0);
        hoveredCard.hb.clicked = true;
        //hoveredCard.hb.hovered = true;
        //hoveredCard.update();
        //hoveredCard.updateHoverLogic();
        System.out.println("hoveredCard = " + hoveredCard.name);
        System.out.println("hoveredCard clicked = " + hoveredCard.hb.clicked);

        if (hoveredCard != null && hoveredCard.hb.clicked) {
            hoveredCard.hb.clicked = false;
            skipButton.hide();
            bowlButton.hide();
            if (codex) {
                screen.codexCard = hoveredCard;
            } else if (discovery) {
                screen.discoveryCard = hoveredCard;
            } else {
                System.out.println("trying to acquire card");
                try {
                    Method m = CardRewardScreen.class.getDeclaredMethod("acquireCard", AbstractCard.class);
                    m.setAccessible(true);
                    m.invoke(screen, hoveredCard);
                }
                catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e)
                {
                    e.printStackTrace();
                }
                //screen.acquireCard(hoveredCard);
            }
            System.out.print("trying to take card reward");
            try {
                Method m = CardRewardScreen.class.getDeclaredMethod("takeReward");
                m.setAccessible(true);
                m.invoke(screen);
            }
            catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e)
            {
                e.printStackTrace();
            }
            //screen.takeReward();
            if (draft && draftCount < 15) {
                screen.draftOpen();
            } else {
                AbstractDungeon.closeCurrentScreen();
                draftCount = 0;
            }
        }
    }
}
