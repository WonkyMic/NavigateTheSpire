package jsonUtil;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;
import java.util.UUID;

public class StateDataDump extends AbstractDataDump {

    //game information
    public static UUID gameID;
    public static int currentStateID;
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


    public void updateStateDataForJson() {

        currentStateID++;
        floorNum = AbstractDungeon.floorNum;
        actNum = AbstractDungeon.actNum;
        roomType = AbstractDungeon.getCurrRoom().getMapSymbol();

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
        if (p.potions != null) {
            for (int i = 0; i < p.potions.size(); i++) {
                potions.add(p.potions.get(i).ID);
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

