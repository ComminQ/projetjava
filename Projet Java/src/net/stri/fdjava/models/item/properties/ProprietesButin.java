package net.stri.fdjava.models.item.properties;

import java.io.Serializable;
import java.util.List;

import net.stri.fdjava.models.item.Item;
import net.stri.fdjava.models.item.ProprietesItem;
import net.stri.fdjava.utils.CC;

/**
 * Représente la prioriété d'un item de type butin / coffre
 * @author Fabien CAYRE (Computer)
 *
 * @date 30/04/2021
 */
public class ProprietesButin extends ProprietesItem implements Serializable{

	/**
	 * @author Fabien CAYRE (Computer)
	 *
	 * @date 16/04/2021
	 */
	private static final long serialVersionUID = -6614964232308792201L;


	/**
	 * Constructeur
	 * @author Fabien CAYRE (Computer)
	 *
	 * @date 30/04/2021
	 */
	public ProprietesButin() {
		super();
	}
	
	/**
	 * Permet de générer le butin
	 * dans le jeu, cette méthode est appellée quand le joueur ouvre ce coffre
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param quantite
	 * @return
	 * @date 30/04/2021
	 */
	public List<Item> genererButin(int quantite){
		return null;
	}
	
	
	@Override
	protected void majDonnees(Item item) {
		super.majDonnees(item);
		this.nom = "Butin";
		this.couleur = CC.YELLOW;
		this.description.add("Ouvrez cet artefact pour découvrir");
		this.description.add("de fabuleux trèsors");
	}
}
