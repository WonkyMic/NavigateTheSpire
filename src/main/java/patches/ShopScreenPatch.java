package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.shop.ShopScreen;
import com.megacrit.cardcrawl.shop.StorePotion;
import com.megacrit.cardcrawl.shop.StoreRelic;
import jsonUtil.JsonDump;
import jsonUtil.StateDataDump;

import java.lang.reflect.Field;
import java.util.ArrayList;


@SpirePatch(
        clz= ShopScreen.class,
        method="open",
        paramtypes = {}
)
public class ShopScreenPatch {
    static boolean openPurge = true;
    public static void Postfix (ShopScreen screen) {

        //TODO: learn how to handle courier relic. updateRelics() patch????
        Class<?> c = screen.getClass();

        ArrayList<StoreRelic> relics = new ArrayList<StoreRelic>();
        ArrayList<StorePotion> potions = new ArrayList<StorePotion>();
        ArrayList<AbstractCard> coloredCards = new ArrayList<AbstractCard>();
        ArrayList<AbstractCard> colorlessCards = new ArrayList<AbstractCard>();
        boolean purgeHovered;
        try {
            Field f = c.getDeclaredField("relics");
            Field f1 = c.getDeclaredField("potions");
            Field f2 = c.getDeclaredField("coloredCards");
            Field f3 = c.getDeclaredField("colorlessCards");
            f.setAccessible(true);
            f1.setAccessible(true);
            f2.setAccessible(true);
            f3.setAccessible(true);
            relics = (ArrayList<StoreRelic>) f.get(screen);
            potions = (ArrayList<StorePotion>) f1.get(screen);
            coloredCards = (ArrayList<AbstractCard>) f2.get(screen);
            colorlessCards = (ArrayList<AbstractCard>) f3.get(screen);
        }
        catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        for(StoreRelic relic : relics) {
            System.out.println("Store relic: " + relic.relic.name + " costs " + relic.price);
            //add to list of relics seen.
            switch(relic.relic.relicId) {
                case "Anchor":
                    JsonDump.seenAnchor = 1;
                    break;
                case "Ancient Tea Set":
                    JsonDump.seenAncientTeaSet = 1;
                    break;
                case "Art of War":
                    JsonDump.seenArtofWar = 1;
                    break;
                case "Astrolabe":
                    JsonDump.seenAstrolabe = 1;
                    break;
                case "Bag of Marbles":
                    JsonDump.seenBagofMarbles = 1;
                    break;
                case "Bag of Preparation":
                    JsonDump.seenBagofPreparation = 1;
                    break;
                case "Bird Faced Urn":
                    JsonDump.seenBirdFacedUrn = 1;
                    break;
                case "Black Blood":
                    JsonDump.seenBlackBlood = 1;
                    break;
                case "Black Star":
                    JsonDump.seenBlackStar = 1;
                    break;
                case "Blood Vial":
                    JsonDump.seenBloodVial = 1;
                    break;
                case "Bloody Idol":
                    JsonDump.seenBloodyIdol = 1;
                    break;
                case "Blue Candle":
                    JsonDump.seenBlueCandle = 1;
                    break;
                case "Bottled Flame":
                    JsonDump.seenBottledFlame = 1;
                    break;
                case "Bottled Lightning":
                    JsonDump.seenBottledLightning = 1;
                    break;
                case "Bottled Tornado":
                    JsonDump.seenBottledTornado = 1;
                    break;
                case "Bronze Scales":
                    JsonDump.seenBronzeScales = 1;
                    break;
                case "Burning Blood":
                    JsonDump.seenBurningBlood = 1;
                    break;
                case "Cables":
                    JsonDump.seenCables = 1;
                    break;
                case "Calipers":
                    JsonDump.seenCalipers = 1;
                    break;
                case "Calling Bell":
                    JsonDump.seenCallingBell = 1;
                    break;
                case "Cauldron":
                    JsonDump.seenCauldron = 1;
                    break;
                case "Centennial Puzzle":
                    JsonDump.seenCentennialPuzzle = 1;
                    break;
                case "Chameleon Ring":
                    JsonDump.seenChameleonRing = 1;
                    break;
                case "Champion Belt":
                    JsonDump.seenChampionBelt = 1;
                    break;
                case "Charon's Ashes":
                    JsonDump.seenCharonsAshes = 1;
                    break;
                case "Chemical X":
                    JsonDump.seenChemicalX = 1;
                    break;
                case "Circlet":
                    JsonDump.seenCirclet = 1;
                    break;
                case "Cracked Core":
                    JsonDump.seenCrackedCore = 1;
                    break;
                case "FrozenCore":
                    JsonDump.seenFrozenCore = 1;
                    break;
                case "Cursed Key":
                    JsonDump.seenCursedKey = 1;
                    break;
                case "Darkstone Periapt":
                    JsonDump.seenDarkstonePeriapt = 1;
                    break;
                case "DataDisk":
                    JsonDump.seenDataDisk = 1;
                    break;
                case "Dead Branch":
                    JsonDump.seenDeadBranch = 1;
                    break;
                case "Derp Rock":
                    JsonDump.seenDerpRock = 1;
                    break;
                case "Discerning Monocle":
                    JsonDump.seenDiscerningMonocle = 1;
                    break;
                case "Dodecahedron":
                    JsonDump.seenDodecahedron = 1;
                    break;
                case "Dream Catcher":
                    JsonDump.seenDreamCatcher = 1;
                    break;
                case "Du-Vu Doll":
                    JsonDump.seenDuVuDoll = 1;
                    break;
                case "Ectoplasm":
                    JsonDump.seenEctoplasm = 1;
                    break;
                case "Emotion Chip":
                    JsonDump.seenEmotionChip = 1;
                    break;
                case "Enchiridion":
                    JsonDump.seenEnchiridion = 1;
                    break;
                case "Eternal Feather":
                    JsonDump.seenEternalFeather = 1;
                    break;
                case "Frozen Egg":
                    JsonDump.seenFrozenEgg = 1;
                    break;
                case "Frozen Egg 2":
                    JsonDump.seenFrozenEgg2 = 1;
                    break;
                case "Frozen Eye":
                    JsonDump.seenFrozenEye = 1;
                    break;
                case "Gambling Chip":
                    JsonDump.seenGamblingChip = 1;
                    break;
                case "Ginger":
                    JsonDump.seenGinger = 1;
                    break;
                case "Girya":
                    JsonDump.seenGirya = 1;
                    break;
                case "Golden Idol":
                    JsonDump.seenGoldenIdol = 1;
                    break;
                case "Gremlin Horn":
                    JsonDump.seenGremlinHorn = 1;
                    break;
                case "Happy Flower":
                    JsonDump.seenHappyFlower = 1;
                    break;
                case "Ice Cream":
                    JsonDump.seenIceCream = 1;
                    break;
                case "Inserter":
                    JsonDump.seenInserter = 1;
                    break;
                case "Juzu Bracelet":
                    JsonDump.seenJuzuBracelet = 1;
                    break;
                case "Kunai":
                    JsonDump.seenKunai = 1;
                    break;
                case "Lantern":
                    JsonDump.seenLantern = 1;
                    break;
                case "Lee's Waffle":
                    JsonDump.seenLeesWaffle = 1;
                    break;
                case "Letter Opener":
                    JsonDump.seenLetterOpener = 1;
                    break;
                case "Living Blade":
                    JsonDump.seenLivingBlade = 1;
                    break;
                case "Lizard Tail":
                    JsonDump.seenLizardTail = 1;
                    break;
                case "Magic Flower":
                    JsonDump.seenMagicFlower = 1;
                    break;
                case "Mango":
                    JsonDump.seenMango = 1;
                    break;
                case "Mark of Pain":
                    JsonDump.seenMarkofPain = 1;
                    break;
                case "Matryoshka":
                    JsonDump.seenMatryoshka = 1;
                    break;
                case "Meat on the Bone":
                    JsonDump.seenMeatontheBone = 1;
                    break;
                case "Medical Kit":
                    JsonDump.seenMedicalKit = 1;
                    break;
                case "Membership Card":
                    JsonDump.seenMembershipCard = 1;
                    break;
                case "Mercury Hourglass":
                    JsonDump.seenMercuryHourglass = 1;
                    break;
                case "Molten Egg":
                    JsonDump.seenMoltenEgg = 1;
                    break;
                case "Molten Egg 2":
                    JsonDump.seenMoltenEgg2 = 1;
                    break;
                case "Mummified Hand":
                    JsonDump.seenMummifiedHand = 1;
                    break;
                case "Necronomicon":
                    JsonDump.seenNecronomicon = 1;
                    break;
                case "NeowsBlessing":
                    JsonDump.seenNeowsBlessing = 1;
                    break;
                case "Nilry's Codex":
                    JsonDump.seenNilrysCodex = 1;
                    break;
                case "Nine Lives":
                    JsonDump.seenNineLives = 1;
                    break;
                case "Ninja Scroll":
                    JsonDump.seenNinjaScroll = 1;
                    break;
                case "Nloth's Gift":
                    JsonDump.seenNlothsGift = 1;
                    break;
                case "Nuclear Battery":
                    JsonDump.seenNuclearBattery = 1;
                    break;
                case "Nullstone Periapt":
                    JsonDump.seenNullstonePeriapt = 1;
                    break;
                case "Odd Mushroom":
                    JsonDump.seenOddMushroom = 1;
                    break;
                case "Oddly Smooth Stone":
                    JsonDump.seenOddlySmoothStone = 1;
                    break;
                case "Old Coin":
                    JsonDump.seenOldCoin = 1;
                    break;
                case "Omamori":
                    JsonDump.seenOmamori = 1;
                    break;
                case "Orichalcum":
                    JsonDump.seenOrichalcum = 1;
                    break;
                case "Ornamental Fan":
                    JsonDump.seenOrnamentalFan = 1;
                    break;
                case "Orrery":
                    JsonDump.seenOrrery = 1;
                    break;
                case "Pandora's Box":
                    JsonDump.seenPandorasBox = 1;
                    break;
                case "Pantograph":
                    JsonDump.seenPantograph = 1;
                    break;
                case "Paper Crane":
                    JsonDump.seenPaperCrane = 1;
                    break;
                case "Paper Frog":
                    JsonDump.seenPaperFrog = 1;
                    break;
                case "Peace Pipe":
                    JsonDump.seenPeacePipe = 1;
                    break;
                case "Pear":
                    JsonDump.seenPear = 1;
                    break;
                case "Pen Nib":
                    JsonDump.seenPenNib = 1;
                    break;
                case "Philosopher's Stone":
                    JsonDump.seenPhilosophersStone = 1;
                    break;
                case "Potion Belt":
                    JsonDump.seenPotionBelt = 1;
                    break;
                case "Prayer Wheel":
                    JsonDump.seenPrayerWheel = 1;
                    break;
                case "Question Card":
                    JsonDump.seenQuestionCard = 1;
                    break;
                case "Red Circlet":
                    JsonDump.seenRedCirclet = 1;
                    break;
                case "Red Mask":
                    JsonDump.seenRedMask = 1;
                    break;
                case "Red Skull":
                    JsonDump.seenRedSkull = 1;
                    break;
                case "Regal Pillow":
                    JsonDump.seenRegalPillow = 1;
                    break;
                case "Ring of the Serpent":
                    JsonDump.seenRingoftheSerpent = 1;
                    break;
                case "Ring of the Snake":
                    JsonDump.seenRingoftheSnake = 1;
                    break;
                case "Runic Capacitor":
                    JsonDump.seenRunicCapacitor = 1;
                    break;
                case "Runic Cube":
                    JsonDump.seenRunicCube = 1;
                    break;
                case "Runic Dome":
                    JsonDump.seenRunicDome = 1;
                    break;
                case "Runic Pyramid":
                    JsonDump.seenRunicPyramid = 1;
                    break;
                case "Self Forming Clay":
                    JsonDump.seenSelfFormingClay = 1;
                    break;
                case "Shovel":
                    JsonDump.seenShovel = 1;
                    break;
                case "Shuriken":
                    JsonDump.seenShuriken = 1;
                    break;
                case "Singing Bowl":
                    JsonDump.seenSingingBowl = 1;
                    break;
                case "Smiling Mask":
                    JsonDump.seenSmilingMask = 1;
                    break;
                case "Snake Skull":
                    JsonDump.seenSnakeSkull = 1;
                    break;
                case "Snecko Eye":
                    JsonDump.seenSneckoEye = 1;
                    break;
                case "Sozu":
                    JsonDump.seenSozu = 1;
                    break;
                case "Spirit Poop":
                    JsonDump.seenSpiritPoop = 1;
                    break;
                case "Strange Spoon":
                    JsonDump.seenStrangeSpoon = 1;
                    break;
                case "Strawberry":
                    JsonDump.seenStrawberry = 1;
                    break;
                case "Sundial":
                    JsonDump.seenSundial = 1;
                    break;
                case "Symbiotic Virus":
                    JsonDump.seenSymbioticVirus = 1;
                    break;
                case "Test 1":
                    JsonDump.seenTest1 = 1;
                    break;
                case "Test 2":
                    JsonDump.seenTest2 = 1;
                    break;
                case "Test 3":
                    JsonDump.seenTest3 = 1;
                    break;
                case "Test 4":
                    JsonDump.seenTest4 = 1;
                    break;
                case "Test 5":
                    JsonDump.seenTest5 = 1;
                    break;
                case "Test 6":
                    JsonDump.seenTest6 = 1;
                    break;
                case "Test 7":
                    JsonDump.seenTest7 = 1;
                    break;
                case "Test 8":
                    JsonDump.seenTest8 = 1;
                    break;
                case "The Courier":
                    JsonDump.seenTheCourier = 1;
                    break;
                case "The Specimen":
                    JsonDump.seenTheSpecimen = 1;
                    break;
                case "Thread and Needle":
                    JsonDump.seenThreadandNeedle = 1;
                    break;
                case "Tingsha":
                    JsonDump.seenTingsha = 1;
                    break;
                case "Tiny Chest":
                    JsonDump.seenTinyChest = 1;
                    break;
                case "Tiny House":
                    JsonDump.seenTinyHouse = 1;
                    break;
                case "Toolbox":
                    JsonDump.seenToolbox = 1;
                    break;
                case "Torii":
                    JsonDump.seenTorii = 1;
                    break;
                case "Tough Bandages":
                    JsonDump.seenToughBandages = 1;
                    break;
                case "Toxic Egg":
                    JsonDump.seenToxicEgg = 1;
                    break;
                case "Toxic Egg 2":
                    JsonDump.seenToxicEgg2 = 1;
                    break;
                case "Toy Ornithopter":
                    JsonDump.seenToyOrnithopter = 1;
                    break;
                case "Turnip":
                    JsonDump.seenTurnip = 1;
                    break;
                case "Unceasing Top":
                    JsonDump.seenUnceasingTop = 1;
                    break;
                case "Vajra":
                    JsonDump.seenVajra = 1;
                    break;
                case "Velvet Choker":
                    JsonDump.seenVelvetChoker = 1;
                    break;
                case "War Paint":
                    JsonDump.seenWarPaint = 1;
                    break;
                case "Whetstone":
                    JsonDump.seenWhetstone = 1;
                    break;
                case "White Beast Statue":
                    JsonDump.seenWhiteBeastStatue = 1;
                    break;
                case "Boot":
                    JsonDump.seenBoot = 1;
                    break;
                case "Mark of the Bloom":
                    JsonDump.seenMarkoftheBloom = 1;
                    break;
                case "Busted Crown":
                    JsonDump.seenBustedCrown = 1;
                    break;
                case "Incense Burner":
                    JsonDump.seenIncenseBurner = 1;
                    break;
                case "Empty Cage":
                    JsonDump.seenEmptyCage = 1;
                    break;
                case "Fusion Hammer":
                    JsonDump.seenFusionHammer = 1;
                    break;
                case "Coffee Dripper":
                    JsonDump.seenCoffeeDripper = 1;
                    break;
                case "SsserpentHead":
                    JsonDump.seenSsserpentHead = 1;
                    break;
                case "MutagenicStrength":
                    JsonDump.seenMutagenicStrength = 1;
                    break;
                case "FaceOfCleric":
                    JsonDump.seenFaceOfCleric = 1;
                    break;
                case "NlothsMask":
                    JsonDump.seenNlothsMask = 1;
                    break;
                case "GremlinMask":
                    JsonDump.seenGremlinMask = 1;
                    break;
                case "CultistMask":
                    JsonDump.seenCultistMask = 1;
                    break;
                case "TheAbacus":
                    JsonDump.seenTheAbacus = 1;
                    break;
                case "DollysMirror":
                    JsonDump.seenDollysMirror = 1;
                    break;
                case "ClockworkSouvenir":
                    JsonDump.seenClockworkSouvenir = 1;
                    break;
                case "MealTicket":
                    JsonDump.seenMealTicket = 1;
                    break;
                case "TwistedFunnel":
                    JsonDump.seenTwistedFunnel = 1;
                    break;
                case "HandDrill":
                    JsonDump.seenHandDrill = 1;
                    break;
                case "HoveringKite":
                    JsonDump.seenHoveringKite = 1;
                    break;
                case "Sling":
                    JsonDump.seenSling = 1;
                    break;
                case "OrangePellets":
                    JsonDump.seenOrangePellets = 1;
                    break;
                case "WristBlade":
                    JsonDump.seenWristBlade = 1;
                    break;
                case "StoneCalendar":
                    JsonDump.seenStoneCalendar = 1;
                    break;
                case "Nunchaku":
                    JsonDump.seenNunchaku = 1;
                    break;
                case "Brimstone":
                    JsonDump.seenBrimstone = 1;
                    break;
                case "PreservedInsect":
                    JsonDump.seenPreservedInsect = 1;
                    break;
                case "Pocketwatch":
                    JsonDump.seenPocketwatch = 1;
                    break;
                case "FossilizedHelix":
                    JsonDump.seenFossilizedHelix = 1;
                    break;
                case "PrismaticShard":
                    JsonDump.seenPrismaticShard = 1;
                    break;
                case "WarpedTongs":
                    JsonDump.seenWarpedTongs = 1;
                    break;
                case "WingedGreaves":
                    JsonDump.seenWingedGreaves = 1;
                    break;
                case "MawBank":
                    JsonDump.seenMawBank = 1;
                    break;
            }
        }
        for(StorePotion potion : potions) {
            System.out.println("Store potion: " + potion.potion.name + " costs " + potion.price);
        }
        for(AbstractCard coloredCard : coloredCards) {
            System.out.println("Store coloredCard: " + coloredCard.name + " costs " + coloredCard.price);
        }
        for(AbstractCard colorlessCard : colorlessCards) {
            System.out.println("Store colorlessCard: " + colorlessCard.name + " costs " + colorlessCard.price);
        }

        System.out.println("purge available: " + screen.purgeAvailable + " costs " + screen.actualPurgeCost);

        /* this is how we purchase things
        relics.get(0).relic.hb.hovered = true;
        relics.get(0).relic.hb.clicked = true;
        System.out.println("attempted to purchase relic: " + relics.get(0).relic.name);

        potions.get(0).potion.hb.hovered = true;
        potions.get(0).potion.hb.clicked = true;
        System.out.println("attempted to purchase relic: " + potions.get(0).potion.name);

        coloredCards.get(0).hb.hovered = true;
        coloredCards.get(0).hb.clicked = true;
        System.out.println("attempted to purchase relic: " + coloredCards.get(0).name);

        colorlessCards.get(0).hb.hovered = true;
        colorlessCards.get(0).hb.clicked = true;
        System.out.println("attempted to purchase relic: " + colorlessCards.get(0).name);
        */


        //handle opening card removal
        if (screen.purgeAvailable && AbstractDungeon.screen == AbstractDungeon.CurrentScreen.SHOP && openPurge)
        {
            if (AbstractDungeon.player.gold >= screen.actualPurgeCost) {
                openPurge = false;
                AbstractDungeon.previousScreen = AbstractDungeon.CurrentScreen.SHOP;
                AbstractDungeon.gridSelectScreen.open(CardGroup.getGroupWithoutBottledCards(AbstractDungeon.player.masterDeck.getPurgeableCards()), 1, ShopScreen.NAMES[13], false, false, true, true);
            }
        }
    }
}
