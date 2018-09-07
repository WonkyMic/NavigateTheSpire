package jsonUtil;

public class JsonCard {
    public String cardId = "";
    public int costForTurn = -1;
    public int cost = -1;
    public String type = "NONE";
    public int baseBlock = -1;
    public int baseDamage = -1;
    public int baseDiscard = -1;
    public int baseDraw = -1;
    public int baseHeal = -1;
    public int upgraded = 0;
    public int exhaust = 0;
    public int isPlayable = 0;

    public JsonCard() {
    }

    public JsonCard(String id_p, int costForTurn_p, int cost_p, String type_p, int baseBlock_p, int baseDamage_p, int baseDiscard_p, int baseDraw_p, int baseHeal_p, int upgraded_p, int exhaust_p, int isPlayable_p)
    {
        cardId = id_p;
        costForTurn = costForTurn_p;
        cost = cost_p;
        type = type_p;
        baseBlock = baseBlock_p;
        baseDamage = baseDamage_p;
        baseDiscard = baseDiscard_p;
        baseDraw = baseDraw_p;
        baseHeal = baseHeal_p;
        upgraded = upgraded_p;
        exhaust = exhaust_p;
        isPlayable = isPlayable_p;
    }
}
