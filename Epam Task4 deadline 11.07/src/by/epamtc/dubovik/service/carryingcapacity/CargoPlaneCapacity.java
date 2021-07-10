package by.epamtc.dubovik.service.carryingcapacity;

import by.epamtc.dubovik.entity.CargoPlane;
import by.epamtc.dubovik.entity.Plane;

public class CargoPlaneCapacity implements CarryingCapacity{
	
	@Override
	public double findCapacity(Plane plane) {
		double capacity = 0;
		if(plane.getClass() == CargoPlane.class) {
			CargoPlane tempPlane = (CargoPlane)plane;
			capacity = tempPlane.getCargo().getWeight();
		}
		
		return capacity;
	}
}
