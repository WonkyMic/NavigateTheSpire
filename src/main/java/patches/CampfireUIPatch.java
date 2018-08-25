package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.GenericEventDialog;
import com.megacrit.cardcrawl.rooms.CampfireUI;
import com.megacrit.cardcrawl.ui.buttons.LargeDialogOptionButton;
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
        try {
            Field f = c.getDeclaredField("buttons");
            f.setAccessible(true);
            ArrayList<AbstractCampfireOption> options = (ArrayList<AbstractCampfireOption>)f.get(campfire);
            for (AbstractCampfireOption option : options) {
                System.out.println("GenericEventDialog: " + option.toString());
            }
            options.get(0).hb.clicked = true;
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
