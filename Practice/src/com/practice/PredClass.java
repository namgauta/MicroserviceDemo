package com.practice;

import java.util.function.Predicate;

public class PredClass {
	public static void main(String[] args) {

		Predicate<String> p1=s->true;
		Predicate<String> p2=s->false;
		Predicate<String> p3=s->true;
		Predicate<String> p4=p1.and(p2.or(p3));
		Predicate<String> p5=p2.or(p3).and(p1);
		System.out.println(p5.test("a"));
		
	}




}
