package com.skilldistillery.jets.entities;

public class FighterJets extends Jet implements CombatReady {
	public FighterJets(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		
	}

	@Override
	public void fight() {
		System.out.println("I've got an enemy on radar, engaging in combat!");
		System.out.println();
		System.out.println("Okay Mav, let's turn and burn!");
		System.out.println();
		
	}
}
