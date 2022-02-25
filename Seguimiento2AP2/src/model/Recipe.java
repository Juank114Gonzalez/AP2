package model;

import java.util.ArrayList;
import java.util.List;

import exceptions.NegativeNumberException;

public class Recipe {
	private List<Ingredient> ingredients;
	
	public Recipe() {
		ingredients = new ArrayList<Ingredient>();
	}
	
	public void addIngredient(String name, double weight) {
		
		Ingredient searched = null;
		Ingredient current = null;
		for (int i = 0; i < ingredients.size() && searched==null; i++) {
			current = ingredients.get(i);
			if(current.getName().equals(name)) {
				searched = current;
			}
		}
		
		
		if(searched!=null) {
			try {
				searched.addWeight(weight);
			} catch (NegativeNumberException e) {
				e.printStackTrace();
			}
		}else {
			Ingredient newIngredient = new Ingredient(name, weight);
			ingredients.add(newIngredient);
		}		
	}
	
	public List<Ingredient> getIngredients(){
		return ingredients;
	}
	
	public void removeIngredient(String name) {
		Ingredient searched = null;
		Ingredient current = null;
		for (int i = 0; i < ingredients.size() && searched==null; i++) {
			current = ingredients.get(i);
			if(current.getName().equals(name)) {
				searched = current;
			}
		}
		
		ingredients.remove(searched);
	}
}
