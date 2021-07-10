package by.epamtc.dubovik.service.comparator;

import java.util.Comparator;

import by.epamtc.dubovik.entity.Plane;
import by.epamtc.dubovik.service.validation.Validation;

public class FlightRangeComparator implements Comparator<Plane> {

	@Override
	public int compare(Plane plane1, Plane plane2) {
		return (int) Math.signum(plane1.getFlightRange() - plane2.getFlightRange());
	}
}
