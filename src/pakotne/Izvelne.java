package pakotne;

import javax.swing.JOptionPane;

public class Izvelne {

	public static void main(String[] args) {
		
		String izvele;
		String[] darbibuSaraksts = {"Ievadīt studentus", "Ievadīt vērtēšanas kritērijus", "Ievadīt kritēriju svaru", "Ievadīt vērtējumu", "Labot kritēriju", "Labot svaru", "Ievadīt iegūto vērtējumu", "Labot iegūto vērtējumu", "Apskatīt failu", "Apturēt"};
		do {
			
			izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies operāciju", "Izvēlne", JOptionPane.QUESTION_MESSAGE, null, darbibuSaraksts, darbibuSaraksts[0]);
			
			if(izvele == null)
				izvele = "Apturēt";
			
			switch(izvele) {
			case "Ievadīt studentus":
				GalvenaKlase.ievadiStudentus();
				break;
				
			case "Ievadīt vērtēšanas kritērijus":
				if(GalvenaKlase.studentuSkaits < 1) {
					JOptionPane.showMessageDialog(null, "Lūdzu ievadiet vispirms datus par studentiem", "Paziņojums", JOptionPane.WARNING_MESSAGE);
					break;
				}
				GalvenaKlase.ievaditKriterijus();
				break;
				
			case "Ievadīt kritēriju svaru":
				if(GalvenaKlase.kriteriji == null) {
					JOptionPane.showMessageDialog(null, "Lūdzu ievadiet vispirms datus par Kritērijiem", "Paziņojums", JOptionPane.WARNING_MESSAGE);
					break;
				}
				GalvenaKlase.ievaditKritSvaru();
			}
			
		}while(!izvele.equals("Apturēt") );
	}

}
