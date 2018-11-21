package com.practice;

public class OddEven {

	static int c=1;
	static Object lock=new Object();
	public static void main(String[] args) {
		Runnable odd=()->{
			synchronized (lock) {
				for(int i=1;i<10;i++) {
					if(c==1) {
						System.out.println(i);c=0;
						lock.notifyAll();
					}else {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		};
		Runnable even=()->{
			synchronized (lock) {
				for(int j=2;j<=10;j++) {
					if(c==0) {
						System.out.println(j);c=1;
						lock.notifyAll();
					}else {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		};
		Thread o=new Thread(odd);
		Thread e=new Thread(even);
		o.start();
		e.start();
	} 
}
