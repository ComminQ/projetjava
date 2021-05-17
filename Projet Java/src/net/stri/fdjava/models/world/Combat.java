package net.stri.fdjava.models.world;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import net.stri.fdjava.models.entity.Heros;
import net.stri.fdjava.models.entity.Monstre;

public class Combat {

	@Getter
	private Heros heros;
	@Getter
	private List<Monstre> monstres;

	public Combat(Heros heros, Monstre... monstres) {
		this(heros, new ArrayList<>(Arrays.asList(monstres)));
	}

	public Combat(Heros heros, List<Monstre> monstres) {
		super();
		this.heros = heros;
		this.monstres = monstres;
	}

	public int getNombreMonstres() {
		return this.monstres.size();
	}

	public int herosAttaque() {
		if (getNombreMonstres() > 0) {
			return herosAttaque(0);
		} else {
			throw new IllegalAccessError("L'héros attaque alors qu'il n'y a plus de monstre");
		}
	}

	public int monstreAttaque() {
		if (getNombreMonstres() > 0) {
			return monstreAttaque(0);
		} else {
			throw new IllegalAccessError("Il n'y a plus de monstre");
		}
	}
	
	public int herosAttaque(int numeroMonstre) {
		if (numeroMonstre >= getNombreMonstres()) {
			throw new IllegalArgumentException("");
		}
		Monstre monstre = this.monstres.get(numeroMonstre);
		return this.heros.attaquer(monstre);
	}
	
	public int monstreAttaque(int numeroMonstre) {
		if (numeroMonstre >= getNombreMonstres()) {
			throw new IllegalArgumentException("");
		}
		Monstre monstre = this.monstres.get(numeroMonstre);
		return monstre.attaquer(this.heros);
	}

	public void tuer(int m) {
		this.monstres.remove(m);
	}
	
	public void tuer(Monstre m) {
		this.monstres.remove(m);
	}

}
