package com.skilldistillery.jets.entities;

public class Passenger extends Jet implements PassengerPlane {
	public Passenger(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		
	}

	public void loadPassengers() {
		System.out.println("Welcome aboard, this is you Captain speaking." +  "\n");
		System.out.println("Please find your seats and fasten your seatbelts, it is bound to be a bumpy ride." + "\n");
	}
}
