package by.epamtc.dubovik.service.filtercondition;

import by.epamtc.dubovik.entity.Plane;

public class ByFlightRange implements FilterCondition{
	@Override
	public boolean isSuitable(Plane plane, double lowerBorder, double higherBorder) {
		return plane.getFlightRange() >= lowerBorder &&
			   plane.getFlightRange() <= higherBorder;
	}
}
