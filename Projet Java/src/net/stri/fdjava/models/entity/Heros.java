package net.stri.fdjava.models.entity;

import lombok.Getter;
import lombok.Setter;
import net.stri.fdjava.models.world.Salle;

public class Heros extends Entity{

	private Inventaire inventaire;
	@Getter @Setter
	private Salle salle;
	
	public Heros(String nom, int ptsVie, int ptsForce) {
		super(nom, ptsVie, ptsForce);
	}
}
