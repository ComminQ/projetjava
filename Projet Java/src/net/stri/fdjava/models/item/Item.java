package net.stri.fdjava.models.item;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class Item implements Serializable  {

	/**
	 * @author Fabien CAYRE (Computer)
	 *
	 * @date 16/04/2021
	 */
	private static final long serialVersionUID = -2362809264765483752L;
	
	@Getter @Setter
	private int quantite;
	@Getter @Setter
	private TypeItem type;
	@Getter
	private ProprietesItem proprietesItem;
	
	public Item(TypeItem type) {
		this.type = type;
		
		
		this.proprietesItem = type.genererProprietes(this);
		this.proprietesItem.majDonnees(this);
	}
	
	
	
}
