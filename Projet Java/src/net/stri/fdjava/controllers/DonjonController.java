package net.stri.fdjava.controllers;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import net.stri.fdjava.models.entity.Heros;
import net.stri.fdjava.models.entity.Monstre;
import net.stri.fdjava.models.entity.monstre.MortVivant;
import net.stri.fdjava.models.world.Combat;
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

	private Salle entree;
	private Salle sortie;
	@Getter
	private Heros heros;
	@Getter @Setter
	private Combat combatActuel;
	private int tour;

	public DonjonController(Heros heros) {
		this.heros = heros;
		this.tour = 0;
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
	 * S'il y a un combat, le joueur ne peut changer de salle
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @return
	 * @date 30/04/2021
	 */
	public boolean[] getSalleDisponible() {
		boolean[] salles = new boolean[4];
		Arrays.fill(salles, false);
		if(this.combatActuel != null) return salles;
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
	 * 
	 * S'il y a un combat, le joueur ne peut changer de salle
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param direction
	 * @return
	 * @date 02/05/2021
	 */
	public boolean estDisponible(int direction) {
		if(this.combatActuel != null) return false;
		if(direction < 0)return false;
		if(direction >= Direction.values().length) return false;
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
		if(direction < 0)return false;
		if(direction >= Direction.values().length) return false;
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
		if(direction < 0)return;
		if(direction >= Direction.values().length) return;
		Direction dir = Direction.getForDonjon(direction);
		this.heros.setSallePrecedente(this.heros.getSalle());
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
	
	/**
	 * Augmenter le tour actuel de 1
	 * @author Fabien CAYRE (Computer)
	 *
	 * @date 07/05/2021
	 */
	public void augmenterTour() {
		this.tour++;
	}

	/**
	 * Un combat est disponible quand le joueur est dans la salle
	 * et que la différence entre le tour actuel et le tour dans lequel le joueur est rentré dans cette salle
	 * est supérieur à 2 ou que ce joueur n'est jamais rentré dans la salle
	 * 
	 * Si un combat est en cours, il ne peut avoir un combat de disponible
	 * @author Fabien CAYRE (Computer)
	 *
	 * @return
	 * @date 07/05/2021
	 */
	public boolean estCombatDisponible() {
		if(this.combatActuel != null) return false;
		Salle salleActuelle = this.heros.getSalle();
		// Si c'est l'entrée : pas de combat
		if(salleActuelle == this.entree) return false;
		return salleActuelle.getRentrerTour() == -1 || salleActuelle.getRentrerTour() + 2 < this.tour;
	}
	
	/**
	 * Le combat commence entre un héros et de 1 à 3 monstres
	 * Il y a 50% de chance pour que le joueur tombe avec 1 monstre
	 * Il y a 30% de chance pour que le joueur tombe avec 2 monstres
	 * Il y a 20% de chance pour que le joueur tombe avec 3 monstres
	 * @author Fabien CAYRE (Computer)
	 *
	 * @date 07/05/2021
	 */
	public void demarrerCombat() {
		float random = 0;
		try {
			random = SecureRandom.getInstanceStrong().nextFloat();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		int nbMonstre = -1;
		if(random < 0.5) {
			//50% de chances
			nbMonstre = 1;
		}else if (random >= 0.5 && random < 0.8) {
			nbMonstre = 2;
		}else if (random >= 0.8 && random <= 1) {
			nbMonstre = 3;
		}
		List<Monstre> monstres = new ArrayList<>();
		for(int i = 0; i < nbMonstre; i++) {
			monstres.add(new MortVivant());
		}
		 
		Combat combat = new Combat(heros, monstres);
		this.combatActuel = combat;
	}

	/**
	 * Vérifie que le donjon est terminé
	 * @author Fabien CAYRE (Computer)
	 *
	 * @return
	 * @date 07/05/2021
	 */
	public boolean estTerminer() {
		// TODO Auto-generated method stub
		return false;
	}

}
