package net.stri.fdjava.models.entity;

import java.util.List;

import lombok.Getter;
import net.stri.fdjava.models.item.Item;

public class Inventaire {
	
	 private List<Item> item;
	 @Getter
	 private int maxItem;
	
}
