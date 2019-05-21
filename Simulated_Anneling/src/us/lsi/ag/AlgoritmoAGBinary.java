package us.lsi.ag;

import java.util.List;

import   org.apache.commons.math3.genetics.*;


/**
 * <p> Algoritmo específico para algoritmos genéticos con codificación binaria </p>
 * <p> Son adecaudos para resolver problemas que buscan subconjuntos de un multiconjunto o conjuntos de valores que puedan
 * ser codificados mediante una lista de bits. Un caso concreto es el de los números reales o productos cartesianos 
 * de los mismos</p>
 * <p> Los cromosomas que implementemos deben heredar de la clase 
 * <a href="http://commons.apache.org/proper/commons-math/apidocs/org/apache/commons/math3/genetics/BinaryChromosome.html" target="_blank"> BinaryChromosome </a>
 * 
 * 
 * @author Miguel Toro
 *
 * @param <S> Tipo de la solución
 */
public class AlgoritmoAGBinary<S> extends AlgoritmoAG<Integer> {
	
	
	public static List<Integer> normalSequence = null;
	
	public AlgoritmoAGBinary(ProblemaAGBag<S> problema) {
		super(problema);
		super.mutationPolicy = new BinaryMutation();		
	}

	@Override
	public Chromosome getInitialChromosome() {
		return BagBinaryChromosome.getInitialChromosome();
	}
	
	
}
