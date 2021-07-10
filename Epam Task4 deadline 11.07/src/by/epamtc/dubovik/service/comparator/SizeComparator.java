package by.epamtc.dubovik.service.comparator;

import java.util.Comparator;

import by.epamtc.dubovik.entity.Plane;

public class SizeComparator implements Comparator<Plane> {

	@Override
	public int compare(Plane plane1, Plane plane2) {
		int compareValue = (int) Math.signum(plane1.getPlaneLength() - plane2.getPlaneLength());
		if(compareValue == 0) {
			compareValue = (int) Math.signum(plane1.getPlaneHigh() - plane2.getPlaneHigh());
		}
		if(compareValue == 0) {
			compareValue = (int) Math.signum(plane1.getWingspan() - plane2.getWingspan());
		}
		return compareValue;
	}
}
