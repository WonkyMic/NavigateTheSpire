package jsonUtil;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class DataDump {

    //player information
    String chosenClass;
    int currentHealth;
    int maxHealth;
    int currentBlock;
    ArrayList<String> currentPowers = new ArrayList<String>();
    int currentEnergy;
    int maxEnergy;
    ArrayList<String> hand = new ArrayList<String>();
    ArrayList<String> exhaustPile = new ArrayList<String>();
    ArrayList<String> discardPile = new ArrayList<String>();
    ArrayList<String> drawPile = new ArrayList<String>();
    ArrayList<String> deck = new ArrayList<String>();
    ArrayList<String> potions = new ArrayList<String>();
    int currentGold;
    ArrayList<String> relicsOwned = new ArrayList<String>();
    ArrayList<String> relicsSeen; //TODO: get list of all relics seen
    ArrayList<String> currentOrbs = new ArrayList<String>();
    int orbSlots;

    //monster information
    ArrayList<JsonEnemy> jsonEnemyArrayList = new ArrayList<JsonEnemy>();
    int enemyCurrentHealth;
    int enemyMaxHealth;
    int enemyCurrentBlock;
    String enemyIntent;
    int enemyIntentDamage = 0;
    int enemyIntentBaseDamage = 0;
    int enemyIntentMultiAmount = 0;
    boolean enemyIntentIsMultiAttack = false;
    ArrayList<String> enemyPowers = new ArrayList<String>();
    public void updateDataForJson() {

        AbstractPlayer p = AbstractDungeon.player;

        //get player information

        chosenClass = p.chosenClass.toString();
        currentHealth = p.currentHealth;
        maxHealth = p.maxHealth;
        currentBlock = p.currentBlock;
        if (p.powers != null) {
            for (int i = 0; i < p.powers.size(); i++) {
                currentPowers.add(p.powers.get(i).name);
            }
        }
        currentEnergy = EnergyPanel.getCurrentEnergy();
        maxEnergy = p.energy.energy;
        if (p.hand.group != null) {
            for (int i = 0; i < p.hand.group.size(); i++) {
                hand.add(p.hand.group.get(i).name);
            }
        }
        if (p.exhaustPile.group != null) {
            for (int i = 0; i < p.exhaustPile.group.size(); i++) {
                exhaustPile.add(p.exhaustPile.group.get(i).name);
            }
        }
        if (p.discardPile.group != null) {
            for (int i = 0; i < p.discardPile.group.size(); i++) {
                discardPile.add(p.discardPile.group.get(i).name);
            }
        }
        if (p.drawPile.group != null) {
            for (int i = 0; i < p.drawPile.group.size(); i++) {
                drawPile.add(p.drawPile.group.get(i).name);
            }
        }
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
        //relicsSeen; //TODO: get list of all relics seen
        if (p.orbs != null) {
            for (int i = 0; i < p.orbs.size(); i++) {
                currentOrbs.add(p.orbs.get(i).name);
            }
        }
        orbSlots = p.maxOrbs;




        //get monster information
        ArrayList<AbstractMonster> enemy = AbstractDungeon.getCurrRoom().monsters.monsters;
        for (int i = 0; i < enemy.size(); i++){
            enemyCurrentHealth = enemy.get(i).currentHealth;
            enemyMaxHealth = enemy.get(i).maxHealth;
            enemyCurrentBlock = enemy.get(i).currentBlock;
            enemyIntent = enemy.get(i).intent.toString();
            try {

                Field f1 = AbstractMonster.class.getDeclaredField("intentDmg");
                f1.setAccessible(true);
                enemyIntentDamage = (int) f1.get(enemy.get(i));

                Field f2 = AbstractMonster.class.getDeclaredField("intentBaseDmg");
                f2.setAccessible(true);
                enemyIntentBaseDamage = f2.getInt(enemy.get(i));

                Field f3 = AbstractMonster.class.getDeclaredField("intentMultiAmt");
                f3.setAccessible(true);
                enemyIntentMultiAmount = f3.getInt(enemy.get(i));

                Field f4 = AbstractMonster.class.getDeclaredField("isMultiDmg");
                f4.setAccessible(true);
                enemyIntentIsMultiAttack = f4.getBoolean(enemy.get(i));



            }
            catch (NoSuchFieldException | IllegalAccessException e)
            {
                e.printStackTrace();
            }

            for (int j = 0; j < enemy.get(i).powers.size(); j++){
                enemyPowers.add(enemy.get(i).powers.get(j).name);
            }

            jsonEnemyArrayList.add(new JsonEnemy(enemyCurrentHealth, enemyMaxHealth, enemyCurrentBlock, enemyIntent, enemyIntentDamage, enemyIntentBaseDamage, enemyIntentMultiAmount, enemyIntentIsMultiAttack, enemyPowers));
        }
    }

}
