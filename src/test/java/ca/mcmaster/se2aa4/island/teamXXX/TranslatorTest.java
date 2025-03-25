package ca.mcmaster.se2aa4.island.teamXXX;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.json.JSONArray;

public class TranslatorTest {

    @Test
    public void testTranslator() {
        JSONObject response = new JSONObject();
        response.put("cost", 2);

        JSONObject extras = new JSONObject();
        extras.put("biomes", new JSONArray().put("BEACH").put("FOREST"));
        extras.put("creeks", new JSONArray());
        extras.put("sites", new JSONArray());

        response.put("extras", extras);
        response.put("status", "OK");
        
        Info result = translator.translate(response);

        Assertions.assertNotNull(result, "Info object should not be null");
        Assertions.assertEquals(2, result.getCost(), "Cost should be 2");
        Assertions.assertEquals(extras.toString(), result.getExtras().toString(), "Extras should match the input");
        Assertions.assertEquals("OK", result.getStatus(), "Status should be 'OK'");
    }
}