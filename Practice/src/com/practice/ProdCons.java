package com.practice;

public class ProdCons {

	public static Object lock=new Object();
	public static int buffer[];
	public static int capacity;
	public static int curr=-1;
	public static class Consumer{
		
		public void consumer() {
			synchronized (lock) {
				if(curr<0) {
					try {
						System.out.println(curr);
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					buffer[curr--]=0;
					lock.notify();
				}
			}
		}
	}
    public static class Producer{
		
    	public void produce() {
    		synchronized (lock) {
				if(curr<capacity-1 ) {
					buffer[++curr]=1;
					lock.notify();
				}else {
					try {
						System.out.println(curr);
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
    	}
	}
    public static void main(String[] args) {
		capacity=10;
		buffer=new int[capacity];
		Producer prod=new Producer();
		Consumer con=new Consumer();
		Runnable p=()->{
			for(int i=0;i<50;i++)
			prod.produce();
		};
		Runnable c=()->{
			for(int i=0;i<50;i++)
			con.consumer();
		};
		Thread p1=new Thread(p);
		Thread c1=new Thread(c);
		p1.start();
		c1.start();
		try {
//			p1.join();
			c1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
