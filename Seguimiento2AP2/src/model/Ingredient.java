package model;

import exceptions.InvalidRemovingException;
import exceptions.NegativeNumberException;

public class Ingredient {
	private String name;
	private double weight;
	
	public Ingredient(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void addWeight(double additionalW) throws NegativeNumberException {
		
		if(additionalW < 0) {
			throw new NegativeNumberException(this.name,additionalW);
		}else {
			this.weight += additionalW;
		}
		
	}
	
	public void removeWeight(double decreasingW) throws NegativeNumberException, InvalidRemovingException{
		
		if(decreasingW < 0) {
			throw new NegativeNumberException(this.name,decreasingW);
		}else if(this.weight < decreasingW){
			throw new InvalidRemovingException(this.name,decreasingW, this.weight);
		}else {
			weight -= decreasingW;
		}
		
	}
	
}
