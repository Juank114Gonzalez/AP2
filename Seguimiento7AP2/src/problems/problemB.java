package problems;

import java.util.Scanner;

public class problemB {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = sc.nextInt();

		int[] secretaries = new int[n];

		int c = 0;
		// Read
		for (int i = 0; i < n; i++) {
			secretaries[i] = sc.nextInt();
		}

		// Bubble
		for (int i = 0; i < secretaries.length - 1; i++) {
			for (int j = 1; j < secretaries.length; j++) {
				int actual = secretaries[j];
				int ante = secretaries[j - 1];
				if (actual < ante) {
					secretaries[j] = ante;
					secretaries[j - 1] = actual;
				}
			}
		}

		
		for(int i = 1; i < secretaries.length ;i++) {
			if(secretaries[i] == secretaries[i-1]) {
				c++;
			}
			if(secretaries[i-1] == secretaries[i] && secretaries[i] == secretaries[i+1] && secretaries[i-1] == secretaries[i+1]) {
				c = -1;
				break;
			}
		}

		System.out.println(c);
	}

}
