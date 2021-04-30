package net.stri.fdjava.views;

import static net.stri.fdjava.utils.Console.println;

import net.stri.fdjava.models.entity.Heros;

public class DonjonVue {

	public void afficherEntree(Heros heros) {
		println("§e"+heros.getNom()+" §f, vous entrez dans le §edonjon§f !");
		println("§fVous êtes dans §ela salle principale");
		
	}
	
}
