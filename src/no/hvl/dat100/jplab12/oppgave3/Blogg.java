package no.hvl.dat100.jplab12.oppgave3;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;
import no.hvl.dat100.jplab12.oppgave2.Bilde;
import no.hvl.dat100.jplab12.oppgave2.Tekst;

public class Blogg {

	// TODO: objektvariable 

	private Innlegg[] innleggtabell;
	private int nesteLedig;
	
	
	public Blogg() {
		innleggtabell = new Innlegg[20];
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteLedig = 0;
	}

	public int getAntall() {
		if(nesteLedig == 0) {
			return 0;
		}
		return innleggtabell[nesteLedig-1].getId();	
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		int p = -1;
		int i = 0;
		while (i<nesteLedig&&p==-1) {
			if(innleggtabell[i].erLik(innlegg)) {
				p = i;
			}
			i++;
		}
		return p;
	}

	public boolean finnes(Innlegg innlegg) {
		boolean finn;
		int pos = finnInnlegg(innlegg);
		
		if(pos==-1) {
			finn = false;
		} else {
			finn = true;
		}
		
		return finn;
	}

	public boolean ledigPlass() {
		if(innleggtabell.length > getAntall()) {
			return true;
		}
		return false;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		int p = finnInnlegg(innlegg);
		
		if(p == -1) {
			innleggtabell[nesteLedig] = innlegg;
			nesteLedig++;
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		String tkst = "";
		for(int i = 0; i < nesteLedig; i++) {
			tkst += innleggtabell[i];
		}

		return getAntall() + "\n" + tkst;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] ny = new Innlegg[innleggtabell.length * 2];
		for(int i = 0; i < nesteLedig; i++) {
			ny[i] = innleggtabell[i];
		}
		innleggtabell = ny;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		int i = finnInnlegg(innlegg);
		
		if(i == -1) {
			if(nesteLedig == innleggtabell.length) {
				utvid();
				return true;
			}
		}
		return false;
	}
	
	public void slett(Innlegg innlegg) {
		int i = finnInnlegg(innlegg);
		if(i>=0) {
			nesteLedig--;
			innleggtabell[nesteLedig] = null;
		}
	}
	
	public int[] search(String keyword) {
		Innlegg[] samling = getSamling();
		int[] tab = null;
		String str;
		int p = 0;
		Tekst[] t = new Tekst[innleggtabell.length];
		
		for(int i = 0; i < samling.length; i++) {
			str = t[i].getTekst();
			if(str.contains(keyword)) {
				tab[p] = t[i].getId();
				p++;
			}
		}
		
		return tab;
	}
}