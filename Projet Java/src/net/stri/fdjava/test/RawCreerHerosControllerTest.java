package net.stri.fdjava.test;

import net.stri.fdjava.controllers.CreerHerosController;
import net.stri.fdjava.models.entity.Heros;
import net.stri.fdjava.views.CreerHerosVue;

public class RawCreerHerosControllerTest {

	public static void main(String[] args) {
		CreerHerosVue vue = new CreerHerosVue();
		Heros heros = new Heros(80, 20);
		CreerHerosController controlleur = new CreerHerosController(heros, vue);
		
		controlleur.créerPersonnage();
	}
	
}
