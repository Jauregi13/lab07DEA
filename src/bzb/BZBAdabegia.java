package bzb;

import java.util.Scanner;
import java.lang.Math;

public class BZBAdabegia {

	int info;
	BZBAdabegia ezkerra;
	BZBAdabegia eskuina;

	/**
	 * BZBAdabegia klasearen eraikitzailea.
	 * 
	 * @param elem adabegiko elementua, int motakoa.
	 */
	public BZBAdabegia(int elem) {
		info = elem;
		ezkerra = null;
		eskuina = null;
	}

	public BZBAdabegia(Scanner source) throws Exception {
		this.info = source.nextInt();
		String token = source.next();
		if (token.equals("]")) {
			this.ezkerra = null;
			this.eskuina = null;
		} else {
			if (token.equals("["))
				this.ezkerra = new BZBAdabegia(source);
			else if (token.equals("*"))
				this.ezkerra = null;
			else
				throw new Exception(String.format("Unexpected token when " + "reading binary tree: %s", token));
			token = source.next();
			if (token.equals("["))
				this.eskuina = new BZBAdabegia(source);
			else if (token.equals("*"))
				this.eskuina = null;
			else
				throw new Exception(String.format("Unexpected token when " + "reading binary tree: %s", token));
			token = source.next();
			if (!token.equals("]"))
				throw new Exception(String.format("Unexpected token when " + "reading binary tree: %s", token));
		}
	}
	

	/**
	 * Adabegiak ezkerreko umea baduen ala ez itzultzen du.
	 * 
	 * @return true, ezkerreko umea baldin badu; false, bestela.
	 */
	public boolean baduEzkerra() {
		return this.ezkerra != null;
	}

	/**
	 * Adabegiak eskuineko umea baduen ala ez itzultzen du.
	 * 
	 * @return true, eskuineko umea baldin badu; false, bestela.
	 */
	public boolean baduEskuina() {
		return this.eskuina != null;
	}

	/**
	 * Adabegia hostoa den ala ez itzultzen du.
	 * 
	 * @return true, hostoa bada; false, bestela.
	 */
	public boolean hostoaDa() {
		return !this.baduEzkerra() && !this.baduEskuina();
	}


	/**
	 * elem elementua BZBAdabegian eransten du, osaera errespetatuta
	 * 
	 * @param elem BZBAdabegian erantsiko den elementua
	 * 
	 */
	public void erantsiElementua(int elem) {
		if (this.info > elem) {
			if (this.baduEzkerra()) {
				ezkerra.erantsiElementua(elem);
			} else {
				this.ezkerra = new BZBAdabegia(elem);
			}
		} else { // this.indo <= elem
			if (this.baduEskuina()) {
				this.eskuina.erantsiElementua(elem);
			} else {
				this.eskuina = new BZBAdabegia(elem);
			}
		}
	}



	public boolean baDauka(int elem) {
		if (this.info == elem)
			return true;
		else if (this.info > elem) {
			if (this.baduEzkerra()) {
				return this.ezkerra.baDauka(elem);
			}
			return false;
		} else { // this.info < elem
			if (this.baduEskuina()) {
				return this.eskuina.baDauka(elem);
			}
			return false;
		}
	}

	public OrekaSakonera orekatuaDaOrok() {

		if(this.baduEzkerra()) {
			
			this.ezkerra.orekatuaDaOrok();
		}
		else if(this.baduEskuina()) {
			this.eskuina.orekatuaDaOrok();
		}
		
		return null;
	}

	public XXXX zenbatHandiagoaIzanOrok() {

		// KODEA OSATU

		return null;
	}

	public int sapaia(int x) {

		// KODEA OSATU
		return -1;
	}
	

	public EzabatuMinEmaitza ezabatuMin() {

		// KODEA OSATU
		return null;
	}

	@Override
	public String toString() {
		String emaitza = "[ " + this.info + " ";
		if (!this.hostoaDa()) {
			if (this.baduEzkerra())
				emaitza += this.ezkerra.toString();
			else
				emaitza += "* ";
			if (this.baduEskuina())
				emaitza += this.eskuina.toString();
			else
				emaitza += "* ";
		}
		emaitza += "] ";
		return emaitza;
	}
}
