package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.events.AbstractEvent;
import com.megacrit.cardcrawl.events.exordium.*;
import jsonUtil.JsonDump;

@SpirePatch(clz= BigFish.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= Cleric.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= DeadAdventurer.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= GoldenIdolEvent.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= GoldenWing.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= GoopPuddle.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= LivingWall.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= Mushrooms.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= Nloth.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= ScrapOoze.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= ShiningLight.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= Sssserpent.class, method="buttonEffect", paramtypez = {int.class})
public class ExordiumEventPatches {
    public static void Postfix(AbstractEvent event, int i) {
        JsonDump jsonDump = new JsonDump();
        jsonDump.createEventJson();
    }
}