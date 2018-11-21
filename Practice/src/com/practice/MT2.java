package com.practice;

public class MT2 {

	public static Object lock=new Object();
	public int buffer[];
	public int count;
	public Object key=new Object();
	static class Producer{
		void produce() {
			synchronized (lock) {
				
			}
		}
	}
}
