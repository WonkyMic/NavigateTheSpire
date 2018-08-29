package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import com.megacrit.cardcrawl.rewards.RewardItem;
import com.megacrit.cardcrawl.screens.CombatRewardScreen;
import jsonUtil.StateDataDump;

@SpirePatch(
        cls="com.megacrit.cardcrawl.screens.CombatRewardScreen",
        method="open",
        paramtypes={
        }
)
public class CombatRewardScreenPatch {
    public static boolean rewardsFinished = false;
    public static void Postfix (CombatRewardScreen screen) {
        rewardsFinished = false;
        for (RewardItem r : screen.rewards) {
            if (r.type == RewardItem.RewardType.CARD) {
                r.hb.clicked = true;
            }
            if (r.type == RewardItem.RewardType.RELIC) {
                //StateDataDump.relicsSeen.add(r.relic.name);
                r.hb.clicked = true;
            }
            if (r.type == RewardItem.RewardType.GOLD || r.type == RewardItem.RewardType.STOLEN_GOLD) {
                r.hb.clicked = true;
            }
            if (r.type == RewardItem.RewardType.POTION) {
                boolean isPotionSlotAvailable = false;
                for ( AbstractPotion potion : AbstractDungeon.player.potions)
                {
                    System.out.println("Player potion.name :: " + potion.name);
                    if ( "Potion Slot".equalsIgnoreCase(potion.name) )
                    {
                        isPotionSlotAvailable = true;
                    }
                }
                if ( isPotionSlotAvailable )
                {
                    r.hb.clicked = true;
                }
            }
        }

        rewardsFinished = true;

        if(AbstractDungeon.getCurrRoom().getMapSymbol() != "B")
        {
            //AbstractDungeon.screen = AbstractDungeon.CurrentScreen.MAP;
        }
    }
}
