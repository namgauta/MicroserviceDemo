package com.practice;

public class DijkstraST {

	public int minIndex(int s[],boolean v[]) {
		int minI=-1,minVal=Integer.MAX_VALUE;
		for(int i=0;i<9;i++) {
			if(v[i]==false && s[i]<minVal) {
				minVal=s[i];
				minI=i;
			}
		}
		return minI;
	}
	public void dijkstra(int[][] g, int src) {
		int s[]=new int[9];
		boolean v[]=new boolean[9];
		for(int i=0;i<9;i++) {
			s[i]=Integer.MAX_VALUE;
		}
		s[src]=0;
		for(int i=0;i<9;i++) {
			int u=minIndex(s,v);
			v[u]=true;
			for(int w=0;w<9;w++) {
				if(s[u]!=Integer.MAX_VALUE && v[w]==false && g[u][w]+s[u]<s[w] && g[u][w]!=0) {
					s[w]=g[u][w]+s[u];
				}
			}
		}
		printSoln(s);
		
	}
	public void printSoln(int[] s) {
		for(int i=0;i<9;i++) {
			System.out.println(i+"->"+s[i]);
		}
	}
	public static void main(String[] args) {
		int graph[][] = new int[][]{
			{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
            {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
            {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
            {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
            {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
            {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
            {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
            {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
            {0, 0, 2, 0, 0, 0, 6, 7, 0} 
           }; 
           DijkstraST t = new DijkstraST(); 
           t.dijkstra(graph, 0);
	}

	
}
