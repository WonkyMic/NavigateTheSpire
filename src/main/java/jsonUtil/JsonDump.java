package jsonUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.UUID;

public class JsonDump {

    //RELICS SEEN
    public static int seenAnchor = 0;
    public static int seenAncientTeaSet = 0;
    public static int seenArtofWar = 0;
    public static int seenAstrolabe = 0;
    public static int seenBagofMarbles = 0;
    public static int seenBagofPreparation = 0;
    public static int seenBirdFacedUrn = 0;
    public static int seenBlackBlood = 0;
    public static int seenBlackStar = 0;
    public static int seenBloodVial = 0;
    public static int seenBloodyIdol = 0;
    public static int seenBlueCandle = 0;
    public static int seenBottledFlame = 0;
    public static int seenBottledLightning = 0;
    public static int seenBottledTornado = 0;
    public static int seenBronzeScales = 0;
    public static int seenBurningBlood = 0;
    public static int seenCables = 0;
    public static int seenCalipers = 0;
    public static int seenCallingBell = 0;
    public static int seenCauldron = 0;
    public static int seenCentennialPuzzle = 0;
    public static int seenChameleonRing = 0;
    public static int seenChampionBelt = 0;
    public static int seenCharonsAshes = 0;
    public static int seenChemicalX = 0;
    public static int seenCirclet = 0;
    public static int seenCrackedCore = 0;
    public static int seenFrozenCore = 0;
    public static int seenCursedKey = 0;
    public static int seenDarkstonePeriapt = 0;
    public static int seenDataDisk = 0;
    public static int seenDeadBranch = 0;
    public static int seenDerpRock = 0;
    public static int seenDiscerningMonocle = 0;
    public static int seenDodecahedron = 0;
    public static int seenDreamCatcher = 0;
    public static int seenDuVuDoll = 0;
    public static int seenEctoplasm = 0;
    public static int seenEmotionChip = 0;
    public static int seenEnchiridion = 0;
    public static int seenEternalFeather = 0;
    public static int seenFrozenEgg = 0;
    public static int seenFrozenEgg2 = 0;
    public static int seenFrozenEye = 0;
    public static int seenGamblingChip = 0;
    public static int seenGinger = 0;
    public static int seenGirya = 0;
    public static int seenGoldenIdol = 0;
    public static int seenGremlinHorn = 0;
    public static int seenHappyFlower = 0;
    public static int seenIceCream = 0;
    public static int seenInserter = 0;
    public static int seenJuzuBracelet = 0;
    public static int seenKunai = 0;
    public static int seenLantern = 0;
    public static int seenLeesWaffle = 0;
    public static int seenLetterOpener = 0;
    public static int seenLivingBlade = 0;
    public static int seenLizardTail = 0;
    public static int seenMagicFlower = 0;
    public static int seenMango = 0;
    public static int seenMarkofPain = 0;
    public static int seenMatryoshka = 0;
    public static int seenMeatontheBone = 0;
    public static int seenMedicalKit = 0;
    public static int seenMembershipCard = 0;
    public static int seenMercuryHourglass = 0;
    public static int seenMoltenEgg = 0;
    public static int seenMoltenEgg2 = 0;
    public static int seenMummifiedHand = 0;
    public static int seenNecronomicon = 0;
    public static int seenNeowsBlessing = 0;
    public static int seenNilrysCodex = 0;
    public static int seenNineLives = 0;
    public static int seenNinjaScroll = 0;
    public static int seenNlothsGift = 0;
    public static int seenNuclearBattery = 0;
    public static int seenNullstonePeriapt = 0;
    public static int seenOddMushroom = 0;
    public static int seenOddlySmoothStone = 0;
    public static int seenOldCoin = 0;
    public static int seenOmamori = 0;
    public static int seenOrichalcum = 0;
    public static int seenOrnamentalFan = 0;
    public static int seenOrrery = 0;
    public static int seenPandorasBox = 0;
    public static int seenPantograph = 0;
    public static int seenPaperCrane = 0;
    public static int seenPaperFrog = 0;
    public static int seenPeacePipe = 0;
    public static int seenPear = 0;
    public static int seenPenNib = 0;
    public static int seenPhilosophersStone = 0;
    public static int seenPotionBelt = 0;
    public static int seenPrayerWheel = 0;
    public static int seenQuestionCard = 0;
    public static int seenRedCirclet = 0;
    public static int seenRedMask = 0;
    public static int seenRedSkull = 0;
    public static int seenRegalPillow = 0;
    public static int seenRingoftheSerpent = 0;
    public static int seenRingoftheSnake = 0;
    public static int seenRunicCapacitor = 0;
    public static int seenRunicCube = 0;
    public static int seenRunicDome = 0;
    public static int seenRunicPyramid = 0;
    public static int seenSelfFormingClay = 0;
    public static int seenShovel = 0;
    public static int seenShuriken = 0;
    public static int seenSingingBowl = 0;
    public static int seenSmilingMask = 0;
    public static int seenSnakeSkull = 0;
    public static int seenSneckoEye = 0;
    public static int seenSozu = 0;
    public static int seenSpiritPoop = 0;
    public static int seenStrangeSpoon = 0;
    public static int seenStrawberry = 0;
    public static int seenSundial = 0;
    public static int seenSymbioticVirus = 0;
    public static int seenTest1 = 0;
    public static int seenTest2 = 0;
    public static int seenTest3 = 0;
    public static int seenTest4 = 0;
    public static int seenTest5 = 0;
    public static int seenTest6 = 0;
    public static int seenTest7 = 0;
    public static int seenTest8 = 0;
    public static int seenTheCourier = 0;
    public static int seenTheSpecimen = 0;
    public static int seenThreadandNeedle = 0;
    public static int seenTingsha = 0;
    public static int seenTinyChest = 0;
    public static int seenTinyHouse = 0;
    public static int seenToolbox = 0;
    public static int seenTorii = 0;
    public static int seenToughBandages = 0;
    public static int seenToxicEgg = 0;
    public static int seenToxicEgg2 = 0;
    public static int seenToyOrnithopter = 0;
    public static int seenTurnip = 0;
    public static int seenUnceasingTop = 0;
    public static int seenVajra = 0;
    public static int seenVelvetChoker = 0;
    public static int seenWarPaint = 0;
    public static int seenWhetstone = 0;
    public static int seenWhiteBeastStatue = 0;
    public static int seenBoot = 0;
    public static int seenMarkoftheBloom = 0;
    public static int seenBustedCrown = 0;
    public static int seenIncenseBurner = 0;
    public static int seenEmptyCage = 0;
    public static int seenFusionHammer = 0;
    public static int seenCoffeeDripper = 0;
    public static int seenSsserpentHead = 0;
    public static int seenMutagenicStrength = 0;
    public static int seenFaceOfCleric = 0;
    public static int seenNlothsMask = 0;
    public static int seenGremlinMask = 0;
    public static int seenCultistMask = 0;
    public static int seenTheAbacus = 0;
    public static int seenDollysMirror = 0;
    public static int seenClockworkSouvenir = 0;
    public static int seenMealTicket = 0;
    public static int seenTwistedFunnel = 0;
    public static int seenHandDrill = 0;
    public static int seenHoveringKite = 0;
    public static int seenSling = 0;
    public static int seenOrangePellets = 0;
    public static int seenWristBlade = 0;
    public static int seenStoneCalendar = 0;
    public static int seenNunchaku = 0;
    public static int seenBrimstone = 0;
    public static int seenPreservedInsect = 0;
    public static int seenPocketwatch = 0;
    public static int seenFossilizedHelix = 0;
    public static int seenPrismaticShard = 0;
    public static int seenWarpedTongs = 0;
    public static int seenWingedGreaves = 0;
    public static int seenMawBank = 0;

    public static UUID gameID;
    public static int currentStateID;

    public void createStateJson()
    {
        StateDataDump data = new StateDataDump();
        data.updateStateDataForJson();

        createJson(data);

    }

    public JsonObject createCombatJson()
    {
        createStateJson();

        CombatDataDump data = new CombatDataDump();
        data.updateCombatDataForJson();

        return getActions(data);
    }

    public void createEventJson()
    {
        createStateJson();

        EventDataDump data = new EventDataDump();
        data.updateEventDataForJson();

        createJson(data);

    }

    public void createJson(AbstractDataDump data)
    {
        Gson gson = new GsonBuilder()
                /*
                .registerTypeAdapter(AbstractMonster.class, new MyTypeAdapter<AbstractMonster>())
                .addSerializationExclusionStrategy(new TestExclusionStrategy())
                .addDeserializationExclusionStrategy(new TestExclusionStrategy())
                */
                .setPrettyPrinting()
                .create();
        String type = data.getClass().getSimpleName();

        //TODO :: this should be the end of the method (with return)
        //return gson.toJson(dataDump)

        try {
            Writer writer = new FileWriter("C:\\Users\\Hafez\\IdeaProjects\\NavigateTheSpire\\json\\" + type + "jsonDump.json");
            writer.write(gson.toJson(data));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //TODO :: move to another method or MachineLearningClient class
        String URL = "http://127.0.0.1:5000/navi/" + type + "test-endpoint";
        Client client = ClientBuilder.newClient();
        try
        {
            Response resp = client.target(URL)
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(gson.toJson(data), MediaType.APPLICATION_JSON));

            if ( 200 == resp.getStatus() )
            {
                System.out.println("JsonDump :: client call response OK (200)." );//+ resp.readEntity(String.class));
            }
            else
            {
                System.out.println("ERROR :: response from :: " + URL + " :: was not OK(200), please check that service is running properly.");
            }
        }
        catch ( ProcessingException ex )
        {
            ex.printStackTrace();
        }
    }



    public JsonObject getActions(AbstractDataDump data)
    {
        JsonObject actions = new JsonObject();
        Gson gson = new GsonBuilder()
                /*
                .registerTypeAdapter(AbstractMonster.class, new MyTypeAdapter<AbstractMonster>())
                .addSerializationExclusionStrategy(new TestExclusionStrategy())
                .addDeserializationExclusionStrategy(new TestExclusionStrategy())
                */
                .setPrettyPrinting()
                .create();

        //TODO :: this should be the end of the method (with return)
        //return gson.toJson(dataDump)
        String type = data.getClass().getSimpleName();
        try {
            Writer writer = new FileWriter("C:\\Users\\Hafez\\IdeaProjects\\NavigateTheSpire\\json\\" + type + "jsonDump.json");
            writer.write(gson.toJson(data));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //TODO :: move to another method or MachineLearningClient class
        String URL = "http://127.0.0.1:5000/navi/" + type + "test-endpoint";
        Client client = ClientBuilder.newClient();
        try
        {
            Response resp = client.target(URL)
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(gson.toJson(data), MediaType.APPLICATION_JSON));

            if ( 200 == resp.getStatus() )
            {
                String actionsString = resp.readEntity(String.class);
                JsonParser parser = new JsonParser();
                actions = parser.parse(actionsString).getAsJsonObject();
                System.out.println("JsonDump :: client call response :: " + actionsString);
            }
            else
            {
                System.out.println("ERROR :: response from :: " + URL + " :: was not OK(200), please check that service is running properly.");
            }
        }
        catch ( ProcessingException ex )
        {
            ex.printStackTrace();
        }

        return actions;
    }

}
