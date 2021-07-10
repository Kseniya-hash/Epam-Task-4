package by.epamtc.dubovik.dao;

public class PlaneNotFoundException extends Exception{

	public PlaneNotFoundException() {}
	
	public PlaneNotFoundException(String s) {
		super(s);
	}
	
	public PlaneNotFoundException(String s, Throwable cause) {
		super(s, cause);
	}
	
	public PlaneNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
