package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.events.AbstractEvent;
import com.megacrit.cardcrawl.events.city.*;
import com.megacrit.cardcrawl.neow.NeowEvent;
import jsonUtil.JsonDump;

@SpirePatch(clz= NeowEvent.class, method="buttonEffect", paramtypez = {int.class})
public class NeowEventPatches {
    public static void Postfix(AbstractEvent event, int i) {
        JsonDump jsonDump = new JsonDump();
        jsonDump.createEventJson();
    }
}