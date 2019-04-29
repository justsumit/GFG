package com.ds.graph;

import java.util.ArrayList;
import java.util.List;

public class MotherVertex {
	
	private int V;
	private List<Integer>[] adjList;
	
	public MotherVertex(int V) {
		// TODO Auto-generated constructor stub
		this.V=V;
		this.adjList=new ArrayList[V];
		
		for(int i=0;i<V;i++){
			adjList[i]= new ArrayList<>();
		}
	}
	
	public void addEdge(int src, int dest){
		adjList[src].add(dest);
	}
	
	public int findMotherVertex(){
		boolean[] visited = new boolean[V];
		for(int i=0; i<V;i++){
			visited[i]=false;
		}
		
		int lastFinishedVertex=-1;
		for(int i=0; i<V;i++){
			if(visited[i]==false){
				visited[i]=true;
				dfsUtil(i, visited);
				lastFinishedVertex=i;
			}
			
		}
		return lastFinishedVertex;
	}
	
	public void dfsUtil(int src, boolean[] visited){
		for(int i : adjList[src]){
			if(visited[i]==false){
				visited[i]=true;
				dfsUtil(i, visited);
			}
		}
		
	}

	public static void main(String[] args) {
		
		MotherVertex g= new MotherVertex(7);
 
		g.addEdge(0, 1); 
	    g.addEdge(0, 2); 
	    g.addEdge(1, 3); 
	    g.addEdge(4, 1); 
	    g.addEdge(6, 4); 
	    g.addEdge(5, 6); 
	    g.addEdge(5, 2); 
	    g.addEdge(6, 0); 

		
		System.out.println("Mother Vertex: " + g.findMotherVertex());
		
	}
	
	

}
