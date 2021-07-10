package by.epamtc.dubovik.service.filtercondition;

import by.epamtc.dubovik.entity.Plane;

public class ByFuelConsumption implements FilterCondition{
	@Override
	public boolean isSuitable(Plane plane, double lowerBorder, double higherBorder) {
		return plane.getFuelConsumption() >= lowerBorder &&
			   plane.getFuelConsumption() <= higherBorder;
	}
}