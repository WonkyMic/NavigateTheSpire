package jsonUtil;

import Map.MapUtil;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import java.util.ArrayList;
import java.util.UUID;

public class StateDataDump extends AbstractDataDump {


    UUID gameID;
    int currentStateID;
    //game information
    int floorNum;
    int actNum;

    //CURRENT ROOM
    int currentRoomIsMonster = 0;
    int currentRoomIsElite = 0;
    int currentRoomIsBoss = 0;
    int currentRoomIsEvent = 0;
    int currentRoomIsShop = 0;
    int currentRoomIsRest = 0;

    //player information
    int isIronclad = 0;
    int isSilent = 0;
    int isDefect = 0;
    int currentHealth;
    int maxHealth;

    //DECK
    int countAThousandCutsCard = 0;
    int countAccuracyCard = 0;
    int countAcrobaticsCard = 0;
    int countAdrenalineCard = 0;
    int countAfterImageCard = 0;
    int countAggregateCard = 0;
    int countAllForOneCard = 0;
    int countAllOutAttackCard = 0;
    int countAllocateCard = 0;
    int countAmplifyCard = 0;
    int countAngerCard = 0;
    int countApotheosisCard = 0;
    int countArmamentsCard = 0;
    int countAscendersBaneCard = 0;
    int countAutoShieldsCard = 0;
    int countAxeKickCard = 0;
    int countBackflipCard = 0;
    int countBackstabCard = 0;
    int countBallLightningCard = 0;
    int countBandageUpCard = 0;
    int countBaneCard = 0;
    int countBarrageCard = 0;
    int countBarricadeCard = 0;
    int countBashCard = 0;
    int countBattleTranceCard = 0;
    int countBeamCellCard = 0;
    int countBerserkCard = 0;
    int countBiasedCognitionCard = 0;
    int countBiteCard = 0;
    int countBladeDanceCard = 0;
    int countBlasterCard = 0;
    int countBlindCard = 0;
    int countBlizzardCard = 0;
    int countBloodforBloodCard = 0;
    int countBloodlettingCard = 0;
    int countBludgeonCard = 0;
    int countBlurCard = 0;
    int countBodySlamCard = 0;
    int countBootSequenceCard = 0;
    int countBouncingFlaskCard = 0;
    int countBrutalityCard = 0;
    int countBufferCard = 0;
    int countBulletTimeCard = 0;
    int countBurnCard = 0;
    int countBurningPactCard = 0;
    int countBurstCard = 0;
    int countCacheCard = 0;
    int countCalculatedGambleCard = 0;
    int countCaltropsCard = 0;
    int countCapacitorCard = 0;
    int countCarnageCard = 0;
    int countCatalystCard = 0;
    int countChannelCard = 0;
    int countChaosCard = 0;
    int countChillCard = 0;
    int countChokeCard = 0;
    int countChrysalisCard = 0;
    int countClashCard = 0;
    int countCleaveCard = 0;
    int countCloakAndDaggerCard = 0;
    int countClotheslineCard = 0;
    int countClumsyCard = 0;
    int countColdSnapCard = 0;
    int countCombustCard = 0;
    int countConcentrateCard = 0;
    int countConserveBatteryCard = 0;
    int countConsumeCard = 0;
    int countCoolheadedCard = 0;
    int countCorpseExplosionCard = 0;
    int countCorruptionCard = 0;
    int countCreativeAICard = 0;
    int countCripplingPoisonCard = 0;
    int countDaggerSprayCard = 0;
    int countDaggerThrowCard = 0;
    int countDarkEmbraceCard = 0;
    int countDarkShacklesCard = 0;
    int countDarknessCard = 0;
    int countDashCard = 0;
    int countDazedCard = 0;
    int countDeadlyPoisonCard = 0;
    int countDecayCard = 0;
    int countDeepBreathCard = 0;
    int countDefend_BCard = 0;
    int countDefend_GCard = 0;
    int countDefend_RCard = 0;
    int countDeflectCard = 0;
    int countDefragmentCard = 0;
    int countDemonFormCard = 0;
    int countDieDieDieCard = 0;
    int countDisarmCard = 0;
    int countDistractionCard = 0;
    int countDodgeandRollCard = 0;
    int countDoomandGloomCard = 0;
    int countDoppelgangerCard = 0;
    int countDoubleEnergyCard = 0;
    int countDoubleTapCard = 0;
    int countDoubtCard = 0;
    int countDramaticEntranceCard = 0;
    int countDropkickCard = 0;
    int countDualWieldCard = 0;
    int countDualcastCard = 0;
    int countEchoFormCard = 0;
    int countElectrodynamicsCard = 0;
    int countEndlessAgonyCard = 0;
    int countEnergyPulseCard = 0;
    int countEnlightenmentCard = 0;
    int countEntrenchCard = 0;
    int countEnvenomCard = 0;
    int countEscapePlanCard = 0;
    int countEviscerateCard = 0;
    int countEvolveCard = 0;
    int countExhumeCard = 0;
    int countExpertiseCard = 0;
    int countFTLCard = 0;
    int countFeedCard = 0;
    int countFeelNoPainCard = 0;
    int countFiendFireCard = 0;
    int countFinesseCard = 0;
    int countFinisherCard = 0;
    int countFireBreathingCard = 0;
    int countFissionCard = 0;
    int countFlameBarrierCard = 0;
    int countFlashofSteelCard = 0;
    int countFlechettesCard = 0;
    int countFlexCard = 0;
    int countFluxCapacitorCard = 0;
    int countFlyingKneeCard = 0;
    int countFootworkCard = 0;
    int countForceFieldCard = 0;
    int countFusionCard = 0;
    int countGashCard = 0;
    int countGeneticAlgorithmCard = 0;
    int countGhostlyCard = 0;
    int countGhostlyArmorCard = 0;
    int countGlacierCard = 0;
    int countGlassKnifeCard = 0;
    int countGofortheEyesCard = 0;
    int countGoodInstinctsCard = 0;
    int countGrandFinaleCard = 0;
    int countHavocCard = 0;
    int countHeadbuttCard = 0;
    int countHeatsinksCard = 0;
    int countHeavyBladeCard = 0;
    int countHeelHookCard = 0;
    int countHelloWorldCard = 0;
    int countHemokinesisCard = 0;
    int countHideCard = 0;
    int countHologramCard = 0;
    int countHyperbeamCard = 0;
    int countIceWallCard = 0;
    int countImmolateCard = 0;
    int countImperviousCard = 0;
    int countImpulseCard = 0;
    int countInfernalBladeCard = 0;
    int countInfiniteBladesCard = 0;
    int countInflameCard = 0;
    int countInjuryCard = 0;
    int countIntimidateCard = 0;
    int countIronWaveCard = 0;
    int countJAXCard = 0;
    int countJackOfAllTradesCard = 0;
    int countJuggernautCard = 0;
    int countLeapCard = 0;
    int countLegSweepCard = 0;
    int countLimitBreakCard = 0;
    int countLockonCard = 0;
    int countLoopCard = 0;
    int countMachineLearningCard = 0;
    int countMadnessCard = 0;
    int countMagnetismCard = 0;
    int countMalaiseCard = 0;
    int countMasterofStrategyCard = 0;
    int countMasterfulStabCard = 0;
    int countMayhemCard = 0;
    int countMelterCard = 0;
    int countMetallicizeCard = 0;
    int countMetamorphosisCard = 0;
    int countMeteorStrikeCard = 0;
    int countMindBlastCard = 0;
    int countMultiCastCard = 0;
    int countNecronomicurseCard = 0;
    int countNeutralizeCard = 0;
    int countNightTerrorCard = 0;
    int countNormalityCard = 0;
    int countNovaCard = 0;
    int countNoxiousFumesCard = 0;
    int countOfferingCard = 0;
    int countOutmaneuverCard = 0;
    int countOverclockCard = 0;
    int countPainCard = 0;
    int countPanaceaCard = 0;
    int countPanacheCard = 0;
    int countParasiteCard = 0;
    int countPerfectedStrikeCard = 0;
    int countPhantasmalKillerCard = 0;
    int countPiercingWailCard = 0;
    int countPoisonedStabCard = 0;
    int countPommelStrikeCard = 0;
    int countPowerThroughCard = 0;
    int countPredatorCard = 0;
    int countPreparedCard = 0;
    int countPrimeCard = 0;
    int countPrimitiveTechCard = 0;
    int countPummelCard = 0;
    int countPurityCard = 0;
    int countQuickSlashCard = 0;
    int countRageCard = 0;
    int countRainbowCard = 0;
    int countRampageCard = 0;
    int countReaperCard = 0;
    int countRebootCard = 0;
    int countReboundCard = 0;
    int countRecklessChargeCard = 0;
    int countRecycleCard = 0;
    int countRedoCard = 0;
    int countReflexCard = 0;
    int countRegretCard = 0;
    int countReinforcedBodyCard = 0;
    int countReprieveCard = 0;
    int countReprogramCard = 0;
    int countRiddleWithHolesCard = 0;
    int countRipandTearCard = 0;
    int countRuptureCard = 0;
    int countSadisticNatureCard = 0;
    int countScrapeCard = 0;
    int countSearingBlowCard = 0;
    int countSecondWindCard = 0;
    int countSecretTechniqueCard = 0;
    int countSecretWeaponCard = 0;
    int countSeeingRedCard = 0;
    int countSeekCard = 0;
    int countSelfRepairCard = 0;
    int countSentinelCard = 0;
    int countSetupCard = 0;
    int countSeverSoulCard = 0;
    int countShameCard = 0;
    int countShivCard = 0;
    int countShockwaveCard = 0;
    int countShrugItOffCard = 0;
    int countSkewerCard = 0;
    int countSkimCard = 0;
    int countSliceCard = 0;
    int countSlimedCard = 0;
    int countSpotWeaknessCard = 0;
    int countStackCard = 0;
    int countStaticDischargeCard = 0;
    int countSteamCard = 0;
    int countSteamPowerCard = 0;
    int countStormCard = 0;
    int countStormofSteelCard = 0;
    int countStreamlineCard = 0;
    int countStrike_BCard = 0;
    int countStrike_GCard = 0;
    int countStrike_RCard = 0;
    int countSuckerPunchCard = 0;
    int countSunderCard = 0;
    int countSurvivorCard = 0;
    int countSweepingBeamCard = 0;
    int countSwiftStrikeCard = 0;
    int countSwordBoomerangCard = 0;
    int countTacticianCard = 0;
    int countTempestCard = 0;
    int countTerrorCard = 0;
    int countTheBombCard = 0;
    int countThinkingAheadCard = 0;
    int countThunderStrikeCard = 0;
    int countThunderclapCard = 0;
    int countToolsoftheTradeCard = 0;
    int countTransmutationCard = 0;
    int countTripCard = 0;
    int countTrueGritCard = 0;
    int countTurboCard = 0;
    int countTwinStrikeCard = 0;
    int countUnderhandedStrikeCard = 0;
    int countUndoCard = 0;
    int countUnloadCard = 0;
    int countUppercutCard = 0;
    int countVenomologyCard = 0;
    int countVoidCard = 0;
    int countWarcryCard = 0;
    int countWellLaidPlansCard = 0;
    int countWhirlwindCard = 0;
    int countWhiteNoiseCard = 0;
    int countWildStrikeCard = 0;
    int countWinterCard = 0;
    int countWoundCard = 0;
    int countWraithFormv2Card = 0;
    int countWritheCard = 0;
    int countZapCard = 0;
    int countCoreSurgeCard = 0;
    int countCompileDriverCard = 0;
    int countRitualDaggerCard = 0;
    int countPrideCard = 0;
    int countPanicButtonCard = 0;
    int countHandOfGreedCard = 0;
    int countViolenceCard = 0;
    int countImpatienceCard = 0;
    int countForethoughtCard = 0;
    int countDiscoveryCard = 0;

    //POTIONS
    int potionSlot0IsAncientPotion = 0;
    int potionSlot1IsAncientPotion = 0;
    int potionSlot2IsAncientPotion = 0;
    int potionSlot3IsAncientPotion = 0;
    int potionSlot4IsAncientPotion = 0;
    int potionSlot0IsAttackPotion = 0;
    int potionSlot1IsAttackPotion = 0;
    int potionSlot2IsAttackPotion = 0;
    int potionSlot3IsAttackPotion = 0;
    int potionSlot4IsAttackPotion = 0;
    int potionSlot0IsBlockPotion = 0;
    int potionSlot1IsBlockPotion = 0;
    int potionSlot2IsBlockPotion = 0;
    int potionSlot3IsBlockPotion = 0;
    int potionSlot4IsBlockPotion = 0;
    int potionSlot0IsBloodPotion = 0;
    int potionSlot1IsBloodPotion = 0;
    int potionSlot2IsBloodPotion = 0;
    int potionSlot3IsBloodPotion = 0;
    int potionSlot4IsBloodPotion = 0;
    int potionSlot0IsDexterityPotion = 0;
    int potionSlot1IsDexterityPotion = 0;
    int potionSlot2IsDexterityPotion = 0;
    int potionSlot3IsDexterityPotion = 0;
    int potionSlot4IsDexterityPotion = 0;
    int potionSlot0IsElixir = 0;
    int potionSlot1IsElixir = 0;
    int potionSlot2IsElixir = 0;
    int potionSlot3IsElixir = 0;
    int potionSlot4IsElixir = 0;
    int potionSlot0IsEnergyPotion = 0;
    int potionSlot1IsEnergyPotion = 0;
    int potionSlot2IsEnergyPotion = 0;
    int potionSlot3IsEnergyPotion = 0;
    int potionSlot4IsEnergyPotion = 0;
    int potionSlot0IsEntropicBrew = 0;
    int potionSlot1IsEntropicBrew = 0;
    int potionSlot2IsEntropicBrew = 0;
    int potionSlot3IsEntropicBrew = 0;
    int potionSlot4IsEntropicBrew = 0;
    int potionSlot0IsEssenceOfSteel = 0;
    int potionSlot1IsEssenceOfSteel = 0;
    int potionSlot2IsEssenceOfSteel = 0;
    int potionSlot3IsEssenceOfSteel = 0;
    int potionSlot4IsEssenceOfSteel = 0;
    int potionSlot0IsExplosivePotion = 0;
    int potionSlot1IsExplosivePotion = 0;
    int potionSlot2IsExplosivePotion = 0;
    int potionSlot3IsExplosivePotion = 0;
    int potionSlot4IsExplosivePotion = 0;
    int potionSlot0IsFairyPotion = 0;
    int potionSlot1IsFairyPotion = 0;
    int potionSlot2IsFairyPotion = 0;
    int potionSlot3IsFairyPotion = 0;
    int potionSlot4IsFairyPotion = 0;
    int potionSlot0IsFearPotion = 0;
    int potionSlot1IsFearPotion = 0;
    int potionSlot2IsFearPotion = 0;
    int potionSlot3IsFearPotion = 0;
    int potionSlot4IsFearPotion = 0;
    int potionSlot0IsFirePotion = 0;
    int potionSlot1IsFirePotion = 0;
    int potionSlot2IsFirePotion = 0;
    int potionSlot3IsFirePotion = 0;
    int potionSlot4IsFirePotion = 0;
    int potionSlot0IsFocusPotion = 0;
    int potionSlot1IsFocusPotion = 0;
    int potionSlot2IsFocusPotion = 0;
    int potionSlot3IsFocusPotion = 0;
    int potionSlot4IsFocusPotion = 0;
    int potionSlot0IsFruitJuice = 0;
    int potionSlot1IsFruitJuice = 0;
    int potionSlot2IsFruitJuice = 0;
    int potionSlot3IsFruitJuice = 0;
    int potionSlot4IsFruitJuice = 0;
    int potionSlot0IsGamblersBrew = 0;
    int potionSlot1IsGamblersBrew = 0;
    int potionSlot2IsGamblersBrew = 0;
    int potionSlot3IsGamblersBrew = 0;
    int potionSlot4IsGamblersBrew = 0;
    int potionSlot0IsGhostInAJar = 0;
    int potionSlot1IsGhostInAJar = 0;
    int potionSlot2IsGhostInAJar = 0;
    int potionSlot3IsGhostInAJar = 0;
    int potionSlot4IsGhostInAJar = 0;
    int potionSlot0IsHealthPotion = 0;
    int potionSlot1IsHealthPotion = 0;
    int potionSlot2IsHealthPotion = 0;
    int potionSlot3IsHealthPotion = 0;
    int potionSlot4IsHealthPotion = 0;
    int potionSlot0IsLiquidBronze = 0;
    int potionSlot1IsLiquidBronze = 0;
    int potionSlot2IsLiquidBronze = 0;
    int potionSlot3IsLiquidBronze = 0;
    int potionSlot4IsLiquidBronze = 0;
    int potionSlot0IsPoisonPotion = 0;
    int potionSlot1IsPoisonPotion = 0;
    int potionSlot2IsPoisonPotion = 0;
    int potionSlot3IsPoisonPotion = 0;
    int potionSlot4IsPoisonPotion = 0;
    int potionSlot0IsPotionSlot = 1;
    int potionSlot1IsPotionSlot = 1;
    int potionSlot2IsPotionSlot = 1;
    int potionSlot3IsPotionSlot = 1;
    int potionSlot4IsPotionSlot = 1;
    int potionSlot0IsPowerPotion = 0;
    int potionSlot1IsPowerPotion = 0;
    int potionSlot2IsPowerPotion = 0;
    int potionSlot3IsPowerPotion = 0;
    int potionSlot4IsPowerPotion = 0;
    int potionSlot0IsRegenPotion = 0;
    int potionSlot1IsRegenPotion = 0;
    int potionSlot2IsRegenPotion = 0;
    int potionSlot3IsRegenPotion = 0;
    int potionSlot4IsRegenPotion = 0;
    int potionSlot0IsSkillPotion = 0;
    int potionSlot1IsSkillPotion = 0;
    int potionSlot2IsSkillPotion = 0;
    int potionSlot3IsSkillPotion = 0;
    int potionSlot4IsSkillPotion = 0;
    int potionSlot0IsSmokeBomb = 0;
    int potionSlot1IsSmokeBomb = 0;
    int potionSlot2IsSmokeBomb = 0;
    int potionSlot3IsSmokeBomb = 0;
    int potionSlot4IsSmokeBomb = 0;
    int potionSlot0IsSneckoOil = 0;
    int potionSlot1IsSneckoOil = 0;
    int potionSlot2IsSneckoOil = 0;
    int potionSlot3IsSneckoOil = 0;
    int potionSlot4IsSneckoOil = 0;
    int potionSlot0IsSpeedPotion = 0;
    int potionSlot1IsSpeedPotion = 0;
    int potionSlot2IsSpeedPotion = 0;
    int potionSlot3IsSpeedPotion = 0;
    int potionSlot4IsSpeedPotion = 0;
    int potionSlot0IsSteroidPotion = 0;
    int potionSlot1IsSteroidPotion = 0;
    int potionSlot2IsSteroidPotion = 0;
    int potionSlot3IsSteroidPotion = 0;
    int potionSlot4IsSteroidPotion = 0;
    int potionSlot0IsStrengthPotion = 0;
    int potionSlot1IsStrengthPotion = 0;
    int potionSlot2IsStrengthPotion = 0;
    int potionSlot3IsStrengthPotion = 0;
    int potionSlot4IsStrengthPotion = 0;
    int potionSlot0IsSwiftPotion = 0;
    int potionSlot1IsSwiftPotion = 0;
    int potionSlot2IsSwiftPotion = 0;
    int potionSlot3IsSwiftPotion = 0;
    int potionSlot4IsSwiftPotion = 0;
    int potionSlot0IsWeakPotion = 0;
    int potionSlot1IsWeakPotion = 0;
    int potionSlot2IsWeakPotion = 0;
    int potionSlot3IsWeakPotion = 0;
    int potionSlot4IsWeakPotion = 0;

    int currentGold;
    //LIST OF RELICS SEEN
    int seenAnchor = 0;
    int seenAncientTeaSet = 0;
    int seenArtofWar = 0;
    int seenAstrolabe = 0;
    int seenBagofMarbles = 0;
    int seenBagofPreparation = 0;
    int seenBirdFacedUrn = 0;
    int seenBlackBlood = 0;
    int seenBlackStar = 0;
    int seenBloodVial = 0;
    int seenBloodyIdol = 0;
    int seenBlueCandle = 0;
    int seenBottledFlame = 0;
    int seenBottledLightning = 0;
    int seenBottledTornado = 0;
    int seenBronzeScales = 0;
    int seenBurningBlood = 0;
    int seenCables = 0;
    int seenCalipers = 0;
    int seenCallingBell = 0;
    int seenCauldron = 0;
    int seenCentennialPuzzle = 0;
    int seenChameleonRing = 0;
    int seenChampionBelt = 0;
    int seenCharonsAshes = 0;
    int seenChemicalX = 0;
    int seenCirclet = 0;
    int seenCrackedCore = 0;
    int seenFrozenCore = 0;
    int seenCursedKey = 0;
    int seenDarkstonePeriapt = 0;
    int seenDataDisk = 0;
    int seenDeadBranch = 0;
    int seenDerpRock = 0;
    int seenDiscerningMonocle = 0;
    int seenDodecahedron = 0;
    int seenDreamCatcher = 0;
    int seenDuVuDoll = 0;
    int seenEctoplasm = 0;
    int seenEmotionChip = 0;
    int seenEnchiridion = 0;
    int seenEternalFeather = 0;
    int seenFrozenEgg = 0;
    int seenFrozenEgg2 = 0;
    int seenFrozenEye = 0;
    int seenGamblingChip = 0;
    int seenGinger = 0;
    int seenGirya = 0;
    int seenGoldenIdol = 0;
    int seenGremlinHorn = 0;
    int seenHappyFlower = 0;
    int seenIceCream = 0;
    int seenInserter = 0;
    int seenJuzuBracelet = 0;
    int seenKunai = 0;
    int seenLantern = 0;
    int seenLeesWaffle = 0;
    int seenLetterOpener = 0;
    int seenLivingBlade = 0;
    int seenLizardTail = 0;
    int seenMagicFlower = 0;
    int seenMango = 0;
    int seenMarkofPain = 0;
    int seenMatryoshka = 0;
    int seenMeatontheBone = 0;
    int seenMedicalKit = 0;
    int seenMembershipCard = 0;
    int seenMercuryHourglass = 0;
    int seenMoltenEgg = 0;
    int seenMoltenEgg2 = 0;
    int seenMummifiedHand = 0;
    int seenNecronomicon = 0;
    int seenNeowsBlessing = 0;
    int seenNilrysCodex = 0;
    int seenNineLives = 0;
    int seenNinjaScroll = 0;
    int seenNlothsGift = 0;
    int seenNuclearBattery = 0;
    int seenNullstonePeriapt = 0;
    int seenOddMushroom = 0;
    int seenOddlySmoothStone = 0;
    int seenOldCoin = 0;
    int seenOmamori = 0;
    int seenOrichalcum = 0;
    int seenOrnamentalFan = 0;
    int seenOrrery = 0;
    int seenPandorasBox = 0;
    int seenPantograph = 0;
    int seenPaperCrane = 0;
    int seenPaperFrog = 0;
    int seenPeacePipe = 0;
    int seenPear = 0;
    int seenPenNib = 0;
    int seenPhilosophersStone = 0;
    int seenPotionBelt = 0;
    int seenPrayerWheel = 0;
    int seenQuestionCard = 0;
    int seenRedCirclet = 0;
    int seenRedMask = 0;
    int seenRedSkull = 0;
    int seenRegalPillow = 0;
    int seenRingoftheSerpent = 0;
    int seenRingoftheSnake = 0;
    int seenRunicCapacitor = 0;
    int seenRunicCube = 0;
    int seenRunicDome = 0;
    int seenRunicPyramid = 0;
    int seenSelfFormingClay = 0;
    int seenShovel = 0;
    int seenShuriken = 0;
    int seenSingingBowl = 0;
    int seenSmilingMask = 0;
    int seenSnakeSkull = 0;
    int seenSneckoEye = 0;
    int seenSozu = 0;
    int seenSpiritPoop = 0;
    int seenStrangeSpoon = 0;
    int seenStrawberry = 0;
    int seenSundial = 0;
    int seenSymbioticVirus = 0;
    int seenTest1 = 0;
    int seenTest2 = 0;
    int seenTest3 = 0;
    int seenTest4 = 0;
    int seenTest5 = 0;
    int seenTest6 = 0;
    int seenTest7 = 0;
    int seenTest8 = 0;
    int seenTheCourier = 0;
    int seenTheSpecimen = 0;
    int seenThreadandNeedle = 0;
    int seenTingsha = 0;
    int seenTinyChest = 0;
    int seenTinyHouse = 0;
    int seenToolbox = 0;
    int seenTorii = 0;
    int seenToughBandages = 0;
    int seenToxicEgg = 0;
    int seenToxicEgg2 = 0;
    int seenToyOrnithopter = 0;
    int seenTurnip = 0;
    int seenUnceasingTop = 0;
    int seenVajra = 0;
    int seenVelvetChoker = 0;
    int seenWarPaint = 0;
    int seenWhetstone = 0;
    int seenWhiteBeastStatue = 0;
    int seenBoot = 0;
    int seenMarkoftheBloom = 0;
    int seenBustedCrown = 0;
    int seenIncenseBurner = 0;
    int seenEmptyCage = 0;
    int seenFusionHammer = 0;
    int seenCoffeeDripper = 0;
    int seenSsserpentHead = 0;
    int seenMutagenicStrength = 0;
    int seenFaceOfCleric = 0;
    int seenNlothsMask = 0;
    int seenGremlinMask = 0;
    int seenCultistMask = 0;
    int seenTheAbacus = 0;
    int seenDollysMirror = 0;
    int seenClockworkSouvenir = 0;
    int seenMealTicket = 0;
    int seenTwistedFunnel = 0;
    int seenHandDrill = 0;
    int seenHoveringKite = 0;
    int seenSling = 0;
    int seenOrangePellets = 0;
    int seenWristBlade = 0;
    int seenStoneCalendar = 0;
    int seenNunchaku = 0;
    int seenBrimstone = 0;
    int seenPreservedInsect = 0;
    int seenPocketwatch = 0;
    int seenFossilizedHelix = 0;
    int seenPrismaticShard = 0;
    int seenWarpedTongs = 0;
    int seenWingedGreaves = 0;
    int seenMawBank = 0;

    transient ArrayList<String> availablePathArrayList = new ArrayList<String>();


    //LIST OF RELICS OWNED
    int hasAnchor = 0;
    int hasAncientTeaSet = 0;
    int hasArtofWar = 0;
    int hasAstrolabe = 0;
    int hasBagofMarbles = 0;
    int hasBagofPreparation = 0;
    int hasBirdFacedUrn = 0;
    int hasBlackBlood = 0;
    int hasBlackStar = 0;
    int hasBloodVial = 0;
    int hasBloodyIdol = 0;
    int hasBlueCandle = 0;
    int hasBottledFlame = 0;
    int hasBottledLightning = 0;
    int hasBottledTornado = 0;
    int hasBronzeScales = 0;
    int hasBurningBlood = 0;
    int hasCables = 0;
    int hasCalipers = 0;
    int hasCallingBell = 0;
    int hasCauldron = 0;
    int hasCentennialPuzzle = 0;
    int hasChameleonRing = 0;
    int hasChampionBelt = 0;
    int hasCharonsAshes = 0;
    int hasChemicalX = 0;
    int hasCirclet = 0;
    int hasCrackedCore = 0;
    int hasFrozenCore = 0;
    int hasCursedKey = 0;
    int hasDarkstonePeriapt = 0;
    int hasDataDisk = 0;
    int hasDeadBranch = 0;
    int hasDerpRock = 0;
    int hasDiscerningMonocle = 0;
    int hasDodecahedron = 0;
    int hasDreamCatcher = 0;
    int hasDuVuDoll = 0;
    int hasEctoplasm = 0;
    int hasEmotionChip = 0;
    int hasEnchiridion = 0;
    int hasEternalFeather = 0;
    int hasFrozenEgg = 0;
    int hasFrozenEgg2 = 0;
    int hasFrozenEye = 0;
    int hasGamblingChip = 0;
    int hasGinger = 0;
    int hasGirya = 0;
    int hasGoldenIdol = 0;
    int hasGremlinHorn = 0;
    int hasHappyFlower = 0;
    int hasIceCream = 0;
    int hasInserter = 0;
    int hasJuzuBracelet = 0;
    int hasKunai = 0;
    int hasLantern = 0;
    int hasLeesWaffle = 0;
    int hasLetterOpener = 0;
    int hasLivingBlade = 0;
    int hasLizardTail = 0;
    int hasMagicFlower = 0;
    int hasMango = 0;
    int hasMarkofPain = 0;
    int hasMatryoshka = 0;
    int hasMeatontheBone = 0;
    int hasMedicalKit = 0;
    int hasMembershipCard = 0;
    int hasMercuryHourglass = 0;
    int hasMoltenEgg = 0;
    int hasMoltenEgg2 = 0;
    int hasMummifiedHand = 0;
    int hasNecronomicon = 0;
    int hasNeowsBlessing = 0;
    int hasNilrysCodex = 0;
    int hasNineLives = 0;
    int hasNinjaScroll = 0;
    int hasNlothsGift = 0;
    int hasNuclearBattery = 0;
    int hasNullstonePeriapt = 0;
    int hasOddMushroom = 0;
    int hasOddlySmoothStone = 0;
    int hasOldCoin = 0;
    int hasOmamori = 0;
    int hasOrichalcum = 0;
    int hasOrnamentalFan = 0;
    int hasOrrery = 0;
    int hasPandorasBox = 0;
    int hasPantograph = 0;
    int hasPaperCrane = 0;
    int hasPaperFrog = 0;
    int hasPeacePipe = 0;
    int hasPear = 0;
    int hasPenNib = 0;
    int hasPhilosophersStone = 0;
    int hasPotionBelt = 0;
    int hasPrayerWheel = 0;
    int hasQuestionCard = 0;
    int hasRedCirclet = 0;
    int hasRedMask = 0;
    int hasRedSkull = 0;
    int hasRegalPillow = 0;
    int hasRingoftheSerpent = 0;
    int hasRingoftheSnake = 0;
    int hasRunicCapacitor = 0;
    int hasRunicCube = 0;
    int hasRunicDome = 0;
    int hasRunicPyramid = 0;
    int hasSelfFormingClay = 0;
    int hasShovel = 0;
    int hasShuriken = 0;
    int hasSingingBowl = 0;
    int hasSmilingMask = 0;
    int hasSnakeSkull = 0;
    int hasSneckoEye = 0;
    int hasSozu = 0;
    int hasSpiritPoop = 0;
    int hasStrangeSpoon = 0;
    int hasStrawberry = 0;
    int hasSundial = 0;
    int hasSymbioticVirus = 0;
    int hasTest1 = 0;
    int hasTest2 = 0;
    int hasTest3 = 0;
    int hasTest4 = 0;
    int hasTest5 = 0;
    int hasTest6 = 0;
    int hasTest7 = 0;
    int hasTest8 = 0;
    int hasTheCourier = 0;
    int hasTheSpecimen = 0;
    int hasThreadandNeedle = 0;
    int hasTingsha = 0;
    int hasTinyChest = 0;
    int hasTinyHouse = 0;
    int hasToolbox = 0;
    int hasTorii = 0;
    int hasToughBandages = 0;
    int hasToxicEgg = 0;
    int hasToxicEgg2 = 0;
    int hasToyOrnithopter = 0;
    int hasTurnip = 0;
    int hasUnceasingTop = 0;
    int hasVajra = 0;
    int hasVelvetChoker = 0;
    int hasWarPaint = 0;
    int hasWhetstone = 0;
    int hasWhiteBeastStatue = 0;
    int hasBoot = 0;
    int hasMarkoftheBloom = 0;
    int hasBustedCrown = 0;
    int hasIncenseBurner = 0;
    int hasEmptyCage = 0;
    int hasFusionHammer = 0;
    int hasCoffeeDripper = 0;
    int hasSsserpentHead = 0;
    int hasMutagenicStrength = 0;
    int hasFaceOfCleric = 0;
    int hasNlothsMask = 0;
    int hasGremlinMask = 0;
    int hasCultistMask = 0;
    int hasTheAbacus = 0;
    int hasDollysMirror = 0;
    int hasClockworkSouvenir = 0;
    int hasMealTicket = 0;
    int hasTwistedFunnel = 0;
    int hasHandDrill = 0;
    int hasHoveringKite = 0;
    int hasSling = 0;
    int hasOrangePellets = 0;
    int hasWristBlade = 0;
    int hasStoneCalendar = 0;
    int hasNunchaku = 0;
    int hasBrimstone = 0;
    int hasPreservedInsect = 0;
    int hasPocketwatch = 0;
    int hasFossilizedHelix = 0;
    int hasPrismaticShard = 0;
    int hasWarpedTongs = 0;
    int hasWingedGreaves = 0;
    int hasMawBank = 0;


    int countAnchor = -1;
    int countAncientTeaSet = -1;
    int countArtofWar = -1;
    int countAstrolabe = -1;
    int countBagofMarbles = -1;
    int countBagofPreparation = -1;
    int countBirdFacedUrn = -1;
    int countBlackBlood = -1;
    int countBlackStar = -1;
    int countBloodVial = -1;
    int countBloodyIdol = -1;
    int countBlueCandle = -1;
    int countBottledFlame = -1;
    int countBottledLightning = -1;
    int countBottledTornado = -1;
    int countBronzeScales = -1;
    int countBurningBlood = -1;
    int countCables = -1;
    int countCalipers = -1;
    int countCallingBell = -1;
    int countCauldron = -1;
    int countCentennialPuzzle = -1;
    int countChameleonRing = -1;
    int countChampionBelt = -1;
    int countCharonsAshes = -1;
    int countChemicalX = -1;
    int countCirclet = -1;
    int countCrackedCore = -1;
    int countFrozenCore = -1;
    int countCursedKey = -1;
    int countDarkstonePeriapt = -1;
    int countDataDisk = -1;
    int countDeadBranch = -1;
    int countDerpRock = -1;
    int countDiscerningMonocle = -1;
    int countDodecahedron = -1;
    int countDreamCatcher = -1;
    int countDuVuDoll = -1;
    int countEctoplasm = -1;
    int countEmotionChip = -1;
    int countEnchiridion = -1;
    int countEternalFeather = -1;
    int countFrozenEgg = -1;
    int countFrozenEgg2 = -1;
    int countFrozenEye = -1;
    int countGamblingChip = -1;
    int countGinger = -1;
    int countGirya = -1;
    int countGoldenIdol = -1;
    int countGremlinHorn = -1;
    int countHappyFlower = -1;
    int countIceCream = -1;
    int countInserter = -1;
    int countJuzuBracelet = -1;
    int countKunai = -1;
    int countLantern = -1;
    int countLeesWaffle = -1;
    int countLetterOpener = -1;
    int countLivingBlade = -1;
    int countLizardTail = -1;
    int countMagicFlower = -1;
    int countMango = -1;
    int countMarkofPain = -1;
    int countMatryoshka = -1;
    int countMeatontheBone = -1;
    int countMedicalKit = -1;
    int countMembershipCard = -1;
    int countMercuryHourglass = -1;
    int countMoltenEgg = -1;
    int countMoltenEgg2 = -1;
    int countMummifiedHand = -1;
    int countNecronomicon = -1;
    int countNeowsBlessing = -1;
    int countNilrysCodex = -1;
    int countNineLives = -1;
    int countNinjaScroll = -1;
    int countNlothsGift = -1;
    int countNuclearBattery = -1;
    int countNullstonePeriapt = -1;
    int countOddMushroom = -1;
    int countOddlySmoothStone = -1;
    int countOldCoin = -1;
    int countOmamori = -1;
    int countOrichalcum = -1;
    int countOrnamentalFan = -1;
    int countOrrery = -1;
    int countPandorasBox = -1;
    int countPantograph = -1;
    int countPaperCrane = -1;
    int countPaperFrog = -1;
    int countPeacePipe = -1;
    int countPear = -1;
    int countPenNib = -1;
    int countPhilosophersStone = -1;
    int countPotionBelt = -1;
    int countPrayerWheel = -1;
    int countQuestionCard = -1;
    int countRedCirclet = -1;
    int countRedMask = -1;
    int countRedSkull = -1;
    int countRegalPillow = -1;
    int countRingoftheSerpent = -1;
    int countRingoftheSnake = -1;
    int countRunicCapacitor = -1;
    int countRunicCube = -1;
    int countRunicDome = -1;
    int countRunicPyramid = -1;
    int countSelfFormingClay = -1;
    int countShovel = -1;
    int countShuriken = -1;
    int countSingingBowl = -1;
    int countSmilingMask = -1;
    int countSnakeSkull = -1;
    int countSneckoEye = -1;
    int countSozu = -1;
    int countSpiritPoop = -1;
    int countStrangeSpoon = -1;
    int countStrawberry = -1;
    int countSundial = -1;
    int countSymbioticVirus = -1;
    int countTest1 = -1;
    int countTest2 = -1;
    int countTest3 = -1;
    int countTest4 = -1;
    int countTest5 = -1;
    int countTest6 = -1;
    int countTest7 = -1;
    int countTest8 = -1;
    int countTheCourier = -1;
    int countTheSpecimen = -1;
    int countThreadandNeedle = -1;
    int countTingsha = -1;
    int countTinyChest = -1;
    int countTinyHouse = -1;
    int countToolbox = -1;
    int countTorii = -1;
    int countToughBandages = -1;
    int countToxicEgg = -1;
    int countToxicEgg2 = -1;
    int countToyOrnithopter = -1;
    int countTurnip = -1;
    int countUnceasingTop = -1;
    int countVajra = -1;
    int countVelvetChoker = -1;
    int countWarPaint = -1;
    int countWhetstone = -1;
    int countWhiteBeastStatue = -1;
    int countBoot = -1;
    int countMarkoftheBloom = -1;
    int countBustedCrown = -1;
    int countIncenseBurner = -1;
    int countEmptyCage = -1;
    int countFusionHammer = -1;
    int countCoffeeDripper = -1;
    int countSsserpentHead = -1;
    int countMutagenicStrength = -1;
    int countFaceOfCleric = -1;
    int countNlothsMask = -1;
    int countGremlinMask = -1;
    int countCultistMask = -1;
    int countTheAbacus = -1;
    int countDollysMirror = -1;
    int countClockworkSouvenir = -1;
    int countMealTicket = -1;
    int countTwistedFunnel = -1;
    int countHandDrill = -1;
    int countHoveringKite = -1;
    int countSling = -1;
    int countOrangePellets = -1;
    int countWristBlade = -1;
    int countStoneCalendar = -1;
    int countNunchaku = -1;
    int countBrimstone = -1;
    int countPreservedInsect = -1;
    int countPocketwatch = -1;
    int countFossilizedHelix = -1;
    int countPrismaticShard = -1;
    int countWarpedTongs = -1;
    int countWingedGreaves = -1;
    int countMawBank = -1;




    public void updateStateDataForJson() {

        gameID = JsonDump.gameID;
        JsonDump.currentStateID++;
        currentStateID = JsonDump.currentStateID;
        floorNum = AbstractDungeon.floorNum;
        actNum = AbstractDungeon.actNum;
        if (AbstractDungeon.getCurrRoom().getMapSymbol() != null) {
            switch (AbstractDungeon.getCurrRoom().getMapSymbol()) {
                case "M":
                    currentRoomIsMonster = 1;
                    break;
                case "E":
                    currentRoomIsElite = 1;
                    break;
                case "B":
                    currentRoomIsBoss = 1;
                    break;
                case "?":
                    currentRoomIsEvent = 1;
                    break;
                case "$":
                    currentRoomIsShop = 1;
                    break;
                case "R":
                    currentRoomIsRest = 1;
                    break;
                default:
                    break;
            }
        }
        //MapUtil mUtil = new MapUtil();
        //availablePathArrayList = mUtil.createAvailablePathArrayList(AbstractDungeon.getCurrMapNode());

        AbstractPlayer p = AbstractDungeon.player;

        //get player information

        switch(p.chosenClass.toString())
        {
            case "IRONCLAD":
                isIronclad = 1;
                break;
            case "SILENT":
                isSilent = 1;
                break;
            case "DEFECT":
                isDefect = 1;
                break;
        }
        currentHealth = p.currentHealth;
        maxHealth = p.maxHealth;
        if (p.masterDeck.group != null) {
            for (final AbstractCard card : p.masterDeck.group) {
                switch(card.cardID) {
                    case "A Thousand Cuts":
                        countAThousandCutsCard++;
                        break;
                    case "Accuracy":
                        countAccuracyCard++;
                        break;
                    case "Acrobatics":
                        countAcrobaticsCard++;
                        break;
                    case "Adrenaline":
                        countAdrenalineCard++;
                        break;
                    case "After Image":
                        countAfterImageCard++;
                        break;
                    case "Aggregate":
                        countAggregateCard++;
                        break;
                    case "All For One":
                        countAllForOneCard++;
                        break;
                    case "All Out Attack":
                        countAllOutAttackCard++;
                        break;
                    case "Allocate":
                        countAllocateCard++;
                        break;
                    case "Amplify":
                        countAmplifyCard++;
                        break;
                    case "Anger":
                        countAngerCard++;
                        break;
                    case "Apotheosis":
                        countApotheosisCard++;
                        break;
                    case "Armaments":
                        countArmamentsCard++;
                        break;
                    case "AscendersBane":
                        countAscendersBaneCard++;
                        break;
                    case "Auto Shields":
                        countAutoShieldsCard++;
                        break;
                    case "Axe Kick":
                        countAxeKickCard++;
                        break;
                    case "Backflip":
                        countBackflipCard++;
                        break;
                    case "Backstab":
                        countBackstabCard++;
                        break;
                    case "Ball Lightning":
                        countBallLightningCard++;
                        break;
                    case "Bandage Up":
                        countBandageUpCard++;
                        break;
                    case "Bane":
                        countBaneCard++;
                        break;
                    case "Barrage":
                        countBarrageCard++;
                        break;
                    case "Barricade":
                        countBarricadeCard++;
                        break;
                    case "Bash":
                        countBashCard++;
                        break;
                    case "Battle Trance":
                        countBattleTranceCard++;
                        break;
                    case "Beam Cell":
                        countBeamCellCard++;
                        break;
                    case "Berserk":
                        countBerserkCard++;
                        break;
                    case "Biased Cognition":
                        countBiasedCognitionCard++;
                        break;
                    case "Bite":
                        countBiteCard++;
                        break;
                    case "Blade Dance":
                        countBladeDanceCard++;
                        break;
                    case "Blaster":
                        countBlasterCard++;
                        break;
                    case "Blind":
                        countBlindCard++;
                        break;
                    case "Blizzard":
                        countBlizzardCard++;
                        break;
                    case "Blood for Blood":
                        countBloodforBloodCard++;
                        break;
                    case "Bloodletting":
                        countBloodlettingCard++;
                        break;
                    case "Bludgeon":
                        countBludgeonCard++;
                        break;
                    case "Blur":
                        countBlurCard++;
                        break;
                    case "Body Slam":
                        countBodySlamCard++;
                        break;
                    case "BootSequence":
                        countBootSequenceCard++;
                        break;
                    case "Bouncing Flask":
                        countBouncingFlaskCard++;
                        break;
                    case "Brutality":
                        countBrutalityCard++;
                        break;
                    case "Buffer":
                        countBufferCard++;
                        break;
                    case "Bullet Time":
                        countBulletTimeCard++;
                        break;
                    case "Burn":
                        countBurnCard++;
                        break;
                    case "Burning Pact":
                        countBurningPactCard++;
                        break;
                    case "Burst":
                        countBurstCard++;
                        break;
                    case "Cache":
                        countCacheCard++;
                        break;
                    case "Calculated Gamble":
                        countCalculatedGambleCard++;
                        break;
                    case "Caltrops":
                        countCaltropsCard++;
                        break;
                    case "Capacitor":
                        countCapacitorCard++;
                        break;
                    case "Carnage":
                        countCarnageCard++;
                        break;
                    case "Catalyst":
                        countCatalystCard++;
                        break;
                    case "Channel":
                        countChannelCard++;
                        break;
                    case "Chaos":
                        countChaosCard++;
                        break;
                    case "Chill":
                        countChillCard++;
                        break;
                    case "Choke":
                        countChokeCard++;
                        break;
                    case "Chrysalis":
                        countChrysalisCard++;
                        break;
                    case "Clash":
                        countClashCard++;
                        break;
                    case "Cleave":
                        countCleaveCard++;
                        break;
                    case "Cloak And Dagger":
                        countCloakAndDaggerCard++;
                        break;
                    case "Clothesline":
                        countClotheslineCard++;
                        break;
                    case "Clumsy":
                        countClumsyCard++;
                        break;
                    case "Cold Snap":
                        countColdSnapCard++;
                        break;
                    case "Combust":
                        countCombustCard++;
                        break;
                    case "Concentrate":
                        countConcentrateCard++;
                        break;
                    case "Conserve Battery":
                        countConserveBatteryCard++;
                        break;
                    case "Consume":
                        countConsumeCard++;
                        break;
                    case "Coolheaded":
                        countCoolheadedCard++;
                        break;
                    case "Corpse Explosion":
                        countCorpseExplosionCard++;
                        break;
                    case "Corruption":
                        countCorruptionCard++;
                        break;
                    case "Creative AI":
                        countCreativeAICard++;
                        break;
                    case "Crippling Poison":
                        countCripplingPoisonCard++;
                        break;
                    case "Dagger Spray":
                        countDaggerSprayCard++;
                        break;
                    case "Dagger Throw":
                        countDaggerThrowCard++;
                        break;
                    case "Dark Embrace":
                        countDarkEmbraceCard++;
                        break;
                    case "Dark Shackles":
                        countDarkShacklesCard++;
                        break;
                    case "Darkness":
                        countDarknessCard++;
                        break;
                    case "Dash":
                        countDashCard++;
                        break;
                    case "Dazed":
                        countDazedCard++;
                        break;
                    case "Deadly Poison":
                        countDeadlyPoisonCard++;
                        break;
                    case "Decay":
                        countDecayCard++;
                        break;
                    case "Deep Breath":
                        countDeepBreathCard++;
                        break;
                    case "Defend_B":
                        countDefend_BCard++;
                        break;
                    case "Defend_G":
                        countDefend_GCard++;
                        break;
                    case "Defend_R":
                        countDefend_RCard++;
                        break;
                    case "Deflect":
                        countDeflectCard++;
                        break;
                    case "Defragment":
                        countDefragmentCard++;
                        break;
                    case "Demon Form":
                        countDemonFormCard++;
                        break;
                    case "Die Die Die":
                        countDieDieDieCard++;
                        break;
                    case "Disarm":
                        countDisarmCard++;
                        break;
                    case "Distraction":
                        countDistractionCard++;
                        break;
                    case "Dodge and Roll":
                        countDodgeandRollCard++;
                        break;
                    case "Doom and Gloom":
                        countDoomandGloomCard++;
                        break;
                    case "Doppelganger":
                        countDoppelgangerCard++;
                        break;
                    case "Double Energy":
                        countDoubleEnergyCard++;
                        break;
                    case "Double Tap":
                        countDoubleTapCard++;
                        break;
                    case "Doubt":
                        countDoubtCard++;
                        break;
                    case "Dramatic Entrance":
                        countDramaticEntranceCard++;
                        break;
                    case "Dropkick":
                        countDropkickCard++;
                        break;
                    case "Dual Wield":
                        countDualWieldCard++;
                        break;
                    case "Dualcast":
                        countDualcastCard++;
                        break;
                    case "Echo Form":
                        countEchoFormCard++;
                        break;
                    case "Electrodynamics":
                        countElectrodynamicsCard++;
                        break;
                    case "Endless Agony":
                        countEndlessAgonyCard++;
                        break;
                    case "Energy Pulse":
                        countEnergyPulseCard++;
                        break;
                    case "Enlightenment":
                        countEnlightenmentCard++;
                        break;
                    case "Entrench":
                        countEntrenchCard++;
                        break;
                    case "Envenom":
                        countEnvenomCard++;
                        break;
                    case "Escape Plan":
                        countEscapePlanCard++;
                        break;
                    case "Eviscerate":
                        countEviscerateCard++;
                        break;
                    case "Evolve":
                        countEvolveCard++;
                        break;
                    case "Exhume":
                        countExhumeCard++;
                        break;
                    case "Expertise":
                        countExpertiseCard++;
                        break;
                    case "FTL":
                        countFTLCard++;
                        break;
                    case "Feed":
                        countFeedCard++;
                        break;
                    case "Feel No Pain":
                        countFeelNoPainCard++;
                        break;
                    case "Fiend Fire":
                        countFiendFireCard++;
                        break;
                    case "Finesse":
                        countFinesseCard++;
                        break;
                    case "Finisher":
                        countFinisherCard++;
                        break;
                    case "Fire Breathing":
                        countFireBreathingCard++;
                        break;
                    case "Fission":
                        countFissionCard++;
                        break;
                    case "Flame Barrier":
                        countFlameBarrierCard++;
                        break;
                    case "Flash of Steel":
                        countFlashofSteelCard++;
                        break;
                    case "Flechettes":
                        countFlechettesCard++;
                        break;
                    case "Flex":
                        countFlexCard++;
                        break;
                    case "Flux Capacitor":
                        countFluxCapacitorCard++;
                        break;
                    case "Flying Knee":
                        countFlyingKneeCard++;
                        break;
                    case "Footwork":
                        countFootworkCard++;
                        break;
                    case "Force Field":
                        countForceFieldCard++;
                        break;
                    case "Fusion":
                        countFusionCard++;
                        break;
                    case "Gash":
                        countGashCard++;
                        break;
                    case "Genetic Algorithm":
                        countGeneticAlgorithmCard++;
                        break;
                    case "Ghostly":
                        countGhostlyCard++;
                        break;
                    case "Ghostly Armor":
                        countGhostlyArmorCard++;
                        break;
                    case "Glacier":
                        countGlacierCard++;
                        break;
                    case "Glass Knife":
                        countGlassKnifeCard++;
                        break;
                    case "Go for the Eyes":
                        countGofortheEyesCard++;
                        break;
                    case "Good Instincts":
                        countGoodInstinctsCard++;
                        break;
                    case "Grand Finale":
                        countGrandFinaleCard++;
                        break;
                    case "Havoc":
                        countHavocCard++;
                        break;
                    case "Headbutt":
                        countHeadbuttCard++;
                        break;
                    case "Heatsinks":
                        countHeatsinksCard++;
                        break;
                    case "Heavy Blade":
                        countHeavyBladeCard++;
                        break;
                    case "Heel Hook":
                        countHeelHookCard++;
                        break;
                    case "Hello World":
                        countHelloWorldCard++;
                        break;
                    case "Hemokinesis":
                        countHemokinesisCard++;
                        break;
                    case "Hide":
                        countHideCard++;
                        break;
                    case "Hologram":
                        countHologramCard++;
                        break;
                    case "Hyperbeam":
                        countHyperbeamCard++;
                        break;
                    case "Ice Wall":
                        countIceWallCard++;
                        break;
                    case "Immolate":
                        countImmolateCard++;
                        break;
                    case "Impervious":
                        countImperviousCard++;
                        break;
                    case "Impulse":
                        countImpulseCard++;
                        break;
                    case "Infernal Blade":
                        countInfernalBladeCard++;
                        break;
                    case "Infinite Blades":
                        countInfiniteBladesCard++;
                        break;
                    case "Inflame":
                        countInflameCard++;
                        break;
                    case "Injury":
                        countInjuryCard++;
                        break;
                    case "Intimidate":
                        countIntimidateCard++;
                        break;
                    case "Iron Wave":
                        countIronWaveCard++;
                        break;
                    case "JAX":
                        countJAXCard++;
                        break;
                    case "Jack Of All Trades":
                        countJackOfAllTradesCard++;
                        break;
                    case "Juggernaut":
                        countJuggernautCard++;
                        break;
                    case "Leap":
                        countLeapCard++;
                        break;
                    case "Leg Sweep":
                        countLegSweepCard++;
                        break;
                    case "Limit Break":
                        countLimitBreakCard++;
                        break;
                    case "Lockon":
                        countLockonCard++;
                        break;
                    case "Loop":
                        countLoopCard++;
                        break;
                    case "Machine Learning":
                        countMachineLearningCard++;
                        break;
                    case "Madness":
                        countMadnessCard++;
                        break;
                    case "Magnetism":
                        countMagnetismCard++;
                        break;
                    case "Malaise":
                        countMalaiseCard++;
                        break;
                    case "Master of Strategy":
                        countMasterofStrategyCard++;
                        break;
                    case "Masterful Stab":
                        countMasterfulStabCard++;
                        break;
                    case "Mayhem":
                        countMayhemCard++;
                        break;
                    case "Melter":
                        countMelterCard++;
                        break;
                    case "Metallicize":
                        countMetallicizeCard++;
                        break;
                    case "Metamorphosis":
                        countMetamorphosisCard++;
                        break;
                    case "Meteor Strike":
                        countMeteorStrikeCard++;
                        break;
                    case "Mind Blast":
                        countMindBlastCard++;
                        break;
                    case "Multi-Cast":
                        countMultiCastCard++;
                        break;
                    case "Necronomicurse":
                        countNecronomicurseCard++;
                        break;
                    case "Neutralize":
                        countNeutralizeCard++;
                        break;
                    case "Night Terror":
                        countNightTerrorCard++;
                        break;
                    case "Normality":
                        countNormalityCard++;
                        break;
                    case "Nova":
                        countNovaCard++;
                        break;
                    case "Noxious Fumes":
                        countNoxiousFumesCard++;
                        break;
                    case "Offering":
                        countOfferingCard++;
                        break;
                    case "Outmaneuver":
                        countOutmaneuverCard++;
                        break;
                    case "Overclock":
                        countOverclockCard++;
                        break;
                    case "Pain":
                        countPainCard++;
                        break;
                    case "Panacea":
                        countPanaceaCard++;
                        break;
                    case "Panache":
                        countPanacheCard++;
                        break;
                    case "Parasite":
                        countParasiteCard++;
                        break;
                    case "Perfected Strike":
                        countPerfectedStrikeCard++;
                        break;
                    case "Phantasmal Killer":
                        countPhantasmalKillerCard++;
                        break;
                    case "PiercingWail":
                        countPiercingWailCard++;
                        break;
                    case "Poisoned Stab":
                        countPoisonedStabCard++;
                        break;
                    case "Pommel Strike":
                        countPommelStrikeCard++;
                        break;
                    case "Power Through":
                        countPowerThroughCard++;
                        break;
                    case "Predator":
                        countPredatorCard++;
                        break;
                    case "Prepared":
                        countPreparedCard++;
                        break;
                    case "Prime":
                        countPrimeCard++;
                        break;
                    case "Primitive Tech":
                        countPrimitiveTechCard++;
                        break;
                    case "Pummel":
                        countPummelCard++;
                        break;
                    case "Purity":
                        countPurityCard++;
                        break;
                    case "Quick Slash":
                        countQuickSlashCard++;
                        break;
                    case "Rage":
                        countRageCard++;
                        break;
                    case "Rainbow":
                        countRainbowCard++;
                        break;
                    case "Rampage":
                        countRampageCard++;
                        break;
                    case "Reaper":
                        countReaperCard++;
                        break;
                    case "Reboot":
                        countRebootCard++;
                        break;
                    case "Rebound":
                        countReboundCard++;
                        break;
                    case "Reckless Charge":
                        countRecklessChargeCard++;
                        break;
                    case "Recycle":
                        countRecycleCard++;
                        break;
                    case "Redo":
                        countRedoCard++;
                        break;
                    case "Reflex":
                        countReflexCard++;
                        break;
                    case "Regret":
                        countRegretCard++;
                        break;
                    case "Reinforced Body":
                        countReinforcedBodyCard++;
                        break;
                    case "Reprieve":
                        countReprieveCard++;
                        break;
                    case "Reprogram":
                        countReprogramCard++;
                        break;
                    case "Riddle With Holes":
                        countRiddleWithHolesCard++;
                        break;
                    case "Rip and Tear":
                        countRipandTearCard++;
                        break;
                    case "Rupture":
                        countRuptureCard++;
                        break;
                    case "Sadistic Nature":
                        countSadisticNatureCard++;
                        break;
                    case "Scrape":
                        countScrapeCard++;
                        break;
                    case "Searing Blow":
                        countSearingBlowCard++;
                        break;
                    case "Second Wind":
                        countSecondWindCard++;
                        break;
                    case "Secret Technique":
                        countSecretTechniqueCard++;
                        break;
                    case "Secret Weapon":
                        countSecretWeaponCard++;
                        break;
                    case "Seeing Red":
                        countSeeingRedCard++;
                        break;
                    case "Seek":
                        countSeekCard++;
                        break;
                    case "Self Repair":
                        countSelfRepairCard++;
                        break;
                    case "Sentinel":
                        countSentinelCard++;
                        break;
                    case "Setup":
                        countSetupCard++;
                        break;
                    case "Sever Soul":
                        countSeverSoulCard++;
                        break;
                    case "Shame":
                        countShameCard++;
                        break;
                    case "Shiv":
                        countShivCard++;
                        break;
                    case "Shockwave":
                        countShockwaveCard++;
                        break;
                    case "Shrug It Off":
                        countShrugItOffCard++;
                        break;
                    case "Skewer":
                        countSkewerCard++;
                        break;
                    case "Skim":
                        countSkimCard++;
                        break;
                    case "Slice":
                        countSliceCard++;
                        break;
                    case "Slimed":
                        countSlimedCard++;
                        break;
                    case "Spot Weakness":
                        countSpotWeaknessCard++;
                        break;
                    case "Stack":
                        countStackCard++;
                        break;
                    case "Static Discharge":
                        countStaticDischargeCard++;
                        break;
                    case "Steam":
                        countSteamCard++;
                        break;
                    case "Steam Power":
                        countSteamPowerCard++;
                        break;
                    case "Storm":
                        countStormCard++;
                        break;
                    case "Storm of Steel":
                        countStormofSteelCard++;
                        break;
                    case "Streamline":
                        countStreamlineCard++;
                        break;
                    case "Strike_B":
                        countStrike_BCard++;
                        break;
                    case "Strike_G":
                        countStrike_GCard++;
                        break;
                    case "Strike_R":
                        countStrike_RCard++;
                        break;
                    case "Sucker Punch":
                        countSuckerPunchCard++;
                        break;
                    case "Sunder":
                        countSunderCard++;
                        break;
                    case "Survivor":
                        countSurvivorCard++;
                        break;
                    case "Sweeping Beam":
                        countSweepingBeamCard++;
                        break;
                    case "Swift Strike":
                        countSwiftStrikeCard++;
                        break;
                    case "Sword Boomerang":
                        countSwordBoomerangCard++;
                        break;
                    case "Tactician":
                        countTacticianCard++;
                        break;
                    case "Tempest":
                        countTempestCard++;
                        break;
                    case "Terror":
                        countTerrorCard++;
                        break;
                    case "The Bomb":
                        countTheBombCard++;
                        break;
                    case "Thinking Ahead":
                        countThinkingAheadCard++;
                        break;
                    case "Thunder Strike":
                        countThunderStrikeCard++;
                        break;
                    case "Thunderclap":
                        countThunderclapCard++;
                        break;
                    case "Tools of the Trade":
                        countToolsoftheTradeCard++;
                        break;
                    case "Transmutation":
                        countTransmutationCard++;
                        break;
                    case "Trip":
                        countTripCard++;
                        break;
                    case "True Grit":
                        countTrueGritCard++;
                        break;
                    case "Turbo":
                        countTurboCard++;
                        break;
                    case "Twin Strike":
                        countTwinStrikeCard++;
                        break;
                    case "Underhanded Strike":
                        countUnderhandedStrikeCard++;
                        break;
                    case "Undo":
                        countUndoCard++;
                        break;
                    case "Unload":
                        countUnloadCard++;
                        break;
                    case "Uppercut":
                        countUppercutCard++;
                        break;
                    case "Venomology":
                        countVenomologyCard++;
                        break;
                    case "Void":
                        countVoidCard++;
                        break;
                    case "Warcry":
                        countWarcryCard++;
                        break;
                    case "Well Laid Plans":
                        countWellLaidPlansCard++;
                        break;
                    case "Whirlwind":
                        countWhirlwindCard++;
                        break;
                    case "White Noise":
                        countWhiteNoiseCard++;
                        break;
                    case "Wild Strike":
                        countWildStrikeCard++;
                        break;
                    case "Winter":
                        countWinterCard++;
                        break;
                    case "Wound":
                        countWoundCard++;
                        break;
                    case "Wraith Form v2":
                        countWraithFormv2Card++;
                        break;
                    case "Writhe":
                        countWritheCard++;
                        break;
                    case "Zap":
                        countZapCard++;
                        break;
                    case "Core Surge":
                        countCoreSurgeCard++;
                        break;
                    case "Compile Driver":
                        countCompileDriverCard++;
                        break;
                    case "RitualDagger":
                        countRitualDaggerCard++;
                        break;
                    case "Pride":
                        countPrideCard++;
                        break;
                    case "PanicButton":
                        countPanicButtonCard++;
                        break;
                    case "HandOfGreed":
                        countHandOfGreedCard++;
                        break;
                    case "Violence":
                        countViolenceCard++;
                        break;
                    case "Impatience":
                        countImpatienceCard++;
                        break;
                    case "Forethought":
                        countForethoughtCard++;
                        break;
                    case "Discovery":
                        countDiscoveryCard++;
                        break;
                }
            }
        }
        if (p.potions != null) {
            for (int i = 0; i < p.potions.size(); i++) {
                switch(i) {
                    case 0:
                        switch (p.potions.get(i).ID) {
                            case "Ancient Potion":
                                potionSlot0IsAncientPotion = 1;
                                break;
                            case "AttackPotion":
                                potionSlot0IsAttackPotion = 1;
                                break;
                            case "Block Potion":
                                potionSlot0IsBlockPotion = 1;
                                break;
                            case "BloodPotion":
                                potionSlot0IsBloodPotion = 1;
                                break;
                            case "Dexterity Potion":
                                potionSlot0IsDexterityPotion = 1;
                                break;
                            case "Elixir":
                                potionSlot0IsElixir = 1;
                                break;
                            case "Energy Potion":
                                potionSlot0IsEnergyPotion = 1;
                                break;
                            case "EntropicBrew":
                                potionSlot0IsEntropicBrew = 1;
                                break;
                            case "EssenceOfSteel":
                                potionSlot0IsEssenceOfSteel = 1;
                                break;
                            case "Explosive Potion":
                                potionSlot0IsExplosivePotion = 1;
                                break;
                            case "FairyPotion":
                                potionSlot0IsFairyPotion = 1;
                                break;
                            case "FearPotion":
                                potionSlot0IsFearPotion = 1;
                                break;
                            case "Fire Potion":
                                potionSlot0IsFirePotion = 1;
                                break;
                            case "FocusPotion":
                                potionSlot0IsFocusPotion = 1;
                                break;
                            case "Fruit Juice":
                                potionSlot0IsFruitJuice = 1;
                                break;
                            case "GamblersBrew":
                                potionSlot0IsGamblersBrew = 1;
                                break;
                            case "GhostInAJar":
                                potionSlot0IsGhostInAJar = 1;
                                break;
                            case "Health Potion":
                                potionSlot0IsHealthPotion = 1;
                                break;
                            case "LiquidBronze":
                                potionSlot0IsLiquidBronze = 1;
                                break;
                            case "Poison Potion":
                                potionSlot0IsPoisonPotion = 1;
                                break;
                            case "Potion Slot":
                                potionSlot0IsPotionSlot = 1;
                                break;
                            case "PowerPotion":
                                potionSlot0IsPowerPotion = 1;
                                break;
                            case "Regen Potion":
                                potionSlot0IsRegenPotion = 1;
                                break;
                            case "SkillPotion":
                                potionSlot0IsSkillPotion = 1;
                                break;
                            case "SmokeBomb":
                                potionSlot0IsSmokeBomb = 1;
                                break;
                            case "SneckoOil":
                                potionSlot0IsSneckoOil = 1;
                                break;
                            case "SpeedPotion":
                                potionSlot0IsSpeedPotion = 1;
                                break;
                            case "SteroidPotion":
                                potionSlot0IsSteroidPotion = 1;
                                break;
                            case "Strength Potion":
                                potionSlot0IsStrengthPotion = 1;
                                break;
                            case "Swift Potion":
                                potionSlot0IsSwiftPotion = 1;
                                break;
                            case "Weak Potion":
                                potionSlot0IsWeakPotion = 1;
                                break;
                            default:
                                potionSlot0IsPotionSlot = 1;
                                break;
                        }
                        break;
                    case 1:
                        switch (p.potions.get(i).ID) {
                            case "Ancient Potion":
                                potionSlot1IsAncientPotion = 1;
                                break;
                            case "AttackPotion":
                                potionSlot1IsAttackPotion = 1;
                                break;
                            case "Block Potion":
                                potionSlot1IsBlockPotion = 1;
                                break;
                            case "BloodPotion":
                                potionSlot1IsBloodPotion = 1;
                                break;
                            case "Dexterity Potion":
                                potionSlot1IsDexterityPotion = 1;
                                break;
                            case "Elixir":
                                potionSlot1IsElixir = 1;
                                break;
                            case "Energy Potion":
                                potionSlot1IsEnergyPotion = 1;
                                break;
                            case "EntropicBrew":
                                potionSlot1IsEntropicBrew = 1;
                                break;
                            case "EssenceOfSteel":
                                potionSlot1IsEssenceOfSteel = 1;
                                break;
                            case "Explosive Potion":
                                potionSlot1IsExplosivePotion = 1;
                                break;
                            case "FairyPotion":
                                potionSlot1IsFairyPotion = 1;
                                break;
                            case "FearPotion":
                                potionSlot1IsFearPotion = 1;
                                break;
                            case "Fire Potion":
                                potionSlot1IsFirePotion = 1;
                                break;
                            case "FocusPotion":
                                potionSlot1IsFocusPotion = 1;
                                break;
                            case "Fruit Juice":
                                potionSlot1IsFruitJuice = 1;
                                break;
                            case "GamblersBrew":
                                potionSlot1IsGamblersBrew = 1;
                                break;
                            case "GhostInAJar":
                                potionSlot1IsGhostInAJar = 1;
                                break;
                            case "Health Potion":
                                potionSlot1IsHealthPotion = 1;
                                break;
                            case "LiquidBronze":
                                potionSlot1IsLiquidBronze = 1;
                                break;
                            case "Poison Potion":
                                potionSlot1IsPoisonPotion = 1;
                                break;
                            case "Potion Slot":
                                potionSlot1IsPotionSlot = 1;
                                break;
                            case "PowerPotion":
                                potionSlot1IsPowerPotion = 1;
                                break;
                            case "Regen Potion":
                                potionSlot1IsRegenPotion = 1;
                                break;
                            case "SkillPotion":
                                potionSlot1IsSkillPotion = 1;
                                break;
                            case "SmokeBomb":
                                potionSlot1IsSmokeBomb = 1;
                                break;
                            case "SneckoOil":
                                potionSlot1IsSneckoOil = 1;
                                break;
                            case "SpeedPotion":
                                potionSlot1IsSpeedPotion = 1;
                                break;
                            case "SteroidPotion":
                                potionSlot1IsSteroidPotion = 1;
                                break;
                            case "Strength Potion":
                                potionSlot1IsStrengthPotion = 1;
                                break;
                            case "Swift Potion":
                                potionSlot1IsSwiftPotion = 1;
                                break;
                            case "Weak Potion":
                                potionSlot1IsWeakPotion = 1;
                                break;
                            default:
                                potionSlot1IsPotionSlot = 1;
                                break;
                        }
                        break;
                    case 2:
                        switch (p.potions.get(i).ID) {
                            case "Ancient Potion":
                                potionSlot2IsAncientPotion = 1;
                                break;
                            case "AttackPotion":
                                potionSlot2IsAttackPotion = 1;
                                break;
                            case "Block Potion":
                                potionSlot2IsBlockPotion = 1;
                                break;
                            case "BloodPotion":
                                potionSlot2IsBloodPotion = 1;
                                break;
                            case "Dexterity Potion":
                                potionSlot2IsDexterityPotion = 1;
                                break;
                            case "Elixir":
                                potionSlot2IsElixir = 1;
                                break;
                            case "Energy Potion":
                                potionSlot2IsEnergyPotion = 1;
                                break;
                            case "EntropicBrew":
                                potionSlot2IsEntropicBrew = 1;
                                break;
                            case "EssenceOfSteel":
                                potionSlot2IsEssenceOfSteel = 1;
                                break;
                            case "Explosive Potion":
                                potionSlot2IsExplosivePotion = 1;
                                break;
                            case "FairyPotion":
                                potionSlot2IsFairyPotion = 1;
                                break;
                            case "FearPotion":
                                potionSlot2IsFearPotion = 1;
                                break;
                            case "Fire Potion":
                                potionSlot2IsFirePotion = 1;
                                break;
                            case "FocusPotion":
                                potionSlot2IsFocusPotion = 1;
                                break;
                            case "Fruit Juice":
                                potionSlot2IsFruitJuice = 1;
                                break;
                            case "GamblersBrew":
                                potionSlot2IsGamblersBrew = 1;
                                break;
                            case "GhostInAJar":
                                potionSlot2IsGhostInAJar = 1;
                                break;
                            case "Health Potion":
                                potionSlot2IsHealthPotion = 1;
                                break;
                            case "LiquidBronze":
                                potionSlot2IsLiquidBronze = 1;
                                break;
                            case "Poison Potion":
                                potionSlot2IsPoisonPotion = 1;
                                break;
                            case "Potion Slot":
                                potionSlot2IsPotionSlot = 1;
                                break;
                            case "PowerPotion":
                                potionSlot2IsPowerPotion = 1;
                                break;
                            case "Regen Potion":
                                potionSlot2IsRegenPotion = 1;
                                break;
                            case "SkillPotion":
                                potionSlot2IsSkillPotion = 1;
                                break;
                            case "SmokeBomb":
                                potionSlot2IsSmokeBomb = 1;
                                break;
                            case "SneckoOil":
                                potionSlot2IsSneckoOil = 1;
                                break;
                            case "SpeedPotion":
                                potionSlot2IsSpeedPotion = 1;
                                break;
                            case "SteroidPotion":
                                potionSlot2IsSteroidPotion = 1;
                                break;
                            case "Strength Potion":
                                potionSlot2IsStrengthPotion = 1;
                                break;
                            case "Swift Potion":
                                potionSlot2IsSwiftPotion = 1;
                                break;
                            case "Weak Potion":
                                potionSlot2IsWeakPotion = 1;
                                break;
                            default:
                                potionSlot2IsPotionSlot = 1;
                                break;
                        }
                        break;
                    case 3:
                        switch (p.potions.get(i).ID) {
                            case "Ancient Potion":
                                potionSlot3IsAncientPotion = 1;
                                break;
                            case "AttackPotion":
                                potionSlot3IsAttackPotion = 1;
                                break;
                            case "Block Potion":
                                potionSlot3IsBlockPotion = 1;
                                break;
                            case "BloodPotion":
                                potionSlot3IsBloodPotion = 1;
                                break;
                            case "Dexterity Potion":
                                potionSlot3IsDexterityPotion = 1;
                                break;
                            case "Elixir":
                                potionSlot3IsElixir = 1;
                                break;
                            case "Energy Potion":
                                potionSlot3IsEnergyPotion = 1;
                                break;
                            case "EntropicBrew":
                                potionSlot3IsEntropicBrew = 1;
                                break;
                            case "EssenceOfSteel":
                                potionSlot3IsEssenceOfSteel = 1;
                                break;
                            case "Explosive Potion":
                                potionSlot3IsExplosivePotion = 1;
                                break;
                            case "FairyPotion":
                                potionSlot3IsFairyPotion = 1;
                                break;
                            case "FearPotion":
                                potionSlot3IsFearPotion = 1;
                                break;
                            case "Fire Potion":
                                potionSlot3IsFirePotion = 1;
                                break;
                            case "FocusPotion":
                                potionSlot3IsFocusPotion = 1;
                                break;
                            case "Fruit Juice":
                                potionSlot3IsFruitJuice = 1;
                                break;
                            case "GamblersBrew":
                                potionSlot3IsGamblersBrew = 1;
                                break;
                            case "GhostInAJar":
                                potionSlot3IsGhostInAJar = 1;
                                break;
                            case "Health Potion":
                                potionSlot3IsHealthPotion = 1;
                                break;
                            case "LiquidBronze":
                                potionSlot3IsLiquidBronze = 1;
                                break;
                            case "Poison Potion":
                                potionSlot3IsPoisonPotion = 1;
                                break;
                            case "Potion Slot":
                                potionSlot3IsPotionSlot = 1;
                                break;
                            case "PowerPotion":
                                potionSlot3IsPowerPotion = 1;
                                break;
                            case "Regen Potion":
                                potionSlot3IsRegenPotion = 1;
                                break;
                            case "SkillPotion":
                                potionSlot3IsSkillPotion = 1;
                                break;
                            case "SmokeBomb":
                                potionSlot3IsSmokeBomb = 1;
                                break;
                            case "SneckoOil":
                                potionSlot3IsSneckoOil = 1;
                                break;
                            case "SpeedPotion":
                                potionSlot3IsSpeedPotion = 1;
                                break;
                            case "SteroidPotion":
                                potionSlot3IsSteroidPotion = 1;
                                break;
                            case "Strength Potion":
                                potionSlot3IsStrengthPotion = 1;
                                break;
                            case "Swift Potion":
                                potionSlot3IsSwiftPotion = 1;
                                break;
                            case "Weak Potion":
                                potionSlot3IsWeakPotion = 1;
                                break;
                            default:
                                potionSlot3IsPotionSlot = 1;
                                break;
                        }
                        break;
                    case 4:
                        switch (p.potions.get(i).ID) {
                            case "Ancient Potion":
                                potionSlot4IsAncientPotion = 1;
                                break;
                            case "AttackPotion":
                                potionSlot4IsAttackPotion = 1;
                                break;
                            case "Block Potion":
                                potionSlot4IsBlockPotion = 1;
                                break;
                            case "BloodPotion":
                                potionSlot4IsBloodPotion = 1;
                                break;
                            case "Dexterity Potion":
                                potionSlot4IsDexterityPotion = 1;
                                break;
                            case "Elixir":
                                potionSlot4IsElixir = 1;
                                break;
                            case "Energy Potion":
                                potionSlot4IsEnergyPotion = 1;
                                break;
                            case "EntropicBrew":
                                potionSlot4IsEntropicBrew = 1;
                                break;
                            case "EssenceOfSteel":
                                potionSlot4IsEssenceOfSteel = 1;
                                break;
                            case "Explosive Potion":
                                potionSlot4IsExplosivePotion = 1;
                                break;
                            case "FairyPotion":
                                potionSlot4IsFairyPotion = 1;
                                break;
                            case "FearPotion":
                                potionSlot4IsFearPotion = 1;
                                break;
                            case "Fire Potion":
                                potionSlot4IsFirePotion = 1;
                                break;
                            case "FocusPotion":
                                potionSlot4IsFocusPotion = 1;
                                break;
                            case "Fruit Juice":
                                potionSlot4IsFruitJuice = 1;
                                break;
                            case "GamblersBrew":
                                potionSlot4IsGamblersBrew = 1;
                                break;
                            case "GhostInAJar":
                                potionSlot4IsGhostInAJar = 1;
                                break;
                            case "Health Potion":
                                potionSlot4IsHealthPotion = 1;
                                break;
                            case "LiquidBronze":
                                potionSlot4IsLiquidBronze = 1;
                                break;
                            case "Poison Potion":
                                potionSlot4IsPoisonPotion = 1;
                                break;
                            case "Potion Slot":
                                potionSlot4IsPotionSlot = 1;
                                break;
                            case "PowerPotion":
                                potionSlot4IsPowerPotion = 1;
                                break;
                            case "Regen Potion":
                                potionSlot4IsRegenPotion = 1;
                                break;
                            case "SkillPotion":
                                potionSlot4IsSkillPotion = 1;
                                break;
                            case "SmokeBomb":
                                potionSlot4IsSmokeBomb = 1;
                                break;
                            case "SneckoOil":
                                potionSlot4IsSneckoOil = 1;
                                break;
                            case "SpeedPotion":
                                potionSlot4IsSpeedPotion = 1;
                                break;
                            case "SteroidPotion":
                                potionSlot4IsSteroidPotion = 1;
                                break;
                            case "Strength Potion":
                                potionSlot4IsStrengthPotion = 1;
                                break;
                            case "Swift Potion":
                                potionSlot4IsSwiftPotion = 1;
                                break;
                            case "Weak Potion":
                                potionSlot4IsWeakPotion = 1;
                                break;
                            default:
                                potionSlot4IsPotionSlot = 1;
                                break;
                        }
                        break;
                }
            }
        }
        currentGold = p.gold;

        //set relics seen variables
        seenAnchor = JsonDump.seenAnchor;
        seenAncientTeaSet = JsonDump.seenAncientTeaSet;
        seenArtofWar = JsonDump.seenArtofWar;
        seenAstrolabe = JsonDump.seenAstrolabe;
        seenBagofMarbles = JsonDump.seenBagofMarbles;
        seenBagofPreparation = JsonDump.seenBagofPreparation;
        seenBirdFacedUrn = JsonDump.seenBirdFacedUrn;
        seenBlackBlood = JsonDump.seenBlackBlood;
        seenBlackStar = JsonDump.seenBlackStar;
        seenBloodVial = JsonDump.seenBloodVial;
        seenBloodyIdol = JsonDump.seenBloodyIdol;
        seenBlueCandle = JsonDump.seenBlueCandle;
        seenBottledFlame = JsonDump.seenBottledFlame;
        seenBottledLightning = JsonDump.seenBottledLightning;
        seenBottledTornado = JsonDump.seenBottledTornado;
        seenBronzeScales = JsonDump.seenBronzeScales;
        seenBurningBlood = JsonDump.seenBurningBlood;
        seenCables = JsonDump.seenCables;
        seenCalipers = JsonDump.seenCalipers;
        seenCallingBell = JsonDump.seenCallingBell;
        seenCauldron = JsonDump.seenCauldron;
        seenCentennialPuzzle = JsonDump.seenCentennialPuzzle;
        seenChameleonRing = JsonDump.seenChameleonRing;
        seenChampionBelt = JsonDump.seenChampionBelt;
        seenCharonsAshes = JsonDump.seenCharonsAshes;
        seenChemicalX = JsonDump.seenChemicalX;
        seenCirclet = JsonDump.seenCirclet;
        seenCrackedCore = JsonDump.seenCrackedCore;
        seenFrozenCore = JsonDump.seenFrozenCore;
        seenCursedKey = JsonDump.seenCursedKey;
        seenDarkstonePeriapt = JsonDump.seenDarkstonePeriapt;
        seenDataDisk = JsonDump.seenDataDisk;
        seenDeadBranch = JsonDump.seenDeadBranch;
        seenDerpRock = JsonDump.seenDerpRock;
        seenDiscerningMonocle = JsonDump.seenDiscerningMonocle;
        seenDodecahedron = JsonDump.seenDodecahedron;
        seenDreamCatcher = JsonDump.seenDreamCatcher;
        seenDuVuDoll = JsonDump.seenDuVuDoll;
        seenEctoplasm = JsonDump.seenEctoplasm;
        seenEmotionChip = JsonDump.seenEmotionChip;
        seenEnchiridion = JsonDump.seenEnchiridion;
        seenEternalFeather = JsonDump.seenEternalFeather;
        seenFrozenEgg = JsonDump.seenFrozenEgg;
        seenFrozenEgg2 = JsonDump.seenFrozenEgg2;
        seenFrozenEye = JsonDump.seenFrozenEye;
        seenGamblingChip = JsonDump.seenGamblingChip;
        seenGinger = JsonDump.seenGinger;
        seenGirya = JsonDump.seenGirya;
        seenGoldenIdol = JsonDump.seenGoldenIdol;
        seenGremlinHorn = JsonDump.seenGremlinHorn;
        seenHappyFlower = JsonDump.seenHappyFlower;
        seenIceCream = JsonDump.seenIceCream;
        seenInserter = JsonDump.seenInserter;
        seenJuzuBracelet = JsonDump.seenJuzuBracelet;
        seenKunai = JsonDump.seenKunai;
        seenLantern = JsonDump.seenLantern;
        seenLeesWaffle = JsonDump.seenLeesWaffle;
        seenLetterOpener = JsonDump.seenLetterOpener;
        seenLivingBlade = JsonDump.seenLivingBlade;
        seenLizardTail = JsonDump.seenLizardTail;
        seenMagicFlower = JsonDump.seenMagicFlower;
        seenMango = JsonDump.seenMango;
        seenMarkofPain = JsonDump.seenMarkofPain;
        seenMatryoshka = JsonDump.seenMatryoshka;
        seenMeatontheBone = JsonDump.seenMeatontheBone;
        seenMedicalKit = JsonDump.seenMedicalKit;
        seenMembershipCard = JsonDump.seenMembershipCard;
        seenMercuryHourglass = JsonDump.seenMercuryHourglass;
        seenMoltenEgg = JsonDump.seenMoltenEgg;
        seenMoltenEgg2 = JsonDump.seenMoltenEgg2;
        seenMummifiedHand = JsonDump.seenMummifiedHand;
        seenNecronomicon = JsonDump.seenNecronomicon;
        seenNeowsBlessing = JsonDump.seenNeowsBlessing;
        seenNilrysCodex = JsonDump.seenNilrysCodex;
        seenNineLives = JsonDump.seenNineLives;
        seenNinjaScroll = JsonDump.seenNinjaScroll;
        seenNlothsGift = JsonDump.seenNlothsGift;
        seenNuclearBattery = JsonDump.seenNuclearBattery;
        seenNullstonePeriapt = JsonDump.seenNullstonePeriapt;
        seenOddMushroom = JsonDump.seenOddMushroom;
        seenOddlySmoothStone = JsonDump.seenOddlySmoothStone;
        seenOldCoin = JsonDump.seenOldCoin;
        seenOmamori = JsonDump.seenOmamori;
        seenOrichalcum = JsonDump.seenOrichalcum;
        seenOrnamentalFan = JsonDump.seenOrnamentalFan;
        seenOrrery = JsonDump.seenOrrery;
        seenPandorasBox = JsonDump.seenPandorasBox;
        seenPantograph = JsonDump.seenPantograph;
        seenPaperCrane = JsonDump.seenPaperCrane;
        seenPaperFrog = JsonDump.seenPaperFrog;
        seenPeacePipe = JsonDump.seenPeacePipe;
        seenPear = JsonDump.seenPear;
        seenPenNib = JsonDump.seenPenNib;
        seenPhilosophersStone = JsonDump.seenPhilosophersStone;
        seenPotionBelt = JsonDump.seenPotionBelt;
        seenPrayerWheel = JsonDump.seenPrayerWheel;
        seenQuestionCard = JsonDump.seenQuestionCard;
        seenRedCirclet = JsonDump.seenRedCirclet;
        seenRedMask = JsonDump.seenRedMask;
        seenRedSkull = JsonDump.seenRedSkull;
        seenRegalPillow = JsonDump.seenRegalPillow;
        seenRingoftheSerpent = JsonDump.seenRingoftheSerpent;
        seenRingoftheSnake = JsonDump.seenRingoftheSnake;
        seenRunicCapacitor = JsonDump.seenRunicCapacitor;
        seenRunicCube = JsonDump.seenRunicCube;
        seenRunicDome = JsonDump.seenRunicDome;
        seenRunicPyramid = JsonDump.seenRunicPyramid;
        seenSelfFormingClay = JsonDump.seenSelfFormingClay;
        seenShovel = JsonDump.seenShovel;
        seenShuriken = JsonDump.seenShuriken;
        seenSingingBowl = JsonDump.seenSingingBowl;
        seenSmilingMask = JsonDump.seenSmilingMask;
        seenSnakeSkull = JsonDump.seenSnakeSkull;
        seenSneckoEye = JsonDump.seenSneckoEye;
        seenSozu = JsonDump.seenSozu;
        seenSpiritPoop = JsonDump.seenSpiritPoop;
        seenStrangeSpoon = JsonDump.seenStrangeSpoon;
        seenStrawberry = JsonDump.seenStrawberry;
        seenSundial = JsonDump.seenSundial;
        seenSymbioticVirus = JsonDump.seenSymbioticVirus;
        seenTest1 = JsonDump.seenTest1;
        seenTest2 = JsonDump.seenTest2;
        seenTest3 = JsonDump.seenTest3;
        seenTest4 = JsonDump.seenTest4;
        seenTest5 = JsonDump.seenTest5;
        seenTest6 = JsonDump.seenTest6;
        seenTest7 = JsonDump.seenTest7;
        seenTest8 = JsonDump.seenTest8;
        seenTheCourier = JsonDump.seenTheCourier;
        seenTheSpecimen = JsonDump.seenTheSpecimen;
        seenThreadandNeedle = JsonDump.seenThreadandNeedle;
        seenTingsha = JsonDump.seenTingsha;
        seenTinyChest = JsonDump.seenTinyChest;
        seenTinyHouse = JsonDump.seenTinyHouse;
        seenToolbox = JsonDump.seenToolbox;
        seenTorii = JsonDump.seenTorii;
        seenToughBandages = JsonDump.seenToughBandages;
        seenToxicEgg = JsonDump.seenToxicEgg;
        seenToxicEgg2 = JsonDump.seenToxicEgg2;
        seenToyOrnithopter = JsonDump.seenToyOrnithopter;
        seenTurnip = JsonDump.seenTurnip;
        seenUnceasingTop = JsonDump.seenUnceasingTop;
        seenVajra = JsonDump.seenVajra;
        seenVelvetChoker = JsonDump.seenVelvetChoker;
        seenWarPaint = JsonDump.seenWarPaint;
        seenWhetstone = JsonDump.seenWhetstone;
        seenWhiteBeastStatue = JsonDump.seenWhiteBeastStatue;
        seenBoot = JsonDump.seenBoot;
        seenMarkoftheBloom = JsonDump.seenMarkoftheBloom;
        seenBustedCrown = JsonDump.seenBustedCrown;
        seenIncenseBurner = JsonDump.seenIncenseBurner;
        seenEmptyCage = JsonDump.seenEmptyCage;
        seenFusionHammer = JsonDump.seenFusionHammer;
        seenCoffeeDripper = JsonDump.seenCoffeeDripper;
        seenSsserpentHead = JsonDump.seenSsserpentHead;
        seenMutagenicStrength = JsonDump.seenMutagenicStrength;
        seenFaceOfCleric = JsonDump.seenFaceOfCleric;
        seenNlothsMask = JsonDump.seenNlothsMask;
        seenGremlinMask = JsonDump.seenGremlinMask;
        seenCultistMask = JsonDump.seenCultistMask;
        seenTheAbacus = JsonDump.seenTheAbacus;
        seenDollysMirror = JsonDump.seenDollysMirror;
        seenClockworkSouvenir = JsonDump.seenClockworkSouvenir;
        seenMealTicket = JsonDump.seenMealTicket;
        seenTwistedFunnel = JsonDump.seenTwistedFunnel;
        seenHandDrill = JsonDump.seenHandDrill;
        seenHoveringKite = JsonDump.seenHoveringKite;
        seenSling = JsonDump.seenSling;
        seenOrangePellets = JsonDump.seenOrangePellets;
        seenWristBlade = JsonDump.seenWristBlade;
        seenStoneCalendar = JsonDump.seenStoneCalendar;
        seenNunchaku = JsonDump.seenNunchaku;
        seenBrimstone = JsonDump.seenBrimstone;
        seenPreservedInsect = JsonDump.seenPreservedInsect;
        seenPocketwatch = JsonDump.seenPocketwatch;
        seenFossilizedHelix = JsonDump.seenFossilizedHelix;
        seenPrismaticShard = JsonDump.seenPrismaticShard;
        seenWarpedTongs = JsonDump.seenWarpedTongs;
        seenWingedGreaves = JsonDump.seenWingedGreaves;
        seenMawBank = JsonDump.seenMawBank;



        //set relics owned variables
        for (final AbstractRelic relic : p.relics) {
            switch(relic.relicId) {
                case "Anchor":
                    hasAnchor = 1;
                    countAnchor = relic.counter;
                    break;
                case "Ancient Tea Set":
                    hasAncientTeaSet = 1;
                    countAncientTeaSet = relic.counter;
                    break;
                case "Art of War":
                    hasArtofWar = 1;
                    countArtofWar = relic.counter;
                    break;
                case "Astrolabe":
                    hasAstrolabe = 1;
                    countAstrolabe = relic.counter;
                    break;
                case "Bag of Marbles":
                    hasBagofMarbles = 1;
                    countBagofMarbles = relic.counter;
                    break;
                case "Bag of Preparation":
                    hasBagofPreparation = 1;
                    countBagofPreparation = relic.counter;
                    break;
                case "Bird Faced Urn":
                    hasBirdFacedUrn = 1;
                    countBirdFacedUrn = relic.counter;
                    break;
                case "Black Blood":
                    hasBlackBlood = 1;
                    countBlackBlood = relic.counter;
                    break;
                case "Black Star":
                    hasBlackStar = 1;
                    countBlackStar = relic.counter;
                    break;
                case "Blood Vial":
                    hasBloodVial = 1;
                    countBloodVial = relic.counter;
                    break;
                case "Bloody Idol":
                    hasBloodyIdol = 1;
                    countBloodyIdol = relic.counter;
                    break;
                case "Blue Candle":
                    hasBlueCandle = 1;
                    countBlueCandle = relic.counter;
                    break;
                case "Bottled Flame":
                    hasBottledFlame = 1;
                    countBottledFlame = relic.counter;
                    break;
                case "Bottled Lightning":
                    hasBottledLightning = 1;
                    countBottledLightning = relic.counter;
                    break;
                case "Bottled Tornado":
                    hasBottledTornado = 1;
                    countBottledTornado = relic.counter;
                    break;
                case "Bronze Scales":
                    hasBronzeScales = 1;
                    countBronzeScales = relic.counter;
                    break;
                case "Burning Blood":
                    hasBurningBlood = 1;
                    countBurningBlood = relic.counter;
                    break;
                case "Cables":
                    hasCables = 1;
                    countCables = relic.counter;
                    break;
                case "Calipers":
                    hasCalipers = 1;
                    countCalipers = relic.counter;
                    break;
                case "Calling Bell":
                    hasCallingBell = 1;
                    countCallingBell = relic.counter;
                    break;
                case "Cauldron":
                    hasCauldron = 1;
                    countCauldron = relic.counter;
                    break;
                case "Centennial Puzzle":
                    hasCentennialPuzzle = 1;
                    countCentennialPuzzle = relic.counter;
                    break;
                case "Chameleon Ring":
                    hasChameleonRing = 1;
                    countChameleonRing = relic.counter;
                    break;
                case "Champion Belt":
                    hasChampionBelt = 1;
                    countChampionBelt = relic.counter;
                    break;
                case "Charon's Ashes":
                    hasCharonsAshes = 1;
                    countCharonsAshes = relic.counter;
                    break;
                case "Chemical X":
                    hasChemicalX = 1;
                    countChemicalX = relic.counter;
                    break;
                case "Circlet":
                    hasCirclet = 1;
                    countCirclet = relic.counter;
                    break;
                case "Cracked Core":
                    hasCrackedCore = 1;
                    countCrackedCore = relic.counter;
                    break;
                case "FrozenCore":
                    hasFrozenCore = 1;
                    countFrozenCore = relic.counter;
                    break;
                case "Cursed Key":
                    hasCursedKey = 1;
                    countCursedKey = relic.counter;
                    break;
                case "Darkstone Periapt":
                    hasDarkstonePeriapt = 1;
                    countDarkstonePeriapt = relic.counter;
                    break;
                case "DataDisk":
                    hasDataDisk = 1;
                    countDataDisk = relic.counter;
                    break;
                case "Dead Branch":
                    hasDeadBranch = 1;
                    countDeadBranch = relic.counter;
                    break;
                case "Derp Rock":
                    hasDerpRock = 1;
                    countDerpRock = relic.counter;
                    break;
                case "Discerning Monocle":
                    hasDiscerningMonocle = 1;
                    countDiscerningMonocle = relic.counter;
                    break;
                case "Dodecahedron":
                    hasDodecahedron = 1;
                    countDodecahedron = relic.counter;
                    break;
                case "Dream Catcher":
                    hasDreamCatcher = 1;
                    countDreamCatcher = relic.counter;
                    break;
                case "Du-Vu Doll":
                    hasDuVuDoll = 1;
                    countDuVuDoll = relic.counter;
                    break;
                case "Ectoplasm":
                    hasEctoplasm = 1;
                    countEctoplasm = relic.counter;
                    break;
                case "Emotion Chip":
                    hasEmotionChip = 1;
                    countEmotionChip = relic.counter;
                    break;
                case "Enchiridion":
                    hasEnchiridion = 1;
                    countEnchiridion = relic.counter;
                    break;
                case "Eternal Feather":
                    hasEternalFeather = 1;
                    countEternalFeather = relic.counter;
                    break;
                case "Frozen Egg":
                    hasFrozenEgg = 1;
                    countFrozenEgg = relic.counter;
                    break;
                case "Frozen Egg 2":
                    hasFrozenEgg2 = 1;
                    countFrozenEgg2 = relic.counter;
                    break;
                case "Frozen Eye":
                    hasFrozenEye = 1;
                    countFrozenEye = relic.counter;
                    break;
                case "Gambling Chip":
                    hasGamblingChip = 1;
                    countGamblingChip = relic.counter;
                    break;
                case "Ginger":
                    hasGinger = 1;
                    countGinger = relic.counter;
                    break;
                case "Girya":
                    hasGirya = 1;
                    countGirya = relic.counter;
                    break;
                case "Golden Idol":
                    hasGoldenIdol = 1;
                    countGoldenIdol = relic.counter;
                    break;
                case "Gremlin Horn":
                    hasGremlinHorn = 1;
                    countGremlinHorn = relic.counter;
                    break;
                case "Happy Flower":
                    hasHappyFlower = 1;
                    countHappyFlower = relic.counter;
                    break;
                case "Ice Cream":
                    hasIceCream = 1;
                    countIceCream = relic.counter;
                    break;
                case "Inserter":
                    hasInserter = 1;
                    countInserter = relic.counter;
                    break;
                case "Juzu Bracelet":
                    hasJuzuBracelet = 1;
                    countJuzuBracelet = relic.counter;
                    break;
                case "Kunai":
                    hasKunai = 1;
                    countKunai = relic.counter;
                    break;
                case "Lantern":
                    hasLantern = 1;
                    countLantern = relic.counter;
                    break;
                case "Lee's Waffle":
                    hasLeesWaffle = 1;
                    countLeesWaffle = relic.counter;
                    break;
                case "Letter Opener":
                    hasLetterOpener = 1;
                    countLetterOpener = relic.counter;
                    break;
                case "Living Blade":
                    hasLivingBlade = 1;
                    countLivingBlade = relic.counter;
                    break;
                case "Lizard Tail":
                    hasLizardTail = 1;
                    countLizardTail = relic.counter;
                    break;
                case "Magic Flower":
                    hasMagicFlower = 1;
                    countMagicFlower = relic.counter;
                    break;
                case "Mango":
                    hasMango = 1;
                    countMango = relic.counter;
                    break;
                case "Mark of Pain":
                    hasMarkofPain = 1;
                    countMarkofPain = relic.counter;
                    break;
                case "Matryoshka":
                    hasMatryoshka = 1;
                    countMatryoshka = relic.counter;
                    break;
                case "Meat on the Bone":
                    hasMeatontheBone = 1;
                    countMeatontheBone = relic.counter;
                    break;
                case "Medical Kit":
                    hasMedicalKit = 1;
                    countMedicalKit = relic.counter;
                    break;
                case "Membership Card":
                    hasMembershipCard = 1;
                    countMembershipCard = relic.counter;
                    break;
                case "Mercury Hourglass":
                    hasMercuryHourglass = 1;
                    countMercuryHourglass = relic.counter;
                    break;
                case "Molten Egg":
                    hasMoltenEgg = 1;
                    countMoltenEgg = relic.counter;
                    break;
                case "Molten Egg 2":
                    hasMoltenEgg2 = 1;
                    countMoltenEgg2 = relic.counter;
                    break;
                case "Mummified Hand":
                    hasMummifiedHand = 1;
                    countMummifiedHand = relic.counter;
                    break;
                case "Necronomicon":
                    hasNecronomicon = 1;
                    countNecronomicon = relic.counter;
                    break;
                case "NeowsBlessing":
                    hasNeowsBlessing = 1;
                    countNeowsBlessing = relic.counter;
                    break;
                case "Nilry's Codex":
                    hasNilrysCodex = 1;
                    countNilrysCodex = relic.counter;
                    break;
                case "Nine Lives":
                    hasNineLives = 1;
                    countNineLives = relic.counter;
                    break;
                case "Ninja Scroll":
                    hasNinjaScroll = 1;
                    countNinjaScroll = relic.counter;
                    break;
                case "Nloth's Gift":
                    hasNlothsGift = 1;
                    countNlothsGift = relic.counter;
                    break;
                case "Nuclear Battery":
                    hasNuclearBattery = 1;
                    countNuclearBattery = relic.counter;
                    break;
                case "Nullstone Periapt":
                    hasNullstonePeriapt = 1;
                    countNullstonePeriapt = relic.counter;
                    break;
                case "Odd Mushroom":
                    hasOddMushroom = 1;
                    countOddMushroom = relic.counter;
                    break;
                case "Oddly Smooth Stone":
                    hasOddlySmoothStone = 1;
                    countOddlySmoothStone = relic.counter;
                    break;
                case "Old Coin":
                    hasOldCoin = 1;
                    countOldCoin = relic.counter;
                    break;
                case "Omamori":
                    hasOmamori = 1;
                    countOmamori = relic.counter;
                    break;
                case "Orichalcum":
                    hasOrichalcum = 1;
                    countOrichalcum = relic.counter;
                    break;
                case "Ornamental Fan":
                    hasOrnamentalFan = 1;
                    countOrnamentalFan = relic.counter;
                    break;
                case "Orrery":
                    hasOrrery = 1;
                    countOrrery = relic.counter;
                    break;
                case "Pandora's Box":
                    hasPandorasBox = 1;
                    countPandorasBox = relic.counter;
                    break;
                case "Pantograph":
                    hasPantograph = 1;
                    countPantograph = relic.counter;
                    break;
                case "Paper Crane":
                    hasPaperCrane = 1;
                    countPaperCrane = relic.counter;
                    break;
                case "Paper Frog":
                    hasPaperFrog = 1;
                    countPaperFrog = relic.counter;
                    break;
                case "Peace Pipe":
                    hasPeacePipe = 1;
                    countPeacePipe = relic.counter;
                    break;
                case "Pear":
                    hasPear = 1;
                    countPear = relic.counter;
                    break;
                case "Pen Nib":
                    hasPenNib = 1;
                    countPenNib = relic.counter;
                    break;
                case "Philosopher's Stone":
                    hasPhilosophersStone = 1;
                    countPhilosophersStone = relic.counter;
                    break;
                case "Potion Belt":
                    hasPotionBelt = 1;
                    countPotionBelt = relic.counter;
                    break;
                case "Prayer Wheel":
                    hasPrayerWheel = 1;
                    countPrayerWheel = relic.counter;
                    break;
                case "Question Card":
                    hasQuestionCard = 1;
                    countQuestionCard = relic.counter;
                    break;
                case "Red Circlet":
                    hasRedCirclet = 1;
                    countRedCirclet = relic.counter;
                    break;
                case "Red Mask":
                    hasRedMask = 1;
                    countRedMask = relic.counter;
                    break;
                case "Red Skull":
                    hasRedSkull = 1;
                    countRedSkull = relic.counter;
                    break;
                case "Regal Pillow":
                    hasRegalPillow = 1;
                    countRegalPillow = relic.counter;
                    break;
                case "Ring of the Serpent":
                    hasRingoftheSerpent = 1;
                    countRingoftheSerpent = relic.counter;
                    break;
                case "Ring of the Snake":
                    hasRingoftheSnake = 1;
                    countRingoftheSnake = relic.counter;
                    break;
                case "Runic Capacitor":
                    hasRunicCapacitor = 1;
                    countRunicCapacitor = relic.counter;
                    break;
                case "Runic Cube":
                    hasRunicCube = 1;
                    countRunicCube = relic.counter;
                    break;
                case "Runic Dome":
                    hasRunicDome = 1;
                    countRunicDome = relic.counter;
                    break;
                case "Runic Pyramid":
                    hasRunicPyramid = 1;
                    countRunicPyramid = relic.counter;
                    break;
                case "Self Forming Clay":
                    hasSelfFormingClay = 1;
                    countSelfFormingClay = relic.counter;
                    break;
                case "Shovel":
                    hasShovel = 1;
                    countShovel = relic.counter;
                    break;
                case "Shuriken":
                    hasShuriken = 1;
                    countShuriken = relic.counter;
                    break;
                case "Singing Bowl":
                    hasSingingBowl = 1;
                    countSingingBowl = relic.counter;
                    break;
                case "Smiling Mask":
                    hasSmilingMask = 1;
                    countSmilingMask = relic.counter;
                    break;
                case "Snake Skull":
                    hasSnakeSkull = 1;
                    countSnakeSkull = relic.counter;
                    break;
                case "Snecko Eye":
                    hasSneckoEye = 1;
                    countSneckoEye = relic.counter;
                    break;
                case "Sozu":
                    hasSozu = 1;
                    countSozu = relic.counter;
                    break;
                case "Spirit Poop":
                    hasSpiritPoop = 1;
                    countSpiritPoop = relic.counter;
                    break;
                case "Strange Spoon":
                    hasStrangeSpoon = 1;
                    countStrangeSpoon = relic.counter;
                    break;
                case "Strawberry":
                    hasStrawberry = 1;
                    countStrawberry = relic.counter;
                    break;
                case "Sundial":
                    hasSundial = 1;
                    countSundial = relic.counter;
                    break;
                case "Symbiotic Virus":
                    hasSymbioticVirus = 1;
                    countSymbioticVirus = relic.counter;
                    break;
                case "Test 1":
                    hasTest1 = 1;
                    countTest1 = relic.counter;
                    break;
                case "Test 2":
                    hasTest2 = 1;
                    countTest2 = relic.counter;
                    break;
                case "Test 3":
                    hasTest3 = 1;
                    countTest3 = relic.counter;
                    break;
                case "Test 4":
                    hasTest4 = 1;
                    countTest4 = relic.counter;
                    break;
                case "Test 5":
                    hasTest5 = 1;
                    countTest5 = relic.counter;
                    break;
                case "Test 6":
                    hasTest6 = 1;
                    countTest6 = relic.counter;
                    break;
                case "Test 7":
                    hasTest7 = 1;
                    countTest7 = relic.counter;
                    break;
                case "Test 8":
                    hasTest8 = 1;
                    countTest8 = relic.counter;
                    break;
                case "The Courier":
                    hasTheCourier = 1;
                    countTheCourier = relic.counter;
                    break;
                case "The Specimen":
                    hasTheSpecimen = 1;
                    countTheSpecimen = relic.counter;
                    break;
                case "Thread and Needle":
                    hasThreadandNeedle = 1;
                    countThreadandNeedle = relic.counter;
                    break;
                case "Tingsha":
                    hasTingsha = 1;
                    countTingsha = relic.counter;
                    break;
                case "Tiny Chest":
                    hasTinyChest = 1;
                    countTinyChest = relic.counter;
                    break;
                case "Tiny House":
                    hasTinyHouse = 1;
                    countTinyHouse = relic.counter;
                    break;
                case "Toolbox":
                    hasToolbox = 1;
                    countToolbox = relic.counter;
                    break;
                case "Torii":
                    hasTorii = 1;
                    countTorii = relic.counter;
                    break;
                case "Tough Bandages":
                    hasToughBandages = 1;
                    countToughBandages = relic.counter;
                    break;
                case "Toxic Egg":
                    hasToxicEgg = 1;
                    countToxicEgg = relic.counter;
                    break;
                case "Toxic Egg 2":
                    hasToxicEgg2 = 1;
                    countToxicEgg2 = relic.counter;
                    break;
                case "Toy Ornithopter":
                    hasToyOrnithopter = 1;
                    countToyOrnithopter = relic.counter;
                    break;
                case "Turnip":
                    hasTurnip = 1;
                    countTurnip = relic.counter;
                    break;
                case "Unceasing Top":
                    hasUnceasingTop = 1;
                    countUnceasingTop = relic.counter;
                    break;
                case "Vajra":
                    hasVajra = 1;
                    countVajra = relic.counter;
                    break;
                case "Velvet Choker":
                    hasVelvetChoker = 1;
                    countVelvetChoker = relic.counter;
                    break;
                case "War Paint":
                    hasWarPaint = 1;
                    countWarPaint = relic.counter;
                    break;
                case "Whetstone":
                    hasWhetstone = 1;
                    countWhetstone = relic.counter;
                    break;
                case "White Beast Statue":
                    hasWhiteBeastStatue = 1;
                    countWhiteBeastStatue = relic.counter;
                    break;
                case "Boot":
                    hasBoot = 1;
                    countBoot = relic.counter;
                    break;
                case "Mark of the Bloom":
                    hasMarkoftheBloom = 1;
                    countMarkoftheBloom = relic.counter;
                    break;
                case "Busted Crown":
                    hasBustedCrown = 1;
                    countBustedCrown = relic.counter;
                    break;
                case "Incense Burner":
                    hasIncenseBurner = 1;
                    countIncenseBurner = relic.counter;
                    break;
                case "Empty Cage":
                    hasEmptyCage = 1;
                    countEmptyCage = relic.counter;
                    break;
                case "Fusion Hammer":
                    hasFusionHammer = 1;
                    countFusionHammer = relic.counter;
                    break;
                case "Coffee Dripper":
                    hasCoffeeDripper = 1;
                    countCoffeeDripper = relic.counter;
                    break;
                case "SsserpentHead":
                    hasSsserpentHead = 1;
                    countSsserpentHead = relic.counter;
                    break;
                case "MutagenicStrength":
                    hasMutagenicStrength = 1;
                    countMutagenicStrength = relic.counter;
                    break;
                case "FaceOfCleric":
                    hasFaceOfCleric = 1;
                    countFaceOfCleric = relic.counter;
                    break;
                case "NlothsMask":
                    hasNlothsMask = 1;
                    countNlothsMask = relic.counter;
                    break;
                case "GremlinMask":
                    hasGremlinMask = 1;
                    countGremlinMask = relic.counter;
                    break;
                case "CultistMask":
                    hasCultistMask = 1;
                    countCultistMask = relic.counter;
                    break;
                case "TheAbacus":
                    hasTheAbacus = 1;
                    countTheAbacus = relic.counter;
                    break;
                case "DollysMirror":
                    hasDollysMirror = 1;
                    countDollysMirror = relic.counter;
                    break;
                case "ClockworkSouvenir":
                    hasClockworkSouvenir = 1;
                    countClockworkSouvenir = relic.counter;
                    break;
                case "MealTicket":
                    hasMealTicket = 1;
                    countMealTicket = relic.counter;
                    break;
                case "TwistedFunnel":
                    hasTwistedFunnel = 1;
                    countTwistedFunnel = relic.counter;
                    break;
                case "HandDrill":
                    hasHandDrill = 1;
                    countHandDrill = relic.counter;
                    break;
                case "HoveringKite":
                    hasHoveringKite = 1;
                    countHoveringKite = relic.counter;
                    break;
                case "Sling":
                    hasSling = 1;
                    countSling = relic.counter;
                    break;
                case "OrangePellets":
                    hasOrangePellets = 1;
                    countOrangePellets = relic.counter;
                    break;
                case "WristBlade":
                    hasWristBlade = 1;
                    countWristBlade = relic.counter;
                    break;
                case "StoneCalendar":
                    hasStoneCalendar = 1;
                    countStoneCalendar = relic.counter;
                    break;
                case "Nunchaku":
                    hasNunchaku = 1;
                    countNunchaku = relic.counter;
                    break;
                case "Brimstone":
                    hasBrimstone = 1;
                    countBrimstone = relic.counter;
                    break;
                case "PreservedInsect":
                    hasPreservedInsect = 1;
                    countPreservedInsect = relic.counter;
                    break;
                case "Pocketwatch":
                    hasPocketwatch = 1;
                    countPocketwatch = relic.counter;
                    break;
                case "FossilizedHelix":
                    hasFossilizedHelix = 1;
                    countFossilizedHelix = relic.counter;
                    break;
                case "PrismaticShard":
                    hasPrismaticShard = 1;
                    countPrismaticShard = relic.counter;
                    break;
                case "WarpedTongs":
                    hasWarpedTongs = 1;
                    countWarpedTongs = relic.counter;
                    break;
                case "WingedGreaves":
                    hasWingedGreaves = 1;
                    countWingedGreaves = relic.counter;
                    break;
                case "MawBank":
                    hasMawBank = 1;
                    countMawBank = relic.counter;
                    break;
            }

        }
        }


    }

