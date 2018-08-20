package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rewards.RewardItem;
import com.megacrit.cardcrawl.screens.CombatRewardScreen;
import com.megacrit.cardcrawl.screens.select.HandCardSelectScreen;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SpirePatch(
        cls="com.megacrit.cardcrawl.screens.CombatRewardScreen",
        method="open",
        paramtypes={
        }
)
public class CombatRewardScreenPatch {
    public static void Postfix (CombatRewardScreen screen) {

        for (RewardItem r : screen.rewards) {
            if (r.type == RewardItem.RewardType.RELIC) {
                r.hb.clicked = true;
            }
            if (r.type == RewardItem.RewardType.GOLD || r.type == RewardItem.RewardType.STOLEN_GOLD) {
                r.hb.clicked = true;
            }
            if (r.type == RewardItem.RewardType.POTION //&& AbstractDungeon.player.potions.size() < AbstractDungeon.player.potionSlots
            ) {
                System.out.println("potion count: " + AbstractDungeon.player.potions.size());
                System.out.println("potion slots: " + AbstractDungeon.player.potionSlots);
                r.hb.clicked = true;
            }
            if (r.type == RewardItem.RewardType.CARD) {
                r.hb.clicked = true;
            }
        }


    }
}
