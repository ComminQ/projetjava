package net.stri.fdjava.models.entity;

import lombok.Getter;

/**
 * Emplacement de l'équipement du joueur pour les items OFFENSIF
 * et pour les calculs de dégats
 * @author Fabien CAYRE (Computer)
 *
 * @date 30/04/2021
 */
public enum Emplacement {

	TETE("Tête"),
	BUSTE("Corps"),
	MAIN("Main");
	
	
	@Getter
	private String name;

	private Emplacement(String name) {
		this.name = name;
	}
	
	
	
	
}
