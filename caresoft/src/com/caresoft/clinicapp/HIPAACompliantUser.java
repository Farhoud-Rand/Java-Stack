package com.caresoft.clinicapp;

public interface HIPAACompliantUser {
	abstract boolean assignPin(int pin);
    abstract boolean accessAuthorized(Integer confirmedAuthID);
    public default int digits (int num) {
    	int count =0;
    		while (num>0) {
    			num/=10;
    			count ++;
    			
    		}
    		return count;
    		
    	}
}
