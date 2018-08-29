package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.events.AbstractEvent;
import com.megacrit.cardcrawl.events.city.*;
import jsonUtil.JsonDump;

@SpirePatch(clz= Addict.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= BackToBasics.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= Beggar.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= Colosseum.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= CursedTome.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= DrugDealer.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= ForgottenAltar.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= Ghosts.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= KnowingSkull.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= MaskedBandits.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= Nest.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= TheJoust.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= TheLibrary.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= TheMausoleum.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= Vampires.class, method="buttonEffect", paramtypez = {int.class})
public class CityEventPatches {
    public static void Postfix(AbstractEvent event, int i) {
        JsonDump jsonDump = new JsonDump();
        jsonDump.createEventJson();
    }
}