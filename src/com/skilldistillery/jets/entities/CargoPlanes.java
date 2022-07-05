package com.skilldistillery.jets.entities;

public class CargoPlanes extends Jet implements CargoCarrier {

	public CargoPlanes(String model, double speed, int range, long price) {
		super( model, speed, range, price);
	}

	@Override
	public void loadCargo() {
		System.out.println("Loading cargo onto the aircraft.");
	}
}
