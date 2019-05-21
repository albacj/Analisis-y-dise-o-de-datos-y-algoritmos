package us.lsi.sa.anuncios;


import us.lsi.sa.ProblemaSA;
import us.lsi.us.anuncios.ListaDeAnunciosAEmitir;
import us.lsi.us.anuncios.ProblemaAnuncios;


public class ProblemaAnunciosSA extends ProblemaAnuncios implements ProblemaSA<EstadoAnunciosSA,ListaDeAnunciosAEmitir,AlternativaAnuncios>{

	public static ProblemaAnunciosSA create() {
		
		return new ProblemaAnunciosSA();
	}

	private ProblemaAnunciosSA() {
		super();
	}
	
	@Override
	public EstadoAnunciosSA getEstadoInicial() {
		
		ListaDeAnunciosAEmitir anuncios = ListaDeAnunciosAEmitir.getSolucionVoraz();
		EstadoAnunciosSA estado = EstadoAnunciosSA.create(anuncios);
		estado.getSolucion();
		return estado;
	}
	
}
