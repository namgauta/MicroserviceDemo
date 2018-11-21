package com.practice;

public class abc {
	
public static void main(String[] args)  {

	String a=new String("Ram");
	String b=("Ram");
	System.out.println(System.identityHashCode(b));
	System.out.println(System.identityHashCode(a));
	System.out.println(a==b);
	a=a.intern();
	System.out.println(System.identityHashCode(a));
//	b=b.intern();
	System.out.println(a==b);
	a=a.intern();
}
}
