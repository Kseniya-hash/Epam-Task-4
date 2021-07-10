package by.epamtc.dubovik.runner;

import java.util.List;

import by.epamtc.dubovik.entity.Plane;

public interface Option {
	
	public List<Plane> run(List<Plane> planeList);
	
}
