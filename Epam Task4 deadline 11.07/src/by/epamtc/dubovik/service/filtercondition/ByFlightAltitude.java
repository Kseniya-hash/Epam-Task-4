package by.epamtc.dubovik.service.filtercondition;

import by.epamtc.dubovik.entity.Plane;

public class ByFlightAltitude implements FilterCondition{
	@Override
	public boolean isSuitable(Plane plane, double lowerBorder, double higherBorder) {
		return plane.getFlightAltitude() >= lowerBorder &&
			   plane.getFlightAltitude() <= higherBorder;
	}
}
