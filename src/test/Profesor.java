package test;

import java.io.Serializable;

public class Profesor implements Serializable {

	
	private String ime = "a";
	private String prezime = "b";
	private boolean mozeLiSeNapraviti;
	
	
	
	public Profesor() {
	}
	
	public Profesor(String ime, String prezime) {
		
		this.ime = ime;
		this.prezime = prezime;
		
	
	if (vratiProfesorovoIme().getPrezime().equals(prezime) || vratiProfesorovoPrezime().getIme().equals(ime)) {
		System.out.println("Postoji vec takav jedan profesor");
		mozeLiSeNapraviti = false;
	}
	
	else 
		mozeLiSeNapraviti = true;
	
	
	

	}
//methods


public Profesor vratiProfesorovoIme() {
		
		for (int i = 0; i < Skola.listaProfesora.size(); i++) {
			if (Skola.listaProfesora.get(i).getIme().equals(this.ime)) {
				return Skola.listaProfesora.get(i);
			}
		}
		
		Profesor profesor = new Profesor();
	return profesor;
	
		}
	
public Profesor vratiProfesorovoPrezime() {
		
		for (int i = 0; i < Skola.listaProfesora.size(); i++) {
			if (Skola.listaProfesora.get(i).getPrezime().equals(this.prezime)) {
				return Skola.listaProfesora.get(i);
			
			}
			}
		
		Profesor profesor = new Profesor();
	return profesor;
	
		}	
	



//gett and setters

	

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public boolean getMozeLiSeNapraviti() {
		return mozeLiSeNapraviti;
	}

	@Override
	public String toString() {
		return "Profesor [ime=" + ime + ", prezime=" + prezime + "]";
	}
	
}
