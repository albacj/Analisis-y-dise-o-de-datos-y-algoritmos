package es.lsi.practica02.AcmeBay;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AcmeBayDataAccess {

	/**
	 * precio m�ximo de los productos en el sistema
	 */
	public static float MAX_PRECIO = 100000;

	/**
	 * Milisegundos de espera de cada m�todo.
	 */
	static int SLEEP_TIME = 0;

	/**
	 * Recupera {@link numProductos} del sistema de informaci�n de AcmeBay. Los
	 * productos recuperados estar�n ordenados por el precio de menor a mayor.
	 * Estos productos se generar�n de manera aleatoria.
	 * 
	 * @param numProductos
	 *            el n�mero de productos que se quieren recuperar
	 * @return Una lista <b>ordenada</b> con {@link numProductos} productos del
	 *         almacen de AcmeBay
	 */
	public static List<Producto> getData(int numProductos) {
		// TODO: F�jese en la implementaci�n dada para la creaci�n de nuevos
		// productos aleatorios a trav�s de un Supplier
		Random random = new Random();
		Supplier<Producto> randomProductoSupplier = () -> new Producto(
				Producto.getReferenciaAleatoria(), random.nextFloat()
						* MAX_PRECIO);

		return Stream.generate(randomProductoSupplier).limit(numProductos)
				.sorted().collect(Collectors.toList());
	}

}
