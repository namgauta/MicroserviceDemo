package com.practice;

public class MT1 {
	static int c=0;
	public static void main(String[] args) {
		Object key=new Object();
		
		Runnable o=()->{
			synchronized(key) {
				for(int i=0;i<10;i++){
					
					if(c==0) {
						try {
							key.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(i%2==1) {
						System.out.println(i);
						c=0;
						key.notifyAll();
					}
					
				}
			}
		};
		Runnable e=()->{
			synchronized(key) {
				for(int i=0;i<10;i++){
					
					if(c==1) {
						try {
							key.wait();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if(i%2==0) {
						System.out.println(i);
						c=1;
						key.notifyAll();
					}
					
				}
			}
		};
		Thread t1=new Thread(o);

		Thread t2=new Thread(e);
		t1.start();
		t2.start();
	}

}
