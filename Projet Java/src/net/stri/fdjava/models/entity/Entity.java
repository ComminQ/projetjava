package net.stri.fdjava.models.entity;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import net.stri.fdjava.models.item.Item;

public abstract class Entity {

	private Map<Emplacement, Item> equipement;
	@Getter
	private String nom;
	@Getter
	private int ptsVie;
	@Getter
	private int ptsForce;
	
	
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
	
	
}
