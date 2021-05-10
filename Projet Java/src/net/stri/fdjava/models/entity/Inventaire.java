package net.stri.fdjava.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import net.stri.fdjava.models.item.Item;

/**
 * Représente une liste d'item (inventaire)
 * 
 * 
 * @author Fabien CAYRE (Computer)
 *
 * @date 30/04/2021
 */
public class Inventaire implements Serializable {

	private static final int DEFAULT_SIZE = 9;
	
	/**
	 * @author Fabien CAYRE (Computer)
	 *
	 * @date 16/04/2021
	 */
	private static final long serialVersionUID = 6189475061361357276L;

	private List<Item> item;
	@Getter
	private int maxItem;
	
	public Inventaire() {
		this(DEFAULT_SIZE);
	}
	
	public Inventaire(int maxItem) {
		this.maxItem = maxItem;
		this.item = new ArrayList<>(maxItem);
	}

	
	//TODO reste a faire : tout
	
	
	public boolean ajouterObjet(Item item) {
		
	}
	
	public boolean retirerObjet(Item item) {
		
	}
	
	public void vider() {
		
	}
	
	public Item getObjet(int index) {
		return null;
	}
	
	
	

}
