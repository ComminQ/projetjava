package net.stri.fdjava.models.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import net.stri.fdjava.models.item.Item;

public abstract class Entity implements Serializable{

	/**
	 * @author Fabien CAYRE (Computer)
	 *
	 * @date 16/04/2021
	 */
	private static final long serialVersionUID = -6820141359657416476L;
	
	
	protected Map<Emplacement, Item> equipement;
	@Getter @Setter
	protected String nom;
	@Getter
	protected int ptsVie;
	@Getter
	protected int ptsForce;
	
	
	public Entity(String nom, int ptsVie, int ptsForce) {
		this.nom = nom;
		this.ptsVie = ptsVie;
		this.ptsForce = ptsForce;
		this.equipement = new HashMap<>();
	}
	
	/**
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param emplacement
	 * @param item
	 * @date 13/04/2021
	 */
	public void setEquipement(Emplacement emplacement, Item item) {
		// TODO check si l'item est bon pour l'emplacement
		this.equipement.put(emplacement, item);
	}

	@Override
	public String toString() {
		return "Entity [nom=" + nom + ", ptsVie=" + ptsVie + ", ptsForce=" + ptsForce + "]";
	}
	
	
	
	
}
