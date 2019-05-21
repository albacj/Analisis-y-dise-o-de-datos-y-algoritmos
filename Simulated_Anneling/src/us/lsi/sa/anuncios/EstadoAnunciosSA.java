package us.lsi.sa.anuncios;


import java.util.List;

import us.lsi.common.ParInteger;
import us.lsi.math.Math2;
import us.lsi.sa.EstadoSA;
import us.lsi.us.anuncios.ListaDeAnunciosAEmitir;
import us.lsi.us.anuncios.ProblemaAnuncios;

public class EstadoAnunciosSA implements EstadoSA<EstadoAnunciosSA,ListaDeAnunciosAEmitir,AlternativaAnuncios>{
	
	public static EstadoAnunciosSA create(EstadoAnunciosSA e) {
		return new EstadoAnunciosSA(ListaDeAnunciosAEmitir.create(e.lista));
	}
	
	public static EstadoAnunciosSA create(ListaDeAnunciosAEmitir lista) {
		return new EstadoAnunciosSA(lista);
	}

	public static EstadoAnunciosSA create() {
		return new EstadoAnunciosSA(ListaDeAnunciosAEmitir.create());
	}
	
	private ListaDeAnunciosAEmitir lista;

	private EstadoAnunciosSA(ListaDeAnunciosAEmitir lista) {
		super();
		this.lista = ListaDeAnunciosAEmitir.create(lista);
	}

	@Override
	public EstadoAnunciosSA next(AlternativaAnuncios a) {
		// TODO
	}
	

	@Override
	public AlternativaAnuncios getAlternativa() {
		// TODO
		List<AlternativaAnuncios.Opcion> ls = lista.getTiposDeOpcionesAlternativasPosibles();
		AlternativaAnuncios.Opcion op;
		AlternativaAnuncios a = null;
		int e;
		if(ls.size()==1){
			e = 0;
		} else if(ls.size() == 2){
			e = Math2.escogeEntre(0.5,0.5);
		}
		
		//TODO
		
		
		return a;
	}
	
	@Override
	public ListaDeAnunciosAEmitir getSolucion() {
		return lista;
	}

	@Override
	public boolean condicionDeParada() {
		return false;
	}

	@Override
	public double getObjetivo() {
		return -lista.getValor();
	}

	@Override
	public EstadoAnunciosSA copia() {
		return EstadoAnunciosSA.create(this);
	}

	@Override
	public boolean esSolucion(ListaDeAnunciosAEmitir s) {
		return true;
	}
	
	@Override
	public String toString() {
		return "EstadoAnunciosSA [lista=" + lista + "]";
	}	
}
