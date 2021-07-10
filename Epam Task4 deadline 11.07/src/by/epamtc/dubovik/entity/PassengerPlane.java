package by.epamtc.dubovik.entity;

import java.io.Serializable;

import by.epamtc.dubovik.service.EntityHelper;

public class PassengerPlane extends Plane implements Serializable {
	
	private SeatType first;
	private SeatType business;
	private SeatType econom;
	
	public PassengerPlane() {
		first = new SeatType();
		business = new SeatType();
		econom = new SeatType();
	}
	
	public PassengerPlane(String model, 
			double planeLength,
			double planeHigh,
			double wingspan,
			double speed,
			double fuelConsumption,
			double flightAltitude,
			double flightRange,
			SeatType first,
			SeatType business,
			SeatType econom) {
		super(model,
			planeLength,
			planeHigh,
			wingspan,
			speed,
			fuelConsumption,
			flightAltitude,
			flightRange);
		this.first = first;
		this.business = business;
		this.econom = econom;
	}
	
	public SeatType getFirst() {
		return first;
	}
	
	public void setFirst(SeatType first) {
		this.first = first;
	}

	public SeatType getBusiness() {
		return business;
	}
	
	public void setBusiness(SeatType business) {
		this.business = business;
	}

	public SeatType getEconom() {
		return econom;
	}
	
	public void setEconom(SeatType econom) {
		this.econom = econom;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) 
			return true;
		if(o == null) 
			return false;
		if(this.getClass() != o.getClass())
			return false;
		PassengerPlane other = (PassengerPlane)o;
		if(!super.equals(o)) {
			return false;
		}
		if(EntityHelper.equalsWithNull(this.first, other.first) &&
				EntityHelper.equalsWithNull(this.business, other.business) &&
				EntityHelper.equalsWithNull(this.econom, other.econom)){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(", " + first);
		result.append(", " + business);
		result.append(", " + econom);
		return result.toString();
	}
	
	@Override
	public int hashCode() {
		int result = super.hashCode();
		int prime = 31;
		result = prime * result + EntityHelper.hashCodeWithNull(first);
		result = prime * result + EntityHelper.hashCodeWithNull(business);
		result = prime * result + EntityHelper.hashCodeWithNull(econom);
		return result;
	}
}
