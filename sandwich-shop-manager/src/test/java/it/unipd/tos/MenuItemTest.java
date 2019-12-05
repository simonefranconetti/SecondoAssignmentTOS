////////////////////////////////////////////////////////////////////
// [SIMONE] [FRANCONETTI] [1143567]
////////////////////////////////////////////////////////////////////
package it.unipd.tos;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import it.unipd.tos.model.MenuItem;

public class MenuItemTest {
	
	@Test
	public void testGetType() {
		MenuItem item = new MenuItem(MenuItem.itemType.PANINI,"Vegetariano",7.77);
		assertEquals(MenuItem.itemType.PANINI,item.getType());
	}
	
	@Test
	public void testGetPrice() {
		MenuItem item = new MenuItem(MenuItem.itemType.PANINI,"Vegetariano",7.77);
		assertEquals(7.77,item.getPrice(),1e-15);
	}
	
	@Test
	public void testGetName() {
		MenuItem item = new MenuItem(MenuItem.itemType.PANINI,"Vegetariano",7.77);
		assertEquals("Vegetariano",item.getName());
	}
	
}
