package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.rooms.TreasureRoom;


@SpirePatch(
        clz= TreasureRoom.class,
        method="onPlayerEntry"
)
public class TreasureRoomPatch {
    public static void Postfix (TreasureRoom room) {

        room.chest.open(false);
    }
}
