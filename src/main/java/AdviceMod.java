import Map.MapUtil;
import basemod.BaseMod;
import basemod.interfaces.PostDungeonInitializeSubscriber;

import basemod.interfaces.PostUpdateSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

@SpireInitializer
public class AdviceMod implements PostDungeonInitializeSubscriber, PostUpdateSubscriber {

    int previousFloor = 0;

    public AdviceMod()
    {
        BaseMod.subscribe(this);
    }

    public static void initialize()
    {
        AdviceMod modInitializer = new AdviceMod();
    }

    private void seeRelicPool()
    {
        System.out.println("**MIC - Relic pools \n"
                                + "Common List :: " + AbstractDungeon.commonRelicPool + "\n"
                                + "Uncommon List :: " + AbstractDungeon.uncommonRelicPool + "\n"
                                + "Rare List :: " + AbstractDungeon.rareRelicPool + "\n"
                                + "Shop List :: " + AbstractDungeon.shopRelicPool + "\n"
                                + "Boss List :: " + AbstractDungeon.bossRelicPool + "\n");
    }

    // No idea how these pools are used when giving player card selections
    private void seeCardPool()
    {
        System.out.println("**MIC - Card pools \n"
                                + "Common List :: " + AbstractDungeon.commonCardPool + "\n"
                                + "Uncommon List :: " + AbstractDungeon.uncommonCardPool + "\n"
                                + "Rare List :: " + AbstractDungeon.rareCardPool + "\n"
                                // Need to investigate how this card pool is generated
//                                + "Shop List :: " + AbstractDungeon.shop + "\n"
                                + "Boss List :: " + AbstractDungeon.getBossRewardCards() + "\n");
    }

    private void invokeNextMapNode()
    {
        previousFloor = AbstractDungeon.floorNum;
        MapUtil mUtil = new MapUtil();
        mUtil.getNextMapRoomNode(AbstractDungeon.getCurrMapNode());
    }

    @Override
    public void receivePostDungeonInitialize()
    {
        //seeRelicPool();
        //seeCardPool();
    }

    /**
     * This method is invoked constantly, careful when adding to this.
     */
    @Override
    public void receivePostUpdate()
    {
        if ( AbstractDungeon.screen == AbstractDungeon.CurrentScreen.MAP && AbstractDungeon.getCurrRoom().phase == com.megacrit.cardcrawl.rooms.AbstractRoom.RoomPhase.COMPLETE)
        {
            invokeNextMapNode();
        }
    }
}
