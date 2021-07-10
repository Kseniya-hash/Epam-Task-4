package by.epamtc.dubovik.entity;

import java.io.Serializable;

public class Cargo implements Serializable {
	
	private double weight;
	private double length;
	private double high;
	private double width;
	
	public Cargo() {}
	
	public Cargo(double weight, double length, double high, double width) {
		this.weight = weight;
		this.length = length;
		this.high = high;
		this.width = width;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getLength() {
		return length;
	}
	
	public void setLength(double length) {
		this.length = length;
	}

	public double getHigh() {
		return high;
	}
	
	public void setHigh(double high) {
		this.high = high;
	}

	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) 
			return true;
		if(o == null) 
			return false;
		if(this.getClass() != o.getClass())
			return false;
		Cargo other = (Cargo)o;
		if(this.weight == other.weight && 
				this.length == other.getLength() &&
				this.high == other.getHigh() &&
				this.width == other.getWidth()) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(weight + ", ");
		result.append(length + ", ");
		result.append(high + ", ");
		result.append(width);
		return result.toString();
	}
	
	@Override
	public int hashCode() {
		int result = 1;
		int prime = 31;
		result = result * prime + (int)weight;
		result = result * prime + (int)length;
		result = result * prime + (int)high;
		result = result * prime + (int)width;
		return result;
	}
}
