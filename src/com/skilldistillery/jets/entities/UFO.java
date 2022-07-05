package com.skilldistillery.jets.entities;

public class UFO extends Jet implements AlienShip{

	public UFO(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	
	}

	@Override
	public void huntEarthlings() {
		System.out.println("Searching the galaxy for human scum!");
		
		System.out.println("              _.---._   .            .  ");
        System.out.println("    *       .'       '.                 ");
        System.out.println("        _.-~===========~-._             ");
        System.out.println("  *    (___________________)       .   *");
        System.out.println("             |_______|                  ");
        System.out.println("                ***                     ");
        System.out.println("                ***                     ");
        System.out.println("                ***                     ");
        System.out.println("                ***                     ");
        System.out.println("                ***                     ");
        System.out.println("                                        ");
		System.out.println("\n");
		
	}

}
