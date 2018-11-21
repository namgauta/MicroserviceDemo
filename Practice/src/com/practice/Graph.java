package com.practice;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	int V;
	LinkedList<Integer> adjList[];
	public Graph(int v) {
		this.V=v;
		adjList=new LinkedList[v];
		for(int i=0;i<v;i++) {
			adjList[i]=new LinkedList<Integer>();
		}
	}
	public void addEdge(int src,int dst) {
		adjList[src].add(dst);
	}
	public void BFS(int src) {
		boolean visit[]=new boolean[this.V];
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(src);
		visit[src]=true;
		while(!q.isEmpty()) {
			int t=q.poll();
			
			System.out.print(t+"->");
			Iterator<Integer> it=adjList[t].iterator();
			while(it.hasNext()) {
				int temp=it.next();
				if(visit[temp]==false) {
					q.add(temp);
					visit[temp]=true;
				}
			}
		}
	}
	public void DFS(int src,boolean v[]) {
//		if(v[src]==true) {
//			return;
//		}
		System.out.print(src+"->");
		v[src]=true;
		Iterator<Integer> it=adjList[src].iterator();
		while(it.hasNext()) {
			int t=it.next();
			if(v[t]==false) {
//				v[t]=true;
				DFS(t, v);
			}
		}
	}
	public static void main(String[] args) {
		Graph g = new Graph(4); 
		  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3);
        boolean v[]=new boolean[4];
        System.out.println("BFS");
        g.BFS(0);
        System.out.println();
        System.out.println("DFS");
        g.DFS(0, v);
	}
}
