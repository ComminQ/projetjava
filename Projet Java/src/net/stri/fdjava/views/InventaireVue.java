package net.stri.fdjava.views;

import static net.stri.fdjava.utils.Console.println;

import net.stri.fdjava.controllers.InventaireController;
import net.stri.fdjava.utils.Console;

public class InventaireVue {

	private InventaireController controleur;

	public InventaireVue(InventaireController controleur) {
		super();
		this.controleur = controleur;
	}
	
	public void utiliserInventaire() {
		if(controleur.nombreObjet() == 0) {
			println("§eVotre inventaire est vide ...");
			return;
		}
		println("§fVoici votre §einventaire:");
		println(controleur.afficherInventaire());
		int choix = -1;
		while(choix < 0 || choix >= controleur.nombreObjet()) {
			println("§fChoisissez l'item avec lequel intéragir");
			choix = Console.demanderEntier();
		}
		if(controleur.estEquipable(choix)) {
			println(controleur.equiper(choix));
			return;
		}
		if(controleur.estUtilisable(choix)) {
			println(controleur.utiliser(choix));
			return;
		}
		println(controleur.interagir(choix));		
	}
	
	
	
}
