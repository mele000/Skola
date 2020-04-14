package test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class DodatniPredmet implements Serializable {

	private String imePredmeta = "a";
	public ArrayList<Ucenik> listaUcenikaJednogPredmeta = new ArrayList<>();
	private boolean validacija;
	private java.util.Date date = new java.util.Date();
	private java.util.Date dateNow = new java.util.Date();
	int biloKojiBroj;
	String imeUcenika;
	String prezimeUcenika;

	public DodatniPredmet() {
	}

	public java.util.Date postavitiLokalnoVrijeme() {
		dateNow.getTime();
		return dateNow;
	}

	public boolean provjeriDatum() {

		if (date.after(postavitiLokalnoVrijeme()) == true) {
			return true;
		}
		return false;
	}

	public DodatniPredmet(String imeUcenika, String prezimeUcenika, String imePredmeta, int biloKojiBroj) {
		this.imeUcenika = imeUcenika;
		this.prezimeUcenika = prezimeUcenika;
		this.imePredmeta = imePredmeta;
		this.biloKojiBroj = biloKojiBroj;

		if (postojiLiUcenik() == true) {
			if (postojiLiPredmet() == true) {
				if (postojiLiUcenikUPredmetu() == false) {

					vratiPredmet().listaUcenikaJednogPredmeta.add(vratiUcenika());
					System.out.println("Dodali ste ucenika na predmet " + vratiPredmet().getImePredmeta());
				} else {
					System.out.println("Vec postoji takav ucenik u predmetu");
				}

			} else {
				System.out.println("Ne postoji takav predmet");
			}
		} else {
			System.out.println("Ne postoji takav ucenik");
		}
	}

	public DodatniPredmet(String imePredmeta, Date date) {
		this.imePredmeta = imePredmeta;
		this.date = date;

		if (postojiLiIstiPredmet() == true) {
			if (provjeriDatum() == true) {
				vratiPredmet().setDate(this.date);
				System.out.println("Datum je spremljen");
			} else {
				System.out.println("Datum je vec prosao");
			}
		} else {
			System.out.println("Predmet ne postoji");
		}
	}

	public DodatniPredmet(String imePredmeta) {
		this.imePredmeta = imePredmeta;

		if (postojiLiIstiPredmet() == true) {
			validacija = false;
			System.out.println("Vec postoji takav jedan predmet");
		} else {
			validacija = true;
		}

	}

	public boolean postojiLiUcenik() {

		for (int i = 0; i < Skola.listaUcenika.size(); i++) {
			if (Skola.listaUcenika.get(i).getIme().equals(imeUcenika)) {
				if (Skola.listaUcenika.get(i).getPrezime().equals(prezimeUcenika)) {
					return true;

				}
			}
		}

		return false;
	}

	public Ucenik vratiUcenika() {

		for (int i = 0; i < Skola.listaUcenika.size(); i++) {

			if (Skola.listaUcenika.get(i).getIme().equals(imeUcenika)) {
				if (Skola.listaUcenika.get(i).getPrezime().equals(prezimeUcenika)) {
					return Skola.listaUcenika.get(i);
				}
			}
		}
		Ucenik ucenik = new Ucenik();
		return ucenik;
	}

	public boolean postojiLiPredmet() {

		for (int i = 0; i < Skola.listaDodatnihPredmeta.size(); i++) {
			if (Skola.listaDodatnihPredmeta.get(i).getImePredmeta().equals(imePredmeta)) {
				return true;
			}
		}

		return false;
	}

	public DodatniPredmet vratiIstiPredmet() {

		for (int i = 0; i < Skola.listaDodatnihPredmeta.size(); i++) {
			if (Skola.listaDodatnihPredmeta.get(i).getImePredmeta().equals(this.imePredmeta)) {
				return Skola.listaDodatnihPredmeta.get(i);
			}
		}

		DodatniPredmet predmet = new DodatniPredmet();
		return predmet;
	}

	public boolean postojiLiUcenikUPredmetu() {

		for (int i = 0; i < vratiIstiPredmet().listaUcenikaJednogPredmeta.size(); i++) {
			if (vratiIstiPredmet().listaUcenikaJednogPredmeta.get(i).getIme().equals(imeUcenika)) {
				if (vratiIstiPredmet().listaUcenikaJednogPredmeta.get(i).getPrezime().equals(prezimeUcenika)) {
					return true;
				}
			}
		}

		return false;
	}

	public DodatniPredmet vratiPredmet() {

		for (int i = 0; i < Skola.listaDodatnihPredmeta.size(); i++) {
			if (Skola.listaDodatnihPredmeta.get(i).getImePredmeta().equals(imePredmeta)) {
				return Skola.listaDodatnihPredmeta.get(i);
			}
		}

		DodatniPredmet predmet = new DodatniPredmet();
		return predmet;
	}

	public boolean postojiLiIstiPredmet() {

		for (int i = 0; i < Skola.listaDodatnihPredmeta.size(); i++) {
			if (Skola.listaDodatnihPredmeta.get(i).getImePredmeta().equals(imePredmeta)) {
				return true;
			}
		}

		return false;
	}

	public boolean getValidacija() {
		return validacija;
	}

	public String getImePredmeta() {
		return imePredmeta;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		if (provjeriDatum() == true) {
			return "DodatniPredmet [imePredmeta=" + imePredmeta + ", date=" + date + ", listaUcenikaJednogPredmeta="
					+ listaUcenikaJednogPredmeta + "]";
		} else
			return "DodatniPredmet [imePredmeta=" + imePredmeta + ", listaUcenikaJednogPredmeta="
					+ listaUcenikaJednogPredmeta +"]";
	}

}
