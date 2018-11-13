import java.util.*;
import java.io.*;

/**
 * 
 */

/**
 * @author Tony
 *
 */
//Filter
class Planet {
	protected String name;
	protected int temp;
	
public Planet(Scanner in) {
	if(in.hasNextLine()) {
		this.name = in.next();
		this.temp = in.nextInt();
		
		
		
	}
}
	public String toString() {
		return String.format("%-10s %5d", name, temp);
	}
	
	private static final double TEMP_ICEGIANTS = 59;
	
	public static void main(String[] args) {
		File file = new File("Planets.dat");
		Set<Planet> dataset = readDataset(file);
		
		for(Planet planet: dataset) {
			if(planet.temp <= TEMP_ICEGIANTS) {
				System.out.println("IceGiant: " +planet);
			}
	}
	
	

}

public static Set readDataset(File file) {
	Set<Planet> set = new HashSet();
	try {
		Scanner in = new Scanner(file);
		in.nextLine();
		while(in.hasNextLine()) {
			set.add(new Planet(in));
		}
		in.close();
	}catch (FileNotFoundException e) {
		System.out.println(e);
			
		}
	return set;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
