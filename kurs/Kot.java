/*
Zadanie
Utwórz klasê Kot . Klasa ta powinna mieæ nastêpuj¹ce pola:
- imiê (ci¹g znaków)
- data urodzenia (data)
- waga (liczba zmiennoprzecinkowa)
- imiê opiekuna (ci¹g znaków)
Klasa ta powinna te¿ mieæ jedn¹ metodê o nazwie przedstawSie. Metoda ta nie przyjmuje ¿adnych argumentów i zwraca ci¹g 
znaków który jest zdaniem zawieraj¹cym imiê kotka, jego datê urodzenia, wagê oraz imiê opiekuna.
 */

package kurs;

import java.util.Date;

public class Kot {
	private String imie;
	private Date dataUrodzenia;
	public Float waga;
	private String imieOpiekuna;
	
	public String przedstawSie() {
		return "Czeœæ, jestem "+imie+", urodzi³em siê "+dataUrodzenia+", wa¿ê "+waga+", a opiekuje siê mn¹ " + imieOpiekuna + ". ";
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
