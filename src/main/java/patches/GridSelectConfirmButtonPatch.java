package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.screens.select.GridCardSelectScreen;
import com.megacrit.cardcrawl.ui.buttons.GridSelectConfirmButton;

import java.lang.reflect.Field;

@SpirePatch(
        clz=GridSelectConfirmButton.class,
        method="show",
        paramtypez={}
)
public class GridSelectConfirmButtonPatch {
    public static void Postfix (GridSelectConfirmButton button)
    {
        System.out.println("GridSelectConfirmButton show");
        button.hb.hovered = true;
        button.hb.clicked = true;
    }
}
