package exceptions;

public class InvalidRemovingException extends Exception{

	public InvalidRemovingException(String name, double newWeight, double actualWeight) {
		super("Está intentando remover un peso mayor ("+ newWeight +") al que el ingrediente ("+name+") tiene ("+actualWeight+")");
	}
	
}