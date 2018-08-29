package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.ui.buttons.ProceedButton;

import static botActions.ProceedButtonActions.clickProceedButton;


@SpirePatch(
        clz= ProceedButton.class,
        method="setLabel",
        paramtypez = String.class
)
public class ProceedButtonPatch {
    public static void Postfix (ProceedButton button, String newLabel) {
        clickProceedButton();
    }
}
