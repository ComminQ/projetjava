package net.stri.fdjava.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Fichier {

	/**
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param dossier
	 * @return
	 * @date 03/05/2021
	 */
	public static List<String> listerFichier(String dossier){
		File file = new File(dossier);
		return Arrays.asList(file.list());
	}
	
	/**
	 * Créer un fichier sur le système
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param nom Le nom du fichier
	 * @throws IOException S'il y a une erreur pendant la création du fichier
	 * @date 03/05/2021
	 */
	public static void creerFichier(String nom) throws IOException {
		File file = new File(nom);
		if(file.exists()) return;
		file.createNewFile();
	}
	
	/**
	 * Vérifie si un fichier existe
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param nom Le nom du fichier
	 * @return
	 * @date 03/05/2021
	 */
	public static boolean fichierExiste(String nom) {
		return new File(nom).exists();
	}
	
	/**
	 * Lit un objet depuis un fichier
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param <T> Le type de donnée à récupérer
	 * @param fichier
	 * @return
	 * @throws IOException S'il y a eu une erreur lors de : l'ouverture du fichier, l'ouverture du flux, la fermeture du flux d'objet
	 * @throws ClassNotFoundException S'il y a eu une erreur sur la lecture de l'objet
	 * @date 03/05/2021
	 */
	public static <T extends Serializable> T lireDonnee(String fichier) throws IOException, ClassNotFoundException {
		File file = new File(fichier);
		// le fichier n'existe pas
		if(!file.exists())return null;
		// On ouvre le buffer d'objet sur le fichier
		FileInputStream fileIn = new FileInputStream(file);
		ObjectInputStream in = new ObjectInputStream(fileIn);
		// On lit l'objet
		T data = (T) in.readObject();
		if(data == null) {
			in.close();
			throw new IOException("Aucune donnée objet dans "+fichier);
		}
		// On ferme le flux
		in.close();
		return data;
	}
	
	/**
	 * Permet de sauvegarder une instance d'un objet dans un fichier
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param <T> le type de l'objet à sauvegarder
	 * @param fichier
	 * @param donnee
	 * @throws IOException S'il y a eu une erreur lors de : l'ouverture du fichier, l'ouverture du flux, la fermeture du flux d'objet
	 * @date 03/05/2021
	 */
	public static <T extends Serializable> void ecrireDonnees(String fichier, T donnee) throws IOException {
		File file = new File(fichier);
		// le fichier n'existe pas
		if(!file.exists()) {
			throw new IOException("Le fichier n'existe pas "+fichier+".");
		}
		// On ouvre le buffer d'objet sur le fichier
		FileOutputStream fileOut = new FileOutputStream(file);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		// On écrit l'objet
		out.writeObject(donnee);
		// On flush
		out.flush();
		// On ferme le flux
		out.close();
	}
	
}
