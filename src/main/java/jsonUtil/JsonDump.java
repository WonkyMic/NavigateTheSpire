package jsonUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class JsonDump {

    public void createStateJson()
    {
        StateDataDump data = new StateDataDump();
        data.updateStateDataForJson();

        createJson(data);

    }

    public void createCombatJson()
    {
        createStateJson();

        CombatDataDump data = new CombatDataDump();
        data.updateCombatDataForJson();

        createJson(data);

    }

    public void createEventJson()
    {
        createStateJson();

        EventDataDump data = new EventDataDump();
        data.updateEventDataForJson();

        createJson(data);

    }

    public void createJson(AbstractDataDump data)
    {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(AbstractMonster.class, new MyTypeAdapter<AbstractMonster>())
                .addSerializationExclusionStrategy(new TestExclusionStrategy())
                .addDeserializationExclusionStrategy(new TestExclusionStrategy())
                .setPrettyPrinting()
                .create();

        //TODO :: this should be the end of the method (with return)
        //return gson.toJson(dataDump)
        String type = data.getClass().getSimpleName();
        try {
            Writer writer = new FileWriter("C:\\Users\\Hafez\\IdeaProjects\\NavigateTheSpire\\json\\" + type + "jsonDump.json");
            writer.write(gson.toJson(data));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //TODO :: move to another method or MachineLearningClient class
        String URL = "http://127.0.0.1:5000/navi/" + type + "test-endpoint";
        Client client = ClientBuilder.newClient();
        try
        {
            Response resp = client.target(URL)
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(gson.toJson(data), MediaType.APPLICATION_JSON));

            if ( 200 == resp.getStatus() )
            {
                System.out.println("JsonDump :: client call response :: " + resp.readEntity(String.class));
            }
            else
            {
                System.out.println("ERROR :: response from :: " + URL + " :: was not OK(200), please check that service is running properly.");
            }
        }
        catch ( ProcessingException ex )
        {
            ex.printStackTrace();
        }
    }

}
