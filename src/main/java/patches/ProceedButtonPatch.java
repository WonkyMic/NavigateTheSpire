package patches;

import botActions.CombatActions;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.ui.buttons.ProceedButton;

import static botActions.ProceedButtonActions.clickProceedButton;


@SpirePatch(
        clz= ProceedButton.class,
        method="setLabel",
        paramtypez = String.class
)
public class ProceedButtonPatch {
    public static void Postfix (ProceedButton button, String newLabel) {
        //TODO: Uncomment this to allow game to fully self-play
        //clickProceedButton();
        if (AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMPLETE) {
            CombatActions.StartRandomFight();
        }
    }
}
