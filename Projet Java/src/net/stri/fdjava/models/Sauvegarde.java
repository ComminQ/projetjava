package net.stri.fdjava.models;

import java.io.Serializable;
import java.util.List;

import net.stri.fdjava.models.entity.Heros;
import net.stri.fdjava.models.world.Salle;

public class Sauvegarde implements Serializable{

	/**
	 * @author Fabien CAYRE (Computer)
	 *
	 * @date 16/04/2021
	 */
	private static final long serialVersionUID = 6826419045846907146L;
	
	
	private Heros heros;
	private List<Salle> salles;
	private Salle entree;
	private Salle sortie;
	
}
