package us.lsi.ag;

import java.util.List;
import java.util.function.Function;

import org.apache.commons.math3.genetics.AbstractListChromosome;
import org.apache.commons.math3.genetics.BinaryChromosome;
import org.apache.commons.math3.genetics.InvalidRepresentationException;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

public class BagBinaryChromosome extends BinaryChromosome implements BagChromosome {

	public static Function<List<Integer>,Double> fitnessFunction;
	
	public BagBinaryChromosome(List<Integer> representation)
			throws InvalidRepresentationException {
		super(representation);
		this.ft = this.calculateFt();
	}

	public BagBinaryChromosome(Integer[] representation)
			throws InvalidRepresentationException {
		super(representation);
		this.ft = this.calculateFt();
	}

	@Override
	public AbstractListChromosome<Integer> newFixedLengthChromosome(List<Integer> ls) {
		return new BagBinaryChromosome(ls);
	}

	/**
	 * @return Una lista de enteros obtenida permutando la secuencia normal (0, 1, 2, ..., r-1) filtrada para incluir 
	 * sólo los seleccionados por el cromosoma binario 
	 */
	@Override
	public List<Integer> decode() {
		List<Integer> secNormal = this.getNormalSequence();
		List<Integer> r = Lists.newArrayList();
		List<Integer> bn = this.getRepresentation();
		Preconditions.checkArgument(secNormal.size() == bn.size());
		for (int i = 0; i < secNormal.size(); i++) {
			if (bn.get(i) == 1) {
				r.add(secNormal.get(i));
			}
		}
		return r;
	}

	@Override
	public List<Integer> getNormalSequence() {
		return AlgoritmoAGBinary.normalSequence;
	}
	
	public static BagBinaryChromosome getInitialChromosome() {
		List<Integer> ls = BinaryChromosome.randomBinaryRepresentation(AlgoritmoAG.DIMENSION);
		return new BagBinaryChromosome(ls);
	}

	@Override
	public double fitness() {
		return ft;
	}
	
	private double ft;
	
	private double calculateFt(){
		return BagBinaryChromosome.fitnessFunction.apply(this.decode());
	}
}