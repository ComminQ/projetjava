package net.stri.fdjava.models.item.properties;

import java.util.List;

import net.stri.fdjava.models.item.Item;
import net.stri.fdjava.models.item.ProprietesItem;
import net.stri.fdjava.utils.CC;

public class ProprietesButin extends ProprietesItem{

	public ProprietesButin() {
		super();
	}
	
	public List<Item> genererButin(int quantite){
		return null;
	}
	
	
	@Override
	protected void majDonnees(Item item) {
		super.majDonnees(item);
		this.nom = "Butin";
		this.couleur = CC.YELLOW;
		this.description.add("Ouvrez cet artefact pour découvrir");
		this.description.add("de fabuleux trèsors");
	}
}
