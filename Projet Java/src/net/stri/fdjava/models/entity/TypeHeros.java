package net.stri.fdjava.models.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Concerne les différentes classes d'héros
 * @author Fabien CAYRE (Computer)
 *
 * @date 30/04/2021
 */
public enum TypeHeros {

	PALADIN(100, 50),
	ASSASIN(65, 110),
	GUERRIER(80, 70);
	
	@Getter @Setter
	private int pointDeVie;
	@Getter @Setter
	private int degat;
	
	private TypeHeros(int pointDeVie, int degat) {
		this.pointDeVie = pointDeVie;
		this.degat = degat;
	}
	
	
	
}
