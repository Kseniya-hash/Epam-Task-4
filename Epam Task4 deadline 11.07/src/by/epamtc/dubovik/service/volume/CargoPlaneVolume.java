package by.epamtc.dubovik.service.volume;

import by.epamtc.dubovik.entity.CargoPlane;
import by.epamtc.dubovik.entity.Plane;

public class CargoPlaneVolume implements Volume {

	@Override
	public double findVolume(Plane plane) {
		double volume = 0;
		if(plane.getClass() == CargoPlane.class) {
			CargoPlane tempPlane = (CargoPlane)plane;
			volume = VolumeHelper.findCargoVolume(tempPlane.getCargo());
		}
		
		return volume;
	}
}
