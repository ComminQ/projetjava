package net.stri.fdjava.utils;

import java.util.Scanner;

public final class Console {
	
	private static final Scanner scanner = new Scanner(System.in);

	/**
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param text
	 * @date 16/04/2021
	 */
	public static void println(String text) {
		System.out.println(Colour.transform(text));
	}
	
	/**
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param row
	 * @param col
	 * @date 16/04/2021
	 */
	public static void positionCursor(int row, int col) {
		char escCode = 0x1B;
		System.out.print(String.format("%c[%d;%df", escCode, row, col));
	}
	
	public static void vider() {
		demanderChaine();
	}
	
	/**
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @return
	 * @date 16/04/2021
	 */
	public static int demanderEntier() {
		int line = scanner.nextInt();
		return line;
	}
	
	/**
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @return
	 * @date 16/04/2021
	 */
	public static String demanderChaine() {
		String line = scanner.nextLine();
		return line;
	}

}
