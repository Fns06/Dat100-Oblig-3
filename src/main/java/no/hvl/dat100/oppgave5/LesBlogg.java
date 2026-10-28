package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.*;
import no.hvl.dat100.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {

		try {

			File fil = new File(mappe, filnavn);
			Scanner scanner = new Scanner(fil);

			int antallInnlegg;

			String forsteOrd = scanner.nextLine();
			antallInnlegg = Integer.parseInt(forsteOrd);

			Blogg samling = new Blogg(antallInnlegg);

			String typeInnlegg;
			int ID;
			String brukernavn;
			String dato;
			int likes;
			String tekst;
			String url;

			for (int i = 0; i < antallInnlegg; i++) {
				typeInnlegg = scanner.nextLine();

				if (typeInnlegg.equals(TEKST)) {

					ID = Integer.parseInt(scanner.nextLine());
					brukernavn = scanner.nextLine();
					dato = scanner.nextLine();
					likes = Integer.parseInt(scanner.nextLine());
					tekst = scanner.nextLine();

					Tekst tekst1 = new Tekst(ID, brukernavn, dato, likes, tekst);

					samling.leggTil(tekst1);
				}

				else if (typeInnlegg.equals(BILDE)) {

					ID = Integer.parseInt(scanner.nextLine());
					brukernavn = scanner.nextLine();
					dato = scanner.nextLine();
					likes = Integer.parseInt(scanner.nextLine());
					tekst = scanner.nextLine();
					url = scanner.nextLine();

					Bilde bilde1 = new Bilde(ID, brukernavn, dato, likes, tekst, url);

					samling.leggTil(bilde1);
				}
			}

			scanner.close();
			
			return samling;

		}

		catch (FileNotFoundException e) {

			return null;
		}

	}
}
