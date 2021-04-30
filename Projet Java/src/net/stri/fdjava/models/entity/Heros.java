package net.stri.fdjava.models.entity;

import lombok.Getter;
import lombok.Setter;
import net.stri.fdjava.models.world.Salle;

public class Heros extends Entity {

	/**
	 * @author Fabien CAYRE (Computer)
	 *
	 * @date 16/04/2021
	 */
	private static final long serialVersionUID = -7460688875366432094L;

	@Getter
	private Inventaire inventaire;
	@Getter
	@Setter
	private Salle salle;

	public Heros(String nom, int ptsVie, int ptsForce) {
		super(nom, ptsVie, ptsForce);
	}

	public Heros(TypeHeros typeHeros) {
		this(typeHeros.getPointDeVie(), typeHeros.getDegat());
	}

	public Heros(int ptsVie, int ptsForce) {
		super("_none", ptsVie, ptsForce);
	}

	@Override
	public String toString() {
		return "Heros [salle=" + salle + ", nom=" + nom + ", ptsVie=" + ptsVie + ", ptsForce=" + ptsForce + "]";
	}

}
