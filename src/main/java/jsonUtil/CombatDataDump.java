package jsonUtil;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
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
    ArrayList<JsonPower> currentPowers = new ArrayList<JsonPower>();
    int currentEnergy;
    int maxEnergy;
    ArrayList<JsonCard> jsonCardArrayListHand = new ArrayList<JsonCard>();
    ArrayList<JsonCard> jsonCardArrayListExhaustPile = new ArrayList<JsonCard>();
    ArrayList<JsonCard> jsonCardArrayListDiscardPile = new ArrayList<JsonCard>();
    ArrayList<JsonCard> jsonCardArrayListDrawPile = new ArrayList<JsonCard>();
    ArrayList<String> currentOrbs = new ArrayList<String>();
    int orbSlots;

    //monster information
    ArrayList<JsonEnemy> jsonEnemyArrayList = new ArrayList<JsonEnemy>();
    transient String enemyID;
    transient int enemyCurrentHealth;
    transient int enemyMaxHealth;
    transient int enemyCurrentBlock;
    transient String enemyIntent;
    transient int enemyIntentDamage = 0;
    transient int enemyIntentBaseDamage = 0;
    transient int enemyIntentMultiAmount = 0;
    transient int enemyIntentIsMultiAttack = 0;
    transient ArrayList<JsonPower> enemyPowers = new ArrayList<JsonPower>();

    public void updateCombatDataForJson() {

        currentStateID = JsonDump.currentStateID;
        combatStateID = UUID.randomUUID();
        gameID = JsonDump.gameID;

        AbstractPlayer p = AbstractDungeon.player;

        //get player information
        currentBlock = p.currentBlock;
        while (currentPowers.size() < 30)
        {
            currentPowers.add(new JsonPower());
        }
        if (p.powers != null) {
            for (int i = 0; i < p.powers.size(); i++) {

                currentPowers.set(i, new JsonPower(p.powers.get(i).ID, p.powers.get(i).amount));
            }
        }
        currentEnergy = EnergyPanel.getCurrentEnergy();
        maxEnergy = p.energy.energy;
        while (jsonCardArrayListHand.size() < 10)
        {
            jsonCardArrayListHand.add(new JsonCard());
        }
        if (p.hand.group != null) {
            for (int i = 0; i < p.hand.group.size(); i++) {
                AbstractCard c = p.hand.group.get(i);
                jsonCardArrayListHand.set(i, new JsonCard(c.cardID, c.costForTurn, c.cost, c.type.toString(), c.baseBlock, c.baseDamage, c.baseDiscard, c.baseDraw, c.baseHeal, (c.upgraded) ? 1 : 0, (c.exhaust) ? 1 : 0));
            }
        }
        while (jsonCardArrayListExhaustPile.size() < 100)
        {
            jsonCardArrayListExhaustPile.add(new JsonCard());
        }
        if (p.exhaustPile.group != null) {
            for (int i = 0; i < p.exhaustPile.group.size(); i++) {
                AbstractCard c = p.exhaustPile.group.get(i);
                jsonCardArrayListExhaustPile.set(i, new JsonCard(c.cardID, c.costForTurn, c.cost, c.type.toString(), c.baseBlock, c.baseDamage, c.baseDiscard, c.baseDraw, c.baseHeal, (c.upgraded) ? 1 : 0, (c.exhaust) ? 1 : 0));
            }
        }
        while (jsonCardArrayListDiscardPile.size() < 100)
        {
            jsonCardArrayListDiscardPile.add(new JsonCard());
        }
        if (p.discardPile.group != null) {
            for (int i = 0; i < p.discardPile.group.size(); i++) {
                AbstractCard c = p.discardPile.group.get(i);
                jsonCardArrayListDiscardPile.set(i, new JsonCard(c.cardID, c.costForTurn, c.cost, c.type.toString(), c.baseBlock, c.baseDamage, c.baseDiscard, c.baseDraw, c.baseHeal, (c.upgraded) ? 1 : 0, (c.exhaust) ? 1 : 0));
            }
        }
        while (jsonCardArrayListDrawPile.size() < 200)
        {
            jsonCardArrayListDrawPile.add(new JsonCard());
        }
        if (p.drawPile.group != null) {
            for (int i = 0; i < p.drawPile.group.size(); i++) {
                AbstractCard c = p.drawPile.group.get(i);
                jsonCardArrayListDrawPile.set(i, new JsonCard(c.cardID, c.costForTurn, c.cost, c.type.toString(), c.baseBlock, c.baseDamage, c.baseDiscard, c.baseDraw, c.baseHeal, (c.upgraded) ? 1 : 0, (c.exhaust) ? 1 : 0));
            }
        }
        //TODO: get list of all relics seen

        while (currentOrbs.size() < 10)
        {
            currentOrbs.add("");
        }
        if (AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT) {
            if (p.orbs != null) {
                for (int i = 0; i < p.orbs.size(); i++) {
                    currentOrbs.set(i,p.orbs.get(i).ID);
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
                enemyID = enemy.id;
                enemyCurrentHealth = enemy.currentHealth;
                enemyMaxHealth = enemy.maxHealth;
                enemyCurrentBlock = enemy.currentBlock;
                enemyIntent = enemy.intent.toString();
                enemyPowers = new ArrayList<JsonPower>();
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
                    boolean tmp = f4.getBoolean(enemy);
                    if(tmp)
                    {
                        enemyIntentIsMultiAttack = 1;
                    }
                    else
                    {
                        enemyIntentIsMultiAttack = 0;
                    }


                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                while (enemyPowers.size() < 30)
                {
                    enemyPowers.add(new JsonPower());
                }
                for (int j = 0; j < enemy.powers.size(); j++) {
                    enemyPowers.set(j, new JsonPower(enemy.powers.get(j).ID, enemy.powers.get(j).amount));
                }

                jsonEnemyArrayList.set(i, new JsonEnemy(enemyID, enemyCurrentHealth, enemyMaxHealth, enemyCurrentBlock, enemyIntent, enemyIntentDamage, enemyIntentBaseDamage, enemyIntentMultiAmount, enemyIntentIsMultiAttack, enemyPowers));
            }
        }
    }

}
