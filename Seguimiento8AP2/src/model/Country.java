package model;

import java.util.Collections;

public class Country {
	

	private String name;

	private String[] maleMedals;
	private String[] femaleMedals;
	/*
	 * ---------Constructor---------
	 */
	public Country(String name, String[] maleMedals, String[] femaleMedals) {
		super();
		this.name = name;
		this.maleMedals = maleMedals;
		this.femaleMedals = femaleMedals;
	}
	/*
	 * ---------Getters and Setters---------
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getMaleMedals() {
		return maleMedals;
	}

	public void setMaleMedals(String[] maleMedals) {
		this.maleMedals = maleMedals;
	}

	public String[] getFemaleMedals() {
		return femaleMedals;
	}

	public void setFemaleMedals(String[] femaleMedals) {
		this.femaleMedals = femaleMedals;
	}

}
