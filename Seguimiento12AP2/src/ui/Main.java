package ui;

import java.util.Scanner;

import model.LinkedList;

public class Main {

	public static Scanner sc = new Scanner(System.in);

	private static LinkedList<Integer> list = new LinkedList<>();

	public static void main(String[] args) {
		int option = 0;
		do {
			showMenu();
			option = option();
			execute(option);
		} while (option != 0);
	}

	public static int option() {
		return sc.nextInt();
	}

	public static void showMenu() {
		System.out.println("1. Give turn\n" + "2. Show turn\n" + "3. Pass turn\n" + "4. Delete turn\n" + "0. Leave");
	}

	public static void execute(int option) {
		switch (option) {
		case 0:
			System.out.println("Bye...");
			break;
		case 1:
			giveTurn();
			break;

		case 2:
			showTurn();
			break;
		case 3:
			passTurn();
			break;

		case 4:
			deleteTurn();
			break;

		default:
			break;
		}
	}

	private static void deleteTurn() {
		// TODO Auto-generated method stub
		System.out.println("Delete turn");
	}

	private static void passTurn() {
		// TODO Auto-generated method stub
		System.out.println("Pass turn");
	}

	private static void showTurn() {
		// TODO Auto-generated method stub
		System.out.println("Show turn");
	}

	private static void giveTurn() {
		// TODO Auto-generated method stub
		addTurn();
		System.out.println("Give turn");
	}

	public static void addTurn() {
		list.add();
	}

}