package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.helpers.Hitbox;
import com.megacrit.cardcrawl.rooms.TreasureRoom;
import com.megacrit.cardcrawl.ui.buttons.ProceedButton;

import java.lang.reflect.Field;


@SpirePatch(
        clz= TreasureRoom.class,
        method="onPlayerEntry"
)
public class TreasureRoomPatch {
    public static void Postfix (TreasureRoom room) {

        room.chest.open(false);
    }
}
