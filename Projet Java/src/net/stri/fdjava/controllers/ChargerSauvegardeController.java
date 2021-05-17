package net.stri.fdjava.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.stri.fdjava.models.Sauvegarde;

public class ChargerSauvegardeController {

	public ChargerSauvegardeController() {
	}
	
	public List<String> choixSauvegarde(){
		List<String> affiche = new ArrayList<>();
		int n = 0;
		for(String sauvegarde : Sauvegarde.listeSauvegarde()) {
			affiche.add("- ("+n+") Fichier de sauvegarde "+sauvegarde);
			n++;
		}
		return affiche;
	}
	
	public int nbSauvegarde() {
		return Sauvegarde.listeSauvegarde().size();
	}
	
	/**
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param n
	 * @return
	 * @date 17/05/2021
	 */
	public Sauvegarde choisir(int n) {
		String file = Sauvegarde.listeSauvegarde().get(n);
		try {
			Sauvegarde saves = Sauvegarde.charger("./saves/"+file);
			return saves;
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean estSauvegarde() {
		return nbSauvegarde() > 0;
	}
	
}
