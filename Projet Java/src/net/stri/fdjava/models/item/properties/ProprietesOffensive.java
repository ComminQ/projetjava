package net.stri.fdjava.models.item.properties;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import net.stri.fdjava.models.item.ProprietesItem;

/**
 * Représente les propriétès d'un item offensif (Armure ou Epée)
 * @author Fabien CAYRE (Computer)
 *
 * @date 30/04/2021
 */
public class ProprietesOffensive extends ProprietesItem implements Serializable{

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
	
	@Override
	public String afficherProps() {
		return super.afficherProps()+", §bAT: "+ptsForce;
	}
	
	
	
}
