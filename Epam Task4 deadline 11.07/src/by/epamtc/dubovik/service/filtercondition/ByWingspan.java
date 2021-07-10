package by.epamtc.dubovik.service.filtercondition;

import by.epamtc.dubovik.entity.Plane;

public class ByWingspan implements FilterCondition{
	@Override
	public boolean isSuitable(Plane plane, double lowerBorder, double higherBorder) {
		return plane.getWingspan() >= lowerBorder &&
			   plane.getWingspan() <= higherBorder;
	}
}
