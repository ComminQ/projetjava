package net.stri.fdjava.models.world;

import lombok.Getter;
import lombok.Setter;

public class Salle {

	@Getter @Setter
	private Salle nord;
	@Getter @Setter
	private Salle sud;
	@Getter @Setter
	private Salle est;
	@Getter @Setter
	private Salle ouest;
	
	public Salle() {
	}
	
}
