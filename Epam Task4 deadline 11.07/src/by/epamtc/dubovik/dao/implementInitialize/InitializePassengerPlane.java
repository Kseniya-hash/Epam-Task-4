package by.epamtc.dubovik.dao.implementInitialize;

import by.epamtc.dubovik.dao.Initialize;
import by.epamtc.dubovik.dao.ParseArray;
import by.epamtc.dubovik.dao.PlaneNotFoundException;
import by.epamtc.dubovik.entity.PassengerPlane;

public class InitializePassengerPlane implements Initialize {
	
	@Override
	public PassengerPlane init(String[] source, int index) {
		PassengerPlane plane = new PassengerPlane();
		try {
			ParseArray.parse(source, index, plane);
		}
		catch(PlaneNotFoundException e) {
			plane = null;
		}
		return plane;
	}
}