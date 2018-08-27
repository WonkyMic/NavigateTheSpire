package relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import powers.AutoPlayFormPower;

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
        AbstractDungeon.actionManager.addToBottom(new actions.PlayCardFromHandAction());
    }
}
