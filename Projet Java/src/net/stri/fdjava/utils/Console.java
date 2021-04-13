package net.stri.fdjava.utils;

public final class Console {

	public static void println(String text) {
		System.out.println(Colour.transform(text));
	}
	
	public static void positionCursor(int row, int col) {
		char escCode = 0x1B;
		System.out.print(String.format("%c[%d;%df", escCode, row, col));
	}

}
