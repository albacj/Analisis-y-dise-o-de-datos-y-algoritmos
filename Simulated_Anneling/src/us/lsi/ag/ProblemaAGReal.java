package us.lsi.ag;

import java.util.List;

import us.lsi.common.Par;

/**
 * @author Miguel Toro
 *
 * @param <S> Tipo de la soluci�n
 */
public interface ProblemaAGReal<S> extends ProblemaAG {
	
	/**
	 * @return N�mero de variables
	 */
	Integer getNumeroDeVariables(); 
	
	/**
	 * @return N�mero de bits para representar cada variable
	 */
	Integer getItemsPorVariable(); 
	
	/**
	 * @return L�mites para cada variable
	 */
	List<Par<Double,Double>> getLimites();
	
	/**
	 * @param ls Lista de valores de las variables
	 * @pre ls.size() == getNumeroDeVariables()
	 * @return Fitness del cromosoma
	 */
	Double fitnessFunction(List<Double> ls);
	
	/**
	 * @param chromosome Es un cromosoma
	 * @return La soluci�n definida por el cromosoma
	 */
	S getSolucion(RealBinaryChromosome chromosome);
	
}
