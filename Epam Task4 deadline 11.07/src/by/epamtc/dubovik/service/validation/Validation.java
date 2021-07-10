package by.epamtc.dubovik.service.validation;

import java.util.HashMap;

import by.epamtc.dubovik.entity.*;

public class Validation implements Valid{
	
	@Override
	public boolean isValidPlane(Plane plane) {
		boolean valid = false;
		HashMap<Class<?>, Valid> options = new HashMap<>();
		options.put(AdministrativePlane.class, new Valid() {
			@Override
			public boolean isValidPlane(Plane plane) {
				return isValid((AdministrativePlane)plane);
			}
		});
		
		options.put(CargoPlane.class, new Valid() {
			@Override
			public boolean isValidPlane(Plane plane) {
				return isValid((CargoPlane)plane);
			}
		});
		
		options.put(PassengerPlane.class, new Valid() {
			@Override
			public boolean isValidPlane(Plane plane) {
				return isValid((PassengerPlane)plane);
			}
		});
		
		options.put(Plane.class, new Valid() {
			@Override
			public boolean isValidPlane(Plane plane) {
				return isValid((Plane)plane);
			}
		});
		
		if(plane != null && options.containsKey(plane.getClass())) {
			valid = (options.get(plane.getClass())).isValidPlane(plane);
		}
		
		return valid;
	}
	
	private static boolean isValid(Plane plane) {
		boolean valid = false;
		if(plane.getModel() != null &&
				plane.getPlaneLength() > 0 &&
				plane.getPlaneHigh() > 0 &&
				plane.getWingspan() > 0 &&
				plane.getSpeed() > 0 &&
				plane.getFuelConsumption() > 0 &&
				plane.getFlightAltitude() > 0 &&
				plane.getFlightRange() > 0) {
			valid = true;
		}
		return valid;
	}
	
	private static boolean isValid(AdministrativePlane plane) {
		boolean valid = false;
		if(isValid((Plane)plane) &&
				plane.getSeatCount() > 0 &&
				isValid(plane.getLuggage())) {
			valid = true;
		}
		return valid;
	}
	
	private static boolean isValid(CargoPlane plane) {
		boolean valid = false;
		if(isValid((Plane)plane) &&
				isValid(plane.getCargo()) &&
				plane.getDoorHigh() > 0 &&
				plane.getDoorWidth() > 0) {
			valid = true;
		}
		return valid;
	}
	
	private static boolean isValid(PassengerPlane plane) {
		boolean valid = false;
		if(isValid((Plane)plane) &&
				isValid(plane.getFirst()) &&
				isValid(plane.getBusiness()) &&
				isValid(plane.getEconom())){
			valid = true;
		}
		return valid;
	}
	
	private static boolean isValid(SeatType seat) {
		boolean valid = false;
		if(seat.getSeatCount() > 0 &&
				seat.getCarryOnBaggage() > 0 &&
				isValid(seat.getLuggagePerPerson())){
			valid = true;
		}
		return valid;
	}
	
	private static boolean isValid(Cargo cargo) {
		boolean valid = false;
		if(cargo.getWeight() > 0 &&
				cargo.getLength() > 0 &&
				cargo.getHigh() > 0 &&
				cargo.getWidth() > 0){
			valid = true;
		}
		return valid;
	}
}
