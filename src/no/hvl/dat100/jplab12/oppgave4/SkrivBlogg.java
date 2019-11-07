package no.hvl.dat100.jplab12.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;

import no.hvl.dat100.jplab12.oppgave3.*;
import no.hvl.dat100.jplab12.common.TODO;

public class SkrivBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	public static boolean skriv(Blogg samling, String filnavn) throws NullPointerException {
		
		boolean skrives = false;
		filnavn = "blogg.dat";
			
		try {
			String tkst = samling.toString();
			PrintWriter writer = new PrintWriter(MAPPE + filnavn);
			writer.println(tkst);
			writer.close();
			skrives = true;
		} catch (FileNotFoundException e) {
			System.out.println("Finner ikke fil.");
		} catch (NullPointerException e) {
			
		}
		
		return skrives;
		
	}
}
