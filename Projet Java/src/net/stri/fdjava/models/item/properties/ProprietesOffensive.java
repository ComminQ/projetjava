package net.stri.fdjava.models.item.properties;

import lombok.Getter;
import lombok.Setter;
import net.stri.fdjava.models.item.ProprietesItem;

public class ProprietesOffensive extends ProprietesItem{

	@Getter @Setter
	private int ptsForce;
	
	public ProprietesOffensive() {
		super();
	}
	
}
