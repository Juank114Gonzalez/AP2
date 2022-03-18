package model;

import java.util.ArrayList;
import java.util.Collections;

public class SortedCountries {

	public ArrayList<Country> firstFloor = new ArrayList<>();
	
	public ArrayList<Country> secondFloor = new ArrayList<>();

	public SortedCountries() {

	}

	/*
	 * public static ArrayList<Country>firstFloor = new ArrayList<>(); public static
	 * ArrayList<Country>secondFloor = new ArrayList<>(); public static
	 * ArrayList<Country>thirdFloor = new ArrayList<>(); public static
	 * ArrayList<Country>fourthFloor = new ArrayList<>();
	 */

	public void sortMaleMedals() {

		Collections.sort(firstFloor, (A, B) -> {
			int out = Integer.parseInt(A.getMaleMedals()[0]) - Integer.parseInt(B.getMaleMedals()[0]);
			if (out == 0) {
				out = Integer.parseInt(A.getMaleMedals()[1]) - Integer.parseInt(B.getMaleMedals()[1]);
				if (out == 0) {
					out = Integer.parseInt(A.getMaleMedals()[2]) - Integer.parseInt(B.getMaleMedals()[2]);
					if(out == 0) {
						out = A.getName().compareTo(B.getName());
					}
				}
			}
			return out;
		});

	}
	
	public void sortFemaleMedals() {

		Collections.sort(secondFloor, (A, B) -> {
			int out = Integer.parseInt(A.getMaleMedals()[0]) - Integer.parseInt(B.getMaleMedals()[0]);
			if (out == 0) {
				out = Integer.parseInt(A.getMaleMedals()[1]) - Integer.parseInt(B.getMaleMedals()[1]);
				if (out == 0) {
					out = Integer.parseInt(A.getMaleMedals()[2]) - Integer.parseInt(B.getMaleMedals()[2]);
					if(out == 0) {
						out = A.getName().compareTo(B.getName());
					}
				}
			}
			return out;
		});

	}

}
