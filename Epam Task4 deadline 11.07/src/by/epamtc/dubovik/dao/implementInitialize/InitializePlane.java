package by.epamtc.dubovik.dao.implementInitialize;

import by.epamtc.dubovik.dao.Initialize;
import by.epamtc.dubovik.dao.ParseArray;
import by.epamtc.dubovik.dao.PlaneNotFoundException;
import by.epamtc.dubovik.entity.Plane;

public class InitializePlane implements Initialize {
	
	@Override
	public Plane init(String[] source, int index) {
		Plane plane = new Plane();
		try {
			ParseArray.parse(source, index, plane);
		}
		catch(PlaneNotFoundException e) {
			plane = null;
		}
		return plane;
	}
}
