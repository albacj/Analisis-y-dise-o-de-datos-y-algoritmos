package us.lsi.ag;

import java.util.List;

public interface BagChromosome {
	/**
	 * @return La secuencia decodificada seg�n la informaci�n en el cromosoma
	 */
	List<Integer> decode();
	
	/**
	 * @return La secuencia de �ndices normal
	 */
	List<Integer> getNormalSequence();
	
	/**
	 * @return Un cromosoma elegido aleatoriamente para formar parte de la problaci�n inicial
	 */
//	Chromosome getInitialChromosome();
		
}
