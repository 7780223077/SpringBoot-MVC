package com.charan.util;

public class Remote {
	private static Remote INSTANCE;
	
	private Remote() {}
	
	public static Remote getRemote() {
		if(INSTANCE == null) {
			INSTANCE = new Remote();
			return INSTANCE;
		}
		return INSTANCE;
	}
}
