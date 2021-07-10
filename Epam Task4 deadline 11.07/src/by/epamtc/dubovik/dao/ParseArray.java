package by.epamtc.dubovik.dao;

import by.epamtc.dubovik.entity.*;

public class ParseArray {
	private static final String NULLMESSAGE = "Source array is null";
	private static final String INDEXMESSAGE = "Index out of border";
	private static final String DATAMESSAGE = "Invalid data";
	
	private static boolean checkIndex(String[] source,int index) {
		return index >= 0 && index < source.length;
	}
	
	public static int parse(String[] source,int index, Plane plane) throws PlaneNotFoundException{
		if(source == null) {
			throw new PlaneNotFoundException(NULLMESSAGE);
		}
		if(!checkIndex(source, index)) {
			throw new PlaneNotFoundException(INDEXMESSAGE);
		}
		try {
			plane.setModel(source[index++]);
			plane.setPlaneLength(Double.parseDouble(source[index++]));
			plane.setPlaneHigh(Double.parseDouble(source[index++]));
			plane.setWingspan(Double.parseDouble(source[index++]));
			plane.setSpeed(Double.parseDouble(source[index++]));
			plane.setFuelConsumption(Double.parseDouble(source[index++]));
			plane.setFlightAltitude(Double.parseDouble(source[index++]));
			plane.setFlightRange(Double.parseDouble(source[index++]));
		}
		catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
			throw new PlaneNotFoundException(DATAMESSAGE);
		}
		return index;
	}
	
	public static int parse(String[] source,int index, AdministrativePlane plane) throws PlaneNotFoundException{
		if(source == null) {
			throw new PlaneNotFoundException(NULLMESSAGE);
		}
		if(!checkIndex(source, index)) {
			throw new PlaneNotFoundException(INDEXMESSAGE);
		}
		try {
			index = parse(source, index, (Plane)plane);
			plane.setSeatCount(Integer.parseInt(source[index++]));
			Cargo luggage = new Cargo();
			index = parse(source, index, luggage);
			plane.setLuggage(luggage);
		}
		catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
			throw new PlaneNotFoundException(DATAMESSAGE);
		}
		return index;
	}
	
	public static int parse(String[] source,int index, CargoPlane plane) throws PlaneNotFoundException{
		if(source == null) {
			throw new PlaneNotFoundException(NULLMESSAGE);
		}
		if(!checkIndex(source, index)) {
			throw new PlaneNotFoundException(INDEXMESSAGE);
		}
		try {
			index = parse(source, index, (Plane)plane);
			Cargo cargo = new Cargo();
			index = parse(source, index, cargo);
			plane.setCargo(cargo);
			plane.setDoorHigh(Double.parseDouble(source[index++]));
			plane.setDoorWidth(Double.parseDouble(source[index++]));
		}
		catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
			throw new PlaneNotFoundException(DATAMESSAGE);
		}
		return index;
	}
	
	public static int parse(String[] source,int index, PassengerPlane plane) throws PlaneNotFoundException{
		if(source == null) {
			throw new PlaneNotFoundException(NULLMESSAGE);
		}
		if(!checkIndex(source, index)) {
			throw new PlaneNotFoundException(INDEXMESSAGE);
		}
		try {
			index = parse(source, index, (Plane)plane);
			SeatType firstSeat = new SeatType();
			index = parse(source, index, firstSeat);
			plane.setFirst(firstSeat);
			SeatType businessSeat = new SeatType();
			index = parse(source, index, businessSeat);
			plane.setBusiness(businessSeat);
			SeatType economSeat = new SeatType();
			index = parse(source, index, economSeat);
			plane.setEconom(economSeat);
		}
		catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
			throw new PlaneNotFoundException(DATAMESSAGE);
		}
		return index;
	}

	public static int parse(String[] source,int index, SeatType seat) throws PlaneNotFoundException{
		if(source == null) {
			throw new PlaneNotFoundException(NULLMESSAGE);
		}
		if(!checkIndex(source, index)) {
			throw new PlaneNotFoundException(INDEXMESSAGE);
		}
		try {
			seat.setSeatCount(Integer.parseInt(source[index++]));
			seat.setCarryOnBaggage(Double.parseDouble(source[index++]));
			Cargo luggage = new Cargo();
			index = parse(source, index, luggage);
			seat.setLuggagePerPerson(luggage);
		}
		catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
			throw new PlaneNotFoundException(DATAMESSAGE);
		}
		return index;
	}
	
	public static int parse(String[] source,int index, Cargo cargo) throws PlaneNotFoundException{
		if(source == null) {
			throw new PlaneNotFoundException(NULLMESSAGE);
		}
		if(!checkIndex(source, index)) {
			throw new PlaneNotFoundException(INDEXMESSAGE);
		}
		try {
			cargo.setWeight(Integer.parseInt(source[index++]));
			cargo.setLength(Double.parseDouble(source[index++]));
			cargo.setHigh(Double.parseDouble(source[index++]));
			cargo.setWidth(Double.parseDouble(source[index++]));
		}
		catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
			throw new PlaneNotFoundException(DATAMESSAGE);
		}
		return index;
	}
}
