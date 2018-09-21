package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

// Example scenarios for testing
//   Item("+5 Dexterity Vest", 10, 20));
//   Item("Aged Brie", 2, 0));
//   Item("Elixir of the Mongoose", 5, 7));
//   Item("Sulfuras, Hand of Ragnaros", 0, 80));
//   Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
//   Item("Conjured Mana Cake", 3, 6));

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_11() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(11, itemBrie.getQuality());
	}
    
	@Test
	public void testUpdateEndOfDay() {
		fail("Test not implemented");
	}
	
	@Test
	public void testUpdateEndOfDay_ElixirOfTheMongoose_Quality_7_6() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Elixir of the Mongoose", 5, 7) );
		store.updateEndOfDay();
		
		List<Item> items = store .getItems();
		Item itemElix = items.get(0);
		assertEquals(6, itemElix.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_ConjuredManaCake_SellIn_3_2() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", 3, 6) );
		store.updateEndOfDay();
		
		List<Item> items = store .getItems();
		Item itemCake = items.get(0);
		assertEquals(2, itemCake.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_ConjuredManaCake_datepassed_Quality_6_4() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", 0, 6) );
		store.updateEndOfDay();
		
		List<Item> items = store .getItems();
		Item itemCake = items.get(0);
		assertEquals(4, itemCake.getQuality());
	}
	@Test
	public void testUpdateEndOfDay_5DexterityVest_QualityNotNegative_0_0(){
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 1, 0) );
		store.updateEndOfDay();
		
		List<Item> items = store .getItems();
		Item itemDex = items.get(0);
		assertEquals(0, itemDex.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_SulfurasHandOfRagnaros_Quality_80_50() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros",0, 80));
		store.updateEndOfDay();
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		assertEquals(50, itemSulfuras.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_SulfurasHandOfRagnaros_Quality_47_47() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros",0, 47));
		store.updateEndOfDay();
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		assertEquals(47, itemSulfuras.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_SulfurasHandOfRagnaros_sell_2_2() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros",2, 47));
		store.updateEndOfDay();
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		assertEquals(2, itemSulfuras.getSellIn());
	}

	@Test
	public void testUpdateEndOfDay_BackstagePassesToConcert_Days15_QualityRaise2() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert",15, 10));
		store.updateEndOfDay();
		List<Item> items = store.getItems();
		Item itemTicket = items.get(0);
		assertEquals(11, itemTicket.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BackstagePassesToConcert_Days9_QualityRaise2() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert",9, 10));
		store.updateEndOfDay();
		List<Item> items = store.getItems();
		Item itemTicket = items.get(0);
		assertEquals(12, itemTicket.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BackstagePassesToConcert_Days4_QualityRaise2() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert",4, 10));
		store.updateEndOfDay();
		List<Item> items = store.getItems();
		Item itemTicket = items.get(0);
		assertEquals(13, itemTicket.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BackstagePassesToConcert_Days0_QualityRaise2() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert",0, 10));
		store.updateEndOfDay();
		List<Item> items = store.getItems();
		Item itemTicket = items.get(0);
		assertEquals(0, itemTicket.getQuality());
	}
}
