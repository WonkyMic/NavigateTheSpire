package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.RoomEventDialog;
import com.megacrit.cardcrawl.ui.buttons.LargeDialogOptionButton;


@SpirePatch(
        clz=RoomEventDialog.class,
        method="removeDialogOption",
        paramtypez = {int.class}
)
public class RoomEventDialogPatch2 {
    public static void Postfix (RoomEventDialog event, int removedOption) {
        for (LargeDialogOptionButton option : AbstractDungeon.getCurrRoom().event.roomEventText.optionList) {
            System.out.println("RoomEventDialog: " + option.msg.toString());
        }

        //AbstractDungeon.getCurrRoom().event.roomEventText.optionList.get(0).hb.clicked = true;
    }
}
