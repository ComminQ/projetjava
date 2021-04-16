package net.stri.fdjava.utils;

import java.util.Scanner;

public final class Console {

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
	
	/**
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @return
	 * @date 16/04/2021
	 */
	public static String demanderChaine() {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		scanner.close();
		return line;
	}

}
