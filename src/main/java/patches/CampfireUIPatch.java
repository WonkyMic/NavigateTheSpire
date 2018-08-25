package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.GenericEventDialog;
import com.megacrit.cardcrawl.helpers.Hitbox;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.rooms.CampfireUI;
import com.megacrit.cardcrawl.ui.buttons.LargeDialogOptionButton;
import com.megacrit.cardcrawl.ui.buttons.ProceedButton;
import com.megacrit.cardcrawl.ui.campfire.AbstractCampfireOption;

import java.lang.reflect.Field;
import java.util.ArrayList;


@SpirePatch(
        clz= CampfireUI.class,
        method="initializeButtons",
        paramtypes = {}
)
public class CampfireUIPatch {
    public static void Postfix (CampfireUI campfire) {
        Class<?> c = campfire.getClass();
        if(AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMPLETE)
        {
            Class<?> c1 = AbstractDungeon.overlayMenu.proceedButton.getClass();
            try {
                Field f1 = c1.getDeclaredField("hb");
                f1.setAccessible(true);
                Hitbox h = (Hitbox) f1.get(AbstractDungeon.overlayMenu.proceedButton);
                h.hovered = true;
                h.clicked = true;
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                Field f = c.getDeclaredField("buttons");
                f.setAccessible(true);
                ArrayList<AbstractCampfireOption> options = (ArrayList<AbstractCampfireOption>) f.get(campfire);
                for (AbstractCampfireOption option : options)
                    {
                        System.out.println("campfire options: " + option.toString());
                    }
                    options.get(0).hb.clicked = true;
                }
                catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }
}
