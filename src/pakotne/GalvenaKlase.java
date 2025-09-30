package pakotne;

import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class GalvenaKlase {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void ievadiStudentus() {
		String studSk;
		int studentuSkaits = 0;
		// Audzēkņu skaita ievade
		do {
			try {
				studSk = JOptionPane.showInputDialog(null, "Cik studentiem aprēķināsi gala vērtējumu?", "Jautājums", JOptionPane.QUESTION_MESSAGE);
				studentuSkaits = Integer.parseInt(studSk);
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}while(studentuSkaits<1);
		String[] studenti = new String[studentuSkaits];
		
		// Ievada audzēkņu vārdus, uzvārdus
		for(int i=0; i<studenti.length; i++) {
			do {
				studenti[i] = JOptionPane.showInputDialog(null, "Ievadi "+(i+1)+". studentu", "Jautājums", JOptionPane.QUESTION_MESSAGE).trim();
			} while(!studenti[i].matches("^[\\p{L} ]+$"));
		}
	
	}
	
	
	/*
	
	
	
	public static void izvelne() {
		int studSk, kritSk;
		
		DecimalFormat df = new DecimalFormat("0.#");
		
		
		
		
		// Vērtēšanas kritēriju skaita ievade
		do {
			System.out.println("Kāds būs kritēriju skaits?");
			while(!scan.hasNextInt()) {
				System.out.println("Kāds būs kritēriju skaits?");
				scan.next();
			}
			kritSk = scan.nextInt();
		}while(kritSk<1);
		String[] kriteriji = new String[kritSk];
		int[] kriterijaSvars = new int[kritSk];
		int[][] kriterijaVertejums = new int[studSk][kritSk];
		double[] semestraVertejums = new double[studSk];
		
		scan.nextLine();
		
		
		
		// Definē kritērijus
		int maxSvars = 100, sk = 1;
		double atlSvars;
		for(int i=0; i<kriteriji.length; i++) {
			do {
				System.out.println("Ievadi "+(i+1)+". kritēriju");
				kriteriji[i] = scan.nextLine().trim();
			} while(!kriteriji[i].matches("^[\\p{L} ]+$"));
			
			// Norāda katra kritērija svaru
			do {
				System.out.println("Ievadi "+(i+1)+". kritērija svaru (max: "+maxSvars+")");
				while(!scan.hasNextInt()) {
					System.out.println("Ievadi "+(i+1)+". kritērija svaru");
					scan.next();
				}
				kriterijaSvars[i] = scan.nextInt();
				/* Minimālā KATRA ATLIKUŠĀ kritērija svars ir 5
				 * kopējai svaru vērtībai ir jābūt 100 (ne mazāk, ne vairāk)
				*/
	/*
				atlSvars = (maxSvars - kriterijaSvars[i]) / (double)(kriteriji.length - sk);
			} while(kriterijaSvars[i]>maxSvars || kriterijaSvars[i]<5 || 
				  (i != kriteriji.length-1 && kriterijaSvars[i] == maxSvars) ||
				  (i == kriteriji.length-1 && (maxSvars - kriterijaSvars[i])  > 0) 
				  || atlSvars < 5);
			maxSvars -= kriterijaSvars[i];
			sk++;
			scan.nextLine();
		}
		
		// Norāda vērtējumu kādu ieguvis katrs audzēknis par katru kritēriju
		for(int i=0; i<kriterijaVertejums.length; i++) {
			for(int j=0; j<kriterijaVertejums[i].length; j++) {
				do {
					System.out.println("Ievadi "+studenti[i]+" vērtējumu par kritēriju "+kriteriji[j]);
					while(!scan.hasNextInt()) {
						System.out.println("Ievadi "+studenti[i]+" vērtējumu par kritēriju "+kriteriji[j]);
						scan.next();
					}
					kriterijaVertejums[i][j] = scan.nextInt();
				}while(kriterijaVertejums[i][j]<0 || kriterijaVertejums[i][j]>10);
			}
		}
		
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