////////////////////////////////////////////////////////////////////
// [SIMONE] [FRANCONETTI] [1143567]
////////////////////////////////////////////////////////////////////
package it.unipd.tos;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.unipd.tos.business.TakeAwayBillImpl;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;

public class TakeAwayBillTest {

	@Test
	public void test_getOrderPrice_OverSize() {
		List<MenuItem> order = new ArrayList<MenuItem>();
		for(int i = 0; i < 31; i++) {
			order.add(new MenuItem(MenuItem.itemType.PANINI,"Primavera",5.50));
		}
		TakeAwayBillImpl bill = new TakeAwayBillImpl();
		try {
			bill.getOrderPrice(order);
		}
		catch (TakeAwayBillException e){
			System.out.println("error");
		}
	}
	
	@Test
	public void test_getOrderPrice_DiscountPriceFor5Panini() {
		List<MenuItem> order = new ArrayList<MenuItem>();
		order.add(new MenuItem(MenuItem.itemType.BEVANDE,"Coca-cola",2.50));
		order.add(new MenuItem(MenuItem.itemType.FRITTI,"Olive Ascolane",2.50));
		for(int i = 0; i < 5; i++) {
			order.add(new MenuItem(MenuItem.itemType.PANINI,"Vegetariano",5.50));
		}
		order.add(new MenuItem(MenuItem.itemType.PANINI,"Primavera",1.0));
		TakeAwayBillImpl bill = new TakeAwayBillImpl();
		try {
			assertEquals(33,bill.getOrderPrice(order),1E-10);
		}
		catch (TakeAwayBillException e){
			System.out.println("error2");
		}
	}
	
	@Test
	public void test_getOrderPrice_TotalPriceLessThan10() {
		List<MenuItem> order = new ArrayList<MenuItem>();
		order.add(new MenuItem(MenuItem.itemType.FRITTI,"Olive Ascolane",5.0));
		order.add(new MenuItem(MenuItem.itemType.FRITTI,"Olive Ascolane",4.0));
		TakeAwayBillImpl bill = new TakeAwayBillImpl();
		try {
			assertEquals(9.5,bill.getOrderPrice(order),1E-10);
		}
		catch(TakeAwayBillException e) {
			System.out.println("error3");
		}	
	}
	
	@Test
	public void test_getOrderPrice_DiscountPriceOver50Euros() {
		List<MenuItem> order = new ArrayList<MenuItem>();
		for(int i = 0; i < 30; i++) {
			order.add(new MenuItem(MenuItem.itemType.PANINI,"Primavera",5.0));
		}
		TakeAwayBillImpl bill = new TakeAwayBillImpl();
		try {
			assertEquals(132.75,bill.getOrderPrice(order),1E-10);
		}
		catch(TakeAwayBillException e) {
			System.out.println("error4");
		}
	}
}