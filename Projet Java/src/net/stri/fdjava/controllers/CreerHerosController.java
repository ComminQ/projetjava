package net.stri.fdjava.controllers;

import lombok.Getter;
import lombok.Setter;
import net.stri.fdjava.models.entity.Heros;
import net.stri.fdjava.models.entity.TypeHeros;

/**
 * Permet la gestion du héros
 * 
 * Ce contrôleur permet de changer le nom du héros et son type
 * 
 * @author Fabien CAYRE (Computer)
 *
 * @date 30/04/2021
 */
public class CreerHerosController {

	@Getter @Setter
	private Heros heros;

	public CreerHerosController(Heros heros) {
		this.heros = heros;
	}
	
	public void setNomHeros(String heros) {
		this.heros.setNom(heros);
	}

	/**
	 * Permet de changer le type du héros
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param index
	 * @date 30/04/2021
	 */
	public void setTypeHeros(int index) {
		TypeHeros type = TypeHeros.values()[index];
		this.heros.setPtsVie(type.getPointDeVie());
		this.heros.setPtsForce(type.getDegat());
		
	}
	
	
	
	
}
