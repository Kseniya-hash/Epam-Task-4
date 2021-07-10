package by.epamtc.dubovik.service;

import java.util.List;
import by.epamtc.dubovik.entity.Plane;

public interface PlaneListService {
	public List<Plane> getPlaneList() throws DataNotFoundException;
}
