import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {
	Main main = new Main();
	
	@Test
	public void testValorA() {
		int[] Bi = {};
		int[] Ci = {};
		char resp = main.verImpedimento(1, 2, Bi, Ci);
		assertEquals(resp,'A');
	}
	
	@Test
	public void testValorB() {
		int[] Bi = {};
		int[] Ci = {};
		char resp = main.verImpedimento(2, 12, Bi, Ci);
		assertEquals(resp,'D');
	}
	
	@Test
	public void testUmDefensor() {
		int[] Bi = {200, 400};
		int[] Ci = {100};
		char resp = main.verImpedimento(2, 1, Bi, Ci);
		assertEquals(resp,'Y');
	}
	
	@Test
	public void testAtacanteProximo() {
		int[] Bi = {200, 400};
		int[] Ci = {200, 1000};
		char resp = main.verImpedimento(2, 2, Bi, Ci);
		assertEquals(resp,'Y');
	}
	
	@Test
	public void testMesmaDistPenultimo() {
		int[] Bi = {500, 700};
		int[] Ci = {1000, 500, 200};
		char resp = main.verImpedimento(2, 3, Bi, Ci);
		assertEquals(resp,'N');
	}
	
	@Test
	public void testAtacanteLonge() {
		int[] Bi = {530, 510, 490};
		int[] Ci = {480, 470, 50, 310};
		char resp = main.verImpedimento(2, 3, Bi, Ci);
		assertEquals(resp,'N');
	}
}
