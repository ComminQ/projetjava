package net.stri.fdjava.controllers;

import lombok.Getter;
import lombok.Setter;
import net.stri.fdjava.models.entity.Heros;
import net.stri.fdjava.models.entity.TypeHeros;

public class CreerHerosController {

	@Getter @Setter
	private Heros heros;

	public CreerHerosController(Heros heros) {
		this.heros = heros;
	}
	
	public void setNomHeros(String heros) {
		this.heros.setNom(heros);
	}

	public void setTypeHeros(int index) {
		TypeHeros type = TypeHeros.values()[index];
		this.heros.setPtsVie(type.getPointDeVie());
		this.heros.setPtsForce(type.getDegat());
		
	}
	
	
	
	
}
