package com.devops.dxc.devops;

import com.devops.dxc.devops.model.Dxc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("unit")
class UnitTests {

	@Test
	public void cuandoSueldoEs1000000Ahorro10000000RetiroEs1000000MetodoCalcula10() {
		Dxc dxc = new Dxc(10000000, 3400000);
		dxc.calculaRetiro();
		Assertions.assertEquals("387604", dxc.getRetiro());
		Assertions.assertEquals("9612396", dxc.getSaldo());
		Assertions.assertEquals("612396", dxc.getImpuesto());
	}

	@Test
	public void cuandoSueldoEs2000000Ahorro10000000RetiroEs8254690MetodoCalcula10() {
		Dxc dxc = new Dxc(10000000, 2000000);
		dxc.calculaRetiro();
		Assertions.assertEquals("825469", dxc.getRetiro());
		Assertions.assertEquals("9174531", dxc.getSaldo());
		Assertions.assertEquals("174531", dxc.getImpuesto());
	}

	@Test
	public void cuandoSueldoEs2700000Ahorro10000000RetiroEs635914MetodoCalcula10() {
		Dxc dxc = new Dxc(10000000, 2700000);
		dxc.calculaRetiro();
		Assertions.assertEquals("635914", dxc.getRetiro());
		Assertions.assertEquals("9364086", dxc.getSaldo());
		Assertions.assertEquals("364086", dxc.getImpuesto());
	}

	@Test
	public void cuandoSueldoEs3400000Ahorro10000000RetiroEs387604MetodoCalcula10() {
		Dxc dxc = new Dxc(10000000, 3400000);
		dxc.calculaRetiro();
		Assertions.assertEquals("387604", dxc.getRetiro());
		Assertions.assertEquals("9612396", dxc.getSaldo());
		Assertions.assertEquals("612396", dxc.getImpuesto());
	}

	@Test
	public void cuandoSueldoEs4700000Ahorro10000000RetiroEs19643MetodoCalcula10()  {
		Dxc dxc = new Dxc(10000000, 4700000);
		dxc.calculaRetiro();
		Assertions.assertEquals("19643", dxc.getRetiro());
		Assertions.assertEquals("9980357", dxc.getSaldo());
		Assertions.assertEquals("980357", dxc.getImpuesto());
	}

	@Test
	public void cuandoSueldoEs5100000Ahorro20000000RetiroEs705948MetodoCalcula10() throws Exception {
		Dxc dxc = new Dxc(20000000, 5100000);
		dxc.calculaRetiro();
		Assertions.assertEquals("705948", dxc.getRetiro());
		Assertions.assertEquals("19294052", dxc.getSaldo());
		Assertions.assertEquals("1294052", dxc.getImpuesto());
	}

	@Test
	public void cuandoSueldoEs6100000Ahorro20000000RetiroEs508958MetodoCalcula10() throws Exception {
		Dxc dxc = new Dxc(20000000, 6100000);
		dxc.calculaRetiro();
		Assertions.assertEquals("508958", dxc.getRetiro());
		Assertions.assertEquals("19491042", dxc.getSaldo());
		Assertions.assertEquals("1491042", dxc.getImpuesto());
	}
}
