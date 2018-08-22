package Map;

import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.map.MapEdge;
import com.megacrit.cardcrawl.map.MapRoomNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class MapUtil
{
    ArrayList<ArrayList<MapRoomNode>> mapNodes = AbstractDungeon.map;
    ArrayList<ArrayList<MapRoomNode>> paths = new ArrayList<ArrayList<MapRoomNode>>();

    public void getNextMapRoomNode(MapRoomNode currentNode)
    {
        ArrayList<ArrayList<MapRoomNode>> nodesToIterateOver = new ArrayList<ArrayList<MapRoomNode>>();
        int getNode = 0;
        if ( currentNode.y < 0 )
        {
            nodesToIterateOver.addAll(mapNodes);
        }
        else
        {
            getNode = 1;
            nodesToIterateOver.add(new ArrayList<MapRoomNode>(Arrays.asList(currentNode)));
        }

        MapRoomNode nextNode = createOptimalPath(nodesToIterateOver).get(getNode);

        // Trigger nextNode
        AbstractDungeon.nextRoom = nextNode;
        CardCrawlGame.music.fadeOutTempBGM();
        AbstractDungeon.pathX.add(Integer.valueOf(nextNode.x));
        AbstractDungeon.pathY.add(Integer.valueOf(nextNode.y));
        AbstractDungeon.topLevelEffects.add(new com.megacrit.cardcrawl.vfx.FadeWipeParticle());
        AbstractDungeon.nextRoomTransitionStart();
    }

    private ArrayList<MapRoomNode> createOptimalPath(ArrayList<ArrayList<MapRoomNode>> nodesToIterateOver)
    {
        // Build all possible paths
        for (MapRoomNode node : nodesToIterateOver.get(0)) {
            if (node.hasEdges()) {
                ArrayList<MapRoomNode> path = new ArrayList<MapRoomNode>();
                addNodeToPath(node, path);
            }
        }

        // Parse all possible paths to get room type and pick the one with the most elites
        return pickBestPath();
    }

    private ArrayList<MapRoomNode> pickBestPath()
    {
        // Storing path as:
        //      key   :: index within paths
        //      value :: Evaluated value from class EvaluatePath
        Map<Integer, Integer> pathEvaluated = new HashMap<Integer, Integer>();

        for ( int i=0 ; i<paths.size() ; i++ )
        {
            // Converting mapNodes to their room symbol
            // to be evaluated by class EvaluatePath
            // example :: MM?MMER?TER$?MR
            StringBuilder str = new StringBuilder();
            for (MapRoomNode node : paths.get(i))
            {
                str.append(node.getRoomSymbol(true));
            }
            pathEvaluated.put(i, EvaluatePath.calculateValue(str.toString()));
        }

        // Now that we have all the
        Entry<Integer, Integer> maxEntry = null;
        for ( Entry<Integer, Integer> e : pathEvaluated.entrySet() )
        {
            if ( maxEntry == null || e.getValue().compareTo(maxEntry.getValue())>0 )
            {
                maxEntry = e;
            }
        }

        // We have our optimal path
        return paths.get(maxEntry.getKey());
    }

    private void addNodeToPath(MapRoomNode node, ArrayList<MapRoomNode> path)
    {
        if( null != node )
        {
            path.add(node);

            for (MapEdge edge : node.getEdges()) {

                // Possible diverge in path if there are multiple edges
                // build new path to handle all alternate routes
                ArrayList<MapRoomNode> tmpPath = new ArrayList<MapRoomNode>();
                for (int i=0 ; i<path.size() ; i++)
                {
                    // add all parent mapNodes up to this point to then split from
                    tmpPath.add(path.get(i));
                }

                MapRoomNode n = edgeToNode(edge);
                if ( null == n)
                {
                    // We have hit the boss node
                    // add full path to all possible paths
                    paths.add(path);
                }
                else
                {
                    addNodeToPath(n, tmpPath);
                }
            }
        }
    }

    private MapRoomNode edgeToNode(MapEdge edge)
    {
        if ( 15 > edge.dstY )
        {
            if ( !mapNodes.isEmpty() )
            {
                return mapNodes.get(edge.dstY).get(edge.dstX);
            }
            else
            {
                System.out.println("Empty mapNodes list!! Check your passed in value to MapUtil.createOptimalPath()");
                return null;
            }
        }
        return null;
    }
}
