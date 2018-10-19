package relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import powers.AutoPlayFormPower;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class AutoPlayRelic extends CustomRelic {
    public static final String ID = "Navi";

    public AutoPlayRelic() {
        super(
                ID,
                new Texture(Gdx.files.internal("img/relics/navi.png")),
                new Texture(Gdx.files.internal("img/relics/outlines/navi.png")),
                RelicTier.STARTER,
                LandingSound.MAGICAL);
    }


    @Override
    public AbstractRelic makeCopy() {
        return new AutoPlayRelic();
    }

    @Override
    public void atBattleStartPreDraw()
    {
        AbstractPlayer p = AbstractDungeon.player;
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new AutoPlayFormPower(p, 1), 1));
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + DESCRIPTIONS[1] + DESCRIPTIONS[2];
    }

    @Override
    public void atTurnStartPostDraw()
    {
        System.out.println("atTurnStartPostDraw From Relic");
        String URL = "http://127.0.0.1:5000/navi/turn-start-endpoint";
        Client client = ClientBuilder.newClient();
        try
        {
            Response resp = client.target(URL)
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.json(""));

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
        AbstractDungeon.actionManager.addToBottom(new actions.PlayCardFromHandAction());
    }

    @Override
    public void onUsePotion()
    {
        //TODO: Check if in combat first
        System.out.println("onUsePotion From Relic");
        AbstractDungeon.actionManager.addToBottom(new actions.PlayCardFromHandAction());
    }
}
