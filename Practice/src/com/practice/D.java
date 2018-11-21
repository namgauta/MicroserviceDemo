package com.practice;

@FunctionalInterface
public interface D{
	int disp(int v);
	static int disp1() {
		return 4;
	}
	default int disp2() {
		return 3;
	}
}