package jsonUtil;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.UUID;

public class CombatDataDump extends AbstractDataDump{

    UUID currentStateID;
    UUID combatStateID;

    //player information
    int currentBlock;
    ArrayList<String> currentPowers = new ArrayList<String>();
    int currentEnergy;
    int maxEnergy;
    ArrayList<String> hand = new ArrayList<String>();
    ArrayList<String> exhaustPile = new ArrayList<String>();
    ArrayList<String> discardPile = new ArrayList<String>();
    ArrayList<String> drawPile = new ArrayList<String>();
    ArrayList<String> currentOrbs = new ArrayList<String>();
    int orbSlots;

    //monster information
    ArrayList<JsonEnemy> jsonEnemyArrayList = new ArrayList<JsonEnemy>();
    transient int enemyCurrentHealth;
    transient int enemyMaxHealth;
    transient int enemyCurrentBlock;
    transient String enemyIntent;
    transient int enemyIntentDamage = 0;
    transient int enemyIntentBaseDamage = 0;
    transient int enemyIntentMultiAmount = 0;
    transient boolean enemyIntentIsMultiAttack = false;
    transient ArrayList<String> enemyPowers = new ArrayList<String>();

    public void updateCombatDataForJson() {

        currentStateID = StateDataDump.currentStateID;
        combatStateID = UUID.randomUUID();

        AbstractPlayer p = AbstractDungeon.player;

        //get player information
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
        //TODO: get list of all relics seen


        if (AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT) {
            if (p.orbs != null) {
                for (int i = 0; i < p.orbs.size(); i++) {
                    currentOrbs.add(p.orbs.get(i).name);
                }
            }
            orbSlots = p.maxOrbs;
        }

        //get monster information

        if (AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT) {
            ArrayList<AbstractMonster> enemies = AbstractDungeon.getCurrRoom().monsters.monsters;
            for (AbstractMonster enemy : enemies) {
                enemyCurrentHealth = enemy.currentHealth;
                enemyMaxHealth = enemy.maxHealth;
                enemyCurrentBlock = enemy.currentBlock;
                enemyIntent = enemy.intent.toString();
                try {

                    Field f1 = AbstractMonster.class.getDeclaredField("intentDmg");
                    f1.setAccessible(true);
                    enemyIntentDamage = (int) f1.get(enemy);

                    Field f2 = AbstractMonster.class.getDeclaredField("intentBaseDmg");
                    f2.setAccessible(true);
                    enemyIntentBaseDamage = f2.getInt(enemy);

                    Field f3 = AbstractMonster.class.getDeclaredField("intentMultiAmt");
                    f3.setAccessible(true);
                    enemyIntentMultiAmount = f3.getInt(enemy);

                    Field f4 = AbstractMonster.class.getDeclaredField("isMultiDmg");
                    f4.setAccessible(true);
                    enemyIntentIsMultiAttack = f4.getBoolean(enemy);


                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }

                for (int j = 0; j < enemy.powers.size(); j++) {
                    enemyPowers.add(enemy.powers.get(j).name);
                }

                jsonEnemyArrayList.add(new JsonEnemy(enemyCurrentHealth, enemyMaxHealth, enemyCurrentBlock, enemyIntent, enemyIntentDamage, enemyIntentBaseDamage, enemyIntentMultiAmount, enemyIntentIsMultiAttack, enemyPowers));
            }
        }
    }

}
