import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
/**
 * 
 */

/**
 * @author Tony
 *
 */
public class HashMapPlanets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		File dataFile = new File("Planets.dat");
		HashMap<String, Integer> dataset = new HashMap();
		
		try {
			Scanner input = new Scanner(dataFile);
			while(input.hasNext()) {
				String name = input.next();
				int temp = input.nextInt();
				dataset.put(name, temp);
			}
			
		}catch (FileNotFoundException e) {
			System.out.println(e);
		}
		System.out.printf("The average temperature (Kelvin) of  in solar system: %5d%n", dataset.get("Venus"));
		System.out.printf("The number of planets in our solar system: %5d%n", dataset.size());
		
	}

}
