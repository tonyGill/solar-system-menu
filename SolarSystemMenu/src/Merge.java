import java.util.*;
import java.io.*;
/**
 * 
 */

/**
 * @author Tony
 *
 */
class Merge implements Comparable<Object>{
	private String name;
	private Integer distance;
	
public Merge(String name, Integer distance) {
	this.name = name;
	this.distance = distance;
	
}

public Merge(Scanner in) {
	if(in.hasNextLine()) {
		this.name = in.next();
		this.distance = in.nextInt();
		
	}
}
public boolean isNull() {
	return this.name == null;
	
}
public int compareTo(Object object) {
	Merge that = (Merge)object;
	return this.distance - that.distance;
	
}
public String toString() {
	return String.format("%10s%n %10d", name, distance);
}
	
}