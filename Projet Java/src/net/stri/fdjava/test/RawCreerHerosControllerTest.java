package net.stri.fdjava.test;

import net.stri.fdjava.controllers.CreerHerosController;
import net.stri.fdjava.models.entity.Heros;
import net.stri.fdjava.views.CreerHerosVue;

public class RawCreerHerosControllerTest {

	/**
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param args
	 * @date 16/04/2021
	 */
	public static void main(String[] args) {
		Heros heros = new Heros(80, 20);
		CreerHerosController controlleur = new CreerHerosController(heros);
		CreerHerosVue vue = new CreerHerosVue(controlleur);
		
		vue.demanderNomHeros();
		vue.demanderTypeHeros();
	}
	
}
