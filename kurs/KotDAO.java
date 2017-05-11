/*
Zadanie 
Zmodyfikuj program który ju¿ napisa³aœ. Utwórz now¹ klasê o nazwie KotDAO, posiadaj¹c¹ metodê dodajKoa(Kot kot) oraz pole 
koty bêd¹ce kolekcj¹ (list¹).

 */


package kurs;

import java.util.ArrayList;
import java.util.List;

public class KotDAO {
	List<Kot> koty = new ArrayList<Kot>();
	public void dodajKota(Kot kot) {
		koty.add(kot);
		System.out.println("Dziêkujê, doda³em kota do kolekcji");
	}
	
	public void showCats() {
		for (Kot kociak : koty) {
			String nazwa = kociak.getName();
			Integer numer = koty.indexOf(kociak);
			System.out.println(nazwa + ", " + numer);
		}
	}

}
