package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.screens.select.BossRelicSelectScreen;

import java.util.ArrayList;


@SpirePatch(
        clz=BossRelicSelectScreen.class,
        method="open",
        paramtypez= ArrayList.class
)
public class BossRelicSelectScreenPatch {
    public static void Postfix (BossRelicSelectScreen screen, ArrayList<AbstractRelic> relicInput) {
        AbstractRelic r = (AbstractRelic)screen.relics.get(0);
        if (!r.relicId.equals("Black Blood") && !r.relicId.equals("Ring of the Serpent")) {
            r.obtain();
        }
        r.isObtained = true;
        }
    }
