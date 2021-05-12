package net.stri.fdjava.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.Getter;
import net.stri.fdjava.models.item.Item;
import net.stri.fdjava.models.item.TypeItem;

/**
 * Représente une liste d'item (inventaire)
 * 
 * 
 * @author Fabien CAYRE (Computer)
 *
 * @date 30/04/2021
 */
public class Inventaire implements Serializable {

	private static final int DEFAULT_SIZE = 9;

	/**
	 * @author Fabien CAYRE (Computer)
	 *
	 * @date 16/04/2021
	 */
	private static final long serialVersionUID = 6189475061361357276L;

	private List<Item> item;
	@Getter
	private int maxItem;

	public Inventaire() {
		this(DEFAULT_SIZE);
	}

	public Inventaire(int maxItem) {
		this.maxItem = maxItem;
		this.item = new ArrayList<>(maxItem);
	}

	public boolean ajouterObjet(Item item) {
		if (this.item.size() >= maxItem) return false;
		int amount = item.getQuantite();
		final int maxQuantity = item.getType().getQuantiteMax();
		
		List<Integer> list = indexDeType(item.getType(), true);
		if(list.size() == 0) {
			this.item.add(item);
			return true;
		}else {
			for(int index : list) {
				Item currItem = this.item.get(index);
				int currAmount = currItem.getQuantite();
				int diffAmount = maxQuantity - currAmount;
				
				if(diffAmount > amount) {
					currAmount += amount;
					amount = 0;
					currItem.setQuantite(currAmount);
				}else {
					currAmount += diffAmount;
					amount -= diffAmount;
					currItem.setQuantite(currAmount);
					if(amount == 0) {
						break;
					}
				}
			}
			if(amount > 0) {
				item.setQuantite(amount);
			}
			return true;
		}
	}

	public boolean retirerObjet(Item item) {
		int quantityToRemove = item.getQuantite();
		TypeItem type = item.getType();
		
		
		return false;
	}

	public void retirerObjet(int index) {
		this.item.remove(index);
	}

	/**
	 * Retourne la liste des index des items du même type que le paramètre
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @param type
	 * @return
	 * @date 12/05/2021
	 */
	public List<Integer> indexDeType(TypeItem type, boolean ignoreWhenFull) {
		return IntStream
			.range(0, this.item.size())
			.filter(i -> {
				if (item.get(i) == null) return false;
				if (item.get(i).getType() != type) return false;
				return ignoreWhenFull ? item.get(i).getQuantite() == type.getQuantiteMax() : true;
			})
			.boxed()
			.collect(Collectors.toList());
	}

	public void vider() {
		this.item.clear();
	}

	public Item getObjet(int index) {
		return this.item.get(index);
	}

}
