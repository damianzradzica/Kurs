/*
Zadanie
Utw�rz klas� Kot . Klasa ta powinna mie� nast�puj�ce pola:
- imi� (ci�g znak�w)
- data urodzenia (data)
- waga (liczba zmiennoprzecinkowa)
- imi� opiekuna (ci�g znak�w)
Klasa ta powinna te� mie� jedn� metod� o nazwie przedstawSie. Metoda ta nie przyjmuje �adnych argument�w i zwraca ci�g 
znak�w kt�ry jest zdaniem zawieraj�cym imi� kotka, jego dat� urodzenia, wag� oraz imi� opiekuna.
 */

package kurs;

import java.util.Date;

public class Kot {
	private String imie;
	private Date dataUrodzenia;
	public Float waga;
	private String imieOpiekuna;
	
	public String przedstawSie() {
		return "Cze��, jestem "+imie+", urodzi�em si� "+dataUrodzenia+", wa�� "+waga+", a opiekuje si� mn� " + imieOpiekuna + ". ";
	}
	
	public void zmienImie(String nazwa){
		this.imie = nazwa;
	}
	
	public void zmienOpiekuna(String opiekun){
		this.imieOpiekuna = opiekun;
	}
	
	public void zmienDate(Date data){
		this.dataUrodzenia = data;
	}
	
	public void zmienWage(Float masa){
		this.waga = masa;
	}
	public String getName(){
		return this.imie;
	}

}
