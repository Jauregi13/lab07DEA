package bzb;

import java.util.Scanner;


public class BZB {

	private BZBAdabegia erroa;

	/**
	 * BZB klasearen eraikitzailea: zuhaitz hutsa sortzen du.
	 * 
	 */
	public BZB() {
		this.erroa = null;
	}

	/**
	 * BZB klasearen eraikitzailea: fitxategiko edukietatik zuhaitza sortzen du.
	 * Suposatzen da fitxategiko elementuak ondo kokatuta daudela, eta BZBen
	 * propietatea betetzen dutela
	 * 
	 */
	public BZB(Scanner source) throws Exception {
		String token = source.next();
		if (token.equals("*"))
			this.erroa = null;
		else if (token.equals("["))
			this.erroa = new BZBAdabegia(source);
		else
			throw new Exception(String.format("Unexpected token when reading " + "binary tree: %s", token));

	}

	/**
	 * Zuhaitz bitarra hutsa den ala ez itzultzen du.
	 * 
	 * @return true, zuhaitz bitarra hutsa bada; false, bestela.
	 */
	public boolean hutsaDa() {
		return (erroa == null);
	}

	/**
	 * Zuhaitz bitarra hostoa den ala ez itzultzen du.
	 * 
	 * @return true, zuhaitz bitarra hostoa bada; false, bestela.
	 */
	public boolean hostoaDa() {
		return (erroa.ezkerra == null && erroa.eskuina == null);
	}

	/**
	 * Erroa izeneko adabegia zuhaitz bitarraren erroan jartzen du.
	 * 
	 * @param erroa zuhaitz bitarraren erroan jarriko den adabegia.
	 * @return eguneratutako zuhaitza itzultzen du.
	 */
	public BZB errotu(BZBAdabegia erroa) {
		this.erroa = erroa;
		return this;
	}

	
	/**
	 * elem elementua BZBan eransten du, BZBaren osaera errespetatuta
	 * 
	 * @param elem BZBan erantsiko den elementua
	 * 
	 */
	public void erantsiElementua(int elem) {
		if (this.hutsaDa()) {
			this.erroa = new BZBAdabegia(elem);
		} else
			this.erroa.erantsiElementua(elem);
	}
	
	
	/**
	 * Zuhaitz bitarrean elem elementua aurkitu den ala ez itzultzen du.
	 * 
	 * @param elem zuhaitz bitarrean bilatuko den elementua.
	 * @return true, elem zuhaitz bitarrean badago; false, bestela.
	 */
	public boolean baDauka(int elem) {
		if (this.hutsaDa())
			return false;
		else
			return this.erroa.baDauka(elem);
	}


	/**
	 * Bilaketa-zuhaitz bitarra orekatu den ala ez itzultzen du.
	 * 
	 * @return true, zuhaitz bitarra orekatuta badago; false, bestela.
	 */
	public boolean orekatuaDa() {

		OrekaSakonera emaitza;
		
		if(this.hutsaDa()) {
			return true;
		}
		else {
			emaitza = this.erroa.orekatuaDaOrok();
			return emaitza.getOreka();
		}
		
	}
	

	/**
	 * Zuhaitz bitarrak zenbat barne-adabegi ditu ondorengo guztiak baino hertsiki
	 * handiagoak direnak.
	 * 
	 * @return zenbat barne-adabegi ditu ondorengo guztiak baino hertsiki handiagoak
	 *         direnak.
	 */
	public int zenbatHandiagoaIzan() {

		// KODEA OSATU
		return -1;
	}

	/**
	 * x baino handiagoa ez den BZBko balio handiena itzultzen du.
	 * 
	 * @param x sapaia markatzen duen zenbakia
	 * @return x baino handiagoa ez den BZBko balio handiena itzultzen du.
	 * @exception x baino txikiagoa den zenbakirik ez badauka BZBak, MIN_VALUE
	 *              itzultzen du
	 */
	public int sapaia(int x) {

		// KODEA OSATU
		return -1;
	}


	/**
	 * Elementurik txikiena ezabatzen du BZBtik.
	 * 
	 * @return ezabatu den elementu txikiena
	 * BZBa hutsa bada, Integer.MAX_VALUE itzultzen du.
	 */
	public Integer ezabatuMin() {

		// KODEA OSATU
		return -1;
	}

	
	/**
	 * java.lang.Object-etik heredatutako metodoaren gainidazketa.
	 * 
	 * @return zuhaitzaren edukia String formatuan.
	 */
	@Override
	public String toString() {
		if (this.hutsaDa())
			return " * ";
		return this.erroa.toString();
	}
}