package problems;

import java.util.Scanner;

public class problemA{

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String line = sc.nextLine();
		
		System.out.println(outPut(line));
	}
	
	public static String outPut(String line) {
		String[] parts = line.split("\\+");
		int[] parseados = new int[parts.length];
		for(int i = 0; i<parts.length ; i++) {
			parseados[i] = Integer.parseInt(parts[i]);
		}
		
		
		//Bubble
		for(int i = 0; i < parseados.length -1; i++) {
			for(int j = 1; j< parseados.length; j++) {
				int actual = parseados[j];
				int ante = parseados[j-1];
				if(actual < ante) {
					parseados[j] = ante;
					parseados[j-1] = actual;
				}
			}
		}
		
		String out = "";
		for(int i = 0; i< parseados.length;i++) {
			if(i != parseados.length-1) {
				out+= parseados[i] + "+";
			}
			else {
				out+= parseados[i];
			}
			
			
		}
		
		return out;
		
	}

}
