package kurs;

import java.util.Scanner;

public class TestowaKlasa {
	static Scanner sc = new Scanner(System.in);
	public static String getUserInput() {
		return sc.nextLine();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Podaj imiê: ");
		String imieWczytaneOdUzytkownika = getUserInput();
		System.out.println(imieWczytaneOdUzytkownika);
	}

}
