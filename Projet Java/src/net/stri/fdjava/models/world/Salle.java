package net.stri.fdjava.models.world;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class Salle implements Serializable {

	/**
	 * @author Fabien CAYRE (Computer)
	 *
	 * @date 16/04/2021
	 */
	private static final long serialVersionUID = -796316498557828403L;
	
	
	@Getter @Setter
	private Salle nord;
	@Getter @Setter
	private Salle sud;
	@Getter @Setter
	private Salle est;
	@Getter @Setter
	private Salle ouest;
	@Getter @Setter
	private String name;
	
	public Salle(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Salle [name=" + name + "]";
	}
	
	
	
}
