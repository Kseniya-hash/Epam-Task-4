package by.epamtc.dubovik.service.carryingcapacity;

import by.epamtc.dubovik.entity.PassengerPlane;
import by.epamtc.dubovik.entity.Plane;
import by.epamtc.dubovik.entity.SeatType;

public class PassengerPlaneCapacity implements CarryingCapacity{
	@Override
	public double findCapacity(Plane plane) {
		double capacity = 0;
		if(plane.getClass() == PassengerPlane.class) {
			PassengerPlane tempPlane = (PassengerPlane)plane;
			capacity = findWeight(tempPlane.getFirst()) + findWeight(tempPlane.getBusiness())
			+ findWeight(tempPlane.getEconom());
		}
		
		return capacity;
	}
	
	private static double findWeight(SeatType seat) {
		double weight = seat.getSeatCount() * (CapacityHelper.HUMANWEIGHT + seat.getCarryOnBaggage()
											  + seat.getLuggagePerPerson().getWeight());
		return weight;
	}
}