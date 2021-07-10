package by.epamtc.dubovik.service;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import by.epamtc.dubovik.dao.ReadFromFile;
import by.epamtc.dubovik.entity.Plane;
import by.epamtc.dubovik.service.validation.Validation;

public class PlaneListServiceImpl implements PlaneListService {
	@Override
	public List<Plane> getPlaneList() throws DataNotFoundException{
		try {
			List<Plane> planeList = ReadFromFile.readPlaneList();
			List<Plane> validatedList = new LinkedList<>();
			Iterator<Plane> it = planeList.iterator();
			while(it.hasNext()) {
				Plane plane = it.next();
				if(plane != null &&  (new Validation()).isValidPlane(plane)) {
					validatedList.add(plane);
				}
			}
			return validatedList;
		} catch (FileNotFoundException e) {
			throw new DataNotFoundException(e);
		}
	}
}
