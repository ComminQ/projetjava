package net.stri.fdjava.controllers;

import net.stri.fdjava.models.entity.Heros;
import net.stri.fdjava.models.entity.Inventaire;
import net.stri.fdjava.models.item.Item;

public class InventaireController {

	private Heros heros;

	public InventaireController(Heros heros) {
		this.heros = heros;
	}

	public String afficherInventaire() {
		String ret = "";
		Inventaire inventaire = this.heros.getInventaire();
		
		ret+="§eVotre inventaire contient: §f";
		for(int i = 0; i < inventaire.getMaxItem(); i++) {
			Item item = inventaire.getObjet(i);
			ret+="- ("+i+") ";
			if(item == null) {
				ret+="Vide";
			}else {
				ret+=item.getType().getNom()+" "+item.getProprietesItem().afficherProps();
			}
			ret+="\n";
		}
		
		
		return ret;
	}

}
