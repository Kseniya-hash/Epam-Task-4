package by.epamtc.dubovik.runner;

import java.util.Scanner;

public class ReadFromConsole {
	
	static public int readInt() {
		Scanner in = new Scanner(System.in);
		
		while (!in.hasNextInt()) {
			in.next();
		}
		return in.nextInt();
	}
	
	static public double readDouble() {
		Scanner in = new Scanner(System.in);
		
		while (!in.hasNextDouble()) {
			in.next();
		}
		return in.nextDouble();
	}

}
