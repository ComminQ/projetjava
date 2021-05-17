package net.stri.fdjava.views;

import static net.stri.fdjava.utils.Console.println;

import net.stri.fdjava.controllers.BoutiqueController;
import net.stri.fdjava.utils.Console;

public class BoutiqueVue {

	private BoutiqueController controleur;

	public BoutiqueVue(BoutiqueController controleur) {
		super();
		this.controleur = controleur;
	}

	public void utiliserBoutique() {
		int choix = -1;
		while(true) {
			println("§fVous avez §e"+controleur.nombrePieceOr()+" pièces d'or.§f");
			println("§fVeuillez choisir le numéro de l'item à acheter");
			for(String string : controleur.afficherProduits()) {
				println(string);
			}
			println("- §c("+controleur.nombreProduits()+") - §cQuitter la boutique§f");
			choix = Console.demanderEntier();
			if(choix == controleur.nombreProduits()) {
				break;
			}
			println(controleur.acheterProduit(choix));
		}
	}
	
	
	
}
