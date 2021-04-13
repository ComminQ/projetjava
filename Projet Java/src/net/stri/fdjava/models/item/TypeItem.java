package net.stri.fdjava.models.item;

import java.lang.reflect.InvocationTargetException;

import lombok.Getter;
import net.stri.fdjava.models.item.properties.ProprietesButin;
import net.stri.fdjava.models.item.properties.ProprietesOffensive;

public enum TypeItem {

	CASQUE("Casque", 1, ProprietesOffensive.class),
	ARMURE("Armure", 1, ProprietesOffensive.class),
	EPEE("Epee", 1, ProprietesOffensive.class),
	PIECE("Piece", 1, ProprietesItem.class),
	BUTIN("Butin", 3, ProprietesButin.class);

	@Getter
	private String nom;
	@Getter
	private int quantiteMax;
	
	private Class<? extends ProprietesItem> propriete;

	private TypeItem(String nom, int qteMax, Class<? extends ProprietesItem> propriete) {
		this.nom = nom;
		this.propriete = propriete;
		this.quantiteMax = qteMax;
	}

	public ProprietesItem genererProprietes(Item item) {
		try {
			return this.propriete.getConstructor().newInstance();
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
