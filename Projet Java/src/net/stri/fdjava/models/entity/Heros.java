package net.stri.fdjava.models.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import net.stri.fdjava.models.world.Salle;

/**
 * Représente un héros
 * @author Fabien CAYRE (Computer)
 *
 * @date 30/04/2021
 */
public class Heros extends Entity implements Serializable {

	/**
	 * @author Fabien CAYRE (Computer)
	 *
	 * @date 16/04/2021
	 */
	private static final long serialVersionUID = -7460688875366432094L;

	/**
	 * L'inventaire du héros
	 */
	@Getter
	private Inventaire inventaire;
	/**
	 * La salle dans lequel il est présent
	 */
	@Getter
	@Setter
	private Salle salle;
	
	@Getter
	@Setter
	private Salle sallePrecedente;
	
	@Getter
	@Setter
	private int pieceOr;

	public Heros(String nom, int ptsVie, int ptsForce) {
		super(nom, ptsVie, ptsForce);
		this.inventaire = new Inventaire();
	}

	public Heros(TypeHeros typeHeros) {
		this(typeHeros.getPointDeVie(), typeHeros.getDegat());
	}

	public Heros(int ptsVie, int ptsForce) {
		this("_none", ptsVie, ptsForce);
	}
	
	public int getArmureTotal() {
		return 0;
	}
	
	public void ajouterPieceOr(int pieceOr) {
		this.pieceOr += pieceOr;
	}

	@Override
	public String toString() {
		return "Heros [salle=" + salle + ", nom=" + nom + ", ptsVie=" + ptsVie + ", ptsForce=" + ptsForce + "]";
	}
	

}
