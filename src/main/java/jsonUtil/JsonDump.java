package jsonUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import jsonUtil.DataDump;

public class JsonDump {

    public void createJson()
    {
        DataDump dataDump = new DataDump();
        dataDump.updateDataForJson();

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(AbstractMonster.class, new MyTypeAdapter<AbstractMonster>())
                .addSerializationExclusionStrategy(new TestExclusionStrategy())
                .addDeserializationExclusionStrategy(new TestExclusionStrategy())
                .setPrettyPrinting()
                .create();

        //System.out.println(gson.toJson(jsonEnemyArrayList));

        try {
            Writer writer = new FileWriter("C:\\Users\\Hafez\\IdeaProjects\\NavigateTheSpire\\json\\jsonDump.json");
            writer.write(gson.toJson(dataDump));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
