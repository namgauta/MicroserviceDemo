package com.practice;
class A{
	A(){
		printaa();
	}
	 void printaa() {
		System.out.println("pppp1");
	}
}
public class B extends A{
B(){
	printaa();
}
 void printaa() {
	System.out.println("pppp2");
}
 void aa() {
	 System.out.println("1234");
 }
public static void main(String[] args) {
	A a=new B();
	((B) a).aa();
}
}
