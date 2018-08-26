package jsonUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import java

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

        //TODO :: this should be the end of the method (with return)
        //return gson.toJson(dataDump)

        //TODO :: move to another method or MachineLearningClient class
        String URL = "http://127.0.0.1:5000/navi/test-endpoint";
        Client client = ClientBuilder.newClient();
        try
        {
            Response resp = client.target(URL)
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(gson.toJson(dataDump), MediaType.APPLICATION_JSON));

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
