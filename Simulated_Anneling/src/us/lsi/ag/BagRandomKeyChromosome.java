package us.lsi.ag;

import java.util.List;
import java.util.function.Function;

import org.apache.commons.math3.genetics.AbstractListChromosome;
import org.apache.commons.math3.genetics.InvalidRepresentationException;
import org.apache.commons.math3.genetics.RandomKey;

import com.google.common.base.Preconditions;

public class BagRandomKeyChromosome extends RandomKey<Integer> implements BagChromosome {

	public static Function<List<Integer>,Double> fitnessFunction;
	
	public BagRandomKeyChromosome(List<Double> representation)
			throws InvalidRepresentationException {
		super(representation);
		this.ft = this.calculateFt();
	}

	public BagRandomKeyChromosome(Double[] representation)
			throws InvalidRepresentationException {
		super(representation);
		this.ft = this.calculateFt();
	}

	@Override
	public AbstractListChromosome<Double> newFixedLengthChromosome(List<Double> ls) {
		return new BagRandomKeyChromosome(ls);
		
	}

	@Override
	public List<Integer> decode() {
		Preconditions.checkArgument(AlgoritmoAGRandomKey.normalSequence!=null);
		return this.decode(AlgoritmoAGRandomKey.normalSequence);
	}

	@Override
	public List<Integer> getNormalSequence() {
		return AlgoritmoAGRandomKey.normalSequence;
	}
	
	
	public static BagRandomKeyChromosome getInitialChromosome() {
		List<Double> ls = RandomKey.randomPermutation(AlgoritmoAG.DIMENSION);
		return new BagRandomKeyChromosome(ls);
	}

	
	@Override
	public double fitness() {
		return ft;
	}
	
	private double ft;
	
	private double calculateFt(){
		return BagRandomKeyChromosome.fitnessFunction.apply(this.decode());
	}
}