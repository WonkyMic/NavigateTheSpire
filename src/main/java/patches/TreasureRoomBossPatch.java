package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.rooms.TreasureRoom;
import com.megacrit.cardcrawl.rooms.TreasureRoomBoss;


@SpirePatch(
        clz= TreasureRoomBoss.class,
        method="onPlayerEntry"
)
public class TreasureRoomBossPatch {
    public static void Postfix (TreasureRoomBoss room) {

        room.chest.open(true);
    }
}
