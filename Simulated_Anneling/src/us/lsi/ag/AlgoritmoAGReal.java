package us.lsi.ag;

import org.apache.commons.math3.genetics.BinaryMutation;
import org.apache.commons.math3.genetics.Chromosome;


public class AlgoritmoAGReal<S> extends AlgoritmoAG<Integer> {
	
	public AlgoritmoAGReal(ProblemaAGReal<S> problema) {
		super(problema);
		super.mutationPolicy = new BinaryMutation();
	}
	
	@Override
	public Chromosome getInitialChromosome() {
		return RealBinaryChromosome.getInitialChromosome();
	}
}
