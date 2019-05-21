package us.lsi.common;

import java.util.Set;

import us.lsi.stream.Stream2;


public class Sets2 {

	public static Set<Integer> newSet(Integer a, Integer b, Integer c){
		return Stream2.create(Stream2.range(a, b, c).boxed()).toSet();
	}	
	
	public static Set<Integer> newSet(Integer a, Integer b){
		return Stream2.create(Stream2.range(a, b, 1).boxed()).toSet();
	}
}
