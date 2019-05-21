package us.lsi.sa.anuncios;

import us.lsi.algoritmos.Algoritmos;
import us.lsi.sa.AlgoritmoSA;
import us.lsi.us.anuncios.ListaDeAnunciosAEmitir;
import us.lsi.us.anuncios.ProblemaAnuncios;

public class TestAnunciosSA {

	public static void main(String[] args) {
		
		ProblemaAnuncios.leeYOrdenaAnuncios("files/anuncios2.txt");
		ProblemaAnuncios.tiempoTotal = 30;
		AlgoritmoSA.temperaturaInicial = 10000;
		AlgoritmoSA.alfa = 0.98;
		AlgoritmoSA.numeroDeIteracionesPorIntento = 400;
		AlgoritmoSA.numeroDeIteracionesALaMismaTemperatura = 20;
		AlgoritmoSA.numeroMaximoDeIntentos = 4;
		AlgoritmoSA<EstadoAnunciosSA, ListaDeAnunciosAEmitir, AlternativaAnuncios> ap = Algoritmos
				.createSA(ProblemaAnunciosSA.create());
		ap.ejecuta();
		System.out.println("Lista de anuncions disponibles ------");
		System.out.println(ProblemaAnuncios.todosLosAnunciosDisponibles);
		System.out.println("Restricciones ------");
		System.out.println(ProblemaAnuncios.restricciones);
		System.out.println("------");
		System.out.println("Soluciones ------");
		for (ListaDeAnunciosAEmitir s : ap.soluciones) {
			System.out.println("Solucion =  " + s);
		}
		System.out.println("------");
		System.out.println("------");
		System.out.println(ap.mejorSolucionGlobalObtenida.getSolucion());
		System.out.println(ProblemaAnuncios.tiempoTotal);
	}
}
