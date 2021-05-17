package net.stri.fdjava.models;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;
import net.stri.fdjava.models.entity.Heros;
import net.stri.fdjava.models.world.Salle;
import net.stri.fdjava.utils.Fichier;

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
	
	/**
	 * Retourne la liste des fichiers de sauvegarde
	 * @author Fabien CAYRE (Computer)
	 *
	 * @return
	 * @date 17/05/2021
	 */
	public static List<String> listeSauvegarde(){
		File saves = new File("./saves");
		if(!saves.exists()) {
			saves.mkdir();
		}
		return Fichier.listerFichier("./saves")
			.stream()
			.filter(s -> s.endsWith(".pj"))
			.collect(Collectors.toList());
	}
	 
	/**
	 * Retourne la sauvegarde d'un fichier
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param chemin
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @date 17/05/2021
	 */
	public static Sauvegarde charger(String chemin) throws ClassNotFoundException, IOException {
		return Fichier.lireDonnee(chemin);
	}
	
	/**
	 * Créer un fichier de sauvegarde
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param sauvegarde
	 * @throws IOException
	 * @date 17/05/2021
	 */
	public static void sauvegarder(Sauvegarde sauvegarde) throws IOException {
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy_HH-mm-ss");
		String dateJour = formater.format(System.currentTimeMillis());
		File file = new File("./saves/Saves_"+dateJour+".pj");
		file.createNewFile();
		Fichier.ecrireDonnees(file.getAbsolutePath(), sauvegarde);
	}
	
	@Getter @Setter
	private Heros heros;
	@Getter @Setter
	private List<Salle> salles;
	@Getter @Setter
	private Salle entree;
	@Getter @Setter
	private Salle sortie;
	@Getter @Setter
	private int tour;
	
	
	public Sauvegarde(Heros heros, List<Salle> salles, Salle entree, Salle sortie) {
		super();
		this.heros = heros;
		this.salles = salles;
		this.entree = entree;
		this.sortie = sortie;
	}
	
	
}
