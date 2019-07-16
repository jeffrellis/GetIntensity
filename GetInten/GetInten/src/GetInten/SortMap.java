package GetInten;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SortMap {
public void MapData (HashMap<String, Long> int_map) {
			
        final Map<String, Long>sorted = sortByValue(int_map);{
        //create or append to file the sorted intensities and shortnames	
        try { 
        	 FileWriter myWriter = new FileWriter("C:\\WH\\RegionalIntensity.txt", true);
        	    for (Entry<String, Long> entry : sorted.entrySet())  
        		    myWriter.write("Intensity = "+ entry.getValue()
        		    +" Short name of region " +entry.getKey()+"\r\n");
        		    
        		 myWriter.close();
        		 System.out.println("Successfully wrote to the file.");
        	} catch (IOException e) {
        		    System.out.println("An error occurred.");
        		    e.printStackTrace();
        		    } 
            } 
    
    } 
    public static Map<String, Long> sortByValue(final Map<String, Long> int_map)
	{
    //sort by intensity from highest to lowest
     return int_map.entrySet()
            .stream()
            .sorted((Map.Entry.<String, Long>comparingByValue().reversed()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

}
