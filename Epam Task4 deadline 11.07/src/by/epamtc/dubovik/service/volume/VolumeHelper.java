package by.epamtc.dubovik.service.volume;

import by.epamtc.dubovik.entity.Cargo;

public class VolumeHelper {
	
	public static double findCargoVolume(Cargo cargo) {
		double volume = 0;
		if(cargo != null) {
			volume = cargo.getHigh() * cargo.getLength() * cargo.getWidth();
		}
		return volume;
	}

}
