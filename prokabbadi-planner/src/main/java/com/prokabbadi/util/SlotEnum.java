package com.prokabbadi.util;

public enum SlotEnum {
	ALREADY_PLAYING(-1),
	NO_SCHEDULE_AVAILABLE(0),
	SLOTS_AVAILABLE(1),
	NO_SLOTS_AVAILABLE(2);  

	private int value;  
	
	SlotEnum(int value){  
		this.value=value;  
	}
	
	public int getValue() {
		return this.value;
	}
}
