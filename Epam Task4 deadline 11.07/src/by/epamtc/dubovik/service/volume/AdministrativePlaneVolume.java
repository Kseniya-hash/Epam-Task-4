package by.epamtc.dubovik.service.volume;

import by.epamtc.dubovik.entity.AdministrativePlane;
import by.epamtc.dubovik.entity.Plane;

public class AdministrativePlaneVolume implements Volume{
	
	@Override
	public double findVolume(Plane plane) {
		double volume = 0;
		if(plane.getClass() == AdministrativePlane.class) {
			AdministrativePlane tempPlane = (AdministrativePlane)plane;
			volume = VolumeHelper.findCargoVolume(tempPlane.getLuggage());
		}
		
		return volume;
	}

}
