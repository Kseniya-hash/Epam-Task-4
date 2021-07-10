package by.epamtc.dubovik.entity;

import java.io.Serializable;

import by.epamtc.dubovik.service.EntityHelper;

public class CargoPlane extends Plane implements Serializable {
	
	private Cargo cargo;
	
	private double doorHigh;
	private double doorWidth;
	
	public CargoPlane() {}
	
	public CargoPlane(String model, 
				 double planeLength,
				 double planeHigh,
				 double wingspan,
				 double speed,
				 double fuelConsumption,
				 double flightAltitude,
				 double flightRange,
				 Cargo cargo,
				 double doorHigh,
				 double doorWidth) {
		super(model,
				planeLength,
				planeHigh,
				wingspan,
				speed,
				fuelConsumption,
				flightAltitude,
				flightRange);
		 this.cargo = cargo;
		 this.doorHigh = doorHigh;
		 this.doorWidth = doorWidth;
	}
	
	public Cargo getCargo() {
		return cargo;
	}
	
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	public double getDoorHigh() {
		return doorHigh;
	}
	
	public void setDoorHigh(double doorHigh) {
		this.doorHigh = doorHigh;
	}

	public double getDoorWidth() {
		return doorWidth;
	}
	
	public void setDoorWidth(double doorWidth) {
		this.doorWidth = doorWidth;
	}
	@Override
	public boolean equals(Object o) {
		if(this == o) 
			return true;
		if(o == null) 
			return false;
		if(this.getClass() != o.getClass())
			return false;
		CargoPlane other = (CargoPlane)o;
		if(!super.equals(o)) {
			return false;
		}
		if(EntityHelper.equalsWithNull(this.cargo, other.getCargo()) && 
				this.doorHigh == other.doorHigh && 
				this.doorWidth == other.doorWidth) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(", " + cargo);
		result.append(", " + doorHigh);
		result.append(", " + doorWidth);
		return result.toString();
	}
	
	@Override
	public int hashCode() {
		int result = super.hashCode();
		int prime = 31;
		result = prime * result + EntityHelper.hashCodeWithNull(cargo);
		result = prime * result + (int)doorHigh;
		result = prime * result + (int)doorWidth;
		return result;
	}

}
