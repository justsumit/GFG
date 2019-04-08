package com.ds.graph;

import java.util.LinkedList;

public class DFS {

	public static void main(String args[]) {
		AdjacenyListGraph graph = new AdjacenyListGraph(GraphRepresentation.DIRECTED_GRAPH_TYPE,5);
		graph.init();
		graph.printGraph();
		dfsTraversal(graph, 2);

	}

	public static void dfsTraversal(AdjacenyListGraph graph, int source) {
		
		boolean visited[] = new boolean[graph.getVertices()];
		visited[source]=true;
		dfsUtil(graph,source,visited);
		
		
		
	}
	
	private static void dfsUtil(AdjacenyListGraph graph,int src,boolean[] visited){
		System.out.print(src + " ");
		for(int i : graph.getEdges()[src]){
			if(visited[i]!=true){
				visited[i]=true;
				dfsUtil(graph, i, visited);
			}
		}
	}
	
	
	
}
