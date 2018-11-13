import java.io.*;
import java.util.*;
// Example 2 Based
public class ReadingSolarSystemCSVFile {
	public static void main(String[] args) {

		File dataFile = new File("SolarSystemCSV.csv");
		try {
            Scanner input = new Scanner(dataFile);
            input.useDelimiter(",|\\s");
            String planetCol = input.next();
            String moonsCol = input.next();
    
            System.out.printf("%-10s%n%2s", planetCol, moonsCol);
            while (input.hasNext()) {
                String planet= input.next();
           
           
               System.out.println();
                System.out.printf("%-10s ", planet);
            }
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}
}
	