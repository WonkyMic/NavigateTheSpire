package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.megacrit.cardcrawl.ui.buttons.ReturnToMenuButton;
import jsonUtil.JsonDump;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//After death will automatically return to menu and then other patches will start new run.
@SpirePatch(
        clz= ReturnToMenuButton.class,
        method="appear",
        paramtypez = {float.class, float.class, String.class}
)
public class ReturnToMenuButtonPatch {
    public static void Postfix (ReturnToMenuButton button, float x, float y, String label) {
        button.hb.hovered = true;
        button.hb.clicked = true;
        //POST death message to ML

        String URL = "http://127.0.0.1:5000/navi/death-endpoint";
        Client client = ClientBuilder.newClient();
        JsonObject responseJson;
        try
        {
            Response resp = client.target(URL)
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.json(""));

            if ( 200 == resp.getStatus() )
            {
                String jsonString = resp.readEntity(String.class);
                JsonParser parser = new JsonParser();
                responseJson = parser.parse(jsonString).getAsJsonObject();
                JsonDump.changeThings = responseJson.get("restart").getAsBoolean();
                System.out.println("JsonDump :: client call response OK (200)." );//+ resp.readEntity(String.class));
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
