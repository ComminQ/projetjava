package net.stri.fdjava.test;

import net.stri.fdjava.controllers.DonjonController;
import net.stri.fdjava.models.entity.Heros;

public class RawDonjonControllerTest {

	public static void main(String[] args) {
		Heros heros = new Heros("Darild", 52, 7);
		DonjonController donjonController = new DonjonController();
		donjonController.entrer(heros);
	}
	
}
