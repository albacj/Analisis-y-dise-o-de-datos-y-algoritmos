package es.lsi.practica02.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import es.lsi.practica02.Busqueda;
import es.lsi.practica02.AcmeBay.AcmeBayDataAccess;
import es.lsi.practica02.AcmeBay.Producto;

public class MedirBusquedaProducto {

	public static void main(String[] args) {
		/**
		 * Repeticiones
		 */
		int rep = 15;

		/**
		 * Tamaños de los problemas a probar Elegir o crear uno que mejor se
		 * adeque a la máquina en el que lo ejecutamos.
		 */
		//Integer[] tams= new
		//Integer[]{100,200,300,400,500,600,700,800,900,1000};
		// Integer[] tams = new Integer[] { 1000, 2000, 3000, 4000, 5000, 6000,
		// 7000, 8000, 9000, 10000 };
		// Integer[] tams= new
		// Integer[]{10000,20000,30000,40000,50000,60000,70000,80000,90000,100000};
		Integer[] tams = new Integer[] { 100000, 1000, 10000, 60000, 110000,
				160000, 210000, 260000, 310000, 360000, 410000, 460000, 510000,
				560000, 610000 };

		List<Float> tiempos = new ArrayList<Float>();
		List<Float> tiemposBS = new ArrayList<Float>();

		for (Integer tam : tams) {
			List<Producto> productos = AcmeBayDataAccess.getData(tam);
			Random r = new Random();
			Float precioReferencia = productos.get(
					Math.abs(r.nextInt()) % productos.size()).getPrecio();

			// Ejecutará el problema rep veces y se quedará con los valores
			// medios
			float timeAcum = 0;
			float timeAcumBS = 0;
			long timeMilis;
			for (int i = 1; i <= rep; i++) {
				timeMilis = System.currentTimeMillis();
				Busqueda.busca(productos, precioReferencia);
				timeMilis = System.currentTimeMillis() - timeMilis;
				timeAcum += (timeMilis / 100d);

				timeMilis = System.currentTimeMillis();
				Busqueda.buscaBS(productos, 0, productos.size(),
						precioReferencia);
				timeMilis = System.currentTimeMillis() - timeMilis;
				timeAcumBS += (timeMilis / 100d);

			}
			timeAcum = Math.round(1000 * (timeAcum / (float) rep)) / 1000f;

			timeAcumBS = Math.round(1000 * (timeAcumBS / (float) rep)) / 1000f;

			System.out.println(tam + " - Java 8: " + (float) timeAcum
					+ " , BS: " + (float) timeAcumBS);

			tiempos.add(timeAcum);
			tiemposBS.add(timeAcumBS);

		}

		imprimirFormatoWolfram(tams, tiempos.toArray());
		imprimirFormatoWolfram(tams, tiemposBS.toArray());
	}

	/**
	 * Imprime las xs y las yx en formato WolframAlpha con la función plot()
	 * Podrá copiarse su contenido y ser pasado directamente a la web de
	 * WolframAlpha
	 * 
	 * @param xs
	 * @param ys
	 */
	public static void imprimirFormatoWolfram(Object[] xs, Object[] ys) {
		if (xs.length != ys.length) {
			throw new IllegalArgumentException(
					"No se corresponden el numero de objetos en la cordenada x ("
							+ xs.length + ") y en la y (" + ys.length
							+ ").\nxs: " + xs + ".\nys: " + ys);
		}

		System.out.println("\n\nWolframAlpha format:");

		System.out.print("ListPlot[{");
		for (int i = 0; i < xs.length - 1; i++) {
			System.out.print("{" + xs[i] + "," + ys[i] + "},");
		}
		System.out.print("{" + xs[xs.length - 1] + "," + ys[xs.length - 1]
				+ "}");
		System.out.print("}]");
	}

}
