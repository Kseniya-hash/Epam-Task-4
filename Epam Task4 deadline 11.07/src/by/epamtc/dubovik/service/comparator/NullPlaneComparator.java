package by.epamtc.dubovik.service.comparator;

import java.util.Comparator;

import by.epamtc.dubovik.entity.Plane;
import by.epamtc.dubovik.service.validation.Validation;

public class NullPlaneComparator implements Comparator<Plane> {
	
	@Override
	public int compare(Plane plane1, Plane plane2) {
		return (plane1 == null)? ((plane2 == null) ? 0 : 1 ) : -1;
	}
}
