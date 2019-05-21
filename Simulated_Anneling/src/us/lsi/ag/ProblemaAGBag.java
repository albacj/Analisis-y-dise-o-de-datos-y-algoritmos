package us.lsi.ag;

import java.util.List;

/**
 * @author Miguel Toro
 *
 * @param <S> Tipo de la soluci�n
 */
public interface ProblemaAGBag<S> extends ProblemaAG {
		
	/**
	 * @pos El tama�o de la lista devuelta es igual a getDimension()
	 * @return La secuencia de �ndices normal
	 */
	List<Integer> getNormalSequence();	
	
	/**
	 * @param ls Lista de �ndices del cromosoma
	 * @pre ls.size() == getDimension()
	 * @return Fitness del cromosoma
	 */
	Double fitnessFunction(List<Integer> ls);
	
	/**
	 * @param chromosome Es un cromosoma
	 * @return La soluci�n definida por el cromosoma
	 */
	S getSolucion(BagChromosome chromosome);
}
