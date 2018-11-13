import java.io.*;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Tony Gill
 *
 */
public class PlanetaryRead {

	
	public static void main(String[] args) throws Exception {
		//Add an index here
	
		int planetIndex = 1;
		
		File file1 = new File ("SolarSystem1.txt");
		
		Scanner input = new Scanner(file1);
		
		while(input.hasNext()) {
			
			String planetName = input.next();	
			double planetDistanceSun = input.nextDouble();
			
			System.out.println(planetIndex + ":" + planetName + " \n" + planetDistanceSun + " million km" );
			planetIndex++;
			
		}
		
		input.close();

	}

}



