package by.epamtc.dubovik.runner;

import java.util.HashMap;
import java.util.List;

import by.epamtc.dubovik.entity.*;

public class Readable implements ReadablePlane{
	
	@Override
	public String receiveString(Plane plane) {
		String result = null;
		HashMap<Class<?>, ReadablePlane> option = new HashMap<>();
		option.put(AdministrativePlane.class, new ReadablePlane() {
			public String receiveString(Plane plane) {
				return toReadableString((AdministrativePlane)plane);
			}
		});
		option.put(CargoPlane.class, new ReadablePlane() {
			public String receiveString(Plane plane) {
				return toReadableString((CargoPlane)plane);
			}
		});
		option.put(PassengerPlane.class, new ReadablePlane() {
			public String receiveString(Plane plane) {
				return toReadableString((PassengerPlane)plane);
			}
		});
		option.put(Plane.class, new ReadablePlane() {
			public String receiveString(Plane plane) {
				return toReadableString(plane);
			}
		});
		if(plane != null && option.containsKey(plane.getClass())) {
			result = (option.get(plane.getClass())).receiveString(plane);
		}
		
		return result;
	}
	
	public String receiveString(List<Plane> planeList) {
		StringBuilder result = new StringBuilder();
		if(planeList != null) {
			for(Plane plane : planeList) {
				result.append(receiveString(plane) + "\n");
			}
		}
		return result.toString();
	}
	
	private String toReadableString(Plane plane) {
		StringBuilder result = new StringBuilder(plane.getModel());
		result.append(", размер: длина " + plane.getPlaneLength());
		result.append(", высота " + plane.getPlaneHigh());
		result.append(", размах крыльев " + plane.getPlaneLength());
		result.append("\nскорость: " + plane.getSpeed());
		result.append(", потребление горючего: " + plane.getFuelConsumption());
		result.append(", высота полета: " + plane.getFlightAltitude());
		result.append(", дальность полета: " + plane.getFlightRange());
		result.append("\n");
		return result.toString();
	}
	
	private String toReadableString(Cargo cargo) {
		StringBuilder result = new StringBuilder();
		result.append("вес: " + cargo.getWeight());
		result.append(", размер: " + cargo.getLength());
		result.append(" х " + cargo.getHigh());
		result.append(" х " + cargo.getWidth());
		return result.toString();
	}
	
	private String toReadableString(AdministrativePlane plane) {
		StringBuilder result = new StringBuilder();
		result.append(toReadableString((Plane)plane));
		result.append("число пассажиров: " + plane.getSeatCount());
		result.append(", багаж: " + toReadableString(plane.getLuggage()));
		result.append("\n");
		return result.toString();
	}
	
	private String toReadableString(CargoPlane plane) {
		StringBuilder result = new StringBuilder();
		result.append(toReadableString((Plane)plane));
		result.append("груз: " + toReadableString(plane.getCargo()));
		result.append(", размер двери: " + plane.getDoorHigh() + " x " + plane.getDoorWidth() + "\n");
		return result.toString();
	}
	
	private String toReadableString(PassengerPlane plane) {
		StringBuilder result = new StringBuilder();
		result.append(toReadableString((Plane)plane));
		result.append("первый класс (" + toReadableString(plane.getFirst()) + ")\n");
		result.append("бизнес класс (" + toReadableString(plane.getBusiness()) + ")\n");
		result.append("эконом класс (" + toReadableString(plane.getEconom()) + ")\n");
		return result.toString();
	}
	
	private String toReadableString(SeatType seat) {
		StringBuilder result = new StringBuilder();
		result.append("число пассажиров: " + seat.getSeatCount());
		result.append(", ручная кладь: " + seat.getCarryOnBaggage());
		result.append(", багаж: " + toReadableString(seat.getLuggagePerPerson()));
		return result.toString();
	}

}
