package jsonUtil;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.UUID;

public class CombatDataDump extends AbstractDataDump{

    int currentStateID;
    UUID combatStateID;
    UUID gameID;

    //player information
    int currentBlock;
    int currentEnergy;
    int maxEnergy;
    ArrayList<JsonCard> jsonCardArrayListHand = new ArrayList<JsonCard>();
    ArrayList<JsonCard> jsonCardArrayListExhaustPile = new ArrayList<JsonCard>();
    ArrayList<JsonCard> jsonCardArrayListDiscardPile = new ArrayList<JsonCard>();
    ArrayList<JsonCard> jsonCardArrayListDrawPile = new ArrayList<JsonCard>();
    int orbSlots;
    int numCardsPlayedThisTurn = 0;
    int numCardsDoubledThisTurn = 0;

    //monster information
    ArrayList<JsonEnemy> jsonEnemyArrayList = new ArrayList<JsonEnemy>();


    //PLAYER ORBS
    int orbSlot0IsDark = 0;
    int orbSlot1IsDark = 0;
    int orbSlot2IsDark = 0;
    int orbSlot3IsDark = 0;
    int orbSlot4IsDark = 0;
    int orbSlot5IsDark = 0;
    int orbSlot6IsDark = 0;
    int orbSlot7IsDark = 0;
    int orbSlot8IsDark = 0;
    int orbSlot9IsDark = 0;
    int orbSlot0IsEmpty = 0;
    int orbSlot1IsEmpty = 0;
    int orbSlot2IsEmpty = 0;
    int orbSlot3IsEmpty = 0;
    int orbSlot4IsEmpty = 0;
    int orbSlot5IsEmpty = 0;
    int orbSlot6IsEmpty = 0;
    int orbSlot7IsEmpty = 0;
    int orbSlot8IsEmpty = 0;
    int orbSlot9IsEmpty = 0;
    int orbSlot0IsFrost = 0;
    int orbSlot1IsFrost = 0;
    int orbSlot2IsFrost = 0;
    int orbSlot3IsFrost = 0;
    int orbSlot4IsFrost = 0;
    int orbSlot5IsFrost = 0;
    int orbSlot6IsFrost = 0;
    int orbSlot7IsFrost = 0;
    int orbSlot8IsFrost = 0;
    int orbSlot9IsFrost = 0;
    int orbSlot0IsLightning = 0;
    int orbSlot1IsLightning = 0;
    int orbSlot2IsLightning = 0;
    int orbSlot3IsLightning = 0;
    int orbSlot4IsLightning = 0;
    int orbSlot5IsLightning = 0;
    int orbSlot6IsLightning = 0;
    int orbSlot7IsLightning = 0;
    int orbSlot8IsLightning = 0;
    int orbSlot9IsLightning = 0;
    int orbSlot0IsPlasma = 0;
    int orbSlot1IsPlasma = 0;
    int orbSlot2IsPlasma = 0;
    int orbSlot3IsPlasma = 0;
    int orbSlot4IsPlasma = 0;
    int orbSlot5IsPlasma = 0;
    int orbSlot6IsPlasma = 0;
    int orbSlot7IsPlasma = 0;
    int orbSlot8IsPlasma = 0;
    int orbSlot9IsPlasma = 0;


    //PLAYER POWERS
    int countAccuracy = 0;
    int countAfterImage = 0;
    int countAmplify = 0;
    int countAnger = 0;
    int countAngry = 0;
    int countArtifact = 0;
    int countAttackBurn = 0;
    int countBarricade = 0;
    int countBerserk = 0;
    int countBias = 0;
    int countBlur = 0;
    int countBrutality = 0;
    int countBuffer = 0;
    int countBulletTime = 0;
    int countBurst = 0;
    int countChoked = 0;
    int countCombust = 0;
    int countConfusion = 0;
    int countConserve = 0;
    int countConstricted = 0;
    int countCorruption = 0;
    int countCreativeAI = 0;
    int countCuriosity = 0;
    int countCurlUp = 0;
    int countDancePuppet = 0;
    int countDarkEmbrace = 0;
    int countDemonForm = 0;
    int countDexLoss = 0;
    int countDexterity = 0;
    int countDoubleDamage = 0;
    int countDoubleTap = 0;
    int countDraw = 0;
    int countDrawCard = 0;
    int countDrawDown = 0;
    int countDrawReduction = 0;
    int countEchoForm = 0;
    int countElectro = 0;
    int countEnergized = 0;
    int countEnergizedBlue = 0;
    int countEntangled = 0;
    int countEnvenom = 0;
    int countEvolve = 0;
    int countExplosive = 0;
    int countExtraCards = 0;
    int countFeelNoPain = 0;
    int countFireBreathing = 0;
    int countFlameBarrier = 0;
    int countFlex = 0;
    int countFlight = 0;
    int countFocus = 0;
    int countFrail = 0;
    int countGambit = 0;
    int countGenericStrengthUpPower = 0;
    int countGrowthPower = 0;
    int countHeatsink = 0;
    int countHello = 0;
    int countHex = 0;
    int countHide = 0;
    int countInfiniteBlades = 0;
    int countIntangible = 0;
    int countIntangiblePlayer = 0;
    int countInverted = 0;
    int countJuggernaut = 0;
    int countKnowledge = 0;
    int countLifeLink = 0;
    int countLockon = 0;
    int countLoop = 0;
    int countMachineLearning = 0;
    int countMagnetism = 0;
    int countMalleable = 0;
    int countMayhem = 0;
    int countMetallicize = 0;
    int countMinion = 0;
    int countModeShift = 0;
    int countNextTurnBlock = 0;
    int countNightTerror = 0;
    int countNoAttack = 0;
    int countNoDraw = 0;
    int countNoxiousFumes = 0;
    int countNullifyAttack = 0;
    int countPainfulStabs = 0;
    int countPanache = 0;
    int countPenNib = 0;
    int countPhantasmal = 0;
    int countPlatedArmor = 0;
    int countPoison = 0;
    int countPrime = 0;
    int countPrimitive = 0;
    int countRage = 0;
    int countRebound = 0;
    int countReduceDamage = 0;
    int countRegenerate = 0;
    int countRegeneration = 0;
    int countRepair = 0;
    int countRepulse = 0;
    int countRetainCards = 0;
    int countRetainHand = 0;
    int countRiposte = 0;
    int countRitual = 0;
    int countRupture = 0;
    int countSadistic = 0;
    int countSerpentine = 0;
    int countShackled = 0;
    int countSharpHide = 0;
    int countShriekFromBeyond = 0;
    int countSkillBurn = 0;
    int countSlow = 0;
    int countSplit = 0;
    int countSporeCloud = 0;
    int countStasis = 0;
    int countStaticDischarge = 0;
    int countStorm = 0;
    int countStrength = 0;
    int countTheBomb = 0;
    int countThievery = 0;
    int countThorns = 0;
    int countThousandCuts = 0;
    int countTimeWarp = 0;
    int countToolsOfTheTrade = 0;
    int countUnawakened = 0;
    int countUnstable = 0;
    int countVenomology = 0;
    int countVulnerable = 0;
    int countWeakened = 0;
    int countWraithFormv2 = 0;
    int countEquilibrium = 0;
    int countFading = 0;
    int countShifting = 0;
    int countTimeMazePower = 0;
    int countNoBlockPower = 0;
    int countCorpseExplosionPower = 0;


    public void updateCombatDataForJson() {

        currentStateID = JsonDump.currentStateID;
        combatStateID = UUID.randomUUID();
        gameID = JsonDump.gameID;

        AbstractPlayer p = AbstractDungeon.player;

        //get player information
        currentBlock = p.currentBlock;
        currentEnergy = EnergyPanel.getCurrentEnergy();
        maxEnergy = p.energy.energy;
        while (jsonCardArrayListHand.size() < 10)
        {
            jsonCardArrayListHand.add(new JsonCard());
        }
        System.out.println(p.hand.group);
        if (p.hand.group != null) {
            for (int i = 0; i < p.hand.group.size(); i++) {
                AbstractCard c = p.hand.group.get(i);
                jsonCardArrayListHand.set(i, new JsonCard(c));
            }
        }
        while (jsonCardArrayListExhaustPile.size() < 100)
        {
            jsonCardArrayListExhaustPile.add(new JsonCard());
        }
        if (p.exhaustPile.group != null) {
            for (int i = 0; i < p.exhaustPile.group.size(); i++) {
                AbstractCard c = p.exhaustPile.group.get(i);
                jsonCardArrayListExhaustPile.set(i, new JsonCard(c));
            }
        }
        while (jsonCardArrayListDiscardPile.size() < 100)
        {
            jsonCardArrayListDiscardPile.add(new JsonCard());
        }
        if (p.discardPile.group != null) {
            for (int i = 0; i < p.discardPile.group.size(); i++) {
                AbstractCard c = p.discardPile.group.get(i);
                jsonCardArrayListDiscardPile.set(i, new JsonCard(c));
            }
        }
        while (jsonCardArrayListDrawPile.size() < 200)
        {
            jsonCardArrayListDrawPile.add(new JsonCard());
        }
        if (p.drawPile.group != null) {
            for (int i = 0; i < p.drawPile.group.size(); i++) {
                AbstractCard c = p.drawPile.group.get(i);
                jsonCardArrayListDrawPile.set(i, new JsonCard(c));
            }
        }


        if (AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT) {
            if (p.orbs != null) {
                for (int i = 0; i < p.orbs.size(); i++) {
                    switch(i) {
                        case 0:
                            switch (p.orbs.get(i).ID) {
                                case "Dark":
                                    orbSlot0IsDark = 1;
                                    break;
                                case "Empty":
                                    orbSlot0IsEmpty = 1;
                                    break;
                                case "Frost":
                                    orbSlot0IsFrost = 1;
                                    break;
                                case "Lightning":
                                    orbSlot0IsLightning = 1;
                                    break;
                                case "Plasma":
                                    orbSlot0IsPlasma = 1;
                                    break;
                            }
                        case 1:
                            switch (p.orbs.get(i).ID) {
                                case "Dark":
                                    orbSlot1IsDark = 1;
                                    break;
                                case "Empty":
                                    orbSlot1IsEmpty = 1;
                                    break;
                                case "Frost":
                                    orbSlot1IsFrost = 1;
                                    break;
                                case "Lightning":
                                    orbSlot1IsLightning = 1;
                                    break;
                                case "Plasma":
                                    orbSlot1IsPlasma = 1;
                                    break;
                            }
                        case 2:
                            switch (p.orbs.get(i).ID) {
                                case "Dark":
                                    orbSlot2IsDark = 1;
                                    break;
                                case "Empty":
                                    orbSlot2IsEmpty = 1;
                                    break;
                                case "Frost":
                                    orbSlot2IsFrost = 1;
                                    break;
                                case "Lightning":
                                    orbSlot2IsLightning = 1;
                                    break;
                                case "Plasma":
                                    orbSlot2IsPlasma = 1;
                                    break;
                            }
                        case 3:
                            switch (p.orbs.get(i).ID) {
                                case "Dark":
                                    orbSlot3IsDark = 1;
                                    break;
                                case "Empty":
                                    orbSlot3IsEmpty = 1;
                                    break;
                                case "Frost":
                                    orbSlot3IsFrost = 1;
                                    break;
                                case "Lightning":
                                    orbSlot3IsLightning = 1;
                                    break;
                                case "Plasma":
                                    orbSlot3IsPlasma = 1;
                                    break;
                            }
                        case 4:
                            switch (p.orbs.get(i).ID) {
                                case "Dark":
                                    orbSlot4IsDark = 1;
                                    break;
                                case "Empty":
                                    orbSlot4IsEmpty = 1;
                                    break;
                                case "Frost":
                                    orbSlot4IsFrost = 1;
                                    break;
                                case "Lightning":
                                    orbSlot4IsLightning = 1;
                                    break;
                                case "Plasma":
                                    orbSlot4IsPlasma = 1;
                                    break;
                            }
                        case 5:
                            switch (p.orbs.get(i).ID) {
                                case "Dark":
                                    orbSlot5IsDark = 1;
                                    break;
                                case "Empty":
                                    orbSlot5IsEmpty = 1;
                                    break;
                                case "Frost":
                                    orbSlot5IsFrost = 1;
                                    break;
                                case "Lightning":
                                    orbSlot5IsLightning = 1;
                                    break;
                                case "Plasma":
                                    orbSlot5IsPlasma = 1;
                                    break;
                            }
                        case 6:
                            switch (p.orbs.get(i).ID) {
                                case "Dark":
                                    orbSlot6IsDark = 1;
                                    break;
                                case "Empty":
                                    orbSlot6IsEmpty = 1;
                                    break;
                                case "Frost":
                                    orbSlot6IsFrost = 1;
                                    break;
                                case "Lightning":
                                    orbSlot6IsLightning = 1;
                                    break;
                                case "Plasma":
                                    orbSlot6IsPlasma = 1;
                                    break;
                            }
                        case 7:
                            switch (p.orbs.get(i).ID) {
                                case "Dark":
                                    orbSlot7IsDark = 1;
                                    break;
                                case "Empty":
                                    orbSlot7IsEmpty = 1;
                                    break;
                                case "Frost":
                                    orbSlot7IsFrost = 1;
                                    break;
                                case "Lightning":
                                    orbSlot7IsLightning = 1;
                                    break;
                                case "Plasma":
                                    orbSlot7IsPlasma = 1;
                                    break;
                            }
                        case 8:
                            switch (p.orbs.get(i).ID) {
                                case "Dark":
                                    orbSlot8IsDark = 1;
                                    break;
                                case "Empty":
                                    orbSlot8IsEmpty = 1;
                                    break;
                                case "Frost":
                                    orbSlot8IsFrost = 1;
                                    break;
                                case "Lightning":
                                    orbSlot8IsLightning = 1;
                                    break;
                                case "Plasma":
                                    orbSlot8IsPlasma = 1;
                                    break;
                            }
                        case 9:
                            switch (p.orbs.get(i).ID) {
                                case "Dark":
                                    orbSlot9IsDark = 1;
                                    break;
                                case "Empty":
                                    orbSlot9IsEmpty = 1;
                                    break;
                                case "Frost":
                                    orbSlot9IsFrost = 1;
                                    break;
                                case "Lightning":
                                    orbSlot9IsLightning = 1;
                                    break;
                                case "Plasma":
                                    orbSlot9IsPlasma = 1;
                                    break;
                            }
                    }
                }
            }
            orbSlots = p.maxOrbs;
        }

        //get monster information

        while (jsonEnemyArrayList.size() < 5)
        {
            jsonEnemyArrayList.add(new JsonEnemy());
        }

        if (AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT) {
            ArrayList<AbstractMonster> enemies = AbstractDungeon.getCurrRoom().monsters.monsters;
            for (int i = 0; i < enemies.size(); i++) {
                AbstractMonster enemy = enemies.get(i);
                if(i <= 4) {
                    jsonEnemyArrayList.set(i, new JsonEnemy(enemy));
                }
                else{
                    System.out.println("*** MONSTER ROOM WITH MORE THAN 5 ENEMIES: " + AbstractDungeon.getCurrRoom().monsters.getMonsterNames());
                }
            }
        }

        //POPULATE PLAYER POWER FIELDS
        for (final AbstractPower power : p.powers) {
            switch(power.ID) {
                case "Accuracy":
                    countAccuracy = power.amount;
                    break;
                case "After Image":
                    countAfterImage = power.amount;
                    break;
                case "Amplify":
                    countAmplify = power.amount;
                    break;
                case "Anger":
                    countAnger = power.amount;
                    break;
                case "Angry":
                    countAngry = power.amount;
                    break;
                case "Artifact":
                    countArtifact = power.amount;
                    break;
                case "Attack Burn":
                    countAttackBurn = power.amount;
                    break;
                case "Barricade":
                    countBarricade = power.amount;
                    break;
                case "Berserk":
                    countBerserk = power.amount;
                    break;
                case "Bias":
                    countBias = power.amount;
                    break;
                case "Blur":
                    countBlur = power.amount;
                    break;
                case "Brutality":
                    countBrutality = power.amount;
                    break;
                case "Buffer":
                    countBuffer = power.amount;
                    break;
                case "Bullet Time":
                    countBulletTime = power.amount;
                    break;
                case "Burst":
                    countBurst = power.amount;
                    break;
                case "Choked":
                    countChoked = power.amount;
                    break;
                case "Combust":
                    countCombust = power.amount;
                    break;
                case "Confusion":
                    countConfusion = power.amount;
                    break;
                case "Conserve":
                    countConserve = power.amount;
                    break;
                case "Constricted":
                    countConstricted = power.amount;
                    break;
                case "Corruption":
                    countCorruption = power.amount;
                    break;
                case "Creative AI":
                    countCreativeAI = power.amount;
                    break;
                case "Curiosity":
                    countCuriosity = power.amount;
                    break;
                case "Curl Up":
                    countCurlUp = power.amount;
                    break;
                case "Dance Puppet":
                    countDancePuppet = power.amount;
                    break;
                case "Dark Embrace":
                    countDarkEmbrace = power.amount;
                    break;
                case "Demon Form":
                    countDemonForm = power.amount;
                    break;
                case "DexLoss":
                    countDexLoss = power.amount;
                    break;
                case "Dexterity":
                    countDexterity = power.amount;
                    break;
                case "Double Damage":
                    countDoubleDamage = power.amount;
                    break;
                case "Double Tap":
                    countDoubleTap = power.amount;
                    break;
                case "Draw":
                    countDraw = power.amount;
                    break;
                case "Draw Card":
                    countDrawCard = power.amount;
                    break;
                case "Draw Down":
                    countDrawDown = power.amount;
                    break;
                case "Draw Reduction":
                    countDrawReduction = power.amount;
                    break;
                case "Echo Form":
                    countEchoForm = power.amount;
                    Class<?> c = power.getClass();
                    try {
                        Field f = c.getDeclaredField("cardsDoubledThisTurn");
                        f.setAccessible(true);
                        numCardsDoubledThisTurn = (int) f.get(power);
                    }
                    catch (IllegalAccessException | NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                    break;
                case "Electro":
                    countElectro = power.amount;
                    break;
                case "Energized":
                    countEnergized = power.amount;
                    break;
                case "EnergizedBlue":
                    countEnergizedBlue = power.amount;
                    break;
                case "Entangled":
                    countEntangled = power.amount;
                    break;
                case "Envenom":
                    countEnvenom = power.amount;
                    break;
                case "Evolve":
                    countEvolve = power.amount;
                    break;
                case "Explosive":
                    countExplosive = power.amount;
                    break;
                case "Extra Cards":
                    countExtraCards = power.amount;
                    break;
                case "Feel No Pain":
                    countFeelNoPain = power.amount;
                    break;
                case "Fire Breathing":
                    countFireBreathing = power.amount;
                    break;
                case "Flame Barrier":
                    countFlameBarrier = power.amount;
                    break;
                case "Flex":
                    countFlex = power.amount;
                    break;
                case "Flight":
                    countFlight = power.amount;
                    break;
                case "Focus":
                    countFocus = power.amount;
                    break;
                case "Frail":
                    countFrail = power.amount;
                    break;
                case "Gambit":
                    countGambit = power.amount;
                    break;
                case "Generic Strength Up Power":
                    countGenericStrengthUpPower = power.amount;
                    break;
                case "GrowthPower":
                    countGrowthPower = power.amount;
                    break;
                case "Heatsink":
                    countHeatsink = power.amount;
                    break;
                case "Hello":
                    countHello = power.amount;
                    break;
                case "Hex":
                    countHex = power.amount;
                    break;
                case "Hide":
                    countHide = power.amount;
                    break;
                case "Infinite Blades":
                    countInfiniteBlades = power.amount;
                    break;
                case "Intangible":
                    countIntangible = power.amount;
                    break;
                case "IntangiblePlayer":
                    countIntangiblePlayer = power.amount;
                    break;
                case "Inverted":
                    countInverted = power.amount;
                    break;
                case "Juggernaut":
                    countJuggernaut = power.amount;
                    break;
                case "Knowledge":
                    countKnowledge = power.amount;
                    break;
                case "Life Link":
                    countLifeLink = power.amount;
                    break;
                case "Lockon":
                    countLockon = power.amount;
                    break;
                case "Loop":
                    countLoop = power.amount;
                    break;
                case "Machine Learning":
                    countMachineLearning = power.amount;
                    break;
                case "Magnetism":
                    countMagnetism = power.amount;
                    break;
                case "Malleable":
                    countMalleable = power.amount;
                    break;
                case "Mayhem":
                    countMayhem = power.amount;
                    break;
                case "Metallicize":
                    countMetallicize = power.amount;
                    break;
                case "Minion":
                    countMinion = power.amount;
                    break;
                case "Mode Shift":
                    countModeShift = power.amount;
                    break;
                case "Next Turn Block":
                    countNextTurnBlock = power.amount;
                    break;
                case "Night Terror":
                    countNightTerror = power.amount;
                    break;
                case "No Attack":
                    countNoAttack = power.amount;
                    break;
                case "No Draw":
                    countNoDraw = power.amount;
                    break;
                case "Noxious Fumes":
                    countNoxiousFumes = power.amount;
                    break;
                case "Nullify Attack":
                    countNullifyAttack = power.amount;
                    break;
                case "Painful Stabs":
                    countPainfulStabs = power.amount;
                    break;
                case "Panache":
                    countPanache = power.amount;
                    break;
                case "Pen Nib":
                    countPenNib = power.amount;
                    break;
                case "Phantasmal":
                    countPhantasmal = power.amount;
                    break;
                case "Plated Armor":
                    countPlatedArmor = power.amount;
                    break;
                case "Poison":
                    countPoison = power.amount;
                    break;
                case "Prime":
                    countPrime = power.amount;
                    break;
                case "Primitive":
                    countPrimitive = power.amount;
                    break;
                case "Rage":
                    countRage = power.amount;
                    break;
                case "Rebound":
                    countRebound = power.amount;
                    break;
                case "Reduce Damage":
                    countReduceDamage = power.amount;
                    break;
                case "Regenerate":
                    countRegenerate = power.amount;
                    break;
                case "Regeneration":
                    countRegeneration = power.amount;
                    break;
                case "Repair":
                    countRepair = power.amount;
                    break;
                case "Repulse":
                    countRepulse = power.amount;
                    break;
                case "Retain Cards":
                    countRetainCards = power.amount;
                    break;
                case "Retain Hand":
                    countRetainHand = power.amount;
                    break;
                case "Riposte":
                    countRiposte = power.amount;
                    break;
                case "Ritual":
                    countRitual = power.amount;
                    break;
                case "Rupture":
                    countRupture = power.amount;
                    break;
                case "Sadistic":
                    countSadistic = power.amount;
                    break;
                case "Serpentine":
                    countSerpentine = power.amount;
                    break;
                case "Shackled":
                    countShackled = power.amount;
                    break;
                case "Sharp Hide":
                    countSharpHide = power.amount;
                    break;
                case "Shriek From Beyond":
                    countShriekFromBeyond = power.amount;
                    break;
                case "Skill Burn":
                    countSkillBurn = power.amount;
                    break;
                case "Slow":
                    countSlow = power.amount;
                    break;
                case "Split":
                    countSplit = power.amount;
                    break;
                case "Spore Cloud":
                    countSporeCloud = power.amount;
                    break;
                case "Stasis":
                    countStasis = power.amount;
                    break;
                case "StaticDischarge":
                    countStaticDischarge = power.amount;
                    break;
                case "Storm":
                    countStorm = power.amount;
                    break;
                case "Strength":
                    countStrength = power.amount;
                    break;
                case "TheBomb":
                    countTheBomb = power.amount;
                    break;
                case "Thievery":
                    countThievery = power.amount;
                    break;
                case "Thorns":
                    countThorns = power.amount;
                    break;
                case "Thousand Cuts":
                    countThousandCuts = power.amount;
                    break;
                case "Time Warp":
                    countTimeWarp = power.amount;
                    break;
                case "Tools Of The Trade":
                    countToolsOfTheTrade = power.amount;
                    break;
                case "Unawakened":
                    countUnawakened = power.amount;
                    break;
                case "Unstable":
                    countUnstable = power.amount;
                    break;
                case "Venomology":
                    countVenomology = power.amount;
                    break;
                case "Vulnerable":
                    countVulnerable = power.amount;
                    break;
                case "Weakened":
                    countWeakened = power.amount;
                    break;
                case "Wraith Form v2":
                    countWraithFormv2 = power.amount;
                    break;
                case "Equilibrium":
                    countEquilibrium = power.amount;
                    break;
                case "Fading":
                    countFading = power.amount;
                    break;
                case "Shifting":
                    countShifting = power.amount;
                    break;
                case "TimeMazePower":
                    countTimeMazePower = power.amount;
                    break;
                case "NoBlockPower":
                    countNoBlockPower = power.amount;
                    break;
                case "CorpseExplosionPower":
                    countCorpseExplosionPower = power.amount;
                    break;
            }
        }

        numCardsPlayedThisTurn = AbstractDungeon.actionManager.cardsPlayedThisTurn.size();
    }

}
