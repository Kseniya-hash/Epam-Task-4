package by.epamtc.dubovik.service.volume;

import by.epamtc.dubovik.entity.PassengerPlane;
import by.epamtc.dubovik.entity.Plane;
import by.epamtc.dubovik.entity.SeatType;

public class PassengerPlaneVolume implements Volume {

	@Override
	public double findVolume(Plane plane) {
		double volume = 0;
		if(plane.getClass() == PassengerPlane.class) {
			PassengerPlane tempPlane = (PassengerPlane)plane;
			volume = findSeatTypeVolume(tempPlane.getFirst())
					+ findSeatTypeVolume(tempPlane.getBusiness())
					+ findSeatTypeVolume(tempPlane.getEconom());
		}
		
		return volume;
	}
	
	private static double findSeatTypeVolume(SeatType seat) {
		double volume = 0;
		if(seat != null && seat.getLuggagePerPerson() != null) {
			volume = seat.getSeatCount() * VolumeHelper.findCargoVolume(seat.getLuggagePerPerson());
		}
		return volume;
	}
}