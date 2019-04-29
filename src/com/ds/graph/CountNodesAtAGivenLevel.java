package com.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountNodesAtAGivenLevel {
	
	private int V;
	private List<Integer>[] adjList;
	
	public CountNodesAtAGivenLevel(int V){
		this.V=V;
		this.adjList=new ArrayList[V];
		for(int i=0; i<V;i++){
			adjList[i]=new ArrayList<>();
		}
	}
	
	public void addEdge(int src, int dest){
		adjList[src].add(dest);
	}
	
	public void countNodesAtAGivenLevel(int l){
		boolean[] visited=new boolean[V];
		for(int i=0; i<V;i++){
			visited[i]=false;
		}
		
		int[] level=new int[V];
		Queue<Integer> q= new LinkedList<>();
		q.add(0);
		level[0]=0;
		
		int elem;
		while(!q.isEmpty()){
			elem=q.poll();
			
			if(!visited[elem]==true){
				visited[elem]=true;
			}
			
			for(int i: adjList[elem]){
				System.out.println(elem + " " + i);
				if(!visited[i]==true){
					visited[i]=true;
					q.add(i);
					level[i]=level[elem] +1;
				}
			}
		}
		int count=0;
		for(int i=0; i<V; i++){
			if(level[i]==l){
				count++;
			}
		}
		
		System.out.println("No. of nodes at the given level::" + l + "=" + count);
	}

	public static void main(String[] args) {
		CountNodesAtAGivenLevel g = new CountNodesAtAGivenLevel(6);
		g.addEdge(0, 1); 
	    g.addEdge(0, 2); 
	    g.addEdge(1, 3); 
	    g.addEdge(2, 4); 
	    g.addEdge(2, 5); 
	  
	    int level = 2; 
	    g.countNodesAtAGivenLevel(level);
	}

}
