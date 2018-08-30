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
        //TODO: get all info that is sent to bot as a String and encode it to ints
        //System.out.println(CardLibrary.getAllCards().toString());
        //System.out.println("Relics: " + RelicLibrary.blueList+RelicLibrary.greenList.toString()+RelicLibrary.redList.toString()+RelicLibrary.bossList.toString()+RelicLibrary.commonList.toString()+RelicLibrary.uncommonList.toString()+RelicLibrary.rareList.toString()+RelicLibrary.shopList.toString()+RelicLibrary.specialList.toString()+RelicLibrary.starterList.toString());
        initializePowerMap();
        System.out.println("Powers: " + powerMap.keySet());
        initializeMonsterMap();
        System.out.println("Monsters: " + monsterMap.keySet());
        System.out.println("Potions: " + PotionHelper.potions.toString());


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






    public void initializePowerMap() {
        logger.info("initializePowerMap");
        powerMap = new HashMap<>();

        ClassFinder finder = new ClassFinder();
        URL url = AbstractPower.class.getProtectionDomain().getCodeSource().getLocation();
        try {
            finder.add(new File(url.toURI()));

            ClassFilter filter = new AndClassFilter(
                    new NotClassFilter(new InterfaceOnlyClassFilter()),
                    new NotClassFilter(new AbstractClassFilter()),
                    new RegexClassFilter("com\\.megacrit\\.cardcrawl\\.powers\\..+")
            );
            Collection<ClassInfo> foundClasses = new ArrayList<>();
            finder.findClasses(foundClasses, filter);

            for (ClassInfo classInfo : foundClasses) {
                if (classInfo.getClassName().contains("$")) {
                    continue;
                }
                try {
                    for (FieldInfo fieldInfo : classInfo.getFields()) {
                        if (fieldInfo.getName().equals("NAME") && fieldInfo.getValue() instanceof String) {
                            powerMap.put((String) fieldInfo.getValue(),
                                    (Class<? extends AbstractPower>) BaseMod.class.getClassLoader().loadClass(classInfo.getClassName()));
                            break;
                        }
                    }
                } catch (ClassNotFoundException e) {
                    System.out.println("ERROR: Failed to load power class: " + classInfo.getClassName());
                }
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void initializeMonsterMap() {
        logger.info("initializeMonsterMap");
        monsterMap = new HashMap<>();

        ClassFinder finder = new ClassFinder();
        URL url = AbstractPower.class.getProtectionDomain().getCodeSource().getLocation();
        try {
            finder.add(new File(url.toURI()));

            ClassFilter filter = new AndClassFilter(
                    new NotClassFilter(new InterfaceOnlyClassFilter()),
                    new NotClassFilter(new AbstractClassFilter()),
                    new RegexClassFilter("com\\.megacrit\\.cardcrawl\\.monsters\\..+")
            );
            Collection<ClassInfo> foundClasses = new ArrayList<>();
            finder.findClasses(foundClasses, filter);

            for (ClassInfo classInfo : foundClasses) {
                if (classInfo.getClassName().contains("$")) {
                    continue;
                }
                try {
                    for (FieldInfo fieldInfo : classInfo.getFields()) {
                        if (fieldInfo.getName().equals("NAME") && fieldInfo.getValue() instanceof String) {
                            monsterMap.put((String) fieldInfo.getValue(),
                                    (Class<? extends AbstractMonster>) BaseMod.class.getClassLoader().loadClass(classInfo.getClassName()));
                            break;
                        }
                    }
                } catch (ClassNotFoundException e) {
                    System.out.println("ERROR: Failed to load monster class: " + classInfo.getClassName());
                }
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
