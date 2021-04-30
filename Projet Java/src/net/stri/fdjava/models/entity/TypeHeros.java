package net.stri.fdjava.models.entity;

import lombok.Getter;
import lombok.Setter;

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
