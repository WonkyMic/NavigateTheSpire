package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.GenericEventDialog;
import com.megacrit.cardcrawl.events.RoomEventDialog;
import com.megacrit.cardcrawl.ui.buttons.LargeDialogOptionButton;


@SpirePatch(
        clz= GenericEventDialog.class,
        method="show",
        paramtypes = {}
)
public class GenericEventDialogPatch {
    public static void Postfix () {
        for (LargeDialogOptionButton option : AbstractDungeon.getCurrRoom().event.imageEventText.optionList) {
            System.out.println("GenericEventDialog: " + option.msg.toString());
        }

        //AbstractDungeon.getCurrRoom().event.imageEventText.optionList.get(0).hb.clicked = true;
    }
}
