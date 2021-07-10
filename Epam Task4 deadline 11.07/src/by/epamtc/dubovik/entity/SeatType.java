package by.epamtc.dubovik.entity;

import java.io.Serializable;

public class SeatType implements Serializable {
	private int seatCount;
	private double carryOnBaggage;
	private Cargo luggagePerPerson;
	
	public SeatType() {}
	
	public SeatType(int seatCount, 
			double carryOnBaggage, 
			Cargo luggagePerPerson) {
		this.seatCount = seatCount;
		this.carryOnBaggage = carryOnBaggage;
		this.luggagePerPerson = luggagePerPerson;
	}
	
	public int getSeatCount() {
		return seatCount;
	}
	
	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}
	
	public double getCarryOnBaggage() {
		return carryOnBaggage;
	}
	
	public void setCarryOnBaggage(double carryOnBaggage) {
		this.carryOnBaggage = carryOnBaggage;
	}
	
	public Cargo getLuggagePerPerson() {
		return luggagePerPerson;
	}
	
	public void setLuggagePerPerson(Cargo luggagePerPerson) {
		this.luggagePerPerson = luggagePerPerson;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) 
			return true;
		if(o == null) 
			return false;
		if(this.getClass() != o.getClass())
			return false;
		SeatType other = (SeatType)o;
		if((this.luggagePerPerson != null ? !this.luggagePerPerson.equals(other.luggagePerPerson) 
											: other.luggagePerPerson != null)){
			return false;
		}
		if(this.seatCount == other.seatCount && this.carryOnBaggage == other.getCarryOnBaggage()) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(seatCount + ", ");
		result.append(carryOnBaggage + ", ");
		result.append(luggagePerPerson);
		return result.toString();
	}
	
	@Override
	public int hashCode() {
		int result = 1;
		int prime = 31;
		result = result * prime + seatCount;
		result = result * prime + (int)carryOnBaggage;
		result = prime * result + ((luggagePerPerson != null) ? luggagePerPerson.hashCode() : 0);
		
		return result;
	}

}
