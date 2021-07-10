package by.epamtc.dubovik.service.filtercondition;

import by.epamtc.dubovik.entity.Plane;

public class BySpeed implements FilterCondition{
	@Override
	public boolean isSuitable(Plane plane, double lowerBorder, double higherBorder) {
		return plane.getSpeed() >= lowerBorder &&
			   plane.getSpeed() <= higherBorder;
	}
}
