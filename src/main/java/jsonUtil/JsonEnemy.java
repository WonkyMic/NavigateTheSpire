package jsonUtil;

import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import java.lang.reflect.Field;

public class JsonEnemy {
    //ONE-HOT ENEMY
    int monsterIsAcidSlime_L = 0;
    int monsterIsAcidSlime_M = 0;
    int monsterIsAcidSlime_S = 0;
    int monsterIsApologySlime = 0;
    int monsterIsAwakenedOne = 0;
    int monsterIsBanditBear = 0;
    int monsterIsBanditChild = 0;
    int monsterIsBanditLeader = 0;
    int monsterIsBookOfStabbing = 0;
    int monsterIsBronzeAutomaton = 0;
    int monsterIsBronzeOrb = 0;
    int monsterIsByrd = 0;
    int monsterIsCenturion = 0;
    int monsterIsChamp = 0;
    int monsterIsChosen = 0;
    int monsterIsCorruptHeart = 0;
    int monsterIsCultist = 0;
    int monsterIsDarkling = 0;
    int monsterIsDeca = 0;
    int monsterIsDonu = 0;
    int monsterIsExploder = 0;
    int monsterIsFireOrb = 0;
    int monsterIsDagger = 0;
    int monsterIsFlameBruiser = 0;
    int monsterIsReptomancer = 0;
    int monsterIsFungiBeast = 0;
    int monsterIsFuzzyLouseDefensive = 0;
    int monsterIsFuzzyLouseNormal = 0;
    int monsterIsGiantHead = 0;
    int monsterIsGremlinFat = 0;
    int monsterIsGremlinLeader = 0;
    int monsterIsGremlinNob = 0;
    int monsterIsGremlinThief = 0;
    int monsterIsGremlinTsundere = 0;
    int monsterIsGremlinWarrior = 0;
    int monsterIsGremlinWizard = 0;
    int monsterIsHealer = 0;
    int monsterIsHexaghost = 0;
    int monsterIsHexaghostBody = 0;
    int monsterIsHexaghostOrb = 0;
    int monsterIsJawWorm = 0;
    int monsterIsLagavulin = 0;
    int monsterIsLooter = 0;
    int monsterIsMaw = 0;
    int monsterIsMugger = 0;
    int monsterIsNemesis = 0;
    int monsterIsOrbWalker = 0;
    int monsterIsPuppeteer = 0;
    int monsterIsRepulsor = 0;
    int monsterIsSentry = 0;
    int monsterIsSerpent = 0;
    int monsterIsShelledParasite = 0;
    int monsterIsSlaverBlue = 0;
    int monsterIsSlaverBoss = 0;
    int monsterIsSlaverRed = 0;
    int monsterIsSlimeBoss = 0;
    int monsterIsSnakePlant = 0;
    int monsterIsSnecko = 0;
    int monsterIsSphericGuardian = 0;
    int monsterIsSpikeSlime_L = 0;
    int monsterIsSpikeSlime_M = 0;
    int monsterIsSpikeSlime_S = 0;
    int monsterIsSpiker = 0;
    int monsterIsTheCollector = 0;
    int monsterIsTheGuardian = 0;
    int monsterIsTheGuardianOrb = 0;
    int monsterIsTimeEater = 0;
    int monsterIsTorchHead = 0;
    int monsterIsTransient = 0;


    public int currentHealth = 0;
    public int maxHealth = 0;
    public int currentBlock = 0;

    //ONE-HOT INTENT
    int intentIsNONE = 0;
    int intentIsATTACK = 0;
    int intentIsATTACK_BUFF = 0;
    int intentIsATTACK_DEBUFF = 0;
    int intentIsATTACK_DEFEND = 0;
    int intentIsBUFF = 0;
    int intentIsDEBUFF = 0;
    int intentIsSTRONG_DEBUFF = 0;
    int intentIsDEBUG = 0;
    int intentIsDEFEND = 0;
    int intentIsDEFEND_DEBUFF = 0;
    int intentIsDEFEND_BUFF = 0;
    int intentIsESCAPE = 0;
    int intentIsMAGIC = 0;
    int intentIsSLEEP = 0;
    int intentIsSTUN = 0;
    int intentIsUNKNOWN = 0;

    public int intentDamage = 0;
    public int intentBaseDamage = 0;
    public int intentMultiAmount = 0;
    public int isMultiAttack = 0;

    //ENEMY POWERS
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

    public JsonEnemy() {

    }

    public JsonEnemy(AbstractMonster m){
        switch (m.id) {
            case "AcidSlime_L":
                monsterIsAcidSlime_L = 1;
                break;
            case "AcidSlime_M":
                monsterIsAcidSlime_M = 1;
                break;
            case "AcidSlime_S":
                monsterIsAcidSlime_S = 1;
                break;
            case "ApologySlime":
                monsterIsApologySlime = 1;
                break;
            case "AwakenedOne":
                monsterIsAwakenedOne = 1;
                break;
            case "BanditBear":
                monsterIsBanditBear = 1;
                break;
            case "BanditChild":
                monsterIsBanditChild = 1;
                break;
            case "BanditLeader":
                monsterIsBanditLeader = 1;
                break;
            case "BookOfStabbing":
                monsterIsBookOfStabbing = 1;
                break;
            case "BronzeAutomaton":
                monsterIsBronzeAutomaton = 1;
                break;
            case "BronzeOrb":
                monsterIsBronzeOrb = 1;
                break;
            case "Byrd":
                monsterIsByrd = 1;
                break;
            case "Centurion":
                monsterIsCenturion = 1;
                break;
            case "Champ":
                monsterIsChamp = 1;
                break;
            case "Chosen":
                monsterIsChosen = 1;
                break;
            case "CorruptHeart":
                monsterIsCorruptHeart = 1;
                break;
            case "Cultist":
                monsterIsCultist = 1;
                break;
            case "Darkling":
                monsterIsDarkling = 1;
                break;
            case "Deca":
                monsterIsDeca = 1;
                break;
            case "Donu":
                monsterIsDonu = 1;
                break;
            case "Exploder":
                monsterIsExploder = 1;
                break;
            case "FireOrb":
                monsterIsFireOrb = 1;
                break;
            case "Dagger":
                monsterIsDagger = 1;
                break;
            case "FlameBruiser":
                monsterIsFlameBruiser = 1;
                break;
            case "Reptomancer":
                monsterIsReptomancer = 1;
                break;
            case "FungiBeast":
                monsterIsFungiBeast = 1;
                break;
            case "FuzzyLouseDefensive":
                monsterIsFuzzyLouseDefensive = 1;
                break;
            case "FuzzyLouseNormal":
                monsterIsFuzzyLouseNormal = 1;
                break;
            case "GiantHead":
                monsterIsGiantHead = 1;
                break;
            case "GremlinFat":
                monsterIsGremlinFat = 1;
                break;
            case "GremlinLeader":
                monsterIsGremlinLeader = 1;
                break;
            case "GremlinNob":
                monsterIsGremlinNob = 1;
                break;
            case "GremlinThief":
                monsterIsGremlinThief = 1;
                break;
            case "GremlinTsundere":
                monsterIsGremlinTsundere = 1;
                break;
            case "GremlinWarrior":
                monsterIsGremlinWarrior = 1;
                break;
            case "GremlinWizard":
                monsterIsGremlinWizard = 1;
                break;
            case "Healer":
                monsterIsHealer = 1;
                break;
            case "Hexaghost":
                monsterIsHexaghost = 1;
                break;
            case "HexaghostBody":
                monsterIsHexaghostBody = 1;
                break;
            case "HexaghostOrb":
                monsterIsHexaghostOrb = 1;
                break;
            case "JawWorm":
                monsterIsJawWorm = 1;
                break;
            case "Lagavulin":
                monsterIsLagavulin = 1;
                break;
            case "Looter":
                monsterIsLooter = 1;
                break;
            case "Maw":
                monsterIsMaw = 1;
                break;
            case "Mugger":
                monsterIsMugger = 1;
                break;
            case "Nemesis":
                monsterIsNemesis = 1;
                break;
            case "OrbWalker":
                monsterIsOrbWalker = 1;
                break;
            case "Puppeteer":
                monsterIsPuppeteer = 1;
                break;
            case "Repulsor":
                monsterIsRepulsor = 1;
                break;
            case "Sentry":
                monsterIsSentry = 1;
                break;
            case "Serpent":
                monsterIsSerpent = 1;
                break;
            case "ShelledParasite":
                monsterIsShelledParasite = 1;
                break;
            case "SlaverBlue":
                monsterIsSlaverBlue = 1;
                break;
            case "SlaverBoss":
                monsterIsSlaverBoss = 1;
                break;
            case "SlaverRed":
                monsterIsSlaverRed = 1;
                break;
            case "SlimeBoss":
                monsterIsSlimeBoss = 1;
                break;
            case "SnakePlant":
                monsterIsSnakePlant = 1;
                break;
            case "Snecko":
                monsterIsSnecko = 1;
                break;
            case "SphericGuardian":
                monsterIsSphericGuardian = 1;
                break;
            case "SpikeSlime_L":
                monsterIsSpikeSlime_L = 1;
                break;
            case "SpikeSlime_M":
                monsterIsSpikeSlime_M = 1;
                break;
            case "SpikeSlime_S":
                monsterIsSpikeSlime_S = 1;
                break;
            case "Spiker":
                monsterIsSpiker = 1;
                break;
            case "TheCollector":
                monsterIsTheCollector = 1;
                break;
            case "TheGuardian":
                monsterIsTheGuardian = 1;
                break;
            case "TheGuardianOrb":
                monsterIsTheGuardianOrb = 1;
                break;
            case "TimeEater":
                monsterIsTimeEater = 1;
                break;
            case "TorchHead":
                monsterIsTorchHead = 1;
                break;
            case "Transient":
                monsterIsTransient = 1;
                break;
        }
        currentHealth = m.currentHealth;
        maxHealth = m.maxHealth;
        currentBlock = m.currentBlock;
        switch(m.intent.toString()) {
            case "NONE":
                intentIsNONE = 1;
                break;
            case "ATTACK":
                intentIsATTACK = 1;
                break;
            case "ATTACK_BUFF":
                intentIsATTACK_BUFF = 1;
                break;
            case "ATTACK_DEBUFF":
                intentIsATTACK_DEBUFF = 1;
                break;
            case "ATTACK_DEFEND":
                intentIsATTACK_DEFEND = 1;
                break;
            case "BUFF":
                intentIsBUFF = 1;
                break;
            case "DEBUFF":
                intentIsDEBUFF = 1;
                break;
            case "STRONG_DEBUFF":
                intentIsSTRONG_DEBUFF = 1;
                break;
            case "DEBUG":
                intentIsDEBUG = 1;
                break;
            case "DEFEND":
                intentIsDEFEND = 1;
                break;
            case "DEFEND_DEBUFF":
                intentIsDEFEND_DEBUFF = 1;
                break;
            case "DEFEND_BUFF":
                intentIsDEFEND_BUFF = 1;
                break;
            case "ESCAPE":
                intentIsESCAPE = 1;
                break;
            case "MAGIC":
                intentIsMAGIC = 1;
                break;
            case "SLEEP":
                intentIsSLEEP = 1;
                break;
            case "STUN":
                intentIsSTUN = 1;
                break;
            case "UNKNOWN":
                intentIsUNKNOWN = 1;
                break;
            default:
                intentIsNONE = 1;
                break;
        }
        try {

            Field f1 = AbstractMonster.class.getDeclaredField("intentDmg");
            f1.setAccessible(true);
            intentDamage = (int) f1.get(m);

            Field f2 = AbstractMonster.class.getDeclaredField("intentBaseDmg");
            f2.setAccessible(true);
            intentBaseDamage = f2.getInt(m);

            Field f3 = AbstractMonster.class.getDeclaredField("intentMultiAmt");
            f3.setAccessible(true);
            intentMultiAmount = f3.getInt(m);

            Field f4 = AbstractMonster.class.getDeclaredField("isMultiDmg");
            f4.setAccessible(true);
            boolean tmp = f4.getBoolean(m);
            if(tmp)
            {
                isMultiAttack = 1;
            }
            else
            {
                isMultiAttack = 0;
            }


        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        //POPULATE ENEMY POWER FIELDS
        for (final AbstractPower power : m.powers) {
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
    }
}
