package net.stri.fdjava.models.entity.monstre;

import java.io.Serializable;

import net.stri.fdjava.models.entity.Monstre;

public class Boss extends Monstre implements Serializable{

	public Boss() {
		super("Boss", 350, 20);
	}

}
