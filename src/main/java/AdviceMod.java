import basemod.BaseMod;
import basemod.interfaces.PostDungeonInitializeSubscriber;

import basemod.interfaces.PostUpdateSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.map.MapGenerator;

@SpireInitializer
public class AdviceMod implements PostDungeonInitializeSubscriber, PostUpdateSubscriber {

    private int count, totalCount;

    private void resetCounts() {
        totalCount = count = 0;
    }

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

    private void populateMapData()
    {
        if ( null != AbstractDungeon.map)
        {
            haveMapData = true;
            System.out.println("**MIC - map :: \n" + MapGenerator.toString(AbstractDungeon.map, Boolean.valueOf(true)));
        }
    }

    @Override
    public void receivePostDungeonInitialize()
    {
        resetCounts();
        seeRelicPool();
        seeCardPool();
        //seeMapLayout();
    }

    boolean haveMapData = false;

    /**
     * This method is invoked constantly, careful when adding to this.
     */
    @Override
    public void receivePostUpdate()
    {
        if ( !haveMapData )
        {
            populateMapData();
        }
    }

}
