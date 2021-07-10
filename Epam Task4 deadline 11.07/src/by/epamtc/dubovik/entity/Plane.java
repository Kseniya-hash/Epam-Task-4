package by.epamtc.dubovik.entity;

import java.io.Serializable;

import by.epamtc.dubovik.service.EntityHelper;

public class Plane implements Serializable {
	
	private String model;
	
	private double planeLength;
	private double planeHigh;
	private double wingspan;
	
	private double speed;
	private double fuelConsumption;
	private double flightAltitude;
	private double flightRange;
	
	public Plane() {}
	
	public Plane(String model, 
				 double planeLength,
				 double planeHigh,
				 double wingspan,
				 double speed,
				 double fuelConsumption,
				 double flightAltitude,
				 double flightRange) {
		this.model = model; 
		this.planeLength = planeLength;
		this.planeHigh = planeHigh;
		this.wingspan = wingspan;
		this.speed = speed;
		this.fuelConsumption = fuelConsumption;
		this.flightAltitude = flightAltitude;
		this.flightRange = flightRange;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public double getPlaneLength() {
		return planeLength;
	}
	
	public void setPlaneLength(double planeLength) {
		this.planeLength = planeLength;
	}
	
	public double getPlaneHigh() {
		return planeHigh;
	}
	
	public void setPlaneHigh(double planeHigh) {
		this.planeHigh = planeHigh;
	}
	
	public double getWingspan() {
		return wingspan;
	}
	
	public void setWingspan(double wingspan) {
		this.wingspan = wingspan;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public double getFuelConsumption() {
		return fuelConsumption;
	}
	
	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}
	
	public double getFlightAltitude() {
		return flightAltitude;
	}
	
	public void setFlightAltitude(double flightAltitude) {
		this.flightAltitude = flightAltitude;
	}
	
	public double getFlightRange() {
		return flightRange;
	}
	
	public void setFlightRange(double flightRange) {
		this.flightRange = flightRange;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) 
			return true;
		if(o == null) 
			return false;
		if(this.getClass() != o.getClass())
			return false;
		Plane other = (Plane)o;
		if(EntityHelper.equalsWithNull(this.model, other.model) &&
				this.planeLength == other.planeLength &&
				this.planeHigh == other.planeHigh &&
				this.wingspan == other.wingspan &&
				this.speed == other.speed &&
				this.fuelConsumption == other.fuelConsumption &&
				this.flightAltitude == other.flightAltitude &&
				this.flightRange == other.flightRange) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(model + ", ");
		result.append(planeLength + ", ");
		result.append(planeHigh + ", ");
		result.append(wingspan + ", ");
		result.append(speed + ", ");
		result.append(fuelConsumption + ", ");
		result.append(flightAltitude + ", ");
		result.append(flightRange);
		return result.toString();
	}
	
	@Override
	public int hashCode() {
		int result = 1;
		int prime = 31;
		result = prime * result + EntityHelper.hashCodeWithNull(model);
		result = prime * result + (int)planeLength;
		result = prime * result + (int)planeHigh;
		result = prime * result + (int)wingspan;
		result = prime * result + (int)speed;
		result = prime * result + (int)fuelConsumption;
		result = prime * result + (int)flightAltitude;
		result = prime * result + (int)flightRange;
		return result;
	}
}
