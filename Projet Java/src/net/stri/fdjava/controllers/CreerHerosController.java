package net.stri.fdjava.controllers;

import lombok.Getter;
import lombok.Setter;
import net.stri.fdjava.models.entity.Heros;
import net.stri.fdjava.views.CreerHerosVue;

public class CreerHerosController {

	@Getter @Setter
	private Heros heros;
	private CreerHerosVue creerHerosVue;

	public CreerHerosController(Heros heros, CreerHerosVue creerHerosVue) {
		this.heros = heros;
		this.creerHerosVue = creerHerosVue;
	}
	
	public void créerPersonnage() {
		this.heros.setNom(this.creerHerosVue.demanderNomHeros());
	}
	
	
	
	
}
