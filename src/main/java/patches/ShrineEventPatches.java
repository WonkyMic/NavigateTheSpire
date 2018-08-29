package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.events.AbstractEvent;
import com.megacrit.cardcrawl.events.shrines.*;
import jsonUtil.JsonDump;

@SpirePatch(clz= AccursedBlacksmith.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= Bonfire.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= Designer.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= Duplicator.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= FaceTrader.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= FountainOfCurseRemoval.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= GoldShrine.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= Lab.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= NoteForYourself.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= PurificationShrine.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= Transmogrifier.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= UpgradeShrine.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= WeMeetAgain.class, method="buttonEffect", paramtypez = {int.class})
@SpirePatch(clz= WomanInBlue.class, method="buttonEffect", paramtypez = {int.class})
public class ShrineEventPatches {
    public static void Postfix(AbstractEvent event, int i) {
        JsonDump jsonDump = new JsonDump();
        jsonDump.createEventJson();
    }
}