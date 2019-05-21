package es.lsi.practica02.test;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import es.lsi.practica02.Busqueda;
import es.lsi.practica02.AcmeBay.AcmeBayDataAccess;
import es.lsi.practica02.AcmeBay.Producto;

public class BusquedaTest {

	Float mayor, menor;
	List<Producto> l;
	Busqueda busqueda;

	@Before
	public void setUp() throws Exception {
		l = AcmeBayDataAccess.getData(100);
	}

	@Test
	public void testBusquedaSimple() {
		menor = AcmeBayDataAccess.MAX_PRECIO / 4;
		mayor = AcmeBayDataAccess.MAX_PRECIO * 3 / 4;
		List<Producto> res = Busqueda.buscaRangoPrecio(menor, mayor, l);
		comprobarLista(res);
	}

	@Test
	public void testBusquedaSimpleExtremo1() {
		menor = 0f;
		mayor = AcmeBayDataAccess.MAX_PRECIO / 2;

		List<Producto> res = Busqueda.buscaRangoPrecio(menor, mayor, l);
		comprobarLista(res);
	}

	@Test
	public void testBusquedaSimpleExtremo2() {
		menor = AcmeBayDataAccess.MAX_PRECIO / 2;
		mayor = AcmeBayDataAccess.MAX_PRECIO;

		List<Producto> res = Busqueda.buscaRangoPrecio(menor, mayor, l);
		comprobarLista(res);
	}

	@Test
	public void testBusquedaPreciosEntre() {
		menor = AcmeBayDataAccess.MAX_PRECIO / 2;
		mayor = AcmeBayDataAccess.MAX_PRECIO;

		List<Float> res = Busqueda.buscaPreciosEntre(menor, mayor, l);
		for (Float p : res) {
			assertTrue("El precio del producto con precio" + p
					+ " debería estar en el rango [" + menor + ", " + mayor
					+ "), sin embargo no es así",
					p.compareTo(menor) >= 0 && p.compareTo(mayor) < 0);
		}
	}

	@Test
	public void testAplicaIVA() {
		List<Producto> res = Busqueda.aplicaIVAPrecio(l, 21f);
		for (int i = 0; i < res.size(); i++) {
			assertTrue(
					"El precio del producto " + l.get(i)
							+ " con IVA debería ser " + l.get(i).getPrecio()
							* (1f + 21f / 100f) + ", sin embargo es "
							+ res.get(i).getPrecio(),
					res.get(i).getPrecio()
							.equals(l.get(i).getPrecio() * (1f + 21f / 100f)));
		}
	}

	@Test
	public void testValorAlmacen() {
		Float totalReal = 0f;
		for (Producto p : l) {
			totalReal += p.getPrecio();
		}

		Float total = Busqueda.valorTotalAlmacen(l);
		assertTrue("El valor total del almacén es " + total
				+ ", mientras que en realidad debería ser " + totalReal,
				total.equals(totalReal));
	}

	void comprobarLista(List<Producto> res) {

		for (Producto p : res) {
			assertTrue("El producto " + p + " tiene un precio " + p.getPrecio()
					+ " que no es mayor o igual que " + menor + " y menor "
					+ mayor + ".", p.getPrecio() >= menor
					&& p.getPrecio() < mayor);

		}
	}

	@Test
	public void testBusquedaAvanzada() {
		mayor = AcmeBayDataAccess.MAX_PRECIO * 3 / 4;
		Optional<Producto> res = Busqueda.buscaBS(l, 0, l.size() - 1, mayor);
		assertTrue(
				"",
				res.get().getPrecio()
						.equals(Busqueda.busca(l, mayor).get().getPrecio()));
	}

	@Test
	public void testBusquedaAvanzadaExtremo1() {
		mayor = AcmeBayDataAccess.MAX_PRECIO / 2;
		Optional<Producto> res = Busqueda.buscaBS(l, 0, l.size() - 1, mayor);
		assertTrue(
				"",
				res.get().getPrecio()
						.equals(Busqueda.busca(l, mayor).get().getPrecio()));
	}

	@Test
	public void testBusquedaAvanzadaExtremo2() {
		mayor = AcmeBayDataAccess.MAX_PRECIO;
		Optional<Producto> res = Busqueda.buscaBS(l, 0, l.size() - 1, mayor);
		assertTrue("", res.equals(Busqueda.busca(l, mayor)));
	}

}
