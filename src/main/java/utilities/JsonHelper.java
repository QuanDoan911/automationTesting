package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.google.gson.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.gson.reflect.TypeToken;

public class JsonHelper {

    public static Map<String, String> convertJsonToMap(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        Map<String, String> myMap = gson.fromJson(json, type);
        return myMap;
    }

    public static List<String> convertJsonToList(String json) {
        List<String> list = new ArrayList<String>();
        Map<String, String> map = convertJsonToMap(json);
        if (null != map) {
            for (String key : map.keySet()) {
                list.add(map.get(key));
            }
        }
        return list;
    }

    public static DesiredCapabilities convertJsonToDesiredCapabilities(String json) {
        DesiredCapabilities capability = new DesiredCapabilities();
        Map<String, String> map = convertJsonToMap(json);
        if (null != map) {
            for (String key : map.keySet()) {
                capability.setCapability(key, map.get(key));
            }
        }
        return capability;
    }

    /**
     * Reading test data from json for a specific test case
     *
     * @param testName
     * @param dataFilePath
     * @return Test Data Object in Key Value pair.
     * <p>
     * Operations in Sequence: Get the data from json file
     * Check if the test case is present in the json file
     * Get the test data in json array format
     * Deserialize the json read into an object of Hashtable type
     * Put the data into object array and return to data provider
     */
    public static Object[][] getData(String testName, String dataFilePath) throws IOException {

        Object[][] data = new Object[0][1];

        //Read json file data using Gson library
        BufferedReader br = new BufferedReader(new FileReader(dataFilePath));
        JsonElement jsonElement = new JsonParser().parse(br);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        //Check for the test name in the json file
        boolean blnTCExist = jsonObject.has(testName);
        if (!blnTCExist) {
            // TODO Log: TC name is not present in the data.json file
            return data;
        }

        //Get test data for the specific test case
        JsonArray jsonArray = jsonObject.getAsJsonArray(testName);
        data = jsonArrayToObjectArray(jsonArray);
        return data;
    }

    public static Object[][] jsonArrayToObjectArray(JsonArray jsonArray){

        Object[][] data = new Object[0][1];
        int index = 0;
        Gson gson = new Gson();

        if (jsonArray.size()>0) {
            data = new Object[jsonArray.size()][1];
            for (Object obj : jsonArray) {
                Hashtable<String, String> hashTable = new Hashtable<String, String>();
                data[index][0] = gson.fromJson((JsonElement) obj, hashTable.getClass());
                index++;
            }
        }
        return data;
    }
}
