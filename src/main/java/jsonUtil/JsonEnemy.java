package jsonUtil;

import java.util.ArrayList;

public class JsonEnemy {
    public String id = "";
    public int currentHealth = 0;
    public int maxHealth = 0;
    public int currentBlock = 0;
    public String intent = "NONE";
    public int intentDamage = 0;
    public int intentBaseDamage = 0;
    public int intentMultiAmount = 0;
    public int isMultiAttack = 0;
    public ArrayList<JsonPower> enemypowers = new ArrayList<JsonPower>();

    public JsonEnemy() {
        while (enemypowers.size() < 30)
        {
            enemypowers.add(new JsonPower());
        }
    }

    public JsonEnemy(String id_p, int currentHealth_p, int maxHealth_p, int currentBlock_p, String intent_p, int intentDamage_p, int intentBaseDamage_p, int intentMultiAmount_p, int isMultiAttack_p, ArrayList<JsonPower> powers_p)
    {
        id = id_p;
        currentHealth = currentHealth_p;
        maxHealth = maxHealth_p;
        currentBlock = currentBlock_p;
        intent = intent_p;
        intentDamage = intentDamage_p;
        intentBaseDamage = intentBaseDamage_p;
        intentMultiAmount = intentMultiAmount_p;
        isMultiAttack = isMultiAttack_p;
        enemypowers = powers_p;
    }
}
