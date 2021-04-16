package net.stri.fdjava.models.item.properties;

import lombok.Getter;
import lombok.Setter;
import net.stri.fdjava.models.item.ProprietesItem;

public class ProprietesOffensive extends ProprietesItem{

	/**
	 * @author Fabien CAYRE (Computer)
	 *
	 * @date 16/04/2021
	 */
	private static final long serialVersionUID = 8867438164821692948L;
	
	@Getter @Setter
	private int ptsForce;
	
	public ProprietesOffensive() {
		super();
	}
	
}
