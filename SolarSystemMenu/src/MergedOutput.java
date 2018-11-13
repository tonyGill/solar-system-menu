import java.io.*;
import java.util.LinkedHashMap;
import java.util.Scanner;
/**
 * 
 */

/**
 * @author Tony
 *
 */
//Shows alternative way to print output for merged SolarSystem3 file for iterator loop used//
public class MergedOutput{

	
	public static void main(String[] args) {
	
		File dataFile = new File("SolarSystem3.dat");
		LinkedHashMap<String, Integer> dataset = new LinkedHashMap();
		
		try {
			Scanner input = new Scanner(dataFile);
			while(input.hasNext()) {
				String name = input.next();
				int distance = input.nextInt();
				dataset.put(name, distance);
			}
			
		}catch (FileNotFoundException e) {
			System.out.println(e);
		}

		for (String name: dataset.keySet()){

            String key =name.toString();
            String value = dataset.get(name).toString();  
            System.out.println(key + " " + value);  

	}
	}
}
