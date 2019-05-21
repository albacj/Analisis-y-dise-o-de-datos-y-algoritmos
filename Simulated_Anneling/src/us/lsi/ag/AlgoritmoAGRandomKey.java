package us.lsi.ag;


import java.util.List;

import   org.apache.commons.math3.genetics.*;


/**
 * <p> Algoritmo específico para algoritmos genéticos con codificación real </p>
 * <p>Es adecaudo para resolver problemas que se representan por permutacionanes </p> 
 * <p>Los cromosomas que implementemos deben heredar de la clase 
 * <a href="http://commons.apache.org/proper/commons-math/apidocs/org/apache/commons/math3/genetics/RandomKey.html" target="_blank"> RandomKey </a>
 * </p>
 * 
 * 
 * @author Miguel Toro
 *
 * @param <S> Tipo de la solución
 */
public class AlgoritmoAGRandomKey<S> extends AlgoritmoAG<Double> {

	public static List<Integer> normalSequence = null;
	
	public AlgoritmoAGRandomKey(ProblemaAGBag<S> problema) {
		super(problema);
		super.mutationPolicy = new RandomKeyMutation();
	}
	
	@Override
	public Chromosome getInitialChromosome() {
		return BagRandomKeyChromosome.getInitialChromosome();
	}
	
}
