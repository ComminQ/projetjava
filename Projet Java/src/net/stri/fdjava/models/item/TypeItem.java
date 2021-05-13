package net.stri.fdjava.models.item;

import java.lang.reflect.InvocationTargetException;

import lombok.Getter;
import net.stri.fdjava.models.item.properties.ProprietesButin;
import net.stri.fdjava.models.item.properties.ProprietesOffensive;

/**
 * Représente un type d'item
 * @author Fabien CAYRE (Computer)
 *
 * @date 30/04/2021
 */
public enum TypeItem {

	CASQUE("Casque", 1, ProprietesOffensive.class),
	ARMURE("Armure", 1, ProprietesOffensive.class),
	EPEE("Epee", 1, ProprietesOffensive.class),
	BUTIN("Butin", 3, ProprietesButin.class),
	TEST("Test", 1000, ProprietesItem.class);

	@Getter
	private String nom;
	@Getter
	private int quantiteMax;
	@Getter
	private Class<? extends ProprietesItem> propriete;

	/**
	 * le constructeur
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param nom le nom par défaut de l'item (Le nom peux changer si c'est un item mythique ou autre)
	 * @param qteMax La quantité maximale
	 * @param propriete La propriété par défaut du type d'item
	 * @date 30/04/2021
	 */
	private TypeItem(String nom, int qteMax, Class<? extends ProprietesItem> propriete) {
		this.nom = nom;
		this.propriete = propriete;
		this.quantiteMax = qteMax;
	}

	/**
	 * Génère la prioriété pour un item donné
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param item
	 * @return
	 * @date 30/04/2021
	 */
	public ProprietesItem genererProprietes(Item item) {
		try {
			ProprietesItem props = this.propriete.getConstructor().newInstance();
			props.majDonnees(item);
			return props;
		} catch (
			InstantiationException
			| IllegalAccessException
			| IllegalArgumentException
			| InvocationTargetException
			| NoSuchMethodException
			| SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}

}
