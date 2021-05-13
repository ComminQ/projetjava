package net.stri.fdjava.models.entity.monstre;

import java.io.Serializable;

import net.stri.fdjava.models.entity.Monstre;

public class MortVivant extends Monstre implements Serializable {

	public MortVivant() {
		super("Mort-Vivant", 150, 25);
	}

}
