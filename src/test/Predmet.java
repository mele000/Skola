package test;

import java.io.Serializable;
import java.util.ArrayList;

public class Predmet implements Serializable {

	

	private String imeProfesora;
	private String prezimeProfesora;
	private String imePredmeta = "a";
	public ArrayList<Ucenik> listaUcenikaJednogPredmeta = new ArrayList<>();
	private boolean mozeLiSeNapraviti;
	private String imeUcenika;
	private String prezimeUcenika;
	int biloKojiBroj;

	public Predmet() {
	}

	public Predmet(String imeUcenika, String prezimeUcenika, String imePredmeta, int biloKojiBroj) {
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

	public Predmet(String imePredmeta, String imeProfesora, String prezimeProfesora) {
		this.imePredmeta = imePredmeta;
		this.imeProfesora = imeProfesora;
		this.prezimeProfesora = prezimeProfesora;

		if (vratiIstiPredmet().getImePredmeta().equals(imePredmeta)) {
			mozeLiSeNapraviti = false;
			System.out.println("Vec postoji taj predmet");
		}

		else if (postojiLiProfesor() == false) {
			mozeLiSeNapraviti = false;
			System.out.println("Profesor ne postoji");
		} else {
			mozeLiSeNapraviti = true;

		}
	}

	public Predmet vratiIstiPredmet() {

		for (int i = 0; i < Skola.listaPredmeta.size(); i++) {
			if (Skola.listaPredmeta.get(i).getImePredmeta().equals(this.imePredmeta)) {
				return Skola.listaPredmeta.get(i);
			}
		}

		Predmet predmet = new Predmet();
		return predmet;
	}

	public boolean postojiLiProfesor() {

		for (int i = 0; i < Skola.listaProfesora.size(); i++) {
			if (Skola.listaProfesora.get(i).getIme().equals(imeProfesora)) {
				if (Skola.listaProfesora.get(i).getPrezime().equals(prezimeProfesora)) {
					return true;

				}
			}
		}

		return false;
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

	public Predmet vratiPredmet() {

		for (int i = 0; i < Skola.listaPredmeta.size(); i++) {
			if (Skola.listaPredmeta.get(i).getImePredmeta().equals(imePredmeta)) {
				return Skola.listaPredmeta.get(i);
			}
		}

		Predmet predmet = new Predmet();
		return predmet;
	}

	public boolean postojiLiPredmet() {

		for (int i = 0; i < Skola.listaPredmeta.size(); i++) {
			if (Skola.listaPredmeta.get(i).getImePredmeta().equals(imePredmeta)) {
				return true;
			}
		}

		return false;
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

	public String getImeUcenika() {
		return imeUcenika;
	}

	public String getPrezimeUcenika() {
		return prezimeUcenika;
	}

	public String getImePredmeta() {
		return imePredmeta;
	}

	public boolean getMozeLiSeNapraviti() {
		return mozeLiSeNapraviti;
	}

	@Override
	public String toString() {
		return "Predmet [imeProfesora=" + imeProfesora + ", prezimeProfesora=" + prezimeProfesora
				+ ", listaUcenikaJednogPredmeta=" + listaUcenikaJednogPredmeta + "]";
	}


	
	
}
