package by.epamtc.dubovik.service.filtercondition;

import by.epamtc.dubovik.entity.Plane;

public interface FilterCondition {
	
	public boolean isSuitable(Plane plane, double lowerBorder, double higherBorder);

}
