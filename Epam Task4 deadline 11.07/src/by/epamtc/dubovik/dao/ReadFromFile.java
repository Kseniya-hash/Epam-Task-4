package by.epamtc.dubovik.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import by.epamtc.dubovik.dao.implementInitialize.*;
import by.epamtc.dubovik.entity.*;

public class ReadFromFile {
	
	public static List<Plane> readPlaneList() throws FileNotFoundException {
		List<Plane> planeList = new ArrayList<Plane>();
		String fileName = "src/resources/source.txt";
		Scanner in = new Scanner(new File(fileName));
		while(in.hasNextLine()) {
			Plane pl = createPlane(in.nextLine());
			planeList.add(pl);
		}
		return planeList;
	}
	
	private static Plane createPlane(String source){
		HashMap<String, Initialize> option = acquireOptions();
		int planeTypeIndex = 0;
		int planeIndex = 1;
		String[] sourceArray = extractArray(source);
		Plane newPlane = null;
		if(option.containsKey(sourceArray[planeTypeIndex])) {
			newPlane = option.get(sourceArray[planeTypeIndex]).init(sourceArray, planeIndex);
		}
		return newPlane;
	}
	
	private static HashMap<String, Initialize> acquireOptions() {
		HashMap<String, Initialize> option = new HashMap<String, Initialize>();
		option.put("Administrative plane", new InitializeAdministrativePlane());
		option.put("Cargo plane", new InitializeCargoPlane());
		option.put("Passenger plane", new InitializePassengerPlane());
		option.put("Plane", new InitializePlane());
		
		return option;
	}
	
	private static String[] extractArray(String source) {
		String[] result = source.split(";");
		for(int i = 0; i < result.length; i++) {
			result[i] = result[i].trim();
		}
		return result;
	}
}
