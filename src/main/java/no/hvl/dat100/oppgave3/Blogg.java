package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggTabell;
	private int nesteLedig;

	public Blogg() {
		innleggTabell = new Innlegg[20];
		nesteLedig = 0;
	}

	public Blogg(int lengde) {
		innleggTabell = new Innlegg[lengde];
		nesteLedig = 0;
	}

	public int getAntall() {
		return nesteLedig;
	}
	
	public Innlegg[] getSamling() {
		return this.innleggTabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		
		for(int i = 0; i < innleggTabell.length; i++){
			if (innleggTabell[i] != null && innleggTabell[i].erLik(innlegg)) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		for(Innlegg a : innleggTabell){
			if (a != null && a.erLik(innlegg)) {
				return true;
			}
		}
		return false;
	}

	public boolean ledigPlass() {
		return nesteLedig < innleggTabell.length;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		
		if (!finnes(innlegg) && ledigPlass()) {
			innleggTabell[nesteLedig] = innlegg;
			nesteLedig++;
			return true;
		}

		return false;
	}
	
	public String toString() {
		String resultat = nesteLedig + "\n";

		for (int i = 0; i < nesteLedig; i++) {
			resultat += innleggTabell[i].toString() + "\n";
		}

		return resultat;

	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] nyInnleggTabell = new Innlegg[(innleggTabell.length) * 2];

		for (int i = 0; i < innleggTabell.length; i++) {
			nyInnleggTabell[i] = innleggTabell[i];
		}

		innleggTabell = nyInnleggTabell;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		
		if (finnes(innlegg)) {
			return false;
		}

		if (!ledigPlass()) {
			utvid();
		}

		innleggTabell[nesteLedig] = innlegg;
		nesteLedig++;

		return true;
	}
	
	public boolean slett(Innlegg innlegg) {
		
		int indeks = finnInnlegg(innlegg);

		if (indeks == -1) {
			return false;
		}

		for (int i = indeks; i < nesteLedig - 1; i++) {
			innleggTabell[i] = innleggTabell[i + 1];
		}

		nesteLedig--;
		innleggTabell[nesteLedig] = null;

		return true;
	}
	
	public int[] search(String user, String ord) {
	
		int[] sokeTabell = new int[nesteLedig];
		int antallTreff = 0;

		for (int i = 0; i < nesteLedig; i++){

			if (innleggTabell[i].toString().contains(ord)) {
				sokeTabell[antallTreff] = innleggTabell[i].getId();
				antallTreff++;
			}
		}

		int[] resultat = new int[antallTreff];

		for (int i = 0; i < antallTreff; i++) {
			resultat[i] = sokeTabell[i];
		}

		return resultat;
	}
}