package jsonUtil;

import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.GenericEventDialog;
import com.megacrit.cardcrawl.events.RoomEventDialog;
import com.megacrit.cardcrawl.ui.buttons.LargeDialogOptionButton;

import java.util.ArrayList;
import java.util.UUID;

public class EventDataDump extends AbstractDataDump{

    int currentStateID;
    UUID eventStateID;
    String eventName;
    ArrayList<String> roomEventOptions = new ArrayList<String>();
    ArrayList<String> imageEventOptions = new ArrayList<String>();

    public transient static RoomEventDialog previousRoomEventText = new RoomEventDialog();
    public transient static GenericEventDialog previousImageEventText = new GenericEventDialog();



    public void updateEventDataForJson() {

        eventName = AbstractDungeon.getCurrRoom().event.NAME;
        System.out.println(eventName);

        for (LargeDialogOptionButton option : AbstractDungeon.getCurrRoom().event.roomEventText.optionList)
        {
            roomEventOptions.add(option.msg.toString());
        }

        for (LargeDialogOptionButton option : AbstractDungeon.getCurrRoom().event.imageEventText.optionList)
        {
            imageEventOptions.add(option.msg.toString());
        }

        currentStateID = StateDataDump.currentStateID;
        eventStateID = UUID.randomUUID();

    }

}
