package us.lsi.ag;

import java.util.List;

public interface BagChromosome {
	/**
	 * @return La secuencia decodificada según la información en el cromosoma
	 */
	List<Integer> decode();
	
	/**
	 * @return La secuencia de índices normal
	 */
	List<Integer> getNormalSequence();
	
	/**
	 * @return Un cromosoma elegido aleatoriamente para formar parte de la problación inicial
	 */
//	Chromosome getInitialChromosome();
		
}
