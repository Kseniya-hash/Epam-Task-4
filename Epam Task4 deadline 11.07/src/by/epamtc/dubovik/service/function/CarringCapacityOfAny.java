package by.epamtc.dubovik.service.function;

import java.util.HashMap;

import by.epamtc.dubovik.entity.*;
import by.epamtc.dubovik.service.carryingcapacity.*;

public class CarringCapacityOfAny implements FunctionOfPlane{
	
	public double findValue(Plane plane) {
		double capacity = 0;
		HashMap<Class<?>, CarryingCapacity> option = new HashMap<>();
		option.put(AdministrativePlane.class, new AdministrativePlaneCapacity());
		option.put(CargoPlane.class, new CargoPlaneCapacity());
		option.put(PassengerPlane.class, new PassengerPlaneCapacity());
		if(option.containsKey(plane.getClass())) {
			capacity = (option.get(plane.getClass())).findCapacity(plane);
		}
		return capacity;
	}
}
