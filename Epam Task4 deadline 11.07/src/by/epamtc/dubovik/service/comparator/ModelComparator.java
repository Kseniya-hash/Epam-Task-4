package by.epamtc.dubovik.service.comparator;

import java.util.Comparator;

import by.epamtc.dubovik.entity.Plane;

public class ModelComparator implements Comparator<Plane> {
	
	@Override
	public int compare(Plane plane1, Plane plane2) {
		return plane1.getModel().compareTo(plane2.getModel());
	}
}
