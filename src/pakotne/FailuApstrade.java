package pakotne;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FailuApstrade {


	public static void saglabat(String teksts) {
		try {
			FileWriter fw = new FileWriter("Atzimes.txt", false);
			BufferedWriter bw = new BufferedWriter(fw);
		
			bw.write(teksts);
		
			bw.close();
			JOptionPane.showMessageDialog(null, "Fails veiksmīgi saglabāts", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public static void nolasit() {
		
	}
}
