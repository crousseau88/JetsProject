package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Airfield {

	public List<Jet> fleet;

	public Airfield() {}

	
	public List<Jet> jetFleet(String fileName) {
		
		fleet = new ArrayList<Jet>();
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {

			String jets;
			String jetModel;
			double jetSpeed;
			int jetRange;
			long jetPrice;
			
			while ((jets = bufIn.readLine()) != null) {
				String[] jetFleet = jets.split(",");

				String jetType = jetFleet[0];
				jetModel = jetFleet[1];
				jetSpeed = Double.parseDouble(jetFleet[2]);
				jetRange = Integer.parseInt(jetFleet[3]);
				jetPrice = Long.parseLong(jetFleet[4]);

				if (jetType.equals("Fighter")) {
				Jet fighter =	new FighterJets(jetModel, jetSpeed, jetRange, jetPrice);
					fleet.add(fighter);
				} else if (jetType.equals("Cargo")) {
				Jet cargo = new CargoPlanes(jetModel, jetSpeed, jetRange, jetPrice);
					fleet.add(cargo);
				} else {
				Jet pass = new Passenger(jetModel, jetSpeed, jetRange, jetPrice);
				fleet.add(pass);
				}
				
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return fleet;

	}

	public List<Jet> getFleet() {
		return fleet;
	}


	public void setFleet(List<Jet> fleet) {
		this.fleet = fleet;
	}
	
}
