package com.ds.graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {

	public static void main(String args[]) {
		AdjListGraph graph = new AdjListGraph(GraphRepresentation.DIRECTED_GRAPH_TYPE,4);
		graph.init();
		graph.printGraph();
		dfsTraversal(graph, 2);

	}

	public static void dfsTraversal(AdjListGraph graph, int source) {

		List<Integer> visited=new ArrayList<>();
		dfsUtil(graph,visited,source);
		
	}
	private static void dfsUtil(AdjListGraph graph,List<Integer> visited, int source){
		
		visited.add(source);
		System.out.print(source + " ");
		
		for(int i : graph.getEdges()[source]){
			if(!visited.contains(i)){
				dfsUtil(graph,visited,i);
			}
		}
	}
	
	
}
