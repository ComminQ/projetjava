package net.stri.fdjava.controllers;

import java.util.ArrayList;
import java.util.List;

import net.stri.fdjava.models.entity.Heros;
import net.stri.fdjava.models.world.Salle;
import net.stri.fdjava.views.DonjonView;

public class DonjonController {

	private List<Salle> salles;
	private Salle entree;
	private Salle sortie;
	private DonjonView donjonView;
	
	public DonjonController() {
		this.salles = new ArrayList<>();
		this.genererDonjon();
	}
	
	public void entrer(Heros heros) {
		
	}
	
	
	private void genererDonjon() {
		
		// Création des salles
		Salle entree = new Salle();
		Salle s01 = new Salle();
		Salle s02 = new Salle();
		Salle s03 = new Salle();
		Salle s10 = new Salle();
		Salle s11 = new Salle();
		Salle s12 = new Salle();
		Salle s13 = new Salle();
		Salle sortie = new Salle();
		
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
	
}
