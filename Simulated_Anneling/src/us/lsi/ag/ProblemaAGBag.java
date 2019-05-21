package us.lsi.ag;

import java.util.List;

/**
 * @author Miguel Toro
 *
 * @param <S> Tipo de la solución
 */
public interface ProblemaAGBag<S> extends ProblemaAG {
		
	/**
	 * @pos El tamaño de la lista devuelta es igual a getDimension()
	 * @return La secuencia de índices normal
	 */
	List<Integer> getNormalSequence();	
	
	/**
	 * @param ls Lista de índices del cromosoma
	 * @pre ls.size() == getDimension()
	 * @return Fitness del cromosoma
	 */
	Double fitnessFunction(List<Integer> ls);
	
	/**
	 * @param chromosome Es un cromosoma
	 * @return La solución definida por el cromosoma
	 */
	S getSolucion(BagChromosome chromosome);
}
