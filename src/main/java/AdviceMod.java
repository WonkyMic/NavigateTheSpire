import Map.MapUtil;
import basemod.BaseMod;
import basemod.interfaces.PostDungeonInitializeSubscriber;
import basemod.interfaces.PostUpdateSubscriber;
import basemod.patches.com.megacrit.cardcrawl.dungeons.AbstractDungeon.PopulateMonsterList;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.helpers.MonsterHelper;
import com.megacrit.cardcrawl.helpers.PotionHelper;
import com.megacrit.cardcrawl.helpers.RelicLibrary;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.rooms.TreasureRoomBoss;
import org.clapper.util.classutil.*;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static basemod.patches.com.megacrit.cardcrawl.ui.panels.EnergyPanel.CtorSwitch.logger;

@SpireInitializer
public class AdviceMod implements PostDungeonInitializeSubscriber, PostUpdateSubscriber {

    int previousFloor = 0;
    HashMap powerMap;
    HashMap monsterMap;

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
                                //+ "Boss List :: " + AbstractDungeon.getBossRewardCards() + "\n"
                        );
    }

    private void invokeNextMapNode()
    {
        previousFloor = AbstractDungeon.floorNum;
        MapUtil mUtil = new MapUtil();
        mUtil.getNextMapRoomNode(AbstractDungeon.getCurrMapNode());
        //ArrayList<String> availablePathArrayList = mUtil.createAvailablePathArrayList(AbstractDungeon.getCurrMapNode());
        //System.out.println("Available Paths: " + availablePathArrayList.get(0));
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

    //TODO: Change this to a patch on opening map?
    @Override
    public void receivePostUpdate()
    {
        if ( AbstractDungeon.screen == AbstractDungeon.CurrentScreen.MAP && AbstractDungeon.getCurrRoom().phase == com.megacrit.cardcrawl.rooms.AbstractRoom.RoomPhase.COMPLETE && !(AbstractDungeon.getCurrRoom() instanceof TreasureRoomBoss))
        {
            invokeNextMapNode();
        }
    }

}
