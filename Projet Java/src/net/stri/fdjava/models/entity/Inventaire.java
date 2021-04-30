package net.stri.fdjava.models.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import net.stri.fdjava.models.item.Item;

/**
 * Représente une liste d'item (inventaire)
 * 
 * 
 * @author Fabien CAYRE (Computer)
 *
 * @date 30/04/2021
 */
public class Inventaire implements Serializable {

	/**
	 * @author Fabien CAYRE (Computer)
	 *
	 * @date 16/04/2021
	 */
	private static final long serialVersionUID = 6189475061361357276L;

	private List<Item> item;
	@Getter
	private int maxItem;
	
	
	//TODO reste a faire : tout

}
