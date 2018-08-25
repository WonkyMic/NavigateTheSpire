package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.GenericEventDialog;
import com.megacrit.cardcrawl.ui.buttons.LargeDialogOptionButton;


@SpirePatch(
        clz= GenericEventDialog.class,
        method="removeDialogOption",
        paramtypez = {int.class}
)
public class GenericEventDialog2Patch {
    public static void Postfix (GenericEventDialog event, int removedOption) {
        for (LargeDialogOptionButton option : AbstractDungeon.getCurrRoom().event.imageEventText.optionList) {
            System.out.println("GenericEventDialog: " + option.msg.toString());
        }

        //AbstractDungeon.getCurrRoom().event.imageEventText.optionList.get(0).hb.clicked = true;
    }
}
