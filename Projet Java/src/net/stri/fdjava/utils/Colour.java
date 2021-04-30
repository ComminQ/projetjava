package net.stri.fdjava.utils;

/**
 * Représente les couleurs dans la console
 * @author Fabien CAYRE (Computer)
 *
 * @date 30/04/2021
 */
public enum Colour {

	BLACK("\033[0;30m", "§k"), // BLACK
	RED("\033[0;31m", "§c"), // RED
	GREEN("\033[0;32m", "§a"), // GREEN
	YELLOW("\033[0;33m", "§e"), // YELLOW
	BLUE("\033[0;34m", "§b"), // DARK BLUE
	PURPLE("\033[0;35m", "§5"), // PURPLE
	CYAN("\033[0;36m", "§d"), // CYAN
	WHITE("\033[0;37m", "§f"), // WHITE
	RESET("\033[0;37m", "§r"); // RESET

	/**
	 * Transforme les codes textes
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param text
	 * @return
	 * @date 30/04/2021
	 */
	public static String transform(String text) {
		for (Colour col : Colour.values()) {
			text = text.replaceAll("\\" + col.replace, col.tag);
		}
		return text;
	}

	private String tag;
	private String replace;

	/**
	 * Constructeur
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param tag
	 * @param replace
	 * @date 30/04/2021
	 */
	private Colour(String tag, String replace) {
		this.tag = tag;
		this.replace = replace;
	}

}
