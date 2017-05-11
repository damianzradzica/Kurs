/*
Zadanie 1
Utw�rz klas� interfejs. Klasa ta powinna by� aplikacj� (tzn. �eby mo�na by�o j� uruchomi�) i powinna pyta� o nastepuj�ce elementy:
- imi� kota
- opiekun

Zadanie 2
Popraw klas� z poprzedniego zadania tak, aby:
-odczytywa�a i zapisywa�a w obiekcie kot dat� w formacie RRRR-MM-DD
-odczytywa�a i zapisywa�a w obiekcie kot jego mas� w formacie zmiennoprzecinkowym
	-do konwersji ci�gu znak�w u�yj klasy java.lang.Float
	-odpowiedni� metod� oraz informacj�, jaki wyj�tek mo�e rzuci�, znajdziesz w dokumentacji klasy Float
Je�li walidacja kt�rego� pola si� nie powiedzie, program powinien pyta� o poprawne dane a� do skutku (zanim przejdzie dalej).

Zadanie 3
Zmodyfikuj program, kt�ry ju� napisa�e� tak, aby u�ywa� wyra�e� regularnych w miejscach gdzie s� klauzule try-catch.
Pseudokod powinien wygl�da� nast�puj�co:
1. Wczytaj informacje od u�ytkownika
2. Dop�ki to, co poda� u�ytkownik nie pasuje do wyra�enia regularnego, pro� go ponownie o podanie danych
3. Je�li to, co wpisa� u�ytkownik pasuje do wyra�enia regularnego przejd� dalej i wykonaj w�a�ciwy kod (np. konwersja daty)
 � mo�liwe, �e nadal b�dziesz musia� u�ywa� blok�w try-catch w niekt�rych miejscach (przez checked exceptions)
 */


package kurs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interfejs {
	
	static Scanner sc = new Scanner(System.in);
	public static String getInfo() {
		return sc.nextLine();
	}
	
	public static void showMessage() {
		System.out.println("Wybierz jedn� z dost�pnych opcji: 1 - dodaj kota; 2 - poka� koty; X - zamknij program");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KotDAO kotDao = new KotDAO();
		String response;
		do {
			showMessage();
			response = getInfo();
			if (response.equals("1")){
	//			Zadanie 1
				Kot kot = new Kot();
				System.out.print("Podaj imi� kota: ");
				String imieKota = getInfo();
				kot.zmienImie(imieKota);
				System.out.print("Wska� opiekuna: ");
				String opiekun = getInfo();
				kot.zmienOpiekuna(opiekun);
				System.out.println("Imi� kota to " + imieKota + " a jego opiekunem jest " + opiekun + ".");
				
	//			Zadanie 2
	//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
	//			System.out.print("Podaj dat� urodzenia kota: ");
	//			Date data = null;
	//			while (data == null) {
	//				try {
	//					String napis = getInfo();
	//					data = sdf.parse(napis);
	//					kot.zmienDate(data);
	//					break;
	//				} catch (ParseException pe) {
	//					System.out.println("B��dny format daty");
	//				} 
	//			}
	//			
		//
	//			do {
	//				System.out.print("Podaj wag� kota: ");
	//				try {
	//					kot.zmienWage(Float.parseFloat(getInfo()));
	//				}
	//				catch (NumberFormatException nfe) { 
	//					System.out.println("B��dna waga");
	//				}
	//			}
	//			while (kot.waga == null);
				
	//			Zadanie 3
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
				Pattern wzorzecDaty = Pattern.compile("[1-9]{4}\\.[0-1]?[1-9]\\.[0-3]?[0-9]");
				Date data = null;
				do {
					System.out.print("Podaj dat� urodzenia kota: ");
					String wpisUzytkownika = getInfo();
					Matcher matcher = wzorzecDaty.matcher(wpisUzytkownika);
					if (matcher.matches()) {
						try {
							data = sdf.parse(wpisUzytkownika);
							kot.zmienDate(data);
						}
						catch (ParseException pe) {
							System.out.print("B��dna data");
						}
					}
				}
				while (data == null);
				
				
				
				Pattern wzorzecWagi = Pattern.compile("[0-9]+(\\.[0-9]+)?");
		        String wagaWczytana;
		        do {
		            System.out.print("Podaj wag� kota: ");
		            wagaWczytana = getInfo();
		            
		            if (wzorzecWagi.matcher(wagaWczytana).matches()) {
		                kot.waga = Float.valueOf(wagaWczytana);
		            }
		        } while (kot.waga == null);
		        
	//	        Zadanie 4
	//	        Na pocz�tku programu utw�rz nowy obiekt KotDAO. Po tym, jak wype�nisz obiekt Kot wywo�aj jego metod� dodajKota
	//	        przekazuj�c jako argument utworzony i wype�niony wcze�niej obiekt. Metoda dodajKota powinna doda� kotka przekazanego 
	//	        w argumencie do kolekcji (listy).
		        
		        kotDao.dodajKota(kot);
		        
			} else if (response.equals("2")) {
				if (kotDao.koty.isEmpty()) {
					System.out.print("Brak kot�w. ");
				} else {
				kotDao.showCats();
				String userChoice = getInfo();
				try {
					int numberChoice = Integer.parseInt(userChoice);
					System.out.print(kotDao.koty.get(numberChoice).przedstawSie());
				} catch (NumberFormatException nfe) {
					System.out.println("To nie liczba, popraw sw�j wyb�r");
				} catch (IndexOutOfBoundsException ioobe) {
					System.out.println("Nie ma takiego kota");
				}
				}
			} else if (response.equals("X")) {
				System.out.print("Zamykam program");
			} else {
				System.out.print("B��dny komunikat, wprowad� ponownie 1, 2 lub X. ");
				showMessage();
				}
		} while (!response.equals("X"));
	}
}


		

