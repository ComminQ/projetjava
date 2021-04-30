package net.stri.fdjava.models.item;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Fabien CAYRE (Computer)
 *
 * @date 30/04/2021
 */
public class Item implements Serializable  {

	/**
	 * @author Fabien CAYRE (Computer)
	 *
	 * @date 16/04/2021
	 */
	private static final long serialVersionUID = -2362809264765483752L;
	
	/**
	 * La quantité d'item
	 */
	@Getter
	private int quantite;
	@Getter @Setter
	private TypeItem type;
	@Getter
	private ProprietesItem proprietesItem;
	
	public Item(TypeItem type) {
		this.type = type;
		
		this.proprietesItem = type.genererProprietes(this);
	}
	
	public void setQuantite(int quantite) {
		// vérification customisé
		if(quantite > type.getQuantiteMax()) {
			throw new IllegalArgumentException("La quantité est trop importante pour le type d'item");
		}
		this.quantite = quantite;
	}
	
	
	
}
