package by.epamtc.dubovik.service.carryingcapacity;

import by.epamtc.dubovik.entity.*;

public class AdministrativePlaneCapacity implements CarryingCapacity{
	@Override
	public double findCapacity(Plane plane) {
		double capacity = 0;
		if(plane.getClass() == AdministrativePlane.class) {
			AdministrativePlane tempPlane = (AdministrativePlane)plane;
			capacity = tempPlane.getSeatCount() * CapacityHelper.HUMANWEIGHT + tempPlane.getLuggage().getWeight();
		}
		
		return capacity;
	}
}
