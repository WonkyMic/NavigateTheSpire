package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.ShopRoom;


@SpirePatch(
        clz= ShopRoom.class,
        method="onPlayerEntry",
        paramtypes = {}
)
public class ShopRoomPatch {
    public static void Postfix (ShopRoom room) {
        AbstractDungeon.shopScreen.open();
    }
}
