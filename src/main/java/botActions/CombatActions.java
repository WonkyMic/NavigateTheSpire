package botActions;

import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.map.MapEdge;
import com.megacrit.cardcrawl.map.MapRoomNode;
import com.megacrit.cardcrawl.rooms.MonsterRoom;

import java.util.ArrayList;
import java.util.Iterator;

public class CombatActions {
    public static void StartFight(String encounterName) {
            AbstractDungeon.monsterList.add(0, encounterName);
            MapRoomNode cur = AbstractDungeon.currMapNode;
            MapRoomNode node = new MapRoomNode(cur.x, cur.y);
            node.room = new MonsterRoom();
            ArrayList<MapEdge> curEdges = cur.getEdges();
            Iterator var6 = curEdges.iterator();

            while(var6.hasNext()) {
                MapEdge edge = (MapEdge)var6.next();
                node.addEdge(edge);
            }

            AbstractDungeon.nextRoom = node;
            AbstractDungeon.nextRoomTransitionStart();
    }
}
