package botActions;

import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class EventChoiceActions {
    public void chooseEventOption(int indexOfChoice)
    {
        if(AbstractDungeon.getCurrRoom().event.roomEventText.optionList.size() > 0) {
            AbstractDungeon.getCurrRoom().event.roomEventText.optionList.get(indexOfChoice).hb.clicked = true;
        }

        if(AbstractDungeon.getCurrRoom().event.imageEventText.optionList.size() > 0) {
            AbstractDungeon.getCurrRoom().event.imageEventText.optionList.get(indexOfChoice).hb.clicked = true;
        }
    }
}
