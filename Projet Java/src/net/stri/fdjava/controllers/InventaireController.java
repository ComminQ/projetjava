package net.stri.fdjava.controllers;

import net.stri.fdjava.models.entity.Emplacement;
import net.stri.fdjava.models.entity.Heros;
import net.stri.fdjava.models.entity.Inventaire;
import net.stri.fdjava.models.item.Item;
import net.stri.fdjava.models.item.properties.ProprietesOffensive;

public class InventaireController {

	private Heros heros;

	public InventaireController(Heros heros) {
		this.heros = heros;
	}

	private Inventaire inv() {
		return this.heros.getInventaire();
	}

	public String afficherInventaire() {
		String ret = "";
		Inventaire inventaire = this.heros.getInventaire();

		ret += "§eVotre inventaire contient: §f\n";
		for (int i = 0; i < inventaire.getMaxItem(); i++) {
			Item item = null;
			if(i < inventaire.taille()) {
				item = inventaire.getObjet(i);
			}
			ret += "- (" + i + ") ";
			if (item == null) {
				ret += "Vide";
			} else {
				ret += item.getType().getNom() + " " + item.getProprietesItem().afficherProps()+"§r";
			}
			ret += "\n";
		}

		return ret;
	}

	public int nombreObjet() {
		return this.heros.getInventaire().taille();
	}

	public boolean estEquipable(int choix) {
		return inv().getObjet(choix).getType().getPropriete() == ProprietesOffensive.class;
	}

	public String equiper(int choix) {
		Item obj = inv().getObjet(choix);
		if (obj == null) {
			return "§cÊtes vous sur que c'est un objet ?";
		}
		Emplacement em = null;
		switch (obj.getType()) {
		case CASQUE:
			em = Emplacement.TETE;
			break;
		case EPEE:
			em = Emplacement.MAIN;
			break;
		case ARMURE:
			em = Emplacement.BUSTE;
			break;
		default:
			em = null;
			break;
		}
		if (em == null) {
			return "§cEtrange!";
		}
		inv().retirerObjet(obj);
		String texte = "";
		Item ancien = this.heros.setEquipement(em, obj);
		texte+="§fVous avez équipé "+obj.getProprietesItem().getCouleur()+obj.getProprietesItem().getNom()+"§f dans/sur votre §e"+em.getName()+"§f!";
		if(ancien != null) {
			texte+="\n";
			texte+="§fVotre ancien objet "+ancien.getProprietesItem().getCouleur()+obj.getProprietesItem().getNom()+" à été transféré dans votre inventaire§f";
			inv().ajouterObjet(ancien);
		}
		return texte;
	}

	public boolean estUtilisable(int choix) {
		// TODO Auto-generated method stub
		return false;
	}

	public String utiliser(int choix) {
		// TODO Auto-generated method stub
		return null;
	}

	public String interagir(int choix) {
		// TODO Auto-generated method stub
		return null;
	}

}
