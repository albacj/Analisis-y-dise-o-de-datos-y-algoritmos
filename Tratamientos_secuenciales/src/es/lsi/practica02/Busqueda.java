package es.lsi.practica02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import es.lsi.practica02.AcmeBay.Producto;

public class Busqueda {

	/**
	 * Realiza una búsqueda empleando interfaces funcionales y la clase Stream
	 * sobre la lista de productos pasada por parámetros, determinando el primer
	 * producto cuyo precio es igual o superior al pasado por parámetro
	 * 
	 * @param l
	 *            lista de productos
	 * @param precio
	 *            Precio de referencia
	 * @return Primer producto cuyo precio está por encima del precio de
	 *         referencia
	 */
	public static Optional<Producto> busca(List<Producto> l, Float precio) {
		Optional<Producto> p = Optional.empty();

		for(Producto producto: l) {
			if(producto.getPrecio() >= precio) {
				Optional<Producto> opt = Optional.of(new Producto(producto));
				p = opt;
				break;
			}
		}

		return p;
	}

	/**
	 * Realiza una búsqueda empleando un algoritmo de tipo divide y vencerás
	 * (búsqueda binaria) sobre la lista de productos pasada por parámetros,
	 * determinando el primer producto cuyo precio es igual o superior al pasado
	 * por parámetro
	 * 
	 * @param l
	 *            lista de productos
	 * @param precio
	 *            Precio de referencia
	 * @param i
	 * @param j
	 * @return Primer producto cuyo precio está por encima del precio de
	 *         referencia
	 */
	public static Optional<Producto> buscaBS(List<Producto> l, int i, int j,
			Float precio) {
		Optional<Producto> ret = Optional.empty();

		// TODO

		return ret;
	}

	/**
	 * Busca linealmente el elemento menor, anterior a i, que tiene el mismo
	 * precio
	 * 
	 * @param l
	 *            lista de productos
	 * @param i
	 *            posicion en la que hay un producto con ese precio
	 * @param precio
	 *            precio del producto
	 * @return posicion del elemento menor con el mismo precio
	 */
	private static Producto atras(List<Producto> l, int i, Float precio) {
		for (; i > 0 && l.get(i - 1).getPrecio().equals(precio); i--)
			;
		return l.get(i);
	}

	/**
	 * Devuelve la lista con los productos de l cuyos precios estén comprendidos
	 * entre [precioMenor y precioMayor)
	 * 
	 * @param precioMenor
	 *            valor inferior del rango (incluido)
	 * @param precioMayor
	 *            valor superior del rango (sin incluir)
	 * @param l
	 *            lista de productos
	 * @return Sublista de l
	 */
	public static List<Producto> buscaRangoPrecio(Float precioMenor,
			Float precioMayor, List<Producto> l) {

		List<Producto> subLista = new ArrayList<Producto>();
		Collections.sort(l, (p1, p2) -> p1.getPrecio().compareTo(p2.getPrecio()));
		
		for(Producto p: l) {
			if(p.getPrecio() >= precioMenor && p.getPrecio() <= precioMayor) {
				subLista.add(p);
			}
		}
		
		return subLista;
	}

	/**
	 * Devuelve la lista con los precios de los productos de l cuyos precios
	 * estén comprendidos entre [precioMenor y precioMayor)
	 * 
	 * @param precioMenor
	 *            valor inferior del rango (incluido)
	 * @param precioMayor
	 *            valor superior del rango (sin incluir)
	 * @param l
	 *            lista de productos
	 * @return Precio de los productos que cumplen la restricción
	 */
	public static List<Float> buscaPreciosEntre(Float precioMenor,
			Float precioMayor, List<Producto> l) {

		List<Float> precios = new ArrayList<Float>();
		List<Producto> productos = buscaRangoPrecio(precioMayor, precioMayor, l);
		
		for(Producto p: productos) {
			precios.add(p.getPrecio());
		}
		
		return precios;
	}

	/**
	 * Aplica el porcentaje de IVA indicado por parámetro a todos los productos
	 * de la colección.
	 * 
	 * @param l
	 *            Lista con los productos originales
	 * @param iva
	 *            Porcentaje de IVA a aplicar sobre los precios originales
	 * @return Lista de productos con los precios modificados aplicando el IVA
	 */
	public static List<Producto> aplicaIVAPrecio(List<Producto> l, Float iva) {
		List<Producto> res = cloneListaProductos(l);

		for(Producto p: res) {
			p.setPrecio(p.getPrecio() * (1f + iva / 100f));
		}
		
		return res;
	}

	/**
	 * Calcula el valor total del almacén a partir de la lista de productos.
	 * Esto es, la suma total de los precios de los diferentes productos
	 * 
	 * @param l
	 *            Listado de productos en el almacén
	 * @return Valor total de los productos
	 */
	public static Float valorTotalAlmacen(List<Producto> l) {
		// TODO
		return null;
	}

	private static List<Producto> cloneListaProductos(List<Producto> l) {
		List<Producto> res = new ArrayList<Producto>();
		l.stream().forEach(p -> res.add(new Producto(p)));
		return res;
	}
}
