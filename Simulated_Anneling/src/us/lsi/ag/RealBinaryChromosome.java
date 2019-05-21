package us.lsi.ag;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.apache.commons.math3.genetics.AbstractListChromosome;
import org.apache.commons.math3.genetics.BinaryChromosome;
import org.apache.commons.math3.genetics.InvalidRepresentationException;

import us.lsi.common.Par;

public class RealBinaryChromosome extends BinaryChromosome {

	public static Integer numeroDeVariables = null;
	public static Integer itemsPorVariable = null;
	public static List<Par<Double,Double>> limites = null;
	private static Double fact = null;
	public static Function<List<Double>,Double> fitnessFunction;
	
	public RealBinaryChromosome(Integer[] representation) throws InvalidRepresentationException {
		super(representation);
		this.ft = this.calculateFt();
	}

	public RealBinaryChromosome(List<Integer> representation) throws InvalidRepresentationException {
		super(representation);
		this.ft = this.calculateFt();
	}
	
	private Double getFact() {
		if(fact==null){
			fact = (double) (Math.pow(2,itemsPorVariable)-1);
		}
		return fact;
	}

	@Override
	public AbstractListChromosome<Integer> newFixedLengthChromosome(List<Integer> ls) {
		return new RealBinaryChromosome(ls);
	}
	
	public List<Double> decode() {
		List<Integer> ls = super.getRepresentation();
		List<Double> r = new ArrayList<Double>();
		for(int i = 0; i< numeroDeVariables; i++){
			int index1 = i*itemsPorVariable;
			int index2 = index1+itemsPorVariable;
			Double e = RealBinaryChromosome.decode(ls.subList(index1, index2));
			Double x = limites.get(i).p1;
			Double y = limites.get(i).p2;
			Double d = x+(y-x)*e/this.getFact();
//			System.out.println(x+","+y+","+e+","+this.getFact());
			r.add(d);
		}
		return r;
	}

	private static  Double decode(List<Integer> ls){
		Double r = 0.;
		for(Integer e:ls){
			r = r*2+e;
		}
		return r;
	}
	
	
	public List<Integer> getRepresentation(){
		return super.getRepresentation();
	}
	
	public static RealBinaryChromosome getInitialChromosome() {
		List<Integer> ls = BinaryChromosome.randomBinaryRepresentation(AlgoritmoAG.DIMENSION);
		return new RealBinaryChromosome(ls);
	}

	@Override
	public double fitness() {
		return ft;
	}
	
	private double ft;
	
	private double calculateFt(){
		return RealBinaryChromosome.fitnessFunction.apply(this.decode());
	}
}
