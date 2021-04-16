package net.stri.fdjava.utils;

public enum Colour {

	BLACK("\033[0;30m", "§k"), // BLACK
	RED("\033[0;31m", "§c"), // RED
	GREEN("\033[0;32m", "§a"), // GREEN
	YELLOW("\033[0;33m", "§e"), // YELLOW
	BLUE("\033[0;34m", "§b"), // BLUE
	PURPLE("\033[0;35m", "§5"), // PURPLE
	CYAN("\033[0;36m", "§c"), // CYAN
	WHITE("\033[0;37m", "§f"),
	RESET("\033[0;37m", "§r"); // WHITE
	
	public static String transform(String text) {
		for(Colour col : Colour.values()) {
			text = text.replaceAll("\\"+col.replace, col.tag);
		}
		return text;
	}
	
	private String tag;
	private String replace;
	
	private Colour(String tag, String replace) {
		this.tag = tag;
		this.replace = replace;
	}
	
	
	
}
