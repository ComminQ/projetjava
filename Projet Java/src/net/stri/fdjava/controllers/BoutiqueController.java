package net.stri.fdjava.controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import net.stri.fdjava.models.entity.Heros;
import net.stri.fdjava.models.item.Item;
import net.stri.fdjava.models.item.UsineItem;

public class BoutiqueController {

	@Getter
	private Map<Item, Integer> boutique;
	@Getter
	private Heros heros;
	@Getter
	private DonjonController donjonController;

	public BoutiqueController(DonjonController donjonController) {
		this.heros = donjonController.getHeros();
		this.donjonController = donjonController;
		// Pour garder l'ordre d'insertion comme dans une ArrayList
		this.boutique = new LinkedHashMap<>();
		this.boutique.put(UsineItem.creerEpee("§eDague dentelée", 15), 25);
		this.boutique.put(UsineItem.creerEpee("§cNodachi", 40), 150);
		this.boutique.put(UsineItem.creerEpee("§5Hache de Landvaettirr", 50), 180);

		this.boutique.put(UsineItem.creerArmure("§ePlastron en cuir", 10), 20);
		this.boutique.put(UsineItem.creerArmure("§cPlastron en maille", 30), 150);

		this.boutique.put(UsineItem.creerCasque("§eCasque Kabuto", 15), 35);
	}

	public int nombrePieceOr() {
		return this.heros.getPieceOr();
	}
	
	public int nombreProduits() {
		return this.boutique.size();
	}

	public String acheterProduit(int index) {
		Map.Entry<Item, Integer> product = new ArrayList<>(this.boutique.entrySet()).get(index);
		Item i = product.getKey();
		
		String res = "";
		if(this.heros.getPieceOr() < product.getValue()) {
			res = "§cVous n'avez pas assez de pièces d'or";
		}else {
			// Le joueur à assez de pièce d'or
			this.heros.ajouterPieceOr(- product.getValue() );
			res = "§aVous avez acheté "+i.getProprietesItem().getCouleur()+i.getProprietesItem().getNom();
			res+= "\n"+"§apour §e"+product.getValue();
			res+= "\n"+"§fVous avez donc §e"+this.heros.getPieceOr()+" pièce d'or§f.";
		}
		return res;
	}
	
	public List<String> afficherProduits() {
		List<String> produits = new ArrayList<>();
		int n = 0;
		for(Map.Entry<Item, Integer> entry : this.boutique.entrySet()) {
			Item i = entry.getKey();
			int prix = entry.getValue();
			produits.add("- §f(§b"+n+"§f) "+i.getProprietesItem().getCouleur()+i.getProprietesItem().getNom()+"§f , pour §e"+prix+" pièces d'or§f"); 
			n++;
		}
		return produits;
	}

}
