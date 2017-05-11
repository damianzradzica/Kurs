/*
Zadanie 
Zmodyfikuj program kt�ry ju� napisa�a�. Utw�rz now� klas� o nazwie KotDAO, posiadaj�c� metod� dodajKoa(Kot kot) oraz pole 
koty b�d�ce kolekcj� (list�).

 */


package kurs;

import java.util.ArrayList;
import java.util.List;

public class KotDAO {
	List<Kot> koty = new ArrayList<Kot>();
	public void dodajKota(Kot kot) {
		koty.add(kot);
		System.out.println("Dzi�kuj�, doda�em kota do kolekcji");
	}
	
	public void showCats() {
		for (Kot kociak : koty) {
			String nazwa = kociak.getName();
			Integer numer = koty.indexOf(kociak);
			System.out.println(nazwa + ", " + numer);
		}
	}

}
