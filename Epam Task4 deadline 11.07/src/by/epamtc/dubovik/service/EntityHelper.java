package by.epamtc.dubovik.service;

public class EntityHelper {
	
	public static boolean equalsWithNull(Object o1, Object o2) {
		return o1 != null ? o1.equals(o2) : o2 == null;
	}
	
	public static int hashCodeWithNull(Object o) {
		return o != null ? o.hashCode() : 0;
	}

}
