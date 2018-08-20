package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.screens.CardRewardScreen;
import java.util.ArrayList;

@SpirePatch(
        cls="com.megacrit.cardcrawl.screens.CardRewardScreen",
        method="cardSelectUpdate"
)
public class CardRewardScreenPatch2 {
    @SpireInsertPatch(
            rloc=16,
            localvars={"rewardGroup", "hoveredCard"}
    )
    public static void Insert (CardRewardScreen screen, ArrayList<AbstractCard>rewardGroup, AbstractCard hoveredCard) {
        System.out.println("cardSelectUpdate patch2 hit");
        //System.out.println("rewardGroup 0 = " + rewardGroup.get(0).name);
        //System.out.println("rewardGroup 1 = " + rewardGroup.get(1).name);
        //System.out.println("rewardGroup 2 = " + rewardGroup.get(2).name);
        hoveredCard = rewardGroup.get(0);
        hoveredCard.hb.clicked = true;
        hoveredCard.hb.hovered = true;
        hoveredCard.update();
        hoveredCard.updateHoverLogic();
        System.out.println("hoveredCard = " + hoveredCard.name);
        System.out.println("hoveredCard clicked = " + hoveredCard.hb.clicked);
    }
}
