package by.epamtc.dubovik.service.comparator;

import java.util.Comparator;

import by.epamtc.dubovik.entity.Plane;

public class FlightAltitudeComparator implements Comparator<Plane> {

	@Override
	public int compare(Plane plane1, Plane plane2) {
		return (int) Math.signum(plane1.getFlightAltitude() - plane2.getFlightAltitude());
	}
}
