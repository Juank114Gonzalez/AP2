package exceptions;

public class NegativeNumberException extends Exception{

	public NegativeNumberException(String name, double weight) {
		super("Está intentando añadir un peso negativo ("+ weight +") para el ingrediente: "+name);
	}
	
}
