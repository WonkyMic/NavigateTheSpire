package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.GenericEventDialog;
import com.megacrit.cardcrawl.events.RoomEventDialog;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.screens.select.BossRelicSelectScreen;
import com.megacrit.cardcrawl.ui.buttons.LargeDialogOptionButton;

import java.util.ArrayList;


@SpirePatch(
        clz=RoomEventDialog.class,
        method="show",
        paramtypes = {}
)
public class RoomEventDialogPatch {
    public static void Postfix (RoomEventDialog event) {
        for (LargeDialogOptionButton option : AbstractDungeon.getCurrRoom().event.roomEventText.optionList) {
            System.out.println("RoomEventDialog: " + option.msg.toString());
        }

        //AbstractDungeon.getCurrRoom().event.roomEventText.optionList.get(0).hb.clicked = true;
    }
}