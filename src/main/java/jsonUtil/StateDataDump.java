package jsonUtil;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;
import java.util.UUID;

public class StateDataDump extends AbstractDataDump {

    //game information
    public static UUID gameID;
    public static UUID currentStateID;
    int floorNum;
    int actNum;

    //player information
    String chosenClass;
    int currentHealth;
    int maxHealth;
    ArrayList<String> deck = new ArrayList<String>();
    ArrayList<String> potions = new ArrayList<String>();
    int currentGold;
    ArrayList<String> relicsOwned = new ArrayList<String>();
    public static ArrayList<String> relicsSeen; //TODO: get list of all relics seen

    public void updateStateDataForJson() {

        currentStateID = UUID.randomUUID();
        floorNum = AbstractDungeon.floorNum;
        actNum = AbstractDungeon.actNum;

        AbstractPlayer p = AbstractDungeon.player;

        //get player information

        chosenClass = p.chosenClass.toString();
        currentHealth = p.currentHealth;
        maxHealth = p.maxHealth;
        if (p.masterDeck.group != null) {
            for (int i = 0; i < p.masterDeck.group.size(); i++) {
                deck.add(p.masterDeck.group.get(i).name);
            }
        }
        if (p.potions != null) {
            for (int i = 0; i < p.potions.size(); i++) {
                potions.add(p.potions.get(i).name);
            }
        }
        currentGold = p.gold;
        if (p.relics != null) {
            for (int i = 0; i < p.relics.size(); i++) {
                relicsOwned.add(p.relics.get(i).name);
            }
        }
        }
    }

