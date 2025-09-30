package pakotne;

import javax.swing.JOptionPane;

public class Izvelne {

	public static void main(String[] args) {
		
		String izvele;
		String[] darbibuSaraksts = {"Ievadīt studentus", "Ievadīt vērtēšanas kritērijus", "Aprēķināt atzīmes", "Apskatīt failu", "Apturēt"};
		do {
			
			izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies operāciju", "Izvēlne", JOptionPane.QUESTION_MESSAGE, null, darbibuSaraksts, darbibuSaraksts[0]);
			
			if(izvele == null)
				izvele = "Apturēt";
			
			switch(izvele) {
			case "Ievadīt studentus":
				GalvenaKlase.ievadiStudentus();
				break;
			}
			
		}while(!izvele.equals("Apturēt") );
	}

}
