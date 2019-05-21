package us.lsi.sa.anuncios;


public class AlternativaAnuncios {
	
	public enum Opcion {Insertar, Eliminar/*, Intercambiar*/}
	

	public Opcion opcion;
	public Integer p1;
	public Integer p2;
	
	public static AlternativaAnuncios createInsertar(Integer p1,Integer p2) {
		
		return new AlternativaAnuncios(Opcion.Insertar, p1, p2);
	}
	
	public static AlternativaAnuncios createEliminar(Integer p1) {
		//TODO
	}
	private AlternativaAnuncios(Opcion opcion, Integer p1, Integer p2) {
		//TODO
	}
		

	@Override
	public String toString() {
		return "AlternativaAnuncios [opcion=" + opcion + ", p1=" + p1 + ", p2="
				+ p2 + "]";
	}
}
