package net.stri.fdjava.models;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import net.stri.fdjava.models.entity.Heros;
import net.stri.fdjava.models.world.Salle;

/**
 * Représente la sauvegarde
 * @author Fabien CAYRE (Computer)
 *
 * @date 30/04/2021
 */
public class Sauvegarde implements Serializable{

	/**
	 * @author Fabien CAYRE (Computer)
	 *
	 * @date 16/04/2021
	 */
	private static final long serialVersionUID = 6826419045846907146L;
	
	@Getter @Setter
	private Heros heros;
	@Getter @Setter
	private List<Salle> salles;
	@Getter @Setter
	private Salle entree;
	@Getter @Setter
	private Salle sortie;
	
	public Sauvegarde(Heros heros, List<Salle> salles, Salle entree, Salle sortie) {
		super();
		this.heros = heros;
		this.salles = salles;
		this.entree = entree;
		this.sortie = sortie;
	}
	
	//TODO à completer
	
	
}
