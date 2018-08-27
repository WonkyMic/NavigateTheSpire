package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.ui.buttons.GridSelectConfirmButton;

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
