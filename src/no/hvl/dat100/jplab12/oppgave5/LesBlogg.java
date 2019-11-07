package no.hvl.dat100.jplab12.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;
import no.hvl.dat100.jplab12.oppgave2.*;
import no.hvl.dat100.jplab12.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String filnavn) throws IOException, NumberFormatException {
		Blogg samling = null;

		FileReader fil = null;
		BufferedReader br = null;

		try {
			fil = new FileReader(MAPPE + filnavn);
			br = new BufferedReader(fil);
			
			int antall = Integer.parseInt(br.readLine());
			samling = new Blogg(antall);
			
			String bruker, dato, tekst, url, type;
			int id, likes;
			
			for(int i = 0; i < antall; i++) {
				type = br.readLine();
				id = Integer.parseInt(br.readLine());
				bruker = br.readLine();
				dato = br.readLine();
				likes = Integer.parseInt(br.readLine());
				tekst = br.readLine();
				switch (type) {
				case "TEKST":
					samling.leggTil(new Tekst(id, bruker, dato, likes, tekst));
					break;
				case "BILDE":
					url = br.readLine();
					samling.leggTil(new Bilde(id, bruker, dato, likes, tekst, url));
					break;
				}
			}			
		} catch (FileNotFoundException e) {
			System.out.println("Finner ikke fil.");
		}
		return samling;

	}
}
