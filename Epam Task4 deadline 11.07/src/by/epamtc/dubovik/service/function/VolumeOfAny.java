package by.epamtc.dubovik.service.function;

import java.util.HashMap;

import by.epamtc.dubovik.entity.*;
import by.epamtc.dubovik.service.volume.*;

public class VolumeOfAny implements FunctionOfPlane{
	
	public double findValue(Plane plane) {
		double volume = 0;
		HashMap<Class<?>, Volume> option = new HashMap<>();
		option.put(AdministrativePlane.class, new AdministrativePlaneVolume());
		option.put(CargoPlane.class, new CargoPlaneVolume());
		option.put(PassengerPlane.class, new PassengerPlaneVolume());
		if(option.containsKey(plane.getClass())) {
			volume = (option.get(plane.getClass())).findVolume(plane);
		}
		return volume;
	}

}
