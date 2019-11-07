package no.hvl.dat100.jplab12.oppgave6;

import no.hvl.dat100.jplab12.oppgave1.Innlegg;
import no.hvl.dat100.jplab12.oppgave3.Blogg;
import no.hvl.dat100.jplab12.common.TODO;

public class HtmlBlogg extends Blogg {

	public HtmlBlogg() {
		super();
	}
	
	private static String HTMLPREFIX = 
			"<html>\n\t<head>\n\t\t<title>DAT100 Blogg</title>\n\t</head>\n\t<body>\n";
	
	private static String HTMLPOSTFIX = 
			"\t</body>\n</html>";
	
	@Override
	public String toString() {
		Innlegg[] b = super.getSamling();
		String html = "";
		int i = 1;
		for(Innlegg o : b) {
			
			html += o.toHTML();
			
			if(i==super.getAntall()) {
				break;
			}

			i++;
		}
		
		return HTMLPREFIX + html + HTMLPOSTFIX;
	}
}
