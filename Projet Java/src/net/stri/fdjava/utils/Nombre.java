package net.stri.fdjava.utils;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * 
 * @author Fabien CAYRE (Computer)
 *
 * @date 13/05/2021
 */
public final class Nombre {

	private static final DecimalFormat DEC = new DecimalFormat("##.##") ;
	
	/**
	 * Génère un nombre aléatoire
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param min borne minimale
	 * @param max borne maximale
	 * @return le nombre aléatoire
	 * @date 13/05/2021
	 */
	public static int nombreAleatoire(int min, int max) {
		Random r = new Random();
		return r.nextInt(max-min) + min;
	}
	
	/**
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param val
	 * @return
	 * @date 17/05/2021
	 */
	public static String format(double val) {
		return DEC.format(val);
	}
	
}
