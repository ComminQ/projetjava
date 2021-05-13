package net.stri.fdjava.models.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import net.stri.fdjava.models.item.Item;
import net.stri.fdjava.models.item.TypeItem;
import net.stri.fdjava.models.item.properties.ProprietesOffensive;

/**
 * Représente un entité du jeu
 * 
 * @author Fabien CAYRE (Computer)
 *
 * @date 30/04/2021
 */
public abstract class Entity implements Serializable {

	/**
	 * @author Fabien CAYRE (Computer)
	 *
	 * @date 16/04/2021
	 */
	private static final long serialVersionUID = -6820141359657416476L;

	/**
	 * Son équipement
	 */
	protected Map<Emplacement, Item> equipement;
	/**
	 * Le nom de l'entité
	 */
	@Getter
	@Setter
	protected String nom;

	/**
	 * Les points de vie
	 */
	@Getter
	@Setter
	protected int ptsVie;

	/**
	 * Les dégats
	 */
	@Getter
	@Setter
	protected int ptsForce;

	/**
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param nom
	 * @param ptsVie
	 * @param ptsForce
	 * @date 30/04/2021
	 */
	public Entity(String nom, int ptsVie, int ptsForce) {
		this.nom = nom;
		this.ptsVie = ptsVie;
		this.ptsForce = ptsForce;
		this.equipement = new HashMap<>();
	}

	/**
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param entity
	 * @returns Les dégats infligé
	 * @date 30/04/2021
	 */
	public int attaquer(Entity entity) {
		// TODO appliquer les dégats en fonction, des points de vie, de la force, des
		// items de chaque coté
		int totalDamage = getDegatTotal();

		// Calcul armure (réduction des dégats)
		totalDamage -= getTotalArmure();
		
		if(totalDamage > 0) {
			entity.setPtsVie(entity.getPtsVie() - totalDamage);
		}
		return totalDamage;
	}

	/**
	 * Renvoie les points de dégats totaux
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @return
	 * @date 07/05/2021
	 */
	public int getDegatTotal() {
		int totalDamage = this.ptsForce;
		// Applications des items dégats
		if (this.equipement.containsKey(Emplacement.MAIN)) {
			Item item = this.equipement.get(Emplacement.MAIN);
			if (item.getType() == TypeItem.EPEE) {
				ProprietesOffensive props = (ProprietesOffensive) item.getProprietesItem();
				totalDamage += props.getPtsForce();
			}
		}
		return totalDamage;
	}

	/**
	 * Renvoie les points d'armures totaux
	 * @author Fabien CAYRE (Computer)
	 *
	 * @return
	 * @date 07/05/2021
	 */
	public int getTotalArmure() {
		int totalArmure = 0;
		// Applications des items deffensif
		if (this.equipement.containsKey(Emplacement.BUSTE)) {
			Item item = this.equipement.get(Emplacement.BUSTE);
			if (item.getType() == TypeItem.ARMURE) {
				ProprietesOffensive props = (ProprietesOffensive) item.getProprietesItem();
				totalArmure += props.getPtsForce();
			}
		}
		if (this.equipement.containsKey(Emplacement.TETE)) {
			Item item = this.equipement.get(Emplacement.TETE);
			if (item.getType() == TypeItem.ARMURE) {
				ProprietesOffensive props = (ProprietesOffensive) item.getProprietesItem();
				totalArmure += props.getPtsForce();
			}
		}
		return totalArmure;
	}

	/**
	 * Met l'item dans l'équipement du joueur
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param emplacement
	 * @param item
	 * @date 13/04/2021
	 */
	public Item setEquipement(Emplacement emplacement, Item item) {
		if (item.getProprietesItem() instanceof ProprietesOffensive) {
			return this.equipement.put(emplacement, item);
		} else {
			throw new IllegalArgumentException("L'item pour le slot " + emplacement + " n'est pas un équipement d'armure.");
		}
	}

	/**
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @return
	 * @date 03/05/2021
	 */
	public boolean estEnVie() {
		return this.ptsVie > 0;
	}

	@Override
	public String toString() {
		return "Entity [nom=" + nom + ", ptsVie=" + ptsVie + ", ptsForce=" + ptsForce + "]";
	}

}
