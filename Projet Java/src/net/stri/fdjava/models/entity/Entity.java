package net.stri.fdjava.models.entity;

import java.util.Map;

import lombok.Getter;
import net.stri.fdjava.models.item.Item;

public abstract class Entity {

	@Getter
	private Map<Emplacement, Item> equipement;
	
}
