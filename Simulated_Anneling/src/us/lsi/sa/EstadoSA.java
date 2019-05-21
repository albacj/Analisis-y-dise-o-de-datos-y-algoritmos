package us.lsi.sa;

/**
 * 
 * <p>La documentaci�n puede encontarse en el: <a href="../../../document/Tema16.pdf" target="_blank">Tema16</a></p>
 * 
 * @author Miguel Toro
 *
 * @param <E> Tipo del Estado 
 * @param <S> Tipo de la soluci�n del problema
 * @param <A> Tipo de las alternativas
 */
public interface EstadoSA<E extends EstadoSA<E,S,A>,S,A> {	
	/**
	 * @param a - Alternativa elegida
	 * @return Siguiente estado si se escoge la alternativa a
	 */
	E next(A a);	
	/**
	 * @return La alternativa escogida en el estado actual. 
	 */
	A getAlternativa();
	/**
	 * @return Soluci�n del problema calculada a partir del estado actual
	 */
	S getSolucion();
	/**
	 * La condici�n de parada establece cuando se parar� el algortimo. Esta condici�n se puede establecer a partir
	 * de la propiedades fijadas para el algortimo: n�mero de soluciones encontradas, n�mero de iteraciones, 
	 * valor de la funci�n objetivo, etc.
	 * 
	 * @return Si se cumple la condici�n del parada del algortimo.
	 */
	boolean condicionDeParada();
	/**
	 * @return Valor de la propiedad a minimizar
	 */
	double getObjetivo(); 
	/**
	 * @return Una copia del estado 
	 */
	E copia();
	/**
	 * @param s En un valor del tipo S
	 * @return Si s es una solcui�n del problema
	 */
	boolean esSolucion(S s);
}
