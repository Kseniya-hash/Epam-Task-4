package by.epamtc.dubovik.service;

public class DataNotFoundException extends Exception{

	public DataNotFoundException() {}
	
	public DataNotFoundException(String s) {
		super(s);
	}
	
	public DataNotFoundException(String s,Throwable cause) {
		super(s, cause);
	}
	
	public DataNotFoundException(Throwable cause) {
		super(cause);
	}
}
