package net.stri.fdjava.views;

import static net.stri.fdjava.utils.Console.println;

import net.stri.fdjava.controllers.ChargerSauvegardeController;
import net.stri.fdjava.models.Sauvegarde;
import net.stri.fdjava.utils.Console;

public class ChargerSauvegardeVue {
	
	private ChargerSauvegardeController controleur;

	public ChargerSauvegardeVue(ChargerSauvegardeController controleur) {
		this.controleur = controleur;
	}
	
	
	public Sauvegarde chargerSauvegarder() {
		if(!controleur.estSauvegarde()){
			// Aucune sauvegarde 
			return null;
		}
		int choix = -1;
		while(choix < 0 || choix > controleur.nbSauvegarde()) {
			println("§eVoici vos sauvegardes ("+controleur.nbSauvegarde()+" sauvegarde(s)): §f");
			for(String affiche : this.controleur.choixSauvegarde()) {
				println(affiche);
			}
			println("§a- ("+controleur.nbSauvegarde()+") Créer une nouvelle partie");
			println("§eVeuillez choisir votre sauvegarde");
			choix = Console.demanderEntier();
		}
		if(choix == controleur.nbSauvegarde()) {
			// Création d'une nouvelle partie
			println("Choix : "+choix+" / création partie ");
			return null;
		}
		return controleur.choisir(choix);
		
		
		
	}
	
	

}
