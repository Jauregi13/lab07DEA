package bzb;

import java.io.File;
import java.util.Scanner;


public class Probak {
	
	public static void main(String[] args) throws Exception {
		Scanner input;
	
		System.out.println("ZUHAITZ OREKATUEN PROBAK:");
		for (int i = 0; i <= 6; i++) {
			input = new Scanner(new File("datuak/zuhaitza"+i+".txt"));			
			BZB zuhaitza = new BZB(input);		

			System.out.println("Zuhaitza: " + zuhaitza);
			System.out.println("Zuhaitz hori " + ((zuhaitza.orekatuaDa())?"BAI":"EZ") + " da orekatua");
			System.out.println();
			input.close();
		}

		
		System.out.println("ZENBAT HANDIAGOAIZAN PROBAK:");
		for (int i = 0; i <= 6; i++) {
			input = new Scanner(new File("datuak/zuhaitza"+i+".txt"));			
			BZB zuhaitza = new BZB(input);
			int emaitza = zuhaitza.zenbatHandiagoaIzan();

			System.out.println("Zuhaitza: " + zuhaitza);		
			System.out.println("Zuhaitzak " + emaitza + " barne-adabegi ditu ondorengo guztiak baino hertsiki handiagoak direnak");
			System.out.println();
			input.close();			
		}
		
		System.out.println("SAPAIAREN PROBAK:");
		int x = 30;
		for (int i = 0; i <= 6; i++) {
			input = new Scanner(new File("datuak/zuhaitza"+i+".txt"));			
			BZB zuhaitza = new BZB(input);
			int emaitza = zuhaitza.sapaia(x);	
			System.out.println("Zuhaitza: " + zuhaitza);	
			System.out.println(x + " zenbakiaren sapaia zuhaitzean: " + emaitza);
			System.out.println();
			input.close();			
		}
		
		System.out.println("EZABATUMIN PROBAK:");
		for (int i = 0; i <= 6; i++) {
			input = new Scanner(new File("datuak/zuhaitza"+i+".txt"));			
			BZB zuhaitza = new BZB(input);
			System.out.println("Zuhaitza: " + zuhaitza);	
			int emaitza = zuhaitza.ezabatuMin();	
			System.out.println("Zuhaitzaren elementu minimoa " + emaitza +" zen, eta EZABATU DA:");			
			System.out.println("Zuhaitza: " + zuhaitza);	
			System.out.println();
			input.close();			
		}	
	}
}