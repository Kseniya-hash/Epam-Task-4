package by.epamtc.dubovik.service.filtercondition;

import by.epamtc.dubovik.entity.Plane;

public class ByPlaneHigh implements FilterCondition{
	
	@Override
	public boolean isSuitable(Plane plane, double lowerBorder, double higherBorder) {
		return plane.getPlaneHigh() >= lowerBorder &&
			   plane.getPlaneHigh() <= higherBorder;
	}
}
