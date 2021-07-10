package by.epamtc.dubovik.dao.implementInitialize;

import by.epamtc.dubovik.dao.Initialize;
import by.epamtc.dubovik.dao.ParseArray;
import by.epamtc.dubovik.dao.PlaneNotFoundException;
import by.epamtc.dubovik.entity.CargoPlane;

public class InitializeCargoPlane implements Initialize {
	
	@Override
	public CargoPlane init(String[] source, int index) {
		CargoPlane plane = new CargoPlane();
		try {
			ParseArray.parse(source, index, plane);
		}
		catch(PlaneNotFoundException e) {
			plane = null;
		}
		return plane;
	}
}