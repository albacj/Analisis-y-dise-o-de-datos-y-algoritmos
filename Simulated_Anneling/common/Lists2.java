package us.lsi.common;

import java.lang.reflect.Array;
import java.util.*;

import us.lsi.stream.Stream2;

import com.google.common.collect.*;
import com.google.common.base.*;

public class Lists2 {
	
	public static <E1,E2> List<Par<E1,E2>> cartesianProduct(List<E1> lista1, List<E2> lista2){
		List<Par<E1,E2>> lp = Lists.newLinkedList();
		for(E1 e1: lista1){
			for(E2 e2:lista2){
				lp.add(Par.create(e1, e2));
			}
		}
		return lp;
	}
	
	@SuppressWarnings("unchecked")
	public static <E> E[] toArray(List<E> lis){
		Preconditions.checkArgument(lis!=null && !lis.isEmpty(), "La lista no puede ser vacía ni null");	
		Class<E> type = (Class<E>) lis.get(0).getClass();
		return lis.stream().toArray((int x)->(E[])Array.newInstance(type, x));
	}

	public static <E> void intercambia(List<E> lista, int i, int j){
		int size = lista.size();
		Preconditions.checkPositionIndex(i, size);
		Preconditions.checkPositionIndex(j, size);
		E aux;
		aux = lista.get(i);
		lista.set(i, lista.get(j));
		lista.set(j, aux);
	}

	public static <T> void intercambia(T[] ls, int i, int j){
		int size = ls.length;
		Preconditions.checkPositionIndex(i, size);
		Preconditions.checkPositionIndex(j, size);
		T aux = ls[i];
		ls[i] = ls[j];
		ls[j] = aux;
	}
	
	public static <T> List<T> nCopias(int n, T a){
	    List<T> v = new ArrayList<T>();
	    for(int i=0;i<n;i++){
	       v.add(a);
	    }
	    return v;
	}

	public static List<Integer> newList(Integer a, Integer b){
		return Lists2.newList(a, b, 1);
	}

	public static List<Integer> newList(Integer a, Integer b, Integer c){
		return Stream2.create(Stream2.range(a, b, c).boxed()).toList();
	}
	
	public static List<Double> newList(Double a, Double b){
		Preconditions.checkArgument(a<=b);
		List<Double> s = Lists.newArrayList();
		for(double i = a; i<b; i++){
			s.add(i);
		}
		return s;
	}

	public static List<Double> newList(Double a, Double b, Double c){
		Preconditions.checkArgument(a<=b  && c>0);
		List<Double> s = Lists.newArrayList();
		for(double i = a; i<b; i=i+c){
			s.add(i);
		}
		return s;
	}
	
	
	
}

