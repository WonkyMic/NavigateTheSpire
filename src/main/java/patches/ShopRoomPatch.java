package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.ShopRoom;
import com.megacrit.cardcrawl.shop.ShopScreen;
import com.megacrit.cardcrawl.shop.StorePotion;
import com.megacrit.cardcrawl.shop.StoreRelic;

import java.lang.reflect.Field;
import java.util.ArrayList;


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
