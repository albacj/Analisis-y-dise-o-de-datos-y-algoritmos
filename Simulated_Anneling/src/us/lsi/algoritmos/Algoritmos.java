package us.lsi.algoritmos;

import us.lsi.ag.AlgoritmoAGBinary;
import us.lsi.ag.AlgoritmoAGMix;
import us.lsi.ag.AlgoritmoAGRandomKey;
import us.lsi.ag.AlgoritmoAGReal;
import us.lsi.ag.BagBinaryChromosome;
import us.lsi.ag.BagMixChromosome;
import us.lsi.ag.BagRandomKeyChromosome;
import us.lsi.ag.ProblemaAGBag;
import us.lsi.ag.ProblemaAGReal;
import us.lsi.ag.RealBinaryChromosome;
import us.lsi.pl.AlgoritmoPL;
import us.lsi.pl.AlgoritmoPLI;
import us.lsi.pl.ProblemaPL;
import us.lsi.sa.AlgoritmoSA;
import us.lsi.sa.EstadoSA;
import us.lsi.sa.ProblemaSA;

public class Algoritmos {
	
	/**
	 * @param <E> El tipo del estado
	 * @param <S> El tipo de la solución
	 * @param <A> El tipo de la alternativa
	 * @param p - Problema a resolver
	 * @return Algoritmo de Simulated Annealing para resolver el problema
	 */
	public static <E extends EstadoSA<E,S,A>,S,A> AlgoritmoSA<E,S,A> createSA(ProblemaSA<E,S,A> p) {
		return new AlgoritmoSA<E,S,A>(p);
	}
	
	
	/**<p> Algoritmo específico para algoritmos genéticos con números reales con codificación binaria.
	 *
	 * 
	 *
	 * @param <S> Tipo de la solución
	 * @param p Problema
	 * @return AlgoritmoAGReal
	 */
	
	public static <S> AlgoritmoAGReal<S> createAGReal(ProblemaAGReal<S> p) {
		RealBinaryChromosome.itemsPorVariable = p.getItemsPorVariable();
		RealBinaryChromosome.limites = p.getLimites();
		RealBinaryChromosome.numeroDeVariables = p.getNumeroDeVariables();
		RealBinaryChromosome.fitnessFunction = p::fitnessFunction;
		return new AlgoritmoAGReal<S>(p);
	}
	
	/**<p> Algoritmo específico para algoritmos genéticos con codificación binaria.
	 * Son adecuados para resolver problemas de subconjuntos de multiconjuntos 
	 * y aquellos otros donde el esapcio de búsqueda es un producto cartesiano de número reales.</p>
	 * Los cromosomas que implementemos deben heredar de la clase 
	 * <a href="http://commons.apache.org/proper/commons-math/apidocs/org/apache/commons/math3/genetics/BinaryChromosome.html" target="_blank"> BinaryChromosome </a>
	 * 
	 * 
	 *
	 * @param <S> Tipo de la solución
	 * @param p Problema
	 * @return AlgoritmoAGBinary
	 */
	
	public static <S> AlgoritmoAGBinary<S> createAGBinary(ProblemaAGBag<S> p) {
		AlgoritmoAGBinary.normalSequence = p.getNormalSequence();
		BagBinaryChromosome.fitnessFunction = p::fitnessFunction;
		return new AlgoritmoAGBinary<S>(p);
	}
	
	/**
	 * <p> Algoritmo específico para algoritmos genéticos con codificación real. 
	 * Son adecuados para resolver problemas que se representan por permutaciones </p>
	 * los cromosomas que implementemos deben heredar de la clase 
	 * <a href="http://commons.apache.org/proper/commons-math/apidocs/org/apache/commons/math3/genetics/RandomKey.html" target="_blank"> RandomKey </a>
	 * 
	 * 
	 *
	 * @param <S> Tipo de la solución
	 * @param p Problema
	 * @return AlgoritmoAGRandomKey
	 */
	public static <S> AlgoritmoAGRandomKey<S> createAGRandomKey(ProblemaAGBag<S> p) {			
		AlgoritmoAGRandomKey.normalSequence = p.getNormalSequence();
		BagRandomKeyChromosome.fitnessFunction = p::fitnessFunction;
		return new AlgoritmoAGRandomKey<S>(p);
	}
	
	/**
	 * <p> Algoritmo específico para algoritmos genéticos con mixta binaria y real. 
	 * Son adecuados para resolver problemas que se representan permutaciones de subconjuntos de los elementos de una lista. </p>
	 * los cromosomas que implementemos deben heredar de la clase que se indica.
	 * 
	 * 
	 *
	 * @param <S> Tipo de la solución
	 * @param p Problema
	 * @return AlgoritmoAGMix
	 */
	public static <S> AlgoritmoAGMix<S> createAGMix(ProblemaAGBag<S> p) {
		AlgoritmoAGMix.normalSequence = p.getNormalSequence();	
		BagMixChromosome.fitnessFunction = p::fitnessFunction;
		return new AlgoritmoAGMix<S>(p);
	}
	
	
	/**
	 * Los tipos involucrados pueden encontrarse en el paquete <a href="https://commons.apache.org/proper/commons-math/apidocs/org/apache/commons/math3/optim/linear/package-summary.html" target="_blank">Apache</a>
	 * 
	 * @param p  Problema de Programación Lineal
	 * @return Un algoritmo para resolver le conjunto de restricciones lineales con variables reales. 
	 * Ignora las declaraciones de varibles no reales y otros tipos de restrcciones distintas de  las lineales
	 */
	public static AlgoritmoPL createPL(ProblemaPL p) {
		return AlgoritmoPL.create(p);
	}
	
	/**
	 * Los tipos involucrados pueden encontrarse en el paquete <a href="https://commons.apache.org/proper/commons-math/apidocs/org/apache/commons/math3/optim/linear/package-summary.html" target="_blank">Apache</a>
	 * 
	 * @param p  Problema de Programación Lineal
	 * @param fichero  Un fichero para guardar las restricciones del problema
	 * @return Un algoritmo para resolver le conjunto de restricciones lineales
	 * Ignora las declaraciones de varibles no reales y otros tipos de restrcciones distintas de  las lineales
	 */
	public static AlgoritmoPL createPL(ProblemaPL p, String fichero) {
		return AlgoritmoPL.create(p,fichero);
	}
	
	
	/**
	 * Los tipos involucrados pueden encontrarse en el paquete <a href="http://lpsolve.sourceforge.net/5.5/" target="_blank">LpSolve</a>
	 * 
	 * @param fichero  Describe un problema de Programación Lineal
	 * @return Un algoritmo para resolver le conjunto de restricciones lineales, variables de tipo real, entero y binarias, 
	 * variables libres y semicontinuas y otros tipos de restricciones como las 
	 * <a href="http://en.wikipedia.org/wiki/Special_ordered_set" target="_blank">Sos</a>
	 * 
	 */
	public static AlgoritmoPLI createPLI(String fichero) {
		return AlgoritmoPLI.create(fichero);
	}
	
	/**
	 * Los tipos involucrados pueden encontrarse en el paquete <a href="http://lpsolve.sourceforge.net/5.5/" target="_blank">LpSolve</a>
	 * 
	 * @param p  Problema de Programación Lineal
	 * @param fichero  Fichero para guardar las restrcciones del problema
	 * @return Un algoritmo para resolver le conjunto de restricciones lineales con variables de tipo real, entero y binarias, 
	 * variables libres y semicontinuas y otros tipos de restricciones como las 
	 * <a href="http://en.wikipedia.org/wiki/Special_ordered_set" target="_blank">Sos</a>
	 * 
	 */
	public static AlgoritmoPLI createPLI(ProblemaPL p, String fichero) {
		return AlgoritmoPLI.create(p,fichero);
	}
}
