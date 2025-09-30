package pakotne;

import javax.swing.JOptionPane;

public class Izvelne {

	public static void main(String[] args) {
		
		String izvele;
		String teksts = "";
		boolean ievadijastudentus = false, ievadijakriterijus = false, ievadijasvaru = false, ievadijavertejumu = false;
		String[] darbibuSaraksts = {"Ievadīt studentus", "Ievadīt vērtēšanas kritērijus", "Ievadīt kritēriju svaru", "Ievadīt vērtējumu", "Labot kritēriju", "Labot svaru", "Ievadīt iegūto vērtējumu", "Labot iegūto vērtējumu", "Aprēķināt gala vērtējumu", "Saglabāt failā", "Apskatīt failu", "Apturēt"};
		do {
			
			izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies operāciju", "Izvēlne", JOptionPane.QUESTION_MESSAGE, null, darbibuSaraksts, darbibuSaraksts[0]);
			
			if(izvele == null)
				izvele = "Apturēt";
			
			switch(izvele) {
			case "Ievadīt studentus":
				GalvenaKlase.ievadiStudentus();
				ievadijastudentus = true;
				break;
				
			case "Ievadīt vērtēšanas kritērijus":
				if(GalvenaKlase.studentuSkaits < 1) {
					JOptionPane.showMessageDialog(null, "Lūdzu ievadiet vispirms datus par studentiem", "Paziņojums", JOptionPane.WARNING_MESSAGE);
					break;
				}
				GalvenaKlase.ievaditKriterijus();
				ievadijakriterijus = true;
				break;
				
			case "Ievadīt kritēriju svaru":
				if(GalvenaKlase.kriteriji == null) {
					JOptionPane.showMessageDialog(null, "Lūdzu ievadiet vispirms datus par Kritērijiem", "Paziņojums", JOptionPane.WARNING_MESSAGE);
					break;
				}
				GalvenaKlase.ievaditKritSvaru();
				ievadijasvaru = true;
				break;
				
			case "Ievadīt vērtējumu":
				if(GalvenaKlase.studentuSkaits < 1 && GalvenaKlase.kriteriji == null) {
					JOptionPane.showMessageDialog(null, "Lūdzu ievadiet vispirms datus par studentiem un kritērijiem", "Paziņojums", JOptionPane.WARNING_MESSAGE);
					break;
				}
				
				GalvenaKlase.ievaditAtzimes();
				ievadijavertejumu = true;
				break;
				
			case "Aprēķināt gala vērtējumu":
				if(!(ievadijastudentus && ievadijakriterijus && ievadijasvaru && ievadijavertejumu)) {
					JOptionPane.showMessageDialog(null, "Lūdzu ievadiet vispirms datus par studentiem un kritērijiem un svariem un vērtējumiem", "Paziņojums", JOptionPane.WARNING_MESSAGE);
					break;
				}
				teksts = GalvenaKlase.aprekinatVertejumu();
				break;
				
			case "Labot kritēriju":
				if(!ievadijakriterijus) {
					JOptionPane.showMessageDialog(null, "Lūdzu ievadiet sākuma vērtību", "Paziņojums", JOptionPane.WARNING_MESSAGE);
					break;
				}
				GalvenaKlase.ievaditKriterijus();
				break;
				
			case "Labot svaru":
				if(!ievadijasvaru) {
					JOptionPane.showMessageDialog(null, "Lūdzu ievadiet sākuma vērtību", "Paziņojums", JOptionPane.WARNING_MESSAGE);
					break;
				}
				GalvenaKlase.ievaditKritSvaru();
				break;
				
			case "Labot iegūto vērtējumu":
				if(!ievadijavertejumu) {
					JOptionPane.showMessageDialog(null, "Lūdzu ievadiet sākuma vērtību", "Paziņojums", JOptionPane.WARNING_MESSAGE);
					break;
				}
				GalvenaKlase.ievaditAtzimes();
				break;
				
			case "Saglabāt failā":
				if(teksts.equals("")) {
					JOptionPane.showMessageDialog(null, "Nav ko saglabāt", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
				FailuApstrade.saglabat(teksts);
			}
			
		}while(!izvele.equals("Apturēt") );
	}

}
