import java.util.*;
import java.io.*;
/**
 * 
 */

/**
 * @author Tony
 *
 */
public class PlanetarySort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file2 = new File("SolarSystemSort.dat");
        HashMap<String, Double> dataset = new HashMap<>();
        try {
            Scanner input = new Scanner(file2);
            while (input.hasNext()) {
                String planet = input.next();
                double distance = input.nextDouble();
                dataset.put(planet, distance);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        

        TreeMap<Double, String> datasetSorted = new TreeMap<>();
        try {
            Scanner input = new Scanner(file2);
            while (input.hasNext()) {
                String planetValue = input.next();
                double distanceKey = input.nextDouble();
                datasetSorted.put(distanceKey, planetValue);
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
 
      
      print(datasetSorted);
    
      }
public static void print(TreeMap<Double, String> planetaryMap) {
	for(Double key: planetaryMap.keySet()) {
		System.out.printf("%.1f %-10s%n", key, planetaryMap.get(key));
	}
	
}
}
    





