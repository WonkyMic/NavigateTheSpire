package jsonUtil;

import java.util.ArrayList;

public class JsonEnemy {
    public int currentHealth;
    public int maxHealth;
    public int currentBlock;
    public String intent;
    public int intentDamage;
    public int intentBaseDamage;
    public int intentMultiAmount;
    public boolean isMultiAttack;
    public ArrayList<String> powers;

    public JsonEnemy(int currentHealth_p, int maxHealth_p, int currentBlock_p, String intent_p, int intentDamage_p, int intentBaseDamage_p, int intentMultiAmount_p, boolean isMultiAttack_p, ArrayList<String> powers_p)
    {
        currentHealth = currentHealth_p;
        maxHealth = maxHealth_p;
        currentBlock = currentBlock_p;
        intent = intent_p;
        intentDamage = intentDamage_p;
        intentBaseDamage = intentBaseDamage_p;
        intentMultiAmount = intentMultiAmount_p;
        isMultiAttack = isMultiAttack_p;
        powers = powers_p;
    }
}
