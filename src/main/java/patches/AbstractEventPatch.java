package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.AbstractEvent;
import com.megacrit.cardcrawl.events.RoomEventDialog;
import com.megacrit.cardcrawl.ui.buttons.LargeDialogOptionButton;


@SpirePatch(
        clz= AbstractEvent.class,
        method="updateDialog",
        paramtypes = {}
)
public class AbstractEventPatch {
    public static void Postfix (AbstractEvent event) {
        for (LargeDialogOptionButton option : AbstractDungeon.getCurrRoom().event.roomEventText.optionList) {
            System.out.println("RoomEventDialog: " + option.msg.toString());
        }

        for (LargeDialogOptionButton option : AbstractDungeon.getCurrRoom().event.imageEventText.optionList) {
            System.out.println("GenericEventDialog: " + option.msg.toString());
        }

        if(AbstractDungeon.getCurrRoom().event.roomEventText.optionList.size() > 0) {
            AbstractDungeon.getCurrRoom().event.roomEventText.optionList.get(0).hb.clicked = true;
        }

        if(AbstractDungeon.getCurrRoom().event.imageEventText.optionList.size() > 0) {
            AbstractDungeon.getCurrRoom().event.imageEventText.optionList.get(0).hb.clicked = true;
        }
    }
}
