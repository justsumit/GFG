package com.ds.graph;

import java.util.ArrayList;
import java.util.List;

public class KCoreGraph {
	
	private int V;
	private List<Integer>[] adjList;
	
	public KCoreGraph(int V) {
		this.V=V;
		this.adjList=new ArrayList[V];
		for(int i=0; i<V;i++){
			adjList[i]=new ArrayList<>();
		}
	}
	
	public void addEdge(int src, int dest){
		adjList[src].add(dest);
		adjList[dest].add(src);
		
	}
	
	
	public void printKCoreGraph(int k){
		
	
	}
	
	public boolean dfsUtil(int src,int k,int[] degree,boolean[] visited){
		return false;
	}

	public static void main(String[] args) {
		KCoreGraph g1= new KCoreGraph(9);
		int k=3;
	    g1.addEdge(0, 1); 
	    g1.addEdge(0, 2); 
	    g1.addEdge(1, 2); 
	    g1.addEdge(1, 5); 
	    g1.addEdge(2, 3); 
	    g1.addEdge(2, 4); 
	    g1.addEdge(2, 5); 
	    g1.addEdge(2, 6); 
	    g1.addEdge(3, 4); 
	    g1.addEdge(3, 6); 
	    g1.addEdge(3, 7); 
	    g1.addEdge(4, 6); 
	    g1.addEdge(4, 7); 
	    g1.addEdge(5, 6); 
	    g1.addEdge(5, 8); 
	    g1.addEdge(6, 7); 
	    g1.addEdge(6, 8); 
	    g1.printKCoreGraph(k); 
	  

	  
		KCoreGraph g2= new KCoreGraph(9);
	    g2.addEdge(0, 1); 
	    g2.addEdge(0, 2); 
	    g2.addEdge(0, 3); 
	    g2.addEdge(1, 4); 
	    g2.addEdge(1, 5); 
	    g2.addEdge(1, 6); 
	    g2.addEdge(2, 7); 
	    g2.addEdge(2, 8); 
	    g2.addEdge(2, 9); 
	    g2.addEdge(3, 10); 
	    g2.addEdge(3, 11); 
	    g2.addEdge(3, 12); 
		g2.printKCoreGraph(3);

	}

}
