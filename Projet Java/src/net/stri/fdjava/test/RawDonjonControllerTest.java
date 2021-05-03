package net.stri.fdjava.test;

import net.stri.fdjava.controllers.DonjonController;
import net.stri.fdjava.models.entity.Heros;
import net.stri.fdjava.views.SalleDonjonVue;

/**
 * test du contrôleur de donjon
 * @author Fabien CAYRE (Computer)
 *
 * @date 30/04/2021
 */
public class RawDonjonControllerTest {

	public static void main(String[] args) {
		Heros heros = RawCreerHerosControllerTest.creerHeros();
		DonjonController controleur = new DonjonController(heros);
		SalleDonjonVue vue = new SalleDonjonVue(controleur);
		
		vue.afficherEntree();
		vue.selectionnerSalle();
		vue.selectionnerSalle();
		// ça marche !
	}
	
}
