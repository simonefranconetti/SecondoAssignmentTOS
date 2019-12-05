////////////////////////////////////////////////////////////////////
// [SIMONE] [FRANCONETTI] [1143567]
////////////////////////////////////////////////////////////////////
package it.unipd.tos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.unipd.tos.business.exception.TakeAwayBillException;

public class TakeAwayBillExceptionTest {

	@Test
	public void testGetMessage() {
		TakeAwayBillException exc = new TakeAwayBillException("error");
		assertEquals("error",exc.getMessage());
	}
}