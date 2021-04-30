package net.stri.fdjava.models.entity;

public class Monstre extends Entity implements Cloneable{

	public Monstre(String nom, int ptsVie, int ptsForce) {
		super(nom, ptsVie, ptsForce);
	}

	@Override
	protected Monstre clone() throws CloneNotSupportedException {
		return (Monstre) super.clone();
	}
	
}
