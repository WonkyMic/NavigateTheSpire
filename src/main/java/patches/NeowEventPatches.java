package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.events.AbstractEvent;
import com.megacrit.cardcrawl.events.city.*;
import com.megacrit.cardcrawl.neow.NeowEvent;
import com.megacrit.cardcrawl.neow.NeowReward;
import jsonUtil.JsonDump;

@SpirePatch(clz= NeowEvent.class, method="buttonEffect", paramtypez = {int.class})
public class NeowEventPatches {
    public static void Postfix(NeowEvent event, int i) {
        //JsonDump jsonDump = new JsonDump();
        //jsonDump.createEventJson();

        int optionToClick = 0;

        event.roomEventText.optionList.get(optionToClick).hb.hovered = true;
        event.roomEventText.optionList.get(optionToClick).hb.clicked = true;
    }
}