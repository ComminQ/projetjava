package net.stri.fdjava.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import net.stri.fdjava.models.item.Item;
import net.stri.fdjava.models.item.UsineItem;

public class ItemTest {
	
	
	@Test
	public void testEqualItemSameInstance() {
		Item item1 = UsineItem.creerEpee("Epée de test", 1500);
		Item item2 = item1;
		assertEquals(true, item1.equals(item2));
	}
	
	@Test
	public void testEqualItemClone() {
		Item item1 = UsineItem.creerEpee("Epée de test", 1500);
		Item item2 = item1.clone();
		assertEquals(true, item1.equals(item2));
	}
	
	@Test
	public void testEqualItem() {
		Item item1 = UsineItem.creerEpee("Epée de test", 1500);
		Item item2 = UsineItem.creerEpee("Epée de test2", 1500);
		assertEquals(false, item1.equals(item2));
	}

}
