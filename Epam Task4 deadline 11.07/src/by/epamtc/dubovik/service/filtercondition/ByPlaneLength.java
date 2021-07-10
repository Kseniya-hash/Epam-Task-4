package by.epamtc.dubovik.service.filtercondition;

import by.epamtc.dubovik.entity.Plane;

public class ByPlaneLength implements FilterCondition{
	@Override
	public boolean isSuitable(Plane plane, double lowerBorder, double higherBorder) {
		return plane.getPlaneLength() >= lowerBorder &&
			   plane.getPlaneLength() <= higherBorder;
		}
	}
