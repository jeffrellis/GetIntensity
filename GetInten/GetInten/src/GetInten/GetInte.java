package GetInten;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GetInte {

public static void main(String[] args)
{
      
    try (FileReader reader = new FileReader("C:\\WH\\response.json"))
    {
        //Read JSON file created by Postman that has all the data
        JSONObject rootJSON = (JSONObject) new JSONParser().parse(reader);
		JSONArray dataList = (JSONArray) rootJSON.get("data");

        //Now extract the region elements
		for(Object projectObj: dataList.toArray()){
        JSONObject project = (JSONObject)projectObj;
        JSONArray regionList = (JSONArray) project.get("regions");
        
        //Put the regions into an array
        HashMap<String, Long> int_map = new HashMap<String, Long>(); //create empty Hash Map
        for(Object regionObj: regionList.toArray()){
            JSONObject region = (JSONObject) regionObj;
                                        
            //From the object region extract the shortname 
            String shortname = (String) region.get("shortname");
                       
            
         JSONObject intensityList = (JSONObject) region.get("intensity");
         // From the object region extract the intensity forecast
         Long intensity = (Long) intensityList.get("forecast");

         //Put the shortname and forecasts into a map so later we can sort
         int_map.put(shortname, intensity);
              
        }
      SortMap sm = new SortMap(); //create a new SortMap object
      //Pass the map to SortMap to sort the map and write to a file
      sm.MapData(int_map);
        }
    }
       catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ParseException e) {
        e.printStackTrace();
    }
}
}
