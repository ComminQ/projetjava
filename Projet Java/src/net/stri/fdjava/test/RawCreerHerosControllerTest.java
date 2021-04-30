package net.stri.fdjava.test;

import net.stri.fdjava.controllers.CreerHerosController;
import net.stri.fdjava.models.entity.Heros;
import net.stri.fdjava.views.CreerHerosVue;

/**
 * Test brut pour la création d'un héros
 * @author Fabien CAYRE (Computer)
 *
 * @date 30/04/2021
 */
public class RawCreerHerosControllerTest {

	/**
	 * Permet de créer un héros
	 * @author Fabien CAYRE (Computer)
	 *
	 * @return Le héros créé 
	 * @date 30/04/2021
	 */
	public static Heros creerHeros() {
		Heros heros = new Heros(80, 20);
		CreerHerosController controlleur = new CreerHerosController(heros);
		CreerHerosVue vue = new CreerHerosVue(controlleur);
		
		vue.demanderNomHeros();
		vue.demanderTypeHeros();
		return heros;
	}
	
	/**
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param args
	 * @date 16/04/2021
	 */
	public static void main(String[] args) {
		creerHeros();
	}
	
}
