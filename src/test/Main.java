package test;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main implements Serializable {

	public static void main(String[] args)
			throws EOFException, IOException, ClassNotFoundException, FileNotFoundException {

		String tacnaSifra = "";
		Scanner unos = new Scanner(System.in);
		System.out.println("Unesite sifru");
		String sifra = unos.next();

		try {
			File file = new File("sifra/sifra.txt");
			Scanner s = new Scanner(file);
			tacnaSifra = s.next();
			s.close();
		} catch (Exception e) {
		}

		if (sifra.equals(tacnaSifra)) {

			try {
				FileInputStream fi = new FileInputStream("predmeti.txt");
				ObjectInputStream input = new ObjectInputStream(fi);

				try {
					while (true) {

						Predmet predmet = (Predmet) input.readObject();
						Skola.listaPredmeta.add(predmet);
						System.out.println(Skola.listaPredmeta.toString());
					}
				} catch (EOFException e) {
				}
			} catch (EOFException e1) {

			}

			try {
				FileInputStream fi = new FileInputStream("profesori.txt");
				ObjectInputStream input = new ObjectInputStream(fi);

				try {
					while (true) {

						Profesor profesor = (Profesor) input.readObject();
						Skola.listaProfesora.add(profesor);
						System.out.println(Skola.listaProfesora.toString());
					}
				} catch (EOFException e) {
				}
			} catch (EOFException e1) {

			}

			try {
				FileInputStream fi = new FileInputStream("ucenici.txt");
				ObjectInputStream input = new ObjectInputStream(fi);

				try {
					while (true) {

						Ucenik ucenik = (Ucenik) input.readObject();
						Skola.listaUcenika.add(ucenik);
						System.out.println(Skola.listaUcenika.toString());
					}
				} catch (EOFException e) {
				}
			} catch (EOFException e1) {

			}

			try {
				FileInputStream fi = new FileInputStream("dodatniPredmeti.txt");
				ObjectInputStream input = new ObjectInputStream(fi);

				try {
					while (true) {

						DodatniPredmet dodatniPredmet = (DodatniPredmet) input.readObject();
						Skola.listaDodatnihPredmeta.add(dodatniPredmet);
						System.out.println(Skola.listaDodatnihPredmeta.toString());
					}
				} catch (EOFException e) {
				}
			} catch (EOFException e1) {

			}

			System.out.println("Unesite" + "\n1 ako hocete kreirati profesora," + "\n2 ako hocete kreirati ucenika,"
					+ "\n3 ako hocete kreirati predmet," + "\n4 ako hocete dodati ucenika,"
					+ "\n5 ako hocete odrediti datum takmicenja,"
					+ "\nbilo koji drugi broj ako hocete zavrsiti program");

			int broj = 0;

			try {

				broj = unos.nextInt();

				while (true) {

					if (broj == 1) {

						System.out.println("\nUnesite ime profesora");
						unos.nextLine();
						String ime = unos.nextLine();
						System.out.println("\nUnesite prezime profesora");
						String prezime = unos.nextLine();

						Profesor profesor = new Profesor(ime, prezime);

						if (profesor.getMozeLiSeNapraviti() == true) {
							Skola.listaProfesora.add(profesor);
						}

						System.out.println(Skola.listaProfesora);

					}

					else if (broj == 2) {

						System.out.println("\nUnesite ime ucenika");

						String ime = unos.next();
						System.out.println("\nUnesite prezime");

						String prezime = unos.next();
						System.out.println("\nUnesite prosjek");
						double prosjek = unos.nextDouble();

						Ucenik ucenik = new Ucenik(ime, prezime, prosjek);

						if (ucenik.getMozeLiSeNapraviti() == true) {
							Skola.listaUcenika.add(ucenik);
							System.out.println("Uspjesno ste napravili ucenika");
						}

						System.out.println(Skola.listaUcenika);
					}

					else if (broj == 3) {
						System.out.println("Unesite broj 1 ako hocete krerirati predemet"
								+ "\nbilo koji drugi ako hocete kreirti dodatni predmet");
						int odaberi = unos.nextInt();
						if (odaberi == 1) {

							System.out.println("\nUnesite ime predmeta");
							unos.nextLine();
							String imePredmeta = unos.nextLine();
							System.out.println("Unesite ime profesora koji predaje");
							String imeProfesora = unos.nextLine();
							System.out.println("Unesite prezime profesora koji predaje");
							String prezimeProfesora = unos.nextLine();

							Predmet predmet = new Predmet(imePredmeta, imeProfesora, prezimeProfesora);

							if (predmet.getMozeLiSeNapraviti() == true) {
								Skola.listaPredmeta.add(predmet);
								System.out.println("Predmet je napravljen");
							}
						}

						else {
							System.out.println("\nUnesite ime predmeta");
							unos.nextLine();
							String imePredmeta = unos.nextLine();

							DodatniPredmet dodatniPredmet = new DodatniPredmet(imePredmeta);
							if (dodatniPredmet.getValidacija() == true) {
								System.out.println("Kreirali ste predmet");
								Skola.listaDodatnihPredmeta.add(dodatniPredmet);

							}
						}

					}

					else if (broj == 4) {

						System.out.println(
								"Unesite 1 ako hocete dodati ucenika na obicni predmet a bilo koji drugi broj ako hocete dodati ucenika na dodatni predmet");
						int unos3 = unos.nextInt();
						if (unos3 == 1) {
							System.out.println("Unesite ime ucenika za kojeg zelite da pohadja ovaj predmet");
							unos.nextLine();
							String imeUcenika = unos.nextLine();
							System.out.println("Unesite prezime ucenika za kojeg zelite da pohadja ovaj predmet");
							String prezimeUcenika = unos.nextLine();
							System.out.println("Unesite predmet");
							String predmet = unos.nextLine();
							System.out.println("Unesite bilo koji broj");
							int broj2 = unos.nextInt();

							Predmet dodajUcenika = new Predmet(imeUcenika, prezimeUcenika, predmet, broj2);

						} else {
							System.out.println("Unesite ime ucenika za kojeg zelite da pohadja ovaj predmet");
							unos.nextLine();
							String imeUcenika = unos.nextLine();
							System.out.println("Unesite prezime ucenika za kojeg zelite da pohadja ovaj predmet");
							String prezimeUcenika = unos.nextLine();
							System.out.println("Unesite dodatni predmet");
							String predmet = unos.nextLine();
							System.out.println("Unesite bilo koji broj");
							int broj2 = unos.nextInt();

							DodatniPredmet dodajUcenika = new DodatniPredmet(imeUcenika, prezimeUcenika, predmet,
									broj2);

						}

					}

					else if (broj == 5) {

						System.out.println("Unesite predmet");
						unos.nextLine();
						String predmet = unos.nextLine();

						java.util.Date date = new java.util.Date();
						System.out.println("Unesite dan");
						date.setDate(unos.nextInt());
						System.out.println("Unesite mjesec");
						date.setMonth(unos.nextInt());

						DodatniPredmet unesiDatum = new DodatniPredmet(predmet, date);

					}

					else
						break;

					System.out.println("Unesite" + "\n1 ako hocete kreirati profesora,"
							+ "\n2 ako hocete kreirati ucenika," + "\n3 ako hocete kreirati predmet,"
							+ "\n4 ako hocete dodati ucenika," + "\n5 ako hocete odrediti datum takmicenja,"
							+ "\nbilo koji drugi broj ako hocete zavrsiti program");

					broj = unos.nextInt();

				}

			} catch (InputMismatchException e) {
				System.out.println("Trebate unjeti broj");
			}

			FileOutputStream fo = new FileOutputStream("predmeti.txt");
			ObjectOutputStream output = new ObjectOutputStream(fo);

			for (Predmet predmet : Skola.listaPredmeta) {
				output.writeObject(predmet);
			}
			output.close();
			fo.close();

			for (Predmet predmet : Skola.listaPredmeta) {
				System.out.println(predmet.toString());
			}

			FileOutputStream foo = new FileOutputStream("profesori.txt");
			ObjectOutputStream outputt = new ObjectOutputStream(foo);

			for (Profesor profesor : Skola.listaProfesora) {
				outputt.writeObject(profesor);
			}
			outputt.close();
			foo.close();

			for (Profesor profesor : Skola.listaProfesora) {
				System.out.println(profesor.toString());
			}

			FileOutputStream fooo = new FileOutputStream("ucenici.txt");
			ObjectOutputStream outputtt = new ObjectOutputStream(fooo);

			for (Ucenik ucenik : Skola.listaUcenika) {
				outputtt.writeObject(ucenik);
			}
			outputtt.close();
			fooo.close();

			for (Ucenik ucenik : Skola.listaUcenika) {
				System.out.println(ucenik.toString());
			}

			FileOutputStream foooo = new FileOutputStream("dodatniPredmeti.txt");
			ObjectOutputStream outputttt = new ObjectOutputStream(foooo);

			for (DodatniPredmet dodatniPredmet : Skola.listaDodatnihPredmeta) {
				outputttt.writeObject(dodatniPredmet);
			}
			outputttt.close();
			foooo.close();

			for (DodatniPredmet dodatniPredmet : Skola.listaDodatnihPredmeta) {
				System.out.println(dodatniPredmet.toString());
			}

		} else
			System.out.println("Pogresna sifra");
	}

}
