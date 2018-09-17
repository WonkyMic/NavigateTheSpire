package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.events.AbstractEvent;
import com.megacrit.cardcrawl.neow.NeowEvent;
import jsonUtil.JsonDump;

@SpirePatch(clz= NeowEvent.class, method=SpirePatch.CONSTRUCTOR, paramtypez = {boolean.class})
public class NeowEventPatch2 {
    public static void Postfix(AbstractEvent event, boolean isDone) {
        //JsonDump jsonDump = new JsonDump();
        //jsonDump.createEventJson();

        int optionToClick = 0;

        event.roomEventText.optionList.get(optionToClick).hb.hovered = true;
        event.roomEventText.optionList.get(optionToClick).hb.clicked = true;
    }
}