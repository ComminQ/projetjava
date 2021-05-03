package net.stri.fdjava.controllers;

import net.stri.fdjava.models.entity.Heros;

public class CombatControleur {

	private Heros heros;
	private DonjonController controleur;

	public CombatControleur(Heros heros, DonjonController controleur) {
		super();
		this.heros = heros;
		this.controleur = controleur;
	}

	public boolean estTermine() {
		// TODO Auto-generated method stub
		return false;
	}

}
