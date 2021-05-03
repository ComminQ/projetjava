package net.stri.fdjava.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.stri.fdjava.models.entity.Heros;
import net.stri.fdjava.models.world.Salle;
import net.stri.fdjava.views.Direction;

/**
 * Controleur du donjon, représente le donjon en lui même
 * 
 * 
 * 
 * @author Fabien CAYRE (Computer)
 *
 * @date 30/04/2021
 */
public class DonjonController {

	private List<Salle> salles;
	private Salle entree;
	private Salle sortie;
	private Heros heros;

	public DonjonController(Heros heros) {
		this.salles = new ArrayList<>();
		this.heros = heros;
		this.genererDonjon();
	}

	/**
	 * Fait rentrer le héros dans le donjon, donc dans la salle principale
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @date 30/04/2021
	 */
	public void entrer() {
		heros.setSalle(entree);
	}

	/**
	 * Génère les salles du donjons
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @date 30/04/2021
	 */
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
	 * Renvoie les salles disponibles respectivement Index 0 = nord Index 1 = ouest
	 * Index 2 = est Index 3 = sud
	 * 
	 * Sur ces index si la valeur est à false, il est impossible d'utiliser la porte
	 * pour aller dans la salle à la direction spécifiée
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @return
	 * @date 30/04/2021
	 */
	public boolean[] getSalleDisponible() {
		boolean[] salles = new boolean[4];
		Arrays.fill(salles, false);
		if (this.heros.getSalle().getNord() != null) {
			salles[0] = true;
		}
		if (this.heros.getSalle().getOuest() != null) {
			salles[1] = true;
		}
		if (this.heros.getSalle().getEst() != null) {
			salles[2] = true;
		}
		if (this.heros.getSalle().getSud() != null) {
			salles[3] = true;
		}
		return salles;
	}

	/**
	 * Vérifie si le joueur peut accèder à une direction par rapport à sa salle actuelle
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param direction
	 * @return
	 * @date 02/05/2021
	 */
	public boolean estDisponible(int direction) {
		if(direction == -1)return false;
		Direction dir = Direction.getForDonjon(direction);
		switch(dir) {
		case EST:
			return this.heros.getSalle().getEst() != null;
		case NORD:
			return this.heros.getSalle().getNord() != null;
		case OUEST:
			return this.heros.getSalle().getOuest() != null;
		case SUD:
			return this.heros.getSalle().getSud() != null;
		}
		return true;
	}

	/**
	 * Vérifie si la salle dans laquelle se dirige le joueur est unidirectionelle
	 * 
	 * Ex:
	 * - Une salle peut avoir une porte EST qui mène à une autre salle ne possèdant pas de porte OUEST
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @return True si la porte est unidirectionelle, False si non OU s'il n'y a pas de sortie sur la direction
	 * @date 02/05/2021
	 */
	public boolean estUnidirectionelle(int direction) {
		if(direction == -1)return false;
		Direction dir = Direction.getForDonjon(direction);
		boolean estDispo = estDisponible(direction);
		if(!estDispo) return false;
		switch(dir) {
		case EST:
			if(this.heros.getSalle().getEst() == null) return false;
			return this.heros.getSalle().getEst().getOuest() == null;
		case NORD:
			if(this.heros.getSalle().getNord() == null) return false;
			return this.heros.getSalle().getNord().getSud() == null;
		case OUEST:
			if(this.heros.getSalle().getOuest() == null) return false;
			return this.heros.getSalle().getOuest().getEst() == null;
		case SUD:
			if(this.heros.getSalle().getSud() == null) return false;
			return this.heros.getSalle().getSud().getNord() == null;
		}
		return false;
	}
	
	/**
	 * Permet de faire changer de salle au joueur
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param direction
	 * @date 02/05/2021
	 */
	public void changerSalle(int direction) {
		if(direction == -1) return;
		Direction dir = Direction.getForDonjon(direction);
		switch(dir) {
		case EST:
			this.heros.setSalle(this.heros.getSalle().getEst());
			break;
		case NORD:
			this.heros.setSalle(this.heros.getSalle().getNord());
			break;
		case OUEST:
			this.heros.setSalle(this.heros.getSalle().getOuest());
			break;
		case SUD:
			this.heros.setSalle(this.heros.getSalle().getSud());
			break;
		}
	}

	public boolean estCombatDisponible() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean estTerminer() {
		// TODO Auto-generated method stub
		return false;
	}

}
