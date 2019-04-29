package com.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountAllPossiblePath {

	private int V;
	private List<Integer>[] adjList;

	public CountAllPossiblePath(int V) {
		this.V = V;
		this.adjList = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
	}

	public void addEdge(int src, int dest) {
		adjList[src].add(dest);
	}
	
	public int countPaths(int s, int d){
		boolean[] visited=new boolean[V];
		Arrays.fill(visited, false);
		int pathCount=0;
		pathCount=countPathUtil(s, d, pathCount, visited);
		return pathCount;
	}
	
	public int countPathUtil(int s, int d, int pathCount, boolean[] visited){
		visited[s]=true;
		if(s==d){
			pathCount++;
		}
		for(int i: adjList[s]){
			if(visited[i]!=true){
				
				pathCount=countPathUtil(i,d,pathCount,visited);
			}
		}
		visited[s]=false;
		return pathCount;
	}

	public static void main(String[] args) {
		CountAllPossiblePath g = new CountAllPossiblePath(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(2, 0);
		g.addEdge(2, 1);
		g.addEdge(1, 3);

		int s = 2, d = 3;
		System.out.println(g.countPaths(s, d));

	}

}
