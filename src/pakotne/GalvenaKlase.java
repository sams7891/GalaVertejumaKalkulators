package pakotne;

import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class GalvenaKlase {
	
	static Scanner scan = new Scanner(System.in);
	
	
	static String[] studenti;
	static String[] kriteriji;

	static int studentuSkaits = 0;

	
	
	public static void ievadiStudentus() {
		String studSk;
		// Audzēkņu skaita ievade
		do {
			try {
				studSk = JOptionPane.showInputDialog(null, "Cik studentiem aprēķināsi gala vērtējumu?", "Jautājums", JOptionPane.QUESTION_MESSAGE);
				studentuSkaits = Integer.parseInt(studSk);
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}while(studentuSkaits<1);
		studenti = new String[studentuSkaits];
		
		// Ievada audzēkņu vārdus, uzvārdus
		for(int i=0; i<studenti.length; i++) {
			do {
				studenti[i] = JOptionPane.showInputDialog(null, "Ievadi "+(i+1)+". studentu", "Jautājums", JOptionPane.QUESTION_MESSAGE).trim();
			} while(!studenti[i].matches("^[\\p{L} ]+$"));
		}
	
	}
	
	public static void ievaditKriterijus() {
		// Vērtēšanas kritēriju skaita ievade
		String kritSkString;
		int kritSk = 0;
		do {
			try {
				kritSkString = JOptionPane.showInputDialog(null, "Kāds būs kritēriju skaits?", "Jautājums", JOptionPane.QUESTION_MESSAGE);
			
				kritSk = Integer.parseInt(kritSkString);
				
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}while(kritSk<1);
		
		
		kriteriji = new String[kritSk];
		
		
		
		
		// Definē kritērijus
		
		for(int i=0; i<kriteriji.length; i++) {
			do {
				kriteriji[i] = JOptionPane.showInputDialog(null, "Ievadi "+(i+1)+". kritēriju", "Jautājums", JOptionPane.QUESTION_MESSAGE).trim();
			} while(!kriteriji[i].matches("^[\\p{L} ]+$"));
			
		}
			
		}
		
	public static void ievaditKritSvaru() {
		int maxSvars = 100, sk = 1;
		double atlSvars;
		int[] kriterijaSvars = new int[kriteriji.length];
		String pagVertiba;
		
		// Norāda katra kritērija svaru
		for(int i = 0; i < kriteriji.length; i++) {
		do {
			try {
			 pagVertiba = JOptionPane.showInputDialog(null, "Ievadi "+(i+1)+". kritērija svaru (max: "+maxSvars+")", "Jautājums", JOptionPane.QUESTION_MESSAGE);
			 kriterijaSvars[i] = Integer.parseInt(pagVertiba);
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, e);
			}
			/* Minimālā KATRA ATLIKUŠĀ kritērija svars ir 5
			 * kopējai svaru vērtībai ir jābūt 100 (ne mazāk, ne vairāk)
			*/

			atlSvars = (maxSvars - kriterijaSvars[i]) / (double)(kriteriji.length - sk);
		} while(kriterijaSvars[i]>maxSvars || kriterijaSvars[i]<5 || 
			  (i != kriteriji.length-1 && kriterijaSvars[i] == maxSvars) ||
			  (i == kriteriji.length-1 && (maxSvars - kriterijaSvars[i])  > 0) 
			  || atlSvars < 5);
		maxSvars -= kriterijaSvars[i];
		sk++;
		}
	}

	public static void ievaditAtzimes() {
		
		int[][] kriterijaVertejums = new int[studentuSkaits][kriteriji.length];
		String pagVertiba;
		for(int i=0; i<kriteriji.length; i++) {
			for(int j=0; j<kriterijaVertejums[i].length; j++) {
				do {
					try {
					pagVertiba = JOptionPane.showInputDialog(null, "Ievadi "+studenti[i]+" vērtējumu par kritēriju "+kriteriji[j], "jautājums", JOptionPane.QUESTION_MESSAGE);
					
					kriterijaVertejums[i][j] = Integer.parseInt(pagVertiba);
					}catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}while(kriterijaVertejums[i][j]<0 || kriterijaVertejums[i][j]>10);
			}
		}
	}
	
	
	/*
			double[] semestraVertejums = new double[studentuSkaits];

	
	
	public static void izvelne() {
		int studSk, kritSk;
		
		DecimalFormat df = new DecimalFormat("0.#");
		
		
		
		
		
		
		// Norāda vērtējumu kādu ieguvis katrs audzēknis par katru kritēriju
		
		
		// Gala vērtējuma aprēķināšana
		double rezultats;
		for(int i=0; i<studenti.length; i++) {
			rezultats=0;
			for(int j=0; j<kriteriji.length; j++) {
				rezultats += ((double) kriterijaSvars[j]/100)*kriterijaVertejums[i][j];
			}
			semestraVertejums[i] = rezultats;
		}
		
		// Gala vērtējumu izvadīšana
		
		String teksts = "";
		
		for(int i=0; i<studenti.length; i++) {	
			for(int j=0; j<kriteriji.length; j++) {
				teksts += "Studenta "+studenti[i]+" vērtējums par kritēriju "+kriteriji[j]+" ir "+kriterijaVertejums[i][j]+", kura svars ir "+kriterijaSvars[j];
			}
			teksts += "Semestra vērtējums ir "+df.format(semestraVertejums[i])+" balles"
					+ "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n";
			
		}
		System.out.println(teksts);
		System.out.println("Vai saglabāt teksta failā? y/n");
		
		char izv;
		
		do {
			izv = scan.next().charAt(0);
		}while(izv == 'y' || izv == 'n');
		scan.close();
	}
	*/
}