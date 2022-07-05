package com.skilldistillery.jets.app;

import java.util.Scanner;
import com.skilldistillery.jets.entities.Airfield;
import com.skilldistillery.jets.entities.CargoCarrier;
import com.skilldistillery.jets.entities.CargoPlanes;
import com.skilldistillery.jets.entities.FighterJets;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.Passenger;

public class JetsApplication {

	private Airfield airField = new Airfield();
	
	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApplication jetsApp = new JetsApplication();
		jetsApp.run();

	}

	private void run() {
//		Airfield airField = new Airfield();
		airField.jetFleet("jets.txt");
		while (true) {
			displayMenu();

			makeChoice(0);

		}
	}

	private void displayMenu() {

		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@             __|__              @");
		System.out.println("@      --@--@--(_)--@--@--       @");
		System.out.println("@           !   !   !            @");
		System.out.println("@ 1. List fleet                  @");
		System.out.println("@ 2. Fly all jets                @");
		System.out.println("@ 3. View fastest jet            @");
		System.out.println("@ 4. View jet with longest range @");
		System.out.println("@ 5. Load all cargo jets         @");
		System.out.println("@ 6. Dogfight!                   @");
		System.out.println("@ 7. Add a jet to Fleet          @");
		System.out.println("@ 8. Remove a jet from Fleet     @");
		System.out.println("@ 9. Quit                        @");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

	}

	public boolean makeChoice(int choice) {
//		JetsApplication addPlanes = new JetsApplication();
//		JetsApplication removePlanes = new JetsApplication();
	

		System.out.println("Please make a selection between 1-10.");

		choice = kb.nextInt();
		switch (choice) {
		case 1:
			listFleet();
			System.out.println();
			break;

		case 2:
			flyAllJets();
			System.out.println();
			break;

		case 3:
			viewFastestJet();
			System.out.println();
			break;
		case 4:
			viewLongestRange();
			break;

		case 5:
			loadCargoPlanes();
			System.out.println();
			break;
		case 6:
			dogFight();
			System.out.println();
			break;
		case 7:
			addAircraft(kb);
			System.out.println();
			break;
		case 8:
			removeAircraft(kb);
			System.out.println();
			break;
		case 9:
			quitProgram();
			return false;
		}
		return true;
	}

	public void addAircraft(Scanner kb) {

		System.out.println("Please enter the type of aircraft (Passenger, Cargo, Fighter): ");
		String type = kb.next(); //part of stretch but has no current function aside from allowing the input type to match on add

		System.out.println("Please enter the model of aircraft you would like to add: ");
		String model = kb.next();

		System.out.println("Please enter the aircrafts speed in MPH: ");
		double speed = kb.nextDouble();

		System.out.println("Please enter the range of the aircraft in miles:");
		int range = kb.nextInt();

		System.out.println("Please enter the aircrafts price: ");
		long price = kb.nextLong();

		if (type.equalsIgnoreCase("Fighter")) {
			FighterJets fighter = new FighterJets(model, speed, range, price);
			airField.fleet.add(fighter);
		} else if (type.equalsIgnoreCase("Cargo")) {
			CargoPlanes cargo = new CargoPlanes(model, speed, range, price);
			airField.fleet.add(cargo);
		} else if (type.equalsIgnoreCase("Passenger")) {
			Passenger pass = new Passenger(model, speed, range, price);
			airField.fleet.add(pass);
		}

	}

	public void listFleet() {

		for (Jet jet : airField.fleet) {

			System.out.println(jet.toString());
		}
	}

	public void flyAllJets() {

		for (Jet jet : airField.fleet) {
			jet.fly();

		}
	}

	public void viewFastestJet() {

		double fastestJet = 0;

		for (Jet jet : airField.fleet) {
			if(fastestJet < jet.getSpeed()) {
				fastestJet = jet.getSpeed();
				
			}
		}
		for (Jet jet : airField.fleet) {
			if(fastestJet == jet.getSpeed()) {
				System.out.println("The fastest jet in the fleet is: " + jet.toString());

			}
		}
		
	}

	public void loadCargoPlanes() {

		for (Jet jet : airField.fleet) {
			if (jet instanceof CargoCarrier) {
				System.out.println(jet.toString());
				((CargoCarrier) jet).loadCargo();
			}
		}

	}

	public void dogFight() {

		FighterJets fighterJets = new FighterJets(null, 0, 0, 0);
		fighterJets.fight();

	}
	public void viewLongestRange() {
		
		double longestRange = 0;
		for (Jet jet : airField.fleet) {
			if (longestRange < jet.getRange()) {
				longestRange = jet.getRange();
			}
		}
		for (Jet jet : airField.fleet) {
			if (longestRange == jet.getRange()) {
				System.out.println("The jet with the longest range is: " + jet.toString());
			}
		}

	}

	public void removeAircraft(Scanner kb) {
		int i = 0;
		for (Jet jet : airField.fleet) {
			System.out.println(i + ": " + jet.toString());
			i++;
		}
		int selection = 0;
		System.out.println("Enter number to remove: ");
		selection = kb.nextInt();
		if (selection != 0 && selection <= airField.fleet.size()) {
			airField.fleet.remove(selection);
		} else {
			System.err.println("Invalid input.");
		}
		
	}
	public void quitProgram() {
		System.out.println("Thank you for using Jets!");
		System.out.println();
		System.exit(0);
	}
}
