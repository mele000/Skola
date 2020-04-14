package test;

import java.io.Serializable;

public class Ucenik implements Serializable {

	private String ime = "a";
	private String prezime = "b";
	private double prosjek;
	private boolean mozeLiSeNapraviti;
	
	
	
	public Ucenik() {
	}


	
	public Ucenik(String ime, String prezime, double prosjek) {
		this.ime = ime;
		this.prezime = prezime;
		this.prosjek = prosjek;
	
		if (vratiUcenikaSaIstimImenom().getPrezime().equals(prezime) || vratiUcenikaSaIstimPrezimenom().getIme().equals(ime)) {
			mozeLiSeNapraviti = false;
			System.out.println("Postoji vec takav jedan ucenik");
		}
		else {
			mozeLiSeNapraviti = true;
		}
	
	System.out.println(mozeLiSeNapraviti);
	System.out.println(vratiUcenikaSaIstimImenom().getPrezime());
	}

	public Ucenik vratiUcenikaSaIstimImenom() {
		
		for (int i = 0; i < Skola.listaUcenika.size(); i++) {
			if (Skola.listaUcenika.get(i).getIme().equals(this.ime)) {
				return Skola.listaUcenika.get(i);
					
			}
		}
		
		Ucenik ucenik = new Ucenik();
		return ucenik;
	
	}
	
	public Ucenik vratiUcenikaSaIstimPrezimenom() {
		
		for (int i = 0; i < Skola.listaUcenika.size(); i++) {
			if (Skola.listaUcenika.get(i).getPrezime().equals(this.prezime)) {
				return Skola.listaUcenika.get(i);
					
			}
	
		}
		Ucenik ucenik = new Ucenik();
		return ucenik;
	}

	
	
	
	
	public String getIme() {
		return ime;
	}

	
	public String getPrezime() {
		return prezime;
	}


	public double getProsjek() {
		return prosjek;
	}

	public boolean getMozeLiSeNapraviti() {
		return mozeLiSeNapraviti;
	}



	@Override
	public String toString() {
		return "Ucenik [ime=" + ime + ", prezime=" + prezime + ", prosjek=" + prosjek + "]";
	}



	

	
}
