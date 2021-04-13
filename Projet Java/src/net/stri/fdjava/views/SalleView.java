package net.stri.fdjava.views;

import static net.stri.fdjava.utils.Console.println;

import java.util.Scanner;

public class SalleView {

	/**
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @return
	 * @date 13/04/2021
	 */
	public Direction demanderDirection() {
		Direction direction = null;
		Scanner scan = new Scanner(System.in);
		while (direction == null) {
			println("Veuillez rentrez une direction (Nord: §eN§r, Sud: §eS§r, Est: §eE§r, Ouest: §eO§r)");
			String line = scan.nextLine();
			direction = Direction.getByTag(line);
		}
		scan.close();
		return direction;
	}

}
