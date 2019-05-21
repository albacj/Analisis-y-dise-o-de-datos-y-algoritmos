package us.lsi.ag;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import org.apache.commons.math3.genetics.Chromosome;
import org.apache.commons.math3.genetics.FixedGenerationCount;
import org.apache.commons.math3.genetics.Population;
import org.apache.commons.math3.genetics.StoppingCondition;
import com.google.common.collect.Lists;

import us.lsi.stream.Stream2;

/**
 * <p> Implementa una condición de parada que se cumple cuando se encuentran <code> numBestChromosomes </code> cromosomas
 * que cumplan un  <code> predicate </code> o el número de generaciones es mayor o igual
 * que <code> AlgoritmoAG.NUM_GENERATIONS</code>  </p>
 * <p> También acumula una lista, en la propiedad 
 * <code> AlgoritmoAG.BestChromosomes </code> que guarda los mejores <code> numBestChromosomes </code> 
 * distintos de cada generación.</p>
 * <p> La propiedad <code> predicate </code> debe ser inicializada desde el problema concreto a resolver
 * 
 * @author Miguel Toro
 *
 */
public class SolutionsNumber implements StoppingCondition {

	public static Predicate<Chromosome> predicate =null;
	private Integer ns;
	private FixedGenerationCount fixed;
	public SolutionsNumber(Integer numBestChromosomes, Integer NUM_GENERATIONS) {
		super();
		this.ns = numBestChromosomes;
		AlgoritmoAG.BestChromosomes = Lists.newArrayList();
		this.fixed = new FixedGenerationCount(NUM_GENERATIONS);
		//Preconditions.checkNotNull(predicate);
	}

	@Override
	public boolean isSatisfied(Population population) {
		List<Chromosome> ls = Stream2
				.<Chromosome> fromUnmodifiableIterable(population)
				.sorted(Comparator.<Chromosome> reverseOrder())
				.distinct()
				.limit(ns)
				.toList();
		AlgoritmoAG.BestChromosomes.addAll(ls);
		boolean ret = fixed.isSatisfied(population);
		if (predicate != null)
			ret = ret || ls.stream().allMatch((Chromosome x) -> predicate.test(x));
		return ret;
	}

}
