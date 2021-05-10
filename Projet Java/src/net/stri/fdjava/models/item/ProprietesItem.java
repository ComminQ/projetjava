package net.stri.fdjava.models.item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import net.stri.fdjava.utils.CC;

/**
 * Représente les propriétès d'un item
 * 
 * les items partages les mêmes type de propriétès, mais pas le même contenu 
 * Ex:
 *  - Une armure en fer et une armure mythique en fer sont deux armures en fer
 *  	Mais une ne donne pas autant de protection que l'autre
 * @author Fabien CAYRE (Computer)
 *
 * @date 30/04/2021
 */
public class ProprietesItem implements Serializable, Cloneable {
	
	/**
	 * @author Fabien CAYRE (Computer)
	 *
	 * @date 16/04/2021
	 */
	private static final long serialVersionUID = -967720215441886950L;
	
	
	@Getter @Setter
	protected String nom;
	@Getter @Setter
	protected List<String> description;
	@Getter @Setter
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
	
	@Override
	public ProprietesItem clone() {
		try {
			ProprietesItem props = (ProprietesItem) super.clone();
			return props;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		ProprietesItem other = (ProprietesItem) obj;
		if (nom == null) {
			if (other.nom != null) return false;
		} else if (!nom.equals(other.nom)) return false;
		return true;
	}
	
	
	
}
