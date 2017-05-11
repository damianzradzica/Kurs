/*
Zadanie 1
Utwórz klasê interfejs. Klasa ta powinna byæ aplikacj¹ (tzn. ¿eby mo¿na by³o j¹ uruchomiæ) i powinna pytaæ o nastepuj¹ce elementy:
- imiê kota
- opiekun

Zadanie 2
Popraw klasê z poprzedniego zadania tak, aby:
-odczytywa³a i zapisywa³a w obiekcie kot datê w formacie RRRR-MM-DD
-odczytywa³a i zapisywa³a w obiekcie kot jego masê w formacie zmiennoprzecinkowym
	-do konwersji ci¹gu znaków u¿yj klasy java.lang.Float
	-odpowiedni¹ metodê oraz informacjê, jaki wyj¹tek mo¿e rzuciæ, znajdziesz w dokumentacji klasy Float
Jeœli walidacja któregoœ pola siê nie powiedzie, program powinien pytaæ o poprawne dane a¿ do skutku (zanim przejdzie dalej).

Zadanie 3
Zmodyfikuj program, który ju¿ napisa³eœ tak, aby u¿ywa³ wyra¿eñ regularnych w miejscach gdzie s¹ klauzule try-catch.
Pseudokod powinien wygl¹daæ nastêpuj¹co:
1. Wczytaj informacje od u¿ytkownika
2. Dopóki to, co poda³ u¿ytkownik nie pasuje do wyra¿enia regularnego, proœ go ponownie o podanie danych
3. Jeœli to, co wpisa³ u¿ytkownik pasuje do wyra¿enia regularnego przejdŸ dalej i wykonaj w³aœciwy kod (np. konwersja daty)
 – mo¿liwe, ¿e nadal bêdziesz musia³ u¿ywaæ bloków try-catch w niektórych miejscach (przez checked exceptions)
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
		System.out.println("Wybierz jedn¹ z dostêpnych opcji: 1 - dodaj kota; 2 - poka¿ koty; X - zamknij program");
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
				System.out.print("Podaj imiê kota: ");
				String imieKota = getInfo();
				kot.zmienImie(imieKota);
				System.out.print("Wska¿ opiekuna: ");
				String opiekun = getInfo();
				kot.zmienOpiekuna(opiekun);
				System.out.println("Imiê kota to " + imieKota + " a jego opiekunem jest " + opiekun + ".");
				
	//			Zadanie 2
	//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
	//			System.out.print("Podaj datê urodzenia kota: ");
	//			Date data = null;
	//			while (data == null) {
	//				try {
	//					String napis = getInfo();
	//					data = sdf.parse(napis);
	//					kot.zmienDate(data);
	//					break;
	//				} catch (ParseException pe) {
	//					System.out.println("B³êdny format daty");
	//				} 
	//			}
	//			
		//
	//			do {
	//				System.out.print("Podaj wagê kota: ");
	//				try {
	//					kot.zmienWage(Float.parseFloat(getInfo()));
	//				}
	//				catch (NumberFormatException nfe) { 
	//					System.out.println("B³êdna waga");
	//				}
	//			}
	//			while (kot.waga == null);
				
	//			Zadanie 3
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
				Pattern wzorzecDaty = Pattern.compile("[1-9]{4}\\.[0-1]?[1-9]\\.[0-3]?[0-9]");
				Date data = null;
				do {
					System.out.print("Podaj datê urodzenia kota: ");
					String wpisUzytkownika = getInfo();
					Matcher matcher = wzorzecDaty.matcher(wpisUzytkownika);
					if (matcher.matches()) {
						try {
							data = sdf.parse(wpisUzytkownika);
							kot.zmienDate(data);
						}
						catch (ParseException pe) {
							System.out.print("B³êdna data");
						}
					}
				}
				while (data == null);
				
				
				
				Pattern wzorzecWagi = Pattern.compile("[0-9]+(\\.[0-9]+)?");
		        String wagaWczytana;
		        do {
		            System.out.print("Podaj wagê kota: ");
		            wagaWczytana = getInfo();
		            
		            if (wzorzecWagi.matcher(wagaWczytana).matches()) {
		                kot.waga = Float.valueOf(wagaWczytana);
		            }
		        } while (kot.waga == null);
		        
	//	        Zadanie 4
	//	        Na pocz¹tku programu utwórz nowy obiekt KotDAO. Po tym, jak wype³nisz obiekt Kot wywo³aj jego metodê dodajKota
	//	        przekazuj¹c jako argument utworzony i wype³niony wczeœniej obiekt. Metoda dodajKota powinna dodaæ kotka przekazanego 
	//	        w argumencie do kolekcji (listy).
		        
		        kotDao.dodajKota(kot);
		        
			} else if (response.equals("2")) {
				if (kotDao.koty.isEmpty()) {
					System.out.print("Brak kotów. ");
				} else {
				kotDao.showCats();
				String userChoice = getInfo();
				try {
					int numberChoice = Integer.parseInt(userChoice);
					System.out.print(kotDao.koty.get(numberChoice).przedstawSie());
				} catch (NumberFormatException nfe) {
					System.out.println("To nie liczba, popraw swój wybór");
				} catch (IndexOutOfBoundsException ioobe) {
					System.out.println("Nie ma takiego kota");
				}
				}
			} else if (response.equals("X")) {
				System.out.print("Zamykam program");
			} else {
				System.out.print("B³êdny komunikat, wprowadŸ ponownie 1, 2 lub X. ");
				showMessage();
				}
		} while (!response.equals("X"));
	}
}


		

