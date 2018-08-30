package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.events.AbstractEvent;
import com.megacrit.cardcrawl.events.beyond.*;
import jsonUtil.JsonDump;

@SpirePatch(clz= Falling.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= MindBloom.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= MoaiHead.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= MysteriousSphere.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= SecretPortal.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= SensoryStone.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= SpireHeart.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= TombRedMask.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= WindingHalls.class, method="buttonEffect", paramtypez = {int.class})
public class BeyondEventPatches {
    public static void Postfix(AbstractEvent event, int i) {
        JsonDump jsonDump = new JsonDump();
        jsonDump.createEventJson();
    }
}

//TODO: if event is SpireHeart then game is won and reward should be very high