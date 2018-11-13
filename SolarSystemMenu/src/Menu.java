import java.util.*;
import java.io.*;      



public class Menu {
    boolean exit;

 public static void main(String[] args) throws FileNotFoundException {
    Menu menu = new Menu();
    menu.runMenu();
 }

 public void runMenu() throws FileNotFoundException{
     while(!exit){
         printMenu();
         int choice = getInput();
        selection(choice);
     }
 }

private void printMenu(){

	System.out.println("***********Welcome to the Solar System************");
	System.out.println();
    System.out.println("1) Read SolarSystem .txt File: \nPlanetary Index, Name & Distance from Sun");
    System.out.println();
    System.out.println("2) Sort SolarSystem .dat File: \nPlanetary Index, Name & Distance from Sun");
    System.out.println();
    System.out.println("3) Filter SolarSystem IceGiants .dat Files: \nPlanet with Mass(kg) at least 10x Earth Mass");
    System.out.println();
    System.out.println("4) Merge SolarSystem .dat Files: \nTerrestrial and GasGiant Planets");
    System.out.println();
    System.out.println("5) Read SolarSystem .csv File: \nPlanet and Moons");
    System.out.println();
    System.out.println("6) Reveal interesting solar system facts with HashMap and .dat File: \nPlanet and Temperature");
    System.out.println();
    System.out.println("0) Exit");
	System.out.println();
    System.out.println("***************************************************");
}

private int getInput (){
    Scanner kb = new Scanner(System.in);
    int choice = -1;
    while(choice < 0 || choice  > 6){
        try {
            System.out.print("\nSelect one of the Solar System Menu Options: ");
            choice = Integer.parseInt(kb.nextLine());
        }
        catch(NumberFormatException e){
            System.err.println("Invalid selection. Please enter a number from the menu options");
            break;
        }
    }
    return choice;
}

private void selection(int choice) throws FileNotFoundException{
    switch(choice){
        case 0:
            exit = true;
            System.out.println("Exiting SolarSystem");
            break;
        case 1:
            readFile();
            break;
        case 2:
            sortSolarSystem();
            break;
        case 3:
            filterSolarSystem();
            break;
        case 4:
            mergeSolarSystem();
            break;
        case 5:
        	readCSVFile();
        	break;
        case 6:
        	readHashMap();
        	break;
        default:
      
            
         
    }
}

private void readFile() throws FileNotFoundException {
	int planetIndex = 1;
	
	File file1 = new File ("SolarSystem1.txt");
	
	Scanner input = new Scanner(file1);
	
	while(input.hasNext()) {
		
		String planetName = input.next();	
		double planetDistanceSun = input.nextDouble();
		
		System.out.println(planetIndex + ":" + planetName + " \n" + planetDistanceSun + " million km" );
		planetIndex++;
		
	}
	
}	




private void sortSolarSystem() {
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
	System.out.println("The solar system planetary distances in ascending order:");
for(Double key: planetaryMap.keySet()) {
	System.out.printf("%.1f %-10s%n", key, planetaryMap.get(key));
}
}

private void filterSolarSystem() {
final int TEMP_ICEGIANTS = 59;
	

		File file = new File("Planets.dat");
		Set<Planet> dataset = readDataset(file);
		System.out.println("Our Solar System IceGiants are:");
		for(Planet planet: dataset) {
			if(planet.temp <= TEMP_ICEGIANTS) {
				System.out.println(planet);
			}
	}
	
}






private void mergeSolarSystem() {
	File inFile1 = new File("SolarSystem.dat");
	File inFile2 = new File("SolarSystem2.dat");
	File outFile = new File("SolarSystem3.dat");
	try {
		Scanner in1 = new Scanner(inFile1);
		Scanner in2 = new Scanner(inFile2);
		PrintWriter out = new PrintWriter(outFile);
		
		Merge planet1 = new Merge(in1);
		Merge planet2 = new Merge(in2);

		while(!planet1.isNull() && !planet2.isNull()) {
			if(planet1.compareTo(planet2) < 0) {
				out.println(planet1);
				planet1 = new Merge(in1);
			} else {
				out.println(planet2);
				planet2 = new Merge(in2);
				
			}
			
		}
		while (!planet1.isNull()) {
			out.println(planet1);;
			planet1 = new Merge(in1);
		}
		while(!planet2.isNull()) {
			out.println(planet2);
			planet2 = new Merge(in2);
		}
		in1.close();
		in2.close();
		out.close();
	} catch (FileNotFoundException e) {
		System.out.println(e) ;
			
		}
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


	print(dataset);
}
public static void print(LinkedHashMap<String, Integer> map) {
	System.out.println("The full solar system merged with the missing dwarf planet:");
	for(String key: map.keySet()) {
		
		System.out.printf("%-10s%12d%n", key, map.get(key));
	}
    }
private void readCSVFile() {
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
private void readHashMap() {
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
	System.out.printf("The average temperature (Kelvin) of the hottest planet in solar system: %5d%n", dataset.get("Venus"));
	System.out.printf("The number of planets in our solar system: %5d%n", dataset.size());
	
}
private Set<Planet> readDataset(File file) {
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

