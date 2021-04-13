package net.stri.fdjava.models.item;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import net.stri.fdjava.utils.CC;

public class ProprietesItem {

	@Getter
	protected String nom;
	@Getter
	protected List<String> description;
	@Getter
	protected String couleur;

	public ProprietesItem() {
		this.description = new ArrayList<>();
	}

	public ProprietesItem(String nom, List<String> description, String couleur) {
		super();
		this.nom = nom;
		this.description = description;
		this.couleur = couleur;
	}

	protected void majDonnees(Item item) {
		this.nom = item.getType().getNom();
		this.couleur = CC.CYAN;
		this.description = new ArrayList<>();
	}
}
