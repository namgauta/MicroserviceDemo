package com.practice;

import java.io.IOException;

//Team-1 Module
//---------------------------------------

class Module1 {
	public void m() throws ArithmeticException {
		System.out.println("Module-1 :: m()");
		throw new ArithmeticException(" i hate u"); // unchecked exception
	}
}

//---------------------------------------

//Team-2 Module
//---------------------------------------

class Module2 {
	public void m() throws ArithmeticException {
		Module1 module1 = new Module1();
		module1.m();
		System.out.println("Module-2 :: m()");
	}
}

//---------------------------------------

public class First {

	public static void main(String[] args) {

		try {
			Module2 module2 = new Module2();
			module2.m();
		} catch (Exception e) {
			System.out.println("Im handling in main()");
			e.printStackTrace();
		}
	}

}
