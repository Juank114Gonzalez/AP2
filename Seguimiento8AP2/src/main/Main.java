package main;

import model.CountryData;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountryData data = new CountryData();
		
		System.out.println("Masculino");
		data.order(1);
		data.print(1);
		System.out.println("----------");
		System.out.println("Femenino");
		data.order(2);
		data.print(2);
		System.out.println("----------");
		System.out.println("Combinado");
		data.order(3);
		data.print(3);
	}

}
