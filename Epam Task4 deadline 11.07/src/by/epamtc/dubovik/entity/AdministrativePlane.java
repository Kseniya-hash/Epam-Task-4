package by.epamtc.dubovik.entity;

import java.io.Serializable;

import by.epamtc.dubovik.service.EntityHelper;

public class AdministrativePlane extends Plane implements Serializable {
	private int seatCount;
	private Cargo luggage;
	
	public AdministrativePlane() {}
	
	public AdministrativePlane(String model, 
			double planeLength,
			double planeHigh,
			double wingspan,
			double speed,
			double fuelConsumption,
			double flightAltitude,
			double flightRange,
			int seatCount,
			Cargo luggage) {
		super(model,
			planeLength,
			planeHigh,
			wingspan,
			speed,
			fuelConsumption,
			flightAltitude,
			flightRange);
		this.seatCount = seatCount;
		this.luggage = luggage;
	}
	
	public int getSeatCount() {
		return seatCount;
	}
	
	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public Cargo getLuggage() {
		return luggage;
	}
	
	public void setLuggage(Cargo luggage) {
		this.luggage = luggage;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) 
			return true;
		if(o == null) 
			return false;
		if(this.getClass() != o.getClass())
			return false;
		AdministrativePlane other = (AdministrativePlane)o;
		if(!super.equals(o)) {
			return false;
		}
		if(this.seatCount == other.seatCount && EntityHelper.equalsWithNull(this.luggage, other.getLuggage())) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(", " + seatCount);
		result.append(", " + luggage);
		return result.toString();
	}
	
	@Override
	public int hashCode() {
		int result = super.hashCode();
		int prime = 31;
		result = prime * result + seatCount;
		result = prime * result + EntityHelper.hashCodeWithNull(luggage);
		return result;
	}
}
