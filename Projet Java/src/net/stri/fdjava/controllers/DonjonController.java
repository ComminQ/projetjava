package net.stri.fdjava.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.stri.fdjava.models.entity.Heros;
import net.stri.fdjava.models.world.Salle;

public class DonjonController {

	private List<Salle> salles;
	private Salle entree;
	private Salle sortie;
	private Heros heros;
	
	public DonjonController(Heros heros) {
		this.salles = new ArrayList<>();
		this.genererDonjon();
		this.heros = heros;
	}
	
	public void entrer() {
		heros.setSalle(entree);
	}
	
	private void genererDonjon() {
		
		// Création des salles
		Salle entree = new Salle("Entrée");
		Salle s01 = new Salle("S01");
		Salle s02 = new Salle("S02");
		Salle s03 = new Salle("S03");
		Salle s10 = new Salle("S10");
		Salle s11 = new Salle("S11");
		Salle s12 = new Salle("S12");
		Salle s13 = new Salle("S13");
		Salle sortie = new Salle("Salle finale");
		
		// Connexion
		entree.setNord(s01);
		entree.setEst(s10);
		
		s01.setSud(entree);
		s01.setEst(s11);
		s01.setNord(s02);
		
		s10.setOuest(entree);
		s10.setNord(s11);
		
		s11.setSud(s10);
		
		s02.setEst(s12);
		s02.setSud(s01);
		s02.setNord(s03);
		
		s12.setSud(s11);
		s12.setOuest(s02);
		
		s03.setSud(s02);
		s03.setEst(s13);
		
		s13.setSud(s12);
		s13.setEst(sortie);
		
		this.entree = entree;
		this.sortie = sortie;
	}

	public String getNomHeros() {
		return this.heros.getNom();
	}

	/**
	 * Renvoie les salles disponibles respectivement
	 * Index 0 = nord
	 * Index 1 = ouest
	 * Index 2 = est
	 * Index 3 = sud
	 * 
	 * Sur ces index si la valeur est à false, il est impossible d'utiliser la porte pour aller dans la salle à la direction spécifiée
	 * @author Fabien CAYRE (Computer)
	 *
	 * @return
	 * @date 30/04/2021
	 */
	public boolean[] getSalleDisponible() {
		boolean[] salles = new boolean[4];
		Arrays.fill(salles, false);
		if(this.heros.getSalle().getNord() != null) {
			salles[0] = true;
		}
		if(this.heros.getSalle().getOuest() != null) {
			salles[1] = true;
		}
		if(this.heros.getSalle().getEst() != null) {
			salles[2] = true;
		}
		if(this.heros.getSalle().getSud() != null) {
			salles[3] = true;
		}
		return salles;
	}
	
}
