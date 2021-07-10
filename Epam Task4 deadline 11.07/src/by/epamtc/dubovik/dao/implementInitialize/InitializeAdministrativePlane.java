package by.epamtc.dubovik.dao.implementInitialize;

import by.epamtc.dubovik.dao.Initialize;
import by.epamtc.dubovik.dao.ParseArray;
import by.epamtc.dubovik.dao.PlaneNotFoundException;
import by.epamtc.dubovik.entity.AdministrativePlane;

public class InitializeAdministrativePlane implements Initialize {
	
	@Override
	public AdministrativePlane init(String[] source, int index) {
		AdministrativePlane plane = new AdministrativePlane();
		try {
			ParseArray.parse(source, index, plane);
		}
		catch(PlaneNotFoundException e) {
			plane = null;
		}
		return plane;
	}
}
