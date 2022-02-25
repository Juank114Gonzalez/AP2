package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import exceptions.InvalidRemovingException;
import exceptions.NegativeNumberException;

class IngredientTest {
	
	private Ingredient tomato;

	//Escenario 1
	void setUpStage1() {
		tomato = new Ingredient("Tomate",245);
	}
	
	//Escenario 2
	void setUpStage2() {
		try {
			tomato.addWeight(54);
		} catch (NegativeNumberException e) {
			e.printStackTrace();
		}
	}
	
	//Escenario 3
	void setUpStage3() {
		try {
			tomato.removeWeight(45);
		} catch (NegativeNumberException | InvalidRemovingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Escenario 4
	void setUpStage4() {
		try {
			tomato.removeWeight(-100);
		} catch (NegativeNumberException | InvalidRemovingException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void addIngredientTest() {
		//Llamo el escenario
		setUpStage1();
		 //Comparo el nombre, y que sea tomate
		assertEquals(tomato.getName(), "Tomate");
		assertTrue(tomato.getWeight()== 245.0);
	}
	
	@Test
	void addWeightTest() {
		setUpStage1();//Creo el ingrediente tomate con 245 de peso
		setUpStage2();//añado al peso de tomate 54
		
		assertTrue(tomato.getWeight()== 299.0); // verifico la variable
	}
	
	
	@Test
	void removeWeightTest() {
		setUpStage1();//Creo el ingrediente tomate con 245 de peso
		setUpStage3();//remuevo al peso de tomate 45
		
		
		assertTrue(tomato.getWeight()== 200); // verifico la variable
	}
	
	@Test
	void negativeWeightTest() {
		setUpStage1();//Creo el ingrediente tomate con 245 de peso
		setUpStage4();//remuevo al peso de tomate -100
		
		assertTrue(tomato.getWeight()== 245); // verifico la variable
	}

}
