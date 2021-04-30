package net.stri.fdjava.test;

import net.stri.fdjava.controllers.DonjonController;
import net.stri.fdjava.models.entity.Heros;
import net.stri.fdjava.views.DonjonVue;

public class RawDonjonControllerTest {

	public static void main(String[] args) {
		Heros heros = RawCreerHerosControllerTest.creerHeros();
		DonjonController controleur = new DonjonController(heros);
		DonjonVue vue = new DonjonVue(controleur);
		
		vue.afficherEntree();
		vue.selectionnerSalle();
	}
	
}
