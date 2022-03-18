package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import model.Country;

public class Main {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int countriesQuant = sc.nextInt();

		Country[] medals = new Country[countriesQuant];

		String readLine = sc.nextLine();
		
		String[] aux = readLine.split(";");
		
		// First floor
		
		String[] masleMedals = new String[3];
		String[] femaleMedals = new String[3];
		
		for(int i = 1; i < aux.length; i++) {
			if(i<4){
				masleMedals[i] = (aux[i]);
			}else {
				femaleMedals[i] = (aux[i]);
			}
		}
		
		
		
		
		
		
		
		/*
		 * for (int i = 0; i < countriesQuant; i++) {
		 * 
		 * for (int k = 0; k < 3; k++) { firstFloor[i][k] = medals[i][k]; } }
		 */
	}

}
