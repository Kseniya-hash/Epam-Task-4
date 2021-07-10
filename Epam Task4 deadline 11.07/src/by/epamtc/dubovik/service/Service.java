package by.epamtc.dubovik.service;

import java.util.*;

import by.epamtc.dubovik.entity.*;
import by.epamtc.dubovik.service.comparator.NullPlaneComparator;
import by.epamtc.dubovik.service.filtercondition.FilterCondition;
import by.epamtc.dubovik.service.function.*;

public class Service {
	
	public static double findCarryingCapacity(List<Plane> planeList) {
		double carryingCapacity = functionOnList(planeList, new CarringCapacityOfAny());
		return carryingCapacity;
	}
	
	private static double functionOnList(List<Plane> planeList, FunctionOfPlane function) {
		double value = 0;
		if(planeList != null) {
			for(Plane plane : planeList) {
				if(plane != null) {
					value += function.findValue(plane);
				}
			}
		}
		return value;
	}
	
	public static double findVolume(List<Plane> planeList) {
		double volume = functionOnList(planeList, new VolumeOfAny());
		return volume;
	}
	
	public static List<Plane> filter(List<Plane> unfiltered, double lowerBorder, 
			  double higherBorder, FilterCondition condition){
		List<Plane> filtered = new LinkedList <Plane>();
		if(unfiltered != null) {
			for(Plane plane : unfiltered) {
				if(plane  != null) {
					if(condition.isSuitable(plane, lowerBorder, higherBorder)) {
						filtered.add(plane);
					}
				}
			}
		}
		return filtered;
	}
	
	public static void sort(List<Plane> planeList, Comparator compareBy) 
	{
		sort(planeList, compareBy, compareBy);
	}
	
	public static void sort(List<Plane> planeList, Comparator compareByPrimary, Comparator compareBySecondary) 
	{
		if(planeList == null)
			return;
		planeList.sort(new Comparator<Plane>(){
			@Override
			public int compare(Plane plane1, Plane plane2) {
				int compareValue = 0;
				if((plane1 != null) && (plane2 != null)) {
					compareValue = compareByPrimary.compare(plane1, plane2);
					if(compareValue == 0) {
						compareValue = compareBySecondary.compare(plane1, plane2);
					}
				} else {
					compareValue = (new NullPlaneComparator()).compare(plane1, plane2);
				}
				return compareValue;
			}
		});
	}
}
