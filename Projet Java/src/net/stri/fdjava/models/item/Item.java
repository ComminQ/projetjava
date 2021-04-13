package net.stri.fdjava.models.item;

import lombok.Getter;
import lombok.Setter;

public class Item {

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
