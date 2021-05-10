package net.stri.fdjava.models.item;

import net.stri.fdjava.models.item.properties.ProprietesOffensive;

/**
 * Permet de généré tout les types d'items
 * 
 * Tiré du design pattern factory
 * 
 * @author Fabien CAYRE (Computer)
 *
 * @date 30/04/2021
 */
public final class UsineItem {

	//TODO 
	private UsineItem() {}

	private static final Item EPEE = new Item(TypeItem.EPEE);
	private static final Item ARMURE = new Item(TypeItem.ARMURE);
	private static final Item CASQUE = new Item(TypeItem.CASQUE);
	
	/**
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param nom
	 * @param degat
	 * @return
	 * @date 10/05/2021
	 */
	public static Item creerEpee(String nom, int degat) {
		Item clone = EPEE.clone();
		ProprietesOffensive props = (ProprietesOffensive) clone.getProprietesItem();
		props.setNom(nom);
		props.setPtsForce(degat);
		return clone;
	}
	
	/**
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param nom
	 * @param degat
	 * @return
	 * @date 10/05/2021
	 */
	public static Item creerArmure(String nom, int protection) {
		Item clone = ARMURE.clone();
		ProprietesOffensive props = (ProprietesOffensive) clone.getProprietesItem();
		props.setNom(nom);
		props.setPtsForce(protection);
		return clone;
	}
	
	/**
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param nom
	 * @param degat
	 * @return
	 * @date 10/05/2021
	 */
	public static Item creerCasque(String nom, int protection) {
		Item clone = CASQUE.clone();
		ProprietesOffensive props = (ProprietesOffensive) clone.getProprietesItem();
		props.setNom(nom);
		props.setPtsForce(protection);
		return clone;
	}
	
}
