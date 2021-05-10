package net.stri.fdjava.models.entity;

/**
 * Représente un monstre dans le donjon
 * @author Fabien CAYRE (Computer)
 *
 * @date 30/04/2021
 */
public abstract class Monstre extends Entity{

	public Monstre(String nom, int ptsVie, int ptsForce) {
		super(nom, ptsVie, ptsForce);
	}

	
}
