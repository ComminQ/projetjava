package net.stri.fdjava.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import net.stri.fdjava.models.entity.Inventaire;
import net.stri.fdjava.models.item.Item;
import net.stri.fdjava.models.item.TypeItem;

public class InventaireTest {

	@Test
	public void testSize() {
		Inventaire inventaire = new Inventaire();
		assertEquals(Inventaire.DEFAULT_SIZE, inventaire.getMaxItem());
	}

	@Test
	public void testCustomSize() {
		Inventaire inventaire = new Inventaire(10);
		assertEquals(10, inventaire.getMaxItem());
	}

	@Test
	public void testGetItem() {
		Inventaire inventaire = new Inventaire();
		Item item = new Item(TypeItem.TEST);
		item.setQuantite(999);
		inventaire.ajouterObjet(item);
		assertEquals("Test", inventaire.getObjet(0).getProprietesItem().getNom());
		assertEquals(999, inventaire.getObjet(0).getQuantite());
	}

	@Test
	public void testAddItem() {
		Inventaire inventaire = new Inventaire();

		Item item = new Item(TypeItem.TEST);
		item.setQuantite(999);

		inventaire.ajouterObjet(item);

		Item item2 = new Item(TypeItem.TEST);
		item2.setQuantite(1);

		inventaire.ajouterObjet(item2);

		assertEquals("Test", inventaire.getObjet(0).getProprietesItem().getNom());
		assertEquals(1000, inventaire.getObjet(0).getQuantite());

	}

	@Test
	public void testAddItemOverflow() {
		Inventaire inventaire = new Inventaire();

		Item item = new Item(TypeItem.TEST);
		item.setQuantite(999);

		inventaire.ajouterObjet(item);

		Item item2 = new Item(TypeItem.TEST);
		item2.setQuantite(2);

		inventaire.ajouterObjet(item2);

		assertEquals("Test", inventaire.getObjet(0).getProprietesItem().getNom());
		assertEquals(1000, inventaire.getObjet(0).getQuantite());
		assertEquals("Test", inventaire.getObjet(1).getProprietesItem().getNom());
		assertEquals(1, inventaire.getObjet(1).getQuantite());
	}

	@Test
	public void testRemoveItem() {
		Inventaire inventaire = new Inventaire();

		Item item = new Item(TypeItem.TEST);
		item.setQuantite(999);

		inventaire.ajouterObjet(item);

		Item item2 = new Item(TypeItem.TEST);
		item2.setQuantite(1);

		inventaire.retirerObjet(item2);

		assertEquals("Test", inventaire.getObjet(0).getProprietesItem().getNom());
		assertEquals(998, inventaire.getObjet(0).getQuantite());
	}

	@Test
	public void testQuantite() {
		Inventaire inventaire = new Inventaire();

		Item item = new Item(TypeItem.TEST);
		item.setQuantite(999);

		Item item2 = new Item(TypeItem.TEST);
		item2.setQuantite(999);

		Item item3 = new Item(TypeItem.ARMURE);
		item3.setQuantite(1);

		inventaire.ajouterObjet(item);
		inventaire.ajouterObjet(item2);
		inventaire.ajouterObjet(item3);

		assertEquals(1998, inventaire.quantite(TypeItem.TEST));
		assertEquals(1, inventaire.quantite(TypeItem.ARMURE));
	}

}
