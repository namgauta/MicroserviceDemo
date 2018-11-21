package com.practice;

public class Graph1 {

	int V,E;
	Edge edge[];
	public static class Edge implements Comparable<Edge>{
		int src,dst,wt;

		@Override
		public int compareTo(Edge e) {
			return this.wt-e.wt;
		}
	}
	public Graph1(int v,int e) {
		this.V=v;
		this.E=e;
		edge=new Edge[e];
		for(int i=0;i<e;i++) {
			edge[i]=new Edge();
		}
	}
	public static void main(String[] args) {
		Graph1 graph=new Graph1(4,5);
		graph.edge[0].src = 0; 
        graph.edge[0].dst = 1; 
        graph.edge[0].wt = 10; 
  
        // add edge 0-2 
        graph.edge[1].src = 0; 
        graph.edge[1].dst = 2; 
        graph.edge[1].wt = 6; 
  
        // add edge 0-3 
        graph.edge[2].src = 0; 
        graph.edge[2].dst = 3; 
        graph.edge[2].wt = 5; 
  
        // add edge 1-3 
        graph.edge[3].src = 1; 
        graph.edge[3].dst = 3; 
        graph.edge[3].wt = 15; 
  
        // add edge 2-3 
        graph.edge[4].src = 2; 
        graph.edge[4].dst = 3; 
        graph.edge[4].wt = 4; 
	}
}
