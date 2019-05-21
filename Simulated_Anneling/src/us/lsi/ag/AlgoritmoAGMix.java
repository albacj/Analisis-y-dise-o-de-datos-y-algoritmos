package us.lsi.ag;

import java.util.List;

import org.apache.commons.math3.genetics.Chromosome;


/**
 * <p> Algoritmo específico para resolver problemas que buscan permutaciones de subconjuntos de un multiconjunto </p>
 * <p> Los cromosomas que implementemos deben heredar de la clase {@link us.lsi.ag.AlgoritmoAGMix AlgoritmoAGMix} </p>
 * 
 * 
 * 
 * @author Miguel Toro
 *
 * @param <S> Tipo de la solución
 */

public class AlgoritmoAGMix<S> extends AlgoritmoAG<Double> {

	public static List<Integer> normalSequence = null;
	
	public AlgoritmoAGMix(ProblemaAGBag<S> problema) {
		super(problema);
		super.mutationPolicy = new MixMutationPolicy();
		super.crossOverPolicy = new MixCrossoverPolicy(super.crossOverPolicy);
 	}
	
	@Override
	public Chromosome getInitialChromosome() {
		return BagMixChromosome.getInitialChromosome();
	}
}
