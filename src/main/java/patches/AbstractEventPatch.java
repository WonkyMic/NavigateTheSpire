package patches;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.AbstractEvent;
import com.megacrit.cardcrawl.events.GenericEventDialog;
import com.megacrit.cardcrawl.events.RoomEventDialog;
import com.megacrit.cardcrawl.ui.buttons.LargeDialogOptionButton;
import jsonUtil.JsonDump;

import static jsonUtil.EventDataDump.previousImageEventText;
import static jsonUtil.EventDataDump.previousRoomEventText;


@SpirePatch(
        clz= AbstractEvent.class,
        method="renderText",
        paramtypez = {SpriteBatch.class}
)
public class AbstractEventPatch {

    public static void Postfix (AbstractEvent event, SpriteBatch sb) {

        if (event.roomEventText != previousRoomEventText) {
            for (LargeDialogOptionButton option : AbstractDungeon.getCurrRoom().event.roomEventText.optionList) {
                previousRoomEventText = event.roomEventText;
                JsonDump jsonDump = new JsonDump();
                jsonDump.createEventJson();
            }
        }

    }
}
