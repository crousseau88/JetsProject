package com.skilldistillery.jets.entities;

public class FighterJets extends Jet implements CombatReady {
	public FighterJets(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		
	}

	@Override
	public void fight() {
		
		
		System.out.println("I've got an enemy on radar, engaging in combat! ");
		System.out.println("  ___										    ");		
		System.out.println(" |   K                                          ");
		System.out.println(" |    K                 ___                     ");
		System.out.println(" |_____K_____________.-'`   `'-.,___            ");
		System.out.println("/| _____     _________            ___>---       ");
		System.out.println("K|___________________________,.-'`              ");
		System.out.println("          `'-.,__________)        *===>         ");
        System.out.println();
		System.out.println();
		System.out.println("Okay Mav, let's turn and burn!" + "\n");
		
	}
}
