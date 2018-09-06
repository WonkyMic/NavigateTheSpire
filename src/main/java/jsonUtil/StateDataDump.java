package jsonUtil;

import Map.MapUtil;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;
import java.util.UUID;

public class StateDataDump extends AbstractDataDump {


    UUID gameID;
    int currentStateID;
    //game information
    int floorNum;
    int actNum;
    String roomType;

    //player information
    String chosenClass;
    int currentHealth;
    int maxHealth;
    ArrayList<String> deck = new ArrayList<String>();
    ArrayList<String> potions = new ArrayList<String>();
    int currentGold;
    ArrayList<String> relicsOwned = new ArrayList<String>();
    ArrayList<String> relicsSeen;
    transient ArrayList<String> availablePathArrayList = new ArrayList<String>();


    public void updateStateDataForJson() {

        gameID = JsonDump.gameID;
        JsonDump.currentStateID++;
        currentStateID = JsonDump.currentStateID;
        floorNum = AbstractDungeon.floorNum;
        actNum = AbstractDungeon.actNum;
        roomType = AbstractDungeon.getCurrRoom().getMapSymbol();
        MapUtil mUtil = new MapUtil();
        availablePathArrayList = mUtil.createAvailablePathArrayList(AbstractDungeon.getCurrMapNode());

        AbstractPlayer p = AbstractDungeon.player;

        //get player information

        chosenClass = p.chosenClass.toString();
        currentHealth = p.currentHealth;
        maxHealth = p.maxHealth;
        while (deck.size() < 200)
        {
            deck.add("");
        }
        if (p.masterDeck.group != null) {
            for (int i = 0; i < p.masterDeck.group.size(); i++) {
                deck.set(i, p.masterDeck.group.get(i).cardID);
            }
        }
        while (potions.size() < 5)
        {
            potions.add("");
        }
        if (p.potions != null) {
            for (int i = 0; i < p.potions.size(); i++) {
                potions.set(i, p.potions.get(i).ID);
            }
        }
        currentGold = p.gold;
        while (relicsOwned.size() < 200)
        {
            relicsOwned.add("");
        }
        if (p.relics != null) {
            for (int i = 0; i < p.relics.size(); i++) {
                relicsOwned.set(i, p.relics.get(i).relicId);
            }
        }
        relicsSeen = JsonDump.relicsSeen;
        }
    }

