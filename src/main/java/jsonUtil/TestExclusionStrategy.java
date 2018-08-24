package jsonUtil;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.FlashPotionEffect;
import com.megacrit.cardcrawl.vfx.cardManip.CardGlowBorder;
import com.megacrit.cardcrawl.vfx.combat.GainPowerEffect;


public class TestExclusionStrategy implements ExclusionStrategy
{
    public boolean shouldSkipClass(Class<?> arg0)
    {
        return (arg0 == AbstractGameEffect.class || arg0 == CardGlowBorder.class || arg0 == FlashPotionEffect.class  || arg0 == GainPowerEffect.class);
    }

    public boolean shouldSkipField(FieldAttributes fieldAttributes)
    {
        return false;
    }
}
