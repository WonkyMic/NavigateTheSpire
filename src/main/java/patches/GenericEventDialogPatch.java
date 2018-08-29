package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.GenericEventDialog;
import com.megacrit.cardcrawl.ui.buttons.LargeDialogOptionButton;
import jsonUtil.JsonDump;

import static jsonUtil.EventDataDump.previousImageEventText;
import static jsonUtil.EventDataDump.previousRoomEventText;


@SpirePatch(
        clz= GenericEventDialog.class,
        method="show",
        paramtypez = {String.class, String.class}
)
public class GenericEventDialogPatch {
    public static void Postfix (GenericEventDialog screen, String s, String s1) {

        JsonDump jsonDump = new JsonDump();
        jsonDump.createEventJson();

    }
}
