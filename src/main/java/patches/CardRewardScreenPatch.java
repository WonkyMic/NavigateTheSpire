package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.rewards.RewardItem;
import com.megacrit.cardcrawl.screens.CardRewardScreen;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

@SpirePatch(
        cls="com.megacrit.cardcrawl.screens.CardRewardScreen",
        method="open",
        paramtypes={
                "java.util.ArrayList",
                "com.megacrit.cardcrawl.rewards.RewardItem",
                "java.lang.String"
        }
)
public class CardRewardScreenPatch {
    public static void Postfix (CardRewardScreen screen, ArrayList<AbstractCard> cards, RewardItem rItem, String header) {
        System.out.println("CardRewardScreenPatch patch hit");
        //screen.rewardGroup.get(0).hb.hovered = true;
        //screen.rewardGroup.get(0).hb.clicked = true;
        //screen.cardSelectUpdate();

        try {
            Method m = CardRewardScreen.class.getDeclaredMethod("cardSelectUpdate");
            m.setAccessible(true);
            System.out.println("invoking cardSelectUpdate");
            m.invoke(screen);
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e)
        {
            e.printStackTrace();
        }

    }
}
